
package koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksiPelanggan {
    
    private Connection Koneksi;
 
    public Connection getKoneksi() {
        if (Koneksi == null) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                System.out.println("Class Driver Ditemukan");
                try {
                    String url = "jdbc:jtds:sqlserver://127.0.0.1:1433/Master_Pelanggan"; 
                    Koneksi = DriverManager.getConnection(url, "izzah", "izzah"); 
                    System.out.println("Koneksi Database sukses");
                } catch (SQLException se) {
                    System.out.println("Koneksi Database Gagal error:" + se);
                    System.exit(0);
                }
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Class tidak ditemukan, error: " + cnfe);
                System.exit(0);
            }
        }
        return Koneksi;

    }
}

