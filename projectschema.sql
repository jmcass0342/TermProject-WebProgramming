DROP TABLE IF EXISTS hasProgram;
DROP TABLE IF EXISTS program;
DROP TABLE IF EXISTS workout;
DROP TABLE IF EXISTS tier1;
DROP TABLE IF EXISTS tier2;
DROP TABLE IF EXISTS tier3;
DROP TABLE IF EXISTS exercises;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS tips;

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

CREATE TABLE `tips` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tip` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



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

INSERT INTO tier1 
VALUES(2003,3008,3014);

INSERT INTO tier2 
VALUES(2004,3036,3048,3024);

INSERT INTO tier3 
VALUES(2005,3049,3047,3031);

INSERT INTO tier1 
VALUES(2006,3025,3033);

INSERT INTO tier2 
VALUES(2007,3038,3010,3037);

INSERT INTO tier3 
VALUES(2008,3032,3028,3030);

INSERT INTO tier1 
VALUES(2009,3027,3044);

INSERT INTO tier2 
VALUES(2010,3016,3017,3035);

INSERT INTO tier3 
VALUES(2011,3023,3019,3007);

INSERT INTO tier1 
VALUES(2012,3009,3043);

INSERT INTO tier2 
VALUES(2013,3034,3021,3015);

INSERT INTO tier3 
VALUES(2014,3040,3006,3032);




INSERT INTO Users 
VALUES (1,'Test','User', 'test','123abc', 'mail@mail.com', '2', '1',0);


INSERT INTO Users 
VALUES (2,'Test','Admin', 'admin','helo', 'admin@mail.com', '0', '0',1);


INSERT INTO workout
VALUES(5001,2000,2001,2002);

INSERT INTO workout
VALUES(5002,2003,2004,2005);

INSERT INTO workout
VALUES(5003,2006,2007,2008);

INSERT INTO workout
VALUES(5004,2009,2010,2011);

INSERT INTO workout
VALUES(5005,2012,2013,2014);


INSERT INTO program
VALUES(4001,5001,NULL,NULL);

INSERT INTO program
VALUES(4002,5001,5002,NULL);

INSERT INTO program
VALUES(4003,5001,5002,5003);

INSERT INTO program
VALUES(4004,5004,NULL,NULL);

INSERT INTO program
VALUES(4005,5005,5003,NULL);

INSERT INTO program
VALUES(4006,5004,5005,5001);



INSERT INTO hasProgram
VALUES(LAST_INSERT_ID(),1,4001,CURDATE(),DATE_ADD(CURDATE(), INTERVAL 1 WEEK));



INSERT INTO tips (tip)
VALUES ("Ask almost any personal trainer and they’ll tell you that regardless of your training goals, healthy eating is the backbone. Food is what fuels your body to reach your goals and without proper nutrition through quality foods, you’re likely to stall. As a result, if possible, eat organic foods and, above all else, maintain a balanced diet consisting of fruits, vegetables, complex carbohydrates, complete proteins, and fats including such things as fish oils and flaxseeds."); 

INSERT INTO tips (tip)
VALUES ("Regardless of what you’re doing, preparing yourself in advance gives you the best chance to accomplish your goals. Micah LaCerte, a personal trainer and fitness competition world champion, explains that your approach to nutrition should be no different. LaCerte says it’s best to prepare for your 'upcoming day by prepping all your food in advance.' He adds that this will ensure you do 'not eat bad foods or skip meals.'"); 

INSERT INTO tips (tip)
VALUES ("Eating only three daily meals? For over 25 years, personal trainer Mike Duffy has sought to correct this habit explaining that, 'half the people I deal with aren’t losing weight because they don’t eat enough.' Duffy advises them 'to eat five times a day, about every three hours to stimulate their metabolism' including two mini meals between their three basic meals. With activity levels decreasing throughout the day, he advises to 'eat less as the day goes on.'");

INSERT INTO tips (tip)
VALUES ("Everything you consume should have substantial nutritional value. No one knows this better than Dan Trink who possesses 11 training certificates in spite of once being overweight. Today, through the magic of the Internet, Trink helps people around the world get healthy and he stresses that, 'you want the most nutritional bang for your buck.' He adds 'everything you eat should serve some sort of nutritional purpose in your body, fuel your workouts, and (be) geared towards optimizing your body.'");

INSERT INTO tips (tip)
VALUES ("Talk to any personal trainer and they’ll tell you there are certain muscle-building basics. First, increase your caloric and complete protein intake. Then, when you enter the gym, focus on your form. Perform compound movements and train with weights on average around four times a week. Never underestimate the importance of rest. Remember, muscle tissue grows outside of the gym when you’re giving your body time to relax and recover following your workouts.");

INSERT INTO tips (tip)
VALUES ("Don’t take any short cuts. As personal trainer Lee Boyce explains, that means you should 'aim for the largest ROM you can achieve in your exercises.' Why? Simple, according to Boyce, an ex-athlete with a background in Kinesiology and Health Sciences, 'your muscles will do more work per rep, and it will result in your breaking down more tissue by the end of the workout.'");

INSERT INTO tips (tip)
VALUES ("Wondering how to get the most out of lifting weights? Duffy says that he tells his clients to 'use a weight that will have them failing on the set between the 30 and 40 second mark because research has shown that it’s the time under tension that causes muscle to grow if you are trying to build more muscle.' He cautions that if 'you’re failing at 20 seconds, you know that weight was too heavy.'");

INSERT INTO tips (tip)
VALUES ("Do you love your cardio exercises? If so, you’ll be disappointed to know that, as LaCerte states, 'during times of mass building you do not want to do large amounts of cardio.' Why? Chances are you’ll be burning far too many calories. So what should you do if you still want to get in some cardio? LaCerte says 'a light jog a few days per week for 20 minutes is adequate.'");

INSERT INTO tips (tip)
VALUES ("Some feel supplements can play a key role in boosting muscle gains. If you subscribe to that theory chances are you’re already taking protein supplements, but what else? Trink says that creatine 'seems to be about the most effective strength and size-building supplement.' And, to boost your performance, you may also want to try peppermint. Cardiello explains that, the scent 'alters the perception of how hard you’re working out' making it seem 'less strenuous, slower paced, and easier to complete.'");

INSERT INTO tips (tip)
VALUES ("When it comes to training for endurance, you’ll need to be hydrated and be sure you’re eating properly because, by its very nature, this form of training is very demanding on your body. You should be doing a good mix of cardio and weight training. And, to increase your aerobic capacity, you should incorporate intense interval training. You’ll likely be sweating buckets and burning calories galore, so be prepared.");

INSERT INTO tips (tip)
VALUES ("If you already own a heart rate monitor, considering all the exercises you’ll be performing, this would be a good time to use it. If not, you may want to either go out and buy one, or learn how to do it yourself. Why? Duffy advises to 'monitor your heart rate' because 'it’s not just doing it and doing it for 60 minutes, it’s am I doing it hard enough for 60 minutes.'");

INSERT INTO tips (tip)
VALUES ("To further your endurance training, you need to put in total effort. Boyce says, 'you’re going for muscle exhaustion, so remember to fully exhaust the muscles.' How can you do that? Boyce suggests that you 'get good at the bodyweight staples – pull ups, chin ups, push ups, inverted rows, (and) squats.' He adds that, 'if you can master these movements for high reps, your muscles will get well conditioned.'");

INSERT INTO tips (tip)
VALUES ("It’s always tempting to take a break when training, but LaCerte advises that you should 'stick with rest times of 30 to 45 seconds between sets' because he says 'this will help increase your overall endurance.' LaCerte adds that 'if you are strength training, lift moderate to heavy weight and keep your rep range between 8 to 15 reps,' or 'if you’re running, mix duration cardio with sprinting.'");

INSERT INTO tips (tip)
VALUES ("Fatigue may be your biggest enemy when endurance training, but Cardiello gave us some tips to fight it. First, drink beet juice because 'it can actually increase stamina by up to 16%' and it 'helps your muscles produce more energy, more efficiently, making exercise less exhausting.' Another way to boost your performance is by carefully selecting your music because a recent study suggested that, 'when people listen to favorable music their blood vessels expanded 26%.'");

INSERT INTO tips (tip)
VALUES ("According to our personal trainers, if you want to build strength, you have to set goals and be patient. In the early going it’s important to be consistent and stick with your plan. When you’re in the gym, don’t get distracted. Stay focused on the task at hand. When you leave the gym, make sure you get proper rest and keep track of your progress. If you stay determined, your goals can be accomplished.");

INSERT INTO tips (tip)
VALUES ("Motivation is key. Cardiello advises to count down when performing reps and 'look at your dominant hand while you’re pushing up.' He explains that it 'automatically includes a positive reinforcement' because the dominant hand more easily and quickly moves the weight. Also, if you’re using the post-workout sauna time as a motivating factor, stop because it 'actually impairs performance and strength two days later.' Instead, Cardiello suggests taking cold showers or even 'ice baths to help replenish muscles.'");

INSERT INTO tips (tip)
VALUES ("When strength training, you’ll be putting your body through very strenuous activity, so it’s important to maintain proper form. Trink explains that by maintaining proper form 'you’re guaranteed to activate the muscle groups that you are looking to train and, most importantly, you’ll stay healthy and injury-free.' He adds that the guy 'who can stay healthiest can train the most and in the long run makes the most progress.'");

INSERT INTO tips (tip)
VALUES ("Ever notice how a bunch of seemingly insignificant things can make all the difference? Strength training is no different. Boyce explains that when you’re strength training you have to 'pay attention to the little things' because 'you’re only as strong as your weakest link.' As a result, he suggests that 'if you notice a deficiency, address it in conjunction with your program.'");

INSERT INTO tips (tip)
VALUES ("If you want to make progress, sometimes you have to change things up. Why? LaCerte explains that it’s important because you have 'to ensure that your body never gets adapted to what is coming next.' Once that happens, you may notice diminishing strength gain results. To avoid this possibility, LaCerte suggests that you could 'switch up how heavy you’re lifting, your tempo of an exercise, your rep/set count, or what time of the day you’re lifting.'");

INSERT INTO tips (tip)
VALUES ("Forget calorie counting and concern yourself with body fat percentages. You must also start eating the right types of foods, which for most people will mean only lean meats, increasing fruit and vegetable intake, and removing any processed foods or those high in sugar. With your nutrition in check, the next step is performing intense interval cardio training, as well as weight training. And, don’t forget to keep track of it all in a journal.");

INSERT INTO tips (tip)
VALUES ("Can’t get the scale to budge? It’s very possible you’re gaining muscle and shedding body fat so follow Trink’s advice and 'take pictures on a weekly basis.' Trink adds that it’s important to take 'front, back, (and) side pictures all from the same angle, same lighting, same clothing because the scales lie, pictures do not, and you’ll really be able to see a change that way.'");

INSERT INTO tips (tip)
VALUES ("'Learn to control your carbohydrate intake' because, as Duffy says, 'they can cause your body to store fat.' Duffy adds that it’s important to train cardiovascularly for more than 20 minutes at a time because in 'the first 20 minutes your body is basically burning carbohydrates for energy.' He continues stating that with every continuous minute past the 20-minute mark, you’ll begin 'burning more and more of the stored body fat.'");

INSERT INTO tips (tip)
VALUES ("To flatten your waist, Cardiello says you must 'go below your navel.' He cites a Syracuse University study indicating 'people burned more calories the day after they did a lower body resistance training (exercise) than after they worked their upper bodies because the leg carries, for one thing, more mass.' Cardiello also adds that 'getting a six-pack doesn’t mean doing 100 crunches a day, it means proper diet.'");

INSERT INTO tips (tip)
VALUES ("An often-overlooked factor, and one stressed by Trink, is to make 'sure that your GI tract is healthy, because that’s how you absorb all your nutrients.' Do so by consuming vitamins, fiber, minerals, a probiotic, and water. Cardiello suggests you drink 'ice cold water first thing in the morning' adding 'you’ll naturally boost your metabolism by up to 24% for 90 minutes.' LaCerte recommends you 'drink at least one gallon of water per day.'");



