package service;

import entity.Score;
import entity.ScoreList;
import jaxb.EmailLoginType;
import util.LoginResponse;

public interface StudentServiceInterface {
	public LoginResponse login(EmailLoginType emailLoginType);

	public ScoreList findScoreListById(String studentId);

	public void addScore(Score score);
	// public void deleteScore(String );
	// public void updateScore(ScoreList list)
}
