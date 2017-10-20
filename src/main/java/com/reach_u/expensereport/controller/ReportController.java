package com.reach_u.expensereport.controller;

import com.reach_u.expensereport.model.Report;
import com.reach_u.expensereport.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

    @DeleteMapping("/reports/{id}")
    public Boolean deleteReport(@PathVariable("id") int id) {
        reportService.deleteReportById(id);
        return true;
    }

    @PutMapping("/reports/{id}")
    public Report updateReport(@RequestBody Report report, @PathVariable("id") int id) {
        return reportService.updateReport(report, id);

    }
    //For creating dummy data
    /*@RequestMapping("/save")
    public String process() {
        return reportService.initialize();
    }*/
}
