package com.sena.servicesecurity.Controller.Operational;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Operational.BillDetails;
import com.sena.servicesecurity.IService.Operational.IBillDetailsService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/bill_details")
public class BillDetailsController  extends ABaseController<BillDetails, IBillDetailsService>{

	protected BillDetailsController(IBillDetailsService service) {
		super(service, "bill_details");
		// TODO Auto-generated constructor stub
	}

}
