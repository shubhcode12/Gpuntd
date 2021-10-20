package com.gpuntd.app.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.gpuntd.app.Models.Create_ID_Data;
import com.gpuntd.app.R;


import java.util.List;


public class CreateDataAdapter extends RecyclerView.Adapter<CreateDataAdapter.MyViewHolder> {

    //private static final String TAG="RecyclerAdapter";
    List<Create_ID_Data> create_data;
    private Context context;

    // int count=0;
    public CreateDataAdapter(List<Create_ID_Data> create_data, Context context) {
        this.create_data = create_data;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Log.i(TAG, "onCreateViewHolder: " + count++);
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapter_create_id_item, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Create_ID_Data createIdData = create_data.get(position);

        //Picasso.with(context)
        //      .load(listData
        //            .getImage_url())
        //  .into(holder.imageView);


       /* if (createIdData.getType().equals("PAID") || walletData.getType().equals("PENDING")) {
            holder.amount.setTextColor(ContextCompat.getColor(context, R.color.red));
            holder.name.setText("Coins Redeemed from  wallet");
            holder.amount.setText(" - " + walletData.getAmount());
        } else if (walletData.getType().equals("REDEEM")) {
            //holder.amount.setTextColor(ContextCompat.getColor(context, R.color.favcolour));
            holder.name.setText("Amount Redeemed From Wallet");
            holder.amount.setText("- " + walletData.getTxn()+" ₹");
            holder.amount.setTextColor(ContextCompat.getColor(context, R.color.green));
        }
        else if (walletData.getType().equals("CREDIT") & (walletData.getTxn().equals("MathQuiz"))) {
        holder.amount.setTextColor(ContextCompat.getColor(context, R.color.favcolour));
        holder.name.setText("Coins Earned Though Quiz");
        holder.amount.setText(" + " +walletData.getAmount()+ " Coins");

    }

        else if (walletData.getType().equals("CREDIT") & (walletData.getTxn().equals("TASK_REWARD"))) {
            holder.amount.setTextColor(ContextCompat.getColor(context, R.color.favcolour));
            holder.name.setText("Coins Earned Though DailyTask");
            holder.amount.setText(" + " +walletData.getAmount()+ " Coins");

        }
        else if (walletData.getType().equals("CREDIT") & (walletData.getTxn().equals("JOINING_BONUS"))) {
            holder.amount.setTextColor(ContextCompat.getColor(context, R.color.favcolour));
            holder.name.setText("Amount Credited For Signup");
            holder.amount.setText(" + " +walletData.getAmount()+ " Coins");

        }

        else if (walletData.getType().equals("CREDIT") & (walletData.getTxn().equals("Qr Code Generation"))) {
            holder.amount.setTextColor(ContextCompat.getColor(context, R.color.favcolour));
            holder.name.setText("Amount Credited For Qr Code");
            holder.amount.setText(" + " +walletData.getAmount()+ " ₹");

        }
        else if (walletData.getType().equals("CREDIT") & (walletData.getTxn().equals("Referal Bonus"))) {
            holder.amount.setTextColor(ContextCompat.getColor(context, R.color.favcolour));
            holder.name.setText("Amount Credited For Refferal");
            holder.amount.setText(" + " +walletData.getAmount()+ " ₹");

        }


        holder.date.setText(walletData.getDate());
        Log.d("DARWINBARK", walletData.getAmount() + walletData.getDate())*/;


        //holder.status.setText(listData.getStatus());
        //holder.joining.setText(listData.getJoining());
    }

    @Override
    public int getItemCount() {
        return create_data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder  {
        LinearLayout linearLayout;
        TextView amount,date,name;

       public MyViewHolder(@NonNull View itemView) {
           super(itemView);

           /*amount=itemView.findViewById(R.id.amount);
           date=itemView.findViewById(R.id.wallet_date);
           name=itemView.findViewById(R.id.name);*/
       }
   }
}
