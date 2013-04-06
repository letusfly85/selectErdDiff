/**
 * Created with IntelliJ IDEA.
 * User: letusfly95
 * Date: 13/04/06
 * Time: 12:04
 * To change this template use File | Settings | File Templates.
 */

package main.scala.dummyData

import main.scala.entity.MsTabColumns
import main.scala.databasemanager.GenerateOracleConnection
import main.scala.apputils.LoadProperties
import java.util.Properties
import java.sql.SQLException

object GenerateSampleSets {

  val pu   :LoadProperties = new LoadProperties
  val prop :Properties = pu.loadProperties(".properties")

  def sample01 :List[MsTabColumns] = {
    var list: List[MsTabColumns] = List()

    val db = new GenerateOracleConnection
    val conn = db.connect

    val stmt = conn.prepareStatement(prop.getProperty("SELECT_9141").asInstanceOf[String])

    try {
      val res = stmt.executeQuery
      while(res.next) {
        val msTabColumns :MsTabColumns = new MsTabColumns
        msTabColumns.physicalColumnName = res.getString("PHYSICAL_COLUMN_NAME")
        msTabColumns.dataType           = res.getString("DATA_TYPE")
        msTabColumns.dataLength         = res.getInt("DATA_LENGTH")

        list ::= msTabColumns
      }
    } catch {
      case e:SQLException =>
        e.printStackTrace
    } finally {
      stmt.close
      conn.close
    }

    list
  }

  def sample02 :List[MsTabColumns] = {
    var list: List[MsTabColumns] = List()

    val db = new GenerateOracleConnection
    val conn = db.connect

    val stmt = conn.prepareStatement(prop.getProperty("SELECT_9138").asInstanceOf[String])

    try {
      val res = stmt.executeQuery
      while(res.next) {
        val msTabColumns :MsTabColumns = new MsTabColumns
        msTabColumns.physicalColumnName = res.getString("PHYSICAL_COLUMN_NAME")
        msTabColumns.dataType           = res.getString("DATA_TYPE")
        msTabColumns.dataLength         = res.getInt("DATA_LENGTH")

        list ::= msTabColumns
      }
    } catch {
      case e:SQLException =>
        e.printStackTrace
    } finally {
      stmt.close
      conn.close
    }

    list
  }

}