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
import fpml.confirmation.FacilityOptionsFeesAndRatesModel;
import fpml.confirmation.FacilityRolesModel;
import fpml.confirmation.GoverningLaw;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.LetterOfCreditFacility;
import fpml.confirmation.LetterOfCreditFacility.LetterOfCreditFacilityBuilder;
import fpml.confirmation.LetterOfCreditFacility.LetterOfCreditFacilityBuilderImpl;
import fpml.confirmation.LetterOfCreditFacility.LetterOfCreditFacilityImpl;
import fpml.confirmation.MultiCurrency;
import fpml.confirmation.meta.LetterOfCreditFacilityMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * A letter of credit facility. A facility designed to issue letter of credit products.
 * @version ${project.version}
 */
@RosettaDataType(value="LetterOfCreditFacility", builder=LetterOfCreditFacility.LetterOfCreditFacilityBuilderImpl.class, version="${project.version}")
public interface LetterOfCreditFacility extends AbstractFacility {

	LetterOfCreditFacilityMeta metaData = new LetterOfCreditFacilityMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	LetterOfCreditFacility build();
	
	LetterOfCreditFacility.LetterOfCreditFacilityBuilder toBuilder();
	
	static LetterOfCreditFacility.LetterOfCreditFacilityBuilder builder() {
		return new LetterOfCreditFacility.LetterOfCreditFacilityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LetterOfCreditFacility> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LetterOfCreditFacility> getType() {
		return LetterOfCreditFacility.class;
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
	interface LetterOfCreditFacilityBuilder extends LetterOfCreditFacility, AbstractFacility.AbstractFacilityBuilder {
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setId(String id);
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addInstrumentId(InstrumentId instrumentId0);
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setDescription(String description);
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setFacilityRolesModel(FacilityRolesModel facilityRolesModel);
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setFacilityDatesModel(FacilityDatesModel facilityDatesModel);
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setFacilityCommitmentModel(FacilityCommitmentModel facilityCommitmentModel);
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setGoverningLaw(GoverningLaw governingLaw);
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setFacilityFeaturesModel(FacilityFeaturesModel facilityFeaturesModel);
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setFacilityOptionsFeesAndRatesModel(FacilityOptionsFeesAndRatesModel facilityOptionsFeesAndRatesModel);
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setMultiCurrency(MultiCurrency multiCurrency);

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
		

		LetterOfCreditFacility.LetterOfCreditFacilityBuilder prune();
	}

	/*********************** Immutable Implementation of LetterOfCreditFacility  ***********************/
	class LetterOfCreditFacilityImpl extends AbstractFacility.AbstractFacilityImpl implements LetterOfCreditFacility {
		
		protected LetterOfCreditFacilityImpl(LetterOfCreditFacility.LetterOfCreditFacilityBuilder builder) {
			super(builder);
		}
		
		@Override
		public LetterOfCreditFacility build() {
			return this;
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder toBuilder() {
			LetterOfCreditFacility.LetterOfCreditFacilityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LetterOfCreditFacility.LetterOfCreditFacilityBuilder builder) {
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
			return "LetterOfCreditFacility {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LetterOfCreditFacility  ***********************/
	class LetterOfCreditFacilityBuilderImpl extends AbstractFacility.AbstractFacilityBuilderImpl  implements LetterOfCreditFacility.LetterOfCreditFacilityBuilder {
	
	
		public LetterOfCreditFacilityBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("facilityRolesModel")
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setFacilityRolesModel(FacilityRolesModel facilityRolesModel) {
			this.facilityRolesModel = facilityRolesModel==null?null:facilityRolesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDatesModel")
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setFacilityDatesModel(FacilityDatesModel facilityDatesModel) {
			this.facilityDatesModel = facilityDatesModel==null?null:facilityDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityCommitmentModel")
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setFacilityCommitmentModel(FacilityCommitmentModel facilityCommitmentModel) {
			this.facilityCommitmentModel = facilityCommitmentModel==null?null:facilityCommitmentModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("governingLaw")
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setGoverningLaw(GoverningLaw governingLaw) {
			this.governingLaw = governingLaw==null?null:governingLaw.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityFeaturesModel")
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setFacilityFeaturesModel(FacilityFeaturesModel facilityFeaturesModel) {
			this.facilityFeaturesModel = facilityFeaturesModel==null?null:facilityFeaturesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityOptionsFeesAndRatesModel")
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setFacilityOptionsFeesAndRatesModel(FacilityOptionsFeesAndRatesModel facilityOptionsFeesAndRatesModel) {
			this.facilityOptionsFeesAndRatesModel = facilityOptionsFeesAndRatesModel==null?null:facilityOptionsFeesAndRatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("multiCurrency")
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setMultiCurrency(MultiCurrency multiCurrency) {
			this.multiCurrency = multiCurrency==null?null:multiCurrency.toBuilder();
			return this;
		}
		
		@Override
		public LetterOfCreditFacility build() {
			return new LetterOfCreditFacility.LetterOfCreditFacilityImpl(this);
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder prune() {
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
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LetterOfCreditFacility.LetterOfCreditFacilityBuilder o = (LetterOfCreditFacility.LetterOfCreditFacilityBuilder) other;
			
			
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
			return "LetterOfCreditFacilityBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
