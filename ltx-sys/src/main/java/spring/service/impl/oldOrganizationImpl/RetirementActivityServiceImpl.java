package spring.service.impl.oldOrganizationImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.oldOrganization.RetirementActivity;
import spring.mapper.oldOrganizationMapper.RetirementActivityMapper;
import spring.mappers.Mapper;
import spring.service.impl.BaseServiceImpl;
import spring.service.oldOrganizationService.RetirementActivityService;

import javax.annotation.Resource;

/**
 * @Author 向加佳
 * @Description
 * @Date 10:59 2020/11/12
 **/
@Service
@Transactional
public class RetirementActivityServiceImpl extends BaseServiceImpl<RetirementActivity> implements RetirementActivityService {

    @Resource
    private RetirementActivityMapper retirementActivityMapper;

    @Override
    public Mapper<RetirementActivity> getMapper() {
        return retirementActivityMapper;
    }

    @Override
    public int deleteByIds1(int[] ids) {
        return retirementActivityMapper.deleteDsIds(ids);
    }
}
