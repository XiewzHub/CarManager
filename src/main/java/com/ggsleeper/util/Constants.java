package com.ggsleeper.util;
/**
 * 全局变量类
 */
public class Constants {
	/**
	 * 用户信息存入会话的键值（key）
	 */
	public static final String USER_SESSION="USER_SESSION";
	/**
	 * 用户角色信息存入会话的键值（key）
	 */
	public static final String USER_SESSION_ROLE="USER_SESSION_ROLE";
	/**
	 * 用户登录跳转回话存入数据
	 */
	public static final String USER_SESSION_REDIRECT="USER_SESSION_REDIRECT";
	/**
	 * 用户自定义分页条数存入回话的键值（key）
	 */
	public static final String USER_SESSION_PAGE_SIZE="USER_SESSION_PAGE_SIZE";
	/**
	 * 用户自定义分页条数存入会话的键值 (key)
	 */
	public static final String USER_SESSION_PAGE_SIZE_PROJECT_INVESTMENT = "USER_SESSION_PAGE_SIZE_PROJECT_INVESTMENT";//出资
	/**
	 * 用户自定义分页条数存入会话的键值 (key)
	 */
	public static final String USER_SESSION_PAGE_SIZE_COMPANY_PAY = "USER_SESSION_PAGE_SIZE_COMPANY_PAY";//出资
	/**
	 * 新出资
	 * 用户自定义分页条数存入会话的键值 (key)
	 */
	//public static final String USER_SESSION_PAGE_SIZE_PROJECT_CONTRIBUTION = "USER_SESSION_PAGE_SIZE_PROJECT_CONTRIBUTION";//新出资
	/**
	 * 用户自定义分页条数存入会话的键值 (key)
	 */
	public static final String USER_SESSION_PAGE_SIZE_COMPANY_FOUND = "USER_SESSION_PAGE_SIZE_COMPANY_FOUND";//公司建立
	
	
	
