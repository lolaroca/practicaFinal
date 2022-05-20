package como.lolaroca.practicaFinal.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("PEDIDO")
public class PedidoModel {
    @Id
    @Column("PEDIDO_ID")
    private Long pedidoId;

    @Column("PEDIDO_NAME")
    private String pedidoName;

    @Column("FOOD_ID")
    private Long foodId;

    @Column("PRICE_PEDIDO")
    private float pricePedido;

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getPedidoName() {
        return pedidoName;
    }

    public void setPedidoName(String pedidoName) {
        this.pedidoName = pedidoName;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public float getPricePedido() {
        return pricePedido;
    }

    public void setPricePedido(float pricePedido) {
        this.pricePedido = pricePedido;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((foodId == null) ? 0 : foodId.hashCode());
        result = prime * result + ((pedidoId == null) ? 0 : pedidoId.hashCode());
        result = prime * result + ((pedidoName == null) ? 0 : pedidoName.hashCode());
        result = prime * result + Float.floatToIntBits(pricePedido);
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
        PedidoModel other = (PedidoModel) obj;
        if (foodId == null) {
            if (other.foodId != null)
                return false;
        } else if (!foodId.equals(other.foodId))
            return false;
        if (pedidoId == null) {
            if (other.pedidoId != null)
                return false;
        } else if (!pedidoId.equals(other.pedidoId))
            return false;
        if (pedidoName == null) {
            if (other.pedidoName != null)
                return false;
        } else if (!pedidoName.equals(other.pedidoName))
            return false;
        if (Float.floatToIntBits(pricePedido) != Float.floatToIntBits(other.pricePedido))
            return false;
        return true;
    }

}
