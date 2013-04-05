/**
 * Created with IntelliJ IDEA.
 * User: letusfly95
 * Date: 13/04/05
 * Time: 23:30
 * To change this template use File | Settings | File Templates.
 */

package main.scala.apputils

object Tapper {
  implicit def anyToTapper[A](obj: A) = new Tapper(obj)
}

class Tapper[A](obj: A) {
  def tap(code: A => Unit): A = {
    code(obj)
    obj
  }
}