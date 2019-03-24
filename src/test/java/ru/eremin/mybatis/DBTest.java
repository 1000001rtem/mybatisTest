package ru.eremin.mybatis;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.eremin.mybatis.dto.BoardDTO;
import ru.eremin.mybatis.dto.NoteDTO;
import ru.eremin.mybatis.service.BoardService;
import ru.eremin.mybatis.service.NoteService;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * @autor Artem Eremin on 24.03.2019.
 */

@RunWith(OrderedRunner.class)
public class DBTest {

    private static BoardService boardService;

    private static NoteService noteService;

    private static NoteDTO note1;
    private static NoteDTO note2;

    private static BoardDTO board1;
    private static BoardDTO board2;

    @BeforeClass
    public static void before() {
        boardService = new BoardService();
        noteService = new NoteService();

        board1 = new BoardDTO("testBoard1", new Date());
        board2 = new BoardDTO("testBoard2", new Date());

        note1 = new NoteDTO("testNote1", "testtest1", board1.getId());
        note2 = new NoteDTO("testNote2", "testtest2", board2.getId());
    }

    @Test
    @Order(order = 1)
    public void countTest() {
        int boardCount = boardService.count();
        int noteCount = noteService.count();

        int boardSize = boardService.findAll().size();
        int noteSize = noteService.findAll().size();

        assertEquals(boardCount, boardSize);
        assertEquals(noteCount, noteSize);
    }

    @Test
    @Order(order = 2)
    public void insertTest() {
        int boardCount = boardService.count();
        int noteCount = noteService.count();

        boardService.insert(board1);
        boardService.insert(board2);

        noteService.insert(note1);
        noteService.insert(note2);

        boardService.commit();
        noteService.commit();

        assertTrue(boardService.count() > boardCount);
        assertTrue(noteService.count() > noteCount);
    }

    @Test
    @Order(order = 3)
    public void updateTest() {
        final NoteDTO noteTMP = noteService.findById(note1.getId());
        final BoardDTO boardTMP = boardService.findById(board1.getId());

        assertNotNull(noteTMP);
        assertNotNull(boardTMP);

        noteTMP.setDescription("updateDescription");
        boardTMP.setName("updateName");

        noteService.update(noteTMP);
        boardService.update(boardTMP);

        boardService.commit();
        noteService.commit();

        assertEquals(noteService.findById(noteTMP.getId()).getDescription(), "updateDescription");
        assertEquals(boardService.findById(boardTMP.getId()).getName(), "updateName");
    }

    @Test
    @Order(order = 4)
    public void deleteTest() {
        int boardCount = boardService.count();
        int noteCount = noteService.count();

        boardService.delete(board1);
        boardService.delete(board2);

        noteService.delete(note1);
        noteService.delete(note2);
        boardService.commit();
        noteService.commit();

        assertEquals(boardService.count()+2, boardCount);
        assertEquals(noteService.count()+2, noteCount);
    }
}
