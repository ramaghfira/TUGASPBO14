package tugas.src.main.java.pbo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LoginMenu loginMenu = new LoginMenu();

            if (loginMenu.login(scanner)) {
                showMainMenu(scanner);
            } else {
                System.out.println("Login gagal. Program berhenti.");
            }
        }
    }

    private static void showMainMenu(Scanner scanner) {
        Barang barang = new Barang(); // Membuat objek Barang
        int option;

        do {
            System.out.println("\nNIMINOT MARKET");
            System.out.println("Tanggal : " + getCurrentDate());
            System.out.println("Waktu   : " + getCurrentTime());
            System.out.println("========================");
            System.out.println("MENU UTAMA");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Baca Barang");
            System.out.println("3. Update Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            option = scanner.nextInt();
            scanner.nextLine(); // Konsumsi karakter newline

            switch (option) {
                case 1:
                    tambahBarangMenu(scanner, barang);
                    break;
                case 2:
                    bacaBarangMenu(scanner, barang);
                    break;
                case 3:
                    updateBarangMenu(scanner, barang);
                    break;
                case 4:
                    hapusBarangMenu(scanner, barang);
                    break;
                case 0:
                    System.out.println("Program berakhir. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih kembali.");
            }

            // Setelah pengguna menginput jumlah beli barang (hanya untuk opsi tambahBarang)
            if (option == 1) {
                // Mengambil informasi barang dari pengguna
                System.out.print("Kode Barang        : ");
                String kodeBarang = scanner.next();
                System.out.print("Nama Barang        : ");
                String namaBarang = scanner.next();
                System.out.print("Harga Barang       : ");
                double hargaBarang = scanner.nextDouble();
                System.out.print("Jumlah Beli        : ");
                int jumlahBeli = scanner.nextInt();

                // Set nilai atribut pada objek barang
                barang.setKodeBarang(kodeBarang);
                barang.setNamaBarang(namaBarang);
                barang.setHargaBarang(hargaBarang);

                // Memanggil metode tambahBarang pada objek barang
                barang.tambahBarang();

                // Memanggil metode hitungTotalBayar dari kelas HitungTotalBayar
                double totalBayar = HitungTotalBayar.hitungTotalBayar(hargaBarang, jumlahBeli);

                // Menampilkan hasil perhitungan total bayar
                System.out.println("TOTAL BAYAR      : " + totalBayar);

                // Mengambil informasi pelanggan dari pengguna
                System.out.print("Nama Pelanggan     : ");
                String namaPelanggan = scanner.next();
                System.out.print("No. HP Pelanggan   : ");
                String noHpPelanggan = scanner.next();
                System.out.print("Alamat Pelanggan   : ");
                String alamatPelanggan = scanner.next();

                new Pelanggan(namaPelanggan, noHpPelanggan, alamatPelanggan);
            }

            // Mengambil informasi kasir dari pengguna atau sistem autentikasi
            System.out.print("Kasir              : ");
            scanner.next();

        } while (option != 0);
    }

    private static void hapusBarangMenu(Scanner scanner, Barang barang) {
    }

    private static void updateBarangMenu(Scanner scanner, Barang barang) {
    }

    private static void bacaBarangMenu(Scanner scanner, Barang barang) {
    }

    private static void tambahBarangMenu(Scanner scanner, Barang barang) {
    }

    private static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd/MM/yyyy");
        return dateFormat.format(new Date());
    }

    private static String getCurrentTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss z");
        return timeFormat.format(new Date());
    }
}