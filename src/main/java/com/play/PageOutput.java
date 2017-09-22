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

public class PageOutput {

    /** property of total. */
    @JsonProperty("total")
    private int total;

    /** property of firstRow. */
    @JsonProperty("firstRow")
    private int firstRow;

    /** property of lastRow. */
    @JsonProperty("lastRow")
    private int lastRow;

    /** property of value. */
    @JsonProperty("value")
    private String value;

    /** property of result. */
    @JsonProperty("Result")
    private List<RowOutput> result;

    /**
     * @return the total
     */
    public final int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public final void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the firstRow
     */
    public final int getFirstRow() {
        return firstRow;
    }

    /**
     * @param firstRow the firstRow to set
     */
    public final void setFirstRow(int firstRow) {
        this.firstRow = firstRow;
    }

    /**
     * @return the lastRow
     */
    public final int getLastRow() {
        return lastRow;
    }

    /**
     * @param lastRow the lastRow to set
     */
    public final void setLastRow(int lastRow) {
        this.lastRow = lastRow;
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
     * @return the result
     */
    public final List<RowOutput> getResult() {
        if (CollectionUtils.isEmpty(result)) {
            result = new ArrayList<RowOutput>();
        }
        return result;
    }

    /**
     * @param result the result to set
     */
    public final void setResult(List<RowOutput> result) {
        this.result = result;
    }

}
