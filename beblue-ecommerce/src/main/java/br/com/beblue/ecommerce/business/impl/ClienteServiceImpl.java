package br.com.beblue.ecommerce.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beblue.ecommerce.business.ClienteService;
import br.com.beblue.ecommerce.domain.entity.Cliente;
import br.com.beblue.ecommerce.exception.BeblueErroException;
import br.com.beblue.ecommerce.repository.ClienteRepository;

@Service
public class ClienteServiceImpl extends AbstractService implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente buscaClientePorCpf(String cpf) throws BeblueErroException {
		try {
			cpf = cpf.replaceAll("", "");
			cpf = cpf.replaceAll("-", "");
			return clienteRepository.findByCpf(cpf);
		}catch (Exception e) {
			throw new BeblueErroException("Falha ao buscar cliente pelo cpf" + e.getMessage());
		}
	}

	@Override
	public Cliente salva(Cliente cliente) throws BeblueErroException {
		try {
			Cliente clienteDB = buscaClientePorCpf(cliente.getCpf());
			return clienteDB == null ? clienteRepository.save(cliente) : clienteDB;
		}catch (Exception e) {
			throw new BeblueErroException("Falha ao salvar cliente" + e.getMessage());
		}
	}

}
