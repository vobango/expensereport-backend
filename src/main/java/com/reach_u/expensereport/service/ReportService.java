package com.reach_u.expensereport.service;

import com.reach_u.expensereport.Repository.ReportRepository;
import com.reach_u.expensereport.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Methods for using report list / single report data.
 */
@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;

    /*@Autowired
    ExpenseDocRepository expenseDocRepository;*/

    //Add an empty report to database with current date and status "Active" for testing purposes
    public String initialize() {
        Report test = new Report();
        List<ExpenseDoc> docs = test.getDocuments();
        ExpenseDoc test_doc = new ExpenseDoc();
        docs.add(test_doc);
        test.setDocuments(docs);
        reportRepository.save(test);
        //expenseDocRepository.save(new ExpenseDoc());
        return "Saved";
    }

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
        reportRepository.save(report);
        return report;
    }
}
