package com.web.portfolio.controller;

import com.web.portfolio.entity.Classify;
import com.web.portfolio.entity.Investor;
import com.web.portfolio.entity.Watch;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio/classify")
public class ClassifyController {
    
    @PersistenceContext
    protected EntityManager em;
    
    @GetMapping(value = {"/", "/query"})
    public List<Classify> query() {
        Query query = em.createQuery("select c from Classify c");
        List<Classify> list = query.getResultList();
        return list;
    }
    
    @GetMapping(value = {"/{id}", "/get/{id}"})
    @Transactional
    public Classify get(@PathVariable("id") Long id) {
        Classify classify = em.find(Classify.class, id);
        if(classify != null && classify.gettStocks() != null && classify.gettStocks().size() > 0) {
            classify.gettStocks().size();
        }
        return classify;
    }
    
    @PostMapping(value = {"/", "/add"})
    @Transactional
    public Classify add(@RequestBody Map<String, String> map) {
        Classify classify = new Classify();
        classify.setName(map.get("name"));
        classify.setTransaction(Boolean.parseBoolean(map.get("transaction")));
        em.persist(classify);
        // 取得最新 id
        em.flush();
        Long id = classify.getId();
        return get(id);
    }
    
    @PutMapping(value = {"/{id}", "/update/{id}"})
    @Transactional
    public Boolean update(@PathVariable("id") Long id, @RequestBody Map<String, String> map) {
        Classify o_classify = get(id);
        if (o_classify == null) {
            return false;
        }
        o_classify.setName(map.get("name"));
        o_classify.setTransaction(Boolean.parseBoolean(map.get("transaction")));

        em.persist(o_classify);
        em.flush();
        return true;
    }
    
    @DeleteMapping(value = {"/{id}", "/delete/{id}"})
    @Transactional
    public Boolean delete(@PathVariable("id") Long id) {
        em.remove(get(id));
        em.flush();
        return get(id) == null ? true : false;
    }
}
