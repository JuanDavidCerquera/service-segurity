package com.sena.servicesecurity.IRepository.Parameter;


import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.Entity.Parameter.Municipality;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface IMunicipalityRepository extends IBaseRepository<Municipality, Long> {

}
