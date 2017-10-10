package com.reach_u.expensereport.model;

import java.util.*;
import com.reach_u.expensereport.*;

public class Report {

    private int reportId;
    private String employee;
    private Date startDate;
    private Date endDate;
    private List<ExpenseDoc> documents = new ArrayList<>();
    private int creditSum;
    private int expenseSum;
    private int totalSum = expenseSum - creditSum;

    public Report(String employee,Date startDate, Date endDate) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getReportId() {
        return reportId;
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
    }

    public int getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(int sum) {
        creditSum += sum;
    }

    public int getExpenseSum() {
        return expenseSum;
    }

    public void setExpenseSum(int sum) {
        expenseSum += sum;
    }

    public int getTotalSum() {
        return totalSum;
    }

}
