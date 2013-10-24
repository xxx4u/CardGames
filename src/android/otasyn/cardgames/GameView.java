/**
 * Patrick John Haskins
 * CS7020 - Term Project
 */
package android.otasyn.cardgames;

import java.util.List;
import java.util.Map;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

	Paint straightLinePaint;
	Paint curvedLinePaint;
	Paint singlePointPaint;
	Paint doublePointPaint;
	
	Path curve;
	
	PointF end1, end2, end3, end4;
	PointF[] points;
	
	PointF movingPoint;
	float offX, offY;
	
	private final String LINEPOINTS_URL = "https://otasyn-cardgames.firebaseio.com/linepoints";
	private boolean firebaseListen = true;
	private Firebase firebase;

	public GameView(Context context) {
		super(context);
		
		straightLinePaint = new Paint();
		straightLinePaint.setColor(Color.BLUE);
		straightLinePaint.setStrokeWidth(5);
		
		curvedLinePaint = new Paint();
		curvedLinePaint.setColor(Color.YELLOW);
		curvedLinePaint.setStyle(Style.STROKE);
		curvedLinePaint.setStrokeWidth(5);
		
		singlePointPaint = new Paint();
		singlePointPaint.setColor(Color.BLUE);
		singlePointPaint.setStyle(Style.FILL);
		singlePointPaint.setStrokeWidth(25);
		singlePointPaint.setStrokeCap(Cap.ROUND);
		
		doublePointPaint = new Paint();
		doublePointPaint.setColor(Color.YELLOW);
		doublePointPaint.setStyle(Style.FILL);
		doublePointPaint.setStrokeWidth(25);
		doublePointPaint.setStrokeCap(Cap.ROUND);
	}
	
	public void initializePoints() {
		end1 = new PointF(100, 50);
		end2 = new PointF(125, 400);
		
		end3 = new PointF(300, 100);
		end4 = new PointF(325, 450);
		
		points = new PointF[] {end1, end2, end3, end4};
		
		curve = new Path();
		curve.moveTo(end1.x, end1.y);
		
		movingPoint = null;
        
        initializeFirebase();
	}
	
	public void initializePoints(Bundle saved) {
		points = (PointF[])saved.getParcelableArray("savedPoints");
		
		end1 = points[0];
		end2 = points[1];
		
		end3 = points[2];
		end4 = points[3];

		curve = new Path();
		curve.moveTo(end1.x, end1.y);
		
		movingPoint = null;
        
        initializeFirebase();
	}
	
	public void initializeFirebase() {
	    if (firebase == null) {
    	    firebase = new Firebase(LINEPOINTS_URL);
    	    
    	    firebase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    if (firebaseListen) {
                        @SuppressWarnings({ "unchecked", "rawtypes" })
                        List<Map> snapshotPoints = (List<Map>) snapshot.getValue();
                        for (int n = 0; n < snapshotPoints.size(); n++) {
                            points[n].x = ((Double) snapshotPoints.get(n).get("x")).floatValue();
                            points[n].y = ((Double) snapshotPoints.get(n).get("y")).floatValue();
                        }
                        invalidate();
                    }
                }
                
                @Override
                public void onCancelled() { }
            });
	    }
	}
	
	public void savePoints(Bundle saved){
		saved.putParcelableArray("savedPoints", points);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		canvas.drawLine(end1.x, end1.y, end2.x, end2.y, straightLinePaint);
		canvas.drawPoint(end1.x, end1.y, doublePointPaint);
		canvas.drawPoint(end2.x, end2.y, singlePointPaint);
		
		canvas.drawLine(end3.x, end3.y, end4.x, end4.y, straightLinePaint);
		canvas.drawPoint(end3.x, end3.y, singlePointPaint);
		canvas.drawPoint(end4.x, end4.y, doublePointPaint);
		
		curve.reset();
		curve.moveTo(end1.x, end1.y);
		curve.cubicTo(end2.x, end2.y, end3.x, end3.y, end4.x, end4.y);
		canvas.drawPath(curve, curvedLinePaint);
	}

	private PointF findPoints(float x, float y, PointF[] p){
		if (p != null) {
			for (int i = 0; i < p.length; i++) {
				double dist = Math.hypot(x - p[i].x, y - p[i].y);
				if (dist < 25)
					return p[i];
			}
		}
		return null;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getActionMasked();
		
		switch (action) {
			case MotionEvent.ACTION_DOWN:
			    firebaseListen = false;
				movingPoint = findPoints(event.getX(), event.getY(), points);
				if (movingPoint != null) {
					offX = movingPoint.x - event.getX();
					offY = movingPoint.y - event.getY();
				}
				break;
			case MotionEvent.ACTION_UP:
			    firebaseListen = true;
				movingPoint = null;
				
				break;
			case MotionEvent.ACTION_MOVE:
				if (movingPoint != null) {
					movingPoint.x = event.getX() + offX;
					movingPoint.y = event.getY() + offY;
					
					firebase.setValue(points);
					
					invalidate();
				}
				break;
		}
		
		return true;
	}
}
