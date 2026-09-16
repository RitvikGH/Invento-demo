package com.invento.ims.infrastructure.adapter.OUT.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.invento.ims.Domain.Models.ThresholdSetting;
import com.invento.ims.Domain.port.OUT.ThresholdRepositoryPort;
import com.invento.ims.infrastructure.adapter.OUT.persistence.Entity.ThresholdJpaEntity;
import com.invento.ims.infrastructure.adapter.OUT.persistence.dataRepo.SpringDataThresholdRepo;

@Component 
public class PostgresThresholdAdapter implements ThresholdRepositoryPort{
     private final SpringDataThresholdRepo jpaRepo;

    public PostgresThresholdAdapter(SpringDataThresholdRepo jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Optional<ThresholdSetting> findById(String id) {

        return jpaRepo.findById(id).map(entity -> {

            ThresholdSetting threshold = new ThresholdSetting();

            threshold.setProdID(entity.getId());
            threshold.setProdName(entity.getProductName());
            threshold.setSKU(entity.getSku());
            threshold.setSupplierID(entity.getSupplierId());
            threshold.setStockQuantity(entity.getStockQuantity());
            threshold.setLowStockTrigger(entity.getLowStockTrigger());

            return threshold;
        });
    }


     @Override
    public void save(ThresholdSetting thresholdSetting) {

        ThresholdJpaEntity entity = new ThresholdJpaEntity(
                thresholdSetting.getProdID(),
                thresholdSetting.getProdName(),
                thresholdSetting.getSKU(),
                thresholdSetting.getSupplierID(),
                thresholdSetting.getStockQuantity(),
                thresholdSetting.getLowStockTrigger()
        );

        jpaRepo.save(entity);
    }

}
