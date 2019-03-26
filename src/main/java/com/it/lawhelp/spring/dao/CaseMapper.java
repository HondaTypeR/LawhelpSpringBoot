package com.it.lawhelp.spring.dao;

import com.it.lawhelp.spring.vo.Case;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CaseMapper {
    List<Case> selectCase(int ID);
    List<Case> selectAllCase(@Param("parentId") int parentId ,@Param("currPage") int currPage,@Param("pageSize") int pageSize);
}
