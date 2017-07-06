package com.ggsleeper.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;





import javax.print.PrintException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.ggsleeper.bean.CarApply;
import com.ggsleeper.bean.CarInfo;
import com.ggsleeper.bean.DriverInfo;
import com.ggsleeper.bean.Privilege;
import com.ggsleeper.bean.Role;
import com.ggsleeper.bean.RolePrivilege;
import com.ggsleeper.bean.User;
import com.ggsleeper.service.CarApplyService;
import com.ggsleeper.service.CarInfoService;
import com.ggsleeper.service.DriverInfoService;
import com.ggsleeper.service.PrivilegeService;
import com.ggsleeper.service.RolePrivilegeService;
import com.ggsleeper.service.RoleService;
import com.ggsleeper.service.UserRolesService;
import com.ggsleeper.service.UserService;
import com.ggsleeper.util.Constants;
import com.ggsleeper.util.PageCounterUtil;
import com.opensymphony.xwork2.ActionContext;

public class UserAction extends PageCounterUtil {

	private static final Logger log = Logger.getLogger(UserAction.class);

	UserService userService;
	UserRolesService userRolesService;
	RoleService roleService;
	RolePrivilegeService rolePrivilegeService;
	PrivilegeService privilegeService;

	CarApplyService CarApplyService;
	private CarApply carApply;
	private List<CarApply> CarApplyList;

	DriverInfoService driverInfoService;
	private DriverInfo driverInfo;
	private List<DriverInfo> driverInfoList;

	ActionContext cxt=ActionContext.getContext();
	HttpServletRequest request=(HttpServletRequest) cxt.get(ServletActionContext.HTTP_REQUEST);


	private List<User> userList = new ArrayList<User>();
	private List<RolePrivilege> rolePriList = new ArrayList<RolePrivilege>();
	private Set<String> rolePriSet = new HashSet<String>();
	private String loginTips = ""; // 登录错误提示
	

	// 待办任务个数
	int TASK_NUM = 0;
	// 判断角色
	String DRIVER_NOTICE = "";
	// 判断角色
	String roleStr;
	private User user;

