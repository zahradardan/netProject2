package ir.asta.training.contacts.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Case")
public class Case {

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

    @Basic
    @Column(name="submitter")
    public String getSubmitter() {
        return submitter;
    }
    public void setSubmitter(String submitter ) {
        this.submitter =submitter ;
    }

    @Basic
    @Column(name="topic")
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Basic
    @Column(name="description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description =description ;
    }

    @Basic
    @Column(name="status")
    public String getStatus() {
        return status;
    }
    public void setStatus(String status ) {
        this.status =status ;
    }

    @Basic
    @Column(name="refer")
    public String getRefer() {
        return refer;
    }
    public void setRefer(String refer) {
        this.refer =refer;
    }

    @Basic
    @Column(name="date")
    public String getDate() {
        return date;
    }
    public void setDate(String date ) {
        this.date = date;
    }
}