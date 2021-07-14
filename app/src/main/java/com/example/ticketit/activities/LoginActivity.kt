package com.example.ticketit.activities

import android.os.Bundle
import com.example.ticketit.BaseActivity
import com.example.ticketit.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginTvRegister.setOnClickListener { startActivity(RegisterActivity::class.java) }

    }


}
