package com.rtmdn.exam.wsd._model.employee;

import com.rtmdn.exam.wsd._model.project.Project;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-12-07T20:19:24.693+0200")
@StaticMetamodel(Employee.class)
public class Employee_ {
	public static volatile SingularAttribute<Employee, Long> id;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, Date> startDate;
	public static volatile SingularAttribute<Employee, Double> salary;
	public static volatile SingularAttribute<Employee, byte[]> picture;
	public static volatile SingularAttribute<Employee, Address> address;
	public static volatile SetAttribute<Employee, Phone> phones;
	public static volatile SingularAttribute<Employee, Department> department;
	public static volatile SingularAttribute<Employee, Employee> manager;
	public static volatile SetAttribute<Employee, Employee> directs;
	public static volatile SetAttribute<Employee, Project> projects;
}
