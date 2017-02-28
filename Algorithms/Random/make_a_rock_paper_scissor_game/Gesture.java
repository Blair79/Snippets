package make_a_rock_paper_scissor_game;

enum Gesture {
	rock(1), paper(2), scissors(3);

	private int type;

	Gesture(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
}
