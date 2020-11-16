package spring.mapper;

import org.apache.ibatis.annotations.Param;
import spring.entity.RetirementPersonnel;
import spring.mappers.Mapper;

public interface RetirementPersonnelMapper extends Mapper<RetirementPersonnel> {
     /*int addEmps(@Param("emps") RetirementPersonnel items);*/

     /**
      * 批量删除人员信息
      * @param ids
      * @return
      */
     int deleteByIdss(Long[] ids); //批量删除

     /**
      * 根据教工卡号查询单个数据
      * @param caid
      * @return
      */
     RetirementPersonnel selectCaid(@Param("staffCard") String caid);

     /**
      * 新增人员管理
      * @param snaps
      * @return
      */
     int added(RetirementPersonnel snaps);

}
