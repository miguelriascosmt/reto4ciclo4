
package Reto2_Web.Reto2_Web;

import Reto2_Web.Reto2_Web.InterfazCleaningProduct;
import Reto2_Web.Reto2_Web.CleaningProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CleaningProductRepositorio {
    @Autowired
    private InterfazCleaningProduct productCrudRepository;

    public List<CleaningProduct> getAll(){
        return productCrudRepository.findAll();
    }

    public Optional<CleaningProduct> getProduct(Integer id){
        return productCrudRepository.findById(id);
    }

    public CleaningProduct create(CleaningProduct product){
        return productCrudRepository.save(product);
    }

    public void update(CleaningProduct product){
        productCrudRepository.save(product);
    }

    public void delete(CleaningProduct product){
        productCrudRepository.delete(product);
    } 
    
    public List<CleaningProduct> productByPrice(double precio) {
	return productCrudRepository.findByPriceLessThanEqual(precio);
}
}
