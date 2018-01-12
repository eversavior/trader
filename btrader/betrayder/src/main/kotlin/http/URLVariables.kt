package http

import com.sun.org.apache.xpath.internal.operations.Bool
import java.io.DataOutputStream
import java.nio.charset.StandardCharsets
import java.util.*

class URLVariables {

    val data:HashMap<String, String> = HashMap();
    private val encoding = StandardCharsets.UTF_8;

    var asString = "";
    var asStringDirty = true;

    constructor() {

    }

    fun addVariable(key:String, value:String) {
        asStringDirty = true;
        data[key] = value;
    }

    fun getVariable(key:String): String? {
        return data[key];
    }

    fun writeToStream(stream: DataOutputStream) {
        stream.use({ wr -> wr.write(toUrlString().toByteArray(encoding)) })
    }

    fun toUrlBytes(): ByteArray {
        return toUrlString().toByteArray(encoding);
    }
    
    fun toUrlString():String {
        if(!asStringDirty)
            return asString;

        asString = ""

        val iterator = data.iterator();
        while(iterator.hasNext()) {
            val variable = iterator.next();
            asString += variable.key + '=' + variable.value
            if(iterator.hasNext())
                asString += '&'
        }

        asStringDirty = false;

        return asString
    }
}