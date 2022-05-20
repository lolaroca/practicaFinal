package como.lolaroca.practicaFinal.join;


public class DiscountUser {
    private Long discountId; //DISCOUNT
    private float discount; //DISCOUNT
    private String username; //USER

    
    public DiscountUser(Long discountId, float discount, String username){
        this.discountId = discountId;
        this.discount = discount;
        this.username = username;
    }

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

   

   