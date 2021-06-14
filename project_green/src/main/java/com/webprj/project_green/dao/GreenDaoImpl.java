// fileDAO.java (��õ �� ���ƿ� ���� ���� �ش� ������ �ö󰡴�)

public int like(String userWriteTitle) {

	PreparedStatement pstmt = null;

        try {

		String SQL = "UPDATE userwritetest SET userLikeAmount = userLikeAmount + 1 WHERE userWriteTitle = ?";

		pstmt = conn.prepareStatement(SQL);

		pstmt.setString(1, userWriteTitle);

		return pstmt.executeUpdate();

	} catch (Exception e) {

		e.printStackTrace();

	} finally {

		try {

			if(pstmt != null) pstmt.close();

			if(conn != null) conn.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	return -1;

}