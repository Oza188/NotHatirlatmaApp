# NotHatirlatmaApp
Android tabanlı basit bir "not alma ve hatırlatma uygulaması". Kullanıcılar bir not girerek uygulama üzerinden kolayca bu notu kaydedebilir. Uygulamanın amacı, kullanıcıya basit ve işlevsel bir şekilde notlarını hatırlatabilecek bir yapı sunmaktır.


## Özellikler
Not girme
Notu kaydetme
Toast mesajı ile uyarı

## Kullanım
Uygulamayı aç, notunu yaz, "Kaydet" butonuna bas.

## Proje Yapısı

text
NotHatirlatmaApp/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/nothatirlatmaapp/
│   │       │   ├── MainActivity.java
│   │       │   └── ReminderReceiver.java
│   │       └── res/
│   │           ├── layout/activity_main.xml
│   │           ├── mipmap/
│   │           └── values/
│   └── AndroidManifest.xml
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md

## Örnek Kod (MainActivity'den parça)

```java
calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
calendar.set(Calendar.MINUTE, timePicker.getMinute());

alarmManager.setExact(
    AlarmManager.RTC_WAKEUP,
    calendar.getTimeInMillis(),
    pendingIntent
);

## Geliştirici
Hudhaifa Omar Farooq
