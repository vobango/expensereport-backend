package com.reach_u.expensereport.model;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "reports")
@Data
public class Report {

    @Id
    @GeneratedValue
    private int reportId;

    private String employee;

    private Date startDate;

    private Date endDate;

    @ElementCollection
    @CollectionTable(joinColumns = @JoinColumn(name = "Id"))
    private List<ExpenseDoc> documents = new ArrayList<>();

    @Column(nullable = true)
    private double expenseSum; //employee's total expenses

    @Column(nullable = true)
    private double creditSum; //amount paid with credit card

    @Enumerated(EnumType.STRING)
    private ReportStatus status;

    @Column(nullable = true)
    private double totalSum; //expenseSum - creditSum (in €)

    public Report(String employee, Date startDate, Date endDate) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = ReportStatus.Active;
    }

    public Report() {
        this.startDate = new Date();
        this.endDate = new Date();
        this.status = ReportStatus.Active;
    }

    public void setCreditSum(double sum) {
        creditSum += sum;
    }

    public void setExpenseSum(double sum) {
        expenseSum += sum;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum() {
        totalSum = getExpenseSum() - getCreditSum();
    }
}
