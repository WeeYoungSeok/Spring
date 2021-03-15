package com.wee.weestagram.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {

	private int board_no;
	private String board_writer;
	private String board_title;
	private String board_content;
	private Date regdate;

	public BoardDto() {
		super();
	}

}
