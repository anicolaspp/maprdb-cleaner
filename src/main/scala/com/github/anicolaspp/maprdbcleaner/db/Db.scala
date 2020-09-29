package com.github.anicolaspp.maprdbcleaner.db

import java.util.stream.StreamSupport

import com.github.anicolaspp.maprdbcleaner.conf.Configuration
import org.ojai.store.{Connection, DocumentStore, Query}

import scala.util.{Failure, Success, Try}

object Db {

  def run(a: (Query, Configuration))(implicit connection: Connection): Either[DBError, DBMessage] = run(a._1, a._2)

  def run(query: Query, config: Configuration)(implicit connection: Connection): Either[DBError, DBMessage] =
    tryRun(query, config) match {
      case Success(value)     => Right(CompletionMessage(value))
      case Failure(exception) => Left(Error(exception))
    }

  private def tryRun(query: Query, config: Configuration)(implicit connection: Connection) = Try {
    val documentStore: DocumentStore = connection.getStore(config.tableName)

    val documents = documentStore.find(query)

    println(s"Notice that the deletion process might take a while based on the size of the table ${config.tableName}.")

    import scala.collection.JavaConverters._

    documents.asScala.par.foreach(document => documentStore.delete(document, config.id))

    documentStore.close()

    query
  }
}


sealed trait DBError

case class Error(e: Throwable) extends DBError

sealed trait DBMessage

case class CompletionMessage(query: Query) extends DBMessage {
  override def toString: String = s"Done deleting documents for query: $query."
}