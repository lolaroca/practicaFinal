package como.lolaroca.practicaFinal.repository;



import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import como.lolaroca.practicaFinal.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Long>{
    public UserModel findByUsername(String username);
    @Query("INSERT INTO USUARIO (userId,username,email,country,address,pedidoId,password) " +"VALUES (:userId,:username,:email,:country,:edad,:address,:pedidoId,:password)")
        void creaUsuario(Long userId,
              String username,
              String email,
              String country,
              String address,
              Long pedidoId,
              String password);
   
}
