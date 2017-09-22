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
 * Created by deepika.j on 6/22/2017.
 */
public class Aggregations {

    /** property of name. */
    @JsonProperty("name")
    private String name;

    /** property of key. */
    @JsonProperty("key")
    private String key;

    /** property of type. */
    @JsonProperty("Bucket")
    private List<BucketOutput> bucketOutput;

    /** property of type. */
    @JsonProperty("type")
    private String type;

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

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
     * @return bucketOutput
     */
    public List<BucketOutput> getBucketOutput() {
        return bucketOutput;
    }

    /**
     *
     * @param bucket the bucketOutput to set
     */
    public void setBucketOutput(List<BucketOutput> bucket) {
        this.bucketOutput = bucket;
    }

    /**
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
}
