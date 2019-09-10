package entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable( name = "costumer_item",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name="costumer_id")
    )
    private
    Set<Costumer> costumers;

    public Item() {
    }

    public Item(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Costumer> getCostumers() {
        return costumers;
    }

    public void setCostumers(Set<Costumer> costumers) {
        this.costumers = costumers;
    }
}
