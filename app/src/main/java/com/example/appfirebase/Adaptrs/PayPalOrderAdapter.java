package com.example.appfirebase.Adaptrs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfirebase.Class.Cart;
import com.example.appfirebase.Class.ChefPaymentOrder1;
import com.example.appfirebase.Class.ChefPendingOrders;
import com.example.appfirebase.Class.ChefPymentOrdera;
import com.example.appfirebase.Class.ChefpendingOrder1;
import com.example.appfirebase.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PayPalOrderAdapter extends RecyclerView.Adapter<PayPalOrderAdapter.ViewHolder> {
    private Context context;
    private List<ChefPymentOrdera> chefpendingOrder1List;
    String userid,dishid;
    static int total =0;


    public PayPalOrderAdapter(Context context, List<ChefPymentOrdera> chefpendingOrder1List) {
        this.context = context;
        this.chefpendingOrder1List = chefpendingOrder1List;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.paypal,parent,false);

        return new PayPalOrderAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {
        final ChefPymentOrdera cadrt=chefpendingOrder1List.get(position);
        holder.dishname.setText(""+cadrt.getDishname());
        holder.price.setText(cadrt.getPrice() + "x" + cadrt.getDishQuntity());
        holder.dishtotal.setText(cadrt.getTotalprice());
       // total +=Integer.parseInt(cart.getTotalprice());

    }

    @Override
    public int getItemCount() {
        return chefpendingOrder1List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dishname,price,dishtotal;
        public ViewHolder(@NonNull  View itemView) {

            super(itemView);
            dishname=itemView.findViewById(R.id.dishnamename1);
            price=itemView.findViewById(R.id.Priceprice1);
            dishtotal=itemView.findViewById(R.id.Totalpricetotalprice1);
        }
    }
}
