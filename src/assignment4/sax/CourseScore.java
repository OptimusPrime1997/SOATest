package assignment4.sax;

public class CourseScore {
	private String courseNo;
	private String scoreAttr;

	public CourseScore(String courseNo, String scoreAttr) {
		super();
		this.courseNo = courseNo;
		this.scoreAttr = scoreAttr;
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getScoreAttr() {
		return scoreAttr;
	}

	public void setScoreAttr(String scoreAttr) {
		this.scoreAttr = scoreAttr;
	}

	@Override
	public String toString() {
		return "CourseScore [courseNo=" + courseNo + ", scoreAttr=" + scoreAttr + "]";
	}

}
