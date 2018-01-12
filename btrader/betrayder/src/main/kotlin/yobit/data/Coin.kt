package yobit

import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator

class Coin {

    var tag:String = "";
    var value = 0;

    @JsonCreator
    fun create(key: String, value: String) {
        tag = key
        this.value = value.toInt()
    }

    @JsonAnySetter
    fun setValues(key: String, value: String) {
        tag = key
        this.value = value.toInt()
    }
}