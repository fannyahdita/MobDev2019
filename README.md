# WEEK 1 : HELLO WORLD APP

## Instalasi Android Development Kit
Android Studio dapat di-install pada https://developer.android.com/studio/. Android Software Development Kit (SDK) sudah termasuk dalam instalasi Android Studio. Untuk mengatur SDK dapat melalui Tools > SDK Manager.

## Deskripsi Hello World 
Tampilan yang dibuat menggunakan Constraint Layout dengan textView di tengah-tengahnya. Pada testView tercetak tulisan “Hello World!”.
Tampilan ini menggunakan default app theme dari Android Studio. Sehingga pada Bar, menggunakan DarkActionBar dengan tampilan label bertuliskan “First”.
Tugas ini dikerjakan secara mandiri.

## Cara Pengerjaan
1. Membuat project baru dengan menggunakan Android Studio dengan memilih “Empty Application” pada tab “Phone and Tablet”
2. Memberi nama proyek dan menentukan Minimum API Level. Saya memilih API 28 : Android 9.0 (Pie)
3. Setelah itu, Android Studio akan mengunduh required gradle files yang akan digunakan dan melakukan gradle build.
4. Kemudian, secara default akan terbentuk MainActivity.kt dan activity_main.xml untuk layoutnya. Layout yang digunakan adalah Constraint Layout. Lalu, saya memindahkan values string Hello World ke strings.xml
5. Untuk DarkActionBar dan manifest, saya tetap menggunakan default dari new project Android Studio.
6. Kemudian, untuk emulator, saya menggunakan salah satu dari default option , dengan perubahan pada ukuran RAM agar dapat menyesuaikan dengan resource pada device yang saya gunakan.

## Keterangan
- Saya memilih Minimum API Level 28 karena menurut Google Play sendiri, aplikasi baru harus memiliki target API minimum Android 9.0 (Pie) atau API level 28. Sehingga saya langsung memilih API Level 28 untuk dijadikan minimum API Level.
- Saya memilih menggunakan Constraint Layout karena menurut saya jenis layout tersebut cukup fleksibel dan mudah untuk ditata, apabila kedepannya akan ditambahkan elemen lain dengan tampilan dan desain yang padat.

## Daftar Pustaka
Meet Google Play's target API level requirement (n.d) Retrieved from https://developer.android.com/distribute/best-practices/develop/target-sdk
