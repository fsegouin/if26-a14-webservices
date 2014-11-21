package com.jorgesegouin.if26_a14_webservices.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by florentsegouin on 21/11/14.
 */

public class ContactList {

    private boolean error;
    private List<Contact> contacts = new ArrayList<Contact>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The error
     */
    public boolean isError() {
        return error;
    }

    /**
     *
     * @param error
     * The error
     */
    public void setError(boolean error) {
        this.error = error;
    }

    /**
     *
     * @return
     * The contacts
     */
    public List<Contact> getContacts() {
        return contacts;
    }

    /**
     *
     * @param contacts
     * The contacts
     */
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
