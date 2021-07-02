-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 02 Jul 2021 pada 10.17
-- Versi server: 10.4.14-MariaDB
-- Versi PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uks`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_ambilobat`
--

CREATE TABLE `t_ambilobat` (
  `kode_ambilobat` int(11) NOT NULL,
  `obat` varchar(50) NOT NULL,
  `obat1` varchar(50) NOT NULL,
  `obat2` varchar(50) NOT NULL,
  `nama` int(25) NOT NULL,
  `nama1` int(25) NOT NULL,
  `nama2` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `t_ambilobat`
--

INSERT INTO `t_ambilobat` (`kode_ambilobat`, `obat`, `obat1`, `obat2`, `nama`, `nama1`, `nama2`) VALUES
(19, 'O001', 'O004', 'O005', 1, 1, 1),
(23, 'O001', '', '', 1, 0, 0),
(25, 'O001', '', '', 0, 0, 0),
(26, 'O001', '', '', 1, 0, 0),
(27, 'O001', 'O002', '', 1, 0, 0),
(28, 'O001', 'O004', 'O005', 0, 0, 0),
(29, 'O001', 'O004', 'O005', 0, 0, 0),
(30, 'O001', '', '', 0, 0, 0),
(31, 'O001', 'O002', '', 1, 0, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_inventaris`
--

CREATE TABLE `t_inventaris` (
  `kode_inventaris` varchar(11) NOT NULL,
  `tahun` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jml` varchar(20) NOT NULL,
  `sumber` varchar(50) NOT NULL,
  `keterangan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `t_inventaris`
--

INSERT INTO `t_inventaris` (`kode_inventaris`, `tahun`, `nama`, `jml`, `sumber`, `keterangan`) VALUES
('I001', '2020', 'Kotak P3K', '1', 'Dana Bos', 'Sangat Baik'),
('I002', '2020', 'Meja', '2', 'Dana Bos', 'Sangat Baik'),
('I003', '2021', 'Kasur', '1', 'Dana Bos', 'Sangat Baik'),
('I004', '2021', 'Sfigmomanometer', '2', 'Dana Bos', 'Sangat Baik');

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_keluhan`
--

CREATE TABLE `t_keluhan` (
  `kode_keluhan` int(11) NOT NULL,
  `kode_list` varchar(11) NOT NULL,
  `kode_list_1` varchar(11) NOT NULL,
  `kode_list_2` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `t_keluhan`
--

INSERT INTO `t_keluhan` (`kode_keluhan`, `kode_list`, `kode_list_1`, `kode_list_2`) VALUES
(27, 'K001', '', ''),
(28, 'K001', '', ''),
(29, 'K001', '', ''),
(30, 'K001', '', ''),
(31, 'K001', '', ''),
(33, 'K001', '', ''),
(34, 'K001', '', ''),
(39, 'K001', '', ''),
(35, 'K001', 'K002', ''),
(40, 'K001', 'K002', ''),
(36, 'K001', 'K004', ''),
(37, 'K001', 'K004', ''),
(26, 'K001', 'K004', 'K005');

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_listkeluhan`
--

CREATE TABLE `t_listkeluhan` (
  `kode_list` varchar(11) NOT NULL,
  `keluhan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `t_listkeluhan`
--

INSERT INTO `t_listkeluhan` (`kode_list`, `keluhan`) VALUES
('K001', 'Badan Panas'),
('K002', 'Sakit Perut'),
('K003', 'Sakit Gigi'),
('K004', 'Tenggorokkan Kering'),
('K005', 'Tenggorokkan Gatal');

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_pasien`
--

CREATE TABLE `t_pasien` (
  `kode_pasien` varchar(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `status` varchar(20) NOT NULL,
  `nis_nip` int(30) NOT NULL,
  `tempat` varchar(30) NOT NULL,
  `tgl` varchar(20) NOT NULL,
  `jekel` varchar(2) NOT NULL,
  `no` varchar(20) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `gol` varchar(10) NOT NULL,
  `alergi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `t_pasien`
--

INSERT INTO `t_pasien` (`kode_pasien`, `nama`, `status`, `nis_nip`, `tempat`, `tgl`, `jekel`, `no`, `alamat`, `gol`, `alergi`) VALUES
('P001', 'Dinil', 'Siswa', 19112233, 'Pekanbaru', '2005-10-23', 'L', '081277746448', 'Jl. Usaha', 'O', 'Daging'),
('P002', 'Ulil', 'Guru', 1911081009, 'Pekanbaru', '2000-10-23', 'L', '081277746448', 'Jl. Usaha', 'A', 'Asap'),
('P003', 'Olla', 'Guru', 191108, 'Payakumbuh', '2001-02-14', 'P', '0812193213', 'Jl. Koto kociak', 'B', 'Asam'),
('P004', 'Aulia', 'Siswa', 1911081001, 'Bukittinggi', '2000-07-12', 'L', '08123912312', 'Jl. Ceria', 'AB', 'Udara Dingin'),
('P005', 'Rafi', 'Siswa', 1911081004, 'Payakumbuh', '2001-06-01', 'L', '08123912312', 'Jl. Apa', 'A', 'Udara Dingin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_pemeriksaan`
--

CREATE TABLE `t_pemeriksaan` (
  `kode_periksa` varchar(11) NOT NULL,
  `kode_keluhan` int(11) NOT NULL,
  `kode_ambilobat` int(11) NOT NULL,
  `kode_pasien` varchar(11) NOT NULL,
  `kode_petugas` varchar(11) NOT NULL,
  `diagnosa` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `t_pemeriksaan`
--

INSERT INTO `t_pemeriksaan` (`kode_periksa`, `kode_keluhan`, `kode_ambilobat`, `kode_pasien`, `kode_petugas`, `diagnosa`) VALUES
('KP001', 26, 19, 'P001', 'P001', 'Demam'),
('KP002', 34, 26, 'P003', 'P002', 'Demam');

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_petugas`
--

CREATE TABLE `t_petugas` (
  `kode_petugas` varchar(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `jekel` varchar(15) NOT NULL,
  `no_hp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `t_petugas`
--

INSERT INTO `t_petugas` (`kode_petugas`, `nama`, `alamat`, `jekel`, `no_hp`) VALUES
('P001', 'Ulil Ambri', 'Jl. Usaha ', 'L', '081277746448'),
('P002', 'Ikhsan', 'Jl. Ceria', 'L', '0812123123'),
('P003', 'Nola', 'Jl. pepaya', 'P', '0823123112'),
('P004', 'Nikita', 'Jl. Indah', 'P', '0812312319123'),
('P005', 'Rafi', 'Jl. Indah', 'L', '0812312319123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_stokobat`
--

CREATE TABLE `t_stokobat` (
  `kode_obat` varchar(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `satuan` varchar(10) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `t_stokobat`
--

INSERT INTO `t_stokobat` (`kode_obat`, `nama`, `satuan`, `stok`) VALUES
('O001', 'Paracetamol', 'Tablet', 95),
('O002', 'Antasida', 'Tablet', 98),
('O003', 'Ponstan', 'Tablet', 100),
('O004', 'Paratusin', 'Tablet', 99),
('O005', 'Salbutamol', 'Tablet', 99);

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_user`
--

CREATE TABLE `t_user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `hak_akses` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `t_user`
--

INSERT INTO `t_user` (`id_user`, `username`, `password`, `hak_akses`) VALUES
(1, 'admin', 'admin', 'Administrator'),
(3, 'ulil', 'ulil2317', 'Petugas'),
(4, 'petugas', 'petugas', 'Petugas'),
(5, 'maimunah', 'maimunah', 'Petugas'),
(6, 'syarif', '12345', 'Petugas');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `t_ambilobat`
--
ALTER TABLE `t_ambilobat`
  ADD PRIMARY KEY (`kode_ambilobat`),
  ADD KEY `obat` (`obat`,`obat1`,`obat2`) USING BTREE;

--
-- Indeks untuk tabel `t_inventaris`
--
ALTER TABLE `t_inventaris`
  ADD PRIMARY KEY (`kode_inventaris`);

--
-- Indeks untuk tabel `t_keluhan`
--
ALTER TABLE `t_keluhan`
  ADD PRIMARY KEY (`kode_keluhan`),
  ADD KEY `kode_list` (`kode_list`,`kode_list_1`,`kode_list_2`) USING BTREE;

--
-- Indeks untuk tabel `t_listkeluhan`
--
ALTER TABLE `t_listkeluhan`
  ADD PRIMARY KEY (`kode_list`);

--
-- Indeks untuk tabel `t_pasien`
--
ALTER TABLE `t_pasien`
  ADD PRIMARY KEY (`kode_pasien`);

--
-- Indeks untuk tabel `t_pemeriksaan`
--
ALTER TABLE `t_pemeriksaan`
  ADD PRIMARY KEY (`kode_periksa`),
  ADD KEY `kode_pasien` (`kode_pasien`),
  ADD KEY `kode_petugas_2` (`kode_petugas`),
  ADD KEY `kode_keluhan` (`kode_keluhan`),
  ADD KEY `kode_obat` (`kode_ambilobat`);

--
-- Indeks untuk tabel `t_petugas`
--
ALTER TABLE `t_petugas`
  ADD PRIMARY KEY (`kode_petugas`);

--
-- Indeks untuk tabel `t_stokobat`
--
ALTER TABLE `t_stokobat`
  ADD PRIMARY KEY (`kode_obat`);

--
-- Indeks untuk tabel `t_user`
--
ALTER TABLE `t_user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `t_ambilobat`
--
ALTER TABLE `t_ambilobat`
  MODIFY `kode_ambilobat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT untuk tabel `t_keluhan`
--
ALTER TABLE `t_keluhan`
  MODIFY `kode_keluhan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT untuk tabel `t_user`
--
ALTER TABLE `t_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `t_ambilobat`
--
ALTER TABLE `t_ambilobat`
  ADD CONSTRAINT `t_ambilobat_ibfk_1` FOREIGN KEY (`obat`) REFERENCES `t_stokobat` (`kode_obat`);

--
-- Ketidakleluasaan untuk tabel `t_keluhan`
--
ALTER TABLE `t_keluhan`
  ADD CONSTRAINT `t_keluhan_ibfk_1` FOREIGN KEY (`kode_list`) REFERENCES `t_listkeluhan` (`kode_list`);

--
-- Ketidakleluasaan untuk tabel `t_pemeriksaan`
--
ALTER TABLE `t_pemeriksaan`
  ADD CONSTRAINT `t_pemeriksaan_ibfk_1` FOREIGN KEY (`kode_pasien`) REFERENCES `t_pasien` (`kode_pasien`),
  ADD CONSTRAINT `t_pemeriksaan_ibfk_2` FOREIGN KEY (`kode_petugas`) REFERENCES `t_petugas` (`kode_petugas`),
  ADD CONSTRAINT `t_pemeriksaan_ibfk_3` FOREIGN KEY (`kode_keluhan`) REFERENCES `t_keluhan` (`kode_keluhan`),
  ADD CONSTRAINT `t_pemeriksaan_ibfk_4` FOREIGN KEY (`kode_ambilobat`) REFERENCES `t_ambilobat` (`kode_ambilobat`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
