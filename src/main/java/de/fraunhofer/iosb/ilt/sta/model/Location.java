package de.fraunhofer.iosb.ilt.sta.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.fraunhofer.iosb.ilt.sta.dao.BaseDao;
import de.fraunhofer.iosb.ilt.sta.dao.LocationDao;
import de.fraunhofer.iosb.ilt.sta.model.ext.EntityList;
import de.fraunhofer.iosb.ilt.sta.service.SensorThingsService;
import org.geojson.GeoJsonObject;

public class Location extends Entity<Location> {

	private String name;
	private String description;
	private String encodingType;
	private GeoJsonObject location;

	@JsonProperty("Things")
	private EntityList<Thing> things;

	@JsonProperty("HistoricalLocations")
	private EntityList<HistoricalLocation> historicalLocations;

	public Location() {
	}

	public Location(String name, String description, String encodingType, GeoJsonObject location) {
		this.name = name;
		this.description = description;
		this.encodingType = encodingType;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEncodingType() {
		return this.encodingType;
	}

	public void setEncodingType(String encodingType) {
		this.encodingType = encodingType;
	}

	public EntityList<HistoricalLocation> getHistoricalLocations() {
		return this.historicalLocations;
	}

	public void setHistoricalLocations(EntityList<HistoricalLocation> historicalLocations) {
		this.historicalLocations = historicalLocations;
	}

	public GeoJsonObject getLocation() {
		return this.location;
	}

	public void setLocation(GeoJsonObject location) {
		this.location = location;
	}

	public EntityList<Thing> getThings() {
		if (this.things == null) {
			this.things = new EntityList<>(EntityType.THINGS);

		}
		return this.things;
	}

	public void setThings(EntityList<Thing> things) {
		this.things = things;
	}

	@Override
	public BaseDao<Location> getDao(SensorThingsService service) {
		return new LocationDao(service);
	}

}
