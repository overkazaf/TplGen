package org.john.bin;

import java.io.File;
import java.util.Map;

public class PathManager {
	private String controllerPath;
	private String mapperPath;
	private String servicePath;
	private String serviceImplPath;
	private String entityPath;
	
	private String myBatisMapperPath;
	private String myBatisConfigPath;
	private String resConfigPath;
	
	
	private String appPath;
	private String srcPath;
	private String resPath;
	
	
	private String controllerPackagePath;
	private String entityPackagePath;
	private String mapperPackagePath;
	private String servicePackagePath;
	private String serviceImplPackagePath;
	
	private Map<String, String> config;
	
	public PathManager (Map<String, String> config) {
		this.config = config;
		this.init();
	}
	
	public void init () {
		initPaths();
	}
	
	public void initPaths () {
		initRootPath();
		initSubPaths();
		initPackagePath();
	}
	
	public String getTplPath() {
		return this.getAppPath() + File.separator + this.config.get("tplFolder");
	}
	
	public String getTargetPrefix () {
		return this.config.get("targetPrefix").replace("/", File.separator);
	}
	
	public void initRootPath () {
		String temp;
		String userDirPath = System.getProperty("user.dir");
		
		temp = userDirPath + File.separator + "src" + File.separator + this.config.get("pkgPrefix");
		String appPath = temp.replace("/", File.separator);
		this.appPath = appPath;
		
		
		temp = userDirPath + File.separator + this.config.get("targetPath");
		String srcPath = temp.replace("/", File.separator);
		this.srcPath = srcPath;
		
		temp = userDirPath + File.separator +  this.config.get("targetMyBatisPath");
		String resPath = temp.replace("/", File.separator);
		this.resPath = resPath;
	}
	
	public void initSubPaths () {
		this.controllerPath = this.getSrcPath() + File.separator + this.getTargetPrefix() + File.separator + this.config.get("controllerFolder").replace("/", File.separator);
		this.entityPath = this.getSrcPath() + File.separator + this.getTargetPrefix() + File.separator + this.config.get("entityFolder").replace("/", File.separator);
		this.servicePath = this.getSrcPath() + File.separator + this.getTargetPrefix() + File.separator + this.config.get("serviceFolder").replace("/", File.separator);
		this.serviceImplPath = this.getSrcPath() + File.separator + this.getTargetPrefix() + File.separator + this.config.get("serviceImplFolder").replace("/", File.separator);
		this.mapperPath = this.getSrcPath() + File.separator + this.getTargetPrefix() + File.separator + this.config.get("mapperFolder").replace("/", File.separator);
		
		this.myBatisMapperPath = this.getResPath() + File.separator + this.getTargetPrefix() + File.separator + this.config.get("myBatisMapperFolder").replace("/", File.separator);
		this.myBatisConfigPath = this.getResPath() + File.separator + this.config.get("myBatisConfigFolder").replace("/", File.separator);
	}
	
	public void initPackagePath () {
		this.controllerPackagePath = this.config.get("packageSrc") + (this.getTargetPrefix() + File.separator + this.config.get("controllerFolder")).replace("/", File.separator).replace(File.separator, ".");
		this.entityPackagePath = this.config.get("packageSrc") + (this.getTargetPrefix() + File.separator + this.config.get("entityFolder")).replace("/", File.separator).replace(File.separator, ".");
		this.servicePackagePath = this.config.get("packageSrc") + (this.getTargetPrefix() + File.separator + this.config.get("serviceFolder")).replace("/", File.separator).replace(File.separator, ".");
		this.serviceImplPackagePath = this.config.get("packageSrc") + (this.getTargetPrefix() + File.separator + this.config.get("serviceImplFolder")).replace("/", File.separator).replace(File.separator, ".");
		this.mapperPackagePath = this.config.get("packageSrc") + (this.getTargetPrefix() + File.separator + this.config.get("mapperFolder")).replace("/", File.separator).replace(File.separator, ".");
		
		
		this.myBatisConfigPath = this.config.get("packageRes") + (this.config.get("myBatisMapperFolder")).replace("/", File.separator).replace(File.separator, ".");
		
		
	}
	
	
	public String getAppPath() {
		return appPath;
	}
	
	public String getSrcPath() {
		return srcPath;
	}

	public String getResPath() {
		return resPath;
	}

	public String getControllerPath() {
		return controllerPath;
	}

	public void setControllerPath(String controllerPath) {
		this.controllerPath = controllerPath;
	}

	public String getMapperPath() {
		return mapperPath;
	}

	public void setMapperPath(String mapperPath) {
		this.mapperPath = mapperPath;
	}

	public String getServicePath() {
		return servicePath;
	}

	public void setServicePath(String servicePath) {
		this.servicePath = servicePath;
	}

	public String getServiceImplPath() {
		return serviceImplPath;
	}

	public void setServiceImplPath(String serviceImplPath) {
		this.serviceImplPath = serviceImplPath;
	}

	public String getEntityPath() {
		return entityPath;
	}

	public void setEntityPath(String entityPath) {
		this.entityPath = entityPath;
	}

	public String getMyBatisMapperPath() {
		return myBatisMapperPath;
	}

	public void setMyBatisMapperPath(String myBatisMapperPath) {
		this.myBatisMapperPath = myBatisMapperPath;
	}

	public String getMyBatisConfigPath() {
		return myBatisConfigPath;
	}

	public void setMyBatisConfigPath(String myBatisConfigPath) {
		this.myBatisConfigPath = myBatisConfigPath;
	}

	public String getResConfigPath() {
		return resConfigPath;
	}

	public void setResConfigPath(String resConfigPath) {
		this.resConfigPath = resConfigPath;
	}

	public void setAppPath(String appPath) {
		this.appPath = appPath;
	}

	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}

	public void setResPath(String resPath) {
		this.resPath = resPath;
	}

	public String getControllerPackagePath() {
		return controllerPackagePath;
	}

	public void setControllerPackagePath(String controllerPackagePath) {
		this.controllerPackagePath = controllerPackagePath;
	}

	public String getEntityPackagePath() {
		return entityPackagePath;
	}

	public void setEntityPackagePath(String entityPackagePath) {
		this.entityPackagePath = entityPackagePath;
	}

	public String getMapperPackagePath() {
		return mapperPackagePath;
	}

	public void setMapperPackagePath(String mapperPackagePath) {
		this.mapperPackagePath = mapperPackagePath;
	}

	public String getServicePackagePath() {
		return servicePackagePath;
	}

	public void setServicePackagePath(String servicePackagePath) {
		this.servicePackagePath = servicePackagePath;
	}

	public String getServiceImplPackagePath() {
		return serviceImplPackagePath;
	}

	public void setServiceImplPackagePath(String serviceImplPackagePath) {
		this.serviceImplPackagePath = serviceImplPackagePath;
	}
	
}
