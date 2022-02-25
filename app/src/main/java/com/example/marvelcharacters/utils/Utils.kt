package com.example.marvelcharacters.utils

import android.graphics.Color
import android.graphics.Typeface
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan

class Utils {
    companion object {
        fun editorial(publisher : String):String{
            return when (publisher) {
                "Marvel Comics" -> Constants.MARVEL_LOGO
                "DC Comics" -> Constants.DC_LOGO
                else -> { // Note the block
                    Constants.ANY_LOGO
                }
            }
        }

        fun textSpan(title: String, value: String, requiredSize : Boolean = false): SpannableStringBuilder {
            val s1 = SpannableString(title)
            val flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE

            if(requiredSize) {
                s1.setSpan(ForegroundColorSpan(Color.BLUE), 0, s1.length, flag)
                s1.setSpan(RelativeSizeSpan(1.3f), 0, s1.length, flag)
            }
            s1.setSpan(StyleSpan(Typeface.BOLD), 0, s1.length, flag)
            val builder = SpannableStringBuilder()
            builder.append(s1)
            builder.append(SpannableString(value))
            return builder
        }

    }
}