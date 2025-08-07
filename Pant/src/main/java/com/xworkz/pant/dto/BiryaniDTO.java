package com.xworkz.pant.dto;

import org.springframework.web.bind.annotation.RequestParam;

public class BiryaniDTO {
    private String type;
    private String spice;
    private String size;
    private String accompaniments;
    private String rice;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpice() {
        return spice;
    }

    public void setSpice(String spice) {
        this.spice = spice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAccompaniments() {
        return accompaniments;
    }

    public void setAccompaniments(String accompaniments) {
        this.accompaniments = accompaniments;
    }

    public String getRice() {
        return rice;
    }

    public void setRice(String rice) {
        this.rice = rice;
    }
}
