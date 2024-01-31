package org.jetbrains.assignment.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@ApiModel(description = "Details about the Locations")
public class LocationDto {
    @ApiModelProperty(notes = "The x-coordinate")
    private int x;

    @ApiModelProperty(notes = "The y-coordinate")
    private int y;
}
