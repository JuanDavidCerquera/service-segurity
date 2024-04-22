package com.sena.servicesecurity.Controller.Parameter;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Parameter.Location;
import com.sena.servicesecurity.IService.Parameter.ILocationService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/location")
public class LocationController extends ABaseController<Location,ILocationService>{

	protected LocationController(ILocationService service) {
		super(service, "Location");
		// TODO Auto-generated constructor stub
	}


}
