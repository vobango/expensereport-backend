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
