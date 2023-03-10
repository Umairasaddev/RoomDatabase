package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

TextView lbl,data;
    EditText t1,t2,t3;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b2 = findViewById(R.id.b2);
        data = findViewById(R.id.dataholder);
        lbl = findViewById(R.id.lbl);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);

        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class,"room_db").allowMainThreadQueries().build();

                UserDao userDao = db.userDao();
                Boolean check = userDao.is_exist(Integer.parseInt(t1.getText().toString()));

                if (check == false){
                    userDao.insertrecord(new User(Integer.parseInt(t1.getText().toString()),
                            t2.getText().toString(), t3.getText().toString()));
                    t1.setText("");
                    t2.setText("");
                    lbl.setText("Record Inserted Sucessfully");
                }else
                {
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");

                lbl.setText("Record exist already");
                }





            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class,"room_db").allowMainThreadQueries().build();

                UserDao userDao = db.userDao();

                List<User> users = userDao.getallusers();
                String str="";

                for (User user : users)
                    str = str+ "\t" +user.getUid() + " " + user.getFirstName() + " " + user.getLastName() + "\n";


                data.setText(str);
            }
        });
    }

//    public class bgThread extends Thread{
//        @Override
//        public void run() {
//            super.run();
//
//            AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"roomdb").build();
//
//            UserDao userDao = db.userDao();
//            userDao.insertrecord(new User(5,t1.getText().toString(),t2.getText().toString()));
//            t1.setText("");
//            t2.setText("");
//
//
//        }
//    }
}