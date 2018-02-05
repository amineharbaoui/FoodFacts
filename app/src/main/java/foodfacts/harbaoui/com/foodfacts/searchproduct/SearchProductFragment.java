package foodfacts.harbaoui.com.foodfacts.searchproduct;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import foodfacts.harbaoui.com.foodfacts.R;
import foodfacts.harbaoui.com.foodfacts.adapters.ViewPagerAdapter;
import foodfacts.harbaoui.com.foodfacts.data.HistoryProduct;
import foodfacts.harbaoui.com.foodfacts.data.Nutriments;
import foodfacts.harbaoui.com.foodfacts.data.Product;
import foodfacts.harbaoui.com.foodfacts.detailproduct.IngredientsFragment;
import foodfacts.harbaoui.com.foodfacts.detailproduct.NutritionFactsTableFragment;
import foodfacts.harbaoui.com.foodfacts.detailproduct.NutritionScoreLevelFragment;
import foodfacts.harbaoui.com.foodfacts.detailproduct.ProductCharacteristicsFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchProductFragment extends Fragment implements SearchProductContract.View {


    @Bind(R.id.iv_bg)
    ImageView ivBg;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.vp_container)
    ViewPager vpContainer;
    @Bind(R.id.iv_menu)
    ImageView ivMenu;
    @Bind(R.id.et_search_barcode)
    EditText etSearchBarcode;
    @Bind(R.id.iv_search)
    ImageView ivSearch;

    SearchProductContract.Presenter mPresenterSearchProduct;

    ProductCharacteristicsFragment productCharacteristicsFragment;
    IngredientsFragment ingredientsFragment;
    NutritionScoreLevelFragment nutritionScoreLevelFragment;
    NutritionFactsTableFragment nutritionFactsTableFragment;
    @Bind(R.id.rl_toolbar)
    RelativeLayout rlToolbar;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    private SlidingPaneLayout slidingPaneLayout;


    public SearchProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_product, container, false);
        ButterKnife.bind(this, view);
        slidingPaneLayout = (SlidingPaneLayout) getActivity().findViewById(R.id.sliding_pane_layout);

        ivBack.setVisibility(View.GONE);
        rlToolbar.setVisibility(View.VISIBLE);

        hideKeyboardWhenTapeOutsideEdittext();

        setupTabLayout();
        initFragments();

        mPresenterSearchProduct = new SearchProductPresenter(this);

        onTapSearchKey();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
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

    @OnClick(R.id.iv_search)
    public void onClickSearchButton() {
        searchBarcode();
    }

    public void onTapSearchKey() {
        etSearchBarcode.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                searchBarcode();
                return true;
            }
            return false;
        });
    }

    @OnClick(R.id.iv_menu)
    public void onClickMenuButton() {
        if (slidingPaneLayout.isOpen()) slidingPaneLayout.closePane();
        else slidingPaneLayout.openPane();
    }

    private void searchBarcode() {
        String barcode = etSearchBarcode.getText().toString().trim();
        if (barcode.isEmpty()) {
            etSearchBarcode.setError("This field can not be blank");
        } else {
            mPresenterSearchProduct.getProduct(barcode);
        }


    }

    private void hideKeyboardWhenTapeOutsideEdittext() {
        etSearchBarcode.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                hideKeyboard(v);
            }
        });
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void onGetProductSuccess(Product product) {

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

            mPresenterSearchProduct.saveHistoryProduct(new HistoryProduct(product.getBarcode(), product.getProductName(), product.getImageUrl()));

        }
    }

    @Override
    public void onGetProductFailure(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveHistoryProductSuccess(HistoryProduct historyProduct) {
        System.out.println("add to history " + historyProduct);
    }

    @Override
    public void onSaveHistoryProductFailure(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(productCharacteristicsFragment, "Product characteristics");
        adapter.addFragment(ingredientsFragment, "Ingredients");
        adapter.addFragment(nutritionScoreLevelFragment, "Nutrition Score & Level");
        adapter.addFragment(nutritionFactsTableFragment, "Nutrition facts Table");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(vpContainer);
    }


}
