package ports.OUT;
import java.util.Optional;

import Models.ThresholdSetting;

public interface ThresholdRepositoryPort {
    Optional<ThresholdSetting> findById(String id);
    void save(ThresholdSetting thresholdSetting);
    

}
