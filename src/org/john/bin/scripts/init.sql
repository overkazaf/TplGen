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
   id                bigint(30) not null comment '支付流水号',
   status               tinyint(2) not null comment '支付状态: 1. 支付成功; 2. 支付失败; 3. 退款成功',
   weixinOrder          varchar(50) comment '微信流水号',
   payMethod            varchar(50) comment '支付方法',
   weixinAccount        varchar(50) comment '微信账户',
   response             text comment '支付接口返回值',
   billingAmount        decimal,
   orderId              bigint(30) comment '订单编号',
   shopId               bigint(10) not null comment '店铺Id',
   supplierId           bigint(10) not null comment '供货商Id',
   remark               text comment '备注',
   gmtCreate            datetime not null,
   payTime              datetime,
   gmtModified          datetime,
   primary key (id)
)