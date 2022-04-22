import org.scalatest._
import flatspec._
import matchers._

class AccountSpec extends AnyFlatSpec with should.Matchers {

  it should "support cash deposit, withdraw and transfer" in {
    val JPM = new Bank("JPMorgan")

    val mom = new Account(JPM)
    mom.id shouldBe 0

    val dad = new Account(JPM)
    dad.id shouldBe 1

    // balance 10000 as default
    mom.balance shouldBe 10000
    dad.balance shouldBe 10000

    // deposits
    mom.deposit(1000)
    mom.balance shouldBe 11000

    // withdraw
    dad.withdraw(4000)
    dad.balance shouldBe 6000

    // transfer
    mom.transferTo(2000, dad)
    mom.balance shouldBe 9000
    dad.balance shouldBe 8000

    // statement
    mom.printStatement shouldBe "ACCOUNT STATEMENT\n" +
      "Bank: JPMorgan\n" +
      "Account id: 0\n" +
      "Account balance: 9000"

    // closing account (making a balance zero)
    mom.close
    mom.balance shouldBe 0

  }
}