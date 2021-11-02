package com.example.geochatroom;

import static android.Manifest.permission.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class MainActivity extends AppCompatActivity {

    class MessageListener extends WebSocketListener {
        public void onOpen(WebSocket webSocket, Response response) {
            System.out.println(" -------------------------- Hi, you are connected ---------------------");
        }

        public void onMessage(WebSocket webSocket, String text) {
            try {
                Log.d("OnMessage", "On Message called");
                Gson gson = new Gson();
                Message message = gson.fromJson(text, Message.class);
                runOnUiThread(() -> {
                    addReceivedMessage(message);
                });
            } catch (Exception e) {
                System.out.println(" -------------------------- Exception on OnMessage ---------------------");
            }
        }

        public void onClosing(WebSocket webSocket, int code, String reason) {
            System.out.println(" -------------------------- Hey, you are disconnected ---------------------");
        }

        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            System.out.println(" -------------------------- There was an error ---------------------");
        }
    }

    private List<Message> msglist = new ArrayList<>();
    private WebSocket ws;
    private String author = "Tom";
    private FusedLocationProviderClient fusedLocationClient;
    private float longitude = 0;
    private float latitude = 0;
    private CustomAdapter adapter = new CustomAdapter();


    public void clearChatList() {
        adapter.clearMessages();
        TextView text = (TextView) findViewById(R.id.chat);
        text.setText("");
    }

    public void addReceivedMessage(Message message) {
        adapter.addMessage(message);
        //TextView text = (TextView) findViewById(R.id.chat);
        //text.append(message.getTimestamp() + " - " + message.getAuthor() + " : " + message.getContent() + "\n");
    }

    public void sendMessage(Message message) {
        Gson gson = new Gson();
        String json = gson.toJson(message);
        ws.send(json);
        //Toast t = Toast.makeText(this, message.getContent(), Toast.LENGTH_SHORT);
        //t.show();
    }

    public WebSocket startWatching(String url) {
        // the URL must start with ws:// or wss:// (and not http:// or https://)
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        MessageListener listener = new MessageListener();
        WebSocket ws = client.newWebSocket(request, listener);
        return ws;
    }

    @Override
    protected void onStart() {
        super.onStart();
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        ws = startWatching("ws://localhost:2021/chat");
        sendMessage(new Message(author, latitude, longitude, "@@@hello:10@@@"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        ws.close(1000, "leave");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.chat);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));


        Button button = (Button) findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText text = (EditText) findViewById(R.id.message);
                String content = String.valueOf(text.getText());

                EditText text2 = (EditText) findViewById(R.id.latitude);
                float latitude = Float.valueOf(String.valueOf(text2.getText()));

                EditText text3 = (EditText) findViewById(R.id.longitude);
                float longitude = Float.valueOf(String.valueOf(text3.getText()));

                sendMessage(new Message(author, latitude, longitude, content));
                text.setText("");
            }
        });

        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            longitude = (float) location.getLongitude();
                            latitude = (float) location.getLatitude();
                        }
                    }
                });

    }
}