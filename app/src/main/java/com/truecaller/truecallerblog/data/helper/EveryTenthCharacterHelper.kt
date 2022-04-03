package com.truecaller.truecallerblog.data.helper

import com.truecaller.truecallerblog.utils.isValidString

/**
 * @Details TenthCharacterHelper: Calculate the every TenthCharacter and returns the List<String>
 * @Author Roshan Bhagat
 */
class EveryTenthCharacterHelper : DataFormatter<String> {

    override fun getFormattedData(value: String?): String {
        val every10thCharList = mutableListOf<String>()
        if (isValidString(value)) {
            var i = 9
            while (i < value!!.length) {
                val tenthChar = value[i].toString()
                if (isValidString(tenthChar)) {
                    every10thCharList.add(tenthChar)
                }
                i += 10
            }
        }
        return every10thCharList.toString()
    }
}