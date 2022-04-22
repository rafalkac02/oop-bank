object Main {

  val GoldmanSachs = new Bank("Goldman Sachs")

  val acc0 = new Account(GoldmanSachs)
  val acc1 = new Account(GoldmanSachs)
  acc0.deposit(1200)
  acc0.withdraw(5000)
  acc0.transferTo(50, acc1)

  GoldmanSachs.accounts.foreach(a => a.printStatement)
  println(GoldmanSachs.accounts.map(f => f.id))

}
