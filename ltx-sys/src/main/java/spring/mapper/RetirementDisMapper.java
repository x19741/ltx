package spring.mapper;

import org.apache.ibatis.annotations.Param;
import spring.mappers.Mapper;
import spring.entity.RetirementDis;

public interface RetirementDisMapper extends Mapper<RetirementDis> {

    /**
     * 重名验证教工卡号
     * @param card
     * @return
     */
    RetirementDis selectWithout(@Param("dieCard") String card);

    /**
     * 批量删除离世管理信息
     * @param ids
     * @return
     */
    int deleteDiIdss(Long [] ids);

    /**
     * 根据人员表新增一条信息，离世表也新增一条对应的信息
     * @param dis
     * @return
     */
    int addw(@Param("id") Long dis);

    /**
     * 查询历史管理信息
     * @param ids 自增id
     * @return
     */
    RetirementDis selectOnes(@Param("id")Long ids);

    /**
     * 修改离世管理信息
     * @param change
     * @return
     */
    int alter (RetirementDis change);
}
