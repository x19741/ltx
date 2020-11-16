package spring.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.RetirementWork;
import spring.mapper.RetirementWorkMapper;
import spring.mappers.Mapper;
import spring.service.RetirementWorkService;

import javax.annotation.Resource;

@Service
@Transactional
public class RetirementWorkServiceImpl extends BaseServiceImpl<RetirementWork> implements RetirementWorkService {

    @Resource
    private RetirementWorkMapper retirementWorkMapper;

    @Override
    public Mapper<RetirementWork> getMapper() {
        return retirementWorkMapper;
    }

    @Override
    public RetirementWork selectWorks(String card) {
        return retirementWorkMapper.selectWorks(card);
    }

    @Override
    public int deleteWoIds(Long[] ids) {
        return retirementWorkMapper.deleteWoIds(ids);
    }
}
