package ly.generalassemb.drewmahrt.shoppinglistver2.setup;

/**
 * Created by justinwells on 10/25/16.
 */

public class ListItem {
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ListItem(String text) {

        this.text = text;
    }
}
