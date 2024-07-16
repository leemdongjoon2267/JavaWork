
CREATE TABLE comment
(
  comm_uid INT           NOT NULL AUTO_INCREMENT COMMENT '댓글일련번호',
  content  VARCHAR(1000) NOT NULL COMMENT '내용',
  date     DATETIME      NOT NULL COMMENT '작성일',
  post_uid INT           NOT NULL COMMENT '게시물일련번호',
  user_uid INT           NOT NULL COMMENT '회원일련번호',
  PRIMARY KEY (comm_uid)
) COMMENT '댓글';

CREATE TABLE friend
(
  user_uid   INT NOT NULL COMMENT '회원일련번호',
  friend_uid INT NOT NULL COMMENT '친구일련번호',
  PRIMARY KEY (user_uid, friend_uid)
) COMMENT '친구';

CREATE TABLE friendrequest
(
  user_uid    INT NOT NULL COMMENT '회원일련번호',
  request_uid INT NOT NULL COMMENT '요청회원일련번호',
  PRIMARY KEY (user_uid, request_uid)
) COMMENT '친구요청';

CREATE TABLE like
(
  user_uid INT NOT NULL COMMENT '회원일련번호',
  post_uid INT NOT NULL COMMENT '게시물일련번호',
  PRIMARY KEY (user_uid, post_uid)
) COMMENT '좋아요';

CREATE TABLE picture
(
  info     VARCHAR(100) NOT NULL COMMENT '파일명정보',
  post_uid INT          NOT NULL COMMENT '게시물일련번호',
  PRIMARY KEY (info)
) COMMENT '사진';

CREATE TABLE posting
(
  post_uid INT               NOT NULL AUTO_INCREMENT COMMENT '게시물일련번호',
  title    VARCHAR(100)      NOT NULL COMMENT '제목',
  content  VARCHAR(1000)     NULL     COMMENT '내용',
  public   ENUM('공개', '비공개') NOT NULL COMMENT '공개수준',
  user_uid INT               NOT NULL COMMENT '회원일련번호',
  PRIMARY KEY (post_uid)
) COMMENT '게시물';

CREATE TABLE user
(
  user_uid INT          NOT NULL AUTO_INCREMENT COMMENT '회원일련번호',
  id       VARCHAR(100) NOT NULL COMMENT '아이디',
  password VARCHAR(100) NOT NULL COMMENT '패스워드',
  PRIMARY KEY (user_uid)
) COMMENT '회원';

ALTER TABLE user
  ADD CONSTRAINT UQ_id UNIQUE (id);

ALTER TABLE posting
  ADD CONSTRAINT FK_user_TO_posting
    FOREIGN KEY (user_uid)
    REFERENCES user (user_uid);

ALTER TABLE like
  ADD CONSTRAINT FK_user_TO_like
    FOREIGN KEY (user_uid)
    REFERENCES user (user_uid);

ALTER TABLE like
  ADD CONSTRAINT FK_posting_TO_like
    FOREIGN KEY (post_uid)
    REFERENCES posting (post_uid);

ALTER TABLE comment
  ADD CONSTRAINT FK_posting_TO_comment
    FOREIGN KEY (post_uid)
    REFERENCES posting (post_uid);

ALTER TABLE comment
  ADD CONSTRAINT FK_user_TO_comment
    FOREIGN KEY (user_uid)
    REFERENCES user (user_uid);

ALTER TABLE picture
  ADD CONSTRAINT FK_posting_TO_picture
    FOREIGN KEY (post_uid)
    REFERENCES posting (post_uid);

ALTER TABLE friend
  ADD CONSTRAINT FK_user_TO_friend
    FOREIGN KEY (user_uid)
    REFERENCES user (user_uid);

ALTER TABLE friend
  ADD CONSTRAINT FK_user_TO_friend1
    FOREIGN KEY (friend_uid)
    REFERENCES user (user_uid);

ALTER TABLE friendrequest
  ADD CONSTRAINT FK_user_TO_friendrequest
    FOREIGN KEY (user_uid)
    REFERENCES user (user_uid);

ALTER TABLE friendrequest
  ADD CONSTRAINT FK_user_TO_friendrequest1
    FOREIGN KEY (request_uid)
    REFERENCES user (user_uid);
