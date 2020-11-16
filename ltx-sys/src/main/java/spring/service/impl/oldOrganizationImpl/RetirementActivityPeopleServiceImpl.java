package spring.service.impl.oldOrganizationImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.oldOrganization.RetirementActivityPeople;
import spring.mapper.oldOrganizationMapper.RetirementActivityPeopleMapper;
import spring.mapper.oldOrganizationMapper.RetirementActivityPeopleMiddleMapper;
import spring.mappers.Mapper;
import spring.service.impl.BaseServiceImpl;
import spring.service.oldOrganizationService.RetirementActivityPeopleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 向加佳
 * @description
 * @date 14:04 2020/11/12
 **/
@Service
@Transactional
public class RetirementActivityPeopleServiceImpl extends BaseServiceImpl<RetirementActivityPeople> implements RetirementActivityPeopleService {

    @Resource
    private RetirementActivityPeopleMapper retirementActivityPeopleMapper;

    @Resource
    private RetirementActivityPeopleMiddleMapper retirementActivityPeopleMiddleMapper;

    @Override
    public Mapper<RetirementActivityPeople> getMapper() {
        return retirementActivityPeopleMapper;
    }

    @Override
    public List<RetirementActivityPeople> selectByPrimaryKey1(Integer activityId, Integer pageSize, Integer pageNumber) {
        return retirementActivityPeopleMapper.selectByPrimaryKey1(activityId,pageNumber,pageSize);
    }

    @Override
    public boolean addPeople(RetirementActivityPeople items, Integer activityId) {
//        给人员表添加数据
        int i = retirementActivityPeopleMapper.addPeople(items);
        if(i>0){
            //添加公共表数据
            retirementActivityPeopleMiddleMapper.addId(activityId,items);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByIds1(int[] ids, Integer activityId) {
//        给人员表删除数据
        int i = retirementActivityPeopleMapper.deleteDsIds(ids);
        if(i>0){
            //删除公共表数据
            retirementActivityPeopleMiddleMapper.deleteId(activityId,ids);
            return true;
        }
        return false;
    }
}
