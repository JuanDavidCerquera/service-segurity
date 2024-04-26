package com.sena.servicesecurity.Service.Security;

import com.sena.servicesecurity.DTO.IModuleDto;
import com.sena.servicesecurity.DTO.IUserDto;
import com.sena.servicesecurity.DTO.IViewDto;
import com.sena.servicesecurity.DTO.SaveUserPersonDTO;
import com.sena.servicesecurity.Entity.Security.Person;
import com.sena.servicesecurity.Entity.Security.Role;
import com.sena.servicesecurity.Entity.Security.User;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Security.IUserRepository;
import com.sena.servicesecurity.IService.Security.IPersonService;
import com.sena.servicesecurity.IService.Security.IRoleService;
import com.sena.servicesecurity.IService.Security.IUserService;
import com.sena.servicesecurity.Service.ABaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService extends ABaseService<User> implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected IBaseRepository<User, Long> getRepository() {
        return userRepository;
    }
    @Autowired
    private IPersonService personService;
    
    @Autowired
    private RoleService roleService;
    



    @Override

    public Optional<IUserDto> getUserWithViews(String username, String password) {
    	
        List<IUserDto> userDtoList = userRepository.getUserWithRole(username, password);

        if (!userDtoList.isEmpty()) {
            IUserDto userDto = userDtoList.get(0);
            
            Long roleId = userDto.getRoleId();
            
            System.out.println(userDto);
            
            List<IViewDto> views = userRepository.getViewsByRoleId(roleId);
            
            
            List<IModuleDto> modules = userRepository.getModulsByRoleId(roleId);
            
            System.out.println(roleId);
            // Crear una implementación concreta de IUserDto y llenarla con los datos obtenidos
           
            IUserDto dto = new IUserDto() {
                @Override
                public Long getId() {
                    return userDto.getId();
                }

                @Override
                public String getUsername() {
                    return userDto.getUsername();
                }

                @Override
                public String getPersonName() {
                    return userDto.getPersonName();
                }

                @Override
                public String getPersonEmail() {
                    return userDto.getPersonEmail();
                }

                @Override
                public Boolean getState() {
                    return userDto.getState();
                }

                @Override
                public Long getRoleId() {
                    return userDto.getRoleId();
                }

				@Override
				public List<IModuleDto> getModules() {
					// TODO Auto-generated method stub
					return modules;
				}

				@Override
				public void setModules(List<IModuleDto> model) {
					// TODO Auto-generated method stub
					
				}
            };

            return Optional.of(dto);
        } else {
            return Optional.empty();
        }
    }




	@Override
	public User saveUserPerson(SaveUserPersonDTO userPerson) throws Exception {
		try {
			
	        // Validación de datos
	        if (userPerson.getUsername() == null || userPerson.getUsername().isEmpty()) {
	            throw new IllegalArgumentException("El nombre de usuario no puede estar vacío");
	        }
	        if (userPerson.getPassword() == null || userPerson.getPassword().isEmpty()) {
	            throw new IllegalArgumentException("La contraseña no puede estar vacía");
	        }
	        
	        
		Person person = personService.save(userPerson.getPerson());
		User entityUser = new User();
		Optional<Role> role = roleService.findById(Long.valueOf(2));
		
	    Set<Role> listRole = new HashSet();
	    listRole.add(role.get());
		
		entityUser.setUsername(userPerson.getUsername());
		entityUser.setPassword(userPerson.getPassword());
		entityUser.setPerson(person);
		entityUser.setState(true);
		entityUser.setRole(listRole);
		entityUser.setCreatedAt(LocalDateTime.now());
		entityUser.setCreatedBy((long)1);
		return userRepository.save(entityUser);
	}catch (Exception e) {
        // Captura la excepción
        throw new Exception("Error al guardar la usuario");
    }
	}
}
