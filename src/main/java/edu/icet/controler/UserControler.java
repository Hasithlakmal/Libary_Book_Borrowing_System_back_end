package edu.icet.controler;

import edu.icet.model.dto.User;
import edu.icet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("user")

@CrossOrigin(origins = "http://localhost:5173")// add new for react coss oragin

public class UserControler {

    @Autowired

    UserService userService;


    @PostMapping("save")
    public String addUser(@RequestBody User user) {


        System.out.println(user);

      //  userService.add(user);


        // return "modulduwa"+bookService.getAll();

        return "ok add";

    }

    @DeleteMapping("delByOb")

    public String deletbyOb(@RequestBody User user) {

        userService.deletbyOb(user);

        return "delet sucsses full ok !!!";


    }


    @DeleteMapping("delUrlId/{id}")

    public String delUrlId(@PathVariable String id) {

        userService.deletbyId(id);

        return "delet sucsses full ok !!!";

    }


    @DeleteMapping("delById")

    public String deletbyId(@RequestBody String id) {

        userService.deletbyId(id);// not working

        System.out.println(id);

        return "delet sucsses full ok !!!";

        // only you can use number  , you can't use String for that
        //  post man in put  therefor  you  can only use number input  thorugh by
        // post man   actualy  id  or   serch itam  or primary key  must be number and not String
        // if was String  that  methord  not work



    }

    @GetMapping("getAll")
    public List<User> getAllUser() {

        List<User> allUser = userService.getAllUser();

        return allUser;

    }

    @GetMapping("getIDInfo/{id}")
    public User getIDInfo(@PathVariable String id) {

        User idInfo = userService.getIDInfo(id);

        return idInfo;

    }

    @GetMapping("/serchIdInfo")
    public User serchId (@RequestBody String id){

        return userService.getIDInfo(id);

        // only you can use number  , you can't use String for that
        //  post man in put  therefor  you  can only use number input  thorugh by
        // post man   actualy  id  or   serch itam  or primary key  must be number and not String
        // if was String  that  methord  not work

    }


    @PutMapping("update")
    public User Update(@RequestBody User user) {


        userService.update(user);
        return userService.getIDInfo(user.getUserId());


    }
}
