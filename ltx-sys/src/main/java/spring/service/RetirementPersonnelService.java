package spring.service;

import spring.entity.RetirementPersonnel;

public interface RetirementPersonnelService extends BaseService<RetirementPersonnel> {
    /*int addEmps(@Param("emps") RetirementPersonnel items);*/

    /**
     * 批量删除人员信息
     * @param ids
     * @return
     */
    int deleteByIdss(Long[] ids);

    /**
     * 根据教工卡号查询单个数据
     * @param caid
     * @return
     */
    RetirementPersonnel selectCaid( String caid);

    /**
     * 新增人员管理
     * @param snaps
     * @return
     */
    int added(RetirementPersonnel snaps);
}
