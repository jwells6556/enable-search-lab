package ly.generalassemb.drewmahrt.shoppinglistver2.setup;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ly.generalassemb.drewmahrt.shoppinglistver2.R;

/**
 * Created by justinwells on 10/25/16.
 */

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder>{
    List<ListItem>shoppingList;

    public CustomRecyclerViewAdapter(final List<ListItem> shoppingList) {
        this.shoppingList = shoppingList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                    .inflate(R.layout.custom_layout, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.shoppingItem.setText(shoppingList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return shoppingList.size();
    }

    public void updateData (List<ListItem>newList) {
        shoppingList=newList;
        notifyDataSetChanged();
    }

}
