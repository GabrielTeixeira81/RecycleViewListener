package br.com.digitalhouse.projetox.mvvm.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.projetox.mvvm.data.database.dao.PessoasDAO;
import br.com.digitalhouse.projetox.mvvm.model.PessoasResp;

public class RecycleViewResultAdapter {

    public class RecyclerViewContatosAdapter extends RecyclerView.Adapter<RecyclerViewContatosAdapter.ViewHolder> {

        private List<PessoasResp> pessoas;
        private RecyclerViewOnItemClickListener listener;

        public RecyclerViewContatosAdapter(List<PessoasResp> pessoas, RecyclerViewOnItemClickListener listener) {
            this.pessoas = pessoas;
            this.listener = listener;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_contato_item, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

            final PessoasResp pessoa = pessoas.get(position);

            viewHolder.bind(pessoa);

            //Vincula o evendo de click do item e repassa para o listener
            viewHolder.itemView.setOnClickListener(v -> {
                // Viculamos o click no item
                listener.onItemClick(pessoa);
            });
        }

        @Override
        public int getItemCount() {
            return pessoas.size();
        }

        public void update(List<PessoasResp> pessoaList){
            this.pessoas = pessoaList;
            notifyDataSetChanged();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {

            private TextView textViewNome;
            private TextView textViewTelefone;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                textViewNome = itemView.findViewById(R.id.textViewNome);
                textViewTelefone = itemView.findViewById(R.id.textViewTelefone);
            }

            public void bind(PessoasResp pessoa) {
                textViewNome.setText(pessoa.getResults());
                textViewTelefone.setText(textViewTelefone.getContext().getString(R.string.tefefone_format, pessoa.getTelefone()));
            }
        }
    }

}
