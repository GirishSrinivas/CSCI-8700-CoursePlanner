use course_planner;

/* for login table */

create table login(net_id varchar(25),
    -> fname varchar(25),
    -> lname varchar(25),
    -> role varchar(25),
    -> email varchar(50),
    -> pwd varchar(25),
    -> primary key (net_id));


