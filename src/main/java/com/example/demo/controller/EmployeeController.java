package com.example.demo.controller;

import com.example.demo.DAO.*;
import com.example.demo.Service.*;
import com.example.demo.bean.*;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Employee")
public class EmployeeController {
    @Resource
    private UserDAO userDAO;
    @Resource
    private AnnouncementService announcementService;

    @Resource
    private CommentService commentService;

    @Resource
    private CourseService courseService;
    @Resource
    private FacilityService facilityService;

    @Resource
    private PaymentService paymentService;

    @Resource
    private Course_coachService courseCoachService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private Course_userService courseUserService;

    @Resource
    private FacilityUseService facilityUseService;
    int EID;
    @ResponseBody
    @GetMapping("/getAllUser")
    public List<User> allUser(){
        return userDAO.getAllUser();
    }

    @ResponseBody
    @GetMapping("/getAllPayment")
    public List<Payment> allPayment(){
        return paymentService.getAllPayment();
    }

    @ResponseBody
    @GetMapping("/getAllFacility")
    public List<Facility> allFac(){
        return facilityService.ViewAllDetailsF();
    }

    @PostMapping("/Addfacility")
    public String addFa (@RequestParam("Status") String Status,
                            @RequestParam("Facility_name") String Facility_name){
        int i = facilityService.addFacility(Status, Facility_name);
        if (i == 1){
            return "redirect:/Esuccess.html";
        }
        return null;
    }
    @PostMapping("/deleteFacility")
    public String deletefa (@RequestParam("FID") int FID
                        ){
        int i = facilityService.deleteFacility(FID);
        if (i == 1){
            return "redirect:/Esuccess.html";
        }
        return null;
    }

    @ResponseBody
    @GetMapping("/getAllCourse")
    public List<Course> allCourse(){
        return courseService.getAllCourse();
    }

    @PostMapping("/AddCourse")
    public String addCourse (@RequestParam("Course_name") String Name,
                             @RequestParam("Year") int Year,
                             @RequestParam("Season") String Season){
        int i = courseService.insertCourse(Name,Year,Season);
        if (i == 1){
            return "redirect:/Esuccess.html";
        }
        return null;
    }

    @PostMapping("/deleteCourse")
    public String deleteCourse (@RequestParam("Course_name") String Name,
                                @RequestParam("Year") int Year,
                                @RequestParam("Season") String Season){
        int i = courseService.deleteCourse(Name,Year,Season);
        if (i == 1){
            return "redirect:/Esuccess.html";
        }
        return null;
    }

    @ResponseBody
    @PostMapping("/ViewCourseUser")
    public List<Integer> findUserinCourse(@RequestParam("Course_name") String Name,
                                          @RequestParam("Year") int Year,
                                          @RequestParam("Season") String Season){
        return courseUserService.findUIDByCourse(Name,Season,Year);
    }

    @PostMapping("/announcement")
    public String announce (@RequestParam("Content") String Content,
                            @RequestParam("Title") String Title){
        int i = announcementService.publishAnn(EID,Content, Title);
        if (i == 1){
            return "redirect:/Esuccess.html";
        }
        return null;
    }
    @PostMapping("/updateannouncement")
    public String upannounce (@RequestParam("Content") String Content,
                            @RequestParam("Title") String Title,
                              @RequestParam("Date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date
    ){
        int i = announcementService.updateAnn(EID,Content, Title,date);
        if (i == 1){
            return "redirect:/Esuccess.html";
        }
        return null;
    }
    @PostMapping("/deleteeannouncement")
    public String dennounce (
                              @RequestParam("Title") String Title,
                              @RequestParam("Date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date
    ){
        int i = announcementService.deleteAnn(EID, Title,date);
        if (i == 1){
            return "redirect:/Esuccess.html";
        }
        return null;
    }

    @ResponseBody
    @PostMapping("/getPaymentOfID")
    public List<Payment> getPayment(@RequestParam("UID") int UID){
        return paymentService.getPaymentByID(UID);
    }

    @PostMapping("/login")
    public String Employ_login(@RequestParam("Email") String email) throws SQLException {
        EID = employeeService.loginByEmail(email).intValue();
        return "redirect:/Ehome.html";
    }


    @PostMapping("/reg")
    public String employee_reg(@RequestParam("Email") String email,
                           @RequestParam("Name") String Name,
                           @RequestParam("Birthday") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date birthday,
                           @RequestParam("Phone_number") int phone_num){
        int i = employeeService.registerByEmail(email, Name, birthday, phone_num);
        if (i == 1){
            return "redirect:/Esuccess.html";
        }
        return null;
    }

    @PostMapping("/AssignCoach")
    public String assignCoach(@RequestParam("EID") int EID,
                           @RequestParam("Field") String Field,
                           @RequestParam("Gender") String Gender){
        int i = employeeService.AssignCoach(EID,Field,Gender);
        if (i == 1){
            return "redirect:/Esuccess.html";
        }
        return null;
    }

    @PostMapping("/AssignCToC")
    public String assignCToC(@RequestParam("Coach_EID") int EID,
                             @RequestParam("Course") String Course,
                             @RequestParam("Season") String Season,
                             @RequestParam("Year") int Year){
        int i = courseCoachService.assignCoachToCourse(EID, Course, Season, Year);
        if (i == 1){
            return "redirect:/Esuccess.html";
        }
        return null;
    }


    @ResponseBody
    @GetMapping ("/getCourseAndCoachTable")
    public List<Coach_teach_course> getTable(){
        return courseCoachService.ViewTable();
    }

    @ResponseBody
    @GetMapping ("/getUsageTable")
    public List<Facility_usage> getUsageTable(){
        return facilityUseService.ViewusageTable();
    }

    @ResponseBody
    @GetMapping ("/getCommentTable")
    public List<String> getTable2(){
        return commentService.seeAllComments();
    }

}
