package com.tathva17.tathva.tathva17.Other;

import com.tathva17.tathva.tathva17.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by burgers on 28/8/17.
 */

public class Exhibition {

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


    public static List<Exhibition> getObjectlist() {

        List<Exhibition> datalist = new ArrayList<>();
        int[] images = getImages();
        String[] n = getNames();

        for(int i = 0; i< images.length;++i){
            Exhibition lect = new Exhibition();
            lect.setName(n[i]);

            lect.setPic(images[i]);
            datalist.add(lect);
        }
        return  datalist;
    }


    private static int[] getImages(){

        int[] images = {
                R.drawable.e1,
                R.drawable.e2,
                R.drawable.e3,
                R.drawable.e4,
                R.drawable.e5,
                R.drawable.e6,
                R.drawable.e7,
                R.drawable.e8,
                R.drawable.e9,
                R.drawable.e10,
                R.drawable.e11

        };
        return images;
    }


    private static String[] getNames(){

        String[] names= {"Humanoid Robots","Quadcopter","Hexacopter","3D Printer","3D Pen","Mind Controlled Helicopter","Bionic Birds",
                "Ornithopter","Minidrones","Medical College","Robotic Arm"};
        return names;
    }



}

