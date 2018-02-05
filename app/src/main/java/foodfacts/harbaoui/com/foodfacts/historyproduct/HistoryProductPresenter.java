package foodfacts.harbaoui.com.foodfacts.historyproduct;

import android.widget.Toast;

import java.util.List;

import foodfacts.harbaoui.com.foodfacts.data.HistoryProduct;

/**
 * Created by amine on 2/5/18.
 */

public class HistoryProductPresenter implements HistoryProductContract.Presenter,HistoryProductContract.onGetHistoryProductListener{

    HistoryProductContract.View mView;
    HistoryProductContract.Interactor mInteractor;


    public HistoryProductPresenter(HistoryProductContract.View mView) {
        this.mView = mView;
        mInteractor = new HistoryProductInteractor(this);
    }

    @Override
    public void getAllHistoryProduct() {
        mInteractor.getAllHistoryProductFromDb();
    }


    @Override
    public void onGetHistoryProductSuccess(List<HistoryProduct> historyProducts) {
        mView.onGetAllHistoryProductSuccess(historyProducts);
    }

    @Override
    public void onGetHistoryProductFailure(String msg) {
        mView.onGetAllHistoryProductFailure(msg);
    }

}
