package spring.service.impl.oldOrganizationImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.oldOrganization.RetirementArchivesPeople;
import spring.mapper.oldOrganizationMapper.RetirementArchivesMapper;
import spring.mapper.oldOrganizationMapper.RetirementArchivesPeopleMiddleMapper;
import spring.service.oldOrganizationService.RetirementArchivesService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 向加佳
 * @description
 * @date 11:44 2020/11/12
 **/
@Service
@Transactional
public class RetirementArchivesServiceImpl implements RetirementArchivesService{

    @Resource
    private RetirementArchivesMapper retirementArchivesMapper;

    @Resource
    private RetirementArchivesPeopleMiddleMapper retirementArchivesPeopleMiddleMapper;

    @Override
    public List<RetirementArchivesPeople> selectByPrimaryKey1(Integer courseId, Integer pageSize, Integer pageNumber) {
        return retirementArchivesMapper.selectByPrimaryKey1(courseId,pageSize,pageNumber);
    }

    @Override
    public boolean deleteByIds1(int[] ids, Integer courseId) {
//        给人员表删除数据
        int i = retirementArchivesMapper.deleteDsIds(ids);
        if(i>0){
            //删除中间表数据
            retirementArchivesPeopleMiddleMapper.deleteId(courseId,ids);
            return true;
        }
        return false;
    }

    @Override
    public boolean addPeople(RetirementArchivesPeople items, Integer courseId) {
//        给人员表添加数据
        int i = retirementArchivesMapper.addPeople(items);
        if(i>0){
            //添加公共表数据
            retirementArchivesPeopleMiddleMapper.addId(courseId,items);
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePeople(RetirementArchivesPeople item) {
        int i = retirementArchivesMapper.updatePeople(item);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public RetirementArchivesPeople selectByPrimaryKey(Integer peopleId) {
        return retirementArchivesMapper.selectByPrimaryKey(peopleId);
    }


//    @Override
//    public XSSFWorkbook show1() {
//      List<RetirementArchives> list = retirementArchivesMapper.selectByExample(null);//查出数据库数据
////        List<RetirementArchives> list = retirementArchivesMapper.selectByExample1();//查出数据库数据
//        XSSFWorkbook wb = new XSSFWorkbook();
//        Sheet sheet = wb.createSheet("Goods");//创建一张表
//        Row titleRow = sheet.createRow(0);//创建第一行，起始为0
//        titleRow.createCell(0).setCellValue("档案ID");//第一列
//        titleRow.createCell(1).setCellValue("课程名称");
//        titleRow.createCell(2).setCellValue("学期开始时间");
//        titleRow.createCell(3).setCellValue("学期结束时间");
//        titleRow.createCell(4).setCellValue("学期");
//        titleRow.createCell(5).setCellValue("工作表ID");
//        int cell = 1;
//        for (RetirementArchives retirementArchives : list) {
//            Row row = sheet.createRow(cell);//从第二行开始保存数据
//            row.createCell(0).setCellValue(cell);
//            row.createCell(1).setCellValue(retirementArchives.getArchivesCourseName());//将数据库的数据遍历出来
////            日期格式转为字符串输出
//            row.createCell(2).setCellValue(retirementArchives.getArchivesBeginDate());
//            row.createCell(3).setCellValue(retirementArchives.getArchivesEndDate());
//            row.createCell(4).setCellValue(retirementArchives.getArchivesSemester());
//            row.createCell(5).setCellValue(retirementArchives.getWorkId());
//            cell++;
//        }
//        return wb;
//    }
}
