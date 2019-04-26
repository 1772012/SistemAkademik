SELECT m.NRPMahasiswa, CONCAT(m.NamaDepanMahasiswa, CONCAT(' ',m.NamaBelakang)) "Nama Mahasiswa"
FROM dbsistemakademik.mahasiswa m
JOIN dbsistemakademik.jadwalkelas j ON m.NRPMahasiswa = j.Mahasiswa_NRPMahasiswa
JOIN dbsistemakademik.matakuliah mk ON j.MataKuliah_KodeMataKuliah = mk.KodeMataKuliah
WHERE mk.NamaMataKuliah = 'PEMROGRAMAN BERORIENTASI OBJEK 2B'