package com.xworkz.pant.dto;

import org.springframework.web.bind.annotation.RequestParam;

public class ParatoDTO {

   private String type;
   private int size;
   private int layers;
   private boolean stuffed;
    private String flour;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getLayers() {
        return layers;
    }

    public void setLayers(int layers) {
        this.layers = layers;
    }

    public boolean isStuffed() {
        return stuffed;
    }

    public void setStuffed(boolean stuffed) {
        this.stuffed = stuffed;
    }

    public String getFlour() {
        return flour;
    }

    public void setFlour(String flour) {
        this.flour = flour;
    }
}
