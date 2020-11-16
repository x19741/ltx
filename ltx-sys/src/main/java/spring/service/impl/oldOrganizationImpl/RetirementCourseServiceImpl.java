package spring.service.impl.oldOrganizationImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.oldOrganization.RetirementCourse;
import spring.mapper.oldOrganizationMapper.RetirementCourseMapper;
import spring.mappers.Mapper;
import spring.service.impl.BaseServiceImpl;
import spring.service.oldOrganizationService.RetirementCourseService;

import javax.annotation.Resource;

/**
 * @author 向加佳
 * @description
 * @date 15:08 2020/11/12
 **/
@Service
@Transactional
public class RetirementCourseServiceImpl extends BaseServiceImpl<RetirementCourse> implements RetirementCourseService {
    @Resource
    private RetirementCourseMapper retirementCourseMapper;

    @Override
    public Mapper<RetirementCourse> getMapper() {
        return retirementCourseMapper;
    }


    @Override
    public int deleteByIds1(int[] ids) {
        return retirementCourseMapper.deleteDsIds(ids);
    }

}
