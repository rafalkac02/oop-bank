import scala.collection.mutable.ArrayBuffer

class Bank(s: String) {
  val name = s
  var accounts = ArrayBuffer.empty[Account]
  def addAcount(a: Account) = accounts += a
}