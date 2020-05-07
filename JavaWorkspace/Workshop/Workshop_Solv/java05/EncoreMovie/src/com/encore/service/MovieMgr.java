package com.encore.service;

import com.encore.vo.Movie;
public class MovieMgr {
	private Movie[ ] movies = new Movie[100];
	private int index;
	
	//�̱���...MovieMgr�� mgr�̸����� ��ü ����...getInstance�� ������ ��ü�� �޾ƿ´�.
	private static MovieMgr mgr = new MovieMgr();
	private MovieMgr() {}
	public static MovieMgr getInstance() {
		return mgr;
	}
	
	public void add(Movie m) {
		movies[index++] = m;
	}
	
	public Movie[] search() {
		Movie[] nMovies = new Movie[index];
		for(int i=0; i<index; i++) {
			nMovies[i]=movies[i];
		}
		return nMovies;
	}
	
	public Movie[] search(String title) {
		int temp = 0;
		Movie[] nMovies = new Movie[index];
		
		for(Movie m : movies) {
			if(m==null) break;
			if(m.getTitle().contains(title)) {
				nMovies[temp++]=m;
			}
		}
		//null ���� �߸��� ���ؼ� �ٽ�  for���� ���۽�Ŵ
		Movie[] realMovies = new Movie[temp];
		for(int i=0; i<temp; i++) {
			realMovies[i] = nMovies[i];
		}
		return realMovies;
	}

	public Movie[] searchDirector(String name) {
		int size = 0;
		for(int i=0; i<index ; i++) {
			if(movies[i].getDirector().contains(name)) size++; //2
		}//
		
		Movie[] nMovie = new Movie[size];
		for(int i=0; i<index; i++) {
			if(movies[i].getDirector().contains(name)) {
				nMovie[--size]=movies[i];
			}
		}
		return nMovie;
	}

	public Movie[] searchGenre(String genre) {
		int temp = 0;
		for(Movie m : movies) {
			if(m==null)
				break;
			if(m.getGenre().equals(genre)) {
				temp ++;
			}
		}
		Movie[] rearMovies = new Movie[temp];
		for(int i = 0; i<temp;) {
			for(Movie m : movies) {
				if(m==null)
					return rearMovies;
				if(m.getGenre().equals(genre)) 
					rearMovies[i++] = m;
			}
		}
		return rearMovies;
	}

	public void delete(String title) {
		for(int i = 0; i<index ; i++) {			
			if(movies[i].getTitle().equals(title)) {
				for(int j = i; j<index; j++) {
					movies[j]=movies[j+1];
				}
			}
			break;
		}
		index --;
		
	}
	
	public int getSize() {
		return index;
	}
}







