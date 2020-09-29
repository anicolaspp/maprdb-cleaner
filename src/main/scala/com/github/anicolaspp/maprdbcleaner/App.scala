package com.github.anicolaspp.maprdbcleaner

import com.github.anicolaspp.maprdbcleaner.conf.Configuration
import com.github.anicolaspp.maprdbcleaner.db.Db
import com.github.anicolaspp.maprdbcleaner.query.QueryBuilder
import com.mapr.db.MapRDB
import org.joda.time.DateTime
import org.ojai.store.{Connection, DriverManager}
import org.ojai.types.OTimestamp

object App {

  implicit lazy val connection: Connection = DriverManager.getConnection("ojai:mapr:")

  //  def main(args: Array[String]): Unit =
  //    Configuration
  //      .parse(args)
  //      .map(QueryBuilder.buildFrom)
  //      .map(Db.run)
  //      .foreach {
  //        case Left(error) => println(error)
  //        case Right(msg)  => println(msg)
  //      }

  def main(args: Array[String]): Unit = {

    val store = connection.getStore("/tables/dates_test")


    val now = DateTime.now()

    val timeStamp = new OTimestamp(now.toDateTime.getMillis)

    store.insert(connection.newDocument().setId(timeStamp.toUTCString))
    store.flush()
  }
}