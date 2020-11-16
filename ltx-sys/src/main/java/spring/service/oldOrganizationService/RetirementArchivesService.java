package spring.service.oldOrganizationService;

import spring.entity.oldOrganization.RetirementArchivesPeople;

import java.util.List;

/**
 * @author 向加佳
 * @description
 * @date 11:37 2020/11/12
 **/
public interface RetirementArchivesService {
//   XSSFWorkbook show1();

/**
 * 查看学员
 * @date 11:37 2020/11/12
 * @param courseId
 * @param pageSize
 * @param pageNumber
 * @return
 **/
    List<RetirementArchivesPeople> selectByPrimaryKey1(Integer courseId, Integer pageSize, Integer pageNumber);

    /**
     * 根据课程ID删除人员信息
     * @param ids
     * @param courseId
     * @return
     */
    boolean deleteByIds1(int[] ids, Integer courseId);

    /**
     * 根据活动ID增加人员信息
     * @param items
     * @param courseId
     * @return
     */
    boolean addPeople(RetirementArchivesPeople items, Integer courseId);

    /**
     * 修改人员信息
     * @param item
     * @return
     */
    boolean updatePeople(RetirementArchivesPeople item);

    /**
     * 查询单个数据
     * @param peopleId
     * @return
     */
    RetirementArchivesPeople selectByPrimaryKey(Integer peopleId);
}
