package com.jorgesegouin.if26_a14_webservices.Api;

import retrofit.RestAdapter;

/**
 * Created by florentsegouin on 19/11/14.
 */
public class MessengerClient {
    private static MessengerApiInterface sMessengerService;

    public static MessengerApiInterface getMessengerApiClient() {
        if (sMessengerService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://train.sandbox.eutech-ssii.com/messenger/")
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();

            sMessengerService = restAdapter.create(MessengerApiInterface.class);
        }

        return sMessengerService;
    }
}
