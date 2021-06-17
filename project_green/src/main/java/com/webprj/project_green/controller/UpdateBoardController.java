package com.webprj.project_green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webprj.project_green.dto.BoardDto;
import com.webprj.project_green.service.BoardService;

@Controller
public class UpdateBoardController {
	@Autowired
	private BoardService boardService;
	// �Խ��� ������
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public String updateView(BoardDto boardDto, Model model) {
		System.out.println(boardDto);

		model.addAttribute("update", boardService.getBoardData(boardDto.getPostNum()));

		return "board/updateView";
	}

	// �Խ��� ����
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String update(@ModelAttribute BoardDto boardDto) {
		System.out.println(boardDto);
		boardService.updateBoard(boardDto);

		return "redirect:/board/detail/" + boardDto.getPostNum();
	}

	// �Խ��� ����
	@GetMapping("board/delete/{postNum}")
	public String delete(@PathVariable int postNum) {
		//��û�� no�� data�� �����ϼ���
		boardService.delete(postNum);
		return "redirect:/b_freetalk";
		
	}


}
