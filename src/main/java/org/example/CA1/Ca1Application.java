package org.example.CA1;

import org.example.CA1.Model.GetData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Ca1Application {

	public static void main(String[] args) throws IOException {
		GetData.setActorsListData();
		GetData.setCommentsListData();
		GetData.setMovieList();
		GetData.setUsersListData();
		SpringApplication.run(Ca1Application.class, args);
	}

}
