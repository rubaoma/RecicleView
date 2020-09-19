package com.example.recycleview.activity.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recycleview.R;
import com.example.recycleview.activity.activity.RecyclerItemClickListener;
import com.example.recycleview.activity.activity.adapter.Adapter;
import com.example.recycleview.activity.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        //Listagem de filmes
        this.criarFilmes();

        // configurar o adapter
        Adapter adapter = new Adapter( listaFilmes );


        //configurar RecycleView

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setHasFixedSize( true );
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter( adapter );

        // evento de cluck
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get( position );
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Filme selecionado: " + filme.getTituloFilme(),
                                    Toast.LENGTH_LONG
                            ).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get( position );
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Ano do filme: " + filme.getAno(),
                                    Toast.LENGTH_LONG
                            ).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        }
                    }
            )
        );

    }

    public void criarFilmes(){
        Filme filme = new Filme("X-mem","Ação","1999");
        this.listaFilmes.add( filme );

        filme = new Filme("Super-man","Ação","2008");
        this.listaFilmes.add( filme );
        filme = new Filme("Bill Kill","Aventura","2000");
        this.listaFilmes.add( filme );
        filme = new Filme("Rocky 3","Drama","1986");
        this.listaFilmes.add( filme );
        filme = new Filme("O Quarto","Suspence","2019");
        this.listaFilmes.add( filme );
        filme = new Filme("Toy Story","infantil","2002");
        this.listaFilmes.add( filme );
        filme = new Filme("Indiana Jones e a arc perdida","Aventura","1992");
        this.listaFilmes.add( filme );
        filme = new Filme("Crepusculo","Drama","2010");
        this.listaFilmes.add( filme );
        filme = new Filme("Velozes e furiosos","Ação","2001");
        this.listaFilmes.add( filme );
        filme = new Filme("Constantine","Terror","2006");
        this.listaFilmes.add( filme );
        filme = new Filme("Jumagi","Aventura","2017");
        this.listaFilmes.add( filme );
    }

}