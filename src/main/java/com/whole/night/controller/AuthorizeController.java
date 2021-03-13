package com.whole.night.controller;

import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import com.whole.night.entity.User;
import com.whole.night.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/*第三方登陆授权*/
@Controller
@RequestMapping("/authorize")
public class AuthorizeController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/qq")  //qq登陆访问路径
    public void toLogin(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        try {
            response.sendRedirect(new Oauth().getAuthorizeURL(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/qcb")    //qqCallback回调方法
    public String loginBack(HttpServletRequest request, HttpServletResponse response , HttpSession session) {
        response.setContentType("text/html; charset=utf-8");
        String queryString = request.getQueryString();
        String[] state = queryString.split("state=");
        request.getSession().setAttribute("qq_connect_state",state[1]);
        try {
            PrintWriter out = response.getWriter();
            AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
            String accessToken = null,
                    openID = null;
            long tokenExpireIn = 0L;
            if (accessTokenObj.getAccessToken().equals("")) {
                System.out.println("没有获取到响应参数");
                return "error";
            } else {
                User currentUser = new User();
                accessToken = accessTokenObj.getAccessToken();
                tokenExpireIn = accessTokenObj.getExpireIn();

                OpenID openIDObj = new OpenID(accessToken);
                openID = openIDObj.getUserOpenID();
                currentUser.setOpenid(openID);

                UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
                UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
                if (userInfoBean.getRet() == 0) {
                    currentUser.setGender(userInfoBean.getGender());
                    currentUser.setNick(userInfoBean.getNickname());
                    currentUser.setAvatar(userInfoBean.getAvatar().getAvatarURL100());
                    session.setAttribute("user",currentUser);
                    return "redirect:/";
                } else {
                    System.out.println("获取信息失败"+userInfoBean.getMsg());
                    return "error";
                }
            }
        } catch (Exception e) {
        }
        return "error";
    }

}
