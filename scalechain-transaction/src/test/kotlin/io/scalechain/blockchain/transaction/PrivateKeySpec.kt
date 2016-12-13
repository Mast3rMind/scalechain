package io.scalechain.blockchain.transaction

import io.kotlintest.KTestJUnitRunner
import io.kotlintest.matchers.Matchers
import io.kotlintest.specs.FlatSpec
import org.junit.runner.RunWith

@RunWith(KTestJUnitRunner::class)
class PrivateKeySpec : FlatSpec(), Matchers, ChainTestTrait {

  init {
    "PrivateKey.from" should "create a private key from wallet import format generated by base58 method" {
      // PrivateKey.generate and base58 method are tested here.
      for ( i in 1 .. 100) { // test many times to make sure different kinds of randomly generated private keys work well.
      val originalPrivateKey = PrivateKey.generate()
      val expectedPrivateKey = originalPrivateKey.base58()
      val decodedPrivateKey = PrivateKey.from(expectedPrivateKey)
      val actualPrivateKey = decodedPrivateKey.base58()

      originalPrivateKey shouldBe decodedPrivateKey
      actualPrivateKey shouldBe expectedPrivateKey
    }
    }
  }
}