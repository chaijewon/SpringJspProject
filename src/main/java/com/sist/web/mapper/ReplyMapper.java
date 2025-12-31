package com.sist.web.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;
@Mapper
@Repository
public interface ReplyMapper {
   @Select("SELECT no,cno,type,name,id,msg,"
		  +"TO_CHAR(regdate,'yyyy-mm-dd hh24:mi:ss') as dbday "
		  +"FROM comment_0 "
		  +"WHERE cno=#{cno} AND type=#{type} "
          +"ORDER BY no DESC")
   public List<ReplyVO> replyListData(
		    @Param("cno") Integer cno,
		    @Param("type") Integer type
		  );
   @Insert("INSERT INTO comment_0 VALUES("
		  +"(SELECT NVL(MAX(no)+1,1) FROM comment_0),"
		  +"#{cno},#{type},#{id},#{name},#{msg},SYSDATE)")
   public void replyInsert(ReplyVO vo);
   
   @Delete("DELETE FROM comment_0 WHERE no=#{no}")
   public void replyDelete(int no);
   
   @Update("UPDATE comment_0 SET "
		  +"msg=#{msg} "
		  +"WHERE no=#{no}")
   public void replyUpdate(ReplyVO vo);
}
