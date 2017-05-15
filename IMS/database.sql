CREATE DATABASE
IF NOT EXISTS `user`;

USE `user`;

CREATE TABLE
IF NOT EXISTS teacher (
	ID INT (10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR (34) NOT NULL,
	`password` VARCHAR (20) NOT NULL,
	`nickname` VARCHAR (34) NOT NULL
);

INSERT INTO teacher (
	username,
	`password`,
	nickname
) SELECT
	'admin1',
	'123',
	'李老师'
FROM
	DUAL
WHERE
	NOT EXISTS (
		SELECT
			username
		FROM
			teacher
		WHERE
			username = 'admin1'
	);

INSERT INTO teacher (
	username,
	`password`,
	nickname
) SELECT
	'admin2',
	'456',
	'邓老师'
FROM
	DUAL
WHERE
	NOT EXISTS (
		SELECT
			username
		FROM
			teacher
		WHERE
			username = 'admin2'
	);

CREATE TABLE
IF NOT EXISTS student (
	ID INT (10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	stuName VARCHAR (34) NOT NULL,
	teacherID INT (10) NOT NULL,
	stuAge INT (10) NOT NULL,
	stuSex INT (1) NOT NULL,
	comments VARCHAR (50) NOT NULL
);

INSERT INTO student (
	stuName,
	teacherID,
	stuAge,
	stuSex,
	comments
)
VALUE
	(
		'张三',
		1,
		22,
		1,
		'学员成绩优秀'
	),
	(
		'李四',
		1,
		23,
		0,
		'学员成绩良好'
	),
	(
		'王五',
		1,
		26,
		1,
		'新学员'
	),
	(
		'赵六',
		2,
		21,
		1,
		'学员成绩优秀'
	);

