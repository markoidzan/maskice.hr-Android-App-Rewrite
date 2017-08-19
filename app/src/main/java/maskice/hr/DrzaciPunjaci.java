package maskice.hr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by marko on 18.8.2017..
 */

public class DrzaciPunjaci extends Fragment {


    private ProgressBar progressBar;



    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.masterweblayout, container, false);

        final WebView webStranica;

        webStranica = (WebView) rootView.findViewById(R.id.stranica);

        progressBar = (ProgressBar) rootView.findViewById(R.id.progressbar);

        WebSettings javascriptUkljucen = webStranica.getSettings();

        javascriptUkljucen.setJavaScriptEnabled(true);

        webStranica.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                webStranica.loadUrl("javascript:(function(){" +
                        "document.getElementsByClassName('header-main show-logo-center nav-dark')[0].style.display='none';" +
                        "})()");
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                /*if (Uri.parse(url).getHost().contains("maskice.hr")) {
                    return false;
                }*/
                if ((url.startsWith("http:") || url.startsWith("https:")) && Uri.parse(url).getHost().contains("maskice.hr")) {
                    return false;
                }
                else if (url.startsWith("tel:")) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
                    startActivity(intent);
                    view.reload();
                    return true;
                }
                else if (url.startsWith("mailto:")) {
                    Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    view.getContext().startActivity(intent1);
                }
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                view.getContext().startActivity(intent2);
                return true;
            }


        });

        /*Button button = null;
        button = (Button)button.findViewById(R.id.refr_button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                webStranica.reload();
            }
        });*/
        webStranica.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        webStranica.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100 && progressBar.getVisibility() == ProgressBar.GONE)
                    progressBar.setVisibility(ProgressBar.VISIBLE);
                progressBar.setProgress(progress);
                if (progress == 100)
                    progressBar.setVisibility(ProgressBar.GONE);

            }

        });

        webStranica.loadUrl("https://maskice.hr/kategorija-proizvoda/adapteri-drzaci-punjaci/");


        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webStranica.reload();
            }
        });*/

        webStranica.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    WebView webView = (WebView) v;

                    switch (keyCode) {
                        case KeyEvent.KEYCODE_BACK:
                            if (webView.canGoBack()) {
                                webView.goBack();
                                return true;
                            }
                    }
                }
                return false;
            }
        });




        return rootView;

    }



}