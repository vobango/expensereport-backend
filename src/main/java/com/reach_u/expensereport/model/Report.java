package com.reach_u.expensereport.model;

import java.util.*;

public class Report {

    private int reportId;
    private String employee;
    private Date startDate;
    private Date endDate;
    private List<ExpenseDoc> documents = new ArrayList<>();
    private double creditSum;
    private double expenseSum;
    private double totalSum;
    private String status;

    public Report(String employee,Date startDate, Date endDate) {
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

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public List<ExpenseDoc> getDocuments() {
        return documents;
    }

    public void setDocuments(ExpenseDoc document) {
        documents.add(document);
        if (document.creditCardUsed()) {
            this.setCreditSum(document.getSum());
        }
        else {
            this.setExpenseSum(document.getSum());
            this.totalSum += expenseSum;
        }
    }

    public double getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(double sum) {
        creditSum += sum;
    }

    public double getExpenseSum() {
        return expenseSum;
    }

   public void setExpenseSum(double sum) {
        expenseSum += sum;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status.toUpperCase();
    }
}
