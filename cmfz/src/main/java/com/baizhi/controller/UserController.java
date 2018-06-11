package com.baizhi.controller;


import com.baizhi.entity.User;
import com.baizhi.service.MenuService;
import com.baizhi.service.UserService;
import com.baizhi.util.CreateValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/28.
 */
@Controller
@RequestMapping("/cmfz")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;


    /*   验 证码图片  */
    @RequestMapping("/image")
    public void iamge(HttpServletResponse response , HttpServletRequest request) throws IOException {

        CreateValidateCode createCode = new CreateValidateCode();
        HttpSession session = request.getSession() ;
        String code = createCode.getCode();
        session.setAttribute("code", code);

        ServletOutputStream writer = response.getOutputStream();
        createCode.write(writer);
    }

   /* ajax判断 验证码 */
   @RequestMapping(value="checkCode")
   public void checkName(String code ,HttpServletResponse response ,HttpSession session) throws IOException{
       response.setCharacterEncoding("UTF-8");
       String  target1 = (String) session.getAttribute("code");
       String target = target1.toUpperCase();

        String code1 = code.toUpperCase();
       PrintWriter writer = response.getWriter();
       if(target.equals(code1)){
           writer.print("√");
       }else{
           writer.print("X");
       }
       writer.flush();
   }
  /*         用户登录                */
  @RequestMapping(value="login")
  public String login(User user){

      Map<String, Object> map = userService.login(user);
      User user1 = (User) map.get("OK");

      if(user1==null){

          return "redirect:/login.jsp";
          //  没有用户信息

      }else{
          //用户存在
          System.out.println(user1);
          return "redirect:/main/main.jsp";
      }


  }



}
