package com.truecaller.truecallerblog.data.helper

import com.truecaller.truecallerblog.utils.CaseInsensitiveMap
import com.truecaller.truecallerblog.utils.isValidString

/**
 * @Details DistinctWordCountHelper: Calculate the Distinct WordCount and returns the String
 * @Author Roshan Bhagat
 * @constructor Create Distinct word count helper
 */
class DistinctWordCountHelper : DataFormatter<String> {

    override fun getFormattedData(value: String?): String {
        val wordCountMapping = CaseInsensitiveMap<String, Int>()
        value?.let {
            val splits: List<String> = it.split("[\\s\\t,]".toRegex())
            for (word in splits) {
                if (isValidString(word)) {
                    wordCountMapping[word] = wordCountMapping[word]?.plus(1) ?: 1
                }
            }
        }
        return wordCountMapping.toString()
    }
}