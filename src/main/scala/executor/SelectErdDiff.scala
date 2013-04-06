import main.scala.entity.MyAttr

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
  def main(args :Array[String]) {

    val a0 :MyAttr = new MyAttr("userId","number")
    val a1 :MyAttr = new MyAttr("address", "string")
    val a2 :MyAttr = new MyAttr("company", "white")

    val b0 :MyAttr = new MyAttr("userId", "number")
    val b1 :MyAttr = new MyAttr("e-mail", "string")
    val b2 :MyAttr = new MyAttr("company", "white")
    val b3 :MyAttr = new MyAttr("position", "associate")

    val circleA :List[MyAttr] = List(a0, a1, a2)
    val circleB :List[MyAttr] = List(b0, b1, b2, b3)


    println("削除対象を表示")
    val delList = getDeleteList(circleA,circleB)
    delList.foreach{d: MyAttr =>
      println("[name]" + d.name + ", [attr]" + d.attr)
    }

    println("追加対象を表示")
    val addList = getAddList(circleA, circleB)
    addList.foreach{a: MyAttr =>
      println("[name]" + a.name + ", [attr]" + a.attr)
    }

  }

  /**
   * 追加対象を取得する
   *
   * @param circleA
   * @param circleB
   * @return
   */
  def getAddList(circleA: List[MyAttr], circleB: List[MyAttr]): List[MyAttr] = {

    var addList: List[MyAttr] = List()
    var switch: Boolean = false
    circleB.foreach{b: MyAttr =>

      circleA.foreach{a: MyAttr =>
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
   * @param circleA
   * @param circleB
   * @return
   */
  def getDeleteList(circleA: List[MyAttr], circleB :List[MyAttr]): List[MyAttr] = {

    var delList: List[MyAttr] = List()
    var switch: Boolean = false
    circleA.foreach{a: MyAttr =>

      circleB.foreach{b: MyAttr =>
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
   * @param a
   * @param b
   * @return
   */
  def isKeyEq(a: MyAttr, b: MyAttr) :Boolean = {
    a.name match {
      case b.name => true
      case _ => false
    }
  }

  /**
   * バリュー合致確認
   *
   * @param a
   * @param b
   * @return
   */
  def isValueEq(a: MyAttr, b: MyAttr): Boolean = {
    a.name match {
      case b.name => true
      case _ => false
    }
  }

}