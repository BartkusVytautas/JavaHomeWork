package bit.lt.Entities;

import javax.persistence.*;

@Entity
@Table(name = "kmi")
public class KMI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "kmi")
    private Double kmi;

    public KMI() {
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {

        this.height = height;
        this.kmi = KMIcalculation();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {

        this.weight = weight;
        this.kmi = KMIcalculation();
    }

    public Double KMIcalculation(){
        if(this.weight !=null && this.height != null) {
            return (Math.round((this.weight / (this.height * this.height)) * 100) / (double) 100);
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getKmi() {
        return kmi;
    }

    public void setKmi(Double kmi) {
        this.kmi = kmi;
    }
}