	/**
	 * 用户自定义分页条数存入会话的键值 (key)
	 */
	public static final String USER_SESSION_PAGE_SIZE_PROJECT = "USER_SESSION_PAGE_SIZE_PROJECT";//项目
	/**
	 * 用户自定义分页条数存入会话的键值 (key)
	 */
	public static final String USER_SESSION_PAGE_SIZE_LXTJ = "USER_SESSION_PAGE_SIZE_LXTJ";//立项投决
	/**
	 * 用户自定义分页条数存入会话的键值 (key)
	 */
	public static final String USER_SESSION_PAGE_SIZE_FYCLSQ = "USER_SESSION_PAGE_SIZE_FYCLSQ";//费用差旅申请
	/**
	 * 用户自定义分页条数存入会话的键值 (key)
	 */
	public static final String USER_SESSION_PAGE_SIZE_FYCLBX = "USER_SESSION_PAGE_SIZE_FYCLBX";//费用差旅报销
	/**
	 * 用户自定义分页条数存入会话的键值 (key)
	 */
	public static final String USER_SESSION_PAGE_SIZE_FYCLBX_NOT = "USER_SESSION_PAGE_SIZE_FYCLBX_NOT";//未提交的费用差旅报销
	/**
	 * 用户自定义分页条数存入会话的键值 (key)
	 */
	public static final String USER_SESSION_PAGE_SIZE_YZSQ = "USER_SESSION_PAGE_SIZE_YZSQ";//用章申请审批
	/**
	 * 用户自定义分页条数存入会话的键值 (key)
	 */
	public static final String USER_SESSION_PAGE_SIZE_QBHB = "USER_SESSION_PAGE_SIZE_QBHB";//签报汇报审批
	/**
	 * 用户自定义分页条数存入会话的键值 (key)
	 */
	public static final String USER_SESSION_PAGE_SIZE_TYQB = "USER_SESSION_PAGE_SIZE_TYQB";//通用签报审批
	/**
	 * 用户自定义分页条数存入会话的键值 (key)
	 */
	public static final String USER_SESSION_PAGE_SIZE_YDPF = "USER_SESSION_PAGE_SIZE_YDPF";//月度评分审批
	/**
	 * 用户自定义分页条数存入会话的键值 (key)
	 */
	public static final String USER_SESSION_PAGE_SIZE_QJSQ = "USER_SESSION_PAGE_SIZE_QJSQ";//请假申请审批
	/**
	 * 用户自定义分页条数存入会话的键值 (key)
	 */
	public static final String USER_SESSION_PAGE_SIZE_JXMBSP = "USER_SESSION_PAGE_SIZE_JXMBSP";//绩效目标审批
	/**
	 * 用户自定义分页条数存入会话的键值 (key)
	 */
	public static final String USER_SESSION_PAGE_SIZE_JXPGSP = "USER_SESSION_PAGE_SIZE_JXPGSP";//绩效评估审批
	/**
	 * 用户自定义分页条数存入会话的键值 (key)
	 */
	public static final String USER_SESSION_PAGE_SIZE_BUSINESS_PROCESS = "USER_SESSION_PAGE_SIZE_BUSINESS_PROCESS";//绩效评估审批
	
	
	/**
	 * excel导出时文件名称在请求中的键值（key）
	 */
	public static final String OUTPUT_EXCEL_NAME="OUTPUT_EXCEL_NAME";
	/**
	 * 用户状态为可用
	 */
	public static final String USER_ENABLE="Y";
	/**
	 * 用户状态为不可用
	 */
	public static final String USER_DISABLE="N";
	/**
	 * 存储用户是否是 管理员
	 */
	public static final String USER_SESSION_ROLE_ADMIN="USER_SESSION_ROLE_ADMIN";
	/**
	 * 判断是否是管理员
	 */
	public static final String USER_ADMIN="系统管理员"; 
	/**
	 * 财务
	 */
	public static final String FINANCE="财务";
	/**
	 * 财务
	 */
	public static final String FINANCE_DEPT="财务部";
	/**
	 * 财务总监
	 */
	public static final String FINANCE_DEPARTMENT="财务部门总监";
	/**
	 * 战略市场部负责人
	 */
	public static final String MARKET_DEPARTMENT="战略市场部";
	/**
	 * 管理层
	 */
	public static final String COMPANY_MANAGE_DEPT="管理层";
	/**
	 * 判断是否是投资部成员，获取项目成员列表
	 */
	public static final String PROJECT_TEAM_FILTER="投资部"; 
	/**
	 * 判断是否是投资一部
	 */
	public static final String PROJECT_FILTER_ONE="投资一部";
	/**
	 * 判断是否是投资二部
	 */
	public static final String PROJECT_FILTER_TWO="投资二部";
	public static final String USER_LU_WEI="卢伟";
	public static final String USER_ZHENEGJIE="郑杰";
	public static final String USER_MING_MEI="明媚";
	public static final String USER_LI_JINXIAN="李进先";
	public static final String USER_WANG_BOZHAO="王博钊";
	public static final String USER_MA_WU_SHEN="马武申";
	public static final String USER_QIANG_YANG="乔洋";
	/**
	 * 绩效评估节点名称  直属经理审批
	 */
	public static final String MANAGER_APPROVE="直属经理审批";
	/**
	 * 绩效评估节点名称  直属经理评估
	 */
	public static final String MANAGER_ESTIMATE="直属经理评估";
	/**
	 * 绩效评估节点名称  总经理评估
	 */
	public static final String GENERAL_MANAGER_ESTIMATE="总经理评估";
	/**
	 * 绩效评估节点名称  员工确认/申诉
	 */
	public static final String EMPLOYEE_CONFIRM="员工确认/申诉";
	
