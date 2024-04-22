package com.sena.servicesecurity.Service.Operational;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.Operational.Product;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Operational.IProductRepository;
import com.sena.servicesecurity.IService.Operational.IProductService;
import com.sena.servicesecurity.Service.ABaseService;


@Service
public class ProductService extends ABaseService<Product> implements IProductService{

	@Override
	protected IBaseRepository<Product, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	private IProductRepository repository;
	
}
