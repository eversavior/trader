package http

import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by KonstantinK on 11.01.2018.
 */
class URLLoader {

    var responseCode:Int = -1
    var responseMessage:String = ""

    constructor() {

    }

    fun load(request:URLRequest):String {
        responseCode = -1
        val url:URL = URL(request.url);
        val connection = url.openConnection() as HttpURLConnection
        prepareConnection(request, connection)
        return readAnswer(connection)
    }

    private fun readAnswer(connection: HttpURLConnection):String {
        responseCode = connection.responseCode
        responseMessage = connection.responseMessage

        val `in` = BufferedReader(InputStreamReader(connection.inputStream, "UTF-8"))

        return `in`.readText();
    }

    private fun prepareConnection(request: URLRequest, connection: HttpURLConnection) {
        val postData = request.variables?.toUrlBytes();
        var postDataLength = 0

        if(postData != null)
            postDataLength = postData.size

        connection.doOutput = true
        connection.instanceFollowRedirects = false
        connection.requestMethod = request.requestMethod;

        for(header in request.headers) {
            connection.setRequestProperty(header.key, header.value)
        }

        connection.setRequestProperty("User-Agent", request.userAgent)
        connection.setRequestProperty("Content-Length", Integer.toString(postDataLength))

        connection.useCaches = request.useCaches
        connection.connectTimeout = request.connectionTimeout;

        if(postData != null)
            DataOutputStream(connection.outputStream).use({ wr -> wr.write(postData) })
    }
}