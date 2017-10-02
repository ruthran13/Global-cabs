package com.example.ruthran13.globalcabs;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Signin extends AppCompatActivity {

    DatabaseHelper dh;
    SQLiteDatabase db ;
    EditText edit1 , edit2;
    Button But;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        dh = new DatabaseHelper(this);

        edit1 = (EditText) findViewById(R.id.editText_username);
        edit2 = (EditText) findViewById(R.id.editText_password1);

        But = (Button) findViewById(R.id.Button1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

//        ValidateUser(edit1.getText().toString(), edit2.getText().toString());

    }

    Cursor cursor;

    public void ValidateUser(String username, String password) {

//        Cursor c = DATABASE_NAME.rawQuery("SELECT name, password FROM" +  TABLE_NAME "WHERE Name like '" + username + "'" + "AND password like" + password, null);

//        if (c != null) {
            Login();

        }
//    }

    public void Login() {
        But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signin.this, TextView.class);
                startActivity(intent);
            }
        });
    }

}
