package com.example.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

@Insert
    void insertrecord(User user);

@Query("Select EXISTS(SELECT * FROM USER WHERE uid = :userId)")
    Boolean is_exist(int userId);

@Query("Select * from User")
    List<User> getallusers();

}
