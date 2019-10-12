package demo.wj.practicedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import demo.wj.practicedraw4.R;

public class Practice08MatrixScaleView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice08MatrixScaleView(Context context) {
        super(context);
    }

    public Practice08MatrixScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08MatrixScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Bitmap bt = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        int sile = w / 3;
        bitmap = Bitmap.createScaledBitmap(bt,sile,sile,true);
    }

    Matrix matrix = new Matrix();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int sile = getWidth() / 3;
        canvas.save();
        canvas.drawBitmap(bitmap,0,0,paint);
        canvas.restore();

        canvas.save();
        canvas.translate(sile,0);
        matrix.reset();
        matrix.postScale(1.3f,1.3f);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,0,0,paint);
        canvas.restore();

        canvas.save();
        canvas.translate(sile*2+100,0);
        matrix.reset();
        matrix.postScale(0.6f,1.4f);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,0,0,paint);
        canvas.restore();

    }
}
