package como.lolaroca.practicaFinal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("DISCOUNT")
public class DiscountModel {
    @Id
    @Column("DISCOUNT_ID")
    private Long discountId;

    @Column("PRICE_DISCOUNT")
    private Float priceDiscount;

    @Column("USER_ID")
    private Long userId;

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public Float getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(Float priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((discountId == null) ? 0 : discountId.hashCode());
        result = prime * result + ((priceDiscount == null) ? 0 : priceDiscount.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DiscountModel other = (DiscountModel) obj;
        if (discountId == null) {
            if (other.discountId != null)
                return false;
        } else if (!discountId.equals(other.discountId))
            return false;
        if (priceDiscount == null) {
            if (other.priceDiscount != null)
                return false;
        } else if (!priceDiscount.equals(other.priceDiscount))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }
    
}
