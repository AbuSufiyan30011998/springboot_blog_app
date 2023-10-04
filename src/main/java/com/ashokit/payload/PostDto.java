package com.ashokit.payload;

import lombok.*;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private Long id;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;

}
