import main.scala.dummyData.GenerateSampleSets
import main.scala.entity.{MsTabColumns}

/**
 * Created with IntelliJ IDEA.
 * User: letusfly95
 * Date: 13/04/05
 * Time: 23:59
 * To change this template use File | Settings | File Templates.
 */

object SelectErdDiff {

  /**
   *
   * attributeの一致,不一致を判別する
   * 不一致分の削除、追加を検知する
   *
   * @param args
   */
  def main(args: Array[String]) {

    // revision 9141 のレコードセットを取得
    val sample01 = GenerateSampleSets.sample01

    // revision 9138 のレコードセットを取得
    val sample02 = GenerateSampleSets.sample02

    // revision 9138 から 9141 への変更で追加になったカラムを表示する
    getAddList(sample02, sample01).foreach{a :MsTabColumns =>
      println(a.physicalColumnName)
    }

  }

  /**
   *
   *
   */
  def getChangedList(fromRevision: List[MsTabColumns], toRevision :List[MsTabColumns]): List[MsTabColumns] = {

    var changes: List[MsTabColumns] = List()
    fromRevision.foreach{a: MsTabColumns =>

      toRevision.foreach{b: MsTabColumns =>
        if (isKeyEq(a,b) && !isValueEq(a,b)) {changes ::= a}
      }
    }

    changes
  }

  /**
   * 追加対象を取得する
   *
   * @param fromRevision
   * @param toRevision
   * @return
   */
  def getAddList(fromRevision: List[MsTabColumns], toRevision :List[MsTabColumns]): List[MsTabColumns] = {

    var addList: List[MsTabColumns] = List()
    var switch: Boolean = false
    toRevision.foreach{b: MsTabColumns =>

      fromRevision.foreach{a: MsTabColumns =>
        if (isKeyEq(b, a)){switch = true}
      }
      if (!switch){
        addList ::= b
      } else {
        switch = false
      }
    }

    addList
  }

  /**
   * 削除対象を取得する
   *
   * @param fromRevision
   * @param toRevision
   * @return
   */
  def getDeleteList(fromRevision: List[MsTabColumns], toRevision :List[MsTabColumns]): List[MsTabColumns] = {

    var delList: List[MsTabColumns] = List()
    var switch: Boolean = false
    fromRevision.foreach{a: MsTabColumns =>

      toRevision.foreach{b: MsTabColumns =>
        if (isKeyEq(a,b)){switch = true}
      }
      if (!switch){
        delList ::= a
      } else {
        switch = false
      }
    }

    delList
  }

  /**
   * キー合致確認
   *
   * @param fromRevision
   * @param toRevision
   * @return
   */
  def isKeyEq(fromRevision: MsTabColumns, toRevision: MsTabColumns) :Boolean = {
    if (fromRevision.physicalColumnName == toRevision.physicalColumnName) {
      return true
    } else {
      return false
    }
  }

  /**
   * バリュー合致確認
   *
   * @param fromRevision
   * @param toRevision
   * @return
   */
  def isValueEq(fromRevision: MsTabColumns, toRevision :MsTabColumns): Boolean = {
    if (fromRevision.dataType == toRevision.dataType) {
      return true
    } else {
      return false
    }
  }

}