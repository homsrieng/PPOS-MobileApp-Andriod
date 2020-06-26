package com.example.ppos_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ppos_app.R
import com.example.ppos_app.ui.fragment.BottomSheetLanguageFragment
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    fun loadSelectLanguage(v: View?) {
        val bottomSheetFragment =
            BottomSheetLanguageFragment()
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }
    fun navigateOTP(v:View) {
        val intent = Intent(this, OTPActivity::class.java)
        startActivity(intent)
        finish()
    }
}
