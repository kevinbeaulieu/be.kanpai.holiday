package be.kanpai.holiday.utils.features;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ConfigurationInterface {

    @GET("configuration?channel=android")
    Call<List<FeatureModel>> getAndroidConfiguration();
}
