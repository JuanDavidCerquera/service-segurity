package com.sena.servicesecurity.DTO;

import java.time.LocalDateTime;

public interface IContractDto extends IGenericDto	{

	String getCode();
	String getDate_start();
	String getDate_ending();
	String getSalary();
	String getObject();
	String getCompany();
	String getPerson();
	LocalDateTime getDeletedAt();
}
