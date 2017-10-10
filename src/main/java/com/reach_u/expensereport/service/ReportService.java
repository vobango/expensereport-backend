package com.reach_u.expensereport.service;

import com.reach_u.expensereport.model.*;

import java.util.*;

/**
 * Database "replacement" for expense reports
 *
 ** Stores all reports in a list.
 *
 ** Adds methods for using report list / single report data.
 */
public class ReportService {
    private static List<Report> reports = new ArrayList<>();

    {
       reports.add(new Report("Aino Ainus", new Date(), new Date()));
       for (int i=0; i < reports.size();i++) {
           reports.get(i).setReportId(i+1);
       }
       reports.get(0).setDocuments(new ExpenseDoc(1, new Date(), "Radisson", "Housing", "Testing", "ExpRep", 150, "EUR", false));
    }

    public List list() {
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
