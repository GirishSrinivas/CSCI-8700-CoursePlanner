
/* DDL for deleting a database */
DROP DATABASE IF EXISTS course_planner;


/* DDL for creating the database */
CREATE DATABASE IF NOT EXISTS course_planner;


/* DDL for selecting database */
USE course_planner;


/* DDL's for deleting tables */
DROP TABLE IF EXISTS enrolls;
DROP TABLE IF EXISTS course_conc;
DROP TABLE IF EXISTS section;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS advisor;
DROP TABLE IF EXISTS login;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS concentration;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS instructor;
DROP TABLE IF EXISTS department;


/* login table DDL */
CREATE TABLE users(netid varchar(25),
                   fname varchar(25),
                   lname varchar(25),
                   email varchar(50),
                   role varchar(25),
                    PRIMARY KEY(netid));


/* student table DDL */
CREATE TABLE login(nuid int,
                   pwd varchar(25),
                   netid varchar(25),
                   PRIMARY KEY(nuid, netid),
                   FOREIGN KEY(netid) REFERENCES users(netid));


/* advisor table DDL */
CREATE TABLE advisor(a_netid varchar(25),
                     PRIMARY KEY(a_netid),
                     FOREIGN KEY(a_netid) REFERENCES users(netid));


/* student table DDL */
CREATE TABLE student(s_netid varchar(25),
                     s_level varchar(25),
                     s_major varchar(25),
                     s_conc varchar(25),
                     a_netid varchar(25),
                     PRIMARY KEY(s_netid),
                     FOREIGN KEY(s_netid) REFERENCES users(netid),
                     FOREIGN KEY(a_netid) REFERENCES advisor(a_netid));


/* course table DDL */
CREATE TABLE course(c_id varchar(25),
                    c_name varchar(25),
                    c_credits int,
                    c_rotation int,
                    c_type varchar(25),
                    PRIMARY KEY(c_id));


/* concentration table DDL */
CREATE TABLE concentration(conc_id varchar(25),
                           conc_name varchar(25),
                           PRIMARY KEY(conc_id));


/* course_conc table DDL */
CREATE TABLE course_conc(c_id varchar(25),
                         conc_id varchar(25),
                         FOREIGN KEY(c_id) REFERENCES course(c_id),
                         FOREIGN KEY(conc_id) REFERENCES concentration(conc_id));


/* department table DDL */
CREATE TABLE department(dept_id varchar(25),
                        dept_name varchar(25),
                        PRIMARY KEY(dept_id));
                        

/* instructor table DDL */
CREATE TABLE instructor(inst_netid varchar(25),
                        inst_fname varchar(25),
                        inst_lname varchar(25),
                        dept_id varchar(25),
                        PRIMARY KEY(inst_netid),
                        FOREIGN KEY(dept_id) REFERENCES department(dept_id));


/* section table DDL */
CREATE TABLE section(c_id varchar(25),
             sec_sid varchar(25),
                     sec_term varchar(25),
                     sec_year int,
                     sec_seats int,
                     sec_aseats int,
                     sec_enstat varchar(25),
                     sec_loc varchar(25),
                     sec_days varchar(25),
                     sec_sdate date,
                     sec_edate date,
                     sec_stime time,
                     sec_etime time,
                     inst_netid varchar(25),
                     PRIMARY KEY(sec_sid, sec_term, sec_year),
                     FOREIGN KEY (c_id) REFERENCES course(c_id),
                     FOREIGN KEY (inst_netid) REFERENCES instructor(inst_netid));
                     

/* enrolls table DDL */
CREATE TABLE enrolls(sec_sid varchar(25),
                     sec_term varchar(25),
                     sec_year int,
                     s_netid varchar(25),
                     grade varchar(5),
                     FOREIGN KEY(sec_sid, sec_term, sec_year) REFERENCES section(sec_sid, sec_term, sec_year),
                     FOREIGN KEY(s_netid) REFERENCES student(s_netid));




