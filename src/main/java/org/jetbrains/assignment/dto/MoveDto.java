package org.jetbrains.assignment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@ApiModel(description = "Details about the Moves")
public class MoveDto {
    @ApiModelProperty(notes = "The direction where the robot will move")
    private String direction;

    @ApiModelProperty(notes = "The amount of steps the robot will take")
    private int steps;
}

