package com.reach_u.expensereport.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.OverridesAttribute;
import java.util.*;

@Entity
@Table(name = "reports")
@Data
public class Report {

    @Id
    @GeneratedValue
    private int reportId;

    private String employee;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
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

    /*
    public void setDocuments(List<ExpenseDoc> documents) {
        for (ExpenseDoc doc : documents) {
            this.documents.add(doc);
            if (doc.isCreditCard()) {
                this.setCreditSum(doc.getSumEur());
                this.setExpenseSum(doc.getSumEur());
            } else {
                this.setExpenseSum(doc.getSumEur());
            }
        }
    }*/

    public void setCreditSum(double sum){ creditSum += sum; }

    public void setExpenseSum(double sum) { expenseSum += sum; }

    public double getTotalSum() { return getExpenseSum()-getCreditSum(); } //amount to be paid to employee = expenseSum - creditSum (in €)
}
