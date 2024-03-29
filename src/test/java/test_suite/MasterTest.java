package test_suite;

import csc1035.project2.*;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

public class MasterTest {
    IController controller;
    Modules[] modules = {new Modules("RSI3393","Nunc nisl.",20,12,new HashSet<>()),
            new Modules("BBU5808","Integer pede justo lacinia eget tincidunt eget tempus vel pede.",10,12,new HashSet<>()),
            new Modules("SAM0176","Cras in purus eu magna vulputate luctus.",10,6,new HashSet<>())};

    Room[] rooms = {new Room("0.379","PC Cluster",157,36,new ArrayList<Booking>()),
            new Room("0.365","PC Cluster",59,9,new ArrayList<Booking>()),
            new Room("1.846","Lecture Lecture",274,50,new ArrayList<Booking>())};

    Staff[] staff = {new Staff("NUC3292317","Jacenta","Khomich",new HashSet<>()),
            new Staff("NUC9674902","Carmita","Cogzell",new HashSet<>()),
            new Staff("NUC7362101","Swen","Geard",new HashSet<>())};

    Students[] students = {new Students("216906208","Doralynn","Bordman",new HashSet<>()),
            new Students("218577635","Farra","Pietroni", new HashSet<>()),
            new Students("216365117","Clareta","Osmint",new HashSet<>())};

    ModuleRequirements[] requirements = {new ModuleRequirements("RSI3393",1,2,1,2,new Date()),
            new ModuleRequirements("BBU5808",1,2,2,2,new Date()),
            new ModuleRequirements("SAM0176",3,1,4,1,new Date())};

    //year 3921 because it adds 1900 from it for some reason
    Timestamp day = new Timestamp(121, 6, 22,
            0, 0,0,0);

    void setUp() {
        controller = new Controller();
        fillDBSample();
    }

    void deleteAll(){
        controller.deleteAll(ModuleBooking.class);
        controller.deleteAll(StudentBooking.class);
        controller.deleteAll(StaffBooking.class);
        controller.deleteAll(Take.class);
        controller.deleteAll(Teach.class);
        controller.deleteAll(Modules.class);
        controller.deleteAll(Room.class);
        controller.deleteAll(Staff.class);
        controller.deleteAll(Students.class);
        controller.deleteAll(ModuleRequirements.class);
    }

    /**
     * Fills the DB with sample data
     */
    void fillDBSample(){
        deleteAll();
        controller.bulkListSave(Arrays.asList(modules));
        controller.bulkListSave(Arrays.asList(rooms));
        controller.bulkListSave(Arrays.asList(staff));
        controller.bulkListSave(Arrays.asList(students));
        controller.bulkListSave(Arrays.asList(requirements));
    }

}
