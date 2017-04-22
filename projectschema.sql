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
VALUES (3000,'Deadlift','d5eGGZXb0Is',1);

INSERT INTO exercises 
VALUES (3008,'Incline Bench Press','jX_au65F3LE',1);

INSERT INTO exercises 
VALUES (3001,'Hinge & Reach','cZIqOYMQty4',1);

INSERT INTO exercises 
VALUES (3011,'Banded Barbell Squat','JhF6uteg7Cc',1);

INSERT INTO exercises 
VALUES (3014,'Front Squat','u9ziflQn3pE',1);

INSERT INTO exercises 
VALUES (3022,'Sumo Deadlift','9WDG_3avBtY',1);

INSERT INTO exercises 
VALUES (3025,'Sled Drag','jyWl4K8mH4A',1);

INSERT INTO exercises 
VALUES (3026,'Heavy Bag Clean and Press','dUhgun2-8gg',1);

INSERT INTO exercises 
VALUES (3027,'Dumbbell Hang Clean','-7S2gDvhwxo',1);

INSERT INTO exercises 
VALUES (3033,'Dumbbell Reverse Lunge','phdW-E_NBl4',1);

INSERT INTO exercises 
VALUES (3043,'Prisoner Squat','O9Lr-Miaj_4',1);

INSERT INTO exercises 
VALUES (3044,'Chin Up','KQycbk0-w7M',1);

INSERT INTO exercises 
VALUES (3045,'Explosive Hands Up Push Up','pQotmzim2WM',1);

INSERT INTO exercises 
VALUES (3009,'TRX Push Up','G-JAUjVdm9k',1);

INSERT INTO exercises 
VALUES (3012,'Med Ball Overhead Lunge','7qT64uOeFFw',1);

INSERT INTO exercises 
VALUES (3013,'Power Step Up','yKh3k1EFd7g',1);




INSERT INTO exercises 
VALUES (3002,'DB Standing Press','u9ziflQn3pE',2);

INSERT INTO exercises 
VALUES (3003,'Rotational Med Ball Throw','dWm_IdmpTLw',2);

INSERT INTO exercises 
VALUES (3004,'TRX Row','x0L6iuTkaRI',2);

INSERT INTO exercises 
VALUES (3015,'RFE Squat','4NVyqqCjqjU',2);

INSERT INTO exercises 
VALUES (3016,'Dumbbell Walking Lunges','ZG0QRvjBvqE',2);

INSERT INTO exercises 
VALUES (3017,'Med Balll Clean','QNmF1aGAkaI',2);

INSERT INTO exercises 
VALUES (3020,'DB Lawnmower Row','seo_pLdGkbY',2);

INSERT INTO exercises 
VALUES (3021,'Split Stance DB Push Jerk','UtABW9pBVLk',2);

INSERT INTO exercises 
VALUES (3024,'Med Ball Half Kneeling Chop','MmeHlgyciqI',2);

INSERT INTO exercises 
VALUES (3034,'Dumbbell Pullover','p4XPDQemYq8',2);

INSERT INTO exercises 
VALUES (3035,'Incline Bench YTL','sIy8pemduXs',2);

INSERT INTO exercises 
VALUES (3036,'Med Ball Slam','MCe3Tm7zv_o',2);

INSERT INTO exercises 
VALUES (3037,'Face Pull','ftRuEDihKz8',2);

INSERT INTO exercises 
VALUES (3038,'Seated Pivot Rope Climb','jqKUjDXf0rM',2);

INSERT INTO exercises 
VALUES (3048,'One Arm Kettle Bell Chest Press','dw1fTlZDfFE',2);

INSERT INTO exercises 
VALUES (3010,'Kettle Bell False Clean and Press','Gdj6r5bH5f8',2);





INSERT INTO exercises 
VALUES (3005,'Slideboard Crunch','jj5E8eb8xRc',3);

INSERT INTO exercises 
VALUES (3006,'RFE Squat','4NVyqqCjqjU',3);

INSERT INTO exercises 
VALUES (3007,'Reverse Wall Slide','zZs08ZCuKkQ',3);

INSERT INTO exercises 
VALUES (3018,'90/90 T-Spine','1BRpSJZz25c',3);

INSERT INTO exercises 
VALUES (3019,'Foam Roller Thoracic Extension','MND4Kmb0HzE',3);

INSERT INTO exercises 
VALUES (3023,'Bridge and Reach','LvbozIqpJes',3);

INSERT INTO exercises 
VALUES (3028,'Slideboard Mountain Climber','ivHVkhhBEy8',3);

INSERT INTO exercises 
VALUES (3029,'Stir the Pot','Qxup8Qiny3g',3);

INSERT INTO exercises 
VALUES (3030,'TRX Side Plank','sst2e0GrEko',3);

INSERT INTO exercises 
VALUES (3031,'Med Ball Half Moon','fULsZEuoEGI',3);

INSERT INTO exercises 
VALUES (3032,'Plank','-kbsPFxOzeE',3);

INSERT INTO exercises 
VALUES (3039,'Banana Hold','zvvmejpOhoc',3);

INSERT INTO exercises 
VALUES (3040,'Glute Bridge','JOeEgCRz1h8',3);

INSERT INTO exercises 
VALUES (3041,'Landmine Twist','omtJPAOQdFI',3);

INSERT INTO exercises 
VALUES (3042,'TRX Roll Out','mtGQ4qHr8hM',3);

INSERT INTO exercises 
VALUES (3046,'V-Up','X39rYcz8UgU',3);

INSERT INTO exercises 
VALUES (3047,'Plank Walk-Up','sm1qBA08Bxo',3);

INSERT INTO exercises 
VALUES (3049,'Bird Dog','_coKq2zqBiQ',3);








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
