package como.lolaroca.practicaFinal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ELEMENTO")
public class ElementoModel {
    @Id
    @Column("FOOD_ID")
    private Long foodId;

    @Column("FOOD_NAME")
    private String foodName;

    @Column("PRICE")
    private float price;

    @Column("INGREDIENTES")
    private String ingredientes;

    @Column("KALORIES")
    private Long kalories;

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Long getKalories() {
        return kalories;
    }

    public void setKalories(Long kalories) {
        this.kalories = kalories;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((foodId == null) ? 0 : foodId.hashCode());
        result = prime * result + ((foodName == null) ? 0 : foodName.hashCode());
        result = prime * result + ((ingredientes == null) ? 0 : ingredientes.hashCode());
        result = prime * result + ((kalories == null) ? 0 : kalories.hashCode());
        result = prime * result + Float.floatToIntBits(price);
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
        ElementoModel other = (ElementoModel) obj;
        if (foodId == null) {
            if (other.foodId != null)
                return false;
        } else if (!foodId.equals(other.foodId))
            return false;
        if (foodName == null) {
            if (other.foodName != null)
                return false;
        } else if (!foodName.equals(other.foodName))
            return false;
        if (ingredientes == null) {
            if (other.ingredientes != null)
                return false;
        } else if (!ingredientes.equals(other.ingredientes))
            return false;
        if (kalories == null) {
            if (other.kalories != null)
                return false;
        } else if (!kalories.equals(other.kalories))
            return false;
        if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
            return false;
        return true;
    }
    
}
