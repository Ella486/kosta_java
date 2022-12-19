drop table board;

create table board(
	board_no int primary key, --�۹�ȣ
	subject varchar2(30) not null,
	writer varchar2(20) not null,
	content varchar2(50) not null, --����
	board_date date not null --�����
); 


--������ ����� ���� ���� �ο�(system���������� ����)
grant  create sequence  to scott;

  
--������ �����
create sequence board_seq nocache; 

drop sequence board_seq

select * from board where upper(subject) like upper(?);

commit

insert into board (board_no, subject, writer, content, board_date) 
values (board_seq.nextval, 'db����', '������', '�볭��', sysdate)

insert into board (board_no, subject, writer, content, board_date) 
values (board_seq.nextval, 'db����2', '�̳���', '�볭��', sysdate)

insert into board (board_no, subject, writer, content, board_date) 
values (board_seq.nextval, 'db����3', '��ȿ��', '�볭��', sysdate)



select * from member;



















