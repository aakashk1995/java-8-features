package com.example.java8.java8features.streamapi;

import com.example.java8.java8features.streamapi.dao.ClassroomDao;
import com.example.java8.java8features.streamapi.model.Classroom;
import com.example.java8.java8features.streamapi.model.Student;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stream_API_Classroom_Data_Example {

    static List<Classroom> classroomList = ClassroomDao.getAllClassroomStudents();

    public static void main(String[] args) {

        printCitiesTopper();


    }
    /*
     * 1. define a function getStudentsByCity(city) that will take cityName as
     * ARGUMENT and return all students of that city.
     */
    public static List<Student> getStudentsByCity(String cityName){
      return   classroomList.stream().flatMap(classroom -> classroom.getStudents().stream())
                .filter(student -> student.getCity().equalsIgnoreCase(cityName))
                .collect(Collectors.toList());
    }

    /*
     * 2. define a function getUniqueCities() that will return an array of city
     * names. cities in array must not duplicate. ["pune", "jaipur","chandigarh"]
     */

    public static List<String> getUniqueCities(){
        return classroomList.stream().flatMap(classroom -> classroom.getStudents().stream())
                .map(Student::getCity).distinct().collect(Collectors.toList());
    }

    /*
     * 3. define a function getPassedStudentsNamesWithGradeA() that will return all
     * students who passed. passing criteria will be
     *
     * a.) marks> 33 in each subject.
     *
     * b.) marks> 33 in each subject and overall avg > 50
     *
     * c.) for general cat. marks> 33 in each subject and overall avg > 50
     *
     * d.) for obc cat. marks> 33 in each subject and overall avg > 40
     *
     * e.) for sc and st cat. marks> 33 in each subject only
     */

    public static void getPassedStudentsNamesWithGradeA() {
        Predicate<Integer> conditionA= (marks) -> marks>33;
        Predicate<Student> conditionB= student -> student.getMarks().stream().mapToInt(Integer::intValue).average().getAsDouble()>50;

        Predicate<Student> generalCategoryCondition = student -> student.getCategory().equalsIgnoreCase("obc");
        Predicate<Student> obcCategoryCondition = student -> student.getCategory().equalsIgnoreCase("obc");
        Predicate<Student> scCategoryCondition = student -> student.getCategory().equalsIgnoreCase("sc");
        Predicate<Student> stCategoryCondition = student -> student.getCategory().equalsIgnoreCase("st");

        classroomList.stream().flatMap(classroom -> classroom.getStudents().stream())
                .filter(generalCategoryCondition)
                .filter(student -> student.getMarks().stream().allMatch(conditionA))
                .filter(conditionB)
                .map(Student::getName)
                .collect(Collectors.toList());

        classroomList.stream().flatMap(classroom -> classroom.getStudents().stream())
                .filter(student -> student.getCategory().equalsIgnoreCase("obc"))
                .filter(student -> student.getMarks().stream().allMatch(conditionA))
                .filter(student -> student.getMarks().stream().mapToInt(Integer::intValue).average().getAsDouble()>40)
                .map(Student::getName)
                .collect(Collectors.toList());

        classroomList.stream().flatMap(classroom -> classroom.getStudents().stream())
                .filter(student -> student.getCategory().equalsIgnoreCase("sc") ||
                        student.getCategory().equalsIgnoreCase("st"))
                .filter(student -> student.getMarks().stream().allMatch(conditionA))
                .map(Student::getName)
                .collect(Collectors.toList());

    }

    /*
     * 4. define a function printCitiesTopper() that will print an array of objects
     * each object will have two properties cityName and topperName.
     */
    static Map<String,Student> topperCityWise = new HashMap<>();
    public static void printCitiesTopper() {
        Map<String, List<Student>> mapCitiesStudent = classroomList.stream().flatMap(classroom -> classroom.getStudents().stream()).collect(Collectors.groupingBy(Student::getCity));
        mapCitiesStudent.entrySet().stream().forEach(mapEntry -> topperCityWise.put(mapEntry.getKey(),findTopper(mapEntry.getValue())));
        System.out.println(topperCityWise);
    }
    /*
    5. From list of students find student who is topper by summation of marks
     */
    public static Student findTopper(List<Student> studentsList){
     return  studentsList.stream().reduce((student, student2) -> student.getMarks().stream().mapToInt(Integer::intValue).sum() > student2.getMarks().stream().mapToInt(Integer::intValue).sum()?student:student2).get();
    }
}
