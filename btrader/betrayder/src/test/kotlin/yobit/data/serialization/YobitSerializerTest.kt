package yobit.data.serialization

import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import org.junit.Test as test

class YobitSerializerTest {

    @test fun testParseBaseYobitData() {
        val rawData = "{\"success\":0,\"error\":\"invalid nonce (has already been used)\"}"
        val data = YobitSerializer().parse(rawData);

        assertNotNull(data, "cannot parse yobitData")
        assertEquals(data?.success, 0)
        assertEquals(data?.error, "invalid nonce (has already been used)")
    }

    @test fun testParseBaseGetInfoData() {
        val rawData = "{\"success\":1,\"return\":{\"rights\":{\"info\":1,\"trade\":1,\"deposit\":1,\"withdraw\":0},\"funds\":{\"btc\":0,\"doge\":0,\"vk\":0,\"eth\":0,\"nyc\":0,\"ecash\":0,\"trx\":3445.53745932,\"b2x\":0,\"token\":0,\"yay\":0,\"gram\":0,\"b3\":0,\"pac\":36556.40299667,\"usd\":0.00000001,\"rur\":0.00000007},\"funds_incl_orders\":{\"btc\":0,\"doge\":0,\"vk\":0,\"eth\":0,\"nyc\":0,\"ecash\":146.33151951,\"trx\":7680.53745932,\"b2x\":0,\"token\":0,\"yay\":0,\"gram\":0,\"b3\":0,\"pac\":36556.40299667,\"usd\":0.00000001,\"rur\":4799.72697252},\"transaction_count\":0,\"open_orders\":0,\"server_time\":1515691282}}"
        val data = YobitSerializer().parseGetInfoData(rawData);

        assertNotNull(data, "cannot parse yobitData")
        assertEquals(data?.success, 1)
        assertEquals(data?.error, null)
        assertNotNull(data?.returnData, null)
    }

    @test fun testParseBaseGetInfoDataError() {
        val rawData = "{\"success\":0,\"error\":\"invalid nonce (has already been used)\"}"
        val data = YobitSerializer().parseGetInfoData(rawData);

        assertNotNull(data, "cannot parse yobitData")
        assertEquals(data?.success, 0)
        assertEquals(data?.error, "invalid nonce (has already been used)")
    }
}