package com.zaotao.daylucky.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.zaotao.daylucky.R;
import com.zaotao.daylucky.module.entity.LuckyItemEntity;
import com.zaotao.daylucky.module.entity.ThemeEntity;
import com.zaotao.daylucky.module.listener.OnItemPositionClickListener;
import com.zaotao.daylucky.widget.appview.AppFakeBoldTextView;

import java.util.List;


/**
 * Description LuckyItemAdapter
 * Created by wangisu@qq.com on 2020/10/23
 */
public class LuckyItemAdapter extends RecyclerView.Adapter<LuckyItemAdapter.ViewHolder> {

    private Context context;
    private List<LuckyItemEntity> items;

    private OnItemPositionClickListener onItemPositionClickListener;


    public void setOnItemPositionClickListener(OnItemPositionClickListener onItemPositionClickListener) {
        this.onItemPositionClickListener = onItemPositionClickListener;
    }

    public LuckyItemAdapter(Context context) {
        this.context = context;
    }

    @Override
    public LuckyItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lucky_view, parent, false);
        return new LuckyItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LuckyItemAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView itemLuckyViewSmallImageStar;
        private AppFakeBoldTextView itemLuckyViewTitle;
        private ImageView itemLuckyViewSmallImageEnd;
        private TextView itemLuckyViewContent;
        private ImageView itemLuckyViewImage;

        ViewHolder(View view) {
            super(view);

            itemLuckyViewSmallImageStar = view.findViewById(R.id.item_lucky_view_small_image_star);
            itemLuckyViewTitle = view.findViewById(R.id.item_lucky_view_title);
            itemLuckyViewSmallImageEnd = view.findViewById(R.id.item_lucky_view_small_image_end);
            itemLuckyViewContent = view.findViewById(R.id.item_lucky_view_content);
            itemLuckyViewImage = view.findViewById(R.id.item_lucky_view_image);

        }

        public void bind(int position) {
            LuckyItemEntity luckyItemEntity = items.get(position);

            itemLuckyViewSmallImageStar.setImageResource(luckyItemEntity.getLineImg());
            itemLuckyViewSmallImageEnd.setImageResource(luckyItemEntity.getLineImg());

            itemLuckyViewTitle.setText(luckyItemEntity.getTitle());

            itemLuckyViewContent.setText(luckyItemEntity.getText());

            itemLuckyViewImage.setImageResource(luckyItemEntity.getImg());
        }
    }

    public void notifyDataSetChanged(List<LuckyItemEntity> items) {
        this.items = items;
        notifyDataSetChanged();
    }
}