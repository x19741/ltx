package spring.mapper;

import org.apache.ibatis.annotations.Param;
import spring.mappers.Mapper;
import spring.entity.RetirementFamily;

public interface RetirementFamilyMapper extends Mapper<RetirementFamily> {

    /**
     * 重名验证
     * @param card
     * @return
     */
    RetirementFamily selectFamily(@Param("familyCard") String card);

    /**
     *批量删除
     * @param ids
     * @return
     */
    int deleteFaIds(Long [] ids);

}
