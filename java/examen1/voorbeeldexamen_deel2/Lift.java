package domein;

public class Lift {
	private final int laagsteVerdieping;
	private final int hoogsteVerdieping;
	private int verdieping;

	public Lift(int laagsteVerdieping, int hoogsteVerdieping) {
		this.laagsteVerdieping = laagsteVerdieping;
		this.hoogsteVerdieping = hoogsteVerdieping;
	}

	public void gaNaarOmhoog(int aantalVerdiepingen) {
		// TODO
		throw new UnsupportedOperationException();
	}

	private void controleerLaagsteEnHoogsteVerdieping(int laagsteVerdieping, int hoogsteVerdieping) {
		// TODO
		throw new UnsupportedOperationException();
	}

	private void setVerdieping(int verdieping) {
		this.verdieping = verdieping;
	}

	public int getVerdieping() {
		return verdieping;
	}

	public int getLaagsteVerdieping() {
		return laagsteVerdieping;
	}

	public int getHoogsteVerdieping() {
		return hoogsteVerdieping;
	}

}
