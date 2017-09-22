/*
 * Copyright 2014 Thomson Reuters Global Resources. All Rights Reserved. 
 * 
 * Proprietary and confidential information of TRGR. Disclosure, use, 
 * or reproduction without the written authorization of TRGR is prohibited.
 */
package com.play;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author narendras
 *
 */
public class Filter {


    /** property of name. */
    @JsonProperty("name")
    private String name;

    /** property of key. */
    @JsonProperty("key")
    private String key;

    /** property of type. */
    @JsonProperty("type")
    private String type;

    /** property of option. */
    @JsonProperty("Option")
    private List<FilterOption> option;

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
     * @return the key
     */
    public final String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public final void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the option
     */
    public final List<FilterOption> getOption() {
        if (CollectionUtils.isEmpty(option)) {
            option = new ArrayList<FilterOption>();
        }
        return option;
    }

    /**
     * @param option the option to set
     */
    public final void setOption(List<FilterOption> option) {
        this.option = option;
    }

    /**
     * @return the type
     */
    public final String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public final void setType(String type) {
        this.type = type;
    }
}
