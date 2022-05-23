insert into t_user1 (username,password,nickname,address,gender,intro) value ('admin','123','管理员','云南省昭通市',1,'超级管理员');
insert into t_user1 values (null,'zhangsan','123','张三',0,'做生意的张三','张三的家');

update t_user1 set intro='老张已经不做生意了' where id=2;

delete from t_user1 where id=2;

delete from t_user1 #表示满足所有条件，意味着删除所有信息

truncate table t_user1;

select * from user_1   //显示表格数据

