package com.example.swagger.demo;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	//일반적으로 Service에서는 DAO를 통해 DB에서 데이터를 읽어온다.
	//여기서는 하드코딩으로 대체
	
	public PlayerVo getPlayerInfo(String userId) {
		
		PlayerVo tmpPlayer = new PlayerVo();
		if(userId.equals("1")) {
			tmpPlayer.setBackNumber("6");
			tmpPlayer.setName("Koke");
			tmpPlayer.setNationality("Spain");
			tmpPlayer.setPosition("MF");
		}else if(userId.equals("2")) {
			tmpPlayer.setBackNumber("7");
			tmpPlayer.setName("Joao Felix");
			tmpPlayer.setNationality("Portugal");
			tmpPlayer.setPosition("MF");
		}else if(userId.equals("3")) {
			tmpPlayer.setBackNumber("13");
			tmpPlayer.setName("Jan Oblak");
			tmpPlayer.setNationality("Slovenia");
			tmpPlayer.setPosition("GK");
		}else if(userId.equals("4")) {
			tmpPlayer.setBackNumber("23");
			tmpPlayer.setName("Kieran Trippier");
			tmpPlayer.setNationality("England");
			tmpPlayer.setPosition("DF");
		}else {
			tmpPlayer.setBackNumber("");
		}
		
		
		return tmpPlayer;
		
		
	}

}
