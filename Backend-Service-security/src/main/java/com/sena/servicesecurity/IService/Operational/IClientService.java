package com.sena.servicesecurity.IService.Operational;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import com.sena.servicesecurity.DTO.IClientDto;
import com.sena.servicesecurity.Entity.Operational.Client;
import com.sena.servicesecurity.Entity.Security.Person;
import com.sena.servicesecurity.IService.IBaseService;

public interface IClientService extends IBaseService<Client>{
	
	List<IClientDto> getList();
	public String GenerateCodeCustomer(String typeDocument, String document, LocalDateTime createAt) throws Exception ;

	public Client savePersonClient(Person entity) throws Exception;
	
	 Optional<Client> findByPersonId(Long personId);
}
