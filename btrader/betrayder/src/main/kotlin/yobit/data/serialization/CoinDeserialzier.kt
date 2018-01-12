package yobit.data.serialization

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.deser.KeyDeserializers
import yobit.Coin

class CoinDeserialzier : KeyDeserializer() {

    override fun deserializeKey(key: String?, ctxt: DeserializationContext?): Any {

        println(key)
        return Coin()
    }


}