DROP TABLE IF EXISTS hasProgram;
DROP TABLE IF EXISTS program;
DROP TABLE IF EXISTS workout;
DROP TABLE IF EXISTS tier1;
DROP TABLE IF EXISTS tier2;
DROP TABLE IF EXISTS tier3;
DROP TABLE IF EXISTS exercises;
DROP TABLE IF EXISTS Users;

CREATE TABLE Users(
	id INT PRIMARY KEY auto_increment,
    firstname varchar(255) not null,
    lastname varchar(255) not null,
    username varchar(255) not null unique,
    password  varchar(255) not null,
    email varchar(255) not null unique,
    expertise INT,
    daysToWorkOut INT, 
    isAdmin boolean 

) ENGINE=InnoDB;


CREATE TABLE exercises(
	id INT PRIMARY KEY auto_increment,
	exerciseName varchar(255) not null,
    video varchar(255) not null,
    tier INT not null
    
)ENGINE=InnoDB;

CREATE TABLE tier1(
	id INT PRIMARY KEY auto_increment,
    exercise1 INT,
    exercise2 INT,
    
    foreign key (exercise1) references  exercises(id),
    foreign key (exercise2) references  exercises(id)

) ENGINE=InnoDB;

CREATE TABLE tier2(
	id INT PRIMARY KEY auto_increment,
    exercise1 INT,
    exercise2 INT,
    exercise3 INT,
    
    foreign key (exercise1) references exercises(id),
    foreign key (exercise2) references exercises(id),
    foreign key (exercise3) references exercises(id)

)ENGINE=InnoDB;

CREATE TABLE tier3(
	id INT PRIMARY KEY auto_increment,
    exercise1 INT,
    exercise2 INT,
    exercise3 INT,
    
    foreign key (exercise1) references exercises(id),
    foreign key (exercise2) references exercises(id),
    foreign key (exercise3) references exercises(id)

)ENGINE=InnoDB;


CREATE TABLE workout(
	id INT PRIMARY KEY auto_increment,
    tier1Id INT,
    tier2Id INT,
    tier3Id INT,
    
    foreign key (tier1Id) references tier1(id),
    foreign key (tier2Id) references tier2(id),
    foreign key (tier3Id) references tier3(id)

)ENGINE=InnoDB;

CREATE TABLE program(
	id INT PRIMARY KEY auto_increment,
	day1 INT NOT NULL,
	day2 INT,
	day3 INT,
	
	foreign key (day1) references workout(id),
    foreign key (day2) references workout(id),
    foreign key (day3) references workout(id)
			
)ENGINE=InnoDB;

CREATE TABLE hasProgram(
	id INT PRIMARY KEY auto_increment,
	userId INT,
    programId INT,
    startDate Date NOT NULL,
	endDate Date NOT NULL,
    
    foreign key (userId) references Users(id),
    foreign key (programId) references program(id)
)ENGINE=InnoDB;


INSERT INTO exercises 
VALUES (3000,'Deadlift','https://www.youtube.com/watch?v=d5eGGZXb0Is',1);

INSERT INTO exercises 
VALUES (3008,'Incline Bench Press','https://youtu.be/jX_au65F3LE',1);

INSERT INTO exercises 
VALUES (3001,'Hinge & Reach','https://www.youtube.com/watch?v=cZIqOYMQty4',1);

INSERT INTO exercises 
VALUES (3002,'DB Standing Press','https://www.youtube.com/watch?v=u9ziflQn3pE&index=18&list=PLvbOI6Hd_YM45VXCQ8hx0-AEUiwqIlSZD',2);

INSERT INTO exercises 
VALUES (3003,'Rotational Med Ball Throw','https://youtu.be/dWm_IdmpTLw?list=PLvbOI6Hd_YM76xJgBzQAWx0Rrx2C4nTta',2);

INSERT INTO exercises 
VALUES (3004,'TRX Row','https://youtu.be/x0L6iuTkaRI',2);

INSERT INTO exercises 
VALUES (3005,'Slideboard Crunch','https://youtu.be/jj5E8eb8xRc',3);

INSERT INTO exercises 
VALUES (3006,'RFE Squat','https://youtu.be/4NVyqqCjqjU',3);

INSERT INTO exercises 
VALUES (3007,'Reverse Wall Slide','https://youtu.be/zZs08ZCuKkQ',3);

INSERT INTO exercises 
VALUES (3011,'Banded Barbell Squat','https://youtu.be/JhF6uteg7Cc',1);

INSERT INTO exercises 
VALUES (3014,'Front Squat','https://youtu.be/u9ziflQn3pE',1);

INSERT INTO exercises 
VALUES (3015,'RFE Squat','https://youtu.be/4NVyqqCjqjU',2);

INSERT INTO exercises 
VALUES (3016,'Dumbbell Walking Lunges','https://youtu.be/ZG0QRvjBvqE',2);


INSERT INTO tier1 
VALUES(2000,3000,3001);

INSERT INTO tier2 
VALUES(2001,3002,3003,3004);

INSERT INTO tier3 
VALUES(2002,3005,3006,3007);


INSERT INTO Users 
VALUES (1,'Test','User', 'test','123abc', 'mail@mail.com', '2', '1',0);


INSERT INTO Users 
VALUES (2,'Test','Admin', 'admin','helo', 'admin@mail.com', '0', '0',1);

INSERT INTO workout
VALUES(5001,2000,2001,2002);

INSERT INTO program
VALUES(4001,5001,NULL,NULL);

INSERT INTO hasProgram
VALUES(LAST_INSERT_ID(),1,4001,CURDATE(),DATE_ADD(CURDATE(), INTERVAL 1 WEEK));
