package com.truecaller.truecallerblog.data.helper

import com.truecaller.truecallerblog.di.DistinctWordCount
import com.truecaller.truecallerblog.di.EveryTenthCharacter
import com.truecaller.truecallerblog.di.TenthCharacter
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * @Details :OperationHelperFactory :Ensure and return the specific helper class formatted data
 * @Author Roshan Bhagat
 */
@ViewModelScoped
class DataHelperFactory @Inject constructor(
    @TenthCharacter private val tenthChar: DataFormatter<String>,
    @EveryTenthCharacter private val everyTenthChar: DataFormatter<String>,
    @DistinctWordCount private val distinctWordCount: DataFormatter<String>

) :
    DataHelper<String> {

    override fun getTenthCharacter(value: String?): String {
        return tenthChar.getFormattedData(value)
    }

    override fun getEveryTenthCharacter(value: String?): String {
        return everyTenthChar.getFormattedData(value)
    }

    override fun getDistinctWordCount(value: String?): String {
        return distinctWordCount.getFormattedData(value)
    }


}