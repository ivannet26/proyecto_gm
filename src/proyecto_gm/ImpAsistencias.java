package proyecto_gm;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import proyecto_gm.Empleado.DatosEmpleados;
import proyecto_gm.Asistencias.DatosAsistencia;

public class ImpAsistencias {

    private static final Connection conn = ConexionBD.getConnection();

    public static void importData(String fileName) throws ParseException {
        List<String[]> noRegistrados = new ArrayList<>();

        try {
            String sql = "INSERT INTO asistencias (Dni, Fecha, Hora) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql); FileInputStream inputStream = new FileInputStream(fileName)) {
                Workbook workbook = new HSSFWorkbook(inputStream);
                Sheet sheet = workbook.getSheetAt(0);

                for (Row row : sheet) {
                    if (row.getRowNum() == 0) {
                        continue;
                    }
                    Cell dniCell = row.getCell(0);
                    Cell fechaCell = row.getCell(1);
                    Cell horaCell = row.getCell(2);

                    double dniDouble = dniCell.getNumericCellValue();
                    String dni = String.format("%.0f", dniDouble);

                    Date fecha = fechaCell.getDateCellValue();
                    SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String fechaBD = outputFormat.format(fecha);

                    Date horaDate = DateUtil.getJavaDate(horaCell.getNumericCellValue());
                    SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");
                    String hora = horaFormat.format(horaDate);

                    pstmt.setString(1, dni);
                    pstmt.setString(2, fechaBD);
                    pstmt.setString(3, hora);
                    pstmt.executeUpdate();

                    if (!DatosEmpleados.existeEmpleado(dni)) {
                        noRegistrados.add(new String[]{dni, fechaBD, hora});
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "Los datos han sido importados correctamente.", "Importación Exitosa", JOptionPane.INFORMATION_MESSAGE);

            try (PreparedStatement pstmt = conn.prepareStatement(" CALL generar_detalle_asistencia() ")) {
                pstmt.execute();
                System.out.println("Detalle de asistencias generado exitosamente");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            for (String[] nr : noRegistrados) {
                DatosAsistencia.ColocarObservacion(nr[0], nr[1], nr[2], "Usuario no registrado en BD");
            }

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}