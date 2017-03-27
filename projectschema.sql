DROP TABLE IF EXISTS exercises;
DROP TABLE IF EXISTS hasWorkout;
DROP TABLE IF EXISTS workout;
DROP TABLE IF EXISTS tier1;
DROP TABLE IF EXISTS tier2;
DROP TABLE IF EXISTS tier3;
DROP TABLE IF EXISTS Users;

CREATE TABLE Users(
	id INT PRIMARY KEY auto_increment not null,
    firstname varchar(255) not null,
    lastname varchar(255) not null,
    username varchar(255) not null unique,
    password  varchar(255) not null,
    email varchar(255) not null,
    expertise INT,
    daysToWorkOut INT, 
    isAdmin boolean 

);

CREATE TABLE tier1(
	id INT PRIMARY KEY auto_increment not null,
    exercise1 varchar(255),
    exercise2 varchar(255)

);

CREATE TABLE tier2(
	id INT PRIMARY KEY auto_increment not null,
    exercise1 varchar(255),
    exercise2 varchar(255),
    exercise3 varchar(255)

);

CREATE TABLE tier3(
	id INT PRIMARY KEY auto_increment not null,
    exercise1 varchar(255),
    exercise2 varchar(255),
    exercise3 varchar(255)

);


CREATE TABLE workout(
	id INT PRIMARY KEY auto_increment not null,
    tier1Id INT,
    tier2Id INT,
    tier3Id INT,
    
    foreign key (tier1Id) references tier1(id),
    foreign key (tier2Id) references tier2(id),
    foreign key (tier3Id) references tier3(id)

);


CREATE TABLE hasWorkout(
	id INT PRIMARY KEY auto_increment not null,
	userId INT,
    workoutId INT,
    
    
    foreign key (userId) references Users(id),
    foreign key (workoutId) references workout(id)
);

CREATE TABLE exercises(
	id INT PRIMARY KEY auto_increment not null,
	exerciseName varchar(255) not null,
    video varchar(255) not null,
    tier INT not null
    
);