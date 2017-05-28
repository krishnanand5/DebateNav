package com.example.android.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_fifth extends AppCompatActivity {
    public static final String MSG = "com.example.yokeshb.MSG";
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_fifth);
        EditText editText=(EditText)findViewById(R.id.ed);
        Intent intent=getIntent();
        int i=intent.getIntExtra("check",1);
        if(i==2)
        {
            editText.setText(intent.getStringExtra(activity_fourth.MSG1));
        }




    }

    public void update(View view) {
        EditText edit = (EditText) findViewById(R.id.ed);
        Button upd = (Button) findViewById(R.id.update);
        text = edit.getText().toString();
        Intent resultintent = new Intent();
        resultintent.putExtra(MSG, text);
        setResult(Activity.RESULT_OK, resultintent);
        finish();

    }
}