	public String login() {
		try {
			userList = userService.findByHQL("from User where loginName='"
					+ user.getLoginName() + "' and userPasswd='"
					+ user.getUserPasswd() + "'");
			// 初始化user
			user = new User();
			// 初始化rolePriset
			if (null != rolePriSet) {
				rolePriSet.clear();
			}
			if (userList != null && userList.size() == 1) {
				// 将登录人信息存入话
				getSession().put(Constants.USER_SESSION, userList.get(0));
				// 根据userId查找角色
				List<Role> roleList = roleService.findByProperty("roleId",
						userList.get(0).getUserId());
				// 根据roleId查询并遍历角色权限,获取角色权限
				StringBuffer priStr = new StringBuffer();
				for (int i = 0; i < roleList.size(); i++) {
					String sql = " select * from tbl_privilege where PRI_ID in (select PRI_ID from tbl_role_privilege where ROLE_ID ="
							+ roleList.get(i).getRoleId() + ")";
					List<Privilege> PR = privilegeService.findBySql(sql);

					for (int j = 0; j < PR.size(); j++) {
						if (PR != null) {
							// 0-15对应菜单的选项卡
							priStr.append(String.valueOf(PR.get(j).getPriId())
									+ ",");

						}
					}
				}
				String str = priStr.substring(0, priStr.length() - 1);
				// 把rolePriSet放入session
				getSession().put("ROLE_PRIVILEGE_SETTING", str);
				// 查询角色
				List<Role> roles = roleService
						.findByHQL("from Role where roleId="
								+ userList.get(0).getUserId());
				roleStr = roles.get(0).getRoleName();
				if (roles != null && roles.size() > 0) {
					// 角色放入session
					getSession().put(Constants.USER_SESSION_ROLE, roles);
					for (Role ur : roles) {
						log.info("拥有角色:" + ur.getRoleName());
					}
				}
				// 待办任务提醒

				if (roleStr.equals("职员")) {
					TASK_NUM = 0;
					getSession().put("TASK_NUM", TASK_NUM);
					getSession().put("DRIVER_NOTICE", DRIVER_NOTICE);
				}
				if (roleStr.equals("系统管理员")) {
					CarApplyList = null;
					List<CarApply> carApplyList2 = CarApplyService
							.findByProperty("state", "审核中");
					CarApplyList = CarApplyService.findByProperty("state",
							"待审核");
					CarApplyList.addAll(carApplyList2);
					TASK_NUM = CarApplyList.size();
					getSession().put("TASK_NUM", TASK_NUM);
					getSession().put("DRIVER_NOTICE", DRIVER_NOTICE);
				}
				if (roleStr.equals("公司领导")) {
					CarApplyList = null;
					List<CarApply> carApplyList2 = CarApplyService
							.findByProperty("state", "审核中");
					CarApplyList = CarApplyService.findByProperty("state",
							"待审核");
					CarApplyList.addAll(carApplyList2);
					TASK_NUM = CarApplyList.size();
					getSession().put("TASK_NUM", TASK_NUM);
					getSession().put("DRIVER_NOTICE", DRIVER_NOTICE);
				}
				if (roleStr.equals("部门领导")) {
					CarApplyList = null;
					CarApplyList = CarApplyService.findByProperty("state",
							"待审核");
					TASK_NUM = CarApplyList.size();
					getSession().put("TASK_NUM", TASK_NUM);
					getSession().put("DRIVER_NOTICE", DRIVER_NOTICE);
				}
				if (roleStr.equals("驾驶员")) {
					User user = (User) getSession().get(Constants.USER_SESSION);
					driverInfo = driverInfoService.findByProperty("driverName",
							user.getName()).get(0);
					DRIVER_NOTICE = driverInfo.getDriverNotice();
					getSession().put("DRIVER_NOTICE", DRIVER_NOTICE);
					TASK_NUM = 0;
					getSession().put("TASK_NUM", TASK_NUM);
				}

				loginTips = "";
				userList.clear();
				getSession().put(Constants.USER_SESSION_PAGE_SIZE, 10);
				return "success";
			}
			loginTips = "<script>art.dialog({" + "title: '提示',"
					+ "content: '用户名或密码错误'," + "icon: 'succeed',"
					+ "ok: function(){return true;}});</script>";
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		finally{
			request.setAttribute("loginTips", loginTips);
		}
		return "input";
	}

	// 修改密码
	public String resetPassword() {
		
		
		User userCurrent = (User) getSession().get(Constants.USER_SESSION);
		/*
		 * List <User> userList =
		 * userService.findByHQL("from User where loginName='" +
		 * user.getLoginName() + "' and userPasswd='" + user.getUserPasswd() +
		 * "'");
		 * 
		 * user=userList.get(0);
		 */
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword1");
		String newPassword2 = request.getParameter("newPassword2");
		if (newPassword.equals(newPassword2)
				&& password.equals(userCurrent.getUserPasswd())) {
			userCurrent.setUserPasswd(newPassword);
			boolean flag = false;
			flag = userService.update(userCurrent);
			
			if (flag){
				return "success";
			}	
			
		}
		return "input";

	}
	//忘记密码
	public String forgetPassword(){
		String loginName=request.getParameter("loginNameForget");
		String issue=request.getParameter("issueForget");
		String newPassword=	request.getParameter("newPassword1Forget");
		String newPassword2=request.getParameter("newPassword2Forget");
		List <User>	userList = userService.findByProperty("loginName", loginName);
		User forgetUser=userList.get(0);
		System.out.println(forgetUser.getUserPasswd()+forgetUser.getUserIssue());
		if(forgetUser.getUserIssue().equals(issue)&&newPassword.equals(newPassword2)){
			forgetUser.setUserPasswd(newPassword);
			boolean flag=false;
			flag=userService.update(forgetUser);
			if(flag)
			return "success";
		}
		return "input";
	}

	/*
	 * // showMenu() public void showMenu(){ if (null != rolePriSet) {
	 * rolePriSet.clear(); } User users =
	 * (User)getSession().get(Constants.USER_SESSION);
	 * 
	 * if(users!=null){ List<Role> userRole
	 * =roleService.findByProperty("USER_ID",users.getUserId()); for (int i = 0;
	 * i < userRole.size(); i++) { if(userRole!=null&&userRole.size()>0){
	 * if(userRole.get(i)!=null){ rolePriList =
	 * rolePrivilegeService.findByProperty("ROLE_ID",
	 * userRole.get(i).getRoleId()); } } for (int j = 0; j < rolePriList.size();
	 * j++) { Privilege pr=rolePriList.get(j).getPrivilege(); if(pr!=null){
	 * rolePriSet.add(String.valueOf(pr.getPriId())); } } } }
	 */
	// log.info("----菜单刷新-----");
	// log.info("用户："+users.getLoginName());
	// for(String menuId:rolePriSet){
	// log.info("拥有菜单编号:"+menuId);
	// }
	/*
	 * try { HttpServletResponse response = getResponse();
	 * response.setCharacterEncoding("utf-8");
	 * response.setContentType("text/html");
	 * response.getWriter().write(rolePriSet.toString()); } catch (IOException
	 * e) { log.error(e); } getSession().put("ROLE_PRIVILEGE_SETTING",
	 * rolePriSet);
	 */
	/* } */

	/**
	 * 注销
	 */
	/*
	 * public void logout() { try { getSession().remove(Constants.USER_SESSION);
	 * getSession().remove(Constants.USER_SESSION_ROLE);
	 * getSession().remove("PARENT_MENU"); getSession().remove("CURRENT_MENU");
	 * HttpServletResponse response = getResponse();
	 * response.setCharacterEncoding("GBK");
	 * response.setContentType("text/html"); response.getWriter().write("ok"); }
	 * catch (IOException e) { log.error(e); } }
	 */

	// 判断是否为系统管理员或公司领导
	@SuppressWarnings("unchecked")
	/*
	 * public boolean checkAdmin() { boolean isAdmin = false; List<Role> roles =
	 * (List<Role>) getSession().get( Constants.USER_SESSION_ROLE); if (roles !=
	 * null) { for (Role ur : roles) { if
	 * (Constants.USER_ADMIN.equals(ur.getRoleName()) ||
	 * Constants.GSLD.equals(ur.getRoleName())) { isAdmin = true; break; } } }
	 * return isAdmin; }
	 */
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserRolesService getUserRolesService() {
		return userRolesService;
	}

	public void setUserRolesService(UserRolesService userRolesService) {
		this.userRolesService = userRolesService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public RolePrivilegeService getRolePrivilegeService() {
		return rolePrivilegeService;
	}

	public void setRolePrivilegeService(
			RolePrivilegeService rolePrivilegeService) {
		this.rolePrivilegeService = rolePrivilegeService;
	}

	public PrivilegeService getPrivilegeService() {
		return privilegeService;
	}

	public void setPrivilegeService(PrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<RolePrivilege> getRolePriList() {
		return rolePriList;
	}

	public void setRolePriList(List<RolePrivilege> rolePriList) {
		this.rolePriList = rolePriList;
	}

	public Set<String> getRolePriSet() {
		return rolePriSet;
	}

	public void setRolePriSet(Set<String> rolePriSet) {
		this.rolePriSet = rolePriSet;
	}

	public CarApplyService getCarApplyService() {
		return CarApplyService;
	}

	public void setCarApplyService(CarApplyService carApplyService) {
		CarApplyService = carApplyService;
	}

	public CarApply getCarApply() {
		return carApply;
	}

	public void setCarApply(CarApply carApply) {
		this.carApply = carApply;
	}

	public List<CarApply> getCarApplyList() {
		return CarApplyList;
	}

	public void setCarApplyList(List<CarApply> carApplyList) {
		CarApplyList = carApplyList;
	}

	public DriverInfoService getDriverInfoService() {
		return driverInfoService;
	}

	public void setDriverInfoService(DriverInfoService driverInfoService) {
		this.driverInfoService = driverInfoService;
	}

	public DriverInfo getDriverInfo() {
		return driverInfo;
	}

	public void setDriverInfo(DriverInfo driverInfo) {
		this.driverInfo = driverInfo;
	}

	public List<DriverInfo> getDriverInfoList() {
		return driverInfoList;
	}

	public void setDriverInfoList(List<DriverInfo> driverInfoList) {
		this.driverInfoList = driverInfoList;
	}
	public String getLoginTips() {
		return loginTips;
	}

	public void setLoginTips(String loginTips) {
		this.loginTips = loginTips;
	}

}
