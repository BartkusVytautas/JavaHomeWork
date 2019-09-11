package lt.bit.CRM.Entities;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "costumers")
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "field is required")
    @Size(min = 4, max = 15, message = "Name should be 4-15 characters long")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Invalid format")
    @Column(name = "name")
    private String name;

    @NotNull(message = "field is required")
    @Size(min = 4, max = 15, message = "Surname should be 4-15 characters long")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Invalid format")
    @Column(name = "surname")
    private String surname;

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

    @NotNull(message = "field is required")
    @Size(max = 50, message = "Address should have maximum 50 characters")
    @Column(name = "address")
    private String address;

    @NotNull(message = "field is required")
    @Size(max = 20, message = "Position should have maximum 20 characters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Invalid format")
    @Column(name = "position")
    private String position;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "company_id", nullable = true )
    private Company company;

    @OneToMany(mappedBy = "costumer")
    private Set<Contact> contacts = new HashSet<>();

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "costumer_item",
            joinColumns = @JoinColumn(name = "costumer_id"),
            inverseJoinColumns = @JoinColumn(name="item_id"))
    private Set<Item> items;



    public Costumer() {
    }

    public Costumer(String name, String surname, String phone, String email, String address, String position) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;

    }

    public Company getCompany() {
        return company;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

}
