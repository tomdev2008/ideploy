package io.ideploy.deployment.admin.po.account;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;


/**
 * 应用系统信息
 * 
 * <pre>
 *     自动生成代码: 表名 mz_app_define, 日期: 2015-08-03
 *     app_id <PK>             int(11)
 *     name              varchar(30)
 *     display_name      varchar(30)
 *     app_key           varchar(80)
 *     summary           varchar(255)
 *     status            tinyint(4)
 *     login_url         varchar(200)
 *     sequence          int(11)
 *     operator          int(11)
 *     last_modify       datetime(19)
 *     bug_report_url    varchar(200)
 *     create_time       datetime(19)
 * </pre>
 */
public class AppDefinePO implements Serializable {

	private static final long serialVersionUID = -3074457344788574693L;

	/** 流水号 */
	private int appId;

	/** 名称 */
	private String appName;

	/** 用于显示的名称 */
	private String displayName;

	/** 系统连接的密钥 */
	private String appKey;

	/** 系统描述 */
	private String summary;

	/** 是否可用1可用，2不可用 */
	private short appStatus = 1;

	/** 切换系统的登录url */
	private String loginUrl;

	/** 排序 */
	private int sequence = 0;

	/** 操作者 */
	private int operator;

	/** 更新时间 */
	private Date lastModify;

	/** 报bug url */
	private String bugReportUrl = "#";

	/** 创建时间 */
	private Date createTime;

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppName() {
		return appName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSummary() {
		return summary;
	}

	public void setAppStatus(short appStatus) {
		this.appStatus = appStatus;
	}

	public short getAppStatus() {
		return appStatus;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public int getSequence() {
		return sequence;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	public int getOperator() {
		return operator;
	}

	public void setLastModify(Date lastModify) {
		this.lastModify = lastModify;
	}

	public Date getLastModify() {
		return lastModify;
	}

	public void setBugReportUrl(String bugReportUrl) {
		this.bugReportUrl = bugReportUrl;
	}

	public String getBugReportUrl() {
		return bugReportUrl;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
