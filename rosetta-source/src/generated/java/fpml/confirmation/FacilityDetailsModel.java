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
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.FacilityDetailsModel.FacilityDetailsModelBuilder;
import fpml.confirmation.FacilityDetailsModel.FacilityDetailsModelBuilderImpl;
import fpml.confirmation.FacilityDetailsModel.FacilityDetailsModelImpl;
import fpml.confirmation.FacilityIdentifier;
import fpml.confirmation.FacilitySummary;
import fpml.confirmation.meta.FacilityDetailsModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model used to reference a facility by either identifier or summary, within various notifications.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityDetailsModel", builder=FacilityDetailsModel.FacilityDetailsModelBuilderImpl.class, version="${project.version}")
public interface FacilityDetailsModel extends RosettaModelObject {

	FacilityDetailsModelMeta metaData = new FacilityDetailsModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A deal summary structure.
	 */
	FacilityIdentifier getFacilityIdentifier();
	/**
	 * A facility summary structure.
	 */
	FacilitySummary getFacilitySummary();

	/*********************** Build Methods  ***********************/
	FacilityDetailsModel build();
	
	FacilityDetailsModel.FacilityDetailsModelBuilder toBuilder();
	
	static FacilityDetailsModel.FacilityDetailsModelBuilder builder() {
		return new FacilityDetailsModel.FacilityDetailsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityDetailsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityDetailsModel> getType() {
		return FacilityDetailsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.class, getFacilityIdentifier());
		processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.class, getFacilitySummary());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityDetailsModelBuilder extends FacilityDetailsModel, RosettaModelObjectBuilder {
		FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier();
		FacilityIdentifier.FacilityIdentifierBuilder getFacilityIdentifier();
		FacilitySummary.FacilitySummaryBuilder getOrCreateFacilitySummary();
		FacilitySummary.FacilitySummaryBuilder getFacilitySummary();
		FacilityDetailsModel.FacilityDetailsModelBuilder setFacilityIdentifier(FacilityIdentifier facilityIdentifier);
		FacilityDetailsModel.FacilityDetailsModelBuilder setFacilitySummary(FacilitySummary facilitySummary);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.FacilityIdentifierBuilder.class, getFacilityIdentifier());
			processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.FacilitySummaryBuilder.class, getFacilitySummary());
		}
		

		FacilityDetailsModel.FacilityDetailsModelBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityDetailsModel  ***********************/
	class FacilityDetailsModelImpl implements FacilityDetailsModel {
		private final FacilityIdentifier facilityIdentifier;
		private final FacilitySummary facilitySummary;
		
		protected FacilityDetailsModelImpl(FacilityDetailsModel.FacilityDetailsModelBuilder builder) {
			this.facilityIdentifier = ofNullable(builder.getFacilityIdentifier()).map(f->f.build()).orElse(null);
			this.facilitySummary = ofNullable(builder.getFacilitySummary()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityIdentifier")
		public FacilityIdentifier getFacilityIdentifier() {
			return facilityIdentifier;
		}
		
		@Override
		@RosettaAttribute("facilitySummary")
		public FacilitySummary getFacilitySummary() {
			return facilitySummary;
		}
		
		@Override
		public FacilityDetailsModel build() {
			return this;
		}
		
		@Override
		public FacilityDetailsModel.FacilityDetailsModelBuilder toBuilder() {
			FacilityDetailsModel.FacilityDetailsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityDetailsModel.FacilityDetailsModelBuilder builder) {
			ofNullable(getFacilityIdentifier()).ifPresent(builder::setFacilityIdentifier);
			ofNullable(getFacilitySummary()).ifPresent(builder::setFacilitySummary);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityDetailsModel _that = getType().cast(o);
		
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityDetailsModel {" +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityDetailsModel  ***********************/
	class FacilityDetailsModelBuilderImpl implements FacilityDetailsModel.FacilityDetailsModelBuilder {
	
		protected FacilityIdentifier.FacilityIdentifierBuilder facilityIdentifier;
		protected FacilitySummary.FacilitySummaryBuilder facilitySummary;
	
		public FacilityDetailsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityIdentifier")
		public FacilityIdentifier.FacilityIdentifierBuilder getFacilityIdentifier() {
			return facilityIdentifier;
		}
		
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier() {
			FacilityIdentifier.FacilityIdentifierBuilder result;
			if (facilityIdentifier!=null) {
				result = facilityIdentifier;
			}
			else {
				result = facilityIdentifier = FacilityIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilitySummary")
		public FacilitySummary.FacilitySummaryBuilder getFacilitySummary() {
			return facilitySummary;
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder getOrCreateFacilitySummary() {
			FacilitySummary.FacilitySummaryBuilder result;
			if (facilitySummary!=null) {
				result = facilitySummary;
			}
			else {
				result = facilitySummary = FacilitySummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityIdentifier")
		public FacilityDetailsModel.FacilityDetailsModelBuilder setFacilityIdentifier(FacilityIdentifier facilityIdentifier) {
			this.facilityIdentifier = facilityIdentifier==null?null:facilityIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilitySummary")
		public FacilityDetailsModel.FacilityDetailsModelBuilder setFacilitySummary(FacilitySummary facilitySummary) {
			this.facilitySummary = facilitySummary==null?null:facilitySummary.toBuilder();
			return this;
		}
		
		@Override
		public FacilityDetailsModel build() {
			return new FacilityDetailsModel.FacilityDetailsModelImpl(this);
		}
		
		@Override
		public FacilityDetailsModel.FacilityDetailsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityDetailsModel.FacilityDetailsModelBuilder prune() {
			if (facilityIdentifier!=null && !facilityIdentifier.prune().hasData()) facilityIdentifier = null;
			if (facilitySummary!=null && !facilitySummary.prune().hasData()) facilitySummary = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFacilityIdentifier()!=null && getFacilityIdentifier().hasData()) return true;
			if (getFacilitySummary()!=null && getFacilitySummary().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityDetailsModel.FacilityDetailsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityDetailsModel.FacilityDetailsModelBuilder o = (FacilityDetailsModel.FacilityDetailsModelBuilder) other;
			
			merger.mergeRosetta(getFacilityIdentifier(), o.getFacilityIdentifier(), this::setFacilityIdentifier);
			merger.mergeRosetta(getFacilitySummary(), o.getFacilitySummary(), this::setFacilitySummary);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityDetailsModel _that = getType().cast(o);
		
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityDetailsModelBuilder {" +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary +
			'}';
		}
	}
}
