package nc.prog1415.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nc.prog1415.R;
import nc.prog1415.model.ProductCategory;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ProdictViewHolder> {

    Context context;
    List<ProductCategory> productCategoryList;

    public ProductCategoryAdapter(Context context, List<ProductCategory> productCategoryList) {
        this.context = context;
        this.productCategoryList = productCategoryList;
    }

    @NonNull
    @Override
    public ProdictViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_row_item,parent,false);

        return new ProdictViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdictViewHolder holder, int position) {

        holder.categoryName.setText(productCategoryList.get(position).getProductName());
        }

    @Override
    public int getItemCount() { return productCategoryList.size();
    }

    public static  final class ProdictViewHolder extends  RecyclerView.ViewHolder{

        TextView categoryName;

        public ProdictViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.cat_name);

        }
    }
}
