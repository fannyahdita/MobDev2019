# WEEK 3 : TIMER APP AND OVERRIDE BACK BUTTON

## Override Back Button
Saya membuat aplikasi sederhana dimana pengguna tidak dapat keluar dari aplikasi dengan
menggunakan tombol back, melainkan harus menekan tombol yang disediakan.
Untuk mengimplementasikannya, saya melakukan override function onBackPressed(), dimana
setiap user menekan back, akan muncul Toast.
Pengguna baru akan dapat keluar dari aplikasi ketika menekan tombol Exit.

## MEMBUAT APP YANG BERJALAN DI BACKGROUND
Saya membuat aplikasi timer untuk menghitung mundur selama 10 menit. Saya menggunakan
module dari CountDownTimer untuk menjalankan program.

Agar dapat berjalan di background, saya melakukan override pada fungsi onStart dan onStop.
Dengan melakukan override pada method onStart(), aplikasi saya dapat melanjutkan kembali
hasil countdown berdasarkan currentTimeMilis(). Saat onStop() SharedPreferences digunakan
untuk menyimpan informasi waktu yang tersisa. Sehingga meskipun aplikasi tidak dibuka
countdown seakan akan tetap berjalan di belakang.

Aplikasi timer yang saya implementasikan memiliki button start, pause, dan reset. Saat pengguna
menekan start, makan timer akan berjalan dan tombol akan berganti tulisan menjadi pause
bersamaan dengan munculnya tombol reset. Saat user menekan pause, maka tombol pause akan
text akan kembali menjadi start. Saat pengguna menekan reset, maka timer akan kembali ke
waktu awal 10:00.
Pada aplikasi timer ini, saya hanya mengimplementasikan setOnClickListener untuk button pada
onCreate().
