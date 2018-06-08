package co.shrey.fireapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    Intent intent;
    List<UserInformation> list;
    private Context context;
    List<UserInformation> arrayList = new ArrayList<>();
    public Adapter( Context ctx,List<UserInformation> list)
    {
        this.context = ctx;
        this.list = list;
        arrayList.addAll(list);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout , parent , false);
        return new ViewHolder(view);
    }

    @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.txtname.setText( list.get(position).getName());
        }

    @Override
    public int getItemCount() {
        return list.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtname;

        public ViewHolder(View itemView) {
            super(itemView);
            txtname = (TextView) itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, Recyclerclick.class);
            intent.putExtra("data", list.get(getAdapterPosition()));
            context.startActivity(intent);

        }
    }

        public void setfilter(String newText) {
            list.clear();
            if(!newText.isEmpty() || !newText.equals("")) {
                for(UserInformation uinfo : arrayList )
                {
                    String name = uinfo.getName().toLowerCase();
                    if(name.startsWith(newText))
                        list.add(uinfo);
                }

            }
            else {
                list.addAll(arrayList);
            }
            notifyDataSetChanged();

            /*ArrayList<UserInformation> arrayList = new ArrayList<>();
            arrayList.addAll(newList);*/


        }

}

