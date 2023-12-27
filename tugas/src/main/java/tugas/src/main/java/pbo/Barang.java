package tugas.src.main.java.pbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Barang {
    private String kodeBarang;
    private String namaBarang;
    private double hargaBarang;

    // Constructor
    public Barang(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }

    public Barang() {
    }

    // Getter methods
    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public double getHargaBarang() {
        return hargaBarang;
    }

    // CRUD Operations

    public void tambahBarang() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String insertQuery = "INSERT INTO barang (kode_barang, nama_barang, harga_barang) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, kodeBarang);
                preparedStatement.setString(2, namaBarang);
                preparedStatement.setDouble(3, hargaBarang);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Barang berhasil ditambahkan ke database.");
                } else {
                    System.out.println("Gagal menambahkan barang ke database.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void bacaBarang() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String selectQuery = "SELECT * FROM barang WHERE kode_barang=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, kodeBarang);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("Kode Barang: " + resultSet.getString("kode_barang"));
                        System.out.println("Nama Barang: " + resultSet.getString("nama_barang"));
                        System.out.println("Harga Barang: " + resultSet.getDouble("harga_barang"));
                    } else {
                        System.out.println("Barang tidak ditemukan.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBarang() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String updateQuery = "UPDATE barang SET nama_barang=?, harga_barang=? WHERE kode_barang=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, namaBarang);
                preparedStatement.setDouble(2, hargaBarang);
                preparedStatement.setString(3, kodeBarang);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Barang berhasil diperbarui.");
                } else {
                    System.out.println("Barang tidak ditemukan.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void hapusBarang() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String deleteQuery = "DELETE FROM barang WHERE kode_barang=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setString(1, kodeBarang);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Barang berhasil dihapus.");
                } else {
                    System.out.println("Barang tidak ditemukan.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setKodeBarang(String kodeBarang2) {
    }

    public void setNamaBarang(String namaBarang2) {
    }

    public void setHargaBarang(double hargaBarang2) {
    }
}