package com.Ep3.Cliente.Repository;

import com.Ep3.Cliente.entity.Persona;
import org.springframework.data.repository.CrudRepository;



public interface ClienteRepository extends CrudRepository<Persona, Long> {

}
