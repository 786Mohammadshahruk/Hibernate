package org.hibernate.OneToOneUniDirectional;

public class PersonClientTest {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        //personDao.createPerson(getPerson());
        //personDao.deletePerson(1);
        personDao.deleteOrder(2);
    }

    private static Person getPerson() {
        Order order = new Order();
        order.setOrderNumber("77895");

        Person person = new Person();
        person.setFirstName("Ola");
        person.setLastName("Hansen");
        person.setOrder(order);
        person.setAge(21);
        return person;
    }
}
