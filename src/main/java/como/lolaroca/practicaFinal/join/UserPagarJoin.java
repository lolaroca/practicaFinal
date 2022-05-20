package como.lolaroca.practicaFinal.join;

public class UserPagarJoin {
    private Long userId;
    private String username;
    private String password;
    private String email;
    private String country;
    private String address;
    private Long cardNumber;;
    private String cardName;
    private Float pricePedido;

    public UserPagarJoin(Long userId, String username, String password, String email, String country, String address,
            Long cardNumber, String cardName, Float pricePedido) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.country = country;
        this.address = address;
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.pricePedido = pricePedido;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
    public Long getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getCardName() {
        return cardName;
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    public Float getPricePedido() {
        return pricePedido;
    }
    public void setPricePedido(Float pricePedido) {
        this.pricePedido = pricePedido;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        UserPagarJoin other = (UserPagarJoin) obj;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }
}
