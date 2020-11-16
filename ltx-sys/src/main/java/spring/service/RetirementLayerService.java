package spring.service;

import spring.entity.RetirementLayer;

public interface RetirementLayerService extends BaseService<RetirementLayer> {

    int deleteLayer(Long [] ids);
}
