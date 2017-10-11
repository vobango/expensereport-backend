package com.reach_u.expensereport.model;

import java.text.SimpleDateFormat;
import java.util.*;

public class Report {

    private int reportId;
    private String employee;
    private Date startDate;
    private Date endDate;
    private List<ExpenseDoc> documents = new ArrayList<>();
    private double expenseSum; //employee's total expenses
    private double creditSum; //amount paid with credit card
    private double totalSum; //amount to be paid to employee = expenseSum - creditSum (in €)
    private String status;

    public Report(String employee, Date startDate, Date endDate) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "ACTIVE";
    }

    public Report() {
        this.status = "ACTIVE";
        this.startDate = new Date();
        this.endDate = new Date();
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getEmployee() {
        return employee;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public List<ExpenseDoc> getDocuments() {
        return documents;
    }

    public void setDocuments(List<ExpenseDoc> documents) {
        for (ExpenseDoc doc : documents) {
            this.documents.add(doc);
            if (doc.getCreditCard()) {
                this.setCreditSum(doc.getSumEur());
                this.setExpenseSum(doc.getSumEur());
            } else {
                this.setExpenseSum(doc.getSumEur());
                this.setTotalSum(doc.getSumEur());
            }
        }
    }

    public double getCreditSum() { return creditSum; }

    public void setCreditSum(double sum){ creditSum += sum; }

    public double getExpenseSum() { return expenseSum; }

   public void setExpenseSum(double sum) { expenseSum += sum; }

    public double getTotalSum() { return totalSum; }

    public void setTotalSum(double sum) { this.totalSum += sum; }

    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status.toUpperCase();
    }
}
