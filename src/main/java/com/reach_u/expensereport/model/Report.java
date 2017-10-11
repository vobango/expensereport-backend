package com.reach_u.expensereport.model;

import java.util.*;

public class Report {

    private int reportId;
    private String employee;
    private String startDate;
    private String endDate;
    private List<ExpenseDoc> documents = new ArrayList<>();
    private double creditSum; //amount paid with credit card
    private double expenseSum; //employee's own expenses
    private double totalSum; //amount to be paid to employee = expenseSum - creditSum (in €)
    private String status;

    public Report(String employee,String startDate, String endDate) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "ACTIVE";
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

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public List<ExpenseDoc> getDocuments() {
        return documents;
    }

    public void setDocuments(ExpenseDoc document) {
        documents.add(document);
        if (document.creditCardUsed()) {
            this.setCreditSum(document.getSumEur());
            this.setExpenseSum(document.getSumEur());
        }
        else {
            this.setExpenseSum(document.getSumEur());
            this.setTotalSum(document.getSumEur());
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
