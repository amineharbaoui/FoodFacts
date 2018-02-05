package foodfacts.harbaoui.com.foodfacts.detailproduct;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import foodfacts.harbaoui.com.foodfacts.ImageFullScreenActivity;
import foodfacts.harbaoui.com.foodfacts.R;
import foodfacts.harbaoui.com.foodfacts.adapters.NutrientFactsListAdapter;
import foodfacts.harbaoui.com.foodfacts.data.NutrientFactsItem;
import foodfacts.harbaoui.com.foodfacts.data.Nutriments;
import foodfacts.harbaoui.com.foodfacts.utils.StringUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class NutritionFactsTableFragment extends Fragment {


    @Bind(R.id.iv_nutrition_url)
    ImageView ivNutritionUrl;
    @Bind(R.id.lv_nutrition_facts)
    ListView lvNutritionFacts;

    Nutriments nutriment;
    String imageUrl;

    public NutritionFactsTableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nutrition_facts_table, container, false);
        ButterKnife.bind(this, view);

        if (getArguments().getParcelable(Nutriments.class.getSimpleName()) != null) {
            nutriment = getArguments().getParcelable(Nutriments.class.getSimpleName());
        } else {
            nutriment = new Nutriments();
        }

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindDataToView(view);
    }

    private void bindDataToView(View view) {

        List<NutrientFactsItem> mNutrientFactsItems = new ArrayList<>();


        imageUrl = getArguments().getString("imageUrl");

        if (imageUrl != null) {
            if (!imageUrl.isEmpty()) {
                Picasso.with(view.getContext())
                        .load(imageUrl)
                        .into(ivNutritionUrl);
            }
        }

        mNutrientFactsItems.add(new NutrientFactsItem(
                getString(R.string.txtEnergy),
                nutriment.getEnergy100g() + " (" + nutriment.getEnergy() + " " + nutriment.getEnergyUnit() + ")",
                nutriment.getEnergyServing()
        ));

        mNutrientFactsItems.add(new NutrientFactsItem(
                getString(R.string.txtfat),
                nutriment.getFat100g(),
                nutriment.getFatServing()
        ));

        mNutrientFactsItems.add(new NutrientFactsItem(
                getString(R.string.txtSaturedfat),
                nutriment.getSaturatedFat100g(),
                nutriment.getSaturatedFatServing()
        ));

        mNutrientFactsItems.add(new NutrientFactsItem(
                getString(R.string.txtCarbohydrate),
                nutriment.getCarbohydrates100g(),
                nutriment.getCarbohydratesServing()
        ));

        mNutrientFactsItems.add(new NutrientFactsItem(
                getString(R.string.txtSugars),
                nutriment.getSugars100g(),
                nutriment.getSugarsServing()
        ));

        mNutrientFactsItems.add(new NutrientFactsItem(
                getString(R.string.txtDietaryFiber),
                nutriment.getFiber100g(),
                nutriment.getFiberValue()
        ));

        mNutrientFactsItems.add(new NutrientFactsItem(
                getString(R.string.txtProteins),
                nutriment.getProteins100g(),
                nutriment.getProteinsServing()
        ));

        mNutrientFactsItems.add(new NutrientFactsItem(
                getString(R.string.txtSalt),
                nutriment.getSalt100g(),
                nutriment.getSaltServing()
        ));

        mNutrientFactsItems.add(new NutrientFactsItem(
                getString(R.string.txtSodium),
                nutriment.getSodium100g(),
                nutriment.getSodiumServing()
        ));




        NutrientFactsListAdapter mNutrientFactsListAdapter = new NutrientFactsListAdapter(getContext(), mNutrientFactsItems);
        lvNutritionFacts.setAdapter(mNutrientFactsListAdapter);
    }

    @OnClick(R.id.iv_nutrition_url)
    public void openFullScreen(View v) {
        if ( imageUrl != null) {
            Intent intent = new Intent(v.getContext(), ImageFullScreenActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("imageUrl", imageUrl);
            intent.putExtras(bundle);
            if (!imageUrl.isEmpty()) startActivity(intent);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
