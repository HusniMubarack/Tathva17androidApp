package com.tathva17.tathva.tathva17;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Husni Mubarack on 08-Oct-17.
 */

public class EventsLoadAdapter extends ArrayAdapter<String> {
    public EventsLoadAdapter(@NonNull Context context, @NonNull ArrayList<String> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String current = getItem(position);

        switch (current){
            case "blitzspark1":
                current = "BoardRoom";
                break;
            case "blitzspark3":
                current = "Interface Startup";
                break;
            case "blitzspark4":
                current = "Alcestis";
                break;
            case "chemical1":
                current = "Cheo Propello";
                break;
            case "chemical2":
                current = "Concorso";
                break;
            case "chemical3":
                current = "Interrupter";
                break;
            case "civil1":
                current = "CAD Art";
                break;
            case "civil2":
                current = "Descartes Square";
                break;
            case "civil3":
                current = "Linkidge";
                break;
            case "civil4":
                current = "Skyscrapers";
                break;
            case "civil5":
                current = "Bob The Builder";
                break;
            case "cs1":
                current = "Hackaholic";
                break;
            case "cs2":
                current = "KoderKombat";
                break;
            case "cs3":
                current = "Debugger";
                break;
            case "cs4":
                current = "Tux of War";
                break;
            case "electrical1":
                current = "Accelero Botx";
                break;
            case "electrical2":
                current = "Circuit Race";
                break;
            case "electrical3":
                current = "Coil Gun";
                break;
            case "electrical4":
                current = "Digi Mania";
                break;
            case "electronics1":
                current = "Analog IQ";
                break;
            case "electronics2":
                current = "E Racer";
                break;
            case "electronics3":
                current = "GSM Labyrinth";
                break;
            case "envision1":
                current = "Srishti";
                break;
            case "envision2":
                current = "BluePrint";
                break;
            case "general1":
                current = "Inquisito Virtuoso";
                break;
            case "general2":
                current = "Tathva Cube Open";
                break;
            case "general3":
                current = "Log IQ";
                break;
            case "general4":
                current = "Treasure Hunt";
                break;
            case "general5":
                current = "skills N thrills";
                break;
            case "mech1":
                current = "Albatross";
                break;
            case "mech2":
                current = "Aqua Strike";
                break;
            case "mech3":
                current = "Contraption";
                break;
            case "mech4":
                current = "Hover Drive";
                break;
            case "mech5":
                current = "MachnaScene";
                break;
            case "mech6":
                current = "MechTrakhi";
                break;
            case "mech7":
                current = "MindKraft";
                break;
            case "mech8":
                current = "Aqua GT";
                break;
            case "physics1":
                current = "Aerogami";
                break;
            case "quiz1":
                current = "Artha";
                break;
            case "quiz2":
                current = "Kick Off";
                break;
            case "quiz3":
                current = "Mela";
                break;
            case "quiz4":
                current = "Prahelika";
                break;
            case "robotics1":
                current = "Amazed";
                break;
            case "robotics2":
                current = "Collision Course";
                break;
            case "robotics3":
                current = "Death Race";
                break;
            case "robotics4":
                current = "Dirt Race";
                break;
            case "robotics5":
                current = "League Of Machines";
                break;
            case "robotics6":
                current = "Schwimmwagen";
                break;
            case "robotics7":
                current = "Transporter";
                break;
            default:
                current = "Other";
        }


        View ListItem = convertView;
        if(ListItem == null){
            ListItem = LayoutInflater.from(getContext()).inflate(R.layout.registered_item,parent,false);
        }
        TextView textView = (TextView)ListItem.findViewById(R.id.registered_event_name);
        textView.setText(current);

        return ListItem;

    }
}
