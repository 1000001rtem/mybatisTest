package ru.eremin.mybatis.service;

import ru.eremin.mybatis.dto.BoardDTO;
import ru.eremin.mybatis.repository.BoardRepository;

import java.util.List;

/**
 * @autor Artem Eremin on 24.03.2019.
 */

public class BoardService extends AbstractService {

    private final BoardRepository boardRepository;

    public BoardService() {
        boardRepository = sqlSession.getMapper(BoardRepository.class);
    }

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    public BoardDTO findById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return boardRepository.findById(id);
    }

    public void insert(final BoardDTO board) {
        if (board == null) return;
        boardRepository.insert(board);
    }

    public void update(final BoardDTO board) {
        if (board == null) return;
        boardRepository.update(board);
    }

    public void delete(final BoardDTO board) {
        if (board == null) return;
        boardRepository.delete(board);
    }

    public int count() {
        return boardRepository.count();
    }
}
