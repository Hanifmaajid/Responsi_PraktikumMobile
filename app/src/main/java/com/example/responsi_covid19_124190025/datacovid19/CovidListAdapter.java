package com.example.responsi_covid19_124190025.datacovid19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi_covid19_124190025.R;

import java.util.List;


public class CovidListAdapter extends  RecyclerView.Adapter<CovidListAdapter.ViewHolder> {

    private Context context;
    private List<ContentItem> contentItems;

    public CovidListAdapter(Context context, List<ContentItem> contentItems) {
        this.context = context;
        this.contentItems = contentItems;
    }

    public void setContentItems(List<ContentItem> contentItems) {
        this.contentItems = contentItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_covid, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidListAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return contentItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTanggal, tvIsolasi, tvSembuh, tvMeninggal, tvKarantina;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTanggal = itemView.findViewById(R.id.tanggal);
            tvIsolasi = itemView.findViewById(R.id.jumlah_isolasi);
            tvSembuh = itemView.findViewById(R.id.jumlah_sembuh);
            tvMeninggal = itemView.findViewById(R.id.jumlah_meninggal);
            tvKarantina = itemView.findViewById(R.id.jumlah_karantina);
        }

        public void bind(int position) {
            tvTanggal.setText(contentItems.get(position).getTanggal());
            tvIsolasi.setText(String.valueOf(contentItems.get(position).getConfirmationDiisolasi()));
            tvSembuh.setText(String.valueOf(contentItems.get(position).getConfirmationSelesai()));
            tvMeninggal.setText(String.valueOf(contentItems.get(position).getConfirmationMeninggal()));
            tvKarantina.setText(String.valueOf(contentItems.get(position).getClosecontactDikarantina()));

        }
    }
}