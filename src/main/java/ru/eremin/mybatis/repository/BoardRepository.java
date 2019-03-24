package ru.eremin.mybatis.repository;

import org.apache.ibatis.annotations.*;
import ru.eremin.mybatis.dto.BoardDTO;
import ru.eremin.mybatis.dto.NoteDTO;

import java.util.List;

/**
 * @autor Artem Eremin on 24.03.2019.
 */

public interface BoardRepository {

    @Select("SELECT * FROM `board_table`")
    List<BoardDTO> findAll();

    @Select("SELECT * FROM `board_table` WHERE `id`= #{id}")
    @Results({@Result(property = "name", column = "board_name")})
    BoardDTO findById(String id);

    @Insert("INSERT INTO `board_table`(`id`, `board_name`, `date`)" +
            "VALUES (#{id}, #{name}, #{date})")
    void insert(BoardDTO board);

    @Update("UPDATE `board_table`" +
            "SET `board_name` = #{name}, `date` = #{date}" +
            "WHERE `id` = #{id}")
    void update(BoardDTO board);

    @Delete("DELETE FROM `board_table` WHERE `id` = #{id}")
    void delete(BoardDTO board);

    @Select("SELECT count(*) FROM `board_table`")
    int count();
}
