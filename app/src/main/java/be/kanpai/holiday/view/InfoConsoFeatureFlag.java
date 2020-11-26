package be.kanpai.holiday.view;

import androidx.lifecycle.MutableLiveData;

import be.kanpai.holiday.utils.features.ConfigurationRepository;
import be.kanpai.holiday.utils.features.FeatureStrategy;

public class InfoConsoFeatureFlag implements FeatureStrategy {

    @Override
    public MutableLiveData<Boolean> showComponent() {
        return new ConfigurationRepository().requestConfiguration("infoConso");
    }
}
