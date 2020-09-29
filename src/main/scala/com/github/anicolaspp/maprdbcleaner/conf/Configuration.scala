package com.github.anicolaspp.maprdbcleaner.conf

case class Configuration(tableName: String, allDocuments: Boolean, query: String, id: String, isSQL: Boolean = false)

object Configuration {

  def parse(args: Seq[String]): Option[Configuration] = parser.parse(args, default)

  private def default = Configuration("", allDocuments = false, query = "", id = "_id")

  private lazy val parser = new scopt.OptionParser[Configuration]("maprdbcls") {
    head("maprdbcls")

    opt[String]('t', "tableName")
      .action((table, conf) => conf.copy(tableName = table))
      .required()
      .maxOccurs(1)
      .text("MapR-DB table name to be used")
      .validate {
        case "" => Left("This value cannot be empty")
        case _ => Right()
      }

    opt[Unit]("all")
      .action((_, conf) => conf.copy(allDocuments = true))
      .maxOccurs(1)
      .text("Indicates if all documents should be deleted. If missing, only those on the --query argument will be deleted.")

    opt[String]('q', "query")
      .action((query, conf) => conf.copy(query = query))
      .maxOccurs(1)
      .text("OJAI query to be deleted from MapR-DB. This query will ONLY be executed if --all is missing.")

    opt[String]('i', "id")
      .action((id, conf) => conf.copy(id = id))
      .maxOccurs(1)
      .text("Name of the field used as the id on the table. If not provided, _id will be used.")

    opt[String]('s', "sql")
        .action((query, conf) => conf.copy(query))

    checkConfig { config =>
      if (!config.allDocuments && config.query.isEmpty)
        Left("When omitting --all, a query (-q OR --query) must be provided.")
      else
        Right()
    }
  }
}
