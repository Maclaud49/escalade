package com.parlow.escalade.model.bean;

public class Departement {

    // ==================== Attributs ====================
    private Integer id;
    private String departement;
    private Region region;

    // ==================== Getters/Setters ==============


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
