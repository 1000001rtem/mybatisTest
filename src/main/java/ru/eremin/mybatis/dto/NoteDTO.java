package ru.eremin.mybatis.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

/**
 * @autor Artem Eremin on 24.03.2019.
 */

@Getter
@Setter
@NoArgsConstructor
public class NoteDTO {

    private String id = UUID.randomUUID().toString();

    private String description;

    private String text;

    private String boardId;

    public NoteDTO(final String description, final String text, final String boardId) {
        this.description = description;
        this.text = text;
        this.boardId = boardId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final NoteDTO noteDTO = (NoteDTO) o;
        return Objects.equals(id, noteDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
