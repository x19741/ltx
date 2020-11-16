package spring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.RetirementRelation;
import spring.mapper.RetirementRelationMapper;
import spring.mappers.Mapper;
import spring.service.RetirementRelationService;

import javax.annotation.Resource;

@Service
@Transactional
public class RetirementRelationServiceImpl extends BaseServiceImpl<RetirementRelation> implements RetirementRelationService {

    @Resource
    private RetirementRelationMapper retirementRelationMapper;

    @Override
    public int deleteRela(Long[] ids) {
        return retirementRelationMapper.deleteRela(ids);
    }

    @Override
    public Mapper<RetirementRelation> getMapper() {
        return retirementRelationMapper;
    }
}
