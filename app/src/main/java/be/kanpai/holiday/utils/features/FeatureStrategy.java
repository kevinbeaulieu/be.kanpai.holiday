package be.kanpai.holiday.utils.features;

import androidx.lifecycle.MutableLiveData;

public interface FeatureStrategy {

    MutableLiveData<Boolean> showComponent();
}
