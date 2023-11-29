package com.example.jobfindernew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private final List<Notification> notificationList;

    public NotificationAdapter(final List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NotificationViewHolder holder, final int position) {
        final Notification notification = this.notificationList.get(position);
        holder.bind(notification);
    }

    @Override
    public int getItemCount() {
        return this.notificationList.size();
    }

    public static class NotificationViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvMessage;
        private final TextView tvCreatedAt;

        public NotificationViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.tvMessage = itemView.findViewById(R.id.tv_message);
            this.tvCreatedAt = itemView.findViewById(R.id.tv_created_at);
        }

        public void bind(final Notification notification) {
            this.tvMessage.setText(notification.message);
            this.tvCreatedAt.setText(notification.createdAt);
        }
    }
}
