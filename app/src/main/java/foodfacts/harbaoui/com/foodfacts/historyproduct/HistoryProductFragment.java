package foodfacts.harbaoui.com.foodfacts.historyproduct;


import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import foodfacts.harbaoui.com.foodfacts.R;
import foodfacts.harbaoui.com.foodfacts.adapters.HistoryAdapter;
import foodfacts.harbaoui.com.foodfacts.data.HistoryProduct;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryProductFragment extends Fragment implements HistoryProductContract.View {


    @Bind(R.id.rv_history_items)
    RecyclerView rvHistoryItems;
    private List<HistoryProduct> historyProducts = new ArrayList<>();
    private HistoryAdapter mAdapter;
    private HistoryProductContract.Presenter mPresenter;
    private SlidingPaneLayout slidingPaneLayout;

    public HistoryProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        ButterKnife.bind(this, view);
        slidingPaneLayout = (SlidingPaneLayout) getActivity().findViewById(R.id.sliding_pane_layout);

        mPresenter = new HistoryProductPresenter(this);
        mPresenter.getAllHistoryProduct();


        return view;
    }


    @OnClick(R.id.iv_menu)
    public void onClickMenuButton() {
        if (slidingPaneLayout.isOpen()) slidingPaneLayout.closePane();
        else slidingPaneLayout.openPane();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }



    @Override
    public void onGetAllHistoryProductSuccess(List<HistoryProduct> historyProducts) {
        System.out.println("from fragment :"+historyProducts.toString());
        if (!historyProducts.isEmpty()) {
            mAdapter = new HistoryAdapter(getContext(),historyProducts);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
            rvHistoryItems.setLayoutManager(mLayoutManager);
            rvHistoryItems.setItemAnimator(new DefaultItemAnimator());
            rvHistoryItems.setAdapter(mAdapter);

        }
    }

    @Override
    public void onGetAllHistoryProductFailure(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }


}
