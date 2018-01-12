package http

import java.util.*

class URLRequest(var url: String) {

    val headers:HashMap<String, String> = HashMap()
    val variables: URLVariables = URLVariables()
    var connectionTimeout = 1000
    var useCaches = false
    var requestMethod = "POST"
    var userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36"

    fun addHeader(name:String, value:String) {
        headers[name] = value
    }
}