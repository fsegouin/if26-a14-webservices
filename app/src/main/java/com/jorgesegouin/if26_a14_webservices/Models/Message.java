package com.jorgesegouin.if26_a14_webservices.Models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by florentsegouin on 18/11/14.
 */

public class Message {

    private String message;
    private String date;
    private boolean sent;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The sent
     */
    public boolean isSent() {
        return sent;
    }

    /**
     *
     * @param sent
     * The sent
     */
    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}