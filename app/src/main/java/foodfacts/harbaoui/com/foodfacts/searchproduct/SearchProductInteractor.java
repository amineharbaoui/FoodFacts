package foodfacts.harbaoui.com.foodfacts.searchproduct;

import android.util.Log;

import foodfacts.harbaoui.com.foodfacts.data.HistoryProduct;
import foodfacts.harbaoui.com.foodfacts.data.ProductResponse;
import foodfacts.harbaoui.com.foodfacts.data.source.local.HistoryProductLocalSourceImp;
import foodfacts.harbaoui.com.foodfacts.data.source.remote.ApiClient;
import foodfacts.harbaoui.com.foodfacts.data.source.remote.ApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by amine on 2/1/18.
 */

public class SearchProductInteractor implements SearchProductContract.Interactor {

    private static final String TAG = "HistoryProductDetailInteractor";
    private SearchProductContract.onGetProductListener mOnGetProductListener;
    private static ApiService mService = ApiClient.getApiClient().create(ApiService.class);
    private HistoryProductLocalSourceImp historyProductLocalSourceImp;


    SearchProductInteractor(SearchProductContract.onGetProductListener onGetProductListener) {
        this.mOnGetProductListener = onGetProductListener;
        historyProductLocalSourceImp = new HistoryProductLocalSourceImp();

    }


    @Override
    public void getProductFromApi(String barcode) {
        mService.getProductByBarcode(barcode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        productResponse -> mOnGetProductListener.onGetProductSuccess(productResponse.getProduct()),
                        throwable -> mOnGetProductListener.onGetProductFailure(throwable.getMessage())
                );

    }

    @Override
    public void saveHistoryProductToDb(HistoryProduct historyProduct) {
        historyProductLocalSourceImp.saveHistoryProduct(historyProduct);
    }

}
