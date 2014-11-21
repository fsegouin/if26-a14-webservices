package com.jorgesegouin.if26_a14_webservices.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by florentsegouin on 21/11/14.
 */


public class MessagesList {

    private Boolean error;
    private List<Message> messages = new ArrayList<Message>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The error
     */
    public Boolean getError() {
        return error;
    }

    /**
     *
     * @param error
     * The error
     */
    public void setError(Boolean error) {
        this.error = error;
    }

    /**
     *
     * @return
     * The messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     *
     * @param messages
     * The messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
