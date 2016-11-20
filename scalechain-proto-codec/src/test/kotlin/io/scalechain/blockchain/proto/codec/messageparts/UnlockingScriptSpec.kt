package io.scalechain.blockchain.proto.codec.messageparts

import io.scalechain.blockchain.proto.UnlockingScript
import io.scalechain.blockchain.proto.codec.{UnlockingScriptCodec, PayloadTestSuite}
import io.scalechain.util.HexUtil._

/**
 *  <Bitcoin Core Packets Not Captured>
 *
 *  49 ....................................... Bytes in sig. script: 73
 *  | 48 ..................................... Push 72 bytes as data
 *  | | 30450221008949f0cb400094ad2b5eb3
 *  | | 99d59d01c14d73d8fe6e96df1a7150de
 *  | | b388ab8935022079656090d7f6bac4c9
 *  | | a94e0aad311a4268e082a725f8aeae05
 *  | | 73fb12ff866a5f01 ..................... Secp256k1 signature
 */
class UnlockingScriptSpec : PayloadTestSuite<UnlockingScript>  {

  val codec = UnlockingScriptCodec.codec
  
  val payload = bytes(
    """
      49                                    
        48                                  
          30450221008949f0cb400094ad2b5eb3
          99d59d01c14d73d8fe6e96df1a7150de
          b388ab8935022079656090d7f6bac4c9
          a94e0aad311a4268e082a725f8aeae05
          73fb12ff866a5f01                  
    """)

  val message = UnlockingScript(bytes("4830450221008949f0cb400094ad2b5eb399d59d01c14d73d8fe6e96df1a7150deb388ab8935022079656090d7f6bac4c9a94e0aad311a4268e082a725f8aeae0573fb12ff866a5f01"))


}
