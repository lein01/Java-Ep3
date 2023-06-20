package com.Ep3.Cliente.service.impl;

import com.Ep3.Cliente.commons.GenericServiceImpl;
import com.Ep3.Cliente.Repository.ClienteRepository;
import com.Ep3.Cliente.entity.Persona;
import com.Ep3.Cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class ClienteServiceImpl extends GenericServiceImpl<Persona, Long> implements ClienteService {

	@Autowired(required=true)
	private ClienteRepository clienteRepository;

	@Override
	public CrudRepository<Persona, Long> getDao() {
		return clienteRepository;
	}

}