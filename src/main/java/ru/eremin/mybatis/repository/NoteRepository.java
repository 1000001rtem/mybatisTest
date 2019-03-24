package ru.eremin.mybatis.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ru.eremin.mybatis.dto.NoteDTO;

import java.util.List;

/**
 * @autor Artem Eremin on 24.03.2019.
 */

public interface NoteRepository {

    @Select("SELECT * FROM `note_table`")
    List<NoteDTO> findAll();

    @Select("SELECT * FROM `note_table` WHERE `id`= #{id}")
    NoteDTO findById(String id);

    @Insert("INSERT INTO `note_table`(`id`, `description`, `text`, `board_id`)" +
            "VALUES (#{id}, #{description}, #{text}, #{boardId})")
    void insert(NoteDTO note);

    @Update("UPDATE `note_table`" +
            "SET `description` = #{description}, `text` = #{text}, `board_id` = #{boardId} " +
            "WHERE `id` = #{id}")
    void update(NoteDTO note);

    @Delete("DELETE FROM `note_table` WHERE `id` = #{id}")
    void delete(NoteDTO note);

    @Select("SELECT count(*) FROM `note_table`")
    int count();
}
