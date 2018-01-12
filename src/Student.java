import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/12.
 * 定义学生类,包含姓名(String name),性别(String gender),年龄(int age)三个属性
 * 生成空参有参构造,set和get方法,toString方法
 */
public class Student implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String gender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public Student() {
        this.name = null;
        this.gender = null;
        this.age = 0;
    }

    public Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "-" + gender + "-" + age;
    }
}
