package br.com.alura.ceep.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.com.alura.ceep.R;
import br.com.alura.ceep.dao.NotaDAO;
import br.com.alura.ceep.model.Nota;
import br.com.alura.ceep.ui.recyclerview.adapter.ListaNotasAdapter;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        List<Nota> todasNotas = notasExemplo();
        configuraAdapter(todasNotas);
    }

    private List<Nota> notasExemplo() {
        NotaDAO dao = new NotaDAO();
        dao.insere(new Nota("Primeira nota",
                "nota curta"));
        dao.insere(new Nota("Primeira nota",
                "nota mais long que a segunda"));
        for (int i = 1; i <= 10000; i++){
            dao.insere(new Nota("Título " + i,
                    "Descrição " + i));
        }
        return dao.todos();
    }

    private void configuraAdapter(List<Nota> todasNotas) {
        RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclerview);
        listaNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));
    }
}
