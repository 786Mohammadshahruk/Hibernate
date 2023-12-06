package org.hibernate.OneToOneMappingBiDirectional;

import jakarta.persistence.*;

@Entity
@Table(name = "address_table")
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
