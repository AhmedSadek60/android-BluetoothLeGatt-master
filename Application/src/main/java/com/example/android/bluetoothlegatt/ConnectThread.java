package com.example.android.bluetoothlegatt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by ahmed on 8/26/2017.
 */

public class ConnectThread extends Thread {
    public final BluetoothSocket mmSocket;
    public final BluetoothDevice mmDevice;
    private BluetoothAdapter mBluetoothAdapter;
    private ConnectThread mConnectThread;
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
    public ConnectThread(BluetoothDevice device) {
        BluetoothSocket tmp = null;
        mmDevice = device;
        try {
            tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
        } catch (IOException e) { }
        mmSocket = tmp;
    }
    public void run() {
        mBluetoothAdapter.cancelDiscovery();
        mConnectThread = new ConnectThread(mmDevice);
        mConnectThread.start();
        try {
            mmSocket.connect();
        } catch (IOException connectException) {
            try {
                mmSocket.close();
            } catch (IOException closeException) { }
            return;
        }
    }
    public void cancel() {
        try {
            mmSocket.close();
        } catch (IOException e) { }
    }
}