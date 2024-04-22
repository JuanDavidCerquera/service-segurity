package com.sena.servicesecurity.Service.Operational;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.Operational.Bill;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Operational.IBillRepository;
import com.sena.servicesecurity.IService.Operational.IBillService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class BillService extends ABaseService<Bill> implements IBillService{

	@Override
	protected IBaseRepository<Bill, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	@Autowired
	private IBillRepository repository;

}
