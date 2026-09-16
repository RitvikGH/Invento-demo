package Models;

public class ThresholdSetting extends Product {
    private int lowStockTrigger;

    public boolean isBelowThreshold(int currentQuantity) {
        return currentQuantity <= lowStockTrigger;
    }

    public void setLowStockTrigger(int triggerValue) {
        if (triggerValue < 0) {
            throw new IllegalArgumentException("Threshold must be zero or greater");
        }
        this.lowStockTrigger = triggerValue;
    }

    public int getLowStockTrigger() { return lowStockTrigger; }
}
