/*
 * Copyright 2014 Thomson Reuters Global Resources. All Rights Reserved. 
 * 
 * Proprietary and confidential information of TRGR. Disclosure, use, 
 * or reproduction without the written authorization of TRGR is prohibited.
 */
package com.play;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author narendras
 *
 */
public class HitTerms {


    /** property of hitTerm. */
    @JsonProperty("Term")
    private List<HitTerm> hitTerm;

    /** property of synonyms. */
    @JsonProperty("Synonym")
    private List<Synonym> synonyms;

	/**
	 * @return the hitTerm
	 */
	public final List<HitTerm> getHitTerm() {
		if (null == hitTerm) {
			hitTerm = new ArrayList<HitTerm>();
		}
		return hitTerm;
	}

	/**
	 * @param hitTerm the hitTerm to set
	 */
	public final void setHitTerm(List<HitTerm> hitTerm) {
		this.hitTerm = hitTerm;
	}

	/**
	 * @return the synonyms
	 */
	public final List<Synonym> getSynonyms() {
		if (null == synonyms) {
			synonyms = new ArrayList<Synonym>();
		}
		return synonyms;
	}

	/**
	 * @param synonyms the synonyms to set
	 */
	public final void setSynonyms(List<Synonym> synonyms) {
		this.synonyms = synonyms;
	}

}
