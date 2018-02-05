package foodfacts.harbaoui.com.foodfacts.data.source.local;

import java.util.List;

import foodfacts.harbaoui.com.foodfacts.data.HistoryProduct;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

/**
 * Created by amine on 2/5/18.
 */

public interface HistoryProductLocalSource {

        Flowable<List<HistoryProduct>> getAllHistoryProduct();
        void saveHistoryProduct(@NonNull HistoryProduct historyProduct);
}
