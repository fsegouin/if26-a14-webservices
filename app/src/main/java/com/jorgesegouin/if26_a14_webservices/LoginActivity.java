package com.jorgesegouin.if26_a14_webservices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jorgesegouin.if26_a14_webservices.Api.MessengerClient;
import com.jorgesegouin.if26_a14_webservices.Models.User;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class LoginActivity extends Activity {

    private EditText txtEmail;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Messenger App");

        txtEmail = (EditText) findViewById(R.id.email);
        txtPassword = (EditText) findViewById(R.id.password);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    public void connexion(View view) {
        String emailValue = txtEmail.getText().toString();
        String passwordValue = txtPassword.getText().toString();

        MessengerClient.getMessengerApiClient().getUser(emailValue, passwordValue, new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                String userToken = user.getToken();
                if (userToken != null) {
//                    Toast.makeText(getApplicationContext(), "Token: " + userToken, Toast.LENGTH_SHORT).show();
                    Intent contactListIntent = new Intent(LoginActivity.this, ContactListActivity.class);
                    contactListIntent.putExtra("token", userToken);
                    startActivity(contactListIntent);
                }
                else
                    Toast.makeText(getApplicationContext(), "Erreur, veuillez vérifier vos informations",
                            Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
