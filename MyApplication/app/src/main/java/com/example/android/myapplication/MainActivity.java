package com.example.android.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private float x1,x2;
    static final int MIN_DISTANCE = 150;
    public static final String MSG="com.example.android.MSG";

    List<Planet> planetsList = new ArrayList<Planet>();
    PlanetAdapter aAdpt;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();

        // We get the ListView component from the layout
     ListView lv = (ListView) findViewById(R.id.listView);

        lv.setDivider(this.getResources().getDrawable(R.drawable.transperent_color));
        lv.setDividerHeight(20);

        // This is a simple adapter that accepts as parameter
        // Context
        // Data list
        // The row layout that is used during the row creation
        // The keys used to retrieve the data
        // The View id used to show the data. The key number and the view id must match
        //aAdpt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, planetsList);
        aAdpt = new PlanetAdapter(planetsList, this);
        lv.setAdapter(aAdpt);

        // React to user clicks on item
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {


                // We know the View is a <extView so we can cast it
                TextView clickedView = (TextView) view.findViewById(R.id.name);
                ListView lv1=(ListView)findViewById(R.id.listView);

                String msg=((TextView)findViewById(R.id.name)).getText().toString();


                Intent intent=new Intent(view.getContext() , com.example.android.myapplication.SecondActivity.class);
                intent.putExtra(MSG,msg);
                startActivity(intent);

            }
        });

        // we register for the contextmneu
        registerForContextMenu(lv);

        // TextFilter
        lv.setTextFilterEnabled(true);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }


    // We want to create a context Menu when the user long click on an item
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo aInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;

        // We know that each row in the adapter is a Map
        Planet planet = aAdpt.getItem(aInfo.position);

        menu.setHeaderTitle("Options for " + planet.getName());

        menu.add(1, 2, 2, "Delete");

    }


    // This method is called when user selects an Item in the Context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        AdapterView.AdapterContextMenuInfo aInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        planetsList.remove(aInfo.position);
        aAdpt.notifyDataSetChanged();
        return true;
    }


    private void initList() {
        // We populate the planets




    }


    // Handle user click
    public void addPlanet(View view) {
        final Dialog d = new Dialog(this);
        d.setContentView(R.layout.dialog);
        d.setTitle("Add Topic");
        d.setCancelable(true);

        final EditText edit = (EditText) d.findViewById(R.id.editTextPlanet);
        Button b = (Button) d.findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String planetName = edit.getText().toString();
                MainActivity.this.planetsList.add(new Planet(planetName));
                MainActivity.this.aAdpt.notifyDataSetChanged(); // We notify the data model is changed
                d.dismiss();
            }
        });

        d.show();
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.android.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.android.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

}
