package spring.mapper;


import org.apache.ibatis.annotations.Param;
import spring.entity.RetirementHappy;
import spring.mappers.Mapper;


public interface RetirementHappyMapper extends Mapper<RetirementHappy> {
    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteHaIds(Long []ids);

    RetirementHappy selectFete(@Param("happyCard") String card);

}
