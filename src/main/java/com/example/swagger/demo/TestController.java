package com.example.swagger.demo;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * The Class RestController
 * 
 * @ApiOperation 요청 URL 에 매핑된 API 에 대한 설명
 * @ApiParam 요청 Parameter에 대한 설명 및 필수여부, 예제값 설정
 * @ApiResponse 응답에 대한 설명
 */

/*
 * @RestController MVC 패턴 방식이 아닌 Rest API 구현을 위한 컨트롤러 선언
 * (Controller + ResponseBody)
 * @Controller MVC 패턴 방식을 위해 제공하는 어노테이션(일반적인 형태)
 */

@RestController
public class TestController {
	
	@Autowired
	TestService service;

	@GetMapping(value = "/helloworld")
	@ApiOperation(value = "Get 테스트용 helloworld", notes = "Get 테스트용 기본형 api 입니다.(설명)")
	public String hellowWorld() {
		return "hello, world";
	}

	@GetMapping(value = "/calculsquare/{data}")
	@ApiOperation(value = "Get PathVariable Test", notes = "제곱근을 리턴하는 API")
	public Object calculSquare(@PathVariable(value = "data", required = true) int data) {
		return data * data;
	}
	

	@PostMapping(value = "/players", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "선수 정보 조회", notes = "UserId를 이용하여 선수 정보를 조회하는 API")
	public Object findUser(
			@ApiParam(value = "User Agent Type ", required = true, example = "Mozila")
			@RequestHeader(value = "User-Agent") String userAgent,
			@ApiParam(value = "선수 고유 ID ", required = true) 
			@RequestParam(value = "playerId") String userId) {
		
		PlayerVo tmpPlayer = new PlayerVo();
		tmpPlayer = service.getPlayerInfo(userId);
		if(!"".equals(tmpPlayer.getBackNumber())){
			return tmpPlayer;
		}else {
			
			return "해당 ID 에 해당하는 선수 데이터가 없습니다.";
			
		}
	}
	
	@PostMapping(value = "/getPlayerInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "선수 정보 조회", notes = "UserId를 이용하여 선수 정보를 조회하는 API")
	public Object findUserResponseEntity(
			@ApiParam(value = "User Agent Type ", required = true, example = "Mozila")
			@RequestHeader(value = "User-Agent") String userAgent,
			@ApiParam(value = "선수 고유 ID ", required = true) 
			@RequestParam(value = "playerId") String userId) {
		
		PlayerVo tmpPlayer = new PlayerVo();
		tmpPlayer = service.getPlayerInfo(userId);
		if(!"".equals(tmpPlayer.getBackNumber())){
			return ResponseEntity.ok().body(tmpPlayer);
		}else {
			
			HashMap<String, String> msg = new HashMap<>();
			msg.put("failCode", "P086161");
			msg.put("msg", "해당 ID 에 해당하는 선수 데이터가 없습니다.");
			return ResponseEntity.ok().body(msg);

		}
	}
	
	
	@PostMapping(value = "/createPlayer", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "선수 정보 생성", notes = "request body를 활용한 선수 정보 생성")
	public Object createPlayer(@RequestBody @ApiParam(value = "선수 정보를 가진 객체 (JSON)", required = true) PlayerVo player)
			{
		
		//실제 구현시에 서비스를 호출해서 player정보를 던지고, DB저장한 후에 정상 리턴하는 형태로 구현

		return player;
	}

}
