package nc.prog1415.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nc.prog1415.model.Productdetails;
import nc.prog1415.R;
import nc.prog1415.model.Products;

public class ProductAdapter  extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    List<Products> productsList;

    public ProductAdapter(Context context, List<Products> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.products_row_item,parent,false);
        return  new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        holder.prodImage.setImageResource(productsList.get(position).getImageUrl());
        holder.prodName.setText(productsList.get(position).getProductName());
        holder.prodInfo.setText(productsList.get(position).getProductInfo());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Productdetails.class);



                Pair[] pairs = new Pair[1];

                pairs[0] = new Pair<View,String>(holder.prodImage,"image");

                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context,pairs);
                context.startActivity(i,activityOptions.toBundle());


                context.startActivity(i);

            }
        });

    }



    @Override
    public int getItemCount() {

        return productsList.size();
    }

    public  static  final  class  ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView prodImage;
        TextView prodName, prodInfo;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            prodImage =itemView.findViewById(R.id.prod_image);
            prodName =itemView.findViewById(R.id.prod_name);
            prodInfo = itemView.findViewById(R.id.prod_info);


        }
    }
}
