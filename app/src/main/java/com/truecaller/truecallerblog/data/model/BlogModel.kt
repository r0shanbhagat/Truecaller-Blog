package com.truecaller.truecallerblog.data.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.truecaller.truecallerblog.BR

/**
 * @Details LoginModel
 * @Author Roshan Bhagat
 * @constructor Create Blog model
 */
class BlogModel : BaseObservable() {

    @get:Bindable
    var blogContent: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.blogContent)
        }
}