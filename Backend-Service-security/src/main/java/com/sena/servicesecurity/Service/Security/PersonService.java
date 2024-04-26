package com.sena.servicesecurity.Service.Security;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Operational.Client;
import com.sena.servicesecurity.Entity.Security.Person;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Security.IPersonRepository;
import com.sena.servicesecurity.IService.Operational.IClientService;
import com.sena.servicesecurity.IService.Security.IPersonService;
import com.sena.servicesecurity.Service.ABaseService;
import com.sena.servicesecurity.Utils.Nomenclature;


@Service
public class PersonService extends ABaseService<Person> implements IPersonService{
	@Override
	protected IBaseRepository<Person, Long> getRepository() {
		return repository;
	}

	
	private final IPersonRepository repository;
	@Lazy
    private final IClientService serviceClient;

    public PersonService(IPersonRepository repository, @Lazy IClientService serviceCustomer) {
        this.repository = repository;
        this.serviceClient = serviceCustomer;
    }
	


	
	

	
	@Override
	public List<IPersonDto> getList() {
		
		return repository.getList();
	}

	@Override
	public Nomenclature[] getDirections() {
		// TODO Auto-generated method stub
		return Nomenclature.values();
	}

	@Override
	public List<IPersonDto> getTypeDocument(String type) {
		return repository.getTypeDocument(type);
	}
	@Override
	public Optional<IPersonDto> findClientIdByPersonId(Long id) {
		return  repository.findClientIdByPersonId(id);
	}
	
 
   
   @Override
   public void update(Long id, Person entity) throws Exception {
       Optional<Person> opPerson = getRepository().findById(id);

       if (opPerson.isEmpty()) {
           throw new Exception("Registro no encontrado");
       } else if (opPerson.get().getDeletedAt() != null) {
           throw new Exception("Registro inhabilitado");
       }
       
       LocalDateTime fecha = opPerson.get().getCreatedAt();
       System.out.println(fecha+"fecha de creacion");
       Person entityUpdate = opPerson.get();
       
       
       String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy" };
       BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
       entityUpdate.setUpdatedAt(LocalDateTime.now());
       entityUpdate.setUpdatedBy((long)1); //Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
       getRepository().save(entityUpdate);

   Optional<Client> opClient= serviceClient.findByPersonId(id);
   
   if (opClient.isPresent() && opClient.get().getDeletedAt() == null) {
	    String code = serviceClient.GenerateCodeCustomer(entityUpdate.getTypeDocument(), entityUpdate.getDocument(), fecha);
	    Client client = opClient.get();
	    client.setCode(code);
	    serviceClient.update(client.getId(), client);
	}
   }


	
}
