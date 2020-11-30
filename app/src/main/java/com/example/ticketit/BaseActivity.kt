package com.example.ticketit

import android.R
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

/**
 * Created by cgheorg1 on 04-Jun-20.
 */
abstract class BaseActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    @Deprecated(
        "no need for context",
        ReplaceWith("startActivity(calledActivity, extras, action, flags)")
    )
    open fun startActivity(
        context: Context?,
        calledActivity: Class<*>,
        extras: Bundle? = null,
        action: String? = null,
        flags: Int = 0
    ) {
        context?.let {
            val intent = Intent(it, calledActivity)
            intent.flags = flags
            intent.action = action
            if (extras != null) {
                intent.putExtras(extras)
            }
            if (it is Activity) {
                it.startActivity(intent)
                it.overridePendingTransition(
                    R.anim.fade_in,
                    R.anim.fade_out
                )
            }
        }
    }

    open fun startActivity(
        calledActivity: Class<*>,
        extras: Bundle? = null,
        action: String? = null,
        flags: Int = 0
    ) {
        baseContext()?.let {
            val intent = Intent(it, calledActivity)
            intent.flags = flags
            intent.action = action
            if (extras != null) {
                intent.putExtras(extras)
            }
            if (it is Activity) {
                it.startActivity(intent)
                it.overridePendingTransition(
                    R.anim.fade_in,
                    R.anim.fade_out
                )
            }
        }
    }

    open fun startActivityForResult(
        context: Context?,
        calledActivity: Class<*>,
        requestCode: Int,
        extras: Bundle? = null,
        action: String? = null,
        flags: Int = 0
    ) {
        context?.let {
            val intent = Intent(it, calledActivity)
            intent.flags = flags
            intent.action = action
            if (extras != null) {
                intent.putExtras(extras)
            }
            if (it is Activity) {
                it.startActivityForResult(intent, requestCode)
                it.overridePendingTransition(
                    R.anim.fade_in,
                    R.anim.fade_out
                )
            }
        }
    }

    fun goBackToActivity(calledActivity: Class<*>, extras: Bundle? = null) {
        startActivity(calledActivity, extras = extras, flags = FLAG_ACTIVITY_CLEAR_TOP)
    }

    fun baseContext(): Context? {
        return this
    }

    fun turnScreenOn() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            this.setTurnScreenOn(true)
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)
        }
    }
}