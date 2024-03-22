package noticeboard.Board;

public class Board {
	private int Board_Id;
	private int User_Id;
	private String Title;
	private String Board_content;
	private String Time;

	public Board(int board_Id, int user_Id, String title, String board_content, String time) {
		super();
		Board_Id = board_Id;
		User_Id = user_Id;
		Title = title;
		Board_content = board_content;
		Time = time;
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

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getBoard_content() {
		return Board_content;
	}

	public void setBoard_content(String board_content) {
		Board_content = board_content;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	@Override
	public String toString() {
		return "Board [Board_Id=" + Board_Id + ", User_Id=" + User_Id + ", Title=" + Title + ", Board_content="
				+ Board_content + ", Time=" + Time + "]";
	}

}