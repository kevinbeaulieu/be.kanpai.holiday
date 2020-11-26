package be.kanpai.holiday.repositories;

import be.kanpai.holiday.models.HolidayModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HolidayInterface {

    @GET("publicholidays/2020/be")
    Call<List<HolidayModel>> get2020BelgiumHolidays();
}
