package foodfacts.harbaoui.com.foodfacts.historyproduct;


import java.util.List;


import foodfacts.harbaoui.com.foodfacts.data.HistoryProduct;
import foodfacts.harbaoui.com.foodfacts.data.source.local.HistoryProductLocalSourceImp;
import io.reactivex.Flowable;

/**
 * Created by amine on 2/5/18.
 */

public class HistoryProductInteractor implements HistoryProductContract.Interactor {

    private HistoryProductContract.onGetHistoryProductListener mOnGetHistoryProductListener;
    private HistoryProductLocalSourceImp historyProductLocalSourceImp;

    HistoryProductInteractor(HistoryProductContract.onGetHistoryProductListener mOnGetHistoryProductListener) {
        this.mOnGetHistoryProductListener = mOnGetHistoryProductListener;
        historyProductLocalSourceImp = new HistoryProductLocalSourceImp();
    }


    @Override
    public void getAllHistoryProductFromDb() {
        Flowable<List<HistoryProduct>> allHistoryProduct = historyProductLocalSourceImp.getAllHistoryProduct();
        allHistoryProduct.subscribe(
                historyProducts -> mOnGetHistoryProductListener.onGetHistoryProductSuccess(historyProducts),
                throwable -> mOnGetHistoryProductListener.onGetHistoryProductFailure(throwable.getMessage())
        );
    }


}
