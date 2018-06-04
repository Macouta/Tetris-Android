package blanc.thomas.dawin.tetris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import java.util.Timer;
import java.util.TimerTask;

import blanc.thomas.dawin.tetris.Model.GridAdapter;
import blanc.thomas.dawin.tetris.Model.IntMatrix;
import blanc.thomas.dawin.tetris.Model.Tetromino;

public class GameActivity extends AppCompatActivity {

    private Timer timer;

    private Tetromino current;
    private Tetromino next;

    private int numColumns = 10;
    private int numRows = 20;

    private GridView gameGridView;
    private IntMatrix gameMatrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setImmersiveMode();

        timer = new Timer();

        gameMatrix = new IntMatrix(numColumns, numRows);

        gameGridView = findViewById(R.id.GameGrid);
        gameGridView.setAdapter(new GridAdapter(this, gameMatrix.data()));

        timer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){

            }
        },0,5000);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setImmersiveMode();
    }

    private void setImmersiveMode() {
        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
    }
}
