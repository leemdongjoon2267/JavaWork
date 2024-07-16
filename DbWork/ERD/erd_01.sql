
CREATE TABLE professor
(
  profno INT         NOT NULL AUTO_INCREMENT COMMENT '교수님번호',
  name   VARCHAR(10) NOT NULL COMMENT '이름',
  deptno INT         NULL     DEFAULT 101 COMMENT '학과번호',
  PRIMARY KEY (profno)
) COMMENT '교수님';

CREATE TABLE register
(
  studno INT NOT NULL COMMENT '학생번호',
  subjno INT NOT NULL COMMENT '과목번호',
  PRIMARY KEY (studno, subjno)
) COMMENT '수강';

CREATE TABLE student
(
  studno INT         NOT NULL AUTO_INCREMENT COMMENT '학생번호',
  name   VARCHAR(10) NOT NULL COMMENT '이름',
  deptno INT         NULL     COMMENT '전공학과',
  profno INT         NOT NULL COMMENT '교수님번호',
  PRIMARY KEY (studno)
) COMMENT '학생';

CREATE TABLE subject
(
  subjno INT         NOT NULL AUTO_INCREMENT COMMENT '과목번호',
  name   VARCHAR(10) NOT NULL COMMENT '과목명',
  profno INT         NOT NULL COMMENT '교수님번호',
  PRIMARY KEY (subjno)
) COMMENT '과목';

ALTER TABLE register
  ADD CONSTRAINT FK_subject_TO_register
    FOREIGN KEY (subjno)
    REFERENCES subject (subjno);

ALTER TABLE student
  ADD CONSTRAINT FK_professor_TO_student
    FOREIGN KEY (profno)
    REFERENCES professor (profno);

ALTER TABLE register
  ADD CONSTRAINT FK_student_TO_register
    FOREIGN KEY (studno)
    REFERENCES student (studno);

ALTER TABLE subject
  ADD CONSTRAINT FK_professor_TO_subject
    FOREIGN KEY (profno)
    REFERENCES professor (profno);
