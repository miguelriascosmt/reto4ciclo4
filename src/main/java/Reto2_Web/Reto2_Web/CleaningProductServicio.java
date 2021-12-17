
package Reto2_Web.Reto2_Web;

import Reto2_Web.Reto2_Web.CleaningProduct;
import Reto2_Web.Reto2_Web.CleaningProductRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CleaningProductServicio {
    @Autowired
    private CleaningProductRepositorio productRepository;

    public List<CleaningProduct> getAll(){
        return productRepository.getAll();
    }

    public Optional<CleaningProduct> getCleaningProducts(Integer id){
        return productRepository.getProduct(id);
    }

    public CleaningProduct save(CleaningProduct cleaningProduct){
        if(cleaningProduct.getId() == null) {
            return cleaningProduct;
        }else{
            return productRepository.create(cleaningProduct);
        }
    }

    public CleaningProduct update(CleaningProduct product) {

        if (product.getId() != null) {
            Optional<CleaningProduct> dbProduct = productRepository.getProduct(product.getId());
            if (!dbProduct.isEmpty()) {
                if (product.getBrand() != null) {
                    dbProduct.get().setBrand(product.getBrand());
                }
                if (product.getCategory() != null) {
                    dbProduct.get().setCategory(product.getCategory());
                }
                if (product.getDescription() != null) {
                    dbProduct.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0.0) {
                    dbProduct.get().setPrice(product.getPrice());
                }
                if (product.getPrice() != 0.0) {
                    dbProduct.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    dbProduct.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    dbProduct.get().setPhotography(product.getPhotography());
                }
                dbProduct.get().setAvailability(product.isAvailability());
                productRepository.update(dbProduct.get());
                return dbProduct.get();
            } else {
                return product;
            }
        }else{
            return product;
        }
    }

    public boolean delete(Integer id){
        Boolean aboolean= getCleaningProducts(id).map(cleaningProduct -> {
            productRepository.delete(cleaningProduct);
            return true;
        }).orElse(false);
        return aboolean;
    }
    
    public List<CleaningProduct> productByPrice(double price) {
        return productRepository.productByPrice(price);
    }
}
