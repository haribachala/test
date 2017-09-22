/*
 * Copyright 2012 Thomson Reuters Global Resources. All Rights Reserved.
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
public class ConferenceEditions {

    /**
     * Java object representing content of 'EditionId' json object.
     */
    private int editionId;

    /**
     * Java object representing content of 'EditionName' json object.
     */
    private String editionName;

    /**
     * Java object representing content of 'ConferenceName' json object.
     */
    private String conferenceName;

    /**
     * Java object representing content of 'DateStart' json object.
     */
    private String dateStart;

    /**
     * Java object representing content of 'DateEnd' json object.
     */
    private String dateEnd;

    /**
     * Java object representing content of 'ExternalURL' json object.
     */
    private String externalUrl;

    /**
     * Java object representing content of 'OrganizerName' json object.
     */
    private String organizerName;

    /**
     * @return the editionId
     */
    public final int getEditionId() {
        return editionId;
    }

    /**
     * Accessor method to set conferenceEditions.
     *
     * The JsonProperty ;'EditionId', is an indication to
     * the Jackson API to map 'ConferenceEditions'(json)
     * with 'editionId'(java).
     *
     * @param id the editionId to set
     */
    @JsonProperty("EditionId")
    public final void setEditionId(final int id) {
        editionId = id;
    }

    /**
     * @return the editionName
     */
    public final String getEditionName() {
        return editionName;
    }

    /**
     * Accessor method to set conferenceEditions.
     *
     * The JsonProperty ;'EditionName', is an indication to
     * the Jackson API to map 'ConferenceEditions'(json)
     * with 'editionName'(java).
     *
     * @param name the editionName to set
     */
    @JsonProperty("EditionName")
    public final void setEditionName(final String name) {
        editionName = name;
    }

    /**
     * @return the conferenceName
     */
    public final String getConferenceName() {
        return conferenceName;
    }

    /**
     * Accessor method to set conferenceEditions.
     *
     * The JsonProperty ;'ConferenceName', is an indication to
     * the Jackson API to map 'ConferenceEditions'(json)
     * with 'conferenceName'(java).
     *
     * @param confName the conferenceName to set
     */
    @JsonProperty("ConferenceName")
    public final void setConferenceName(final String confName) {
        conferenceName = confName;
    }

    /**
     * @return the dateStart
     */
    public final String getDateStart() {
        return dateStart;
    }

    /**
     * Accessor method to set conferenceEditions.
     *
     * The JsonProperty ;'DateStart', is an indication to
     * the Jackson API to map 'ConferenceEditions'(json)
     * with 'dateStart'(java).
     *
     * @param startDate the dateStart to set
     */
    @JsonProperty("DateStart")
    public final void setDateStart(final String startDate) {
        dateStart = startDate;
    }

    /**
     *
     * @return
     */
    public final String getDateEnd() {
        return dateEnd;
    }

    /**
     *
     * @param dateEnd
     */
    @JsonProperty("DateEnd")
    public final void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     *
     * @return
     */
    public final String getExternalUrl() {
        return externalUrl;
    }

    /**
     *
     * @param externalUrl
     */
    @JsonProperty("ExternalURL")
    public final void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    /**
     *
     * @return
     */
    public final String getOrganizerName() {
        return organizerName;
    }

    /**
     *
     * @param organizerName
     */
    @JsonProperty("OrganizerName")
    public final void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }
}
