package pattern.action;
/*
 * AddAction -> 컴포넌트
 * 
 * 인터페이스 기반으로 작성된 재사용성이 강한 자바 클래스 
 */
public class UpdateAction implements Action {

	@Override
	public void excute() {
		/*
		 * 1. 폼값 받아서
		 * 2. DAO 리턴 받고 
		 * 3. Biz 로직 호출 
		 * 4. 리턴된 값 바인딩 
		 * 5. path를 최종적으로 리턴
		 */
		
		Update();
	}

	private void Update() {
		// 위의 로직들이 수행됐다 가정
		System.out.println("Update OK");
	}	
	
}