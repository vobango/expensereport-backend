package com.reach_u.expensereport.controller;


import com.reach_u.expensereport.model.Report;
import com.reach_u.expensereport.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

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
    @RequestMapping("/save")
    public String process() {
        return reportService.initialize();
    }

}
