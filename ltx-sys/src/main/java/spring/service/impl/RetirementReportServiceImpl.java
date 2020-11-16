package spring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.RetirementReport;
import spring.mapper.RetirementReportMapper;
import spring.mappers.Mapper;
import spring.service.RetirementReportService;

import javax.annotation.Resource;

@Service
@Transactional
public class RetirementReportServiceImpl extends BaseServiceImpl<RetirementReport> implements RetirementReportService {

    @Resource
    private RetirementReportMapper retirementReportMapper;

    @Override
    public RetirementReport selectPacket(String card) {
        return retirementReportMapper.selectPacket(card);
    }

    @Override
    public int deleteReIdss(Long[] ids) {
        return retirementReportMapper.deleteReIdss(ids);
    }

    @Override
    public Mapper<RetirementReport> getMapper() {
        return retirementReportMapper;
    }
}
