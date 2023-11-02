# language: id
#@skipped
Fitur: Cari Tagihan Pembayaran

  Dasar:
    Dengan akses menu "pembayaran"                             
      
  Skenario: user mencari berdasarkan nama                 
    Dengan user berada di halaman "Tagihan"
    Ketika user mencari berdasarkan nama
    Maka sistem akan menampilkan tagihan yang dicari
  
  Skenario: user mencari berdasarkan tanggal                     
    Dengan user telah berada di halaman "Tagihan"
    Ketika user memilih tanggal
    Maka sistem akan menampilkan tagihan sesuai tanggal yang dipilih