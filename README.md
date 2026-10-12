# TP4DPBO2526C1
janji : Saya Aracelli Jasmine Malaika dengan NIM 2501804 mengerjakan Tugas Praktikum 4 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

# Deskripsi Program
Program ini merupakan aplikasi desktop sederhana bernama **PeopleData** yang dibuat menggunakan bahasa pemrograman Java dengan Java Swing GUI. Program ini digunakan untuk mengelola data orang dengan tema Data Mahasiswa.

Program memiliki lima atribut, yaitu ID, Nama, Tahun Lahir, Kategori, dan Jenis Kelamin. Empat atribut pertama merupakan atribut awal sesuai ketentuan tugas praktikum, sedangkan Jenis Kelamin merupakan atribut tambahan yang menggunakan komponen `JComboBox` sebagai bonus karena bukan berupa `JTextField`.

Program menyediakan fitur CRUD (*Create, Read, Update, Delete*) untuk menambahkan, menampilkan, mengubah, dan menghapus data. Data disimpan menggunakan `ArrayList<Person>` selama program berjalan.

# Desain Program
## 1. Class Person
Class `Person` digunakan untuk menyimpan informasi setiap orang. Class ini memiliki lima atribut, yaitu:

* `id` bertipe data `int` untuk menyimpan ID orang.
* `nama` bertipe data `String` untuk menyimpan nama orang.
* `tahunLahir` bertipe data `int` untuk menyimpan tahun lahir.
* `kategori` bertipe data `String` untuk menyimpan kategori orang.
* `jenisKelamin` bertipe data `String` untuk menyimpan jenis kelamin.

Class `Person` memiliki constructor untuk menginisialisasi seluruh atribut, getter untuk mengambil nilai atribut, serta setter untuk mengubah data yang diperlukan.

## 2. Class PeopleMenu
Class `PeopleMenu` digunakan untuk mengatur tampilan antarmuka dan logika program menggunakan Java Swing GUI.

Komponen yang digunakan pada program ini antara lain:

* `JPanel` sebagai panel utama aplikasi.
* `JTextField` untuk memasukkan ID, nama, dan tahun lahir.
* `JComboBox` untuk memilih kategori dan jenis kelamin.
* `JButton` untuk menjalankan operasi CRUD dan membersihkan form.
* `JTable` untuk menampilkan data orang.
* `DefaultTableModel` untuk mengatur data yang ditampilkan pada tabel.
* `ArrayList<Person>` untuk menyimpan kumpulan objek Person selama program berjalan.
* `JOptionPane` untuk menampilkan pesan informasi, kesalahan, dan konfirmasi penghapusan.

## 3. Method Utama
| Method           | Fungsi                                                         |
| ---------------- | -------------------------------------------------------------- |
| `main()`         | Membuat dan menampilkan jendela utama aplikasi.                |
| `PeopleMenu()`   | Menginisialisasi data, ComboBox, tabel, dan listener komponen. |
| `populateList()` | Menambahkan data awal ke dalam ArrayList.                      |
| `setTable()`     | Menampilkan data dari ArrayList ke JTable.                     |
| `insertData()`   | Memvalidasi input dan menambahkan data baru.                   |
| `updateData()`   | Mengubah data orang yang dipilih.                              |
| `deleteData()`   | Menghapus data setelah pengguna mengonfirmasi penghapusan.     |
| `clearForm()`    | Mengosongkan form dan mengembalikan pilihan ke kondisi awal.   |

# Fitur Program
## 1. Create (Tambah Data)
Pengguna dapat menambahkan data orang dengan mengisi ID, nama, tahun lahir, memilih kategori, dan memilih jenis kelamin. Setelah tombol Tambah ditekan, program memeriksa input dan memastikan ID belum digunakan. Jika input valid, data akan ditambahkan ke ArrayList dan ditampilkan pada tabel.

## 2. Read (Tampilkan Data)
Seluruh data orang ditampilkan menggunakan JTable. Program menyediakan tiga data awal, yaitu Ara, Budi, dan Citra. Pengguna juga dapat memilih baris pada tabel untuk menampilkan kembali data tersebut pada form.

## 3. Update (Ubah Data)
Pengguna dapat memilih data pada tabel, kemudian mengubah nama, tahun lahir, kategori, atau jenis kelamin melalui form. Setelah tombol Update ditekan, perubahan akan diterapkan pada data yang dipilih dan tabel diperbarui.

## 4. Delete (Hapus Data)
Pengguna dapat memilih data yang ingin dihapus, kemudian menekan tombol Hapus. Program menampilkan dialog konfirmasi sebelum penghapusan dilakukan. Jika pengguna memilih Yes, data akan dihapus dari ArrayList. Jika memilih No, penghapusan dibatalkan.

## 5. Clear (Bersihkan Form)
Tombol Clear digunakan untuk mengosongkan seluruh input, mengembalikan pilihan ComboBox ke pilihan pertama, menghapus pilihan baris pada tabel, dan mengaktifkan kembali input ID.

## 6. Validasi Input
Program melakukan beberapa validasi untuk menjaga data yang dimasukkan, yaitu:

