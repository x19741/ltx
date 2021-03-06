package spring.mapper;

import org.apache.ibatis.annotations.Param;
import spring.entity.RetirementDisclose;
import spring.mappers.Mapper;

public interface RetirementDiscloseMapper  extends Mapper<RetirementDisclose> {
    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteDsIds(Long []ids);

    /**
     * 判断是否有重名教工卡号
     * @param card
     * @return
     */
    RetirementDisclose selectName(@Param("discloseCard") String card) ;

}
