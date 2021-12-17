package Reto2_Web.Reto2_Web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class Reto2WebApplication implements CommandLineRunner {
    
    @Autowired
    private InterfazCleaningProduct interfazCleaningProduct;
    @Autowired
    private InterfazUser interfazUser;
    @Autowired
    private InterfazOrder interfazOrder;
    
    @Autowired
    private UserRepositorio userRepositorio;
    
    @Autowired
    private OrderRepositorio orderRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;
	
        public static void main(String[] args) {
		SpringApplication.run(Reto2WebApplication.class, args);
	}
        @Override
        
        public void run (String... args) throws Exception{
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        interfazCleaningProduct.deleteAll();
        interfazUser.deleteAll();
        interfazOrder.deleteAll();
    }

}
