package com.bluetooth.mwoolley.microbitbledemo;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.bluetooth.mwoolley.microbitbledemo.bluetooth.BleAdapterService;

public class receivedata extends AppCompatActivity {

    private BleAdapterService bluetooth_le_adapter;
    private BluetoothDevice blueDevice;

    private TextView receive_data;
    private TextView send_data;
    private Button btn_send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receivedata);

        receive_data = (TextView)findViewById(R.id.receive_data);
        send_data = (TextView)findViewById(R.id.send_data);
        btn_send = (Button)findViewById(R.id.btn_send);

        blueDevice = bluetooth_le_adapter.getDevice();
    }
}