	/**
	 * 投决和立项审批流程节点名称  项目经理审批
	 */
	public static final String PROJECT_MANAGER_APPROVE="项目经理审批";
	/**
	 * 投决和立项审批流程节点名称  部门主管审批
	 */
	public static final String DEPT_MANAGER_APPROVE="部门主管审批";
	/**
	 * 投决和立项审批流程节点名称  运营总监审批
	 */
	public static final String COMPANY_LEADER_APPROVE="运营总监审批";
	/**
	 * 判断是否是投委会办公室
	 */
	public static final String ROLE_INVEST_OFFICE="投委会办公室"; 
	/**
	 * 判断是否是运营部
	 */
	public static final String OPERATION_DEPARTMENT="运营部";
	/**
	 * 判断是否是投委会
	 */
	public static final String ROLE_INVEST="投委会"; 
	/**
	 * 判断是否是投委会
	 */
	public static final String ROLE_RISK_MANAGE_OFFICE="风控部"; 
	/**
	 * 判断是否是战略市场部
	 */
	public static final String MARKET_DEPT="战略市场部"; 
	/**
	 * 判断是否是部门主管
	 */
	public static final String DEPARTMENT_MANAGER="部门主管";
	/**
	 * 判断是否是公司领导
	 */
	public static final String COMPANY_LEADERSHIP="公司领导";
	/**
	 * 判断是否是总经理
	 */
	public static final String ROLE_SUPER_MAMAGER="总经理";
	/**
	 * 判断是否是领导秘书
	 */
	public static final String SECRETARY="领导秘书";
	/**
	 * 判断是否是公司合伙人
	 */
	public static final String COMPANY_PARTER="公司合伙人";
	/**
	 * 判断是否是公司高管
	 */
	public static final String COMPANY_MANAGER="公司高管";
	/**
	 * 判断是否是投资部领导
	 */
	public static final String DEPARTMENT_INVEST_MANAGER="投资部领导";
	
	/**
	 * 项目信息来源，基础参数数据键值
	 */
	public static final String PROJECT_SOURCE="所属行业";
	/**
	 * 投后管理部
	 */
	public static final String INVENT_MANAGE_DEPARTMENT="投后管理部";
	/**
	 * 投资研究部
	 */
	public static final String INVENT_STUDY_DEPARTMENT="投资研究部";
	/**
	 * 普罗财务部
	 */
	public static final String PRO_FINANCE_DEPARTMENT="普罗财务部";
	
	/**
	 * 项目信息类型，基础参数数据键值
	 */
	public static final String PROJECT_TYPE="项目类型";
	/**
	 * 报销申请，报销类型
	 */
	public static final String CLAIM_TYPE="报销类型";
	/**
	 * 差旅费用管理，费用内容和用途
	 */
	public static final String COST_TYPE="费用内容和用途";
	/**
	 * 项目成员角色项目经理
	 */
	public static final String PROJECT_TEAM_ROLE_MANAGER="0";
	/**
	 * 项目成员角色普通成员
	 */
	public static final String PROJECT_TEAM_ROLE_MEMBER="1";
	/**
	 * 立项预审成员
	 */
	public static final String TEAM_TYPE_PROJ_PRECHECK ="0";
	/**
	 * 投资决策预审成员
	 */
	public static final String TEAM_TYPE_INVEST_PRECHECK ="1";
	/**
	 * 项目组成员
	 */
	public static final String TEAM_TYPE_PROJ_TEAM ="2";
	/**
	 * 拟定等级类型，基础参数数据键值
	 */
	public static final String SECRET_LEVEL="拟定等级";
	/**
	 * 推荐意见类型，基础参数数据键值
	 */
	public static final String RECMD_ADVICE="推荐意见";
	/**
	 * 项目状态标识，基础参数数据键值
	 */
	public static final String PROJECT_STATUS="项目状态";
	/**
	 * 请求状态标识，基础参数数据键值
	 */
	public static final String REQUEST_STATUS="请求状态";
	
