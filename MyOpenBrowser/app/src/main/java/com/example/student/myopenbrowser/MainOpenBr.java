package com.example.student.myopenbrowser;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainOpenBr extends AppCompatActivity {
    private Button goSearch;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_open_br);
        goSearch = (Button) findViewById(R.id.button1);
        editText = (EditText) findViewById(R.id.editText);
        goSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = editText.getText().toString();
                if (!search.endsWith(".com") || !search.endsWith(".ru") || !search.endsWith(".am")) {
                    final Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, search);
                    startActivity(intent);
                } else {
                    WebView webView = new WebView(MainOpenBr.this);
                    setContentView(webView);
                    webView.loadUrl(String.valueOf(editText.getText()));
                }


            }
        });
    }
}
