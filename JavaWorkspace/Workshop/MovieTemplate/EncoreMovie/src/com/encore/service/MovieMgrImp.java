package com.encore.service;

import com.encore.vo.Movie;

public class MovieMgrImp implements MovieMgr {
	
	private int index;
	
	//�̱��� 1�� 
	private static MovieMgrImp mgr = new MovieMgrImp();
	//�̱��� 2��
	private MovieMgrImp() {}
	//�̱��� 3��
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







