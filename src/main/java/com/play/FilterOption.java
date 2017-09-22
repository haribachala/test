/*
 * Copyright 2014 Thomson Reuters Global Resources. All Rights Reserved. 
 * 
 * Proprietary and confidential information of TRGR. Disclosure, use, 
 * or reproduction without the written authorization of TRGR is prohibited.
 */
package com.play;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author narendras
 *
 */
public class FilterOption {

    /** property of name. */
    @JsonProperty("name")
    private String name;

    /** property of count. */
    @JsonProperty("count")
    private int count;

    /** property of id. */
    @JsonProperty("id")
    private String id;

    /** property of value. */
    @JsonProperty("value")
    private String value;
    
    /** property of path. */
    @JsonProperty("path")
    private String path;

    /** property of leaf. */
    @JsonProperty("leaf")
    private String leaf;

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * @return the count
     */
    public final int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public final void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public final void setId(String id) {
        this.id = id;
    }

    /**
     * @return the value
     */
    public final String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public final void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the path
     */
    public final String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public final void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the leaf
     */
    public final String getLeaf() {
        return leaf;
    }

    /**
     * @param leaf the leaf to set
     */
    public final void setLeaf(String leaf) {
        this.leaf = leaf;
    }
}
