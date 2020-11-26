package be.kanpai.holiday.utils.features;

import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import be.kanpai.holiday.utils.Constants;
import be.kanpai.holiday.utils.MyApplication;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfigurationRepository {

    public MutableLiveData<Boolean> requestConfiguration(String featureName) {
        final MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();

        ConfigurationInterface configurationInterface = MyApplication.getRetrofitClient(Constants.CONFIGURATION_BASE_URL).create(ConfigurationInterface.class);

        configurationInterface.getAndroidConfiguration().enqueue(new Callback<List<FeatureModel>>() {
            @Override
            public void onResponse(@NotNull Call<List<FeatureModel>> call, @NotNull Response<List<FeatureModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mutableLiveData.setValue(isFeatureActive(response.body(), featureName));
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<FeatureModel>> call, @NotNull Throwable throwable) {
                //Nothing to do here
            }
        });

        return mutableLiveData;
    }

    protected Boolean isFeatureActive(List<FeatureModel> features, String featureName) {
        for (FeatureModel feature : features) {
            if (feature.getName().equals(featureName)) {
                return feature.getValue();
            }
        }

        return false;
    }
}
