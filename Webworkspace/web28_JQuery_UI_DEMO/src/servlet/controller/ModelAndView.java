/*
 * 결과 페이지 이름과 
 * 이동 방식(forward| redirect)에 대한 정보를 담고 있는 객체 
 * ModelandView 
 */
package servlet.controller;

public class ModelAndView {
	private String path;
	private boolean isRedirect; 
	// 필드의 데이타 타입이 불리언 일떄 기본 값은 false 이다. 
	// 따라서 false 값을 넘길 떄는 생성자에 불리언 타입을 뺴고 넘겨도 된다. 
	// 
	
	public ModelAndView() {
		super();
	}
	
	public ModelAndView(String path) {
		this.path = path;
	}
	
	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	@Override
	public String toString() {
		return "ModelAndView [path=" + path + ", isRedirect=" + isRedirect + "]";
	}
	
	
	
	
	
}
