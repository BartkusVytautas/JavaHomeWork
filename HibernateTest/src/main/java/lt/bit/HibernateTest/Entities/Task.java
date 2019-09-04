package lt.bit.HibernateTest.Entities;


import javax.persistence.*;

@Entity
@Table(name = "tasks")

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    Integer id;
    @Column(name = "name")
    private
    String name;
    @Column(name = "status_id")
    private
    Integer statusId;

    public Task() {
    }



    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
}
