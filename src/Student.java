import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/12.
 * 定义学生类,包含姓名(String name),性别(String gender),年龄(int age)三个属性
 * 生成空参有参构造,set和get方法,toString方法
 */
public class Student implements Serializable, Comparable<Student> {
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

    @Override
    public int compareTo(Student s) {
        if (this.age > s.age) {
            return 1;
        }else if (this.age < s.age) {
            return -1;
        }else {
            return 0;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (!name.equals(student.name)) return false;
        return gender.equals(student.gender);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + age;
        return result;
    }
}
