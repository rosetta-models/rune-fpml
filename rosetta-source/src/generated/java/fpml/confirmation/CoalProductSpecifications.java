package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.CoalProductSpecifications;
import fpml.confirmation.CoalProductSpecifications.CoalProductSpecificationsBuilder;
import fpml.confirmation.CoalProductSpecifications.CoalProductSpecificationsBuilderImpl;
import fpml.confirmation.CoalProductSpecifications.CoalProductSpecificationsImpl;
import fpml.confirmation.CoalStandardQuality;
import fpml.confirmation.CoalStandardQualitySchedule;
import fpml.confirmation.meta.CoalProductSpecificationsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The different options for specifying the quality attributes of the coal to be delivered.
 * @version ${project.version}
 */
@RosettaDataType(value="CoalProductSpecifications", builder=CoalProductSpecifications.CoalProductSpecificationsBuilderImpl.class, version="${project.version}")
public interface CoalProductSpecifications extends RosettaModelObject {

	CoalProductSpecificationsMeta metaData = new CoalProductSpecificationsMeta();

	/*********************** Getter Methods  ***********************/
	CoalStandardQuality getStandardQuality();
	CoalStandardQualitySchedule getStandardQualitySchedule();

	/*********************** Build Methods  ***********************/
	CoalProductSpecifications build();
	
	CoalProductSpecifications.CoalProductSpecificationsBuilder toBuilder();
	
