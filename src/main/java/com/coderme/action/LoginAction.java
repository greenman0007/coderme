package com.coderme.action;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.coderme.bean.Article;
import com.coderme.bean.User;
import com.coderme.core.util.VerifyCodeUtil;
import com.coderme.service.ArticleService;
import com.coderme.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginAction {

	@Resource
	private ArticleService articleService;
	@Resource
    private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        return "login";
    }
	@RequestMapping(method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute User user,HttpServletRequest request, HttpServletResponse response) {
		String resultPageURL = InternalResourceViewResolver.FORWARD_URL_PREFIX + "/";  
        String username = request.getParameter("userName");  
        String password = request.getParameter("passWord");  
        //获取HttpSession中的验证码  
        String verifyCode = (String)request.getSession().getAttribute("verifyCode");  
        //获取用户请求表单中输入的验证码  
        String submitCode = WebUtils.getCleanParam(request, "verifyCode");  
        System.out.println("用户[" + username + "]登录时输入的验证码为[" + submitCode + "],HttpSession中的验证码为[" + verifyCode + "]");  
        if (StringUtils.isEmpty(submitCode) || !StringUtils.equals(verifyCode, submitCode.toLowerCase())){  
            request.setAttribute("errorMsg", "验证码不正确");  
            return "login";  
        }  
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);  
        token.setRememberMe(true);  
        System.out.println("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));  
        //获取当前的Subject  
        Subject currentUser = SecurityUtils.getSubject();  
        try {  
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查  
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应  
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法  
            System.out.println("对用户[" + username + "]进行登录验证..验证开始");  
            currentUser.login(token);  
            System.out.println("对用户[" + username + "]进行登录验证..验证通过");  
            resultPageURL = "mainPage";  
        }catch(UnknownAccountException uae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,未知账户");  
            request.setAttribute("msg", "未知账户");  
            resultPageURL = "login";
        }catch(IncorrectCredentialsException ice){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");  
            request.setAttribute("msg", "密码不正确");  
            resultPageURL = "login";
        }catch(LockedAccountException lae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");  
            request.setAttribute("msg", "账户已锁定");  
            resultPageURL = "login";
        }catch(ExcessiveAttemptsException eae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");  
            request.setAttribute("msg", "用户名或密码错误次数过多");  
            resultPageURL = "login";
        }catch(AuthenticationException ae){  
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");  
            ae.printStackTrace();  
            request.setAttribute("msg", "用户名或密码不正确");  
            resultPageURL = "login";
        }  
        //验证是否登录成功  
        if(currentUser.isAuthenticated()){  
            System.out.println("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");  
        }else{  
            token.clear();  
        }  
        List<Article> texts = new ArrayList<Article>();
		try {
			texts = articleService.findAllArticle();
		} catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
		}
        model.addAttribute("userName", username);
        model.addAttribute("textList", texts);
        return resultPageURL;  
	}
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logout(Model model) {
		//获取当前的Subject  
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();

        List<Article> texts = new ArrayList<Article>();
		try {
			texts = articleService.findAllArticle();
		} catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
		}
		System.out.println(texts);
		
		model.addAttribute("textList", texts);
		return "mainPage";
	}
	
	
	
	@RequestMapping(value="/void" ,method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute User user, HttpServletResponse response) {
		User user1 = userService.findByName(user.getUserName());
		if (null == user1) {
			model.addAttribute("msg", "用户名不存在！请注册！");
			return "register";
		} else if (!user.getPassWord().equals(user1.getPassWord())) {
			model.addAttribute("msg", "密码不正确！请重试！");
			return "login";
		} else {
			System.out.println("success");
			
			List<Article> texts = null;
			try {
				texts = articleService.findAllArticle();
			} catch (Exception e) {
				model.addAttribute("errorMsg", e.getMessage());
			}
			System.out.println(texts);
			
			String username = null; 
		    Object principal = SecurityContextHolder.getContext() 
		        .getAuthentication().getPrincipal(); 
		    Object credential = SecurityContextHolder.getContext() 
	        .getAuthentication().getCredentials();
		    if (principal instanceof UserDetails) { 
		        username = ((UserDetails) principal).getUsername(); 
		    } else { 
		        username = principal.toString(); 
		    } 
		    
		    System.out.println("userName:"+username);
		    System.out.println("credential:"+credential);
		    model.addAttribute("userName", username);
			model.addAttribute("textList", texts);
			return "mainPage";
		}
	}
}
