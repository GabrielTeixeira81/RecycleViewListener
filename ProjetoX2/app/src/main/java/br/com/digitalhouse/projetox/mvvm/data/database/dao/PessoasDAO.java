package br.com.digitalhouse.projetox.mvvm.data.database.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import br.com.digitalhouse.projetox.mvvm.model.Result;
import io.reactivex.Flowable;

@Dao
public interface PessoasDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Result result);

    @Update
    void update(Result result);

    @Delete
    void delete(Result result);

    @Query("Select * from pessoas limit 30")
    List<Result> getAll();

    @Query("Select * from pessoas limit 30")
    Flowable<Result> getAllRxJava();

    @Query("Select * from pessoas where idBanco = :id")
    Result getPessoasById(long id);

    @Query("Select * from pessoas where name = :nome")
    Result getPessoasByName(String nome);
}
