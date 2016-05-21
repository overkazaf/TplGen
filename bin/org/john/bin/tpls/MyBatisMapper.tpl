<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="{{MapperPackage}}.{{Entity}}Mapper">

	<insert id="add{{Entity}}" parameterType="{{entity}}" useGeneratedKeys="true" keyProperty="{{EntityKey}}">
	INSERT
	INTO
	{{EntityTableName}}
	(
		advertiser_id,
		display,
		alias,
		field_name,
		datatype,
		created_by,
		created_date,
		modified_by,
		modified_date
	)
	VALUES
	(
		#{advertiserId,jdbcType=INTEGER},
		#{display,jdbcType=VARCHAR},
		#{alias,jdbcType=VARCHAR},
		#{fieldName,jdbcType=VARCHAR},
		#{datatype,jdbcType=VARCHAR},
		#{createdBy},
		#{createdDate},
		#{modifiedBy},
		#{modifiedDate}
	)
	</insert>
	
	<delete id="remove{{Entity}}ById" parameterType="int">
		DELETE
		FROM
		{{EntityTableName}}
		WHERE
		{{entity}}_id = #{id};
	</delete>
	
	
	<select id="is{{Entity}}Exists" parameterType="int" resultType="int">
		SELECT
		COUNT(*)
		FROM
		{{Entity}}
		WHERE
		{{entity}}_id = #{id}
	</select>
	
	<select id="findAll{{Entity}}s" parameterType="int" resultType="{{entity}}">
		SELECT
		id,
		advertiser_id advertiserId,
		display,
		alias,
		field_name fieldName,
		datatype
		FROM
		{{EntityTableName}}
		WHERE
		{{entity}}_id = #{id}
	</select>
	
	
	<update id="update{{Entity}}" parameterType="{{entity}}">
		UPDATE
		{{EntityTableName}}
		SET
		display = #{display,jdbcType=VARCHAR},
		alias = #{alias,jdbcType=VARCHAR},
		datatype = #{datatype,jdbcType=VARCHAR},
		created_by = #{createdBy},
		created_date = #{createdDate},
		modified_by = #{modifiedBy},
		modified_date = #{modifiedDate}
		WHERE
		advertiser_id = #{advertiserId,jdbcType=INTEGER}
		AND
		field_name = #{fieldName,jdbcType=VARCHAR}
		
	</update>
</mapper>