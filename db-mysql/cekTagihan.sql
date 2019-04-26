SELECT t.NamaTagihan, t.Biaya, t.StatusLunas
FROM dbsistemakademik.mahasiswa m
JOIN dbsistemakademik.tagihan t
ON m.NRP = t.Mahasiswa_NRP
WHERE m.NRP = '1702001';