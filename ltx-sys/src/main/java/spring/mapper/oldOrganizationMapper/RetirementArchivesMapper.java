package spring.mapper.oldOrganizationMapper;

import org.apache.ibatis.annotations.Param;
import spring.entity.oldOrganization.RetirementArchivesPeople;

import java.util.List;

/**
 * @author 向加佳
 * @description 查询档案人员相关信息
 * @date 11:47 2020/11/12
 **/
public interface RetirementArchivesMapper {
//    List<RetirementArchives> archivesInfo();
//
//    List<RetirementArchives> selectByExample1();

    /**
     * 根据课程ID查询人员信息
     * @date 13:02 2020/11/12
     * @param courseId
     * @param pageSize
     * @param pageNumber
     * @return
     **/
    List<RetirementArchivesPeople> selectByPrimaryKey1(@Param("courseId") Integer courseId,
                                                       @Param("pageSize") Integer pageSize,
                                                       @Param("pageNumber") Integer pageNumber);

    /**
     * 批量删除人员信息
     * @param ids
     * @return
     */
    int deleteDsIds(int []ids);

    /**增加人员信息
     *
     * @param items
     * @return
     */
    int addPeople(RetirementArchivesPeople items);

    /**
     * 修改人员信息
     * @param item
     * @return
     */
    int updatePeople(RetirementArchivesPeople item);

    /**
     * 查询单个数据
     * @param peopleId
     * @return
     */
    RetirementArchivesPeople selectByPrimaryKey(@Param("peopleId") Integer peopleId);
}
