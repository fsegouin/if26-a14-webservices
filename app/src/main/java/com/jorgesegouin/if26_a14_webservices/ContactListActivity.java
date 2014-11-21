package com.jorgesegouin.if26_a14_webservices;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.jorgesegouin.if26_a14_webservices.Api.MessengerClient;
import com.jorgesegouin.if26_a14_webservices.Models.ContactList;
import com.jorgesegouin.if26_a14_webservices.Models.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ContactListActivity extends Activity {

    private static final String TAG = "ContactListActivity";
    private String[] from = { "name", "message" };
    private int[] to = { android.R.id.text1, android.R.id.text2 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        Bundle b = getIntent().getExtras();
        String userToken = b.getString("token");

//        Download contact list from API

        MessengerClient.getMessengerApiClient().getContacts(userToken, new Callback<ContactList>() {
            @Override
            public void success(ContactList contactList, Response response) {
                List<Contact> allContacts = contactList.getContacts();
                ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();

                for (Contact contact : allContacts) {
                    HashMap<String, String> item = new HashMap<String, String>();
                    item.put("name", contact.getContact().getFirstName() + " " + contact.getContact().getLastName());
                    item.put("message", contact.getMessage().getMessage());
                    list.add(item);
                }

                ListView listView = (ListView) findViewById(R.id.listView);
                SimpleAdapter adapter = new SimpleAdapter(ContactListActivity.this, list,android.R.layout.simple_list_item_2, from, to);
                listView.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), "Error.", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact_list, menu);
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
}
