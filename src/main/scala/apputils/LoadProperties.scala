/**
 * Created with IntelliJ IDEA.
 * User: letusfly95
 * Date: 13/04/05
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */

package main.scala.apputils

import java.util.Properties
import java.io.{File, FileInputStream}

import Tapper._

class LoadProperties {

  def loadProperties :List[Properties] = {

    new Properties.tap(_.load(new FileInputStream(new File(path).getAbsolutePath)))

  }
}