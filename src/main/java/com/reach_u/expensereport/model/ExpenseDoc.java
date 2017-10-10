package com.reach_u.expensereport.model;

import java.util.Date;

/**
 * Model for expense documents (plane tickets, hotel bills etc.)
 *
 ** The expense report will consist of one or more expense documents.
 */
public class ExpenseDoc {

    private int reportId;
    private int docId;
    private Date date;
    private String issuer;
    private String content;
    private String field;
    private String project;
    private int sum;
    private String currency;
    private boolean creditCard;

    public ExpenseDoc(int reportId, Date date, String issuer, String content, String field, String project, int sum, String currency, boolean creditCard) {
        this.reportId = reportId;
        this.date = date;
        this.issuer = issuer;
        this.content = content;
        this.field = field;
        this.project = project;
        this.sum = sum;
        this.currency = currency;
        this.creditCard = creditCard;
    }

    public int getReportId() {
        return reportId;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public Date getDate() {
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

    public int getSum() {
        return sum;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean creditCardUsed() {
        return creditCard;
    }
}
