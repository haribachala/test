package com.play;

import java.util.Set;

public class SearchResult {
    private Set<String> results;
    private Integer total;

    public SearchResult(Set<String> results, Integer total) {
        this.results = results;
        this.total = total;
    }

    public Set<String> getResults() {
        return this.results;
    }

    public void setResults(Set<String> results) {
        this.results = results;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
