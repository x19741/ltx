package spring.mapper;

import org.apache.ibatis.annotations.Param;
import spring.entity.RetirementWork;
import spring.mappers.Mapper;

public interface RetirementWorkMapper  extends Mapper<RetirementWork> {

    /**
     *重名验证
     * @param card
     * @return
     */
    RetirementWork selectWorks(@Param("workCard") String card);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteWoIds( Long [] ids);
}
