package com.hmh.favq.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class UserDetails {

    @SerializedName("user")
    @Expose
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @SerializedName("favorite")
    @Expose
    private Boolean favorite;
    @SerializedName("upvote")
    @Expose
    private Boolean upvote;
    @SerializedName("downvote")
    @Expose
    private Boolean downvote;
    @SerializedName("hidden")
    @Expose
    private Boolean hidden;

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Boolean getUpvote() {
        return upvote;
    }

    public void setUpvote(Boolean upvote) {
        this.upvote = upvote;
    }

    public Boolean getDownvote() {
        return downvote;
    }

    public void setDownvote(Boolean downvote) {
        this.downvote = downvote;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

}