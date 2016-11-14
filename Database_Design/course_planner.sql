use course_planner;

/* for login table */

CREATE TABLE users(netid varchar(25),
                   fname varchar(25),
                   lname varchar(25),
                   email varchar(50),
                    PRIMARY KEY(netid));
/* for student table */

CREATE TABLE login(nuid int,
                   pwd varchar(25),
                   netid varchar(25),
                   PRIMARY KEY(nuid, netid),
                   FOREIGN KEY(netid) REFERENCES users(netid));

CREATE TABLE advisor(a_netid varchar(25),
                     PRIMARY KEY(a_netid),
                     FOREIGN KEY(a_netid) REFERENCES users(netid));

CREATE TABLE student(s_netid varchar(25),
                     s_level varchar(25),
                     s_major varchar(25),
                     s_conc varchar(25),
                     a_netid varchar(25),
                     PRIMARY KEY(s_netid),
                     FOREIGN KEY(s_netid) REFERENCES users(netid),
                     FOREIGN KEY(a_netid) REFERENCES advisor(a_netid))




