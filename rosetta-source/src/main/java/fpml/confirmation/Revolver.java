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
import fpml.confirmation.MultiCurrency;
import fpml.confirmation.Revolver;
import fpml.confirmation.Revolver.RevolverBuilder;
import fpml.confirmation.Revolver.RevolverBuilderImpl;
import fpml.confirmation.Revolver.RevolverImpl;
import fpml.confirmation.meta.RevolverMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * A revolver facility. A facility which allows a flexible line of credit which can be drawn and repaid multiple times over the life of the facility.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Revolver", builder=Revolver.RevolverBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Revolver extends AbstractFacility {

	RevolverMeta metaData = new RevolverMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Revolver build();
	
	Revolver.RevolverBuilder toBuilder();
	
	static Revolver.RevolverBuilder builder() {
		return new Revolver.RevolverBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Revolver> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Revolver> getType() {
		return Revolver.class;
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
	interface RevolverBuilder extends Revolver, AbstractFacility.AbstractFacilityBuilder {
		Revolver.RevolverBuilder setId(String id);
		Revolver.RevolverBuilder addInstrumentId(InstrumentId instrumentId0);
		Revolver.RevolverBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		Revolver.RevolverBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		Revolver.RevolverBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		Revolver.RevolverBuilder setDescription(String description);
		Revolver.RevolverBuilder setFacilityRolesModel(FacilityRolesModel facilityRolesModel);
		Revolver.RevolverBuilder setFacilityDatesModel(FacilityDatesModel facilityDatesModel);
		Revolver.RevolverBuilder setFacilityCommitmentModel(FacilityCommitmentModel facilityCommitmentModel);
		Revolver.RevolverBuilder setGoverningLaw(GoverningLaw governingLaw);
		Revolver.RevolverBuilder setFacilityFeaturesModel(FacilityFeaturesModel facilityFeaturesModel);
		Revolver.RevolverBuilder setFacilityOptionsFeesAndRatesModel(FacilityOptionsFeesAndRatesModel facilityOptionsFeesAndRatesModel);
		Revolver.RevolverBuilder setMultiCurrency(MultiCurrency multiCurrency);

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
		

		Revolver.RevolverBuilder prune();
	}

	/*********************** Immutable Implementation of Revolver  ***********************/
	class RevolverImpl extends AbstractFacility.AbstractFacilityImpl implements Revolver {
		
		protected RevolverImpl(Revolver.RevolverBuilder builder) {
			super(builder);
		}
		
		@Override
		public Revolver build() {
			return this;
		}
		
		@Override
		public Revolver.RevolverBuilder toBuilder() {
			Revolver.RevolverBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Revolver.RevolverBuilder builder) {
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
			return "Revolver {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Revolver  ***********************/
	class RevolverBuilderImpl extends AbstractFacility.AbstractFacilityBuilderImpl  implements Revolver.RevolverBuilder {
	
	
		public RevolverBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public Revolver.RevolverBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public Revolver.RevolverBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Revolver.RevolverBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public Revolver.RevolverBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Revolver.RevolverBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Revolver.RevolverBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("facilityRolesModel")
		public Revolver.RevolverBuilder setFacilityRolesModel(FacilityRolesModel facilityRolesModel) {
			this.facilityRolesModel = facilityRolesModel==null?null:facilityRolesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDatesModel")
		public Revolver.RevolverBuilder setFacilityDatesModel(FacilityDatesModel facilityDatesModel) {
			this.facilityDatesModel = facilityDatesModel==null?null:facilityDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityCommitmentModel")
		public Revolver.RevolverBuilder setFacilityCommitmentModel(FacilityCommitmentModel facilityCommitmentModel) {
			this.facilityCommitmentModel = facilityCommitmentModel==null?null:facilityCommitmentModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("governingLaw")
		public Revolver.RevolverBuilder setGoverningLaw(GoverningLaw governingLaw) {
			this.governingLaw = governingLaw==null?null:governingLaw.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityFeaturesModel")
		public Revolver.RevolverBuilder setFacilityFeaturesModel(FacilityFeaturesModel facilityFeaturesModel) {
			this.facilityFeaturesModel = facilityFeaturesModel==null?null:facilityFeaturesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityOptionsFeesAndRatesModel")
		public Revolver.RevolverBuilder setFacilityOptionsFeesAndRatesModel(FacilityOptionsFeesAndRatesModel facilityOptionsFeesAndRatesModel) {
			this.facilityOptionsFeesAndRatesModel = facilityOptionsFeesAndRatesModel==null?null:facilityOptionsFeesAndRatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("multiCurrency")
		public Revolver.RevolverBuilder setMultiCurrency(MultiCurrency multiCurrency) {
			this.multiCurrency = multiCurrency==null?null:multiCurrency.toBuilder();
			return this;
		}
		
		@Override
		public Revolver build() {
			return new Revolver.RevolverImpl(this);
		}
		
		@Override
		public Revolver.RevolverBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Revolver.RevolverBuilder prune() {
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
		public Revolver.RevolverBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Revolver.RevolverBuilder o = (Revolver.RevolverBuilder) other;
			
			
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
			return "RevolverBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
