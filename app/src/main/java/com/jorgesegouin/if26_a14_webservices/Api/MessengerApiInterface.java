package com.jorgesegouin.if26_a14_webservices.Api;

import android.widget.EditText;

import com.jorgesegouin.if26_a14_webservices.Models.Contact;
import com.jorgesegouin.if26_a14_webservices.Models.ContactList;
import com.jorgesegouin.if26_a14_webservices.Models.MessagesList;
import com.jorgesegouin.if26_a14_webservices.Models.User;

import java.util.List;

import retrofit.Callback;
import retrofit.client.Response;
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

    @GET("/contacts.php")
    void getContacts(@Query("token") String token, Callback<ContactList> cb);

    @GET("/messages.php")
    void getMessages(@Query("token") String token, @Query("contact") int contactId, Callback<MessagesList> cb);

    @GET("/message.php")
    void sendMessage(@Query("token") String token, @Query("contact") int contactId,
                     @Query("message") String message, Callback<MessagesList> cb);

}
