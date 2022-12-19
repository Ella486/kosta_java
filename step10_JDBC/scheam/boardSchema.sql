drop table board;

create table board(
	board_no int primary key, --글번호
	subject varchar2(30) not null,
	writer varchar2(20) not null,
	content varchar2(50) not null, --내용
	board_date date not null --등록일
); 


--시퀀스 만들기 전에 권한 부여(system계정에서만 가능)
grant  create sequence  to scott;

  
--시퀀스 만들기
create sequence board_seq nocache; 

drop sequence board_seq

select * from board where upper(subject) like upper(?);

commit

insert into board (board_no, subject, writer, content, board_date) 
values (board_seq.nextval, 'db수업', '장희정', '잼난다', sysdate)

insert into board (board_no, subject, writer, content, board_date) 
values (board_seq.nextval, 'db수업2', '이나영', '잼난다', sysdate)

insert into board (board_no, subject, writer, content, board_date) 
values (board_seq.nextval, 'db수업3', '이효리', '잼난다', sysdate)



select * from member;



















