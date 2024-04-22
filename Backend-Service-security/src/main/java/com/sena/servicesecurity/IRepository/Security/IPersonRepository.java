package com.sena.servicesecurity.IRepository.Security;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Security.Person;
import com.sena.servicesecurity.IRepository.IBaseRepository;


@Repository
public interface IPersonRepository extends IBaseRepository<Person, Long>{


		@Query(value = " SELECT  "
				+ " id, "
				+ " concat(first_name,'  ',last_name) as person, "
				+ " type_document, "
				+ " document "
				+ "	FROM  "
				+ "	person "
				+ "	WHERE  "
				+ " deleted_at IS NULL", nativeQuery = true)
		List<IPersonDto> getList();
		
		@Query(value = " SELECT  "
				+ " id, "
				+ " concat(first_name,'  ',last_name) as person "
				+ "	FROM  "
				+ "	person "
				+ "	WHERE  "
				+ " deleted_at IS NULL", nativeQuery = true)
		List<Object[]> getDList();
		
		@Query(value = " SELECT  "
				+ " type_document, "
				+ " document "
				+ "	FROM  "
				+ "	person "
				+ "	WHERE  "
				+ " id = :Id", nativeQuery = true)
		String[] getDocument(@Param("Id") Long Id);
		
		@Query(value = " SELECT  "
				+ " id, "
				+ " concat(first_name,'  ',last_name) as person, "
				+ " document "
				+ "	FROM  "
				+ "	person "
				+ "	WHERE  "
				+ " type_document = :type", nativeQuery = true)
		List<IPersonDto> getTypeDocument(@Param("type") String type);
		
		
		
		@Query(value = " SELECT  "
				+ " c.id "
				+ "	FROM  "
				+ "	client AS c"
				+ "	WHERE  "
				+ " c.person_id = :personId", nativeQuery = true)
		Optional<IPersonDto> findClientIdByPersonId(@Param("personId") Long id);

}
