#code generator for springMVC and mybatis based web project

##Usage
1. enter src/org/john/bin
2. enter class TplGen
3. run the main function

##Notes
+ the entry package is located on /src/org/john/bin/
+ modify the setup.properties to match project structure
+ in the demo case, we use test schema, which contains table user, role,
	role_group and trade_weixin_pay tables to generate relative files if you
	want to fetch remote mysql database tables as your entities
+ allow users to use static model definitions in /src/org/john/bin/models/
+ /src/org/john/bin/scripts/init.sql is provided if you dont prepare some table
+ have fun
