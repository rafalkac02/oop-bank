class Account(bank: Bank) {

  val id = bank.accounts.length
  bank.addAcount(this)

  // balance is 10k as default
  var balance = 10000

  def deposit(amount: Int) = {
    balance += amount
  }

  def withdraw(amount: Int) = balance match {
    case b if b < amount => println("Error. Insufficient amount.")
    case _ => balance -= amount
  }

  def printStatement = {
    val statement = {
      "ACCOUNT STATEMENT" + "\n" +
        "Bank: " + bank.name + "\n" +
        "Account id: " + id + "\n" +
        "Account balance: " + balance
    }
    println(statement)
    statement
  }

  def close: Unit = balance = 0

  def transferTo(amount: Int, receiver: Account) = balance match {
    case b if b < amount => println("Error. Insufficient amount.")
    case _ =>
      balance -= amount
      receiver.balance += amount
  }
}