	/**
	 * 文件上传 一级业务类型
	 */
	public static final String DOC_LEVEL1_TYPE="一级文件类型";
	/**
	 * 文件上传 二级业务类型
	 */
	public static final String DOC_LEVEL2_TYPE="二级文件类型";
	/**
	 * 公司设立      业务类型
	 */
	public static final String BUSINESS_TYPE="业务类型";
	/**
	 * 公司设立      公司类型
	 */
	public static final String COMPANY_TYPE="公司类型";
	/**
	 * 请求标识，（0=申请，1=审批）
	 */
	public static final String REQUEST_FLAG_REQ="0";
	/**
	 * 请求标识，（0=申请，1=审批）
	 */
	public static final String REQUEST_FLAG_APPROVE="1";
	/**
	 * 操作日志，操作名称，项目信息
	 */
	public static final String LOG_NAME_PROJECT="项目信息";
	
	/**
	 * 操作日志，操作类型，保存
	 */
	public static final String LOG_TARGET_SAVE="新建";
	
	/**
	 * 操作日志，操作类型，修改
	 */
	public static final String LOG_TARGET_CHANGE="修改";
	/**
	 * 操作日志，操作类型，删除
	 */
	public static final String LOG_TARGET_DELETE="删除";
	/**
	 * 操作日志，操作类型，上传
	 */
	public static final String LOG_TARGET_UPLOAD="上传";
	/**
	 * 操作日志，操作类型，下载
	 */
	public static final String LOG_TARGET_DOWNLOAD="下载";
	
	/**
	 * 操作日志，操作结果，成功
	 */
	public static final String LOG_RESULT_SUCCESS="成功";
	/**
	 * 操作日志，操作结果，失败
	 */
	public static final String LOG_RESULT_FAILED="失败";
	
	/**
	 * 待审批（申请人保存申请，但未提交）
	 */
	public static final String COST_TYPE_PRE_APPROVE="待审批";
	/**
	 * 审批中  （提交审批之后，流程结束前）
	 */
	public static final String COST_TYPE_APPROVING="审批中";
	/**
	 * 已批准    （获得所有审批同意，流程结束）
	 */
	public static final String COST_TYPE_APPROVED="已批准";
	/**
	 * 已保存    （点击保存按钮后）
	 */
	public static final String COST_TYPE_SAVED="已保存";
	/**
	 * 待确认     (所有审批同意，进入报销阶段)
	 */
	public static final String COST_TYPE_CONFIRM="待确认";
	/**
	 * 待报销	(财务确认ok，进入发放阶段)
	 */
	public static final String COST_TYPE_ISSUE="待发放";
	/**
	 * 回款完成(非上海普罗公司报销流程结束)
	 */
	public static final String COST_TYPE_COMPLETE_PAY="完成";
	/**
	 * 已发放待转回(非上海普罗公司报销流程结束)
	 */
	public static final String COST_TYPE_WAITING_RETURN="待转回";
	/**
	 * 已报销   (上海普罗-所有流程结束)
	 */
	public static final String COST_TYPE_FINISH="已发放";
	
	/**
	 * 已拒绝    （批准领导拒绝申请，流程结束）
	 */
	public static final String COST_TYPE_REJECT="已拒绝";
	/**
	 * 已退回     （批准领导退回申请，由申请人重新填写内容，提交后，再次进入‘审批中’状态）
	 */
	public static final String COST_TYPE_BACK="已退回";
	/**
	 * 已取回   
	 */
	public static final String COST_TYPE_CALL_BACK="已取回";
	
	/**
	 * 查询公司  印章集合
	 */
	public static final String COMPANY_SEAL="印章类型";
	
	/**
	 * 月度评分申请类型
	 */
	//普通员工
	public static final Integer APPLY_SCORE_GENERAL=0;
	//vp
	public static final Integer APPLY_SCORE_VP=1;
	
	/**
	 * 绩效申请类型(个人、部门)
	 */
	//部门
	public static final Integer APPLY_PERFORM_DEPARTMENT = 1;
	//个人
	public static final Integer APPLY_PERFORM_PERSONAL = 0;
	
