
package com.web.portfolio.controller;

import com.web.portfolio.entity.Investor;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/portfolio")
public class LoginController {

    @PersistenceContext
    protected EntityManager em;

    @RequestMapping(value = {"/login"})
    public String login(HttpSession session,
            @RequestHeader(value = "referer", required = false) String referer,
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        System.out.println("login---" + referer);
        try {
            String sql = "Select i From Investor i Where i.pass=true And i.username=:username";
            Investor investor = em.createQuery(sql, Investor.class)
                    .setParameter("username", username)
                    .getSingleResult();

            if (investor != null && investor.getPassword().equals(password)) {
                session.setAttribute("investor", investor);
                session.setAttribute("watch_id", investor.getWatchs().iterator().next().getId());
                if (referer.contains("login.jsp")) {
                    return "redirect:/portfolio/index.jsp";
                }
                return "redirect:" + referer;
            }
            if (investor == null) {
                return "redirect:/portfolio/regist.jsp";
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        session.invalidate();
        return "redirect:/portfolio/login.jsp";
    }

    @RequestMapping(value = {"/regist"})
    public String regist() {
        return "redirect:/portfolio/regist.jsp";
    }

    @RequestMapping(value = {"/logout"})
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/portfolio/login.jsp";
    }

    @GetMapping("/verify/{id}/{code}")
    @Transactional
    public String verify(@PathVariable("id") Long id, @PathVariable("code") String code, Model model) {
        String message = "ERROR";
        Investor investor = em.find(Investor.class, id);
        if (investor.getCode().equals(code)) {
            investor.setPass(Boolean.TRUE);
            em.persist(investor);
            message = "SUCCESS";
        }
        return "redirect:/portfolio/verify.jsp?message=" + message;
    }

}
