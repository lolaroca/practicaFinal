package como.lolaroca.practicaFinal.repository;



import org.springframework.data.repository.CrudRepository;

import como.lolaroca.practicaFinal.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Long>{
    public UserModel findByUsername(String username);

   
}
