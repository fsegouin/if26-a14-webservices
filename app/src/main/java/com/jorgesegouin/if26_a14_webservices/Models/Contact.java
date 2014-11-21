package com.jorgesegouin.if26_a14_webservices.Models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by florentsegouin on 18/11/14.
 */

public class Contact {

    private int id;
    private Contact_ contact;
    private Message message;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The contact
     */
    public Contact_ getContact() {
        return contact;
    }

    /**
     *
     * @param contact
     * The contact
     */
    public void setContact(Contact_ contact) {
        this.contact = contact;
    }

    /**
     *
     * @return
     * The message
     */
    public Message getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(Message message) {
        this.message = message;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}