package com.example.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface UserDao {

@Insert
    void insertrecord(User user);

}
