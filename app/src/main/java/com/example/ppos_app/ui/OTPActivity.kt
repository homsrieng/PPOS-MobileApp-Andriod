package com.example.ppos_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ppos_app.R
import com.example.ppos_app.ui.fragment.BottomSheetLanguageFragment
import kotlinx.android.synthetic.main.activity_login.*

class OTPActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
    }
    fun navigateTermCondition(v:View) {
        val intent = Intent(this, TermConditionActivity::class.java)
        startActivity(intent)
        finish()
    }
}