	/**
	 * 绩效目标类别
	 * 1.业务目标(发展类)
	 * 2.组织贡献，团体发展(收益类)
	 * 3.学习发展	(风险及管理类)
	 * 4.(合规类)
	 */
	public static final String PERFORM_TARGET_TYPE_1 = "BUSSINESS_TARGET";
	public static final String PERFORM_TARGET_TYPE_2 = "CONTRIBUTION";
	public static final String PERFORM_TARGET_TYPE_3 = "LEARNING_DEVELOPMENT";
	public static final String PERFORM_TARGET_TYPE_4 = "COMPLIANCE";
	
	/**
	 * 绩效目标类别
	 * 1.业务目标(发展类)0
	 * 2.组织贡献，团体发展(收益类)1
	 * 3.学习发展(风险及管理类)2
	 * 4.(合规类)3
	 */
	public static final Integer PERFORM_TARGET_TYPE_BUSSINESS_TARGET = 0;
	public static final Integer PERFORM_TARGET_TYPE_CONTRIBUTION = 1;
	public static final Integer PERFORM_TARGET_TYPE_LEARNING_DEVELOPMENT = 2;
	public static final Integer PERFORM_TARGET_TYPE_COMPLIANCE = 3;
	
	
	/**
	 * 绩效目标申请状态
	 */
	/**
	 * 新建
	 */
	public static final Integer TARGET_SAVE=0;//新建
	/**
	 * 待审批
	 */
	public static final Integer TARGET_SUBMIT=1;//待审批
	/**
	 * 审批通过 
	 */
	public static final Integer TARGET_OK=2;//审批通过
	/**
	 * 审批退回(拒绝)
	 */
	public static final Integer TARGET_REFUSE=3;//审批退回(拒绝)
	
	
	/**
	 * 绩效评估状态
	 */
	/**
	 * 保存新建
	 */
	public static final Integer EVALUATION_SAVE=0;//保存
	/**
	 * 处理中
	 */
	public static final Integer EVALUATION_SUBMIT=1;//待审批，处理中
	/**
	 * 处理完毕
	 */
	public static final Integer EVALUATION_OK=2;//处理完毕
	/**
	 * 退回
	 */
	public static final Integer EVALUATION_RETURN=3;//退回
	/**
	 * 员工申诉
	 */
	public static final Integer EVALUATION_APPEAL=4;//申诉
	
	
	/**
	 * 年
	 */
	public static final String YEAR = "年";
	
	/**
	 * 元
	 */
	public static final String YUAN = "(元)";
	
	/**
	 * 亿元
	 */
	public static final String BYUAN = "(亿元)";
	
	/**
	 * 流程状态
	 */
	
	/**
	 * 流程结束code-0
	 */
	public static final Integer WORK_FLOW_CODE_END = 0;
	/**
	 * 流程退回code-1
	 */
	public static final Integer WORK_FLOW_CODE_RETURN = 1;//
	/**
	 * 流程申请code-2
	 */
	public static final Integer WORK_FLOW_CODE_SUBMIT=2;
	/**
	 * 流程同意code-3
	 */
	public static final Integer WORK_FLOW_CODE_AGREE=3;//
	/**
	 * 流程重新提交code-4
	 */
	public static final Integer WORK_FLOW_CODE_SUBMIT_AGAIN=4;//
	
	/**
	 * 个人绩效评估
	 */
	public static final String GRJXPG = "个人绩效";
	/**
	 * 绩效评估数据状态-处理中
	 */
	public static final String HANDING = "处理中";
	
	/**
	 * 部门绩效评估
	 */
	public static final String BMJXPG ="部门绩效";
	
	/**
	 * Action-ajax返回页面状态 (1-成功,0-失败)
	 */
	/**
	 * ajax-返回成功
	 */
	public static final String MESSAGE_SUCCESS = "1";
	/**
	 * ajax-返回失败
	 */
	public static final String MESSAGE_FAIL = "0";
	
	/**
	 * 绩效流程code-jixiao
	 */
	public static final String PERFORM_CODE = "jixiao";
	
