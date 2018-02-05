package foodfacts.harbaoui.com.foodfacts.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import foodfacts.harbaoui.com.foodfacts.R;
import foodfacts.harbaoui.com.foodfacts.data.HistoryProduct;
import foodfacts.harbaoui.com.foodfacts.historyproduct.HistoryProductFragment;
import foodfacts.harbaoui.com.foodfacts.historyproductdetail.HistoryProductDetailActivity;
import foodfacts.harbaoui.com.foodfacts.searchproduct.SearchProductFragment;

/**
 * Created by amine on 2/5/18.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    Context mContext;
    List<HistoryProduct> mHistoryProducts = new ArrayList<>();
    private SearchProductFragment searchProductFragment;
    HistoryProductFragment historyProductFragment;


    public HistoryAdapter() {
    }

    public HistoryAdapter(Context mContext, List<HistoryProduct> mHistoryProducts) {
        this.mContext = mContext;
        this.mHistoryProducts = mHistoryProducts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HistoryProduct historyProduct = mHistoryProducts.get(position);

        if (!historyProduct.getUrlImage().isEmpty()) {
            Picasso.with(mContext)
                    .load(historyProduct.getUrlImage())
                    .networkPolicy(NetworkPolicy.OFFLINE)
                    .into(holder.ivProduct, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {
                            //Try again online if cache failed
                            Picasso.with(mContext)
                                    .load(historyProduct.getUrlImage())
                                    .into(holder.ivProduct, new Callback() {
                                        @Override
                                        public void onSuccess() {

                                        }

                                        @Override
                                        public void onError() {
                                            Log.v("Picasso","Could not fetch image");
                                        }
                                    });
                        }
                    });

        }
        holder.tvProductName.setText(historyProduct.getTitle());
        holder.tvBarcode.setText(historyProduct.getBarcode());
        holder.rlHistoryProduct.setOnClickListener(v -> {

            Intent intent = new Intent(mContext, HistoryProductDetailActivity.class);
            intent.putExtra("barcode", historyProduct.getBarcode());

            mContext.startActivity(intent);

        });

    }


    @Override
    public int getItemCount() {
        return mHistoryProducts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_product)
        ImageView ivProduct;
        @Bind(R.id.tv_product_name)
        TextView tvProductName;
        @Bind(R.id.tv_barcode)
        TextView tvBarcode;
        @Bind(R.id.rl_history_product)
        RelativeLayout rlHistoryProduct;


        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
