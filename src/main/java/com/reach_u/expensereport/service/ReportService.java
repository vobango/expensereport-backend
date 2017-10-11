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
    private static List<ExpenseDoc> documents = new ArrayList<>();
    private AtomicInteger reportCounter = new AtomicInteger();
    private AtomicInteger expenseDocCounter = new AtomicInteger();


    /*
     * Dummy data creation for testing purposes
     */
    {
        //Create a new Report and add to list
       reports.add(new Report("Aino Ainus", new Date(), new Date()));

        //Create two Expense documents and add them to the report
       documents.add(new ExpenseDoc(new Date(), "Radisson", "Housing", "Testing", "ExpRep", 150, Currency.GBP, true));
       documents.add(new ExpenseDoc(new Date(), "EasyJet", "Travel", "Testing", "ExpRep", 100, Currency.EUR, false));
       reports.get(0).setDocuments(documents);

       //Set IDs for Report and Expense documents
       for (Report report : reports) {
           report.setReportId(reportCounter.incrementAndGet());
           for (ExpenseDoc doc : report.getDocuments()) {
               doc.setReportId(reportCounter.get());
               doc.setDocId(expenseDocCounter.incrementAndGet());
           }
       }
    }


    //Method for getting all Reports with GET
    public List<Report> list() {
        return reports;
    }

    //Method for getting a single Report with GET
    public Report get(int reportId) {
        for (Report r : reports) {
            if (r.getReportId() == reportId) {
                return r;
            }
        }
        return null;
    }

    //Method for POST request
    public Report create(Report report) {
        AtomicInteger docCounter = new AtomicInteger();
        report.setReportId(reportCounter.incrementAndGet());
        for (ExpenseDoc doc : report.getDocuments()) {
            doc.setDocId(docCounter.incrementAndGet());
            doc.setReportId(reportCounter.get());
        }
        reports.add(report);
        return report;
    }
}
