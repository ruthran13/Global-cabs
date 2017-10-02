package com.example.ruthran13.globalcabs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper Mydb;
    EditText Myedit1, Myedit2, Myedit3, Myedit4, Myedit5, Myedit6;
    Button But1, But2, But3;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Mydb = new DatabaseHelper(this);

        Myedit1 = (EditText) findViewById(R.id.editText_name);
        Myedit2 = (EditText) findViewById(R.id.editText_password1);
        Myedit3 = (EditText) findViewById(R.id.editText_password2);
        Myedit4 = (EditText) findViewById(R.id.editText_email);

        Myedit5 = (EditText) findViewById(R.id.editText_username);
        Myedit6 = (EditText) findViewById(R.id.editText_password1);

        But1 = (Button) findViewById(R.id.Button1);
        But2 = (Button) findViewById(R.id.Button2);
        But3 = (Button) findViewById(R.id.Button1);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        AddData();
        Signin();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void AddData() {


        But1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Myedit1.getText().toString().length() == 0) {
                    Toast.makeText(MainActivity.this, "Enter user name", Toast.LENGTH_LONG).show();
                    return;

                } else if (Myedit2.getText().toString().length() == 0) {
                    Toast.makeText(MainActivity.this, "Enter password", Toast.LENGTH_LONG).show();
                    return;


                } else if (Myedit4.getText().toString().length() == 0) {
                    Toast.makeText(MainActivity.this, "Enter email address", Toast.LENGTH_LONG).show();
                    return;

                } else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(Myedit4.getText().toString()).matches()){
                    Toast.makeText(MainActivity.this, "Enter valid email address", Toast.LENGTH_LONG).show();
                    return;


                } else {

                    if (Myedit2.getText().toString().equals(Myedit3.getText().toString())) {

                        boolean IsInserted = Mydb.insertData(Myedit1.getText().toString(), Myedit2.getText().toString(), Myedit4.getText().toString());

                        if (IsInserted = true) {
                            Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "User not registered", Toast.LENGTH_LONG).show();

                        }
                    } else {

                        Toast.makeText(MainActivity.this,"Passwords doesn't match", Toast.LENGTH_LONG).show();
                        return;
                    }

                }
            }
        });
    };


    public void Signin() {
        But2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signin.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.ruthran13.globalcabs/http/host/path")
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
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.ruthran13.globalcabs/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
