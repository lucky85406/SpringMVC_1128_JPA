
package com.web.portfolio.controller;

import com.web.portfolio.entity.Investor;
import com.web.portfolio.service.EmailService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio/forget")
public class ForgetController {

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    EmailService emailService;

    @GetMapping(value = {"/", "/query"})
    public List<Investor> query() {
        Query query = em.createQuery("select i from Investor i");
        List<Investor> list = query.getResultList();
        return list;
    }

    @GetMapping(value = {"/{email}", "/get/{email}"})
    public Investor get(@PathVariable("email") String email) {
        System.out.println("get");
        String sql = "Select i.id From Investor i Where i.email =:email";
        Query query = em.createQuery(sql);
        query.setParameter("email", email+".com");
        Long id = (Long) query.getSingleResult();
        Investor investor = em.find(Investor.class,id);
        System.out.println("out");
        if (investor != null && investor.getPortfolios() != null && investor.getPortfolios().size() > 0) {
            investor.getPortfolios().size();
        }
        if (investor != null && investor.getWatchs() != null && investor.getWatchs().size() > 0) {
            investor.getWatchs().size();
        }

        return investor;
    }

    @PutMapping(value = {"/", "/send/{email}"})
    public Boolean send(@PathVariable("email") String email, @RequestBody Map<String, String> map) {
        System.out.println("in");
        emailService.forgetEmail(get(email));
        System.out.println("OK");
        return true;
    }
}
