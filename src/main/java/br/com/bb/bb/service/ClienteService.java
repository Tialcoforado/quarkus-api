package br.com.bb.bb.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import br.com.bb.bb.models.Categoria;
import br.com.bb.bb.repository.CategoriaRepository;
import org.eclipse.microprofile.opentracing.Traced;

import br.com.bb.bb.models.Cliente;
import br.com.bb.bb.repository.ClienteRepository;

@RequestScoped
@Traced
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    CategoriaRepository categoriaRepository;

    public List<Cliente> listClientes(){
        return clienteRepository.listAll();
    }

    @Transactional
    public Cliente createClient(Cliente user) throws Exception {
        Categoria category = categoriaRepository.findById(user.getCategoriaCode());
        Cliente cliente = new Cliente();

        cliente.setName(user.getName());
        cliente.setAge(user.getAge());
        cliente.setVat(user.getVat());
        cliente.setEmail(user.getEmail());
        cliente.setCategoria(category);

        try {
            clienteRepository.persist(cliente);
            return cliente;
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
        Categoria category = categoriaRepository.findById(client.getCategoriaCode());

        entity.setName(client.getName());
        entity.setAge(client.getAge());
        entity.setVat(client.getVat());
        entity.setEmail(client.getEmail());
        entity.setCategoria(category);

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

