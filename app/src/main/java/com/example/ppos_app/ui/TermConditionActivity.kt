package com.example.ppos_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ppos_app.R
import kotlinx.android.synthetic.main.activity_term_condition.*

class TermConditionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_term_condition)

        initUI();
    }
    fun initUI() {
        webViewTermCondition.loadUrl("https://policies.google.com/privacy?hl=en-US");
    }
    fun navigateHome(v: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
