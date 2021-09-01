package com.example.swagger.demo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "선수 정보(Model)")
public class PlayerVo {
	
	@ApiModelProperty(required = true, value = "id", example = "1", hidden = true)
    private String id;
	
	@ApiModelProperty(required = true, value = "선수이름", example = "Griezmann")
    private String name;
	
	@ApiModelProperty(required = true, value = "백넘버", example = "108")
    private String backNumber;
	
	@ApiModelProperty(required = true, value = "국적", example = "France")
    private String nationality;
	
	@ApiModelProperty(required = true, value = "포지션", example = "FW")
    private String position;
}