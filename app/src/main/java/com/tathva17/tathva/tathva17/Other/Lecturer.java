package com.tathva17.tathva.tathva17.Other;


import com.tathva17.tathva.tathva17.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by burgers on 28/8/17.
 */

public class Lecturer {

    private String name,desc,time;
    private int pic;


    /*public Lecturer(String name, String designation, int pic) {
        this.name = name;
        this.designation = designation;
        this.pic = pic;
    }*/

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }


    public static List<Lecturer> getObjectlist() {

        List<Lecturer> datalist = new ArrayList<>();
        int[] images = getImages();
        String[] n = getNames();
        String[] d = getDesigs();
        String[] t = getTimes();
        for(int i = 0; i< images.length;++i){
            Lecturer lect = new Lecturer();
            lect.setName(n[i]);
            lect.setDesc(d[i]);
            lect.setTime(t[i]);
            lect.setPic(images[i]);
            datalist.add(lect);
        }
        return  datalist;
    }


    private static int[] getImages(){

        int[] images = {
                R.drawable.zubin_deboo,
                R.drawable.manoj_dharmarajan,
                R.drawable.r_chidambaram,
                R.drawable.atul_gurtu,
                R.drawable.praveen,
                R.drawable.nisheeth_singh,
                R.drawable.kartik_sheth
        };
        return images;
    }


    private static String[] getNames(){

        String[] names= {"Zubin Deboo","Manoj Dharmajan","Dr R Chidambaram","Atul Gurtu","Praveen Vettiyatil","Nisheeth Singh","Kartik Sheth"};
        return names;
    }

    private static String[] getDesigs(){
        String[] desigs = {"Executive Director of Krishna Consultants","Former Director, Dept of Telecommunication","Chief Scientific Advisor,Govt of India",
                "Experimental High Energy Physicist","President of YCI Technologies","At Graviky, leads technical development on pollution capture technologies.","Astrophysicist, NASA"};
        return desigs;
    }

    private static String[] getTimes(){
        String[] times = {"Oct 13,10 am","Oct 13,1.30 pm","Oct 13,4.30 pm","Oct 14,10 am","Oct 14,1.30 pm","Oct 14, 4.30 pm","Oct 15,11 am"};
        return times;
    }
}

