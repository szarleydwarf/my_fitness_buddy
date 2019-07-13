package eu.rjch.myfitnessbuddy.utility;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "fitness_buddy_db";
    private static final String TABLE_NAME = "user_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "user_name";
    private static final String COL3 = "location";
    private static final String COL4 = "actvities";
    private static final String COL5 = "fav_profiles";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+TABLE_NAME
                + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COL2+" TEXT,"
                +COL3+" TEXT,"
                +COL4+" TEXT,"
                +COL5+" TEXT"
                +")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //todo most likely this command will be removed later, when get in to final stage and in to play store
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    //insert

//    /update

//    delete

//    get data

//    get all

//    get row count


}
