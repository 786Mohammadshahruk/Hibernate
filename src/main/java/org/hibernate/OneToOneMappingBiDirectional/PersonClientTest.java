package org.hibernate.OneToOneMappingBiDirectional;

public class PersonClientTest {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        //personDao.addPerson(getPerson());
        //personDao.getPerson(1);
        //personDao.updatePerson(1);
        //personDao.deletePerson(1);


        personDao.getAddress(52);
    }

    private static Person getPerson() {
        Address address = new Address();
        address.setCity("Mumbai");
        address.setStreet("Mumbai");

        Person person = new Person();
        person.setName("Aman Kumar");
        person.setAddress(address);
        return person;
    }
}
