package com.github.anicolaspp.maprdbcleaner.query

import com.github.anicolaspp.maprdbcleaner.conf.Configuration
import org.ojai.store.{Connection, Query}

object QueryBuilder {

  def buildFrom(config: Configuration)(implicit connection: Connection): (Query, Configuration) =
    (if (config.allDocuments) allDocumentsQuery() else someDocumentsQuery(config.query), config)

  private def allDocumentsQuery()(implicit connection: Connection) = connection.newQuery().build()

  private def someDocumentsQuery(query: String)(implicit connection: Connection) = connection.newQuery(query).build()

}
