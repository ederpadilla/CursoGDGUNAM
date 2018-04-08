package dev.eder.padilla.cursogdgunam.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.eder.padilla.cursogdgunam.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolderAdapter> {

    private List<Model> modelList;

    private Context adapterContext;

    private ItemLongClicked itemLongClicked;

    private ItemInRecyclerClicked itemInRecyclerClicked;

    public RecyclerViewAdapter(List<Model> modelList, Context adapterContext, ItemLongClicked itemLongClicked, ItemInRecyclerClicked itemInRecyclerClicked) {
        this.modelList = modelList;
        this.adapterContext = adapterContext;
        this.itemLongClicked = itemLongClicked;
        this.itemInRecyclerClicked = itemInRecyclerClicked;
    }

    @NonNull
    @Override
    public ItemViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        adapterContext = parent.getContext();
        View view = LayoutInflater.from(adapterContext).inflate(R.layout.item_of_recycler_view, parent, false);
        ItemViewHolderAdapter viewholder = new ItemViewHolderAdapter(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolderAdapter holder, int position) {
        Model model = modelList.get(position);
        holder.bindMyItemView(model);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public class ItemViewHolderAdapter extends RecyclerView.ViewHolder implements View.OnClickListener , View.OnLongClickListener{

        @BindView(R.id.img_model) ImageView mImgModel;
        @BindView(R.id.tv_model_name)TextView mTvModelName;
        @BindView(R.id.tv_model_type)TextView mTvModelType;
        @BindView(R.id.tv_model_max_power)TextView mTvModelMaxPower;
        @BindView(R.id.tv_model_min_power)TextView mTvModelMinPower;

        public ItemViewHolderAdapter(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            itemView.setLongClickable(true);
        }

        public void bindMyItemView(Model model){
            Glide.with(adapterContext).load(model.getImageUrl()).centerCrop().placeholder(R.drawable.dragon_ball_turtle).into(mImgModel);
            mTvModelName.setText("Nombre "+model.getName());
            mTvModelType.setText("Tipo "+model.getType());
            mTvModelMaxPower.setText("Max poder "+model.getPowerLevel().getMaxPowerLevel());
            mTvModelMinPower.setText("Poder Base "+model.getPowerLevel().getMinPowerLevel());
        }

        @Override
        public void onClick(View view) {
            itemInRecyclerClicked.recyclerViewItemClicked(view,this.getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View view) {
            itemLongClicked.recyclerViewLongItemClicked(view,this.getAdapterPosition());
            return true;
        }
    }
}
