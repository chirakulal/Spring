package com.xworkz.pant.dto;

import org.springframework.web.bind.annotation.RequestParam;

public class ButterDTO {


   private String type;
  private String fatContent;
   private String saltType;
   private String packageSize;
   private   String brand;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(String packageSize) {
        this.packageSize = packageSize;
    }

    public String getSaltType() {
        return saltType;
    }

    public void setSaltType(String saltType) {
        this.saltType = saltType;
    }

    public String getFatContent() {
        return fatContent;
    }

    public void setFatContent(String fatContent) {
        this.fatContent = fatContent;
    }
}
