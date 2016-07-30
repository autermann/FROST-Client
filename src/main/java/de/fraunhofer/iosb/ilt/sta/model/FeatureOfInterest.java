package de.fraunhofer.iosb.ilt.sta.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.fraunhofer.iosb.ilt.sta.dao.BaseDao;
import de.fraunhofer.iosb.ilt.sta.dao.FeatureOfInterestDao;
import de.fraunhofer.iosb.ilt.sta.model.ext.EntityList;
import de.fraunhofer.iosb.ilt.sta.service.SensorThingsService;
import org.geojson.GeoJsonObject;

public class FeatureOfInterest extends Entity<FeatureOfInterest> {

	private String description;
	private String encodingType;
	private GeoJsonObject feature;

	@JsonProperty("Observations")
	private EntityList<Observation> observations;

	public FeatureOfInterest() {
	}

	public FeatureOfInterest(String description, String encodingType, GeoJsonObject feature) {
		this.description = description;
		this.encodingType = encodingType;
		this.feature = feature;
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

	public GeoJsonObject getFeature() {
		return this.feature;
	}

	public void setFeature(GeoJsonObject feature) {
		this.feature = feature;
	}

	public EntityList<Observation> getObservations() {
		return this.observations;
	}

	public void setObservations(EntityList<Observation> observations) {
		this.observations = observations;
	}

	@Override
	public BaseDao<FeatureOfInterest> getDao(SensorThingsService service) {
		return new FeatureOfInterestDao(service);
	}

}
