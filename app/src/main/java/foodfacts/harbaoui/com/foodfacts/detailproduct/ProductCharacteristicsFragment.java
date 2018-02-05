package foodfacts.harbaoui.com.foodfacts.detailproduct;


import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
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
public class ProductCharacteristicsFragment extends Fragment {


    @Bind(R.id.iv_product_image)
    ImageView ivProductImage;
    @Bind(R.id.tv_product_name)
    TextView tvProductName;
    @Bind(R.id.tv_generic_name)
    TextView tvGenericName;
    @Bind(R.id.tv_quantity)
    TextView tvQuantity;
    @Bind(R.id.tv_packaging_tags)
    TextView tvPackagingTags;
    @Bind(R.id.tv_brands_tags)
    TextView tvBrandsTags;
    @Bind(R.id.tv_categories_tags)
    TextView tvCategoriesTags;
    @Bind(R.id.tv_labels_tags)
    TextView tvLabelsTags;
    @Bind(R.id.tv_manufacturing_places_tags)
    TextView tvManufacturingPlacesTags;
    @Bind(R.id.tv_link)
    TextView tvLink;
    @Bind(R.id.tv_countries_tags)
    TextView tvCountriesTags;


    Product product;

    public ProductCharacteristicsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_characteristics, container, false);
        ButterKnife.bind(this, view);

        if (getArguments().getParcelable(Product.class.getSimpleName()) != null) {
            product = getArguments().getParcelable(Product.class.getSimpleName());
        } else {
            product = new Product();
        }
        setRetainInstance(true);

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
                    .load(product.getImageUrl())
                    .into(ivProductImage);
        }

        if (!product.getProductName().trim().isEmpty()) {
            tvProductName.setText(product.getProductName());
        } else {
            tvProductName.setVisibility(View.GONE);
        }
        bindDataToTextViewOrHideIt(tvGenericName, getString(R.string.txtGenericName), product.getGenericName());
        bindDataToTextViewOrHideIt(tvQuantity, getString(R.string.txtQuantity), product.getQuantity());
        bindDataToTextViewOrHideIt(tvPackagingTags, getString(R.string.txtPackaging), product.getPackagingString());
        bindDataToTextViewOrHideIt(tvBrandsTags, getString(R.string.txtBrands), product.getBrandsString());
        bindDataToTextViewOrHideIt(tvCategoriesTags, getString(R.string.txtCategories), product.getCategoriesString());
        bindDataToTextViewOrHideIt(tvLabelsTags, getString(R.string.txtLabels), product.getLabelsString());
        bindDataToTextViewOrHideIt(tvManufacturingPlacesTags, getString(R.string.txtManufacturingPlaces), product.getManufacturingPlacesTagsString());
        bindDataToTextViewOrHideIt(tvLink, getString(R.string.txtLink), product.getLink());
        bindDataToTextViewOrHideIt(tvCountriesTags, getString(R.string.txtCountries), product.getCountriesString());

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

    @OnClick(R.id.iv_product_image)
    public void openFullScreen(View v) {
        if (product.getImageUrl() != null) {
            Intent intent = new Intent(v.getContext(), ImageFullScreenActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("imageUrl", product.getImageUrl().trim());
            intent.putExtras(bundle);
            if (!product.getImageUrl().trim().isEmpty()) startActivity(intent);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