	static CoalProductSpecifications.CoalProductSpecificationsBuilder builder() {
		return new CoalProductSpecifications.CoalProductSpecificationsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalProductSpecifications> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CoalProductSpecifications> getType() {
		return CoalProductSpecifications.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("standardQuality"), processor, CoalStandardQuality.class, getStandardQuality());
		processRosetta(path.newSubPath("standardQualitySchedule"), processor, CoalStandardQualitySchedule.class, getStandardQualitySchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalProductSpecificationsBuilder extends CoalProductSpecifications, RosettaModelObjectBuilder {
		CoalStandardQuality.CoalStandardQualityBuilder getOrCreateStandardQuality();
		CoalStandardQuality.CoalStandardQualityBuilder getStandardQuality();
		CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder getOrCreateStandardQualitySchedule();
		CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder getStandardQualitySchedule();
		CoalProductSpecifications.CoalProductSpecificationsBuilder setStandardQuality(CoalStandardQuality standardQuality);
		CoalProductSpecifications.CoalProductSpecificationsBuilder setStandardQualitySchedule(CoalStandardQualitySchedule standardQualitySchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("standardQuality"), processor, CoalStandardQuality.CoalStandardQualityBuilder.class, getStandardQuality());
			processRosetta(path.newSubPath("standardQualitySchedule"), processor, CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder.class, getStandardQualitySchedule());
		}
		

		CoalProductSpecifications.CoalProductSpecificationsBuilder prune();
	}

	/*********************** Immutable Implementation of CoalProductSpecifications  ***********************/
	class CoalProductSpecificationsImpl implements CoalProductSpecifications {
		private final CoalStandardQuality standardQuality;
		private final CoalStandardQualitySchedule standardQualitySchedule;
		
		protected CoalProductSpecificationsImpl(CoalProductSpecifications.CoalProductSpecificationsBuilder builder) {
			this.standardQuality = ofNullable(builder.getStandardQuality()).map(f->f.build()).orElse(null);
			this.standardQualitySchedule = ofNullable(builder.getStandardQualitySchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("standardQuality")
		public CoalStandardQuality getStandardQuality() {
			return standardQuality;
		}
		
		@Override
		@RosettaAttribute("standardQualitySchedule")
		public CoalStandardQualitySchedule getStandardQualitySchedule() {
			return standardQualitySchedule;
		}
		
		@Override
		public CoalProductSpecifications build() {
			return this;
		}
		
		@Override
		public CoalProductSpecifications.CoalProductSpecificationsBuilder toBuilder() {
			CoalProductSpecifications.CoalProductSpecificationsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalProductSpecifications.CoalProductSpecificationsBuilder builder) {
			ofNullable(getStandardQuality()).ifPresent(builder::setStandardQuality);
			ofNullable(getStandardQualitySchedule()).ifPresent(builder::setStandardQualitySchedule);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalProductSpecifications _that = getType().cast(o);
		
			if (!Objects.equals(standardQuality, _that.getStandardQuality())) return false;
			if (!Objects.equals(standardQualitySchedule, _that.getStandardQualitySchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardQuality != null ? standardQuality.hashCode() : 0);
			_result = 31 * _result + (standardQualitySchedule != null ? standardQualitySchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalProductSpecifications {" +
				"standardQuality=" + this.standardQuality + ", " +
				"standardQualitySchedule=" + this.standardQualitySchedule +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalProductSpecifications  ***********************/
	class CoalProductSpecificationsBuilderImpl implements CoalProductSpecifications.CoalProductSpecificationsBuilder {
	
		protected CoalStandardQuality.CoalStandardQualityBuilder standardQuality;
		protected CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder standardQualitySchedule;
	
		public CoalProductSpecificationsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("standardQuality")
		public CoalStandardQuality.CoalStandardQualityBuilder getStandardQuality() {
			return standardQuality;
		}
		
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder getOrCreateStandardQuality() {
			CoalStandardQuality.CoalStandardQualityBuilder result;
			if (standardQuality!=null) {
				result = standardQuality;
			}
			else {
				result = standardQuality = CoalStandardQuality.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("standardQualitySchedule")
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder getStandardQualitySchedule() {
			return standardQualitySchedule;
		}
		
		@Override
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder getOrCreateStandardQualitySchedule() {
			CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder result;
			if (standardQualitySchedule!=null) {
				result = standardQualitySchedule;
			}
			else {
				result = standardQualitySchedule = CoalStandardQualitySchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("standardQuality")
		public CoalProductSpecifications.CoalProductSpecificationsBuilder setStandardQuality(CoalStandardQuality standardQuality) {
			this.standardQuality = standardQuality==null?null:standardQuality.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("standardQualitySchedule")
		public CoalProductSpecifications.CoalProductSpecificationsBuilder setStandardQualitySchedule(CoalStandardQualitySchedule standardQualitySchedule) {
			this.standardQualitySchedule = standardQualitySchedule==null?null:standardQualitySchedule.toBuilder();
			return this;
		}
		
		@Override
		public CoalProductSpecifications build() {
			return new CoalProductSpecifications.CoalProductSpecificationsImpl(this);
		}
		
		@Override
		public CoalProductSpecifications.CoalProductSpecificationsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalProductSpecifications.CoalProductSpecificationsBuilder prune() {
			if (standardQuality!=null && !standardQuality.prune().hasData()) standardQuality = null;
			if (standardQualitySchedule!=null && !standardQualitySchedule.prune().hasData()) standardQualitySchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStandardQuality()!=null && getStandardQuality().hasData()) return true;
			if (getStandardQualitySchedule()!=null && getStandardQualitySchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalProductSpecifications.CoalProductSpecificationsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalProductSpecifications.CoalProductSpecificationsBuilder o = (CoalProductSpecifications.CoalProductSpecificationsBuilder) other;
			
			merger.mergeRosetta(getStandardQuality(), o.getStandardQuality(), this::setStandardQuality);
			merger.mergeRosetta(getStandardQualitySchedule(), o.getStandardQualitySchedule(), this::setStandardQualitySchedule);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalProductSpecifications _that = getType().cast(o);
		
			if (!Objects.equals(standardQuality, _that.getStandardQuality())) return false;
			if (!Objects.equals(standardQualitySchedule, _that.getStandardQualitySchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardQuality != null ? standardQuality.hashCode() : 0);
			_result = 31 * _result + (standardQualitySchedule != null ? standardQualitySchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalProductSpecificationsBuilder {" +
				"standardQuality=" + this.standardQuality + ", " +
				"standardQualitySchedule=" + this.standardQualitySchedule +
			'}';
		}
	}
}
