package com.web.portfolio.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Portfolio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer amount;

    @Column
    private Double cost;

    @Column
    private Date date = new Date();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Investor_id", referencedColumnName = "id")
    @JsonIgnoreProperties("portfolios")
    private Investor investor;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Tstock_ID",
            foreignKey = @ForeignKey(name = "tStock_fk",
                    value = ConstraintMode.CONSTRAINT))
    private Tstock tstock;
    
    

}
