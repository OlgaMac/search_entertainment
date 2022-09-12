package com.aston.search_entertainment.generators;

import com.aston.search_entertainment.domain.dto.request.CommentRequest;
import com.aston.search_entertainment.domain.dto.request.EntertainmentRequest;
import com.aston.search_entertainment.domain.dto.response.CommentResponse;
import com.aston.search_entertainment.domain.dto.response.EntertainmentResponse;
import com.aston.search_entertainment.domain.entity.Comment;
import com.aston.search_entertainment.domain.entity.Company;
import com.aston.search_entertainment.domain.entity.Entertainment;
import com.aston.search_entertainment.domain.entity.Role;
import com.aston.search_entertainment.domain.entity.User;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EntitiesGenerator {

    public static User user = generateUser();

    private static final Long id = 1L;


    public static Comment generateComment() {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setCreated(Timestamp.valueOf(LocalDateTime.now()));
        comment.setUpdated(Timestamp.valueOf(LocalDateTime.now()));
        comment.setText("test-text");
        comment.setUser(user);
        comment.setEntertainment(generateEntertainment());
        comment.setRating(5.0);

        return comment;
    }

    public static CommentRequest generateCommentRequest() {
        CommentRequest commentRequest = CommentRequest.builder()
                .entertainment_id(id)
                .rating(0.5)
                .text("nice")
                .user_id(id)
                .build();
        return commentRequest;
    }

    public static CommentResponse generateCommentResponse() {
        CommentResponse commentResponse = CommentResponse.builder()
                .id(id)
                .entertainment_id(id)
                .rating(0.5)
                .text("nice")
                .user_id(id)
                .build();

        return commentResponse;
    }


    public static Entertainment generateEntertainment() {
        Entertainment entertainment = Entertainment.builder()
                .id(id)
                .active(true)
                .company(generateCompany())
                .date(Timestamp.valueOf(LocalDateTime.now()))
                .name("Aston")
                .rating(5.0)
                .build();

        return entertainment;
    }

    public static Company generateCompany() {
        Company company = Company.builder()
                .id(id)
                .name("Ivan")
                .userId(user)
                .build();

        return company;
    }

    private static User generateUser() {
        User user = User.builder()
                .id(id)
                .email("mail@mail.com")
                .password("qwerty")
                .role(Role.USER)
                .firstName("Ivan")
                .lastName("Ivanov")
                .created(Timestamp.valueOf(LocalDateTime.now()))
                .enable(true)
                .build();

        return user;
    }



    public static EntertainmentResponse generateEntertainmentResponse() {
        EntertainmentResponse entertainmentResponse = EntertainmentResponse.builder()
                .id(id)
                .name("Aston")
                .company_id(1L)
                .location("location")
                .documents("documents")
                .url("url")
                .date(LocalDate.now())
                .rating(5.0)
                .build();

        return entertainmentResponse;
    }

    public static EntertainmentRequest generateEntertainmentRequest() {
        EntertainmentRequest entertainmentRequest = EntertainmentRequest.builder()
                .name("Aston")
                .company_id(1L)
                .location("location")
                .documents("documents")
                .url("url")
                .rating(5.0)
                .build();

        return entertainmentRequest;
    }

}
