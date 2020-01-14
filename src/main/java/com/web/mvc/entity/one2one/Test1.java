package com.web.mvc.entity.one2one;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.mvc.entity.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

public class Test1 {
    static EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    public static void main(String[] args) throws Exception {
        //add("老李");
        //get(1L);
        query();
    }
    
    public static void add(String name) {
        Person person = new Person();
        person.setName(name);
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        System.out.println("Add OK !");
    }
    
    public static void get(Long id) throws Exception {
        Person person = em.find(Person.class, id);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(person);
        System.out.println(json);
    }
    
    public static void query() throws Exception {
        List<Person> list = em.createQuery("Select p From Person p", Person.class).getResultList();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        System.out.println(json);
    }
}
