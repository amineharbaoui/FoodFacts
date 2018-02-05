package foodfacts.harbaoui.com.foodfacts.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import foodfacts.harbaoui.com.foodfacts.R;
import foodfacts.harbaoui.com.foodfacts.data.NutrientFactsItem;

/**
 * Created by amine on 2/4/18.
 */

public class NutrientFactsListAdapter extends BaseAdapter {

    private Context context;
    private List<NutrientFactsItem> mNutriments = new ArrayList<>();


    public NutrientFactsListAdapter(Context context, List<NutrientFactsItem> mNutriments) {
        this.context = context;
        this.mNutriments = mNutriments;
        System.out.println(mNutriments.size());
    }


    @Override
    public int getCount() {
        return mNutriments.size();
    }

    @Override
    public Object getItem(int position) {
        return mNutriments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.nutrition_facts_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        NutrientFactsItem factsItem = (NutrientFactsItem) getItem(position);
        viewHolder.tvFactName.setText(factsItem.getFactName());
        viewHolder.tvFactValueG.setText(factsItem.getFactValueG());
        viewHolder.tvFactValueS.setText(factsItem.getFactValueS());
        if (factsItem.getFactName().equals(context.getString(R.string.txtEnergy)))
            viewHolder.progressBarFact.setVisibility(View.GONE);
        try {
            float value = Float.parseFloat(factsItem.getFactValueG());
            viewHolder.progressBarFact.setProgress((int)value);
        }catch (NullPointerException|NumberFormatException e) {
            System.out.println("cannot convert to float : "+e.getMessage());
        }
        return convertView;
    }


    static class ViewHolder {
        @Bind(R.id.tv_fact_name)
        TextView tvFactName;
        @Bind(R.id.tv_fact_value_g)
        TextView tvFactValueG;
        @Bind(R.id.tv_fact_value_s)
        TextView tvFactValueS;
        @Bind(R.id.ll_text)
        LinearLayout llText;
        @Bind(R.id.progressBar_fact)
        ProgressBar progressBarFact;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
