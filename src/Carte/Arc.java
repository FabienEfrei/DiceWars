package Carte;

public class Arc {

	public Sommet source, destination;
	public int value;

	public Arc(Sommet source, Sommet destination, int value) {
		this.source = source;
		this.destination = destination;
		this.value = value;
	}

	@Override
	public String toString() {
		return (source + "->" + value + ":" + destination);
	}
	
}
