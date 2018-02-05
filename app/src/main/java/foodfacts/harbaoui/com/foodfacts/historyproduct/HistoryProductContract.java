package foodfacts.harbaoui.com.foodfacts.historyproduct;

import java.util.List;

import foodfacts.harbaoui.com.foodfacts.data.HistoryProduct;

/**
 * Created by amine on 2/5/18.
 */

public interface HistoryProductContract {


    interface View {


        void onGetAllHistoryProductSuccess(List<HistoryProduct> historyProducts);

        void onGetAllHistoryProductFailure(String msg);


    }

    interface Presenter {

        void getAllHistoryProduct();

    }

    interface Interactor {

        void getAllHistoryProductFromDb();

    }

    interface onGetHistoryProductListener {

        void onGetHistoryProductSuccess(List<HistoryProduct> historyProducts);

        void onGetHistoryProductFailure(String msg);
    }
}
