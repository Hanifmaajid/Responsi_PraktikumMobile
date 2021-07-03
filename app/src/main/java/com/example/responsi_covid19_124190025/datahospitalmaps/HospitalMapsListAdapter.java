package com.example.responsi_covid19_124190025.datahospitalmaps;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.responsi_covid19_124190025.R;
import java.util.List;

public class HospitalMapsListAdapter extends RecyclerView.Adapter<HospitalMapsListAdapter.ViewHolder>{

    private Context context;
    private List<DataItem> dataItems;

    public HospitalMapsListAdapter(Context context, List<DataItem> dataItems) {
        this.context = context;
        this.dataItems = dataItems;
    }

    public void setDataItems(List<DataItem> dataItems) {
        this.dataItems = dataItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_hospital, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalMapsListAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNama, tvAlamat, tvTelepon;
        private Button btnMaps;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.title_maps);
            tvAlamat = itemView.findViewById(R.id.alamat_maps);
            tvTelepon = itemView.findViewById(R.id.telepon_maps);
            btnMaps = itemView.findViewById(R.id.btn_maps);

        }

        public void bind(int position) {
            tvNama.setText(dataItems.get(position).getNama());
            tvAlamat.setText(dataItems.get(position).getAlamat());
            tvTelepon.setText(dataItems.get(position).getTelepon());
            btnMaps.setOnClickListener(v -> {
                String address = String.format("geo: 0, 0?q= %s", dataItems.get(position).getNama());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
                intent.setPackage("com.google.android.apps.maps");
                context.startActivity(intent);
            });
        }
    }
}
