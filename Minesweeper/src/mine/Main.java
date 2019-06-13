package mine;

/*
1
 * [과제명 : 지뢰찾기]
게임을 제작한다고 가정하고, 각 사각형에 표시될 숫자를 입력하는 코드를 
작성하시오.
  * 언어는 자율이며, 실행 가능한 코드로 제출 
   - 빌드가 필요할 경우 빌드 방법을 반드시 설명해주세요.
  * 자료형 포함 프로그램 구성은 자율
  * 사각형은 가로10개 , 세로 10개
  * 지뢰의 갯수는 10개로 가정하고, 임의 위치에 놓여 있다고 하거나  
    직접 위치를 지정해도 무관
  * 모든 사각형(100개)에 대한 숫자를 구해야함
※ 참고 지뢰찾기의 각 사각형이 나타내는 숫자는 자신을 제외한 주변 8개 
    사각형에 포함된 폭탄의 갯수를 의미하며, 폭탄 갯수를 구하여 표시하는 것
    으로 작성해주십시오. 
 */
public class Main {

	public static void main(String[] args) {
		
		Minesweeper minesweeper = new Minesweeper();
		
		minesweeper.showStage();
		
	}
}
