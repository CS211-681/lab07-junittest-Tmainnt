package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student s;

    @BeforeEach
    void setUp(){
        s = new Student("6710405338", "Test1");
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
}
