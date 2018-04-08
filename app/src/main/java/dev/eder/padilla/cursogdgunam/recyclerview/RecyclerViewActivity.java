package dev.eder.padilla.cursogdgunam.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.eder.padilla.cursogdgunam.R;
import dev.eder.padilla.cursogdgunam.util.Util;

public class RecyclerViewActivity extends AppCompatActivity implements ItemInRecyclerClicked,ItemLongClicked {

    @BindView(R.id.dragon_ball_recycler_view) RecyclerView mrecView;

    RecyclerViewAdapter recyclerViewAdapter;

    List<Model> modelList = new ArrayList<>();

    private String gokuImageUrl = "https://vignette.wikia.nocookie.net/dragonballfanon/images/7/7b/Dbds_44_3.jpg/revision/latest/scale-to-width-down/300?cb=20160831232618&path-prefix=es";
    private String vegetaImageUrl = "https://vignette.wikia.nocookie.net/dragonballfanon/images/0/01/Dbds_44_4.jpg/revision/latest?cb=20160831232623&path-prefix=es";
    private String piccoloImageUrl = "https://vignette.wikia.nocookie.net/dragonball/images/3/3f/Re_cualca.jpg/revision/latest/scale-to-width-down/185?cb=20130509175630&path-prefix=es";
    private String yamchaImageUrl = "https://image.redbull.com/rbcom/052/2017-08-17/3359f20d-e6c5-490a-8736-72faa007e73d/0010/1/2600/1130/1/dragon-ball-yamcha.jpg";
    private String bulmaImageUrl = "https://vignette.wikia.nocookie.net/dragonball/images/a/ab/Descarga99999.jpg/revision/latest?cb=20130812161041&path-prefix=es";

    private String types[] = {"Saiyajin","Namekusei","Human"};
    private final String TAG = RecyclerViewActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        setUpRecView();
        modelList.add(new Model(gokuImageUrl,"1","Goku",types[0],new PowerLevel("10","5")));
        modelList.add(new Model(vegetaImageUrl,"2","Vegeta",types[0],new PowerLevel("5","5")));
        modelList.add(new Model(piccoloImageUrl,"3","Piccolo",types[1],new PowerLevel("8","4")));
        modelList.add(new Model(yamchaImageUrl,"4","Yamcha",types[2],new PowerLevel("1","1")));
        modelList.add(new Model(bulmaImageUrl,"5","Bulma",types[2],new PowerLevel("1","1")));
        recyclerViewAdapter.notifyDataSetChanged();
    }

    private void setUpRecView() {
        recyclerViewAdapter = new RecyclerViewAdapter(modelList,getApplicationContext(),this,this);
        mrecView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void recyclerViewItemClicked(View v, int position) {
        Model model = modelList.get(position);
        modelList.add(position,model);
        recyclerViewAdapter.notifyItemInserted(position);
        recyclerViewAdapter.notifyItemRangeChanged(position,modelList.size());
        mrecView.scrollToPosition(position);
    }

    @Override
    public void recyclerViewLongItemClicked(View v, int position) {
        Model model = modelList.get(position);
        modelList.remove(model);
        recyclerViewAdapter.notifyItemRemoved(position);
        recyclerViewAdapter.notifyItemRangeChanged(position,modelList.size());
        mrecView.scrollToPosition(position);
    }
}
