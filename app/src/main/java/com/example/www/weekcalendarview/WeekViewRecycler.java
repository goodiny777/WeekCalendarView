package com.example.www.weekcalendarview;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WeekViewRecycler extends RecyclerView.Adapter<WeekViewRecycler.DataObjectHolder> {
    private List<Date[]> days;
    private Calendar startDate;

    //c'tor with list of dates
    public WeekViewRecycler(List<Date[]> days) {
        this.days = days;
    }

    //c'tor to bring all dates from start date
    public WeekViewRecycler(Calendar startDate) {
        days = new ArrayList<>();
        this.startDate = startDate;
        this.startDate.setFirstDayOfWeek(Calendar.SUNDAY);
        while(startDate.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY){
            startDate.add(Calendar.DATE, -1);
        }
        //set last date
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.DATE, -1);

        Log.e("AMOUNT OF WEEKS BETWEEN", "" + (lastDate.get(Calendar.WEEK_OF_YEAR) - startDate.get(Calendar.WEEK_OF_YEAR)));
        while (startDate.before(lastDate)) {
            Date[] weekDays = new Date[7];
            for (int i = 0; i < weekDays.length; i += 1) {
                Date tempDate = startDate.getTime();
                weekDays[i] = tempDate;
                startDate.add(Calendar.DATE, 1);
            }
            days.add(weekDays);
        }
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView month, firstNum, secondNum, thirdNum, fourthNum, fifthNum, sixthNum, seventhNum;
        TextView firstName, secondName, thirdName, fourthName, fifthName, sixthName, seventhName;

        public DataObjectHolder(View itemView) {
            super(itemView);
            month = itemView.findViewById(R.id.month);
            firstName = itemView.findViewById(R.id.first_day_of_month);
            secondName = itemView.findViewById(R.id.second_day_of_month);
            thirdName = itemView.findViewById(R.id.third_day_of_month);
            fourthName = itemView.findViewById(R.id.fourth_day_of_month);
            fifthName = itemView.findViewById(R.id.fifth_day_of_month);
            sixthName = itemView.findViewById(R.id.sixth_day_of_month);
            seventhName = itemView.findViewById(R.id.sevens_day_of_month);

            firstNum = itemView.findViewById(R.id.first_day_of_week);
            secondNum = itemView.findViewById(R.id.second_day_of_week);
            thirdNum = itemView.findViewById(R.id.third_day_of_week);
            fourthNum = itemView.findViewById(R.id.fourth_day_of_week);
            fifthNum = itemView.findViewById(R.id.fifth_day_of_week);
            sixthNum = itemView.findViewById(R.id.sixth_day_of_week);
            seventhNum = itemView.findViewById(R.id.sevens_day_of_week);
        }
    }

    @NonNull
    @Override
    public DataObjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataObjectHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_week, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataObjectHolder holder, int position) {
        holder.month.setText(DateFormat.format("MMM", days.get(position)[0]));

        holder.firstNum.setText(DateFormat.format("dd", days.get(position)[0]));
        holder.firstName.setText(DateFormat.format("EEE", days.get(position)[0]));

        holder.secondNum.setText(DateFormat.format("dd", days.get(position)[1]));
        holder.secondName.setText(DateFormat.format("EEE", days.get(position)[1]));

        holder.thirdNum.setText(DateFormat.format("dd", days.get(position)[2]));
        holder.thirdName.setText(DateFormat.format("EEE", days.get(position)[2]));

        holder.fourthNum.setText(DateFormat.format("dd", days.get(position)[3]));
        holder.fourthName.setText(DateFormat.format("EEE", days.get(position)[3]));

        holder.fifthNum.setText(DateFormat.format("dd", days.get(position)[4]));
        holder.fifthName.setText(DateFormat.format("EEE", days.get(position)[4]));

        holder.sixthNum.setText(DateFormat.format("dd", days.get(position)[5]));
        holder.sixthName.setText(DateFormat.format("EEE", days.get(position)[5]));

        holder.seventhNum.setText(DateFormat.format("dd", days.get(position)[6]));
        holder.seventhName.setText(DateFormat.format("EEE", days.get(position)[6]));

    }


    @Override
    public int getItemCount() {
        return days.size();
    }
/*
    public static int daysBetween(Calendar startInclusive, Calendar endExclusive) {
        zeroTime(startInclusive);
        zeroTime(endExclusive);

        long diff = endExclusive.getTimeInMillis() - startInclusive.getTimeInMillis(); //result in millis
        return (int) TimeUnit.MILLISECONDS.toDays(diff);
    }

    private static void zeroTime(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }*/

}

