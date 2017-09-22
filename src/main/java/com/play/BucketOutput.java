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
public class BucketOutput {

    /** property of count. */
    @JsonProperty("count")
    private String count;

    /** property of key. */
    @JsonProperty("key")
    private String key;

    /** property of value. */
    @JsonProperty("value")
    private String value;

    /** property of Aggregation. */
    @JsonProperty("Aggregation")
    private List<AggregationOutput> aggregationOutput;

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
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     *
     * @return aggregationOutput
     */
    public List<AggregationOutput> getAggregationOutput() {
        return aggregationOutput;
    }

    /**
     *
     * @param aggregationOutput the aggregationOutput to set
     */
    public void setAggregationOutput(List<AggregationOutput> aggregationOutput) {
        this.aggregationOutput = aggregationOutput;
    }
}
