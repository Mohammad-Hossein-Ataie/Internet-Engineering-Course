create database if not exists IEMDB;
use IEMDB;
ALTER database IEMDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci; 

create table if not exists Movie(
	id			integer,
	movie_name		varchar(100),
	summary		LONGTEXT,
	releaseDate	varchar(100),
	director	varchar(100),
	imdbRate	varchar(10),
	duration	varchar(10),
	ageLimit	integer,
	image		varchar(200),
	coverImage	varchar(200),
	rating		float,
	primary key(id)
);

create table if not exists Writer(
	movieId		integer,
	writer		varchar(100),
	primary key(movieId, writer),
	foreign key(movieId) references Movie(id) on delete cascade
);

create table if not exists Genres(
	movieId		integer,
	genres		varchar(100),
	primary key(movieId, genres),
	foreign key(movieId) references Movie(id) on delete cascade
);

create table if not exists Actor(
	id				integer,
	name			varchar(100),
	birthDate		varchar(100),
	nationality		varchar(100),
	image			varchar(200),
	primary key(id)
);

create table if not exists Casts(
	movieId		integer,
	actorId		integer,
	primary key(movieId, actorId),
	foreign key(movieId) references Movie(id) on delete cascade,
	foreign key(actorId) references Actor(id) on delete cascade
);

create table if not exists User(
	email			varchar(100),
	password		varchar(100),
	nickname		varchar(100),
	name			varchar(100),
	birthDate		varchar(100),
	primary key(email)
);

create table if not exists Rate(
	userEmail	varchar(100),
	movieId		integer,
	score		integer,
	primary key(userEmail, movieId),
	foreign key(userEmail) references User(email) on delete cascade,
	foreign key(movieId) references Movie(id) on delete cascade
);

create table if not exists Comment(
	userEmail		varchar(100),
	movieId			integer,
	text			TEXT,
    id		integer,
	primary key(id),
	foreign key(movieId) references Movie(id) on delete cascade,
	foreign key(userEmail) references User(email) on delete cascade
);

create table if not exists Vote(
	userEmail	varchar(100),
	commentId	integer,
	vote		integer,
	primary key(userEmail, commentId),
	foreign key(userEmail) references User(email) on delete cascade,
	foreign key(commentId) references Comment(id) on delete cascade
);

create table if not exists watchList(
	userEmail	varchar(100),
	movieId		integer,
	primary key(userEmail, movieId),
	foreign key(movieId) references Movie(id) on delete cascade,
	foreign key(userEmail) references User(email) on delete cascade
);
