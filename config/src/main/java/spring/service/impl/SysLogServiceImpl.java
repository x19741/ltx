package spring.service.impl;

import spring.entity.SysLog;
import spring.mapper.SysLogMapper;
import spring.mappers.Mapper;
import spring.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.util.IdWorker;

import javax.annotation.Resource;

@Service
@Transactional
public class SysLogServiceImpl extends BaseServiceImpl<SysLog> implements SysLogService {
    @Resource
    SysLogMapper sysLogMapper;

    @Override
    public int insertLog(SysLog sysLog) {
        sysLog.setId(IdWorker.getIdWorkerNext().toString());
        return sysLogMapper.insertSelective(sysLog);
    }

    @Override
    public Mapper<SysLog> getMapper() {
        return sysLogMapper;
    }


}
