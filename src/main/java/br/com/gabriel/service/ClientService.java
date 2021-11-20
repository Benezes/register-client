package br.com.gabriel.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.gabriel.dto.ClientDTO;
import br.com.gabriel.entity.ClientEntity;
import br.com.gabriel.exception.ObjectAlreadyExistException;
import br.com.gabriel.exception.ObjectNotFoundException;
import br.com.gabriel.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ModelMapper modelMapper;

	public Page<ClientDTO> findAllClients(PageRequest pageable) {
		return clientRepository.findAll(pageable).map(itens -> modelMapper.map(itens, ClientDTO.class));
	}

	public ClientDTO findClientById(Long id) {
		return convertToDTO(clientRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Id .: " + id + ", not found.")));
	}

	public ClientDTO save(ClientDTO client) {

		Optional<ClientEntity> clientCpf = clientRepository.findByCpf(client.getCpf());

		if (clientCpf.isPresent())
			throw new ObjectAlreadyExistException("This client already exist");

		return convertToDTO(clientRepository.save(convertToEntity(client)));
	}

	public ClientDTO update(Long id, ClientDTO newClient) {
		ClientDTO oldClient = findClientById(id);
		BeanUtils.copyProperties(newClient, oldClient, "id");
		return convertToDTO(clientRepository.save(convertToEntity(oldClient)));
	}

	public void deleteClientById(Long id) {
		findClientById(id);
		clientRepository.deleteById(id);
	}

	private ClientDTO convertToDTO(ClientEntity entity) {
		return modelMapper.map(entity, ClientDTO.class);
	}

	private ClientEntity convertToEntity(ClientDTO dto) {
		return modelMapper.map(dto, ClientEntity.class);
	}
}
