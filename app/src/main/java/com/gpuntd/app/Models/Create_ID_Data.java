package com.gpuntd.app.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Create_ID_Data {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("id_name")
    @Expose
    private String idName;
    @SerializedName("id_image")
    @Expose
    private String idImage;
    @SerializedName("id_website")
    @Expose
    private String idWebsite;
    @SerializedName("id_status")
    @Expose
    private String idStatus;
    @SerializedName("id_created_date")
    @Expose
    private String idCreatedDate;
    @SerializedName("id_updated_date")
    @Expose
    private String idUpdatedDate;
    @SerializedName("id_total_created")
    @Expose
    private String idTotalCreated;
    public Create_ID_Data(String id, String idName, String idImage, String idWebsite, String idStatus, String idCreatedDate, String idUpdatedDate, String idTotalCreated) {
        this.id = id;
        this.idName = idName;
        this.idImage = idImage;
        this.idWebsite = idWebsite;
        this.idStatus = idStatus;
        this.idCreatedDate = idCreatedDate;
        this.idUpdatedDate = idUpdatedDate;
        this.idTotalCreated = idTotalCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public String getIdWebsite() {
        return idWebsite;
    }

    public void setIdWebsite(String idWebsite) {
        this.idWebsite = idWebsite;
    }

    public String getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(String idStatus) {
        this.idStatus = idStatus;
    }

    public String getIdCreatedDate() {
        return idCreatedDate;
    }

    public void setIdCreatedDate(String idCreatedDate) {
        this.idCreatedDate = idCreatedDate;
    }

    public String getIdUpdatedDate() {
        return idUpdatedDate;
    }

    public void setIdUpdatedDate(String idUpdatedDate) {
        this.idUpdatedDate = idUpdatedDate;
    }

    public String getIdTotalCreated() {
        return idTotalCreated;
    }

    public void setIdTotalCreated(String idTotalCreated) {
        this.idTotalCreated = idTotalCreated;
    }
}
