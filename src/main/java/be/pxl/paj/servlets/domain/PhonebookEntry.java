package be.pxl.paj.servlets.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "findPhonenumberByName", query="SELECT p FROM PhonebookEntry p WHERE p.firstName = :firstName AND p.lastName = :lastName")
})
public class PhonebookEntry {


    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public PhonebookEntry() {
    }

    public Long getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
