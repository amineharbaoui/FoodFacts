package foodfacts.harbaoui.com.foodfacts.historyproductdetail;

import foodfacts.harbaoui.com.foodfacts.data.Product;

/**
 * Created by amine on 2/1/18.
 */

public class HistoryProductDetailPresenter implements HistoryProductDetailContract.Presenter, HistoryProductDetailContract.onGetProductListener {

    HistoryProductDetailContract.View mView;
    HistoryProductDetailContract.Interactor mInteractor;

    public HistoryProductDetailPresenter(HistoryProductDetailContract.View view) {
        mView = view;
        mInteractor = new HistoryProductDetailInteractor(this);
    }

    @Override
    public void getProduct(String barcode) {

        mInteractor.getProductFromCache(barcode);
    }

    @Override
    public void onGetProductSuccess(Product product) {
        mView.onGetProductSuccess(product);
    }

    @Override
    public void onGetProductFailure(String msg) {
        mView.onGetProductFailure(msg);
    }

}
