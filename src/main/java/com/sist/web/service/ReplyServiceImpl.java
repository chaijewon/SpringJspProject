package com.sist.web.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import com.sist.web.mapper.*;
@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{
  private final ReplyMapper mapper;

  @Override
  public List<ReplyVO> replyListData(int cno, int type) {
	// TODO Auto-generated method stub
	return mapper.replyListData(cno,type);
  }

  @Override
  public void replyInsert(ReplyVO vo) {
	// TODO Auto-generated method stub
	mapper.replyInsert(vo);
  }
}
