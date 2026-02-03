import java.sql.*;
import java.util.Scanner;

public class H2Delete {

    public static void deleteById(Connection conn, Scanner sc) {

        String selectSql = "SELECT id, indate, category, amount FROM AccountBook WHERE id = ?";
        String deleteSql = "DELETE FROM AccountBook WHERE id = ?";

        try {
            System.out.print("삭제할 목록의 번호를 입력해주세요 : ");
            int id = sc.nextInt();

            PreparedStatement ps = conn.prepareStatement(selectSql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("해당 번호의 내역이 존재하지 않습니다.");
                return;
            }

            System.out.println(
                    rs.getInt("id") + " / " +
                    rs.getString("indate") + " / " +
                    rs.getString("category") + " / " +
                    rs.getInt("amount")
            );

            System.out.print("삭제할 목록이 맞습니까? (Y/N) : ");
            if (!sc.next().equalsIgnoreCase("Y")) {
                System.out.println("삭제가 취소되었습니다.");
                return;
            }

            ps = conn.prepareStatement(deleteSql);
            ps.setInt(1, id);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("삭제가 완료되었습니다.");
            } else {
                System.out.println("삭제 실패");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}