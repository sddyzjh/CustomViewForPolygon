package com.example.saint.app002;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import static com.example.saint.app002.MainActivity.edges;

/**
 * Created by Saint on 11/4/2016.
 */

public class MyView extends View {
    Path path ;
    Paint paint;
    Bitmap bitmap;
    Shader mShader;
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        path = new Path();
        paint = new Paint();
        bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.winter);
        mShader = new BitmapShader(bitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
    }
    public MyView(Context context) {
        super(context);
        path = new Path();
        paint = new Paint();
        bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.winter);
        mShader = new BitmapShader(bitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (edges == 0)
            return;
        Draw();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setShader(mShader);
        canvas.drawPath(path, paint);
    }
    private void Draw(){
        final double r = 600;
        double alpha = 360.0/(double)edges, a = 0.0;
        final int x = 610, y = 610;
        path.reset();
        path.moveTo(x+(int)(Math.cos((a*3.141592653589793)/180.0)*r), y+(int)(Math.sin((a*3.141592653589793)/180.0)*r));
        for (int i = 0;i < edges; ++i){
            a += alpha;
            path.lineTo(x+(int)(Math.cos((a*3.141592653589793)/180.0)*r), y+(int)(Math.sin((a*3.141592653589793)/180.0)*r));
        }
    }
}