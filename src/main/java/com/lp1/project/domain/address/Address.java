package java.com.lp1.project.domain.address;

public class Address {
    private String cep;
    private State state;
    private String city;
    private String neighbor;
    private String street;
    private String number;
    private String complement;

    public Address(String cep, State state, String city, String neighbor,
                   String street, String number, String complement) {
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.neighbor = neighbor;
        this.street = street;
        this.number = number;
        this.complement = complement;
    }

    public String getCep() {
        return cep;
    }

    public State getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getNeighbor() {
        return neighbor;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

}
