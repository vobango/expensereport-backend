package com.reach_u.expensereport.service;

import com.reach_u.expensereport.model.*;
import com.reach_u.expensereport.model.Currency;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Database "replacement" for expense reports
 *
 ** Stores all reports in a list.
 *
 ** Adds methods for using report list / single report data.
 */
public class ReportService {
    private static List<Report> reports = new ArrayList<>();
    private AtomicInteger reportCounter = new AtomicInteger();
    private AtomicInteger expenseDocCounter = new AtomicInteger();

    /**
     * Dummy data for testing purposes
     */
    {
       reports.add(new Report("Aino Ainus", new SimpleDateFormat("dd.MM.yy").format(new Date()), new SimpleDateFormat("dd.MM.yy").format(new Date())));
       for (int i=0; i < reports.size();i++) {
           reports.get(i).setReportId(reportCounter.incrementAndGet());
       }
       reports.get(0).setDocuments(new ExpenseDoc(reportCounter.get(),expenseDocCounter.incrementAndGet(), new SimpleDateFormat("dd.MM.yy").format(new Date()), "Radisson", "Housing", "Testing", "ExpRep", 150, Currency.GBP, false));
       reports.get(0).setDocuments(new ExpenseDoc(reportCounter.get(),expenseDocCounter.incrementAndGet(),  new SimpleDateFormat("dd.MM.yy").format(new Date()), "EasyJet", "Travel", "Testing", "ExpRep", 100, Currency.EUR, false));
    }

    public List<Report> list() {
        return reports;
    }

    public Report get(int reportId) {
        for (Report r : reports) {
            if (r.getReportId() == reportId) {
                return r;
            }
        }
        return null;
    }
}
