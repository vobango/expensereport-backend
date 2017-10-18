package com.reach_u.expensereport.Repository;

import com.reach_u.expensereport.model.Report;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReportRepository extends CrudRepository<Report, Long> {
    List<Report> findByEmployee(String employee);

    Report findReportByReportId(int reportId);

}
