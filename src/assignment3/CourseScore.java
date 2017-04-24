package assignment3;

public class CourseScore {
	private String courseNo;
	private String courseAttr;
	private int realScore;

	public CourseScore(String courseNo, String courseAttr, int realScore) {
		super();
		this.courseNo = courseNo;
		this.courseAttr = courseAttr;
		this.realScore = realScore;
	}

	public CourseScore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getCourseAttr() {
		return courseAttr;
	}

	public void setCourseAttr(String courseAttr) {
		this.courseAttr = courseAttr;
	}

	public int getRealScore() {
		return realScore;
	}

	public void setRealScore(int realScore) {
		this.realScore = realScore;
	}

	@Override
	public String toString() {
		return "CourseScore [courseNo=" + courseNo + ", courseAttr=" + courseAttr + ", realScore=" + realScore + "]";
	}

}
