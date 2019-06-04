package br.com.digitalhouse.recycleviewlistener.contatos.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.digitalhouse.recycleviewlistener.R;
import br.com.digitalhouse.recycleviewlistener.contatos.model.Contato;

public class DetalheContatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_contato);

        //Valido se veio alguma coisa na intent
        if (getIntent() != null && getIntent().getExtras() != null){
            Contato contato = getIntent().getParcelableExtra("CONTATO");

        if (contato != null) {
            // Posso usar o contato para mostrar os dados na tela
        }


        }
    }
}
