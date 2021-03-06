package mine;


import java.util.Random;



public class Minesweeper {

	int row = 10; // 가로로 10칸
	int col = 10; // 세로로 10칸
	int mine = 10; // 지뢰 갯수
	int[] x = new int[mine];
	int[] y = new int[mine];

	// 8방향으로 탐색
	int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	// 정사각형 100칸 배열 생성
	String[][] stage = new String[row][col];

	public Minesweeper() {
		clean();
		makeMine();

	}

	// 모든 배열 0으로 바꿔주기
	private void clean() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				stage[i][j] = "0";
			}
		}
	}
	
	// 지뢰 랜덤 생성
	private int[] makeRandomPosition(int index) {
		Random random = new Random();
		int xx = 0;
		int yy = 0;
		
		int[] result = new int[2];

		xx = random.nextInt(row);
		yy = random.nextInt(col);

		for (int i = 0; i < index; i++) {
			if (xx == x[i] && yy == y[i]) {
				//또다시 처음부터 배열 탐색
				i = -1;
				xx = random.nextInt(row);
				yy = random.nextInt(col);
			}
		}
		result[0] = xx;
		result[1] = yy;
		return result;

	}

	// 지뢰 만들기
	private void makeMine() {

		// 지뢰의 갯수만큼 랜덤으로 지뢰 생성
		for (int i = 0; i < mine; i++) {
			int[] result = makeRandomPosition(i);
			x[i] = result[0];
			y[i] = result[1];
		}

		// 지뢰찾기
		for (int i = 0; i < mine; i++) {
			findMine(x[i], y[i]);
		}

		// 지뢰로 바꿔주기
		for (int i = 0; i < mine; i++) {
			changeToMine(x[i], y[i]);
		}

	}

	private void changeToMine(int x, int y) {
		stage[x][y] = "*";
	}
	
// 지뢰 찾기 
	private void findMine(int x, int y) {

		for (int k = 0; k < 8; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			// 탐색이 배열 넘으면 무시
			if (nx >= row || nx < 0 || ny >= col || ny < 0)
				continue;

			stage[nx][ny] = String.valueOf(Integer.parseInt(stage[nx][ny]) + 1);
		}

	}

	// 지뢰찾기 맵 출력
	public void showStage() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(stage[i][j] + " ");
			}
			System.out.println();
		}
	}

	

}
