package ku.cs.kafe.controller;


import ku.cs.kafe.model.SignupRequest_Sorasak_6210451560;
import ku.cs.kafe.service.SignupService_Sorasak_6210451560;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SignupController_Sorasak_6210451560 {


    @Autowired
    private SignupService_Sorasak_6210451560 signupService;


    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup"; // return หน้าฟอร์ม signup.html
    }


    @PostMapping("/signup")
    public String signupUser(@ModelAttribute SignupRequest_Sorasak_6210451560 user,
                             Model model) {
        if (signupService.isUsernameAvailable(user.getUsername())) {
            signupService.createUser(user);
            model.addAttribute("signupSuccess", true);
        } else {
            model.addAttribute("signupError", "Username not available");
        }
        return "signup";
    }
}

