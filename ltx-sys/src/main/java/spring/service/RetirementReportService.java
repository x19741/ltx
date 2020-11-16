package spring.service;

import spring.entity.RetirementReport;

public interface RetirementReportService extends BaseService<RetirementReport> {

    RetirementReport selectPacket(String card);

    int deleteReIdss(Long [] ids);
}
