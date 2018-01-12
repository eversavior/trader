package yobit.data

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import yobit.Coin
import yobit.data.serialization.CoinDeserialzier

class YobitReturnData {

    var rights:YobitRightsData = YobitRightsData()

    @JsonDeserialize(contentAs = Coin::class)
    val funds: HashMap<String, Coin> = HashMap()
    var funds_incl_orders:HashMap<String, String> = HashMap()

    var transaction_count:Int = 0
    var open_orders:Int = 0
    var server_time:Long = 0
}