	/**
	 * 月度评分流程code-monthlyScore
	 */
	public static final String SCORE_CODE="monthlyScore";
	
	
	/**
	 * 请假流程code-takeLeave
	 */
	public static final String TAKE_LEAVE="takeLeave";
	/**
	 * 项目出资流程code-xmcz
	 */
	public static final String PROJECT_INVESTMENT_CODE = "xmcz";
	
	/**
	 * 新的项目出资流程code-projectchuzi
	 */
	public static final String PROJECT_CHUZI_CODE = "projectchuzi";
	
	
	/**
	 * 绩效申请如果没有直属领导，就先发给tomcat
	 */
	public static final Integer BOSS_ID = 1;//tomcat编号
	public static final String BOSS_NAME = "tomcat";
	
	/**
	 * 以下领导可以看到所有部门绩效
	 */
	public static final String[] members_dept = {"xuchenhao","luwei","shiderong","yaoyuan","lujun","wangzhe"};
	
	/**
	 * 以下人员可以看到所有历年和当年所有人的绩效
	 */
	public static final String[] members_personnal = {"yaoyuan","xuchenhao"};
	
	/**
	 * 运营部
	 */
	public static final String YYB = "运营部";
	/**
	 * 投后部
	 */
	public static final String THB = "投后管理部";
	/**
	 * 投研部
	 */
	public static final String TYB = "投资研究部";
	/**
	 * 风险控制部
	 */
	public static final String FKB = "风险控制部";
	/**
	 * 首席运营官
	 */
	public static final String SXYYG = "首席运营官";
	/**
	 * 副总裁
	 */
	public static final String FZC = "副总裁";
	
	/**
	 * 直属经理
	 */
	public static final String ZSJL = "直属经理";
	/**
	 * 财务总监
	 */
	public static final String CWZJ = "财务总监";
	/**
	 * 财务部门总监
	 */
	public static final String CWBMZJ = "财务部门总监";
	
	
	/**
	 * 投资一部
	 */
	public static final String TZYB = "投资一部";
	/**
	 * 投资二部
	 */
	public static final String TZRB = "投资二部";
	
	/**
	 * 领导
	 */
	public static final String GSLD = "公司领导";
	public static final String BMLD = "部门领导";
	
	/**
	 * 北京总部
	 */
	public static final String BJ_OFFICE="北京总部";
	/**
	 * 上海分部
	 */
	public static final String SH_OFFICE="上海分部";
	
	
	public static final String FOURPERSONWD = "(360度评估)";
	
	public static final String FOURPERSONESTIMATE= "360度评估人";
	
	public static final Integer ESTIMATETYPE_TARGET = 0;//目标评估区别_目标明细
	public static final Integer ESTIMATETYPE_EVAL = 1;//目标评估区别_评估明细
	
	public static final String OP_SAVE = "save";
	public static final String OP_SUBMIT = "submit";
//	public static final String LEADERWD = "(领导评估)";

	public static final String FLOWTYPE_INITIATE="initiateProject";
	public static final String FLOWNAME_INITIATE="项目立项申请";
	public static final String FLOWTYPE_INVESTMENT="investmentDecisionProcess";
	public static final String FLOWNAME_INVESTMENT="项目投决申请";

	
	
	/**
	 * 项目出资
	 */
	public static final String PI_PAGE_TYPE_APPLY="0";//申请页面
	public static final String PI_PAGE_TYPE_APPROVE="1";//审批页面
	public static final String PI_PAGE_TYPE_VIEW="2";//查看页面

	/**
	 * 公司设立
	 */
	public static final String COMPANY_ADMIN="公司管理员";

	
	/**
	 * 项目出资/(公司付款)/设立状态
	 */
	/**
	 * 拒绝
	 */
	public static final Integer REFUSE=0;//拒绝
	/**
	 * 待审批
	 */
	public static final Integer SUBMIT=1;//待审批
	/**
	 * 审批通过
	 */
	public static final Integer OK=2;//审批通过
	/**
	 * 审批退回
	 */
	public static final Integer BACK=3;//审批退回
	
