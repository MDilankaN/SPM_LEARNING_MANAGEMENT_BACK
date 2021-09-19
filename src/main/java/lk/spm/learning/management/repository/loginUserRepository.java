package lk.spm.learning.management.repository;

import lk.spm.learning.management.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface loginUserRepository {
    String validateUser (@RequestBody User user);
//    List<User>  getStudentList();//User
    List<User> getStudentList();
    List<User> getTeacherList();
    List<User> getUserList();
    String getTeacherStatus(@RequestBody User user);
    String getUserID(@RequestBody User user);
}
