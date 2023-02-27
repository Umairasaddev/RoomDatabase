package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText t1,t2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);

        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new bgThread().start();
            }
        });
    }

    public class bgThread extends Thread{
        @Override
        public void run() {
            super.run();

            AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"roomdb").build();

            UserDao userDao = db.userDao();
            userDao.insertrecord(new User(5,t1.getText().toString(),t2.getText().toString()));
            t1.setText("");
            t2.setText("");


        }
    }
}