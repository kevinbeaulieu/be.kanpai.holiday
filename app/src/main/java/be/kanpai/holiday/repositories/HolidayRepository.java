package be.kanpai.holiday.repositories;

import be.kanpai.holiday.utils.MyApplication;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;

import be.kanpai.holiday.models.HolidayModel;
import be.kanpai.holiday.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HolidayRepository {

    public MutableLiveData<List<HolidayModel>> getHolidays() {
        final MutableLiveData<List<HolidayModel>> mutableLiveData = new MutableLiveData<>();

        HolidayInterface holidayServices = MyApplication.getRetrofitClient(Constants.HOLIDAYS_BASE_URL).create(HolidayInterface.class);

        holidayServices.get2020BelgiumHolidays().enqueue(new Callback<List<HolidayModel>>() {
            @Override
            public void onResponse(@NotNull Call<List<HolidayModel>> call, @NotNull Response<List<HolidayModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<HolidayModel>> call, @NotNull Throwable throwable) {
                //Nothing to do here
            }
        });

        return mutableLiveData;
    }
}
