package com.androidplot.xy;

import android.graphics.Path;
import android.graphics.PointF;

/**
 * WARNING: This is an unfinished class.  Series drawn by this implementation may look nice
 * but they are not yet accurate representations of the control points from which they are derived.
 */
public class BezierLineAndPointRenderer extends LineAndPointRenderer<BezierLineAndPointFormatter> {
    public BezierLineAndPointRenderer(XYPlot plot) {
        super(plot);
    }

    @Override
    protected void appendToPath(Path path, PointF thisPoint, PointF lastPoint) {
        //path.lineTo(thisPoint.x, thisPoint.y);

        // bezier curve version:
        PointF mid = new PointF();
        mid.set((lastPoint.x + thisPoint.x) / 2, (lastPoint.y + thisPoint.y) / 2);
        path.quadTo((lastPoint.x + mid.x) / 2, lastPoint.y, mid.x, mid.y);
        //path.quadTo((mid.x + thisPoint.x) / 2, thisPoint.y, thisPoint.x, thisPoint.y);
        path.quadTo((mid.x + thisPoint.x) / 2, lastPoint.y, thisPoint.x, thisPoint.y);

    }
}
