package maskice.hr;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import maskice.hr.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutApp extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.masterweblayout, container, false);


        final WebView webStranica;

        webStranica = (WebView) rootView.findViewById(R.id.stranica);


        WebSettings javascriptUkljucen = webStranica.getSettings();

        javascriptUkljucen.setJavaScriptEnabled(true);




        webStranica.loadUrl("file:///android_asset/about.html");



        return rootView;

    }


}
