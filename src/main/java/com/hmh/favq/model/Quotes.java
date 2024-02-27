package com.hmh.favq.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.List;

@Generated("jsonschema2pojo")
public class Quotes {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("last_page")
    @Expose
    private Boolean lastPage;
    @SerializedName("quotes")
    @Expose
    private List<QuoteObject> quotes;
    @SerializedName("totalObjects")
    @Expose
    private Integer totalObjects;

    public Integer getTotalObjects() {
        return totalObjects;
    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Boolean getLastPage() {
        return lastPage;
    }

    public void setLastPage(Boolean lastPage) {
        this.lastPage = lastPage;
    }

    public List<QuoteObject> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<QuoteObject> quotes) {
        this.quotes = quotes;
    }
    public void setTotalObjects(Integer totalObjects) {
        this.totalObjects = totalObjects;
    }

}