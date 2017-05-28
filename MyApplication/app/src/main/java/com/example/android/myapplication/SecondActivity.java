package com.example.android.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

String heading;
public static final String MSG="Heading";
    public static final String MSG1="Side";
    public static String Side;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        heading=intent.getStringExtra(MainActivity.MSG);
        heading.toString();
        TextView textView=(TextView)findViewById(R.id.Text1);
        textView.setText(heading);
        Button prop=(Button)findViewById(R.id.prop);
        Button opp=(Button)findViewById(R.id.opp);

    }
    public void Prop(View view)
    {   Side="Proposition";
        Intent intent=new Intent(this,activity_third.class);
        intent.putExtra(MSG,heading);
        intent.putExtra(MSG1,Side);
        startActivity(intent);
    }
    public void Opp(View view)
    {   Side="Opposition";
        Intent intent=new Intent(this,activity_third.class);
        intent.putExtra(MSG,heading);
        intent.putExtra(MSG1,Side);
        startActivity(intent);
    }
}
