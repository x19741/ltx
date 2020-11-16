package spring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.RetirementPersonnel;
import spring.mapper.RetirementPersonnelMapper;
import spring.mappers.Mapper;
import spring.service.RetirementPersonnelService;

import javax.annotation.Resource;

@Service
@Transactional
public class RetirementPersonnelServiceImpl extends BaseServiceImpl<RetirementPersonnel> implements RetirementPersonnelService {

    @Resource
    private RetirementPersonnelMapper retirementPersonnelMapper;

    @Override
    public Mapper<RetirementPersonnel> getMapper() {
        return retirementPersonnelMapper;
    }

    @Override
    public int deleteByIdss(Long[] ids) {
        return retirementPersonnelMapper.deleteByIdss(ids);
    }

    @Override
    public RetirementPersonnel selectCaid(String caid) {
        return retirementPersonnelMapper.selectCaid(caid);
    }

    @Override
    public int added(RetirementPersonnel snaps) {
        return retirementPersonnelMapper.added(snaps);
    }
}
