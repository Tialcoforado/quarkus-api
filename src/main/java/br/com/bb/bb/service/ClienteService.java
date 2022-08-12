package br.com.bb.bb.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import org.eclipse.microprofile.opentracing.Traced;

import br.com.bb.bb.models.Cliente;
import br.com.bb.bb.repository.ClienteRepository;

@RequestScoped
@Traced
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    public List<Cliente> listClientes(){
        return clienteRepository.listAll();
    }

    @Transactional
    public Cliente createClient(Cliente user) throws Exception {

        try {
            clienteRepository.persist(user);
            return user;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Cliente updateClient(long id, Cliente client) {

        Cliente entity = clienteRepository.findById(id);
        if (entity == null) {
            throw new NotFoundException();
        }

        entity.setName(client.getName());
        entity.setAge(client.getAge());
        entity.setVat(client.getVat());
        entity.setEmail(client.getEmail());

        return entity;
    }


    @Transactional
    public void deleteClient(long id) throws Exception {

        Cliente entity = clienteRepository.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        clienteRepository.delete(entity);

    }
 
}

