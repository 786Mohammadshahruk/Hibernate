package org.hibernate.OneToOneUniDirectional;

import jakarta.persistence.*;

@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_number")
    private String orderNumber;

    /*@OneToOne(mappedBy = "order")
    private Person person;*/

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /*public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }*/

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderNumber='" + orderNumber + '\'' +
               /* ", person=" + person +*/
                '}';
    }
}
