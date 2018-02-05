package foodfacts.harbaoui.com.foodfacts.data.source.local;

import java.util.List;

import foodfacts.harbaoui.com.foodfacts.application.App;
import foodfacts.harbaoui.com.foodfacts.data.DaoSession;
import foodfacts.harbaoui.com.foodfacts.data.HistoryProduct;
import io.reactivex.Flowable;

/**
 * Created by amine on 2/5/18.
 */

public class HistoryProductLocalSourceImp implements HistoryProductLocalSource {

    private static final String TAG ="HistoryProductLocalSourceImp" ;
    private DaoSession daoSession = App.getDaoSession();

    @Override
    public Flowable<List<HistoryProduct>> getAllHistoryProduct() {
        return Flowable.fromCallable(() -> {
            List<HistoryProduct> list = daoSession.getHistoryProductDao().loadAll();
            System.out.println("getAllHistoryProduct: " + list.size());
            return list;
        });
    }


    @Override
    public void saveHistoryProduct(HistoryProduct historyProduct) {
        daoSession.getHistoryProductDao().insertOrReplace(historyProduct);
    }
}
