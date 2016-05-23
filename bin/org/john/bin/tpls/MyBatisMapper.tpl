<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="{{MapperPackage}}.{{Entity}}Mapper">
	<sql id="Base_Column_List">
	{{EntityTableKeys}}
	</sql>
	
	<select id="find{{Entity}}ById" parameterType="int" resultType="{{entity}}">
		SELECT
			<include refid="Base_Column_List" />
		FROM
		{{TablePrefix}}{{Entity}}
		WHERE
		id = #{{{EntityPrimaryKey}}}
	</select>
	
	<select id="findAll{{Entity}}s" parameterType="int" resultType="{{entity}}">
		SELECT
			<include refid="Base_Column_List" />
		FROM
		{{TablePrefix}}{{Entity}}
	</select>
	
	<insert id="add{{Entity}}" parameterType="{{entity}}" useGeneratedKeys="true" keyProperty="{{EntityPrimaryKey}}">
	INSERT
	INTO
	{{TablePrefix}}{{Entity}}
	(
		<include refid="Base_Column_List" />
	)
	VALUES
	(
		{{EntityKeys}}
	)
	</insert>
	
	<insert id="addAll{{Entity}}s" parameterType="java.util.List">  
	    INSERT 
	    INTO 
	    {{TablePrefix}}{{Entity}}
	    (  
			<include refid="Base_Column_List" />  
		) 
		VALUES 
		<foreach collection="entityList" item="item" index="index" open="(" separator="," close=")" >  
	    	{{EntityKeys}}
		</foreach>
	</insert>  
	
	<delete id="remove{{Entity}}ById" parameterType="int">
		DELETE
		FROM
		{{TablePrefix}}{{Entity}}
		WHERE
		{{EntityTablePrimaryKey}} = #{{{EntityPrimaryKey}}}
	</delete>
	
	<delete id="removeAll{{Entity}}s" parameterType="java.util.List">
		DELETE
		FROM
		{{TablePrefix}}{{Entity}}
		WHERE
		id
		IN
		<foreach item="item" index="index" collection="idList" open="(" separator="," close=")">
			#{item.id}
		</foreach>
	</delete>
	
	
	<update id="update{{Entity}}" parameterType="{{entity}}">
		UPDATE
		{{TablePrefix}}{{Entity}}
		SET
		{{EntityUpdateArea}}
		WHERE
		id = #{{{EntityPrimaryKey}}}
	</update>
	
	<update id="updateAll{{Entity}}s" parameterType="java.util.List">
		UPDATE
		{{TablePrefix}}{{Entity}}
		SET
		{{EntityUpdateArea}}
		WHERE
		id 
		IN
		<foreach item="item" index="index" collection="idList" open="(" separator="," close=")">
			#{item.id}
		</foreach>
	</update>
</mapper>