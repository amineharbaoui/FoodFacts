package foodfacts.harbaoui.com.foodfacts.historyproductdetail;

import foodfacts.harbaoui.com.foodfacts.data.source.remote.ApiClient;
import foodfacts.harbaoui.com.foodfacts.data.source.remote.ApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by amine on 2/1/18.
 */

public class HistoryProductDetailInteractor implements HistoryProductDetailContract.Interactor {

    private static final String TAG = "HistoryProductDetailInteractor";
    private HistoryProductDetailContract.onGetProductListener mOnGetProductListener;
    private static ApiService mService = ApiClient.getApiClient().create(ApiService.class);

    HistoryProductDetailInteractor(HistoryProductDetailContract.onGetProductListener onGetProductListener) {
        this.mOnGetProductListener = onGetProductListener;
    }


    @Override
    public void getProductFromCache(String barcode) {
        mService.getProductByBarcode(barcode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        productResponse -> mOnGetProductListener.onGetProductSuccess(productResponse.getProduct()),
                        throwable -> mOnGetProductListener.onGetProductFailure(throwable.getMessage())
                );

    }


}
