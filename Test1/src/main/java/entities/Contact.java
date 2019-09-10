package entities;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contact_information")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @Column(name = "conversation")
    private String conversation;

    @ManyToOne
    @JoinColumn(name = "costumer_id", nullable = false)
    private Costumer costumer;


    public Contact() {
    }

    public Contact(String conversation) {
        this.conversation = conversation;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public Integer getId() {
        return id;
    }


    public Date getDate() {
        return date;
    }

    public String getConversation() {
        return conversation;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public void setConversation(String conversation) {
        this.conversation = conversation;
    }
}
