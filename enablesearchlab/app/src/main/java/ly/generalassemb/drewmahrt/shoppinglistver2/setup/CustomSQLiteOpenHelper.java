package ly.generalassemb.drewmahrt.shoppinglistver2.setup;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justinwells on 10/25/16.
 */

public class CustomSQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {
    private static final String DATABASE_NAME = "SHOPPING_DB";
    private static final int DATABASE_VERSION = 7;
    public static final String TABLE_NAME = "SHOPPING_LIST";
    public static final String COL_ID = "id";
    public static final String COL_ITEM = "ITEM_NAME";
    private static CustomSQLiteOpenHelper sInstance;
    public static final String TABLE_CREATE =
            "CREATE TABLE " +  TABLE_NAME + " (" +
                    COL_ID + " INTEGER PRIMARY KEY," +
                    COL_ITEM + " TEXT)";


    public static CustomSQLiteOpenHelper getInstance (Context context) {
        if (sInstance == null) {
            sInstance = new CustomSQLiteOpenHelper(context.getApplicationContext());
        }

        return sInstance;
    }

    private CustomSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public List<ListItem> getAllAsList () {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[] {COL_ITEM}
                ,null,null,null,null,null);

        List<ListItem>itemList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String listItem = cursor.getString(cursor.getColumnIndex(COL_ITEM));

                itemList.add(new ListItem(listItem));

                cursor.moveToNext();

            }
        }
        cursor.close();
        return itemList;
    }

    public Cursor getAllItems () {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }

    public List<ListItem> searchItems (String query) {
        List<ListItem>resultList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                                 null,
                                 COL_ITEM+ " LIKE ?",
                                 new String[]{"%"+query+"%"},
                                 null,null,COL_ITEM,null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                ListItem item = new ListItem(cursor.getString(cursor.getColumnIndex(COL_ITEM)));
                resultList.add(item);
                cursor.moveToNext();
            }

            cursor.close();

        }

        return resultList;
    }

}
