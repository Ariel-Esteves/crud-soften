package br.com.soften.crud.services;
import br.com.soften.crud.models.entities.Sales;
import br.com.soften.crud.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    public Sales save (Sales req){ return salesRepository.save(req) ; }

    public Optional<Sales> findById(long id){return salesRepository.findById(id); }

    public List<Sales> findAll(){return salesRepository.findAll();}

    public String delete(long id){
        Optional<Sales> sales = findById(id);
        boolean res = sales.isPresent() ? true  : false;

        if(res){
            salesRepository.delete(sales.get());
            return "done";
        } else {
            return "not found";
        }
    }

}
