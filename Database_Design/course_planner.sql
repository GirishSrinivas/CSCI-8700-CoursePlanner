use course_planner;

/* for login table */

create table login(net_id varchar(25),
    -> fname varchar(25),
    -> lname varchar(25),
    -> role varchar(25),
    -> email varchar(50),
    -> pwd varchar(25),
    -> primary key (net_id));

/* for student table */

create table student(nuid int,
    -> net_id varchar(25),
    -> fname varchar(25),
    -> lname varchar(25),
    -> level varchar(25),
    -> major varchar(25),
    -> concentration varchar(25),
    -> primary key(nuid));  


