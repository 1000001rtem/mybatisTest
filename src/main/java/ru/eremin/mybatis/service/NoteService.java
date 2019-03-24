package ru.eremin.mybatis.service;


import ru.eremin.mybatis.dto.NoteDTO;
import ru.eremin.mybatis.repository.NoteRepository;

import java.util.List;

/**
 * @autor Artem Eremin on 24.03.2019.
 */


public final class NoteService extends AbstractService {

    private final NoteRepository noteRepository;

    public NoteService() {
        noteRepository = sqlSession.getMapper(NoteRepository.class);
    }

    public List<NoteDTO> findAll() {
        return noteRepository.findAll();
    }

    public NoteDTO findById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return noteRepository.findById(id);
    }

    public void insert(final NoteDTO note) {
        if (note == null) return;
        noteRepository.insert(note);
    }

    public void update(final NoteDTO note) {
        if (note == null) return;
        noteRepository.update(note);
    }

    public void delete(final NoteDTO note) {
        if (note == null) return;
        noteRepository.delete(note);
    }

    public int count() {
        return noteRepository.count();
    }
}
