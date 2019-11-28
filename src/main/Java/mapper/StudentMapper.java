package mapper;

import entity.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    Student selectById(Integer id);
    int insert(Student student);
    int delect(Integer id);
    int modify(Student student);

    Student selectByNameAndAge(@Param(value = "name") String name,@Param(value = "age") Integer id);
}
