package spring.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.RetirementHappy;
import spring.mapper.RetirementHappyMapper;
import spring.mappers.Mapper;
import spring.service.RetirementHappyService;

import javax.annotation.Resource;

@Service
@Transactional
public class RetirementHappyServiceImpl extends BaseServiceImpl<RetirementHappy> implements RetirementHappyService {

    @Resource
    private RetirementHappyMapper retirementHappyMapper;

    @Override
    public Mapper<RetirementHappy> getMapper() {
        return retirementHappyMapper;
    }

    @Override
    public int deleteHaIds(Long[] ids) {
        return retirementHappyMapper.deleteHaIds(ids);
    }

    @Override
    public RetirementHappy selectFete(String card) {
        return retirementHappyMapper.selectFete(card);
    }
}
