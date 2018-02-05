package foodfacts.harbaoui.com.foodfacts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import foodfacts.harbaoui.com.foodfacts.historyproduct.HistoryProductFragment;
import foodfacts.harbaoui.com.foodfacts.searchproduct.SearchProductFragment;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.fl_container)
    FrameLayout flContainer;
    @Bind(R.id.sliding_pane_layout)
    SlidingPaneLayout slidingPaneLayout;
    @Bind(R.id.tv_search)
    TextView tvSearch;
    @Bind(R.id.tv_history)
    TextView tvHistory;

    SearchProductFragment searchProductFragment;
    HistoryProductFragment historyProductFragment;
    //Fragment active;
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (getSupportActionBar() != null) getSupportActionBar().hide();

        searchProductFragment = new SearchProductFragment();
        historyProductFragment = new HistoryProductFragment();

        //active = searchProductFragment;

        loadFragment(searchProductFragment);
        loadFragment(historyProductFragment);

        fragmentTransaction.hide(historyProductFragment).show(searchProductFragment).commit();


    }

    void loadFragment(Fragment fragment) {
        String TAG = fragment.getClass().getSimpleName();
        fragmentTransaction.add(R.id.fl_container, fragment, TAG);
        fragmentTransaction.addToBackStack(TAG);
    }

    @OnClick(R.id.tv_history)
    public void onClickHistoryMenu() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(searchProductFragment).show(historyProductFragment).commit();
        slidingPaneLayout.closePane();
    }

    @OnClick(R.id.tv_search)
    public void onClickSearchMenu() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(historyProductFragment).show(searchProductFragment).commit();
        slidingPaneLayout.closePane();
    }

}
