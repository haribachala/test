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
public class SearchOutput {


    /** property of id. */
    @JsonProperty("id")
    private String id;

    /** property of dataset. */
    @JsonProperty("dataset")
    private String dataset;

    /** property of time. */
    @JsonProperty("time")
    private Long time;

    /** property of normalizedUIQL. */
    @JsonProperty("normalizedUIQL")
    private String normalizedUIQL;

    /** property of lastDatasetUpdate. */
    @JsonProperty("lastDatasetUpdate")
    private String lastDatasetUpdate;
    

    /** property of filters. */
    @JsonProperty("Filters")
    private List<Filter> filters;

    /** property of pagedResults. */
    @JsonProperty("PagedResults")
    private PageOutput pagedResults;

    /** property of datasetCounts. */
    @JsonProperty("DatasetCounts")
    private List<DatasetCount> datasetCounts;

    /** property of year. */
    @JsonProperty("serviceExecutionTime")
    private String serviceExecutionTime;

    /** property of hitTerms. */
    @JsonProperty("HitTerms")
    private HitTerms hitTerms;

    /** property of aggregations. */
    @JsonProperty("Aggregations")
    private List<Aggregations> aggregations;

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
     * @return the time
     */
    public final Long getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public final void setTime(Long time) {
        this.time = time;
    }

    /**
     * @return the normalizedUIQL
     */
    public final String getNormalizedUIQL() {
        return normalizedUIQL;
    }

    /**
     * @param normalizedUIQL the normalizedUIQL to set
     */
    public final void setNormalizedUIQL(String normalizedUIQL) {
        this.normalizedUIQL = normalizedUIQL;
    }

    /**
     * @return the lastDatasetUpdate
     */
    public final String getLastDatasetUpdate() {
        return lastDatasetUpdate;
    }

    /**
     * @param lastDatasetUpdate the lastDatasetUpdate to set
     */
    public final void setLastDatasetUpdate(String lastDatasetUpdate) {
        this.lastDatasetUpdate = lastDatasetUpdate;
    }

    /**
     * @return the filters
     */
    public final List<Filter> getFilters() {
        if (CollectionUtils.isEmpty(filters)) {
            filters = new ArrayList<Filter>();
        }
        return filters;
    }

    /**
     * @param filters the filters to set
     */
    public final void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    /**
     * @return the pagedResults
     */
    public final PageOutput getPagedResults() {
        return pagedResults;
    }

    /**
     * @param pagedResults the pagedResults to set
     */
    public final void setPagedResults(PageOutput pagedResults) {
        this.pagedResults = pagedResults;
    }

    /**
     * @return the datasetCounts
     */
    public final List<DatasetCount> getDatasetCounts() {
        if (CollectionUtils.isEmpty(datasetCounts)) {
            datasetCounts = new ArrayList<DatasetCount>();
        }
        return datasetCounts;
    }

    /**
     * @param datasetCounts the datasetCounts to set
     */
    public final void setDatasetCounts(List<DatasetCount> datasetCounts) {
        this.datasetCounts = datasetCounts;
    }

    /**
     * @return the serviceExecutionTime
     */
    public final String getServiceExecutionTime() {
        return serviceExecutionTime;
    }

    /**
     * @param serviceExecutionTime the serviceExecutionTime to set
     */
    public final void setServiceExecutionTime(String serviceExecutionTime) {
        this.serviceExecutionTime = serviceExecutionTime;
    }

    /**
     * @return the hitTerms
     */
    public final HitTerms getHitTerms() {
        return hitTerms;
    }

    /**
     * @param hitTerms the hitTerms to set
     */
    public final void setHitTerms(HitTerms hitTerms) {
        this.hitTerms = hitTerms;
    }

    /**
     *
     * @return the aggregations
     */
    public List<Aggregations> getAggregations() {
        return aggregations;
    }

    /**
     *
     * @param aggregations the aggregations to set
     */
    public void setAggregations(List<Aggregations> aggregations) {
        this.aggregations = aggregations;
    }
}
