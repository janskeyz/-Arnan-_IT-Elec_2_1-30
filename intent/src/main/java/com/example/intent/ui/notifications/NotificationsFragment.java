package com.example.intent.ui.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.intent.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {


    private FragmentNotificationsBinding binding;
    private TextView textView;

    IntentFilter intentfilter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        textView = binding.textNotifications;

        final Button checkStatus = binding.button2;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        checkStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().registerReceiver(broadcastReceiver, intentFilter);
            }
        });

        return root;
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int deviceHealth = intent.getIntExtra(BatteryManager.EXTRA_HEALTH,0);

            if (deviceHealth == BatteryManager.BATTERY_HEALTH_GOOD)
            {
                textView.setText("current Battery Health" + "= GOOD");
            }
            if (deviceHealth == BatteryManager.BATTERY_HEALTH_COLD)
            {
                textView.setText("current Battery Health" + "= COLD");
            }
            if (deviceHealth == BatteryManager.BATTERY_HEALTH_DEAD);
            {
                textView.setText("current Battery Health" + "= DEAD");
            }
            if (deviceHealth == BatteryManager.BATTERY_HEALTH_OVERHEAT)
            {
                textView.setText("current Battery Health" + "= OVERHEAT");
            }
            if (deviceHealth == BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE)
            {
                textView.setText("current Battery Health" + "= OVER VOLTAGE");
            }
            if (deviceHealth == BatteryManager.BATTERY_HEALTH_UNKNOWN)
            {
                textView.setText("current Battery Health" + "= UNKNOWN");
            }
            if (deviceHealth == BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE);
            {
                textView.setText("current Battery Health" + "= FAILED");
            }
        }
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}