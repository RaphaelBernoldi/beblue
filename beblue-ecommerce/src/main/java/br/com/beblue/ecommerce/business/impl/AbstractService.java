package br.com.beblue.ecommerce.business.impl;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractService {
	
	protected <T> ResponseEntity<T>getResultado(Optional<T>optional){
		if(optional.isPresent()) {
			return new ResponseEntity<T>(optional.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}

}
