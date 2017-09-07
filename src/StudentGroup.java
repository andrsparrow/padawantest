package com.epam.college;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

import javax.management.ObjectName;

public class StudentGroup implements GroupOperationService {

	private Student[] students;

	public StudentGroup(int length) {
		students = new Student[0];
	}

	@Override
	public Student[] getStudents() {
		return students;

	}

	@Override
	public void setStudents(Student[] students) {

		if (this.students == null) {
			throw new IllegalArgumentException();
		} else
			this.students = students;
	}

	@Override
	public Student getStudent(int index) {
		if (index > 0 && index >= students.length)
			throw new IllegalArgumentException();
		else
			return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		if (student == null && index > 0 && index >= students.length)
			throw new IllegalArgumentException();
		else
			students[index] = student;

	}

	@Override
	public void addFirst(Student student) {
		if (student == null)
			throw new IllegalArgumentException();
		Student[] temp = new Student[students.length + 1];
		for (int i = 0; i < students.length; i++) {

			temp[i + 1] = students[i];
		}
		temp[0] = student;
		students = new Student[temp.length];
		for (int i = 0; i < temp.length; i++) {
			students[i] = temp[i];
		}
	}

	@Override
	public void addLast(Student student) {

		if (student == null)
			throw new IllegalArgumentException();
		Student[] temp = new Student[students.length + 1];
		for (int i = 0; i < students.length; i++) {
			temp[i] = students[i];
		}
		temp[students.length] = student;
		students = new Student[temp.length];
		for (int i = 0; i < temp.length; i++) {
			students[i] = temp[i];
		}

	}

	@Override
	public void remove(int index) {
		if (index >= students.length && index < 0)
			throw new IllegalArgumentException();
		Student[] temp = new Student[students.length - 1];
		for (int i = 0; i < index; i++) {
			temp[i] = students[i];
		}
		for (int i = index + 1; i < students.length; i++) {
			temp[i - 1] = students[i];
		}

		students = new Student[temp.length];
		for (int i = 0; i < temp.length; i++) {
			students[i] = temp[i];
		}
	}

	@Override
	public void remove(Student student) {
		if (student == null)
			throw new IllegalArgumentException();
		int count = 0;
		int indexremove = 0;
		int check = 0;
		for (int i = 0; i < students.length; i++) {
			if (student.equals(students[i])) {
				indexremove = i;
				if (i == 0)
					check++;
				count++;
			}
		}

		if (count != 0 && check != 0) {
			Student[] temp = new Student[students.length - 1];
			for (int i = 0; i < indexremove; i++) {
				if (!student.equals(students[i]))
					temp[i] = students[i];
			}
			for (int i = indexremove + 1; i < students.length; i++) {
				if (!student.equals(students[i]))
					temp[i - 1] = students[i];
			}
			students = new Student[temp.length];
			for (int i = 0; i < temp.length; i++) {
				students[i] = temp[i];
			}
		} else {
			Student[] temp = new Student[students.length - 1];

			for (int i = 0; i < students.length; i++) {
				temp[i - 1] = students[i];
			}
			students = new Student[temp.length];
			for (int i = 0; i < temp.length; i++) {
				students[i] = temp[i];
			}
		}

	}

	@Override
	public void removeFromIndex(int index) {

		if (index >= students.length && index < 0)
			throw new IllegalArgumentException();
		Student[] temp = new Student[index];
		for (int i = 0; i < index; i++) {
			temp[i] = students[i];
		}

		students = new Student[temp.length];
		for (int i = 0; i < temp.length; i++) {
			students[i] = temp[i];
		}

	}

	@Override
	public void removeFromElement(Student student) {

		if (student == null)
			throw new IllegalArgumentException();
		int count = 0;
		for (int i = 0; i < students.length; i++) {
			if (student.equals(students[i]))
				count = i;
		}

		Student[] temp = new Student[count + 1];
		for (int i = 0; i < count + 1; i++) {
			temp[i] = students[i];
		}

		students = new Student[temp.length];
		for (int i = 0; i < temp.length; i++) {
			students[i] = temp[i];
		}

	}

	@Override
	public void removeToIndex(int index) {

		if (index >= students.length && index < 0)
			throw new IllegalArgumentException();
		if (index == 0)
			students = new Student[0];
		else {
			Student[] temp = new Student[students.length - index + 1];
			for (int i = 0; i < students.length - index + 1; i++) {
				temp[i] = students[index + i - 1];
			}

			students = new Student[temp.length];
			for (int i = 0; i < temp.length; i++) {
				students[i] = temp[i];
			}
		}
	}

	@Override
	public void removeToElement(Student student) {

		if (student == null)
			throw new IllegalArgumentException();
		int count = 0;
		for (int i = 0; i < students.length; i++) {
			if (student.equals(students[i]))
				count = i;
		}
		if (count != 0) {
			Student[] temp = new Student[students.length - count];
			for (int i = 0; i < students.length - count; i++) {
				temp[i] = students[count + i];
			}

			students = new Student[temp.length];
			for (int i = 0; i < temp.length; i++) {
				students[i] = temp[i];
			}
		} else {
			students = new Student[0];
		}

	}

	@Override
	public void bubbleSort() {
		Arrays.sort(students);
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		Student[] result = null;
		int count = 0;
		if (date == null)
			throw new IllegalArgumentException();

		for (int i = 0; i < students.length; i++) {
			if (date.equals( students[i].getBirthDate())) {
				count++;
			}
		}
		if (count != 0) {
			int counter=0;
			result= new Student[count];
			for (int i = 0; i < students.length; i++) {
				if (date.equals( students[i].getBirthDate())) {
					result[counter]=students[i];
					counter++;
				}
			}
		}
		return result;

	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		
		
		return students;

	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		return students;

	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		return indexOfStudent;

	}

	@Override
	public Student[] getStudentsByAge(int age) {
		return students;

	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		return students;

	}

	@Override
	public Student getNextStudent(Student student) {
		return student;

	}

	@Override
	public void add(Student student, int index) {
		if (student == null && index >= students.length && index < 0)
			throw new IllegalArgumentException();
		Student[] temp = new Student[students.length + 1];
		for (int i = 0; i < students.length; i++) {
			temp[i] = students[i];
		}
		temp[students.length] = student;
		students = new Student[temp.length];
		for (int i = 0; i < temp.length; i++) {
			students[i] = temp[i];
		}

	}

	private int getStudentIndex(Student student) {
		return 0;

	}

	private int getDiffYears(Date first, Date last) {
		return 0;

	}

	private Calendar getCalendar(Date date) {
		return null;

	}

	public void show() {
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
		}
	}

}