package com.Ep3.Cliente.Api;

import com.Ep3.Cliente.entity.Persona;
import com.Ep3.Cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
public class ClienteApi {

	@Autowired
	private ClienteService clienteServiceAPI;

	@GetMapping(value = "/all")
	public List<Persona> getAll() {
		return clienteServiceAPI.getAll();
	}

	@GetMapping(value = "/find/{id}")
	public Persona find(@PathVariable Long id) {
		return clienteServiceAPI.get(id);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Persona> save(@RequestBody Persona persona) {
		Persona obj = clienteServiceAPI.save(persona);
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Persona> delete(@PathVariable Long id) {
		Persona persona = clienteServiceAPI.get(id);
		if (persona != null) {
			clienteServiceAPI.delete(id);
		} else {
			return new ResponseEntity<Persona>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}

}