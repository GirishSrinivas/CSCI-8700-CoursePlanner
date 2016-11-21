"""
Author: Girish Srinivas [gsrinivas@unomaha.edu] [girish.s.srinivas@gmail.com]
"""

import random

f = open('course_planner_DDL.sql', 'w')
dtable = []
instuctor = []
concentration = []
course = []
sectn = []
course_conc = []
users = []
login = []
student = []
a = ['lplanos', 'bpainter']


def create_database():
    f.write("DROP DATABASE IF EXISTS course_planner;" + "\n")
    f.write("CREATE DATABASE IF NOT EXISTS course_planner;" + "\n")
    f.write("USE course_planner;" + "\n")
    f.write("\n")


def drop_tables():
    f.write("DROP TABLE IF EXISTS enrolls;" + "\n")
    f.write("DROP TABLE IF EXISTS course_conc;" + "\n")
    f.write("DROP TABLE IF EXISTS section;" + "\n")
    f.write("DROP TABLE IF EXISTS student;" + "\n")
    f.write("DROP TABLE IF EXISTS advisor;" + "\n")
    f.write("DROP TABLE IF EXISTS login;" + "\n")
    f.write("DROP TABLE IF EXISTS users;" + "\n")
    f.write("DROP TABLE IF EXISTS concentration;" + "\n")
    f.write("DROP TABLE IF EXISTS course;" + "\n")
    f.write("DROP TABLE IF EXISTS instructor;" + "\n")
    f.write("DROP TABLE IF EXISTS department;" + "\n")
    f.write("\n")


def create_tables():
    cre_users = "CREATE TABLE users(netid varchar(25)," \
                "fname varchar(25)," \
                "lname varchar(25)," \
                "email varchar(50)," \
                "role varchar(25)," \
                "PRIMARY KEY(netid));"

    cre_login = "CREATE TABLE login(nuid int," \
                "pwd varchar(25)," \
                "netid varchar(25)," \
                "PRIMARY KEY(nuid, netid)," \
                "FOREIGN KEY(netid) REFERENCES users(netid));"

    cre_advisor = "CREATE TABLE advisor(a_netid varchar(25)," \
                  "PRIMARY KEY(a_netid)," \
                  "FOREIGN KEY(a_netid) REFERENCES users(netid));"

    cre_student = "CREATE TABLE student(s_netid varchar(25)," \
                  "s_level varchar(25)," \
                  "s_major varchar(50)," \
                  "s_conc varchar(50)," \
                  "a_netid varchar(25)," \
                  "PRIMARY KEY(s_netid)," \
                  "FOREIGN KEY(s_netid) REFERENCES users(netid)," \
                  "FOREIGN KEY(a_netid) REFERENCES advisor(a_netid));"

    cre_course = "CREATE TABLE course(c_id varchar(25)," \
                 "c_name varchar(100)," \
                 "c_credits int," \
                 "c_rotation int," \
                 "c_type varchar(25)," \
                 "PRIMARY KEY(c_id));"

    cre_conc = "CREATE TABLE concentration(conc_id varchar(25)," \
               "conc_name varchar(50)," \
               "PRIMARY KEY(conc_id));"

    cre_courseConc = "CREATE TABLE course_conc(c_id varchar(25)," \
                     "conc_id varchar(25)," \
                     "FOREIGN KEY(c_id) REFERENCES course(c_id)," \
                     "FOREIGN KEY(conc_id) REFERENCES concentration(conc_id));"

    cre_dept = "CREATE TABLE department(dept_id varchar(25)," \
               "dept_name varchar(100)," \
               "PRIMARY KEY(dept_id));"

    cre_inst = "CREATE TABLE instructor(inst_netid varchar(25)," \
               "inst_fname varchar(25)," \
               "inst_lname varchar(25)," \
               "dept_id varchar(25)," \
               "PRIMARY KEY(inst_netid)," \
               "FOREIGN KEY(dept_id) REFERENCES department(dept_id));"

    cre_sec = "CREATE TABLE section(c_id varchar(25)," \
              "sec_sid varchar(25)," \
              "sec_year int," \
              "sec_term varchar(25)," \
              "sec_seats int," \
              "sec_aseats int," \
              "sec_enstat varchar(25)," \
              "sec_loc varchar(25)," \
              "sec_days varchar(25)," \
              "sec_stime varchar(25)," \
              "sec_etime varchar(25)," \
              "sec_sdate varchar(25)," \
              "sec_edate varchar(25)," \
              "inst_netid varchar(25)," \
              "PRIMARY KEY(sec_sid, sec_term, sec_year)," \
              "FOREIGN KEY (c_id) REFERENCES course(c_id)," \
              "FOREIGN KEY (inst_netid) REFERENCES instructor(inst_netid));"

    cre_enrolls = "CREATE TABLE enrolls(sec_sid varchar(25)," \
                  "sec_term varchar(25)," \
                  "sec_year int," \
                  "s_netid varchar(25)," \
                  "grade varchar(5)," \
                  "FOREIGN KEY(sec_sid, sec_term, sec_year) REFERENCES section(sec_sid, sec_term, sec_year)," \
                  "FOREIGN KEY(s_netid) REFERENCES student(s_netid));"

    f.write(cre_users + "\n")
    f.write(cre_login + "\n")
    f.write(cre_advisor + "\n")
    f.write(cre_student + "\n")
    f.write(cre_course + "\n")
    f.write(cre_conc + "\n")
    f.write(cre_courseConc + "\n")
    f.write(cre_dept + "\n")
    f.write(cre_inst + "\n")
    f.write(cre_sec + "\n")
    f.write(cre_enrolls + "\n")
    f.write("\n")


