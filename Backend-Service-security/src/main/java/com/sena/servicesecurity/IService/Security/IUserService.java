package com.sena.servicesecurity.IService.Security;

import java.util.Optional;


import com.sena.servicesecurity.DTO.IUserDto;
import com.sena.servicesecurity.DTO.SaveUserPersonDTO;
import com.sena.servicesecurity.Entity.Security.User;
import com.sena.servicesecurity.IService.IBaseService;

public interface IUserService extends IBaseService<User>{

	 Optional<IUserDto> getUserWithViews(String username, String password);
	 public User saveUserPerson(SaveUserPersonDTO userPerson)  throws Exception;
	 

}
