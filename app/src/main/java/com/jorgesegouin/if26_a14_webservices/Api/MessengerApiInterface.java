package com.jorgesegouin.if26_a14_webservices.Api;

import android.widget.EditText;

import com.jorgesegouin.if26_a14_webservices.Models.User;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;

/**
 * Created by florentsegouin on 18/11/14.
 */
public interface MessengerApiInterface {
    @GET("/login.php")
    void getUser(@Query("email") String email, @Query("password") String password, Callback<User> cb);

//    @GET("/d3/profile/{battleTag}/")
//    Profile profile(@Path("battleTag") String battleTag);

//    @GET("/d3/profile/{battleTag}/")
//    void getUserProfile(@Path("battleTag") String battleTag, Callback<Profile> cb);
}
