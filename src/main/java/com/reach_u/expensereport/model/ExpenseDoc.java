package com.reach_u.expensereport.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
/**
 * Model for expense documents (plane tickets, hotel bills etc.)
 *
 ** The expense report will consist of one or more expense documents.
 */

@Entity
@Table(name="expensedoc")
@Data
public class ExpenseDoc {

    private int reportId; //which report this document belongs to

    @Id
    @GeneratedValue
    private int docId; //document's ID in the current report

    @Column(name = "date")
    private Date date;

    @Column(name = "issuer")
    private String issuer;

    @Column(name = "content")
    private String content;

    @Column(name = "field")
    private String field;

    @Column(name = "project")
    private String project;

    @Column(name = "sum")
    private double sum;

    @Column(name = "currency")
    private Currency currency;

    @Column(name = "creditcard")
    private boolean creditCard;

    public ExpenseDoc(Date date, String issuer, String content, String field, String project, double sum, Currency currency, boolean creditCard) {
        this.date = date;
        this.issuer = issuer;
        this.content = content;
        this.field = field;
        this.project = project;
        this.sum = sum;
        this.currency = currency;
        this.creditCard = creditCard;
    }

    public ExpenseDoc() {
        this.date = new Date();
    }

    public double getSumEur() {
        return sum*currency.getRate();
    }
}
