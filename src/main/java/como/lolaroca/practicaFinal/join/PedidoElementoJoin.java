package como.lolaroca.practicaFinal.join;

public class PedidoElementoJoin {
        private Long pedidoId;
        private String pedidoName;
        private Long foodId;
        private Float pricePedido;
        private String foodName;
        private Float priceElemento;
        private String ingredients;
        private Long kalories;
        public PedidoElementoJoin() {
        }
        public PedidoElementoJoin(Long pedidoId, String pedidoName, Long foodId, Float pricePedido, String foodName, Float priceElemento, String ingredients, Long kalories) {
            this.pedidoId = pedidoId;
            this.pedidoName = pedidoName;
            this.foodId = foodId;
            this.pricePedido = pricePedido;
            this.foodName = foodName;
            this.priceElemento = priceElemento;
            this.ingredients = ingredients;
            this.kalories = kalories;
        }
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
        public Float getPricePedido() {
            return pricePedido;
        }
        public void setPricePedido(Float pricePedido) {
            this.pricePedido = pricePedido;
        }
        public String getFoodName() {
            return foodName;
        }
        public void setFoodName(String foodName) {
            this.foodName = foodName;
        }
        public Float getPriceElemento() {
            return priceElemento;
        }
        public void setPriceElemento(Float priceElemento) {
            this.priceElemento = priceElemento;
        }
        public String getIngredients() {
            return ingredients;
        }
        public void setIngredients(String ingredients) {
            this.ingredients = ingredients;
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
            result = prime * result + ((pedidoId == null) ? 0 : pedidoId.hashCode());
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
            PedidoElementoJoin other = (PedidoElementoJoin) obj;
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
            return true;
        }
    
        
 }

