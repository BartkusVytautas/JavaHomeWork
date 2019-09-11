package lt.bit.CRM.Entities;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity

@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotNull(message = "field is required")
    @Size(min = 4, max = 15, message = "Name should be 4-15 characters long")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Invalid format")
    private String name;

    @NotNull(message = "field is required")
    @Size(max = 50, message = "Address should have maximum 50 characters")
    @Column(name = "adress")
    private String adress;

    @Size(max = 10, message = "Vat code should have maximum 10 characters")
    @Column(name = "vat_code")
    private String vat_code;

    @NotNull(message = "field is required")
    @Size(min = 4, max = 15, message = "Company name should be 4-15 characters long")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Invalid format")
    @Column(name = "company_name")
    private String company_name;

    @NotNull(message = "field is required")
    @Size(min = 12, max = 12, message = "Phone should have 12 symbols")
    @Pattern(regexp = "^[+]\\d{11}$", message = "Invalid format")
    @Column(name = "phone")
    private String phone;

    @NotNull(message = "field is required")
    @Email(message = "Invalid format")
    @Size(max = 25, message = "Email should have maximum 25 characters")
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "company", cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Costumer> costumers = new HashSet<>();


    public Company() {
    }

    public Company(String name, String adress, String vat_code, String company_name, String phone, String email) {
        this.name = name;
        this.adress = adress;
        this.vat_code = vat_code;
        this.company_name = company_name;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return adress;
    }

    public String getVat_code() {
        return vat_code;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setVat_code(String vat_code) {
        this.vat_code = vat_code;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public Set<Costumer> getCostumers() {
        return costumers;
    }

    public void setCostumers(Set<Costumer> costumers) {
        this.costumers = costumers;
    }
}
