package spring.mapper;

import org.apache.ibatis.annotations.Param;
import spring.entity.RetirementProvide;
import spring.mappers.Mapper;
import spring.util.ReType;


public interface RetirementProvideMapper extends Mapper<RetirementProvide>  {
   /* public List<RetirementProvide> selectForm(Map select );*/
    ReType getUnderways(RetirementProvide item);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deletePrIdss(Long [] ids);

    RetirementProvide selectOld(@Param("provideCard") String card);
}
