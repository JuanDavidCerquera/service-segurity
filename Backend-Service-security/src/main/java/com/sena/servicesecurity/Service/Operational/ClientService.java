package com.sena.servicesecurity.Service.Operational;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Service.ABaseService;
import com.sena.servicesecurity.DTO.IClientDto;
import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Operational.Client;
import com.sena.servicesecurity.Entity.Security.Person;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Operational.IClientRepository;
import com.sena.servicesecurity.IService.Operational.IClientService;
import com.sena.servicesecurity.IService.Security.IPersonService;

@Service
public class ClientService extends ABaseService<Client> implements IClientService{

	@Override
	protected IBaseRepository<Client, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	

	
	private final IClientRepository repository;
	
	@Lazy
    private final IPersonService personService;

    public ClientService( @Lazy IPersonService personService, IClientRepository repository) {
        this.repository = repository;
		this.personService = personService;
    }

	@Override
	public List<IClientDto> getList() {
		return repository.getList();
	}

	@Override
	public Client save(Client entity) throws Exception {
		try {
			IPersonDto person = repository.getDocument(entity.getPerson().getId());
			
			String type= person.getType_document();
			String document = person.getDocument();
			// Obtener el año actual
			int currentYear = LocalDate.now().getYear();

			// Obtener los últimos 4 dígitos de document
			String documentSuffix = document.substring(Math.max(0, document.length() - 4));

			// Combinar los elementos para formar el código
			String code = currentYear + "-" + type + "-" + documentSuffix;
			
			entity.setCode(code);
            entity.setCreatedAt(LocalDateTime.now());
            entity.setCreatedBy((long)1); //Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
            return getRepository().save(entity);
        } catch (Exception e) {
            // Captura la excepción
            throw new Exception("Error al guardar la entidad: " + e.getMessage());
        }
	}

//	@Override
//	public void update(Long id, Client entity) throws Exception {
//		Optional<Client> opClient = getRepository().findById(id);
//
//        if (opClient.isEmpty()) {
//            throw new Exception("Registro no encontrado");
//        } else if (opClient.get().getDeletedAt() != null) {
//            throw new Exception("Registro inhabilitado");
//        }
//
//
//        Client existingClient = opClient.get();
//        Person PersonExist = existingClient.getPerson();
//        // Verificar si el documento ha cambiado
//        if (!PersonExist.getDocument().equals(entity.getPerson().getDocument())) {
//            // El documento ha cambiado, genera un nuevo código
//        	Person person = entity.getPerson();
//            String newCode = GenerateCodeCustomer(person.getId(), person.getTypeDocument(), person.getDocument(), entity.getCreatedAt());
//            existingClient.setCode(newCode);
//        }
//
//        // Copiar propiedades desde la entidad de entrada a la existente, ignorando campos no actualizables
//        String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy", "code" };
//        BeanUtils.copyProperties(entity, existingClient, ignoreProperties);
//        
//        // Actualizar las propiedades adicionales
//        existingClient.setUpdatedAt(LocalDateTime.now());
//        existingClient.setUpdatedBy((long)1); // Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
//        
//        // Guardar la entidad actualizada
//        getRepository().save(existingClient);
//    }
	
	
	@Override
	public void update(Long id, Client entity) throws Exception {
		Optional<Client> op = getRepository().findById(id);

        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        } else if (op.get().getDeletedAt() != null) {
            throw new Exception("Registro inhabilitado");
        }
        Client entityUpdate = op.get();
        
        Person personUpdate = entity.getPerson();
        
        
        Optional<Client> clientExist = getRepository().findById(id);
        Person personExist = clientExist.get().getPerson();
        
        if(personExist.getDocument() != entity.getPerson().getDocument() ||  personExist.getTypeDocument() != entity.getPerson().getTypeDocument()) {
        	
        	
        	String code = GenerateCodeCustomer(personUpdate.getTypeDocument(),personUpdate.getDocument(),clientExist.get().getCreatedAt());
            entityUpdate.setCode(code);

        }
        	personService.update(personUpdate.getId(), personUpdate);
        	String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy","code" };
            BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
            entityUpdate.setUpdatedAt(LocalDateTime.now());
            entityUpdate.setUpdatedBy((long)1); //Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
            getRepository().save(entityUpdate);
        
	}

	@Override
	public String GenerateCodeCustomer(String typeDocument, String document, LocalDateTime date) 
			throws Exception {
			 	String documentDigit= document.substring(Math.max(0, document.length() -4));
			 	String code= date.getYear()+"-"+typeDocument+"-"+documentDigit;
				return code;
	}

	@Override
	public Client savePersonClient(Person entity) throws Exception {
		Person person = personService.save(entity);
		Client entityClient = new Client();
		String codeClient=  GenerateCodeCustomer(person.getTypeDocument(), person.getDocument(), person.getCreatedAt());
		entityClient.setCode(codeClient);
		entityClient.setPerson(person);
		entityClient.setState(true);
		entityClient.setCreatedAt(LocalDateTime.now());
		entityClient.setCreatedBy((long)1); //Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
        
		Client client = save(entityClient);
		return client;
		
	}

	@Override
	public Optional<Client> findByPersonId(Long personId) {
		return  repository.findByPersonId(personId);
	}
}
