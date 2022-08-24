package br.com.soften.crud.services;

import br.com.soften.crud.models.Dto.SalesDto;
import br.com.soften.crud.models.entities.Product;
import br.com.soften.crud.models.entities.Sales;
import br.com.soften.crud.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class SalesService {


    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private ProductService productService;

    public Optional<Sales> findById(long id){

        return salesRepository.findById(id);}

    public Sales save(Sales entity ){ return salesRepository.save(entity); }

    public void deleteById(long id){}

    public List<Sales> findAll(){ return salesRepository.findAll();}

    public Sales update(Sales sales){

        return salesRepository.save(sales); }

    public List<Object> getRelationalTable(){ return salesRepository.getRelationalTable();}

}
