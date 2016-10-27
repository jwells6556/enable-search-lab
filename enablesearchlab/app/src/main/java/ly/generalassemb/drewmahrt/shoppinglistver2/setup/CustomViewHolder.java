package ly.generalassemb.drewmahrt.shoppinglistver2.setup;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ly.generalassemb.drewmahrt.shoppinglistver2.R;

/**
 * Created by justinwells on 10/25/16.
 */

public class CustomViewHolder extends RecyclerView.ViewHolder {
    public TextView shoppingItem;

    public CustomViewHolder(View itemView) {
        super(itemView);
        shoppingItem = (TextView) itemView.findViewById(R.id.grocery_item);
    }
}
