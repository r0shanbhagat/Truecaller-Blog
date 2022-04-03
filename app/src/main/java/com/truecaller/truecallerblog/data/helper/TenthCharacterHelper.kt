package com.truecaller.truecallerblog.data.helper

import android.text.SpannableStringBuilder
import androidx.core.text.bold
import com.truecaller.truecallerblog.utils.isValidString

/**
 * @Details TenthCharacterHelper: Calculate the TenthCharacter and returns the String at 10th index
 * @Author Roshan Bhagat
 */
class TenthCharacterHelper : DataFormatter<String> {

    override fun getFormattedData(value: String?): String {
        val tenthChar = SpannableStringBuilder()
        if (isValidString(value) && value!!.length >= 10) {
            tenthChar.bold { append("10th character displayed on the screen is:") }
            tenthChar.append(value[9])
        }
        return tenthChar.toString()
    }
}