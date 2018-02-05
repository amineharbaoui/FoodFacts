package foodfacts.harbaoui.com.foodfacts.detailproduct;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import foodfacts.harbaoui.com.foodfacts.ImageFullScreenActivity;
import foodfacts.harbaoui.com.foodfacts.R;
import foodfacts.harbaoui.com.foodfacts.data.Product;
import foodfacts.harbaoui.com.foodfacts.utils.StringUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class IngredientsFragment extends Fragment {

    Product product;
    @Bind(R.id.iv_ingredients_image)
    ImageView ivIngredientsImage;
    @Bind(R.id.tv_ingredients)
    TextView tvIngredients;
    @Bind(R.id.tv_substances)
    TextView tvSubstances;
    @Bind(R.id.tv_additives)
    TextView tvAdditives;
    @Bind(R.id.tv_traces)
    TextView tvTraces;

    public IngredientsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);
        ButterKnife.bind(this, view);

        if (getArguments().getParcelable(Product.class.getSimpleName()) != null) {
            product = getArguments().getParcelable(Product.class.getSimpleName());
        } else {
            product = new Product();
        }

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindDataToView(view);
    }

    private void bindDataToView(View view) {
        if (!product.getImageUrl().trim().isEmpty()) {
            Picasso.with(view.getContext())
                    .load(product.getImageIngredientsUrl())
                    .into(ivIngredientsImage);
        }

        bindDataToTextViewOrHideIt(tvIngredients, getString(R.string.txtIngredients), product.getIngredientsTagsString());
        bindDataToTextViewOrHideIt(tvAdditives, getString(R.string.txtAdditives), product.getAdditivesTagsString());
        bindDataToTextViewOrHideIt(tvSubstances, getString(R.string.txtSubstances), product.getAllergensTagsString());
        bindDataToTextViewOrHideIt(tvTraces, getString(R.string.txtTraces), product.getTracesTagsString());


    }

    @OnClick(R.id.iv_ingredients_image)
    public void openFullScreen(View v) {
        if (product.getImageUrl() != null) {
            Intent intent = new Intent(v.getContext(), ImageFullScreenActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("imageUrl", product.getImageIngredientsUrl().trim());
            intent.putExtras(bundle);
            if (!product.getImageUrl().trim().isEmpty()) startActivity(intent);
        }
    }

    private void bindDataToTextViewOrHideIt(TextView textView, String sa, String sb) {
        if (!sb.trim().isEmpty()) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(StringUtils.bold(sa));
            textView.append(": " + sb);
        } else {
            textView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
