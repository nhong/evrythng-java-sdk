package com.evrythng.thng.resource.model.store.geojson;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Represents the characteristics of a GeoJSON coordinate
 * 
 */
public abstract class GeoJson {
	static final int LON_IDX = 0;
	static final int LAT_IDX = 1;

	public static final String FIELD_TYPE = "type";
	public static final String FIELD_COORDINATES = "coordinates";

	private GeoJsonType type;

	public GeoJson(GeoJsonType type) {
		this.type = type;
	}

	public String getType() {
		return type.toString();
	}

	@JsonIgnore
	public GeoJsonType getGeoJsonType() {
		return type;
	}

	@Override
	public String toString() {
		return "GeoJson [type=" + type + "]";
	}
}