def ins_dept():
    d = open('department.txt', 'r')
    for line in d:
        line = line.strip()
        s = line.split("_")
        dtable.append(s)

    dept, major = map(list, zip(*dtable))

    for d1, m1 in zip(dept, major):
        dept_query = "INSERT INTO department VALUES('%s', '%s');" % (d1, m1)
        f.write(dept_query + "\n")
    f.write("\n")
    d.close()


def ins_instructor():
    inst = open('instructor.txt', 'r')
    for line in inst:
        line = line.strip()
        s = line.split("_")
        instuctor.append(s)

    i, f1, l, d = map(list, zip(*instuctor))

    for ids, fn, ln, dept in zip(i, f1, l, d):
        inst_query = "INSERT INTO instructor VALUES('%s', '%s', '%s', '%s');" % (ids, fn, ln, dept)
        f.write(inst_query + "\n")
    f.write("\n")
    inst.close()


def ins_concentration():
    conc = open('concentration.txt', 'r')
    for line in conc:
        line = line.strip()
        s = line.split("_")
        concentration.append(s)

    i, n = map(list, zip(*concentration))

    for ids, name in zip(i, n):
        inst_conc = "INSERT INTO concentration VALUES('%s', '%s');" % (ids, name)
        f.write(inst_conc + "\n")
    f.write("\n")
    conc.close()


def ins_course():
    crs = open('course.txt', 'r')
    for line in crs:
        line = line.strip()
        s = line.split("_")
        course.append(s)

    i, cn, c, t, r = map(list, zip(*course))

    for ids, cname, cre, typ, rot in zip(i, cn, c, t, r):
        inst_course = "INSERT INTO course VALUES('%s', '%s', %d, %d, '%s');" % (ids, cname, int(cre), int(rot), typ)
        f.write(inst_course + "\n")
    f.write("\n")
    crs.close()


def ins_section():
    sec = open('section.txt', 'r')
    for line in sec:
        line = line.strip()
        s = line.split("_")
        sectn.append(s)

    c, s, y, t, ts, es, est, l, d, t1, t2, d1, d2, i = map(list, zip(*sectn))

    for cid, sid, yy, trm, ms, es, est, loc, ds, st, et, sd, ed, iid in zip(c, s, y, t, ts, es, est, l, d, t1, t2, d1, d2, i):
        inst_sec = "INSERT INTO section VALUES('%s', '%s', %d, '%s', %d, %d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');" \
                   % (cid, sid, int(yy), trm, int(ms), int(es), est, loc, ds, st, et, sd, ed, iid)
        f.write(inst_sec + "\n")
    f.write("\n")
    sec.close()


def ins_courseconc():
    cc = open('course_conc.txt', 'r')
    for line in cc:
        line = line.strip()
        s = line.split("_")
        course_conc.append(s)

    ci, cc1 = map(list, zip(*course_conc))

    for cid, ccid in zip(ci, cc1):
        inst_crsconc = "INSERT INTO course_conc VALUES('%s', '%s');" % (cid, ccid)
        f.write(inst_crsconc + "\n")
    f.write("\n")
    cc.close()


def ins_users():
    usr = open('users.txt', 'r')
    for line in usr:
        line = line.strip()
        s = line.split("_")
        users.append(s)

    n, f1, l, e, r = map(list, zip(*users))

    for netid, fn, ln, email, role in zip(n, f1, l, e, r):
        inst_usr = "INSERT INTO users VALUES('%s', '%s', '%s', '%s', '%s');" % (netid, fn, ln, email, role)
        f.write(inst_usr + "\n")
    f.write("\n")
    usr.close()


def ins_advisor():
    for netid in a:
        inst_adv = "INSERT INTO advisor VALUES('%s');" % (netid)
        f.write(inst_adv + "\n")
    f.write("\n")


def ins_stud():
    std = open('student.txt', 'r')
    for line in std:
        line = line.strip()
        s = line.split("_")
        student.append(s)

    sn, sl, sm, sc = map(list, zip(*student))

    for nid, lvl, mjr, conc in zip(sn, sl, sm, sc):
        inst_stud = "INSERT INTO student VALUES('%s', '%s', '%s', '%s', '%s');" % (nid, lvl, mjr, conc, random.choice(a))
        f.write(inst_stud + "\n")
    f.write("\n")
    std.close()


def ins_login():
    log = open('login.txt', 'r')
    for line in log:
        line = line.strip()
        s = line.split("_")
        login.append(s)

    n, p, i = map(list, zip(*login))

    for nuid, pwd, id in zip(n, p, i):
        inst_login = "INSERT INTO login VALUES(%d, '%s', '%s');" % (int(nuid), pwd, id)
        f.write(inst_login + "\n")
    f.write("\n")
    log.close()


def main():
    create_database()
    drop_tables()
    create_tables()
    ins_dept()
    ins_instructor()
    ins_concentration()
    ins_course()
    ins_section()
    ins_courseconc()
    ins_users()
    ins_advisor()
    ins_stud()
    ins_login()

    f.close()

if __name__ == "__main__":
    main()
