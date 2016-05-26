use test;
create table if not exists user(
	id int primary key not null auto_increment,
	age int(3),
	name varchar(32),
	password varchar(32),
	phone varchar(11),
	gender tinyint(2),
	create_date datetime,
	register_date datetime
);

create table if not exists role(
	id int primary key not null auto_increment,
	role_name varchar(32),
	previlige_level int(3),
	create_by varchar(32),
	create_date datetime,
	modified_by varchar(32),
	modified_date datetime
);

create table if not exists role_group(
	id int primary key not null auto_increment,
	role_group_name varchar(32),
	create_by varchar(32),
	create_date datetime,
	modified_by varchar(32),
	modified_date datetime
);


create table if not exists trade_weixin_pay
(
   id                bigint(30) not null comment '֧����ˮ��',
   status               tinyint(2) not null comment '֧��״̬: 1. ֧���ɹ�; 2. ֧��ʧ��; 3. �˿�ɹ�',
   weixinOrder          varchar(50) comment '΢����ˮ��',
   payMethod            varchar(50) comment '֧������',
   weixinAccount        varchar(50) comment '΢���˻�',
   response             text comment '֧���ӿڷ���ֵ',
   billingAmount        decimal,
   orderId              bigint(30) comment '�������',
   shopId               bigint(10) not null comment '����Id',
   supplierId           bigint(10) not null comment '������Id',
   remark               text comment '��ע',
   gmtCreate            datetime not null,
   payTime              datetime,
   gmtModified          datetime,
   primary key (id)
)