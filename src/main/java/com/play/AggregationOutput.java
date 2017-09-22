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
public class AggregationOutput {

    /** property of name. */
    @JsonProperty("name")
    private String name;

    /** property of Bucket. */
    @JsonProperty("Bucket")
    private List<Bucket> bucket;

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
     * @return bucket
     */
    public List<Bucket> getBucket() {
        return bucket;
    }

    /**
     *
     * @param bucket the bucket to set
     */
    public void setBucket(List<Bucket> bucket) {
        this.bucket = bucket;
    }
}
