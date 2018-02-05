package com.tathva17.tathva.tathva17.Other;


import com.tathva17.tathva.tathva17.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by burgers on 28/8/17.
 */

public class Workshop {

    private String name,desc;
    private int pic;


    /*public Lecturer(String name, String designation, int pic) {
        this.name = name;
        this.designation = designation;
        this.pic = pic;
    }*/

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


    public static List<Workshop> getObjectlist() {

        List<Workshop> datalist = new ArrayList<>();
        int[] images = getImages();
        String[] n = getNames();

        for(int i = 0; i< images.length;++i){
            Workshop lect = new Workshop();
            lect.setName(n[i]);

            lect.setPic(images[i]);
            datalist.add(lect);
        }
        return  datalist;
    }


    private static int[] getImages(){

        int[] images = { R.drawable.ai,
                         R.drawable.bigdata,
                         R.drawable.green_building,
                         R.drawable.hacking,
                         R.drawable.ic_engine,
                         R.drawable.iot,
                         R.drawable.nlp,
                         R.drawable.quadcopter,
                         R.drawable.sixth_sense,
                         R.drawable.swarm

        };
        return images;
    }


    private static String[] getNames(){

        String[] names=//{"Saitama","Naruto","Luffy","Itachi","Ichigo","Law","DLaw","DLaw","DLaw","DLaw"};
                {"Artificial Intelligence","Big Data and Hadoop","Green Building","Information Security","IC Engine","Internet of Things","NLP","Quadcopter","Sixth Sense Technology","Swarm Robotics"};
        return names;
    }



}

