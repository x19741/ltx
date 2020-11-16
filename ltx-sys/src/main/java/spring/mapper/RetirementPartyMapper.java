package spring.mapper;

import org.apache.ibatis.annotations.Param;
import spring.entity.RetirementParty;
import spring.mappers.Mapper;

public interface RetirementPartyMapper extends Mapper<RetirementParty> {
    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deletePaIds(Long []ids);

    /**
     * 教工卡号重命名
     * @param card
     * @return
     */
    RetirementParty selectParty (@Param("flowCard") String card);
}
