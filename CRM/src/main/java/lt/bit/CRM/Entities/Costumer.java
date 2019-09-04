package lt.bit.CRM.Entities;


import javax.persistence.*;

@Entity
@Table(name = "costumers")
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "position")
    private String position;

    @Column(name = "company_id")
    private Integer company_id;

    public Costumer() {
    }

    public Costumer(String name, String surname, String phone, String email, String address, String position, Integer company_id) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.company_id = company_id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPosition() {
        return position;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }
}
