package como.lolaroca.practicaFinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import como.lolaroca.practicaFinal.join.DiscountUser;
import como.lolaroca.practicaFinal.repository.DiscountRepository;
import como.lolaroca.practicaFinal.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository repository;

    @Autowired
    private JdbcTemplate template;
    
    @Override
    public Iterable<DiscountUser> retrieveDiscountUser(String id) {
        String query = "SELECT DISCOUNT.DISCOUNT_ID,DISCOUNT.PRICE_DISCOUNT, USERS.USERNAME FROM USERS, DISCOUNT WHERE USERS.USER_ID = DISCOUNT.USER_ID AND USERS.USER_ID="+ id;//id es una variable
        Iterable<DiscountUser> userDiscount = template.query(
            query,
            (data, rowNum) -> { //te devuelve estas dos cosas: 
                return new DiscountUser( //nos devuelve un user nuevo 
                    data.getLong("DISCOUNT.DISCOUNT_ID"),
                    data.getFloat("DISCOUNT.PRICE_DISCOUNT"),
                    data.getString("USERS.USERNAME")
                );
            }
        );
        //DISCOUNT.DISCOUNT_ID, DISCOUNT.PRICE_DISCOUNT, USERS.USERNAME, PEDIDO.PEDIDO_ID, PEDIDO.PEDIDO_NAME, PEDIDO.FOOD_ID, PEDIDO.PRICE_PEDIDO

        return userDiscount; //me devuelve mi nueva tabla. 
    }
   
    
}
