/**
 * Created with IntelliJ IDEA.
 * User: letusfly95
 * Date: 13/04/06
 * Time: 12:12
 * To change this template use File | Settings | File Templates.
 */

package main.scala.databasemanager

import main.scala.apputils.LoadProperties
import java.util.Properties

import java.sql.{DriverManager, Connection}

class GenerateOracleConnection {

  val pu   :LoadProperties = new LoadProperties
  val prop :Properties = pu.loadProperties(".properties")

  val oracleHost = prop.getProperty("ORACLE_HOST")
  val oracleUser = prop.getProperty("ORACLE_USER")
  val oraclePass = prop.getProperty("ORACLE_PASS")

  val jdbcURL =   "jdbc:oracle:thin:@" + oracleHost

  def connect :Connection = {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver").newInstance()
      return DriverManager.getConnection(jdbcURL,oracleUser,oraclePass)
    } catch {
      case e:Exception =>
        e.printStackTrace()
        return null
    }
  }
}