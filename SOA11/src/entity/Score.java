package entity;

public class Score{
	private String courseId;
	private String scoreType;
	private String studentId;
	private String score;
	
	public Score(String courseId, String scoreType, String studentId, String score){
		this.courseId = courseId;
		this.scoreType = scoreType;
		this.studentId = studentId;
		this.score = score;
		
	}
	
	public Score(){
		
	}
	
	
	
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getScoreType() {
		return scoreType;
	}

	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}

	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	
	public String toString(){
		return "课程编号： "+ courseId+ " 成绩属性： " + scoreType +" 学号： " + studentId  + " 得分： "  +  score + "\n";
	}
	
	
	
}