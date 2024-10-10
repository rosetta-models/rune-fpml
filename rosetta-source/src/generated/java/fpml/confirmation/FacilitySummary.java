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
import fpml.confirmation.FacilityCommitmentModel;
import fpml.confirmation.FacilityDatesModel;
import fpml.confirmation.FacilityIdentifier;
import fpml.confirmation.FacilityIdentifier.FacilityIdentifierBuilder;
import fpml.confirmation.FacilityIdentifier.FacilityIdentifierBuilderImpl;
import fpml.confirmation.FacilityIdentifier.FacilityIdentifierImpl;
import fpml.confirmation.FacilityRolesModel;
import fpml.confirmation.FacilitySummary;
import fpml.confirmation.FacilitySummary.FacilitySummaryBuilder;
import fpml.confirmation.FacilitySummary.FacilitySummaryBuilderImpl;
import fpml.confirmation.FacilitySummary.FacilitySummaryImpl;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.meta.FacilitySummaryMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A short form of a facility.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilitySummary", builder=FacilitySummary.FacilitySummaryBuilderImpl.class, version="${project.version}")
public interface FacilitySummary extends FacilityIdentifier {

	FacilitySummaryMeta metaData = new FacilitySummaryMeta();

	/*********************** Getter Methods  ***********************/
	FacilityRolesModel getFacilityRolesModel();
	FacilityDatesModel getFacilityDatesModel();
	FacilityCommitmentModel getFacilityCommitmentModel();

	/*********************** Build Methods  ***********************/
	FacilitySummary build();
	
	FacilitySummary.FacilitySummaryBuilder toBuilder();
	
