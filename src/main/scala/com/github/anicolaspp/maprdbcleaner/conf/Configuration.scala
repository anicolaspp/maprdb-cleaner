package com.github.anicolaspp.maprdbcleaner.conf

case class Configuration(tableName: String, allDocuments: Boolean, query: String, id: String)

object Configuration {
  
  def parse(args: Seq[String]): Option[Configuration] = parser.parse(args, default)

  private def default = Configuration("", allDocuments = false, query = "", id  = "_id")

  private lazy val parser = new scopt.OptionParser[Configuration]("run.sh") {
    head("maprdb-cleaner")

    opt[String]('t', "tableName")
      .action((table, conf) => conf.copy(tableName = table))
      .required()
      .maxOccurs(1)
      .text("MapR-DB table name to be used")
      .validate {
        case "" =>  Left("This value cannot be empty")
        case _  =>  Right()
      }

    opt[Boolean]('a', "all")
      .action((all, conf) => conf.copy(allDocuments = all))
      .required()
      .maxOccurs(1)
      .text("Indicates if all documents should be deleted. If false, only those on the query argument will be deleted.")

    opt[String]('q', "query")
      .action((query, conf) => conf.copy(query = query))
      .maxOccurs(1)
      .text("OJAI query to be deleted from MapR-DB. This query will ONLY be executed if --all is false.")

    opt[String]('i', "id")
      .action((id, conf) => conf.copy(id = id))
      .maxOccurs(1)
      .text("Name of the field used as the id on the table. If not provided, _id will be used.")

      checkConfig { config =>
        if (!config.allDocuments && config.query.isEmpty)
          Left("When indicating --all false, a query (-q OR --query) must be provided.")
        else
          Right()
      }
  }
}
