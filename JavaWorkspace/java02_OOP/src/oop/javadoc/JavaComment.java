package oop.javadoc;
/**
 * 
 * @author Ryan [소스코드 작성자 정보]
 * @since JDK1.8.5 
 * @version [소스코드 버전정보] Start Version level 1.
 *
 */
public class JavaComment {
	/**
	 * 해당 점수를 받은 수강자의 이름이 입력되는 변수
	 */
	public String name;

	/**
	 * 
	 * @param java -> 인자값, Program Score
	 * @param algo Program Score
	 * @return 자바 성적과 알고리즘 성점의 합산으로 학생의 최종 점수를 반환
	 */
	public int scoreSum(int java, int algo) {
		return java + algo; 
	}
}
