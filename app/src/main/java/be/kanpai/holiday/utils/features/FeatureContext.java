package be.kanpai.holiday.utils.features;

import androidx.lifecycle.MutableLiveData;

public class FeatureContext {
    private final FeatureStrategy strategy;

    public FeatureContext(FeatureStrategy strategy) {
        this.strategy = strategy;
    }

    public MutableLiveData<Boolean> executeStrategy() {
        return strategy.showComponent();
    }
}