	/**
	 * 新项目出资状态/(公司付款)
	 * 0拒绝1退回3同意4重新申请5完成
	 */
	public static final Integer CHUZI_REFUSE=0;//拒绝
	public static final Integer CHUZI_SUBMIT=3;//待审批
	public static final Integer CHUZI_FISNISH=5;//流程结束
	public static final Integer CHUZI_BACK=1;//退回
	//public static final Integer CHUZI_REAPPLY=4;//重新申请
	
	
	/**
	 * 流程处理类型:
	 * 0:用章
	 * 1:签报
	 * 3:绩效目标
	 * 5:绩效评估
	 * 6:项目出资
	 * 7:公司设立
	 * 8:通用签报
	 * 9:月度绩效
	 * 10:请假流程
	 */
	
	public static final Integer BUSSINESS_TYPE_YZ = 0;
	public static final Integer BUSSINESS_TYPE_QB = 1;
	public static final Integer BUSSINESS_TYPE_JXMB = 3;
	public static final Integer BUSSINESS_TYPE_JXPG = 5;
	public static final Integer BUSSINESS_TYPE_XMCZ = 6;
	public static final Integer BUSSINESS_TYPE_NXMCZ = 66;//新项目出资
	public static final Integer BUSSINESS_TYPE_GSSL = 7;
	public static final Integer BUSSINESS_TYPE_TYQB = 8;//通用签报
	public static final Integer BUSSINESS_TYPE_YDPF = 9;//月度绩效
	public static final Integer BUSSINESS_TYPE_QJLC = 10;//请假流程
	public static final Integer BUSSINESS_TYPE_GSFK = 11;//公司付款
	
	
	/**
	 * 附件上传类型
	 * 0:用章
	 * 1:签报
	 * 2:项目出资
	 * 3:公司设立
	 */
	public static final Integer ATTARCHMENT_YZ = 0;//用章
	public static final Integer ATTARCHMENT_QB = 1;//签报
	public static final Integer ATTARCHMENT_XMCZ = 6;
	public static final Integer ATTARCHMENT_NXMCZ = 66;//新项目出资
	public static final Integer ATTARCHMENT_GSSL = 7;//公司设立
	public static final Integer ATTARCHMENT_TYQB = 8;//通用签报
	public static final Integer ATTARCHMENT_QJSQ = 9;//请假申请
	public static final Integer ATTARCHMENT_GSFK = 11;//公司付款
	
