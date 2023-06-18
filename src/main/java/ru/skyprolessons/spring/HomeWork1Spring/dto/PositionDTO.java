package ru.skyprolessons.spring.HomeWork1Spring.dto;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.skyprolessons.spring.HomeWork1Spring.pojo.Position;


@NoArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
public class PositionDTO {
    private Integer id;
    private String name;

    public static PositionDTO fromPosition(Position position) {
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setId(position.getIdPosition());
        positionDTO.setName(position.getNamePosition());
        return new PositionDTO();
    }

    public Position toPosition(PositionDTO positionDTO) {
        Position position = new Position();
        position.setIdPosition(positionDTO.getId());
        position.setNamePosition(positionDTO.getName());
        return position;
    }
}