* ID harus berupa angka dan tidak boleh kosong.
* Nama tidak boleh kosong.
* Tahun lahir harus berupa angka.
* ID tidak boleh sama dengan ID data yang sudah tersedia.
* Data hanya dapat diubah atau dihapus setelah pengguna memilih baris pada tabel.

# Alur Program
1. Program dijalankan melalui method `main()` yang membuat jendela aplikasi PeopleData.
2. Constructor `PeopleMenu()` menginisialisasi ArrayList, pilihan kategori dan jenis kelamin, data awal, tabel, serta listener tombol dan tabel.
3. Method `populateList()` memasukkan tiga data awal ke dalam ArrayList.
4. Method `setTable()` menampilkan data yang tersimpan ke dalam JTable.
5. Ketika pengguna menekan tombol Tambah, program memvalidasi input. Jika valid, objek Person baru ditambahkan ke ArrayList dan tabel diperbarui.
6. Ketika pengguna memilih baris pada tabel, data yang dipilih dimuat kembali ke form agar dapat diubah atau dihapus.
7. Ketika tombol Update ditekan, program memperbarui atribut data yang dipilih dan menampilkan hasilnya pada tabel.
8. Ketika tombol Hapus ditekan, program menampilkan dialog konfirmasi. Data hanya dihapus apabila pengguna menyetujui penghapusan.
9. Ketika tombol Clear ditekan, form dikosongkan dan dikembalikan ke kondisi awal.

Data program disimpan sementara di dalam ArrayList. Oleh karena itu, perubahan data tidak dipertahankan ketika aplikasi ditutup atau dijalankan ulang.

# Dokumentasi Program
## 1. Tampilan Awal
Tampilan awal aplikasi menunjukkan form input data orang serta tabel yang berisi tiga data awal.

<img width="689" height="650" alt="1-tampilanawal" src="https://github.com/user-attachments/assets/5f36d434-283f-45b4-bb27-2259239065e6" />

## 2. Create — Mengisi Form
Pengguna memasukkan ID, nama, tahun lahir, kategori, dan jenis kelamin sebelum menekan tombol Tambah.

<img width="687" height="648" alt="2-sebelumadd" src="https://github.com/user-attachments/assets/2d45c52c-a975-4ad5-ac07-1e0e5633c582" />

## 3. Create — Berhasil Menambahkan Data
Setelah tombol Tambah ditekan dan input dinyatakan valid, data baru ditambahkan ke tabel dan program menampilkan pesan keberhasilan.

<img width="692" height="657" alt="3-tambahdata" src="https://github.com/user-attachments/assets/0bc6d687-06a2-4376-94c0-9052b2493763" />
<img width="690" height="639" alt="4-tambahdata" src="https://github.com/user-attachments/assets/652cdd4d-642f-4f26-9614-f126af69a78d" />

## 4. Update — Memilih dan Mengubah Data
Pengguna memilih salah satu baris pada tabel. Data tersebut dimuat ke form, kemudian pengguna mengubah informasi yang diperlukan.

<img width="690" height="653" alt="5-sebelumubah" src="https://github.com/user-attachments/assets/71901dd6-e894-4235-8d87-686365056b19" />

## 5. Update — Berhasil Mengubah Data
Setelah tombol Update ditekan, perubahan diterapkan pada data yang dipilih dan hasilnya ditampilkan kembali pada tabel.

<img width="690" height="655" alt="6-sesudahubah" src="https://github.com/user-attachments/assets/6fd2e76c-7bdb-4ce4-a55b-1412d19ceb56" />
<img width="688" height="656" alt="7-sesudahubah" src="https://github.com/user-attachments/assets/71b88720-0201-4e3f-a5e5-7e05e30215d6" />

## 6. Delete — Konfirmasi Penghapusan
Ketika tombol Hapus ditekan setelah memilih data, program menampilkan dialog konfirmasi untuk memastikan pengguna ingin menghapus data tersebut.

<img width="690" height="653" alt="8-sebelumhapus" src="https://github.com/user-attachments/assets/03b73346-2342-4a6b-9227-c66d17ec249e" />
<img width="687" height="657" alt="9-yakinhapus" src="https://github.com/user-attachments/assets/fcedad54-e9cf-4323-9ccb-9f6332525fca" />

## 7. Delete — Berhasil Menghapus Data
Setelah pengguna menyetujui penghapusan, data dihapus dari tabel dan program menampilkan pesan bahwa penghapusan berhasil dilakukan.

<img width="689" height="662" alt="10-hapus" src="https://github.com/user-attachments/assets/8c8cbd53-011f-4775-ac43-97808861ba65" />
<img width="689" height="655" alt="11-setelahhapus" src="https://github.com/user-attachments/assets/b8b3e59e-c7c2-4202-a625-bca9bc665c42" />

# Kesimpulan
Program PeopleData merupakan aplikasi pengelolaan data orang berbasis Java Swing GUI yang menerapkan konsep pemrograman berorientasi objek melalui class Person dan PeopleMenu.

Program ini memiliki fitur CRUD, menggunakan ArrayList sebagai penyimpanan sementara, menampilkan data melalui JTable, serta menyediakan validasi input dan konfirmasi sebelum penghapusan. Penambahan atribut Jenis Kelamin menggunakan JComboBox juga menjadi pengembangan komponen GUI non-JTextField sesuai ketentuan tugas praktikum.
