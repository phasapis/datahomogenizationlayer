package org.impress.datahomogenization.ws.model;

public class Building {
	String artifact;
	GeoPoint coords;
	String type;

	public String getArtifact() {
		return artifact;
	}

	public void setArtifact(String artifact) {
		this.artifact = artifact;
	}

	public GeoPoint getCoords() {
		return coords;
	}

	public void setCoords(GeoPoint coords) {
		this.coords = coords;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
