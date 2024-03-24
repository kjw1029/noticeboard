package comment;

public class Comment {
	private int Comment_Id;
	private int Board_Id;
	private int User_Id;
	private String Time;
	private String Board_Commnet;

	public Comment(int comment_Id, int board_Id, int user_Id, String time, String board_Commnet) {
		super();
		Comment_Id = comment_Id;
		Board_Id = board_Id;
		User_Id = user_Id;
		Time = time;
		Board_Commnet = board_Commnet;
	}

	public int getComment_Id() {
		return Comment_Id;
	}

	public void setComment_Id(int comment_Id) {
		Comment_Id = comment_Id;
	}

	public int getBoard_Id() {
		return Board_Id;
	}

	public void setBoard_Id(int board_Id) {
		Board_Id = board_Id;
	}

	public int getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getBoard_Commnet() {
		return Board_Commnet;
	}

	public void setBoard_Commnet(String board_Commnet) {
		Board_Commnet = board_Commnet;
	}

	@Override
	public String toString() {
		return "Comment [Comment_Id=" + Comment_Id + ", Board_Id=" + Board_Id + ", User_Id=" + User_Id + ", Time="
				+ Time + ", Board_Commnet=" + Board_Commnet + "]";
	}

}