	/**
	 * 公司设立流程各节点名称
	 * 
	 */
	public static final String PROJECT_MANAGER = "项目经理审批";//项目经理审批
	public static final String DEPT_MANAGER = "部门负责人审批";//部门负责人审批
	public static final String COMPANY_MANAGER_APPROVE = "公司管理员审批";
	public static final String MARKET_DEPT_MANAGER = "战略市场部负责人审批";
	public static final String RISK_DEPT_MANAGER = "风险控制部负责人审批";
	public static final String COMPANY_FOUND_LEADER_APPROVE = "上海普罗首席运营官审批";
	public static final String LEGAL_PERSON_APPROVE = "法定代表人审批";
	public static final String LEGAL_PERSON = "法定代表人";
	public static final String INVESTMENT_LEGAL_PERSON = "出资单位法人/执行合伙人";
	public static final String INVESTMENT_LEGAL_PERSON_APPROVE = "出资单位法人/执行合伙人审批";
	public static final String FINANCIAL_MANAGER = "财务管理员";
	public static final String FINANCIAL_MANAGER_APPROVE = "财务管理员确认";
	public static final String FINANCIAL_MANAGER_PROVIDE = "财务管理员发放";
	public static final String SIGNDEPARTMENT_SIGN = "会签部门会签";
	public static final String FINANCIAL_CONTROLLER_APPROVE = "财务总监审批";
    public static final String GENERAL_MANAGER_APPROVE = "总经理审批";
    public static final String CHIEF_OPERATING_APPROVE = "首席运营官审批";
    
    
    /**
	 * 项目出资流程各节点名称
	 * 
	 */
	public static final String XMCZ_PROJECT_MANAGER = "项目经理审批";
	public static final String XMCZ_DEPT_MANAGER = "部门负责人审批";
	public static final String XMCZ_MARKET_DEPT_MANAGER = "战略部负责人审批";
	public static final String XMCZ_RISK_DEPT_MANAGER = "风控部负责人审批";
	public static final String XMCZ_FINANCIAL_MANAGER = "财务管理员";
	public static final String XMCZ_FINANCIAL_MANAGER_APPROVE = "出资公司财务管理员审批";
	public static final String XMCZ_FINANCIAL_MANAGER_PROVIDE = "财务部发放";
	public static final String XMCZ_FINANCIAL_CONTROLLER_APPROVE = "财务部总监审批";
    public static final String XMCZ_CHIEF_OPERATING_APPROVE = "首席运营官审批";
    /**
     * project step number means
     */
    public static final String stepL1="-1"; //我的待办
    public static final String step0 = "0"; //修改项目信息
    public static final String step1 = "1"; //项目入项申请
    public static final String step2 = "2"; //项目入库审批
    public static final String step3 = "3"; //项目秘密变更申请/项目立项申请
    public static final String step4 = "4"; //
    public static final String step5 = "5"; //项目秘密变更审核
    public static final String step6 = "6"; //
    public static final String step7 = "7";
    public static final String step8 = "8"; //立项材料审批
    public static final String step9 = "9"; //预审意见
    public static final String step10 = "10"; //
    public static final String step11 = "11"; //审意表决
    public static final String step12 = "12"; //
    public static final String step13 = "13";
    public static final String step14 = "14";
    public static final String step15 = "15"; //投决申请
    public static final String step16 = "16"; //复议申请
    public static final String step17 = "17";
    public static final String step18 = "18"; //投决材料审核
    public static final String step19 = "19"; //预审意见反馈
    public static final String step20 = "20";
    public static final String step21 = "21"; //投资决策审议表决
    public static final String step22 = "22";
    public static final String step23 = "23"; //投资协议变更申请/签署投资协议的请示
    public static final String step24 = "24"; //申请复议
    public static final String step25 = "25";
    public static final String step26 = "26"; //投资协议变更审议
    public static final String step27 = "27"; 
    public static final String step28 = "28";
    public static final String step29 = "29"; //签署投资协议的批示
    public static final String step30 = "30"; //签署投资协议申请驳回
    public static final String step31 = "31"; //出资请示
    public static final String step32 = "32"; //出资请示审批
    public static final String step33 = "33"; //出资请示驳回
    public static final String step34 = "34"; //上传框架协议
    
    
    public static final String STR_XMCZ = "项目出资";//项目出资
    public static final String STR_ZTCZ = "主体出资";//主体出资
    public static final String STR_GLRCZ = "管理人出资";//管理人出资
    
    
    //月度评分人角色
    public static final String MONTHSCORE_ADMIN = "月度评分管理员";
    public static final String MONTHSCORE_TASKAPPROVER = "月度评分任务审核人";
    public static final String MONTHSCORE_FIRSTAPPROVER = "月度评分第一审核人";
    public static final String MONTHSCORE_TOTALAPPROVER = "月度评分总审核人";
    public static final String MONTHSCORE_APPLIER = "月度评分申请人";
    
    public static final String OFFICE_LOCATION_SH = "上海";
    
    //报销费用类型（公司支付）
    public static final String CLAIM_TRAIN_TICKET_TYPE_COMPANY = "火车票（公司支付）";
    public static final String CLAIM_AIRCRAFT_TICKET_TYPE_COMPANY = "机票（公司支付）";
    
    
    //上海普罗股权投资管理合伙企业（有限合伙）
    public static final String GKRH_SH_PL_COM = "上海普罗股权投资管理合伙企业（有限合伙）";
    
    //人民币(圆)
    public static final String YUAN_BIG = "圆";
    
    //人民币(零圆)
    public static final String ZERO_YUAN_BIG = "零圆";
    
}
