package com.play;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by deepika.j on 6/28/2017.
 */
public class Bucket {

    /** property of key. */
    @JsonProperty("key")
    private String key;

    /** property of count. */
    @JsonProperty("count")
    private String count;

    /** property of value. */
    @JsonProperty("value")
    private String value;

    /**
     *
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     *
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     *
     * @return count
     */
    public String getCount() {
        return count;
    }

    /**
     *
     * @param count teh count to set
     */
    public void setCount(String count) {
        this.count = count;
    }

    /**
     *
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value teh value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
}
