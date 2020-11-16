package spring.mapper;

import org.apache.ibatis.annotations.Param;
import spring.entity.RetirementReport;
import spring.mappers.Mapper;

public interface RetirementReportMapper extends Mapper<RetirementReport> {

    RetirementReport selectPacket(@Param("reportCard") String card);

    int deleteReIdss(Long [] ids);
}
