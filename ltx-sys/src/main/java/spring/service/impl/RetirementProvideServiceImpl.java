package spring.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.RetirementProvide;
import spring.mapper.RetirementProvideMapper;
import spring.mappers.Mapper;
import spring.service.RetirementProvideService;
import spring.util.ReType;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RetirementProvideServiceImpl extends BaseServiceImpl<RetirementProvide> implements RetirementProvideService {

    @Resource
    private RetirementProvideMapper retirementProvideMapper;

    @Override
    public Mapper<RetirementProvide> getMapper() {
        return retirementProvideMapper;
    }

    @Override
    public ReType getUnderways(RetirementProvide item, Integer pageNumber, Integer pageSize) {
        List<RetirementProvide> tList = null;
        Page<RetirementProvide> tPage = PageHelper.startPage(pageNumber, pageSize);
        try {
            /*item.setDisposeUserId(getUser().getId());*/
            tList = (List<RetirementProvide>) retirementProvideMapper.getUnderways(item);
        } catch (Exception e) {
            //log.error("class:BaseServiceImpl ->method:show->message:" + e.getMessage());
            e.printStackTrace();
        }
        return new ReType(tPage.getTotal(), tList);
    }

    @Override
    public int deletePrIdss(Long[] ids) {
        return retirementProvideMapper.deletePrIdss(ids);
    }

    @Override
    public RetirementProvide selectOld(String card) {
        return retirementProvideMapper.selectOld(card);
    }
}
