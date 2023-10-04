package com.ashokit.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post_dtls")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    private User user;



}
