package be.kanpai.holiday.view;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import be.kanpai.holiday.models.HolidayModel;
import be.kanpai.holiday.repositories.HolidayRepository;
import be.kanpai.holiday.utils.features.FeatureContext;

public class HolidayViewModel extends ViewModel {

    private final HolidayRepository holidayRepository;

    private MutableLiveData<List<HolidayModel>> mutableLiveData;
    private MutableLiveData<Boolean> featureButtonLiveDataDisplay;
    private MutableLiveData<Boolean> infoConsoFeature;

    public HolidayViewModel() {
        holidayRepository = new HolidayRepository();
    }

    public LiveData<List<HolidayModel>> getHolidays() {
        if (mutableLiveData == null) {
            mutableLiveData = holidayRepository.getHolidays();
        }

        return mutableLiveData;
    }

    public LiveData<Boolean> manageFeatureButton() {
        if (featureButtonLiveDataDisplay == null) {
            featureButtonLiveDataDisplay = new FeatureContext(new ButtonFeatureFlag()).executeStrategy();
        }

        return featureButtonLiveDataDisplay;
    }

    public LiveData<Boolean> manageInfoConsoFeature() {
        if (infoConsoFeature == null) {
            infoConsoFeature = new FeatureContext(new InfoConsoFeatureFlag()).executeStrategy();
        }

        return infoConsoFeature;
    }
}
