-- 기본 --
create table chat (
chat_id int auto_increment,
user_code int not null,
insert_date timestamp,
update_date timestamp,
chat_kind varchar(1),
chat_body text,
constraint chat_pk primary key (chat_id),
constraint chat_fk foreign key (user_code) references user(user_code)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

create table chathistory (
history_id int auto_increment,
chat_id int,
user_info varchar(1000) not null,
chat_body text,
insert_date datetime,
update_date datetime,
constraint history_pk primary key (history_id),
constraint history_fk foreign key (chat_id) references chat(chat_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

-- 기능 --
create table exam (
exam_id int auto_increment primary key,
exam_kind int not null,
subject_code varchar(30) not null,
exam_num int not null,
exam_question varchar(1000) not null,
exam_division char(1) not null,
exam_choice1 varchar(100) not null,
exam_choice2 varchar(100) not null,
exam_choice3 varchar(100) not null,
exam_choice4 varchar(100) not null,
exam_choice5 varchar(100) not null,
exam_answer varchar(200) not null,
exam_content varchar(1000) not null,
insert_date timestamp
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

create table examanalysis (
analysis_id int auto_increment primary key,
user_code int not null,
subject_code varchar(30) not null,
exam_kind int not null,
exam_num int not null,
wrong_answer varchar(200) not null,
insert_date timestamp,
constraint examanalysis_fk foreign key (user_code) references user(user_code)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;


--연관 관계--
CREATE TABLE user
(
    `id`                INT            NOT NULL    AUTO_INCREMENT,
    `user_code`         INT            NOT NULL UNIQUE,
    `school_code`       INT            NOT NULL,
    //데이터 파일과 다른 필드명 문의
    `cur_grade`         INT            NULL,
    `home_class`        INT            NULL,
    `name`              VARCHAR(9)     NOT NULL,
    `user_id`           VARCHAR(20)    NOT NULL,
    `user_pw`           VARCHAR(20)    NOT NULL,
    `email`             VARCHAR(50)    NULL,
    `phone`             VARCHAR(13)    NULL,
    `gardian_phone`     VARCHAR(13)    NULL,
    `gardian_relation`  VARCHAR(2)     NULL,
    `gender`            VARCHAR(1)     NULL,
    `position_checker`  int            NOT NULL,
    `insert_date`       DATETIME       NULL,
    `update_date`       DATETIME       NULL,
    PRIMARY KEY (id)
)ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;