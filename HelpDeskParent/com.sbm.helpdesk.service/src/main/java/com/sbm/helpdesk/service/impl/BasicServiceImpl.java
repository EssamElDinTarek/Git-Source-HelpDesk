package com.sbm.helpdesk.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
