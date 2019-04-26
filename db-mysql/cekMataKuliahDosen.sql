SELECT LTRIM(CONCAT(d.GelarDepanDosen, CONCAT(' ', CONCAT(d.NamaDepanDosen,
 CONCAT(' ', CONCAT(d.NamaBelakangDosen , CONCAT(' ', d.GelarBelakangDosen))))))) AS 'Nama Lengkap', 
 mk.namamatakuliah, j.KelasJadwalKelas, j.WaktuJadwalKelas, j.RuangJadwalKelas
 FROM dbsistemakademik.dosen d
 JOIN dbsistemakademik.jadwalkelas j ON d.NIKDosen = j.Dosen_NIKDosen
 JOIN dbsistemakademik.matakuliah mk ON mk.KodeMataKuliah = j.MataKuliah_KodeMataKuliah
