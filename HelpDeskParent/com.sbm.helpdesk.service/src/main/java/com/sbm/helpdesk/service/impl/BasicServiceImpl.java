package com.sbm.helpdesk.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/*
 * This class is to convert Dto to Entity and ViceVersa
 * E is the Entity to be converted which is User Entity for example
 * D is the DTO to be get which is UserDTO for example
 * D is always the DTO and it is the first generic argument , E is always the Entity and it is the second generic argument
 * */
@Service
public class BasicServiceImpl<D,E> {

	@Autowired
	protected ModelMapper modelMapper;
	
	
	@SuppressWarnings("unchecked")
	public D convertToDTO(E entity , D dto)
	{
		
		D convertedDtoObj = (D) modelMapper.map(entity, dto.getClass());
		return convertedDtoObj;
	}
	
	@SuppressWarnings("unchecked")
	public E convertToEntity(E entity , D dto)
	{
		E convertedEntity = (E) modelMapper.map(dto, entity.getClass());
		return convertedEntity;
	}
	
	protected void configureMapperLocally()
	{
		
	}
}
