package com.reach_u.expensereport.controller;


import com.reach_u.expensereport.model.Report;
import com.reach_u.expensereport.service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReportController {

    private ReportService reportService = new ReportService();

    @GetMapping("/reports")
    public List<Report> getReports() {
        return reportService.list();
    }

    @GetMapping("/reports/{id}")
    public Report getReport(@PathVariable("id") int id) {
        return reportService.get(id);
    }

    @PostMapping("/reports")
    public Report createReport(@RequestBody Report report) {
        reportService.create(report);
        return report;
    }

}
