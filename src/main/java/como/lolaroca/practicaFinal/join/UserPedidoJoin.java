package como.lolaroca.practicaFinal.join;

public class UserPedidoJoin {
    private String username;
    private String email;
    private String country;
    private String address;
    private Long pedidoId; //Compartido por ambos
    private String pedidoName;
    private Long foodId;
    private float pricePedido;



    public UserPedidoJoin(String username, String email, String country, String address, Long pedidoId,String pedidoName, Long foodId, float pricePedido) {
        this.username = username;
        this.email = email;
        this.country = country;
        this.address = address;
        this.pedidoId = pedidoId;
        this.pedidoName = pedidoName;
        this.foodId = foodId;
        this.pricePedido = pricePedido;
    }



    public UserPedidoJoin(long long1, String string, String string2, long long2, long long3, String string3,
            float float1) {
    }


    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public String getCountry() {
        return country;
    }



    public void setCountry(String country) {
        this.country = country;
    }



    public String getAddress() {
        return address;
    }



    public void setAddress(String address) {
        this.address = address;
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
        UserPedidoJoin other = (UserPedidoJoin) obj;
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



    @Override
    public String toString() {
        return "Pedido del usuario [dirección=" + address + ", country=" + country + ", email=" + email + ", foodId=" + foodId
                + ", pedidoId=" + pedidoId + ", pedidoName=" + pedidoName + ", pricePedido=" + pricePedido
                + ", username=" + username + "]";
    }
    
}