package com.tathva17.tathva.tathva17;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Husni Mubarack on 08-Oct-17.
 */

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    private static  final String TAG = "FirebaseMessagingService";
    private static final String DB_NAME = "NOTIFICATIONS";
    public FirebaseMessagingService() {

    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if(remoteMessage.getData().size()>0){

        }

        if(remoteMessage.getNotification() != null){
        String title = remoteMessage.getNotification().getTitle();
        String message = remoteMessage.getNotification().getBody();

        sendNotification(title,message);



        }


    }

    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();
    }

    private void sendNotification(String title, String messageBody) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Notification forgroundNote;
        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.notification_item);
        contentView.setImageViewResource(R.id.notify_icon, R.mipmap.ic_tathva17);
        contentView.setTextViewText(R.id.title10, title);
        contentView.setTextViewText(R.id.text10,messageBody);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSound(defaultSoundUri)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContent(contentView);
        Notification notification = mBuilder.build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_VIBRATE;
        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);





    }
}
