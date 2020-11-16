package spring.service.impl.activityManagementImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.activityManagement.ActivityManagementPeople;
import spring.mapper.activityManagementMapper.ActivityManagementPeopleMapper;
import spring.mapper.activityManagementMapper.ActivityManagementPeopleMiddleMapper;
import spring.mappers.Mapper;
import spring.service.activityManagementService.ActivityManagementPeopleService;
import spring.service.impl.BaseServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ActivityManagementPeopleServiceImpl
 * @Description 活动管理-活动人员
 * @Author 向加佳
 * @Date 2020/11/13 13:33
 */
@Service
@Transactional
public class ActivityManagementPeopleServiceImpl  extends BaseServiceImpl<ActivityManagementPeople> implements ActivityManagementPeopleService {

    @Resource
    private ActivityManagementPeopleMapper activityManagementPeopleMapper;

    @Resource
    private ActivityManagementPeopleMiddleMapper activityManagementPeopleMiddleMapper;

    @Override
    public Mapper<ActivityManagementPeople> getMapper() {
        return activityManagementPeopleMapper;
    }

    @Override
    public boolean addPeople(ActivityManagementPeople items, Integer activityId) {
//        给人员表添加数据
        int i = activityManagementPeopleMapper.addPeople(items);
        if(i>0){
            //添加公共表数据
            activityManagementPeopleMiddleMapper.addId(activityId,items);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByIds1(int[] ids, Integer activityId) {
//        给人员表删除数据
        int i = activityManagementPeopleMapper.deleteDsIds(ids);
        if(i>0){
            //删除公共表数据
            activityManagementPeopleMiddleMapper.deleteId(activityId,ids);
            return true;
        }
        return false;
    }

    @Override
    public List<ActivityManagementPeople> selectByPrimaryKey1(Integer activityId, Integer pageSize, Integer pageNumber) {
//        ActivityManagementPeople count = activityManagementPeopleMapper.count(Integer activityId);
        return activityManagementPeopleMapper.selectByPrimaryKey1(activityId,pageNumber,pageSize);
    }
}
