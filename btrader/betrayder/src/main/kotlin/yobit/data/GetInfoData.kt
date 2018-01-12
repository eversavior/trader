package yobit.data

import com.fasterxml.jackson.annotation.JsonProperty

class GetInfoData : BaseYobitData() {

    @JsonProperty("return", required = false)
    val returnData: YobitReturnData? = null
}