package org.trahim.data.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "budget", schema = "fin")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Long getBudjetId() {
        return budjetId;
    }

    public void setBudjetId(Long budjetId) {
        this.budjetId = budjetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(BigDecimal goalAmount) {
        this.goalAmount = goalAmount;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
