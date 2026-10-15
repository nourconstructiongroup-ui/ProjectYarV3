package com.projectyar.app;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
public class MainActivity extends Activity {
 WebView view;
 @Override public void onCreate(Bundle state){super.onCreate(state); view=new WebView(this); view.setWebViewClient(new WebViewClient()); WebSettings s=view.getSettings();s.setJavaScriptEnabled(true);s.setDomStorageEnabled(true);setContentView(view);view.loadUrl("file:///android_asset/index.html");}
 @Override public void onBackPressed(){view.evaluateJavascript("(function(){if(document.getElementById('modal').classList.contains('open')){closeModal();return true;}if(page!=='home'){goto('home');return true;}return false;})()", result->{if(!"true".equals(result)){if(view.canGoBack())view.goBack();else MainActivity.super.onBackPressed();}});}
}
