package com.sena.servicesecurity.IService.Operational;

import java.util.List;


import com.sena.servicesecurity.DTO.ILendingDto;
import com.sena.servicesecurity.Entity.Operational.Lending;
import com.sena.servicesecurity.IService.IBaseService;

public interface ILendingService extends IBaseService<Lending> {

	List<ILendingDto> getListBookClient(Long clientId);
	
}
