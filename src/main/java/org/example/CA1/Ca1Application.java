package org.example.CA1;

import org.example.CA1.DAO.CommentDAO;
import org.example.CA1.Entity.Comment;
import org.example.CA1.Entity.User;
import org.example.CA1.Model.GetData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Ca1Application {

	public static void main(String[] args) throws IOException, SQLException {
// 		GetData.setActorsListData();
//		GetData.setCommentsListData();
//		GetData.setMovieList();
//		GetData.setUsersListData();
//		GetData.setCommentIDS();
		SpringApplication.run(Ca1Application.class, args);
	}

}
