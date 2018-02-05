package foodfacts.harbaoui.com.foodfacts.detailproduct;


import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.caverock.androidsvg.SVG;

import java.io.InputStream;

import butterknife.Bind;
import butterknife.ButterKnife;
import foodfacts.harbaoui.com.foodfacts.R;
import foodfacts.harbaoui.com.foodfacts.data.NutriScore;
import foodfacts.harbaoui.com.foodfacts.data.Product;
import foodfacts.harbaoui.com.foodfacts.utils.StringUtils;
import foodfacts.harbaoui.com.foodfacts.utils.SvgDecoder;
import foodfacts.harbaoui.com.foodfacts.utils.SvgDrawableTranscoder;
import foodfacts.harbaoui.com.foodfacts.utils.SvgSoftwareLayerSetter;


/**
 * A simple {@link Fragment} subclass.
 */
public class NutritionScoreLevelFragment extends Fragment {

    Product product;
    @Bind(R.id.iv_score)
    ImageView ivScore;
    @Bind(R.id.tv_fat)
    TextView tvFat;
    @Bind(R.id.tv_saturated_fat)
    TextView tvSaturatedFat;
    @Bind(R.id.tv_sugars)
    TextView tvSugars;
    @Bind(R.id.tv_salt)
    TextView tvSalt;
    @Bind(R.id.iv_fat)
    ImageView ivFat;
    @Bind(R.id.iv_saturated_fat)
    ImageView ivSaturatedFat;
    @Bind(R.id.iv_sugars)
    ImageView ivSugars;
    @Bind(R.id.iv_salt)
    ImageView ivSalt;
    @Bind(R.id.tv_serving_size)
    TextView tvServingSize;
    @Bind(R.id.tv_warning)
    TextView tvWarning;

    private GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> requestBuilder;


    public NutritionScoreLevelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nutrition_score_level, container, false);
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

        if (product.getNutritionGrades().toLowerCase().equals("a")) loadSvg(view, NutriScore.A);
        if (product.getNutritionGrades().toLowerCase().equals("b")) loadSvg(view, NutriScore.B);
        if (product.getNutritionGrades().toLowerCase().equals("c")) loadSvg(view, NutriScore.C);
        if (product.getNutritionGrades().toLowerCase().equals("d")) loadSvg(view, NutriScore.D);
        if (product.getNutritionGrades().toLowerCase().equals("e")) loadSvg(view, NutriScore.E);

        tvWarning.setText(getString(R.string.txtWarning));

        if (product.getNutrientLevels().getFat().toLowerCase().equals("high"))
            ivFat.setImageResource(R.drawable.ic_high);
        if (product.getNutrientLevels().getFat().toLowerCase().equals("low"))
            ivFat.setImageResource(R.drawable.ic_low);
        if (product.getNutrientLevels().getFat().toLowerCase().equals("moderate"))
            ivFat.setImageResource(R.drawable.ic_moderate);
        tvFat.setText(product.getNutriments().getFat100g());
        tvFat.append("g ");
        tvFat.append(StringUtils.bold(getString(R.string.txtfat)));
        tvFat.append(" is ");
        tvFat.append(product.getNutrientLevels().getFat());
        tvFat.append(" quantity ");


        if (product.getNutrientLevels().getSugar().toLowerCase().equals("high"))
            ivSaturatedFat.setImageResource(R.drawable.ic_high);
        if (product.getNutrientLevels().getSugar().toLowerCase().equals("low"))
            ivSaturatedFat.setImageResource(R.drawable.ic_low);
        if (product.getNutrientLevels().getSugar().toLowerCase().equals("moderate"))
            ivSaturatedFat.setImageResource(R.drawable.ic_moderate);
        tvSaturatedFat.setText(product.getNutriments().getSaturatedFat100g());
        tvSaturatedFat.append("g ");
        tvSaturatedFat.append(StringUtils.bold(getString(R.string.txtSaturedfat)));
        tvSaturatedFat.append(" is ");
        tvSaturatedFat.append(product.getNutrientLevels().getSaturatedFat());
        tvSaturatedFat.append(" quantity ");

        if (product.getNutrientLevels().getFat().toLowerCase().equals("high"))
            ivSugars.setImageResource(R.drawable.ic_high);
        if (product.getNutrientLevels().getFat().toLowerCase().equals("low"))
            ivSugars.setImageResource(R.drawable.ic_low);
        if (product.getNutrientLevels().getFat().toLowerCase().equals("moderate"))
            ivSugars.setImageResource(R.drawable.ic_moderate);
        tvSugars.setText(product.getNutriments().getSugars100g());
        tvSugars.append("g ");
        tvSugars.append(StringUtils.bold(getString(R.string.txtSugars)));
        tvSugars.append(" is ");
        tvSugars.append(product.getNutrientLevels().getSugar());
        tvSugars.append(" quantity ");

        if (product.getNutrientLevels().getSalt().toLowerCase().equals("high"))
            ivSalt.setImageResource(R.drawable.ic_high);
        if (product.getNutrientLevels().getSalt().toLowerCase().equals("low"))
            ivSalt.setImageResource(R.drawable.ic_low);
        if (product.getNutrientLevels().getSalt().toLowerCase().equals("moderate"))
            ivSalt.setImageResource(R.drawable.ic_moderate);
        tvSalt.setText(product.getNutriments().getSalt100g());
        tvSalt.append("g ");
        tvSalt.append(StringUtils.bold(getString(R.string.txtSalt)));
        tvSalt.append(" is ");
        tvSalt.append(product.getNutrientLevels().getSalt());
        tvSalt.append(" quantity ");


    }


    public void loadSvg(View view, String url) {

        requestBuilder = Glide.with(this)
                .using(Glide.buildStreamModelLoader(Uri.class, view.getContext()), InputStream.class)
                .from(Uri.class)
                .as(SVG.class)
                .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
                .sourceEncoder(new StreamEncoder())
                .cacheDecoder(new FileToStreamDecoder<SVG>(new SvgDecoder()))
                .decoder(new SvgDecoder())
                .animate(android.R.anim.fade_in)
                .listener(new SvgSoftwareLayerSetter<Uri>());

        Uri uri = Uri.parse(url);
        requestBuilder
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .load(uri)
                .into(ivScore);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
