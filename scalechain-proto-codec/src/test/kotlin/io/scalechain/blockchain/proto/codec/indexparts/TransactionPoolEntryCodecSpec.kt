package io.scalechain.blockchain.proto.codec.indexparts

import io.scalechain.blockchain.proto.{TransactionPoolEntry, InPoint, Hash, OrphanTransactionDescriptor}
import io.scalechain.blockchain.proto.codec.messages.TransactionSpec
import io.scalechain.blockchain.proto.codec.{OrphanTransactionDescriptorCodec, TransactionPoolEntryCodec, PayloadTestSuite}
import io.scalechain.util.HexUtil._

class TransactionPoolEntryCodecSpec : PayloadTestSuite<TransactionPoolEntry>  {

  val codec = TransactionPoolEntryCodec.codec

  val DUMMY_HASH1 = Hash ( "1" * 64 )

  val payload = bytes(
    """010000000553252190608c627bdfc66018977cd27f7e0cb9c86dd5a64c5b3f23f362878242010000006b483045022100e55e797b51711148692b9cc4a2c80652c69bd78d4103438dec41e01670c046f802207ef80574570cfde8f6a788a6b2900343d01115645b6a037773c43df507493294012102772555483a3445bab2cdd3886a1cc9b362f4e9991db50d0944689aed90b67b19ffffffffb3cdca7641771b13fa5d567b819d9804f32ffb4582f5200e377c60e6825f05b4010000006b483045022100844f55bdc9bfa12f468560ee293219433ad96060538a6ee6df7d0922d7e4b80602204da8d73e024e353fb5598dda67a6afe8425677b7ee483cbb2147ced5bfc5a629012103df96db891b824f53f5ac423368b627319071b95409491989e641eee2d7326864fffffffffe72e456c2ad03e3c6c2371cc5178c44279c51342bafdf27e156a9ce4c3a37db010000006b48304502210082ca0851f3a94d4e0d0067a47f6bd132b47b798a83e40e7a408011d4021d7ec5022034b75358575754bfe58229610d12749c60e7295d9472790014067d36eab88dd1012103df96db891b824f53f5ac423368b627319071b95409491989e641eee2d7326864ffffffff356fceedfed386d0d6e6777d53c7be9e88380b89a57be1632a9598291db42b6c0000000069463043022070d2b610ac64d9643a87d33d785996596612e343fe62f7a6a94f7ab732ffbb8a021f1b1bee854faa6595be856c64a8cf5086821d3867a1da5e12bc27ab5905ab9501210251571c711c89343b477ea209601542b9827dad55e1249ca35bb8cc0f65efad1cfffffffff4d029cf2c83ae07019439d8ce9605cb2ce6c67967a76f9118b7336ee8fc5cae020000006a473044022100fec80cc70b82274c0b292c79a1c0cb672d83b0bcc79ea61a55e7b50ae6c32f6b021f4dc2534e647bbcec0d2741e44421a080ad192edccccabc742da715980dbe940121023547f5787c54caf67be8359a482553ee83a8e77eb13526475ad17475077d888cffffffff0262e7b103000000001976a914f92a54b60ae8b9eaf4234aea1b51d0c0659d6aed88ac71920000000000001976a91408240470d3e7e1a3dd26e7655e3fb90373bfa5bb88ac000000000300ff111111111111111111111111111111111111111111111111111111111111111101000000000000000000000001
    """)

  val message = TransactionPoolEntry(
    transaction = TransactionSpec.SampleTransaction,
    outputsSpentBy = List( None, Some(InPoint(DUMMY_HASH1, 1)), None ),
    createdAtNanos = 1
  )
}
