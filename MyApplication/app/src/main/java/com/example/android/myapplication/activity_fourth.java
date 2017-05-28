package com.example.android.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_fourth extends AppCompatActivity {
int request_Code=1;
public static String newText;
    public static final String MSG1="Content";
    public static final String check="check";
    int id=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_fourth);
        Intent intent=getIntent();
        String content=intent.getStringExtra(activity_third.MSG1);
        TextView textView=(TextView)findViewById(R.id.Text1);
        textView.setText(content);
    }
    public void change(View view)

    {
        Intent i = new Intent(this, activity_fifth.class);
        TextView textView=(TextView)findViewById(R.id.Text);
        i.putExtra(check,id);
        if(textView.getText()!=null)
        {
            i.putExtra(MSG1,newText);
            id=2;
            i.removeExtra(check);
            i.putExtra(check,id);

        }

        startActivityForResult(i,request_Code);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (1) : {
                if (resultCode == Activity.RESULT_OK) {
                    newText = data.getStringExtra(activity_fifth.MSG);
                    // TODO Update your TextView.
                    TextView textView=(TextView)findViewById(R.id.Text);
                    textView.setText(newText);
                }
                break;
            }
        }
    }

    }