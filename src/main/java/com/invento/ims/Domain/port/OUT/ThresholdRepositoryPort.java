package com.invento.ims.Domain.port.OUT;
import java.util.Optional;

import com.invento.ims.Domain.Models.ThresholdSetting;

public interface ThresholdRepositoryPort {
    Optional<ThresholdSetting> findById(String id);
    void save(ThresholdSetting thresholdSetting);
    

}
