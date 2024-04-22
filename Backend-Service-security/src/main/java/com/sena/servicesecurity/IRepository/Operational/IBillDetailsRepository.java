package com.sena.servicesecurity.IRepository.Operational;

import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.Entity.Operational.BillDetails;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface IBillDetailsRepository extends IBaseRepository<BillDetails, Long>{

}
