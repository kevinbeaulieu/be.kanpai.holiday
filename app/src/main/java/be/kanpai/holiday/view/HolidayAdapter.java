package be.kanpai.holiday.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import be.kanpai.holiday.R;
import be.kanpai.holiday.databinding.ItemHolidayBinding;
import be.kanpai.holiday.models.HolidayModel;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.MyViewHolder> {

    private List<HolidayModel> holidayList;

    public HolidayAdapter() {
        holidayList = new ArrayList<>();
    }

    public void addHolidayList(List<HolidayModel> holidays) {
        this.holidayList = holidays;
    }

    @Override
    public int getItemCount() {
        return holidayList != null ? holidayList.size() : 0;
    }

    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        ItemHolidayBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_holiday, parent, false);

        return new MyViewHolder(binding);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemHolidayBinding binding;

        MyViewHolder(ItemHolidayBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.binding.setModel(holidayList.get(position));
    }
}
