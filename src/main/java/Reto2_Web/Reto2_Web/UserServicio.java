
package Reto2_Web.Reto2_Web;

import Reto2_Web.Reto2_Web.User;
import Reto2_Web.Reto2_Web.UserRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicio {
    @Autowired
    private UserRepositorio userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }

    public User save(User user){
        if(user.getId() == null) {
            return user;
        }else{
            Optional<User> e = userRepository.getUser(user.getId());
            if(e.isEmpty()){
                if(emailExists(user.getEmail())==false){
                    return userRepository.save(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }
        }
    }

    public User update(User user) {
        if(user.getId() != null) {
            Optional<User> dbUser = userRepository.getUser(user.getId());
            if (!dbUser.isEmpty()) {
                if (user.getIdentification() != null) {
                    dbUser.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    dbUser.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    dbUser.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    dbUser.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    dbUser.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    dbUser.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    dbUser.get().setZone(user.getZone());
                }
                userRepository.save(dbUser.get());
                return dbUser.get();
            } else {
                return user;
            }
        }else{
            return user;
        }
    }

    public boolean delete(int userId) {
        Boolean userBoolean = getUser(userId).map(user ->{
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return userBoolean;
    }

    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    public User authenticateUser (String email, String password) {
        Optional<User> user = userRepository.authenticateUser(email, password);
        if(user.isEmpty()){
            return new User();
        } else{
            return user.get();
        }
    }
    
    public List<User> birthtDayList(String monthBirthtDay) {
        return userRepository.birthtDayList(monthBirthtDay);
    }
}
