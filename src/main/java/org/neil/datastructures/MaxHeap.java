package org.neil.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author neil
 * @date 2019-02-22
 */
public class MaxHeap<T extends Comparable<T>> {
    private List<T> mHeap;

    public MaxHeap() {
        this.mHeap = new ArrayList<>();
    }


    /**
     * 添加元素
     * @param t
     */
    public void insert(T t){
        insert(t,mHeap);
    }

    private void insert(T t, List<T> mHeap) {
        mHeap.add(t);

        int thisX = mHeap.indexOf(t);
        up(mHeap, thisX);
    }

    private void up(List<T> mHeap, int thisX) {
        while (thisX > 0 ){
            int fathX = (thisX-1)/2;
            T fathT = mHeap.get(fathX);
            T thisT = mHeap.get(thisX);
            if(thisT.compareTo(fathT) > 0){
                mHeap.set(thisX,fathT);
                mHeap.set(fathX,thisT);
                thisX = fathX;
            }else {
                break;
            }
        }
    }


    /**
     *
     * @param list
     */
    public List<T> adjust2MaxHeap(List<T> list,int size){

        for (int i = size/2 - 1; i >= 0; i--) {
            down(list,i,size);
        }

        return list;
    }


    /**
     * 删除元素
     * @param t
     */
    public void remove(T t){
        remove(t,mHeap);
    }


    private void remove(T t, List<T> mHeap) {
        int last = mHeap.size()-1;
        int thisx = mHeap.indexOf(t);
        while (thisx < last){
            T thisT = mHeap.get(last);
            mHeap.set(thisx, thisT);
            int leftx = thisx*2+1;
            int rightx = thisx*2+2;
            if(leftx <= last && rightx <= last){
                T leftT = mHeap.get(leftx);
                T rightT = mHeap.get(rightx);
                T maxT = leftT.compareTo(rightT)>0?leftT:rightT;
                int maxX = leftT.compareTo(rightT)>0?leftx:rightx;
                mHeap.set(thisx,maxT);
                mHeap.set(maxX,thisT);
                thisx = maxX;
            }else if(leftx <= last && rightx > last){
                T leftT = mHeap.get(leftx);
                mHeap.set(thisx,leftT);
                mHeap.set(leftx,thisT);
                thisx = leftx;
            }else if(rightx <= last && leftx > last){
                T rightT = mHeap.get(rightx);
                mHeap.set(thisx,rightT);
                mHeap.set(rightx,thisT);
                thisx = rightx;
            }else {
                break;
            }
        }
        mHeap.remove(last);

    }

    private void down(List<T> mHeap, int current,int size) {
        while (current >= 0){
            downEvery(mHeap, current,size);
            current--;
        }

    }

    private void downEvery(List<T> mHeap, int current,int size) {
        int leftX = current*2+1;
        int rightX = current*2+2;
        T maxT;
        int maxX;
        if(leftX < size){
            T leftT = mHeap.get(leftX);
            if(rightX <= size-1){
                T rightT = mHeap.get(rightX);
                maxT = leftT.compareTo(rightT)>0?leftT:rightT;
                maxX = leftT.compareTo(rightT)>0?leftX:rightX;

            }else{
                maxT = leftT;
                maxX = leftX;
            }

            T currentT = mHeap.get(current);
            if(maxT.compareTo(currentT)>0){
                mHeap.set(current,maxT);
                mHeap.set(maxX,currentT);
                downEvery(mHeap,maxX,size);
            }
        }

    }


    public List<T> getmHeap() {
        return mHeap;
    }

    public void setmHeap(List<T> mHeap) {
        this.mHeap = mHeap;
    }
}
