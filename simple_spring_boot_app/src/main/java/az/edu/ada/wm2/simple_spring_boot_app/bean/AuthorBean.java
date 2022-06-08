package az.edu.ada.wm2.simple_spring_boot_app.bean;

public class AuthorBean {
    private String a_firstName;
    private String b_lastName;
    private String country;

    public AuthorBean() {
    }

    public AuthorBean(String a_firstName, String b_lastName, String country) {
        this.a_firstName = a_firstName;
        this.b_lastName = b_lastName;
        this.country = country;
    }

    public String getA_firstName() {
        return a_firstName;
    }

    public void setA_firstName(String a_firstName) {
        this.a_firstName = a_firstName;
    }

    public String getB_lastName() {
        return b_lastName;
    }

    public void setB_lastName(String b_lastName) {
        this.b_lastName = b_lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
