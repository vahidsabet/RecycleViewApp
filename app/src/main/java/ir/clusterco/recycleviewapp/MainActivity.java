package ir.clusterco.recycleviewapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;


    private MediaPlayer mp;
    private  Button playBtn;
private SeekBar mseecbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp=new MediaPlayer();
        mp=MediaPlayer.create(getApplicationContext(),R.raw.test_cbr);
mseecbar=(SeekBar) findViewById(R.id.seekBar);

        mseecbar.setMax(mp.getDuration());

        mseecbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b)
                {
                    mp.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        playBtn=(Button)findViewById(R.id.btnPlay);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp.isPlaying()){
                    pauseSound();
                }else{
                    startSound();
                    Toast.makeText(MainActivity.this, "OK",Toast.LENGTH_LONG).show();
                }

            }
        });

       /* recyclerView = (RecyclerView) findViewById(R.id.recyclerViewId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ListItem listItem = new ListItem(
                    "item" + (i + 1),
                    "Description",
                    "Excellent"
            );

            listItems.add(listItem);
        }

        adapter = new MyAdapter(this, listItems);*/
      //  recyclerView.setAdapter(adapter);
    }

    public void startSound()
    {
        if (mp!=null) {
            mp.start();
            playBtn.setText("Pause");
        }
    }

    public void pauseSound()
    {
        if (mp!=null) {
            mp.pause();
            playBtn.setText("Start");
        }
    }

    @Override
    protected void onDestroy() {
        if (mp.isPlaying() && mp!=null)
        {
            mp.stop();
            mp.release();
            mp=null;
        }
        super.onDestroy();
    }
}

