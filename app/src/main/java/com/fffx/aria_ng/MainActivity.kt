package com.fffx.aria_ng

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.webkit.CookieManager
import android.webkit.WebView

/*
 TODO
  1. allow user update ariaNg and auto update? https://developer.android.com/training/data-storage
  2. inject css/js to suit mobile?
*/

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CookieManager.getInstance().setAcceptCookie(true)
        if (BuildConfig.DEBUG) {
            WebView.setWebContentsDebuggingEnabled(true)
        }
        val webView = WebView(this)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.databaseEnabled = true
        webView.loadUrl("file:///android_asset/AriaNg.html")
        setContentView(webView)
    }
}