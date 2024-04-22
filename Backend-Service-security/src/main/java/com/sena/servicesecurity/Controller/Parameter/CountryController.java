package com.sena.servicesecurity.Controller.Parameter;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Parameter.Country;
import com.sena.servicesecurity.IService.Parameter.ICountryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/country")
public class CountryController extends ABaseController<Country,ICountryService>{
	public CountryController(ICountryService service) {
        super(service, "Country");
    }


}
