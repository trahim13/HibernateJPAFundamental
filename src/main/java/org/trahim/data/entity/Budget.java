package org.trahim.data.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "budget", schema = "fin")
public class Budget {

    @Id
    @GeneratedValue
    @Column(name = "BUDGET_ID")
    private Long budjetId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GOAL_AMOUNT")
    private BigDecimal goalAmount;

    @Column(name = "PERIOD")
    private String period;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="BUDGET_TRANSACTION", joinColumns = @JoinColumn(name = "BUDGET_ID"),
            inverseJoinColumns = @JoinColumn(name = "TRANSACTION_ID"))
    private List<Transaction> transactions = new ArrayList<>();
}
