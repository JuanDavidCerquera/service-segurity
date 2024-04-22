package com.sena.servicesecurity.Controller.Operational;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Operational.Bill;
import com.sena.servicesecurity.IService.Operational.IBillService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/bill")
public class BillController  extends ABaseController<Bill, IBillService>{

	protected BillController(IBillService service) {
		super(service, "bill");
		// TODO Auto-generated constructor stub
	}

}
