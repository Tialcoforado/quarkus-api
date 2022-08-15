package br.com.bb.bb.service;

import br.com.bb.bb.models.Categoria;
import br.com.bb.bb.repository.CategoriaRepository;
import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

@RequestScoped
@Traced
public class CategoriaService {

    @Inject
    CategoriaRepository categoriaRepository;

    public List<Categoria> listCategorias(){
        return categoriaRepository.listAll();
    }

    @Transactional
    public Categoria createCategoria(Categoria user) throws Exception {

        try {
            categoriaRepository.persist(user);
            return user;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Categoria updateCategoria(long id, Categoria categoria) {

        Categoria entity = categoriaRepository.findById(id);
        if (entity == null) {
            throw new NotFoundException();
        }

        entity.setNome(categoria.getNome());

        return entity;
    }


    @Transactional
    public void deleteCategoria(long id) throws Exception {

        Categoria entity = categoriaRepository.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        categoriaRepository.delete(entity);

    }
 
}

