package org.example;

public class Main {
    interface Pow {
        int pow(int number, int pow);
    }

    static class Student {
        String firstName;
        String lastName;
        String group;
        double averageMark;

        public Student(String firstName, String lastName, String group, double averageMark) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.group = group;
            this.averageMark = averageMark;
        }

        public double getScholarship() {
            if (averageMark == 5) {
                return 100;
            } else {
                return 80;
            }
        }
    }

    static class Aspirant extends Student {
        String scientificWork;

        public Aspirant(String firstName, String lastName, String group, double averageMark, String scientificWork) {
            super(firstName, lastName, group, averageMark);
            this.scientificWork = scientificWork;
        }

        @Override
        public double getScholarship() {
            if (averageMark == 5) {
                return 200;
            } else {
                return 180;
            }
        }
    }

    public static void main(String[] args) {
        Pow power = (number, pow) -> {
            int result = 1;
            for (int i = 0; i < pow; i++) {
                result *= number;
            }
            return result;
        };

        int result = power.pow(2, 3);
        System.out.println("Результат: " + result);

        Student student = new Student("Иван", "Петров", "Группа 1", 4.5);
        Aspirant aspirant = new Aspirant("Петр", "Сидоров", "Группа 2", 5, "Научная работа");

        Student[] students = {student, aspirant};

        for (Student s : students) {
            System.out.println(s.firstName + " " + s.lastName + ": Стипендия - " + s.getScholarship() + " грн");
        }
    }
}
