package com.encore.service;

import com.encore.vo.Movie;

public class MovieMgrImp implements MovieMgr {
	
	private int index;
	
	//½Ì±ÛÅæ 1¹ø 
	private static MovieMgrImp mgr = new MovieMgrImp();
	//½Ì±ÛÅæ 2¹ø
	private MovieMgrImp() {}
	//½Ì±ÛÅë 3¹ø
	public static MovieMgrImp getInstance(){
		return mgr;
	}
	
	@Override
	public void add(Movie m) {
		
	}

	@Override
	public Movie[] search() {
		return null;
	}

	@Override
	public Movie[] search(String title) {
		return null;
	}

	@Override
	public Movie[] searchDirector(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie[] searchGenre(String genre) {
		return null;
	}

	@Override
	public void delete(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSize() {
		return 0;
	}
}







