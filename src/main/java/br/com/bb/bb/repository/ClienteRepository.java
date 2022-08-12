package br.com.bb.bb.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.bb.bb.models.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

}