package ir.asta.training.contacts.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="CaseTB")
public class CaseEntity {

    long caseID;
    String submitter;
    String topic;
    String description;
    String status;
    String refer;
    String date;


    @Id
    @Column(name = "CaseID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getId() {
        return caseID;
    }
    public void setId(long id) {
        this.caseID = id;
    }

    @Column(name="submitter")
    public String getSubmitter() {
        return submitter;
    }
    public void setSubmitter(String submitter ) {
        this.submitter =submitter ;
    }

    @Column(name="topic")
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description =description ;
    }

    @Column(name="status")
    public String getStatus() {
        return status;
    }
    public void setStatus(String status ) {
        this.status =status ;
    }

    @Column(name="refer")
    public String getRefer() {
        return refer;
    }
    public void setRefer(String refer) {
        this.refer =refer;
    }

    @Column(name="date")
    public String getDate() {
        return date;
    }
    public void setDate(String date ) {
        this.date = date;
    }
}