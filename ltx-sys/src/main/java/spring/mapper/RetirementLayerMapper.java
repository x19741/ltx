package spring.mapper;

import spring.entity.RetirementLayer;
import spring.mappers.Mapper;

public interface RetirementLayerMapper extends Mapper<RetirementLayer> {

    int deleteLayer(Long [] ids);
}
