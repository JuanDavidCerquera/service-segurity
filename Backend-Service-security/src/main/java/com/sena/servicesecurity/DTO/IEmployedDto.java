package com.sena.servicesecurity.DTO;

import java.time.LocalDateTime;

public interface IEmployedDto extends IGenericDto{
	String getCode();
    String getPerson();
    String getPosition();
    String getCompany();
    LocalDateTime getDeletedAt();
	
}
