//package com.example.beatbox.db;
//
//import androidx.lifecycle.LiveData;
//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.OnConflictStrategy;
//import androidx.room.Query;
//
//import com.example.beatbox.model.User;
//
//@Dao
//public interface UserDao {
//
//    /**
//     *
//     * @param user
//     */
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void inserUers(User user);
//
//    /**
//     *
//     * @param user
//     */
//    @Delete
//    void deleteStudent(User user);
//
//    /**
//     *
//     * @param name
//     * @return LiveData(User)
//     */
//    @Query("SELECT * FROM user WHERE name = :name")
//    LiveData<User> getUserByName(String name);
//}