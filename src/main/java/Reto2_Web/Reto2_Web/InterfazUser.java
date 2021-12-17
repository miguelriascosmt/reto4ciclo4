
package Reto2_Web.Reto2_Web;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface InterfazUser extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    List<User> findBybirthtDay(Date date);
   Optional<User> findByEmailAndPassword(String email, String password);
   
    List<User> findByMonthBirthtDay(String monthBirthtDay);
}
