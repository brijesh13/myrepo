
package com.example.daffolap_172.ratrofitdemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hero {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("global_rank")
    @Expose
    private Integer globalRank;
    @SerializedName("country_rank")
    @Expose
    private Integer countryRank;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("diff")
    @Expose
    private Integer diff;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("institution")
    @Expose
    private String institution;
    @SerializedName("institution_type")
    @Expose
    private String institutionType;
    @SerializedName("all_rating")
    @Expose
    private String allRating;
    @SerializedName("html_handle")
    @Expose
    private String htmlHandle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGlobalRank() {
        return globalRank;
    }

    public void setGlobalRank(Integer globalRank) {
        this.globalRank = globalRank;
    }

    public Integer getCountryRank() {
        return countryRank;
    }

    public void setCountryRank(Integer countryRank) {
        this.countryRank = countryRank;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getDiff() {
        return diff;
    }

    public void setDiff(Integer diff) {
        this.diff = diff;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getInstitutionType() {
        return institutionType;
    }

    public void setInstitutionType(String institutionType) {
        this.institutionType = institutionType;
    }

    public String getAllRating() {
        return allRating;
    }

    public void setAllRating(String allRating) {
        this.allRating = allRating;
    }

    public String getHtmlHandle() {
        return htmlHandle;
    }

    public void setHtmlHandle(String htmlHandle) {
        this.htmlHandle = htmlHandle;
    }

}
