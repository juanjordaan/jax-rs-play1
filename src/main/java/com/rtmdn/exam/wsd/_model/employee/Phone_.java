package com.rtmdn.exam.wsd._model.employee;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-12-02T20:14:35.840+0200")
@StaticMetamodel(Phone.class)
public class Phone_ {
	public static volatile SingularAttribute<Phone, Long> id;
	public static volatile SingularAttribute<Phone, String> number;
	public static volatile SingularAttribute<Phone, PhoneType> phoneType;
	public static volatile SingularAttribute<Phone, Employee> employee;
}
