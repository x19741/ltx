package spring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.RetirementDisclose;
import spring.mapper.RetirementDiscloseMapper;
import spring.mappers.Mapper;
import spring.service.RetirementDiscloseService;

import javax.annotation.Resource;

@Service
@Transactional
public class RetirementDiscloseServiceImpl extends BaseServiceImpl<RetirementDisclose> implements RetirementDiscloseService {

    @Resource
    private RetirementDiscloseMapper retirementDiscloseMapper;


    @Override
    public Mapper<RetirementDisclose> getMapper() {
        return retirementDiscloseMapper;
    }

    @Override
    public int deleteDsIds(Long[] ids) {
        return retirementDiscloseMapper.deleteDsIds(ids);
    }

    @Override
    public RetirementDisclose selectName(String card) {
        RetirementDisclose retirementDisclose=retirementDiscloseMapper.selectName(card);
        return retirementDisclose;
    }


}
