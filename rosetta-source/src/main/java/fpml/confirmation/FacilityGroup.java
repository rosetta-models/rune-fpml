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
import fpml.confirmation.AbstractFacility;
import fpml.confirmation.AbstractFacility.AbstractFacilityBuilder;
import fpml.confirmation.AbstractFacility.AbstractFacilityBuilderImpl;
import fpml.confirmation.AbstractFacility.AbstractFacilityImpl;
import fpml.confirmation.FacilityCommitmentModel;
import fpml.confirmation.FacilityDatesModel;
import fpml.confirmation.FacilityFeaturesModel;
import fpml.confirmation.FacilityGroup;
import fpml.confirmation.FacilityGroup.FacilityGroupBuilder;
import fpml.confirmation.FacilityGroup.FacilityGroupBuilderImpl;
import fpml.confirmation.FacilityGroup.FacilityGroupImpl;
import fpml.confirmation.FacilityOptionsFeesAndRatesModel;
import fpml.confirmation.FacilityRolesModel;
import fpml.confirmation.GoverningLaw;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.MultiCurrency;
import fpml.confirmation.meta.FacilityGroupMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Head of the substitution group for all facility types.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FacilityGroup", builder=FacilityGroup.FacilityGroupBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FacilityGroup extends AbstractFacility {

	FacilityGroupMeta metaData = new FacilityGroupMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FacilityGroup build();
	
	FacilityGroup.FacilityGroupBuilder toBuilder();
	
	static FacilityGroup.FacilityGroupBuilder builder() {
		return new FacilityGroup.FacilityGroupBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityGroup> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityGroup> getType() {
		return FacilityGroup.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("facilityRolesModel"), processor, FacilityRolesModel.class, getFacilityRolesModel());
		processRosetta(path.newSubPath("facilityDatesModel"), processor, FacilityDatesModel.class, getFacilityDatesModel());
		processRosetta(path.newSubPath("facilityCommitmentModel"), processor, FacilityCommitmentModel.class, getFacilityCommitmentModel());
		processRosetta(path.newSubPath("governingLaw"), processor, GoverningLaw.class, getGoverningLaw());
		processRosetta(path.newSubPath("facilityFeaturesModel"), processor, FacilityFeaturesModel.class, getFacilityFeaturesModel());
		processRosetta(path.newSubPath("facilityOptionsFeesAndRatesModel"), processor, FacilityOptionsFeesAndRatesModel.class, getFacilityOptionsFeesAndRatesModel());
		processRosetta(path.newSubPath("multiCurrency"), processor, MultiCurrency.class, getMultiCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityGroupBuilder extends FacilityGroup, AbstractFacility.AbstractFacilityBuilder {
		FacilityGroup.FacilityGroupBuilder setId(String id);
		FacilityGroup.FacilityGroupBuilder addInstrumentId(InstrumentId instrumentId0);
		FacilityGroup.FacilityGroupBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		FacilityGroup.FacilityGroupBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		FacilityGroup.FacilityGroupBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		FacilityGroup.FacilityGroupBuilder setDescription(String description);
		FacilityGroup.FacilityGroupBuilder setFacilityRolesModel(FacilityRolesModel facilityRolesModel);
		FacilityGroup.FacilityGroupBuilder setFacilityDatesModel(FacilityDatesModel facilityDatesModel);
		FacilityGroup.FacilityGroupBuilder setFacilityCommitmentModel(FacilityCommitmentModel facilityCommitmentModel);
		FacilityGroup.FacilityGroupBuilder setGoverningLaw(GoverningLaw governingLaw);
		FacilityGroup.FacilityGroupBuilder setFacilityFeaturesModel(FacilityFeaturesModel facilityFeaturesModel);
		FacilityGroup.FacilityGroupBuilder setFacilityOptionsFeesAndRatesModel(FacilityOptionsFeesAndRatesModel facilityOptionsFeesAndRatesModel);
		FacilityGroup.FacilityGroupBuilder setMultiCurrency(MultiCurrency multiCurrency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("facilityRolesModel"), processor, FacilityRolesModel.FacilityRolesModelBuilder.class, getFacilityRolesModel());
			processRosetta(path.newSubPath("facilityDatesModel"), processor, FacilityDatesModel.FacilityDatesModelBuilder.class, getFacilityDatesModel());
			processRosetta(path.newSubPath("facilityCommitmentModel"), processor, FacilityCommitmentModel.FacilityCommitmentModelBuilder.class, getFacilityCommitmentModel());
			processRosetta(path.newSubPath("governingLaw"), processor, GoverningLaw.GoverningLawBuilder.class, getGoverningLaw());
			processRosetta(path.newSubPath("facilityFeaturesModel"), processor, FacilityFeaturesModel.FacilityFeaturesModelBuilder.class, getFacilityFeaturesModel());
			processRosetta(path.newSubPath("facilityOptionsFeesAndRatesModel"), processor, FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder.class, getFacilityOptionsFeesAndRatesModel());
			processRosetta(path.newSubPath("multiCurrency"), processor, MultiCurrency.MultiCurrencyBuilder.class, getMultiCurrency());
		}
		

		FacilityGroup.FacilityGroupBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityGroup  ***********************/
	class FacilityGroupImpl extends AbstractFacility.AbstractFacilityImpl implements FacilityGroup {
		
		protected FacilityGroupImpl(FacilityGroup.FacilityGroupBuilder builder) {
			super(builder);
		}
		
		@Override
		public FacilityGroup build() {
			return this;
		}
		
		@Override
		public FacilityGroup.FacilityGroupBuilder toBuilder() {
			FacilityGroup.FacilityGroupBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityGroup.FacilityGroupBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityGroup {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityGroup  ***********************/
	class FacilityGroupBuilderImpl extends AbstractFacility.AbstractFacilityBuilderImpl  implements FacilityGroup.FacilityGroupBuilder {
	
	
		public FacilityGroupBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public FacilityGroup.FacilityGroupBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public FacilityGroup.FacilityGroupBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public FacilityGroup.FacilityGroupBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public FacilityGroup.FacilityGroupBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FacilityGroup.FacilityGroupBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public FacilityGroup.FacilityGroupBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("facilityRolesModel")
		public FacilityGroup.FacilityGroupBuilder setFacilityRolesModel(FacilityRolesModel facilityRolesModel) {
			this.facilityRolesModel = facilityRolesModel==null?null:facilityRolesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDatesModel")
		public FacilityGroup.FacilityGroupBuilder setFacilityDatesModel(FacilityDatesModel facilityDatesModel) {
			this.facilityDatesModel = facilityDatesModel==null?null:facilityDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityCommitmentModel")
		public FacilityGroup.FacilityGroupBuilder setFacilityCommitmentModel(FacilityCommitmentModel facilityCommitmentModel) {
			this.facilityCommitmentModel = facilityCommitmentModel==null?null:facilityCommitmentModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("governingLaw")
		public FacilityGroup.FacilityGroupBuilder setGoverningLaw(GoverningLaw governingLaw) {
			this.governingLaw = governingLaw==null?null:governingLaw.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityFeaturesModel")
		public FacilityGroup.FacilityGroupBuilder setFacilityFeaturesModel(FacilityFeaturesModel facilityFeaturesModel) {
			this.facilityFeaturesModel = facilityFeaturesModel==null?null:facilityFeaturesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityOptionsFeesAndRatesModel")
		public FacilityGroup.FacilityGroupBuilder setFacilityOptionsFeesAndRatesModel(FacilityOptionsFeesAndRatesModel facilityOptionsFeesAndRatesModel) {
			this.facilityOptionsFeesAndRatesModel = facilityOptionsFeesAndRatesModel==null?null:facilityOptionsFeesAndRatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("multiCurrency")
		public FacilityGroup.FacilityGroupBuilder setMultiCurrency(MultiCurrency multiCurrency) {
			this.multiCurrency = multiCurrency==null?null:multiCurrency.toBuilder();
			return this;
		}
		
		@Override
		public FacilityGroup build() {
			return new FacilityGroup.FacilityGroupImpl(this);
		}
		
		@Override
		public FacilityGroup.FacilityGroupBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityGroup.FacilityGroupBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityGroup.FacilityGroupBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FacilityGroup.FacilityGroupBuilder o = (FacilityGroup.FacilityGroupBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityGroupBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
