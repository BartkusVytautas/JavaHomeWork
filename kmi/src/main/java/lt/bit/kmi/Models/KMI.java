package lt.bit.kmi.Models;

public class KMI {

    private Double height;
    private Double weight;

    public KMI() {
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double KMIcalculation(){
        return this.weight / (this.height * this.height);
    }
}
