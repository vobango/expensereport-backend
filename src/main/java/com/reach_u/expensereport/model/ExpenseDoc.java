package com.reach_u.expensereport.model;

import java.util.Date;

/**
 * Model for expense documents (plane tickets, hotel bills etc.)
 *
 ** The expense report will consist of one or more expense documents.
 */
public class ExpenseDoc {

    private int reportId; //which report this document belongs to
    private int docId; //document's ID in the current report
    private String date;
    private String issuer;
    private String content;
    private String field;
    private String project;
    private double sum;
    private Currency currency;
    private boolean creditCard;

    public ExpenseDoc(String date, String issuer, String content, String field, String project, double sum, Currency currency, boolean creditCard) {
        this.date = date;
        this.issuer = issuer;
        this.content = content;
        this.field = field;
        this.project = project;
        this.sum = sum;
        this.currency = currency;
        this.creditCard = creditCard;
    }

    public ExpenseDoc() {}

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getDate() {
        return date;
    }

    public String getIssuer() {
        return issuer;
    }

    public String getContent() {
        return content;
    }

    public String getField() {
        return field;
    }

    public String getProject() {
        return project;
    }

    public double getSum() {
        return sum;
    }

    public double getSumEur() {
        return sum*currency.getRate();
    }

    public Currency getCurrency() {
        return currency;
    }

    public boolean getCreditCard() {
        return creditCard;
    }
}
