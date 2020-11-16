package spring.mapper.oldOrganizationMapper;

import org.apache.ibatis.annotations.Param;
import spring.entity.oldOrganization.RetirementArchivesPeople;

/**
 * @author 向加佳
 * @date 13:22 2020/11/12
 **/
public interface RetirementArchivesPeopleMiddleMapper {
    /**
     * 批量删除
     * @param courseId
     * @param ids
     * @return
     */
    int deleteId(Integer courseId,@Param("array") int[] ids);

    /**
     * 增加中间表ID
     * @param courseId
     * @param items
     * @return
     */
    int addId(Integer courseId, RetirementArchivesPeople items);
}
