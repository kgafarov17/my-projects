package wm2.as3.login_app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Country {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Country was not provided!")
    @Column(name = "COUNTRY")
    private String a_country;

    @NotBlank(message="Capital was not provided!")
    @Column(name = "CAPITAL")
    private String b_capital;

    @NotBlank(message="Currency was not provided!")
    @Column(name = "CURRENCY")
    private String currency;

    public Country() {
    }

    public Country(String a_country, String b_capital) {
        this.a_country = a_country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getA_country() {
        return a_country;
    }

    public void setA_country(String a_country) {
        this.a_country = a_country;
    }

    public String getB_capital() {
        return b_capital;
    }

    public void setB_capital(String b_capital) {
        this.b_capital = b_capital;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
