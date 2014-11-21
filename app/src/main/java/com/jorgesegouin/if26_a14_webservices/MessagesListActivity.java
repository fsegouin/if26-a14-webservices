package com.jorgesegouin.if26_a14_webservices;

import android.app.Activity;
import android.os.Bundle;
import android.sax.TextElementListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.jorgesegouin.if26_a14_webservices.Api.MessengerClient;
import com.jorgesegouin.if26_a14_webservices.Models.Message;
import com.jorgesegouin.if26_a14_webservices.Models.MessagesList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MessagesListActivity extends Activity {

    SimpleAdapter adapter = null;
    private EditText messageText;
    private Button sendButton;
    private List<Message> allMessages = new ArrayList<Message>();
    private ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
    private String[] from = { "message", "date" };
    private int[] to = { android.R.id.text1, android.R.id.text2 };
    private String userToken;
    private int contactId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages_list);

        messageText = (EditText) findViewById(R.id.messageTextField);
        sendButton = (Button) findViewById(R.id.sendButton);

        Bundle b = getIntent().getExtras();
        userToken = b.getString("userToken");
        contactId = b.getInt("contactId");
        String contactName = b.getString("contactName");
        setTitle(contactName);

        final ListView messageListView = (ListView) findViewById(R.id.messageListView);
        adapter = new SimpleAdapter(MessagesListActivity.this, list,
                android.R.layout.simple_list_item_2, from, to);
        messageListView.setAdapter(adapter);

        messageText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(messageText.length() != 0)
                    sendButton.setEnabled(true);
                else
                    sendButton.setEnabled(false);
            }
        });

        //        Download contact list from the API
        getMessages();

    }

    public void getMessages() {
        MessengerClient.getMessengerApiClient().getMessages(userToken, contactId,
                new Callback<MessagesList>() {
            @Override
            public void success(MessagesList messagesList, Response response) {
                allMessages = messagesList.getMessages();
                list.clear();

                for (Message message : allMessages) {
                    HashMap<String, String> item = new HashMap<String, String>();
                    item.put("message", message.getMessage());
                    item.put("date", message.getDate());
                    list.add(item);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void sendMessage(View view) {
        String message = messageText.getText().toString();

        if (message.length() != 0) {
            MessengerClient.getMessengerApiClient().sendMessage(userToken, contactId, message,
                    new Callback<MessagesList>() {
                        @Override
                        public void success(MessagesList messagesList, Response response) {
                            if (messagesList.getError() != Boolean.TRUE) {
                                Toast.makeText(getApplicationContext(), "Message envoyé", Toast.LENGTH_SHORT).show();
                                messageText.setText("");
                                getMessages();
                            } else
                                Toast.makeText(getApplicationContext(), "Error lors de l'envoi du message",
                                        Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Toast.makeText(getApplicationContext(), "Error lors de l'envoi du message.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_messages_list, menu);
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
