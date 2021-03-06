package com.reach_u.expensereport.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
/**
 * Model for expense documents (plane tickets, hotel bills etc.)
 *
 ** The expense report will consist of one or more expense documents.
 */

@Embeddable
@Data
public class ExpenseDoc {

    @GeneratedValue
    private int docId; //document's ID in the current report

    private Date date;

    private String issuer;

    private String content;

    private String field;

    private String project;

    private double sum;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private boolean creditCard;

    private double sumEur;

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
    }

    public double getSumEur() {
        return sumEur;
    }
    public void setSumEur() {
        sumEur = sum*currency.getRate();
    }
}
