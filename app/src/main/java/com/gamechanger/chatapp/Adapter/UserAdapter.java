package com.gamechanger.chatapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gamechanger.chatapp.MessageActivity;
import com.gamechanger.chatapp.Model.User;
import com.gamechanger.chatapp.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context context;
    private List<User> mUsers;
    //private boolean ischat;

    public UserAdapter(Context context,List<User> mUsers)//,boolean ischat)
    {
        this.mUsers=mUsers;
        this.context=context;
        //this.ischat=ischat;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.user_item,parent,false);
        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final User user = mUsers.get(position);
        holder.username.setText(user.getUsername());
        if (user.getImageURL().equals("default"))
        {
            holder.profile_img.setImageResource(R.mipmap.ic_launcher_foreground);
        }
        else
        {
            Glide.with(context).load(user.getImageURL()).into(holder.profile_img);
        }

        /*if (ischat)
        {
            if (user.getStatus().equals("online"))
            {
                holder.img_on.setVisibility(View.VISIBLE);
                holder.img_off.setVisibility(View.GONE);
            }
            else {
                holder.img_on.setVisibility(View.GONE);
                holder.img_off.setVisibility(View.VISIBLE);
            }
        }
        else
        {
            holder.img_on.setVisibility(View.GONE);
            holder.img_off.setVisibility(View.VISIBLE);
        }*/
//:)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MessageActivity.class);
                intent.putExtra("userId",user.getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }


    ///
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView username;
        public ImageView profile_img;
        /*private ImageView img_on;
        private ImageView img_off;*/

        public ViewHolder(View itemView)
        {
            super(itemView);

            username=itemView.findViewById(R.id.userName);
            profile_img=itemView.findViewById(R.id.profile_img);
            /*img_on=itemView.findViewById(R.id.img_on);
            img_off=itemView.findViewById(R.id.img_off);*/
        }
    }
}
