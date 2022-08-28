package br.com.soften.crud.services;
import br.com.soften.crud.models.entities.Client;
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

    public Product findById(long id){
        Optional<Product> find = productRepository.findById(id);
        Product result = find.isPresent() ? find.get() : productRepository.findById(1L).get();
        return result; }

    public List<Product> findAll(){return productRepository.findAll();}

    public String delete(long id){
        Product product = findById(id);
        boolean res = product.getName() != "null product" ? true  : false;

        if(res){
            productRepository.delete(product);
            return "done";
        } else {
            return "not found";
        }
    }

    public List<Product> findByNameContaining(String name){
        return productRepository.findByNameContaining(name);
    }
}
