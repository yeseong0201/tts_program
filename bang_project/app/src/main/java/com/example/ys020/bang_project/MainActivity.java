package com.example.ys020.bang_project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private MyView vw;

    public class Vertex {
        Vertex(float ax, float ay, Boolean ad) {
            x = ax;
            y = ay;
            Draw = ad;
        }
        Button save;
        Button back;
        float x;
        float y;
        boolean Draw;
    }

    ArrayList<Vertex> arVertex;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vw = new MyView(this);
        setContentView(vw);
        arVertex = new ArrayList<Vertex>();
    }

    protected class MyView extends View {
        Paint pnt;

        public MyView(Context context) {
            super(context);
            pnt = new Paint();
            pnt.setColor(Color.BLUE);
            pnt.setStrokeWidth(5);
            pnt.setAntiAlias(true);


        }

        @Override
        public void onWindowFocusChanged(boolean hasWindowFocus) {
            @SuppressLint("WrongViewCast") LinearLayout temp_view = (LinearLayout)findViewById(R.id.temp_view);
            if(temp_view != null)

            super.onWindowFocusChanged(hasWindowFocus);
        }

        public void onDraw(Canvas canvas) {
            int i;
            canvas.drawColor(Color.LTGRAY);
            for (i = 0; i < arVertex.size(); i++) {
                if (arVertex.get(i).Draw) {
                    canvas.drawLine(arVertex.get(i - 1).x, arVertex.get(i - 1).y, arVertex.get(i).x, arVertex.get(i).y, pnt);
                }
            }
        }

        public boolean onTouchEvent(MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                arVertex.add(new Vertex(event.getX(), event.getY(), false));
                return true;
            }
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                arVertex.add(new Vertex(event.getX(), event.getY(), true));
                invalidate();
                return true;
            }
            return false;
        }
    }
}
