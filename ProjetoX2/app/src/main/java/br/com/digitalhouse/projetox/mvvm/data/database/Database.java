package br.com.digitalhouse.projetox.mvvm.data.database;



import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import br.com.digitalhouse.projetox.mvvm.data.database.dao.PessoasDAO;
import br.com.digitalhouse.projetox.mvvm.model.Result;

@androidx.room.Database(entities = {Result.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class Database extends RoomDatabase {
    private static volatile Database INSTANCE;

    public abstract PessoasDAO pessoasDAO();

    public static Database getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, Database.class, "my_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}

