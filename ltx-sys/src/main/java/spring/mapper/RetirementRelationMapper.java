package spring.mapper;

import spring.entity.RetirementRelation;
import spring.mappers.Mapper;

public interface RetirementRelationMapper extends Mapper<RetirementRelation> {

    int deleteRela(Long [] ids);
}
