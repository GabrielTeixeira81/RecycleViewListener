package br.com.digitalhouse.recycleviewlistener.contatos.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.recycleviewlistener.R;
import br.com.digitalhouse.recycleviewlistener.contatos.RecyclerViewClickListener;
import br.com.digitalhouse.recycleviewlistener.contatos.adapters.RecyclerViewContatosAdapter;
import br.com.digitalhouse.recycleviewlistener.contatos.model.Contato;

public class ContatoActivity extends AppCompatActivity implements RecyclerViewClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewContatosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerViewContatos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerViewContatosAdapter(getContatos(), this);
        recyclerView.setAdapter(adapter);

    }

    private List<Contato> getContatos() {
        List<Contato> contatos = new ArrayList<>();
        contatos.add(new Contato("Gabriel", "11-91111-1111", R.drawable.wolverine));
        contatos.add(new Contato("Alexia", "11-91231-3322", R.drawable.fenix));
        contatos.add(new Contato("Marcelo", "11-91111-7653", R.drawable.ciclope));
        contatos.add(new Contato("Jéssica", "11-91534-1199", R.drawable.psylocke));
        contatos.add(new Contato("Roberto", "11-91987-1251", R.drawable.gambit));
        contatos.add(new Contato("Tairo", "11-91090-1244", R.drawable.magneto));


        return contatos;
    }

    @Override
    public void onClik(Contato contato) {

        Intent intent = new Intent(this, DetalheContatoActivity.class);
        intent.putExtra("CONTATO", contato);
        startActivity(intent);

    }
}
