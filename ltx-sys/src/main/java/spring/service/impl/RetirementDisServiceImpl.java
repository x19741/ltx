package spring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.RetirementDis;
import spring.mapper.RetirementDisMapper;
import spring.mappers.Mapper;
import spring.service.RetirementDisService;

import javax.annotation.Resource;

@Service
@Transactional
public class RetirementDisServiceImpl extends  BaseServiceImpl<RetirementDis> implements RetirementDisService {

    @Resource
    private RetirementDisMapper retirementDisMapper;

    @Override
    public RetirementDis selectWithout(String card) {
        return retirementDisMapper.selectWithout(card);
    }

    @Override
    public int deleteDiIdss(Long[] ids) {
        return retirementDisMapper.deleteDiIdss(ids);
    }

    @Override
    public int addw(Long dis) {
        return retirementDisMapper.addw(dis);
    }

    @Override
    public RetirementDis selectOnes(Long ids) {
        return retirementDisMapper.selectOnes(ids);
    }

    @Override
    public int alter(RetirementDis change) {
        return retirementDisMapper.alter(change);
    }

    @Override
    public Mapper<RetirementDis> getMapper() {
        return retirementDisMapper;
    }
}
