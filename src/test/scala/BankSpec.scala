import org.scalatest._
import flatspec._
import matchers._

class BankSpec extends AnyFlatSpec with should.Matchers {

  it should "store seq of accounts" in {
    val goldman = new Bank("Goldman Sachs")

    goldman.name shouldBe "Goldman Sachs"

    // no accounts at the start
    goldman.accounts.length shouldBe 0

    // create accounts in Goldman Sachs
    val acc0 = new Account(goldman)
    val acc1 = new Account(goldman)

    // two accounts in the bank after adding
    goldman.accounts.length shouldBe 2

    // bank goldman stores accounts with ascending ids (starting from 0) and cash balance (default 10000)
    goldman.accounts.map(a => (a.id, a.balance)) shouldBe Seq((0, 10000), (1, 10000))
  }
}