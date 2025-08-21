package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student s;
    StudentList slist;

    @BeforeEach
    void setUp(){
        s = new Student("6710405338", "Test1");
    }
    @BeforeEach
    void setUpList() {
        slist = new StudentList();
        slist.addNewStudent("6710405338", "Test2");
        slist.addNewStudent("6710405331", "Test3");
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.12 คะแนน")
    void testAddScore(){
        s.addScore(45.12);
        assertEquals(45.12, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculatorGrade(){
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อเป็น Nobita")
    void testChangeName(){
        s.changeName("Nobita");
        assertEquals("Nobita", s.getName());
    }

    @Test
    @DisplayName("ทดสอบ isId")
    void TestIsId(){

        assertEquals(false, s.isId("6710405339"));
    }

    @Test
    @DisplayName("ทดสอบ isNameContains")
    void TestIsNameContains(){
        assertEquals(false, s.isNameContains("Nobita"));
    }

    /*@Test
    @DisplayName("")
    */

    @Test
    @DisplayName("ทดสอบ class Student list method findStudentId")
    void TestFindStudentById(){
        assertNotEquals(null, slist.findStudentById("6710405338"));
    }

    @Test
    @DisplayName("ทดสอบ class Student list method filterByName")
    void TestFilterByName(){
        assertNotEquals(null, slist.filterByName("Test2"));
    }

    @Test
    @DisplayName("ทดสอบ class Student list method giveScoreToId")
    void TestGiveScoreToId(){
        Student student = slist.findStudentById("6710405338");
        assertNotNull(student);

        assertEquals(0.0, student.getScore());
        slist.giveScoreToId("6710405338", 20.56);
        assertEquals(20.56, student.getScore());
    }

    @Test
    @DisplayName("ทดสอบ class Student list method viewGradeOfId")
    void TestViewGradeOfId(){
        Student student = slist.findStudentById("6710405338");
        assertNotNull(student);

        slist.giveScoreToId("6710405338", 50.65);
        assertEquals(50.65, student.getScore());
        assertEquals("D",  student.getGrade());
    }



}
