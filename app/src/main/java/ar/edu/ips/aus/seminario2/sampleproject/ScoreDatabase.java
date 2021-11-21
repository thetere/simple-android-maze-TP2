package ar.edu.ips.aus.seminario2.sampleproject;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Score.class}, version = 1)
public abstract class ScoreDatabase extends RoomDatabase {

    public abstract ScoreDAO scoreDAO();

    private static volatile ScoreDatabase instance;

    static ScoreDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (ScoreDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            ScoreDatabase.class,
                            "score_database").build();
                }
            }
        }
        return instance;
    }
}
