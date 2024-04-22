package com.sena.servicesecurity.IRepository.Operational;

import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.Entity.Operational.Bill;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface IBillRepository extends IBaseRepository<Bill, Long>{}
