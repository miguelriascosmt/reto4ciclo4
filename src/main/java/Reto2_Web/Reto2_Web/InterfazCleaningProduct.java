/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_Web.Reto2_Web;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import Reto2_Web.Reto2_Web.CleaningProduct;
/**
 *
 * @author USUARIO
 */
public interface InterfazCleaningProduct extends MongoRepository<CleaningProduct, Integer> {
     public List<CleaningProduct> findByPriceLessThanEqual(double precio);
}
