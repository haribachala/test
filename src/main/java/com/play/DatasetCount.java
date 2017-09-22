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
public class DatasetCount {

    /** property of dataset. */
    @JsonProperty("dataset")
    private String dataset;

    /** property of value. */
    @JsonProperty("value")
    private int value;

    /**
     * @return the dataset
     */
    public final String getDataset() {
        return dataset;
    }

    /**
     * @param dataset the dataset to set
     */
    public final void setDataset(String dataset) {
        this.dataset = dataset;
    }

    /**
     * @return the value
     */
    public final int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public final void setValue(int value) {
        this.value = value;
    }
}
