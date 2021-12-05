package com.example.appdreiplusvier

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity

class Storage {

    companion object {
        // shared prefs data
        val SHARED_PREFS = "shared_prefs"

        val HOME_IMAGE_INDEX = "home_image_id"
        val HOME_BACKGROUD_COLOR = "home_background_color"
        val HOME_INVITATION = "home_invitation"
        val HOME_OTHER_TEXT = "home_other_info_text"
        val RED_VAL = "RED_VAL"
        val GREEN_VAL = "GREEN_VAL"
        val BLUE_VAL = "BLUE_VAL"


        //fragment manager data
        val SELECT_NEW_IMAGE = "SEL_IMG"
        val SELECT_NEW_IMAGE_INDEX = "SEL_IMG_INDEX"
        val COLOR_ID = "COL_BACK_ID"
        val COLOR_STRING = "get_color_string"
        val INVITATION_TEXT_ID = "INV_TEXT_ID"
        val INVITATION_TEXT = "invitation_text"
        val OTHER_TEXT_ID = "OTHER_TEXT_ID"
        val OTHER_TEXT = "other_home_text"


        fun saveIntData(act: FragmentActivity, title: String, id: Int) {
            val sharedPrefs = act.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
            val editor = sharedPrefs.edit()
            editor.putInt(title, id)
            editor.apply()
        }

        fun saveStringData(act: FragmentActivity, key: String, data: String) {
            val sharedPrefs = act.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
            val editor = sharedPrefs.edit()
            editor.putString(key, data)
            editor.apply()
        }

        fun loadIntData(act: FragmentActivity, key: String, default: Int=0): Int {
            val sharedPrefs = act.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
            return sharedPrefs.getInt(key, default)
        }

        fun loadStringData(act: FragmentActivity, key: String, default: String=""): String {
            val sharedPrefs = act.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
            return sharedPrefs.getString(key, default) as String
        }


    }

}