package sg.edu.rp.c346.practicalquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spnWeb;
    WebView wvWeb;
    ArrayList<String> alWebsite;
    ArrayAdapter<String> aaWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnWeb = findViewById(R.id.spinnerWebsite);
        wvWeb = findViewById(R.id.webViewWeb);


        alWebsite = new ArrayList<>();
        aaWebsite = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, alWebsite);

        String[] websites = getResources().getStringArray(R.array.website);
        alWebsite.addAll(Arrays.asList(websites));
        spnWeb.setAdapter(aaWebsite);

        wvWeb.setWebViewClient(new WebViewClient());

        spnWeb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String rp = "https://www.rp.edu.sg";
                String google = "https://www.google.com";
                switch (i) {
                    case 0:
                        // code
                        wvWeb.loadUrl(rp);
                        break;

                    case 1:
                        // code
                        wvWeb.loadUrl(google);
                        wvWeb.getSettings().setJavaScriptEnabled(true);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}
