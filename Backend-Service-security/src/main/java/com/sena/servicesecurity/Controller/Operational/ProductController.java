package com.sena.servicesecurity.Controller.Operational;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Operational.Product;
import com.sena.servicesecurity.IService.Operational.IProductService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/product")
public class ProductController  extends ABaseController<Product, IProductService>{

	protected ProductController(IProductService service) {
		super(service, "product");
		// TODO Auto-generated constructor stub
	}

}
