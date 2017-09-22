/*
 * Copyright 2012 Thomson Reuters Global Resources. All Rights Reserved.
 *
 * Proprietary and confidential information of TRGR. Disclosure, use,
 * or reproduction without the written authorization of TRGR is prohibited.
 */
package com.play;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author narendras
 *
 */
public class ForthComingConferenceEditions {

    /**Holds list of Conference Editions. */
    private List<ConferenceEditions> conferenceEditions;

    /**
     * @return the conferenceEditions
     */
    public final List<ConferenceEditions> getConferenceEditions() {
        return conferenceEditions;
    }

    /**
     * Accessor method to set listForthComingConferences.
     *
     * The JsonProperty ;'ConferenceEditions', is an indication to
     * the Jackson API to map 'ConferenceEditions'(json)
     * with 'conferenceEditions'(java).
     *
     * @param editions the conferenceEditions to set
     */
    @JsonProperty("ConferenceEditions")
    public final void setConferenceEditions(
                            final List<ConferenceEditions> editions) {
        conferenceEditions = editions;
    }
}
