package Command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Pakage.AccountBook;

// extends Search 제거 (필요 없음)
public class Update {

    public int SelectUpdate2(Connection conn, AccountBook ab) {
        // SQL: "category"와 "DATE"가 일치하는 항목을 찾아 -> "amount(금액)"를 수정한다.
        // (Insert.java에 맞춰 컬럼명을 "DATE"로 통일했습니다. indate -> "DATE")
        String sql = "UPDATE accountbook SET amount = ? WHERE category = ? AND \"DATE\" = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            // 매니저에서 받아온 ab 객체 안에 있는 '새로운 금액'과 '조건'을 꺼내서 세팅
            ps.setInt(1, ab.getAmount());      // 바꿀 금액
            ps.setString(2, ab.getCategory()); // 조건: 분류
            ps.setString(3, ab.getDate());     // 조건: 날짜

            return ps.executeUpdate(); // 성공 시 1 반환
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}