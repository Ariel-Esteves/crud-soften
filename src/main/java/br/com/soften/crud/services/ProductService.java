package br.com.soften.crud.services;
import br.com.soften.crud.models.entities.Product;
import br.com.soften.crud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product save (Product req){ return productRepository.save(req) ; }

    public Optional<Product> findById(long id){return productRepository.findById(id); }

    public List<Product> findAll(){return productRepository.findAll();}

    public String delete(long id){
        Optional<Product> product = findById(id);
        boolean res = product.isPresent() ? true  : false;

        if(res){
            productRepository.delete(product.get());
            return "done";
        } else {
            return "not found";
        }
    }
}
