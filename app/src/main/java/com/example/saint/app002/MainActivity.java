package com.example.saint.app002;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView editText = (TextView)findViewById(R.id.editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event){
                if (editText.getText().toString().length() == 0)
                    edges = 0;
                else
                    edges = Integer.parseInt(editText.getText().toString());
                init();
                return false;
            }});
    }

    static int edges;
    private void init(){
        MyView myView = (MyView)findViewById(R.id.myView);
        myView.invalidate();
    }
}
