insert into t_user1 (username,password,nickname,address,gender,intro) value ('admin','123','����Ա','����ʡ��ͨ��',1,'��������Ա');
insert into t_user1 values (null,'zhangsan','123','����',0,'�����������','�����ļ�');

update t_user1 set intro='�����Ѿ�����������' where id=2;

delete from t_user1 where id=2;

delete from t_user1 #��ʾ����������������ζ��ɾ��������Ϣ

truncate table t_user1;

select * from user_1   //��ʾ�������

