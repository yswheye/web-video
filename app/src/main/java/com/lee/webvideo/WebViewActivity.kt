package com.lee.webvideo

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_web_video.*

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_video)
        web_view.settings.javaScriptEnabled = true
        web_view.webChromeClient = WebChromeClient()
        web_view.webViewClient = CustomWebViewClient()
        web_view.loadUrl("https://www.bilibili.com/video/BV1u34y1B7wE?spm_id_from=333.851.b_7265636f6d6d656e64.1")
    }

    override fun onDestroy() {
        super.onDestroy()
        web_view.destroy()
    }

    private class CustomWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            val url = request?.url?.toString()
            if (url != null && (!url.startsWith("http") || !url.startsWith("https"))) {
                return true
            }
            return super.shouldOverrideUrlLoading(view, request)
        }
    }
}