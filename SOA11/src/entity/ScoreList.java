package entity;

import java.util.ArrayList;
import java.util.List;

public class ScoreList {

	List<Score> scoreList;
	
	public ScoreList(){
		scoreList = new ArrayList<>();
	}
	

	public List<Score> getScoreList() {
		return scoreList;
	}

	public void  addScore(Score score) {
		scoreList.add(score);
	}

	public void setScoreList(List<Score> scoreList) {
		this.scoreList = scoreList;
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		for(Score score : scoreList){
			builder.append(score.toString());
		}
		return builder.toString();
	}
	
}

