package com.reach_u.expensereport.model;

import java.util.*;
import com.reach_u.expensereport.*;

public class Report {

    private int reportId;
    private String employee;
    private Date startDate;
    private Date endDate;
    private List<ExpenseDoc> documents = new List<ExpenseDoc>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<ExpenseDoc> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] ts) {
            return null;
        }

        @Override
        public boolean add(ExpenseDoc expenseDoc) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends ExpenseDoc> collection) {
            return false;
        }

        @Override
        public boolean addAll(int i, Collection<? extends ExpenseDoc> collection) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public ExpenseDoc get(int i) {
            return null;
        }

        @Override
        public ExpenseDoc set(int i, ExpenseDoc expenseDoc) {
            return null;
        }

        @Override
        public void add(int i, ExpenseDoc expenseDoc) {

        }

        @Override
        public ExpenseDoc remove(int i) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<ExpenseDoc> listIterator() {
            return null;
        }

        @Override
        public ListIterator<ExpenseDoc> listIterator(int i) {
            return null;
        }

        @Override
        public List<ExpenseDoc> subList(int i, int i1) {
            return null;
        }
    };
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
