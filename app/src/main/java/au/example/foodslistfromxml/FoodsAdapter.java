package au.example.foodslistfromxml;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodsAdapter extends ArrayAdapter<Food> {
    public FoodsAdapter(Context context, ArrayList<Food> foods) {
        super(context, 0, foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Food food = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.food_item, parent, false);
        }
        TextView foodNameView = convertView.findViewById(R.id.foodName);
        TextView caloriesView = convertView.findViewById(R.id.calories);
        foodNameView.setText(food.getName());
        caloriesView.setText(food.getCalories());
        return convertView;
    }
}

