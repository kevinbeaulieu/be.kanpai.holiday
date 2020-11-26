package be.kanpai.holiday.view;

import android.os.Bundle;
import android.view.View;

import be.kanpai.holiday.R;
import be.kanpai.holiday.databinding.ActivityHolidayBinding;
import be.kanpai.holiday.models.HolidayModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

public class HolidayActivity extends AppCompatActivity {

    ActivityHolidayBinding binding;
    HolidayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_holiday);

        initUI();

        HolidayViewModel holidayViewModel = new HolidayViewModel();
        holidayViewModel.getHolidays().observe(this, this::updateHolidaysList);
        holidayViewModel.manageFeatureButton().observe(this, this::displayFeatureButton);
        holidayViewModel.manageInfoConsoFeature().observe(this, this::displayInfoConso);
    }

    private void initUI() {
        binding.rvHolidayList.setHasFixedSize(true);
        binding.rvHolidayList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HolidayAdapter();
        binding.rvHolidayList.setAdapter(adapter);
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void updateHolidaysList(List<HolidayModel> holidays) {
        if (holidays != null && !holidays.isEmpty()) {
            binding.progressBar.setVisibility(View.GONE);
            adapter.addHolidayList(holidays);
            adapter.notifyDataSetChanged();
        }
    }

    private void displayFeatureButton(Boolean value) {
        if (Boolean.TRUE.equals(value)) {
            binding.featureButton.setVisibility(View.VISIBLE);
        } else {
            binding.featureButton.setVisibility(View.GONE);
        }
    }

    private void displayInfoConso(Boolean value) {
        if (Boolean.TRUE.equals(value)) {
            binding.infoConso.setVisibility(View.VISIBLE);
        } else {
            binding.infoConso.setVisibility(View.GONE);
        }
    }
}
