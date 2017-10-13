package com.reach_u.expensereport.service;

import com.reach_u.expensereport.Repository.ReportRepository;
import com.reach_u.expensereport.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Methods for using report list / single report data.
 */
@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;

    AtomicInteger docIdCounter = new AtomicInteger();

    //Add an empty report to database with current date, status "Active" and empty expense document for testing purposes
    /*public String initialize() {
        Report test = new Report();
        List<ExpenseDoc> docs = test.getDocuments();
        docs.add(new ExpenseDoc());
        for (ExpenseDoc doc : docs) {
            doc.setDocId(docIdCounter.incrementAndGet());
        }
        docIdCounter.set(0);
        test.setDocuments(docs);
        reportRepository.save(test);
        return "Saved";
    }*/

    //Method for getting all Reports with GET
    public List<Report> list() {
        List<Report> reports = new ArrayList<>();
        for (Report report : reportRepository.findAll()) {
            reports.add(report);
        }
        return reports;
    }

    //Method for getting a single Report with GET
    public Report get(int reportId) {
        if (reportRepository.findReportByReportId(reportId).getReportId() == reportId) {
                return reportRepository.findReportByReportId(reportId);
            }
        return null;
    }

    //Method for POST request
    public Report create(Report report) {
        for (ExpenseDoc doc : report.getDocuments()) {
            doc.setDocId(docIdCounter.incrementAndGet());
            if (doc.getDate() == null) {
                doc.setDate(new Date());
            }
            doc.setSumEur();
            if (doc.isCreditCard()) {
                report.setCreditSum(doc.getSumEur());
                report.setExpenseSum(doc.getSumEur());
            }
            else {
                report.setExpenseSum(doc.getSumEur());
            }
        }
        report.setTotalSum();
        docIdCounter.set(0);
        reportRepository.save(report);
        return report;
    }
}
