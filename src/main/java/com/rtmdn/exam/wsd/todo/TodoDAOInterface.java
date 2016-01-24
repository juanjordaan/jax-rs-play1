package com.rtmdn.exam.wsd.todo;

import javax.ejb.Local;

import com.rtmdn.jpa.dao.Dao;

@Local
public interface TodoDAOInterface extends Dao<Long, Todo>
{
	
}
