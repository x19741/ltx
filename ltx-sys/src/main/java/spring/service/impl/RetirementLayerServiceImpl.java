package spring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.RetirementLayer;
import spring.mapper.RetirementLayerMapper;
import spring.mappers.Mapper;
import spring.service.RetirementLayerService;

import javax.annotation.Resource;

@Service
@Transactional
public class RetirementLayerServiceImpl extends BaseServiceImpl<RetirementLayer> implements RetirementLayerService {

    @Resource
    private RetirementLayerMapper retirementLayerMapper;

    @Override
    public int deleteLayer(Long[] ids) {
        return retirementLayerMapper.deleteLayer(ids);
    }

    @Override
    public Mapper<RetirementLayer> getMapper() {
        return retirementLayerMapper;
    }
}
