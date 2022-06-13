package com.jonghyun.searchgit.extends

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText


fun EditText.hideKeyboard(
) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as
        InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}