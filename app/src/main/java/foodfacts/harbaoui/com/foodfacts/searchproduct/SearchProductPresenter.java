package foodfacts.harbaoui.com.foodfacts.searchproduct;

import foodfacts.harbaoui.com.foodfacts.data.HistoryProduct;
import foodfacts.harbaoui.com.foodfacts.data.Product;

/**
 * Created by amine on 2/1/18.
 */

public class SearchProductPresenter implements SearchProductContract.Presenter, SearchProductContract.onGetProductListener {

    SearchProductContract.View mView;
    SearchProductContract.Interactor mInteractor;

    public SearchProductPresenter(SearchProductContract.View view) {
        mView = view;
        mInteractor = new SearchProductInteractor(this);
    }

    @Override
    public void getProduct(String barcode) {

        mInteractor.getProductFromApi(barcode);
    }

    @Override
    public void saveHistoryProduct(HistoryProduct historyProduct) {
        mInteractor.saveHistoryProductToDb(historyProduct);
    }

    @Override
    public void onGetProductSuccess(Product product) {
        mView.onGetProductSuccess(product);
    }

    @Override
    public void onGetProductFailure(String msg) {
        mView.onGetProductFailure(msg);
    }

    @Override
    public void onSaveHistoryProductSuccess(HistoryProduct historyProduct) {
        mView.onSaveHistoryProductSuccess(historyProduct);
    }

    @Override
    public void onSaveHistoryProductFailure(String msg) {
        mView.onSaveHistoryProductFailure(msg);
    }
}
