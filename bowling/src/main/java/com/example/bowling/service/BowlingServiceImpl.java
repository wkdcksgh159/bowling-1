package com.example.bowling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bowling.mapper.BowlingMapper;
import com.example.bowling.vo.Game;
import com.example.bowling.vo.GamePlayer;
import com.example.bowling.vo.GameResult;
import com.example.bowling.vo.Referee;
import com.example.bowling.vo.Team;
import com.example.bowling.vo.TeamPlayerName;

@Service
@Transactional
public class BowlingServiceImpl implements BowlingService {
	@Autowired
	private BowlingMapper bowlingMapper;
	
	@Override
	public int addGameResult(GamePlayer gamePlayer) {
		System.out.println("bowilng serviceImpl addGameResult -----------------------------");
		GameResult gameResult = bowlingMapper.selectGameResult(gamePlayer);
		return bowlingMapper.insertGameResult(gameResult);
	}
	
	@Override
	public int addReferee(Referee referee) {
		System.out.println("bowilng serviceImpl addReferee -----------------------------");
		return bowlingMapper.insertReferee(referee);
	}
	
	// addReport 심판의 목록을 불러오기위한 serviceImpl
	@Override
	public List<Referee> getReferee() {
		System.out.println("bowilng serviceImpl getReferee -----------------------------");
		return bowlingMapper.selectReferee();
	}
	
	//addReport 선수의 회차마다의 기록을 저장하기 위한 serviceImpl
	@Override
	public int addGamePlayer(GamePlayer gamePlayer) {
		System.out.println("bowilng serviceImpl addGamePlayer -----------------------------");
		return bowlingMapper.insertGamePlayer(gamePlayer);
	}
	
	//addReport 홈팀의 구장을 가져오기위한 serviceImpl
	@Override
	public Team getStadium(Team team) {
		System.out.println("bowilng serviceImpl getStadium -----------------------------");
		return bowlingMapper.selectStadium(team);
	}
	
	//addReport 게임테이블에 경기를 기록하는 serviceImpl
	@Override
	public Game addGame(Game game) {
		System.out.println("bowilng serviceImpl addGame -----------------------------");
		int row = bowlingMapper.insertGame(game);
		Game maxGameNo = bowlingMapper.maxGameNo(game);
		System.out.println("row : "+row);
		System.out.println("maxGameNo : "+maxGameNo);
		return maxGameNo;
	}
	
	
	//addReport 홈팀을 제외한 팀 목록을 셀렉트박스에 불러오는 serviceImpl
	@Override
	public List<Team> getAwayTeam(Team team) {
		System.out.println("bowilng serviceImpl getAwayTeam -----------------------------");
		return bowlingMapper.selectAwayTeam(team);
	}
	
	
	//addReport 선택한 팀의 속한 선수 목록을 불러오는 serviceImpl
	@Override
	public List<TeamPlayerName> getTeamPlayer(Team team){
		System.out.println("bowilng serviceImpl getTeamPlayer -----------------------------");
		System.out.println("Team: "+team);
		return bowlingMapper.selectTeamPlayer(team);
	}
	
	//addReport 팀 목록을 셀렉트박스에 불러오는 serviceImpl
	@Override
	public List<Team> getHomeTeam() {
		System.out.println("bowilng serviceImpl getTeam -----------------------------");
		return bowlingMapper.selectTeam();
	}
}
