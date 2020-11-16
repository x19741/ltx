package spring.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.RetirementFamily;
import spring.mapper.RetirementFamilyMapper;
import spring.mappers.Mapper;
import spring.service.RetirementFamilyService;

import javax.annotation.Resource;

@Service
@Transactional
public class RetirementFamilyServiceImpl extends BaseServiceImpl<RetirementFamily> implements RetirementFamilyService {

    @Resource
    private RetirementFamilyMapper retirementFamilyMapper;

    @Override
    public Mapper<RetirementFamily> getMapper() {
        return retirementFamilyMapper;
    }

    @Override
    public RetirementFamily selectFamily(String card) {
        return retirementFamilyMapper.selectFamily(card);
    }

    @Override
    public int deleteFaIds(Long[] ids) {
        return retirementFamilyMapper.deleteFaIds(ids);
    }
}
