package demo.util

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import java.util.*
import kotlin.collections.HashMap

abstract class UnknownFields(
    private val otherValues: MutableMap<String, Any?> = HashMap()
) {
    @JsonAnyGetter
    fun getOtherValues(): Map<String, Any?> =
        Collections.unmodifiableMap(otherValues)

    @JsonAnySetter
    fun setOtherValue(key: String, value: Any?) {
        otherValues[key] = value
    }
}
