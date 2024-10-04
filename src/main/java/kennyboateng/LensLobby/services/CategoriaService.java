package kennyboateng.LensLobby.services;

import kennyboateng.LensLobby.entities.Categoria;
import kennyboateng.LensLobby.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> findAllCategorie() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findCategoriaById(Long id) {
        return categoriaRepository.findById(id);
    }

    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
