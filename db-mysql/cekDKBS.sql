SELECT j.SemesterJadwalKelas, j.KelasJadwalKelas, j.RuangJadwalKelas, j.WaktuJadwalKelas, mk.KodeMataKuliah, mk.NamaMataKuliah, mk.SKSPraktikumMataKuliah , mk.SKSTeoriMataKuliah
FROM dbsistemakademik.mahasiswa m
JOIN dbsistemakademik.jadwalkelas j ON m.NRPMahasiswa = j.Mahasiswa_NRPMahasiswa
JOIN dbsistemakademik.matakuliah mk ON j.MataKuliah_KodeMataKuliah = mk.KodeMataKuliah
WHERE m.nrpmahasiswa = '1702002'