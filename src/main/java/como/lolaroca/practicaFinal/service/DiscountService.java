package como.lolaroca.practicaFinal.service;

import como.lolaroca.practicaFinal.join.DiscountUser;

public interface DiscountService {
    Iterable<DiscountUser> retrieveDiscountUser(String id); //le metemos el user id que queremos ver el descuento que tiene 
    
}
