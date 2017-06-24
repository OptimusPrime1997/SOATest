package assignment3;

import java.util.List;

public class Stu {
	private String studentNo;
	private String name;
	private String sex;
	private String birthDate;
	private String id;
	private String phoneNum;
	private List<CourseScore> scoreList;

	public Stu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stu(String studentNo, String name, String sex, String birthDate, String id, String phoneNum) {
		super();
		this.studentNo = studentNo;
		this.name = name;
		this.sex = sex;
		this.birthDate = birthDate;
		this.id = id;
		this.phoneNum = phoneNum;
	}

	public List<CourseScore> getScoreList() {
		return scoreList;
	}

	public void setScoreList(List<CourseScore> scoreList) {
		this.scoreList = scoreList;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "Stu [studentNo=" + studentNo + ", name=" + name + ", sex=" + sex + ", birthDate=" + birthDate + ", id="
				+ id + ", phoneNum=" + phoneNum + "]";
	}

	

}
