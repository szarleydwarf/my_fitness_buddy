package eu.rjch.myfitnessbuddy.utility;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseDatabaseHelper {
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private String db_name;

    public FirebaseDatabaseHelper(String db_name) {
        this.db_name = db_name;
        this.mFirebaseInstance = FirebaseDatabase.getInstance();
        this.mFirebaseDatabase = mFirebaseInstance.getReference(this.db_name);
    }

    //todo user exists test
    //todo create new user record
    //todo update user
    //todo delete user?
}
