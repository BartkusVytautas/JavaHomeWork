package lt.bit.CRM.Entities;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contact_information")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "costumer_id")
    private Integer costumer_id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @Column(name = "conversation")
    private String conversation;

    public Contact() {
    }

    public Contact(Integer costumer_id, String conversation) {
        this.costumer_id = costumer_id;
        this.conversation = conversation;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCostumer_id() {
        return costumer_id;
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

    public void setCostumer_id(Integer costumer_id) {
        this.costumer_id = costumer_id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setConversation(String conversation) {
        this.conversation = conversation;
    }
}
