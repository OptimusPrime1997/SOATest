package util;

public enum LoginResponse {
	LOGIN_WRONG("wrong email or password!", 0), UNDERGRADUATE_LOGIN("undergraduate students login",
			1), GRADUATE_LOGIN("graduate students login", 2), TEACHER_LOGIN("teacher login", 3);
	private String value;
	private int level;

	private LoginResponse(String value, int level) {
		this.value = value;
		this.level = level;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public static LoginResponse getLoginResponse(String value) {
		LoginResponse result = UNDERGRADUATE_LOGIN;
		switch (value) {
		case "wrong email or password!":
			result = LOGIN_WRONG;
			break;
		case "undergraduate students login":
			result = UNDERGRADUATE_LOGIN;
			break;
		case "graduate students login":
			result = GRADUATE_LOGIN;
			break;
		case "teacher login":
			result = TEACHER_LOGIN;
			break;
		default:
			System.out.println("Login Email failed!");
			break;
		}
		return result;
	}

}
