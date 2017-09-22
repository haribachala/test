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
public class RowOutput {

    /** property of pos. */
    @JsonProperty("pos")
    private String pos;

    /** property of field. */
    @JsonProperty("Field")
    private List<FieldOutput> field;

    /**
     * @return the pos
     */
    public final String getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public final void setPos(String pos) {
        this.pos = pos;
    }

    /**
     * @return the field
     */
    public final List<FieldOutput> getField() {
        if (CollectionUtils.isEmpty(field)) {
            field = new ArrayList<FieldOutput>();
        }
        return field;
    }

    /**
     * @param field the field to set
     */
    public final void setField(List<FieldOutput> field) {
        this.field = field;
    }
}
