package com.example.app.service.imp;

import com.example.app.cmd.dao.UserDao;
import com.example.app.cmd.model.Templet;
import com.example.app.cmd.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import java.text.SimpleDateFormat;

@Service("userService")
public class UserServiceImpl {
    // 日期格式定义
    private final SimpleDateFormat dateFormat	= new SimpleDateFormat("MMddHHmmss");

    @Autowired
    UserDao userDao;
    @PersistenceContext
//	private EntityManager entityManager;


    public Users findUser(String name){
        return userDao.findByName(name);
    }

    /**
     * 用户注册
     * 1、获取用户的手机号码
     * 2、通过第三方获取手机号码的验证信息
     * 3、保存用户的信息
     * APIID：C08248384
     * APIKEY：97bae7439e1d7b59fae488a911b3eede
     * @param phone
     * @param templet
     */
    public void getUserRegister(String phone, Templet templet) {
//		if(templet==null){
//			return;
//		}
//		//自动生成4位编码
//		String code = Integer.toString((int)(Math.random() * 9000 + 1000));
//		String[] content =templet.getContent().split("\\^");
//		String msg = content[0]+""+code+""+content[1];
//		String userid = templet.getUserId();
//		String pwd = templet.getPassword();
//		String masterIpAddress=templet.getIpAddress();
//		Users u = findUser(phone);
//		//设置IP
//		ConfigManager.setIpInfo(masterIpAddress, null, null, null);
//		//密码是否加密   true：密码加密;false：密码不加密
//		ConfigManager.IS_ENCRYPT_PWD=true;
//		boolean isEncryptPwd=ConfigManager.IS_ENCRYPT_PWD;
//		try{
//			// 参数类
//			Message message = new Message();
//			// 实例化短信处理对象
//			CHttpPost cHttpPost = new CHttpPost();
//
//			// 设置账号   将 userid转成大写,以防大小写不一致
//			message.setUserid(userid.toUpperCase());
//
//			//判断密码是否加密。
//			//密码加密，则对密码进行加密
//			if(isEncryptPwd)
//			{
//				// 设置时间戳
//				String timestamp = dateFormat.format(Calendar.getInstance().getTime());
//				message.setTimestamp(timestamp);
//
//				// 对密码进行加密
//				String encryptPwd = cHttpPost.encryptPwd(message.getUserid(),pwd, message.getTimestamp());
//				// 设置加密后的密码
//				message.setPwd(encryptPwd);
//
//			}else {
//				message.setPwd(pwd);
//			}
//			// 设置手机号码 此处只能设置一个手机号码
//			message.setMobile(phone);
//			// 设置内容
//			message.setContent(msg);
//			// 设置扩展号
//			message.setExno("11");
//			// 返回的平台流水编号等信息
//			StringBuffer msgId = new StringBuffer();
//			// 返回值
//			int result = -310099;
//			// 发送短信
//			result = cHttpPost.singleSend(message, msgId);
//			// result为0:成功;非0:失败
//			if(result == 0){
//				System.out.println("短信发送提交成功！");
//				if(u==null){
//					Users user = new Users();
//					user.setId(UUID.randomUUID().toString());
//					user.setName(phone);
//					user.setPhone(phone);
//					user.setCode(code);
//					user.setCountNum(1);
//					userDao.add(user);
//				}else{
//					u.setCode(code);
//					u.setCountNum(u.getCountNum()+1);
//					userDao.add(u);
//				}
//			}else{
//				System.out.println("短信发送失败！"+result);
//			}
//		}
//		catch (Exception e){
//			e.printStackTrace();
//		}
    }

    /**
     * 验证码校验
     * 验证码的计时60秒，time 不小于60，返回验证码无效
     * @param phone
     * @param code
     */
    public String checkIdentifyingCode(String phone, String code, int time ) {
        Users user = findUser(phone);
//		String uCode = user.getCode();
        String tag = "";
//		if(time < 60){
//			if(uCode.equals(code)){
//				tag = "0";
//			}else{
//				tag="1";
//			}
//		}else{
//			tag ="2";
//		}
        return tag;
    }

    /**
     * 统计用户使次数
     * 保证用户已经存在，才可以使用
     * @param phone
     * @return
     */
    public void countUser(String phone) {
//		Users user = findUser(phone);
//		if(user != null){
//			int num = user.getCountNum() + 1;
//			user.setCountNum(num);
//			//更新用户的访问次数
//			userDao.update(user);
//		}
    }

//	public Page<Users> getUserPage(int page, int rows) {
//		Sort sort = new Sort(Sort.Direction.DESC,"createTime"); //创建时间降序排序
//		Pageable pageable = new PageRequest(page-1, rows);
//		Page<Users> pages = userDao.findAll(pageable);
//		return pages;
//	}

    public String findUserById(String s) {
//		String userId="58ad413d-36e6-11e8-9141-14dae9ccffb3";
//		Users user = userDao.selectByUserId(userId);
//		return user;
        return "哈哈哈"+s;
    }
}
