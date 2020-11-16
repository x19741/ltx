package spring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.RetirementParty;
import spring.mapper.RetirementPartyMapper;
import spring.mappers.Mapper;
import spring.service.RetirementPartyService;

import javax.annotation.Resource;

@Service
@Transactional
public class RetirementPartyServiceImpl extends BaseServiceImpl<RetirementParty> implements RetirementPartyService {

    @Resource
    private RetirementPartyMapper retirementPartyMapper;

    @Override
    public Mapper<RetirementParty> getMapper() {
        return retirementPartyMapper;
    }

    @Override
    public int deletePaIds(Long[] ids) {
        return retirementPartyMapper.deletePaIds(ids);
    }

    @Override
    public RetirementParty selectParty(String card) {
        return retirementPartyMapper.selectParty(card);
    }
}
