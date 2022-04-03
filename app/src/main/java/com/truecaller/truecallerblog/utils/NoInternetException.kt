package com.truecaller.truecallerblog.utils

import java.io.IOException

/**
 * @Details NoInternetException
 * @Author Roshan Bhagat
 * @constructor
 *
 * @param msg
 * @param cause
 */
class NoInternetException(msg: String?, cause: Throwable?) : IOException(msg, cause)