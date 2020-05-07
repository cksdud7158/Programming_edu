package oop.javadoc;
//
/*
 * 
 */
/**
 * 
 * @author HaBaRee [소스코드 작성자 정보]
 * @since JDK 1.8.5
 * @version [소스코드 버전정보] Start Version level 1.
 *
 */
public class JavaComment {
	/**
	 * 해당 점수를 받은 수강자의 이름이 입력되는 변수
	 */
	public String name;
	public int age;
	/**
	 * 
	 * @param java Program Score
	 * @param algo Program Score
	 * @return 자바성적과 알도리즘 성적의 합산으로 학생의 최종점수를 반환
	 */
	public int scoreSum(int java, int algo) {
		return java + algo; //호출한 곳으로....main Test
	}
	
}














