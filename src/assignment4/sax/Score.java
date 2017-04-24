package assignment4.sax;

public class Score implements Comparable {
	private String studentNo;
	private int realScore;

	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Score(String studentNo, int realScore) {
		super();
		this.studentNo = studentNo;
		this.realScore = realScore;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public int getRealScore() {
		return realScore;
	}

	public void setRealScore(int realScore) {
		this.realScore = realScore;
	}

	@Override
	public String toString() {
		return "Score [studentNo=" + studentNo + ", realScore=" + realScore + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.realScore - ((Score) o).getRealScore();
	}

}
