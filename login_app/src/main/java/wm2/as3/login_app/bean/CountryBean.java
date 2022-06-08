package wm2.as3.login_app.bean;

public class CountryBean {
    private String a_country;
    private String b_capital;
    private String currency;

    public CountryBean() {
    }

    public CountryBean(String a_country, String b_capital, String currency) {
        this.a_country = a_country;
        this.b_capital = b_capital;
        this.currency = currency;
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
