package foodfacts.harbaoui.com.foodfacts.historyproductdetail;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import foodfacts.harbaoui.com.foodfacts.R;
import foodfacts.harbaoui.com.foodfacts.adapters.ViewPagerAdapter;
import foodfacts.harbaoui.com.foodfacts.data.Nutriments;
import foodfacts.harbaoui.com.foodfacts.data.Product;
import foodfacts.harbaoui.com.foodfacts.detailproduct.IngredientsFragment;
import foodfacts.harbaoui.com.foodfacts.detailproduct.NutritionFactsTableFragment;
import foodfacts.harbaoui.com.foodfacts.detailproduct.NutritionScoreLevelFragment;
import foodfacts.harbaoui.com.foodfacts.detailproduct.ProductCharacteristicsFragment;

public class HistoryProductDetailActivity extends AppCompatActivity implements HistoryProductDetailContract.View {


    ProductCharacteristicsFragment productCharacteristicsFragment;
    IngredientsFragment ingredientsFragment;
    NutritionScoreLevelFragment nutritionScoreLevelFragment;
    NutritionFactsTableFragment nutritionFactsTableFragment;
    @Bind(R.id.iv_bg)
    ImageView ivBg;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.iv_menu)
    ImageView ivMenu;
    @Bind(R.id.et_search_barcode)
    EditText etSearchBarcode;
    @Bind(R.id.iv_search)
    ImageView ivSearch;
    @Bind(R.id.rl_toolbar)
    RelativeLayout rlToolbar;
    @Bind(R.id.vp_container)
    ViewPager vpContainer;
    @Bind(R.id.iv_back)
    ImageView ivBack;

    HistoryProductDetailPresenter historyProductDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_detail_product);
        ButterKnife.bind(this);
        if (getSupportActionBar() != null) getSupportActionBar().hide();

        historyProductDetailPresenter = new HistoryProductDetailPresenter(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String barcode = extras.getString("barcode");
            System.out.println(barcode);
            historyProductDetailPresenter.getProduct(barcode);
        }
        setupTabLayout();
        initFragments();

        rlToolbar.setVisibility(View.GONE);
        ivBack.setVisibility(View.VISIBLE);


    }

    @OnClick(R.id.iv_back)
    public void onClickBackButton() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void initFragments() {
        productCharacteristicsFragment = new ProductCharacteristicsFragment();
        ingredientsFragment = new IngredientsFragment();
        nutritionScoreLevelFragment = new NutritionScoreLevelFragment();
        nutritionFactsTableFragment = new NutritionFactsTableFragment();
    }

    private void setupTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("Product characteristics"));
        tabLayout.addTab(tabLayout.newTab().setText("Ingredients"));
        tabLayout.addTab(tabLayout.newTab().setText("Nutrition Score & Level"));
        tabLayout.addTab(tabLayout.newTab().setText("Nutrition facts Table"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(productCharacteristicsFragment, "Product characteristics");
        adapter.addFragment(ingredientsFragment, "Ingredients");
        adapter.addFragment(nutritionScoreLevelFragment, "Nutrition Score & Level");
        adapter.addFragment(nutritionFactsTableFragment, "Nutrition facts Table");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(vpContainer);
    }

    @Override
    public void onGetProductSuccess(Product product) {
        System.out.println(product);
        if (product != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(Product.class.getSimpleName(), product);

            productCharacteristicsFragment.setArguments(bundle);
            ingredientsFragment.setArguments(bundle);
            nutritionScoreLevelFragment.setArguments(bundle);

            Bundle bundle1 = new Bundle();
            bundle1.putParcelable(Nutriments.class.getSimpleName(), product.getNutriments());
            bundle1.putString("imageUrl", product.getImageNutritionUrl());
            nutritionFactsTableFragment.setArguments(bundle1);
            setupViewPager(vpContainer);

        }
    }

    @Override
    public void onGetProductFailure(String msg) {

    }
}
