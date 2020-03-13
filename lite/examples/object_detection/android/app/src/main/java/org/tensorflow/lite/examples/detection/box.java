package org.tensorflow.lite.examples.detection;

import android.util.Log;

public class box {
    private float left,right,top,bottom;


    public box(float left, float right, float top, float bottom) {
        this.left=left;
        this.right=right;
        this.top=top;
        this.bottom=bottom;

    }

    public double iou(box other){
        float x_left = max(other.left, left);
        float y_top = max(other.top, top);
        float x_right = min(other.right, right);
        float y_bottom = min(other.bottom, bottom);
//        if (x_right < x_left && y_bottom < y_top)
//            return 0;
        float intersection_area = (x_right - x_left) * (y_bottom - y_top);
        float bb1_area = (right - left) * (bottom- top);
        float bb2_area = (other.right - other.left) * (other.bottom - other.top);
        double iou = intersection_area / ((bb1_area + bb2_area - intersection_area)*1.0);
        return iou;
    }
    private  float max(float a,float b){
        if(a>b)
            return  a;
        return  b;
    }
    private  float min(float a, float b){
        if(a<b)
            return a;
        return  b;
    }
}