	static FacilitySummary.FacilitySummaryBuilder builder() {
		return new FacilitySummary.FacilitySummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilitySummary> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilitySummary> getType() {
		return FacilitySummary.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("facilityRolesModel"), processor, FacilityRolesModel.class, getFacilityRolesModel());
		processRosetta(path.newSubPath("facilityDatesModel"), processor, FacilityDatesModel.class, getFacilityDatesModel());
		processRosetta(path.newSubPath("facilityCommitmentModel"), processor, FacilityCommitmentModel.class, getFacilityCommitmentModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilitySummaryBuilder extends FacilitySummary, FacilityIdentifier.FacilityIdentifierBuilder {
		FacilityRolesModel.FacilityRolesModelBuilder getOrCreateFacilityRolesModel();
		FacilityRolesModel.FacilityRolesModelBuilder getFacilityRolesModel();
		FacilityDatesModel.FacilityDatesModelBuilder getOrCreateFacilityDatesModel();
		FacilityDatesModel.FacilityDatesModelBuilder getFacilityDatesModel();
		FacilityCommitmentModel.FacilityCommitmentModelBuilder getOrCreateFacilityCommitmentModel();
		FacilityCommitmentModel.FacilityCommitmentModelBuilder getFacilityCommitmentModel();
		FacilitySummary.FacilitySummaryBuilder setId(String id);
		FacilitySummary.FacilitySummaryBuilder addInstrumentId(InstrumentId instrumentId0);
		FacilitySummary.FacilitySummaryBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		FacilitySummary.FacilitySummaryBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		FacilitySummary.FacilitySummaryBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		FacilitySummary.FacilitySummaryBuilder setDescription(String description);
		FacilitySummary.FacilitySummaryBuilder setFacilityRolesModel(FacilityRolesModel facilityRolesModel);
		FacilitySummary.FacilitySummaryBuilder setFacilityDatesModel(FacilityDatesModel facilityDatesModel);
		FacilitySummary.FacilitySummaryBuilder setFacilityCommitmentModel(FacilityCommitmentModel facilityCommitmentModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("facilityRolesModel"), processor, FacilityRolesModel.FacilityRolesModelBuilder.class, getFacilityRolesModel());
			processRosetta(path.newSubPath("facilityDatesModel"), processor, FacilityDatesModel.FacilityDatesModelBuilder.class, getFacilityDatesModel());
			processRosetta(path.newSubPath("facilityCommitmentModel"), processor, FacilityCommitmentModel.FacilityCommitmentModelBuilder.class, getFacilityCommitmentModel());
		}
		

		FacilitySummary.FacilitySummaryBuilder prune();
	}

	/*********************** Immutable Implementation of FacilitySummary  ***********************/
	class FacilitySummaryImpl extends FacilityIdentifier.FacilityIdentifierImpl implements FacilitySummary {
		private final FacilityRolesModel facilityRolesModel;
		private final FacilityDatesModel facilityDatesModel;
		private final FacilityCommitmentModel facilityCommitmentModel;
		
		protected FacilitySummaryImpl(FacilitySummary.FacilitySummaryBuilder builder) {
			super(builder);
			this.facilityRolesModel = ofNullable(builder.getFacilityRolesModel()).map(f->f.build()).orElse(null);
			this.facilityDatesModel = ofNullable(builder.getFacilityDatesModel()).map(f->f.build()).orElse(null);
			this.facilityCommitmentModel = ofNullable(builder.getFacilityCommitmentModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityRolesModel")
		public FacilityRolesModel getFacilityRolesModel() {
			return facilityRolesModel;
		}
		
		@Override
		@RosettaAttribute("facilityDatesModel")
		public FacilityDatesModel getFacilityDatesModel() {
			return facilityDatesModel;
		}
		
		@Override
		@RosettaAttribute("facilityCommitmentModel")
		public FacilityCommitmentModel getFacilityCommitmentModel() {
			return facilityCommitmentModel;
		}
		
		@Override
		public FacilitySummary build() {
			return this;
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder toBuilder() {
			FacilitySummary.FacilitySummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilitySummary.FacilitySummaryBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityRolesModel()).ifPresent(builder::setFacilityRolesModel);
			ofNullable(getFacilityDatesModel()).ifPresent(builder::setFacilityDatesModel);
			ofNullable(getFacilityCommitmentModel()).ifPresent(builder::setFacilityCommitmentModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilitySummary _that = getType().cast(o);
		
			if (!Objects.equals(facilityRolesModel, _that.getFacilityRolesModel())) return false;
			if (!Objects.equals(facilityDatesModel, _that.getFacilityDatesModel())) return false;
			if (!Objects.equals(facilityCommitmentModel, _that.getFacilityCommitmentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityRolesModel != null ? facilityRolesModel.hashCode() : 0);
			_result = 31 * _result + (facilityDatesModel != null ? facilityDatesModel.hashCode() : 0);
			_result = 31 * _result + (facilityCommitmentModel != null ? facilityCommitmentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilitySummary {" +
				"facilityRolesModel=" + this.facilityRolesModel + ", " +
				"facilityDatesModel=" + this.facilityDatesModel + ", " +
				"facilityCommitmentModel=" + this.facilityCommitmentModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilitySummary  ***********************/
	class FacilitySummaryBuilderImpl extends FacilityIdentifier.FacilityIdentifierBuilderImpl  implements FacilitySummary.FacilitySummaryBuilder {
	
		protected FacilityRolesModel.FacilityRolesModelBuilder facilityRolesModel;
		protected FacilityDatesModel.FacilityDatesModelBuilder facilityDatesModel;
		protected FacilityCommitmentModel.FacilityCommitmentModelBuilder facilityCommitmentModel;
	
		public FacilitySummaryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityRolesModel")
		public FacilityRolesModel.FacilityRolesModelBuilder getFacilityRolesModel() {
			return facilityRolesModel;
		}
		
		@Override
		public FacilityRolesModel.FacilityRolesModelBuilder getOrCreateFacilityRolesModel() {
			FacilityRolesModel.FacilityRolesModelBuilder result;
			if (facilityRolesModel!=null) {
				result = facilityRolesModel;
			}
			else {
				result = facilityRolesModel = FacilityRolesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityDatesModel")
		public FacilityDatesModel.FacilityDatesModelBuilder getFacilityDatesModel() {
			return facilityDatesModel;
		}
		
		@Override
		public FacilityDatesModel.FacilityDatesModelBuilder getOrCreateFacilityDatesModel() {
			FacilityDatesModel.FacilityDatesModelBuilder result;
			if (facilityDatesModel!=null) {
				result = facilityDatesModel;
			}
			else {
				result = facilityDatesModel = FacilityDatesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityCommitmentModel")
		public FacilityCommitmentModel.FacilityCommitmentModelBuilder getFacilityCommitmentModel() {
			return facilityCommitmentModel;
		}
		
		@Override
		public FacilityCommitmentModel.FacilityCommitmentModelBuilder getOrCreateFacilityCommitmentModel() {
			FacilityCommitmentModel.FacilityCommitmentModelBuilder result;
			if (facilityCommitmentModel!=null) {
				result = facilityCommitmentModel;
			}
			else {
				result = facilityCommitmentModel = FacilityCommitmentModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public FacilitySummary.FacilitySummaryBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public FacilitySummary.FacilitySummaryBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public FacilitySummary.FacilitySummaryBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("instrumentId")
		public FacilitySummary.FacilitySummaryBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null)  {
				this.instrumentId = new ArrayList<>();
			}
			else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("description")
		public FacilitySummary.FacilitySummaryBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("facilityRolesModel")
		public FacilitySummary.FacilitySummaryBuilder setFacilityRolesModel(FacilityRolesModel facilityRolesModel) {
			this.facilityRolesModel = facilityRolesModel==null?null:facilityRolesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDatesModel")
		public FacilitySummary.FacilitySummaryBuilder setFacilityDatesModel(FacilityDatesModel facilityDatesModel) {
			this.facilityDatesModel = facilityDatesModel==null?null:facilityDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityCommitmentModel")
		public FacilitySummary.FacilitySummaryBuilder setFacilityCommitmentModel(FacilityCommitmentModel facilityCommitmentModel) {
			this.facilityCommitmentModel = facilityCommitmentModel==null?null:facilityCommitmentModel.toBuilder();
			return this;
		}
		
		@Override
		public FacilitySummary build() {
			return new FacilitySummary.FacilitySummaryImpl(this);
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilitySummary.FacilitySummaryBuilder prune() {
			super.prune();
			if (facilityRolesModel!=null && !facilityRolesModel.prune().hasData()) facilityRolesModel = null;
			if (facilityDatesModel!=null && !facilityDatesModel.prune().hasData()) facilityDatesModel = null;
			if (facilityCommitmentModel!=null && !facilityCommitmentModel.prune().hasData()) facilityCommitmentModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityRolesModel()!=null && getFacilityRolesModel().hasData()) return true;
			if (getFacilityDatesModel()!=null && getFacilityDatesModel().hasData()) return true;
			if (getFacilityCommitmentModel()!=null && getFacilityCommitmentModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilitySummary.FacilitySummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FacilitySummary.FacilitySummaryBuilder o = (FacilitySummary.FacilitySummaryBuilder) other;
			
			merger.mergeRosetta(getFacilityRolesModel(), o.getFacilityRolesModel(), this::setFacilityRolesModel);
			merger.mergeRosetta(getFacilityDatesModel(), o.getFacilityDatesModel(), this::setFacilityDatesModel);
			merger.mergeRosetta(getFacilityCommitmentModel(), o.getFacilityCommitmentModel(), this::setFacilityCommitmentModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilitySummary _that = getType().cast(o);
		
			if (!Objects.equals(facilityRolesModel, _that.getFacilityRolesModel())) return false;
			if (!Objects.equals(facilityDatesModel, _that.getFacilityDatesModel())) return false;
			if (!Objects.equals(facilityCommitmentModel, _that.getFacilityCommitmentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityRolesModel != null ? facilityRolesModel.hashCode() : 0);
			_result = 31 * _result + (facilityDatesModel != null ? facilityDatesModel.hashCode() : 0);
			_result = 31 * _result + (facilityCommitmentModel != null ? facilityCommitmentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilitySummaryBuilder {" +
				"facilityRolesModel=" + this.facilityRolesModel + ", " +
				"facilityDatesModel=" + this.facilityDatesModel + ", " +
				"facilityCommitmentModel=" + this.facilityCommitmentModel +
			'}' + " " + super.toString();
		}
	}
}
