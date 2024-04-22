package com.sena.servicesecurity.IRepository.Operational;

import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.Entity.Operational.Product;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface IProductRepository extends IBaseRepository<Product, Long>{

}
