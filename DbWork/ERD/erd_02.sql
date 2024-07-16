
CREATE TABLE department
(
  deptno INT         NOT NULL COMMENT '학과번호',
  phone  VARCHAR(20) NOT NULL COMMENT '전화번호',
  name   VARCHAR(10) NOT NULL COMMENT '학과명',
  dept   VARCHAR(10) NOT NULL COMMENT '사무실',
  PRIMARY KEY (deptno)
) COMMENT '학과';

CREATE TABLE lecture
(
  lecno     INT         NOT NULL COMMENT '강좌번호',
  name      VARCHAR(10) NOT NULL COMMENT '강좌명',
  gradeno   INT         NOT NULL COMMENT '학점수',
  lecadress VARCHAR(10) NOT NULL COMMENT '강의실',
  year      YEAR        NOT NULL COMMENT '년도',
  regno     INT         NOT NULL COMMENT '수강인원',
  profno    INT         NOT NULL COMMENT '교수번호',
  PRIMARY KEY (lecno)
) COMMENT '강좌';

CREATE TABLE professor
(
  profno   INT         NOT NULL AUTO_INCREMENT COMMENT '교수번호',
  jumin    VARCHAR(20) NOT NULL COMMENT '주민번호',
  address  VARCHAR(30) NOT NULL COMMENT '주소',
  name     VARCHAR(10) NOT NULL COMMENT '이름',
  post     VARCHAR(10) NOT NULL COMMENT '직위',
  phone    VARCHAR(20) NOT NULL COMMENT '전화번호',
  hiredate DATE        NOT NULL COMMENT '임용연도',
  deptno   INT         NOT NULL COMMENT '학과번호',
  PRIMARY KEY (profno)
) COMMENT '교수';

CREATE TABLE register
(
  lecno  INT NOT NULL COMMENT '강좌번호',
  studno INT NOT NULL COMMENT '학번',
  PRIMARY KEY (lecno, studno)
) COMMENT '수강';

CREATE TABLE student
(
  studno  INT         NOT NULL AUTO_INCREMENT COMMENT '학번',
  name    VARCHAR(10) NOT NULL COMMENT '이름',
  grade   INT         NOT NULL COMMENT '학년',
  address VARCHAR(30) NOT NULL COMMENT '주소',
  jumin   VARCHAR(20) NOT NULL COMMENT '주민번호',
  phone   VARCHAR(20) NOT NULL COMMENT '전화번호',
  deptno  INT         NOT NULL COMMENT '학과번호',
  PRIMARY KEY (studno)
) COMMENT '학생';

ALTER TABLE register
  ADD CONSTRAINT FK_lecture_TO_register
    FOREIGN KEY (lecno)
    REFERENCES lecture (lecno);

ALTER TABLE register
  ADD CONSTRAINT FK_student_TO_register
    FOREIGN KEY (studno)
    REFERENCES student (studno);

ALTER TABLE student
  ADD CONSTRAINT FK_department_TO_student
    FOREIGN KEY (deptno)
    REFERENCES department (deptno);

ALTER TABLE professor
  ADD CONSTRAINT FK_department_TO_professor
    FOREIGN KEY (deptno)
    REFERENCES department (deptno);

ALTER TABLE lecture
  ADD CONSTRAINT FK_professor_TO_lecture
    FOREIGN KEY (profno)
    REFERENCES professor (profno);
