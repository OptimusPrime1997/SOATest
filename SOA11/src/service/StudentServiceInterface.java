package service;

import java.util.List;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import entity.Score;
import entity.ScoreList;

public interface StudentServiceInterface {
	public ScoreList findScoreListById(String studentId);
	public void addScore(Score score);
//	public void deleteScore(String );
//	public void updateScore(ScoreList list)
}
