package yobit.data.serialization

import yobit.data.BaseYobitData
import yobit.data.GetInfoData
import com.fasterxml.jackson.databind.ObjectMapper

class YobitSerializer {

    val objectMapper = ObjectMapper()

    inline fun parse(rawData: String):BaseYobitData? {
        return objectMapper.readValue<BaseYobitData>(rawData, BaseYobitData::class.java)
    }

    fun parseGetInfoData(rawData:String):GetInfoData? {
        return objectMapper.readValue<GetInfoData>(rawData, GetInfoData::class.java)
    }
}