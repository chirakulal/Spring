package com.xworkz.facewash.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoeComponent {

    @Autowired
    private BagComponent bagComponent;

    public void walk(){
        System.out.println("running walkMethod in shoeComponent");
        bagComponent.hold();
    }
}
