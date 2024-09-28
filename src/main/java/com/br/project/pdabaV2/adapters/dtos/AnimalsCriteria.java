package com.br.project.pdabaV2.adapters.dtos;

import java.util.Date;

public interface AnimalsCriteria {

    Long getId();
    String getName();
    String getInstagramURL();
    Date getRegistrationDate();
    Long getPriority();
    Boolean getActive();
    byte[] getPicByte();
    String getImageName();
    String getImageType();
    Date getAdoptionDate();

}
