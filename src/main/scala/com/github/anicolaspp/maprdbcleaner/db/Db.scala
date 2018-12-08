package com.github.anicolaspp.maprdbcleaner.db

import com.github.anicolaspp.maprdbcleaner.conf.Configuration
import org.ojai.store.{Connection, DocumentStore, Query}

import scala.util.{Failure, Success, Try}

object Db {

  def run(a: (Query, Configuration))(implicit connection: Connection): Either[DBError, DBMessage] = run(a._1, a._2)

  def run(query: Query, config: Configuration)(implicit connection: Connection): Either[DBError, DBMessage] =
    Try {
      tryRun(query, config)
    } match {
      case Success(value)     => Right(CompletionMessage(value))
      case Failure(exception) => Left(Error(exception))
    }

  private def tryRun(query: Query, config: Configuration)(implicit connection: Connection) = {
    val documentStore: DocumentStore = connection.getStore(config.tableName)

    val documents = documentStore.find(query)

    documentStore.delete(documents, config.id)

    documentStore.close()

    query
  }
}


sealed trait DBError

case class Error(e: Throwable) extends DBError

sealed trait DBMessage

case class CompletionMessage(query: Query) extends DBMessage {
  override def toString: String = s"Done deleting documents for query: $query"
}