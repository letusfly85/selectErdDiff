package main.scala.entity

/**
 * Created with IntelliJ IDEA.
 * User: letusfly95
 * Date: 13/04/06
 * Time: 11:57
 * To change this template use File | Settings | File Templates.
 */
class MsTabColumns {

  var tableId :Int = _
  var physicalTableName :String = _
  var logicalTableName :String = _
  var tableComment :String = _
  var columnId :Int = _
  var physicalColumnName :String = _
  var logicalColumnName :String = _
  var columnComment :String = _

  var dataType: String = _
  var dataLength :Int = _
  var dataPrecision :Int = _
  var notNull :String = _
  var pkFlg :String = _
  var dataDefault :String = _
  var revision :Int = _


}
