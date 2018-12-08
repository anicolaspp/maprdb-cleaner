package com.github.anicolaspp.maprdbcleaner

import com.github.anicolaspp.maprdbcleaner.conf.Configuration
import com.github.anicolaspp.maprdbcleaner.db.Db
import com.github.anicolaspp.maprdbcleaner.query.QueryBuilder
import org.ojai.store.{Connection, DriverManager}

object App {

  implicit lazy val connection: Connection = DriverManager.getConnection("ojai:mapr:")

  def main(args: Array[String]): Unit =
    Configuration
      .parse(args)
      .map(QueryBuilder.buildFrom)
      .map(Db.run)
      .foreach {
        case Left(error) => println(error)
        case Right(msg)  => println(msg)
      }
}