package com.example.demo.controller;

import com.example.demo.Service.*;
import com.example.demo.bean.Announcement;
import com.example.demo.bean.Course;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private CommentService commentService;
    @Resource
    private PaymentService paymentService;
    @Resource
    private CourseService courseService;
    @Resource
    private Course_userService courseUserService;
    @Resource private AnnouncementService announcementService;
    @Resource private FacilityUseService facilityUseService;
    @Resource private FacilityService facilityService;
    int UID;

    @PostMapping("/reg")
    public String user_reg(@RequestParam("Email") String email,
                             @RequestParam("Name") String Name,
                             @RequestParam("Birthday") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date birthday,
                             @RequestParam("Gender") String gender,
                             @RequestParam("Phone_number") int phone_num){
       int i = userService.registerByEmail(email, Name, birthday, gender, phone_num);
       if (i == 1){
           return "redirect:/index.html";
       }
       return null;
    }
    //@ResponseBody
    @PostMapping("/login")
    public String user_login(@RequestParam("Email") String email, HttpSession Session) throws SQLException {
        UID = userService.loginByEmail(email).intValue();
        return "redirect:/home.html";
    }

    @PostMapping("/modify")
    public String user_modify(@RequestParam("Email") String email,
                              @RequestParam("Name") String Name,
                              @RequestParam("Birthday") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date birthday,
                              @RequestParam("Gender") String gender,
                              @RequestParam("Phone_number") int phone_num
    ){
        int i  = userService.updateByUID(UID,email,Name,birthday,gender,phone_num);
        if (i == 1){
            return "redirect:/success.html";
        }
        return null;
    }


    @PostMapping("/comments")
    public String comments (@RequestParam("Content") String content){
        int i = commentService.leaveComment(UID,content);
        if (i == 1){
            return "redirect:/success.html";
        }
        return null;
    }

    @ResponseBody
    @GetMapping("/getComments")
    public List<String> get_comments(){
        return commentService.seeAllComments();
    }


    @PostMapping("/makePayment")
    public String make_payment(@RequestParam("Purpose") String Purpose,
                            @RequestParam("Amount")int Amount){
        int i = paymentService.makePayment(Purpose,UID,Amount);
        if (i == 1){
            return "redirect:/success.html";
        }
        return null;
    }
    @ResponseBody
    @GetMapping("/getAllCourse")
    public List<Course> allCourse(){
        return courseService.getAllCourse();
    }

    @ResponseBody
    @GetMapping("/getCourseByname")
    public List<Course> getCourseByName(@RequestParam("Course_name") String Course_name){
        return courseService.findCourseByName(Course_name);
    }

    @ResponseBody
    @GetMapping("/getCourseByYearAndSeason")
    public List<Course> getCourseByYS(@RequestParam("Year") int Year,
                                      @RequestParam("Season") String Season){
        return courseService.findCourseBySemester(Year,Season);
    }

    @PostMapping("/Enroll")
    public String enrollCourse (@RequestParam("Course_name") String Course_name,
                                @RequestParam("Season") String Season,
                                @RequestParam("Year") int Year
    ){
        int i = courseUserService.enroll_course(UID,Course_name,Season,Year);
        if(i == 1){
            return "redirect:/success.html";
        }
        return null;
    }

    @PostMapping("/drop")
    public String dropCourse (@RequestParam("Course_name") String Course_name,
                              @RequestParam("Season") String Season,
                              @RequestParam("Year") int Year){
        int i = courseUserService.drop_course(UID,Course_name,Season,Year);
        if (i == 1){
            return "redirect:/success.html";
        }
        return null;
    }
    @ResponseBody
    @GetMapping("/getAllAnnounce")
    public List<Announcement> allAnn(){
        return announcementService.viewALL();
    }

    @ResponseBody
    @GetMapping("/getAllFacility")
    public List<String> allFac(){
        return facilityService.ViewAllFacility();
    }


    @ResponseBody
    @PostMapping("/CheckFacility")
    public String checkFac(@RequestParam("FID") int FID){
        if (facilityService.checkFacilityUsage(FID)){
            return "In use";
        }
        return "not In use";
    }

    @PostMapping("/borrow")
    public String borrow (@RequestParam("FID") int FID){
        int i = facilityUseService.Borrow(UID,FID);
        if (i == 1){
            return "redirect:/success.html";
        }
        return null;
    }

    @PostMapping("/return")
    public String Return (@RequestParam("FID") int FID){
        int i = facilityUseService.Return(UID,FID);
        if (i == 1){
            return "redirect:/success.html";
        }
        return null;
    }




}
