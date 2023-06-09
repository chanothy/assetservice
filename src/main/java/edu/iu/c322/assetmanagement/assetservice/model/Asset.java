package edu.iu.c322.assetmanagement.assetservice.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int licenseId;
    private String name;

    @Transient
    private String licenseType;

    @Transient
    private String licenseDescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return id == asset.id && licenseId == asset.licenseId && name.equals(asset.name) && licenseType.equals(asset.licenseType) && licenseDescription.equals(asset.licenseDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, licenseId, name, licenseType, licenseDescription);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getLicenseDescription() {
        return licenseDescription;
    }

    public void setLicenseDescription(String licenseDescription) {
        this.licenseDescription = licenseDescription;
    }
}

