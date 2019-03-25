package com.bluetooth.mwoolley.microbitbledemo;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
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

    private final ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            bluetooth_le_adapter = ((BleAdapterService.LocalBinder) service).getService();
            bluetooth_le_adapter.setActivityHandler(mMessageHandler);
            bluetooth_le_adapter.readCharacteristic(Utility.normaliseUUID(BleAdapterService.UARTSERVICE_SERVICE_UUID),Utility.normaliseUUID(BleAdapterService.ACCELEROMETERPERIOD_CHARACTERISTIC_UUID));
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receivedata);

        receive_data = (TextView)findViewById(R.id.receive_data);
        send_data = (TextView)findViewById(R.id.send_data);
        btn_send = (Button)findViewById(R.id.btn_send);

        blueDevice = bluetooth_le_adapter.getDevice();
    }

    private Handler mMessageHandler = new Handler(){

    };
}
