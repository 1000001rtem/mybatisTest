package ru.eremin.mybatis.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * @autor Artem Eremin on 24.03.2019.
 */

@Getter
@Setter
@NoArgsConstructor
public class BoardDTO {

    private String id = UUID.randomUUID().toString();

    private String name;

    private Date date;

    public BoardDTO(final String name, final Date date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BoardDTO boardDTO = (BoardDTO) o;
        return Objects.equals(id, boardDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
