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
import fpml.confirmation.TermLoan;
import fpml.confirmation.TermLoan.TermLoanBuilder;
import fpml.confirmation.TermLoan.TermLoanBuilderImpl;
import fpml.confirmation.TermLoan.TermLoanImpl;
import fpml.confirmation.meta.TermLoanMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * A term loan facility. A facility which is fully funded (utilized) at deal closing.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="TermLoan", builder=TermLoan.TermLoanBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface TermLoan extends AbstractFacility {

	TermLoanMeta metaData = new TermLoanMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	TermLoan build();
	
	TermLoan.TermLoanBuilder toBuilder();
	
	static TermLoan.TermLoanBuilder builder() {
		return new TermLoan.TermLoanBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TermLoan> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TermLoan> getType() {
		return TermLoan.class;
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
	interface TermLoanBuilder extends TermLoan, AbstractFacility.AbstractFacilityBuilder {
		TermLoan.TermLoanBuilder setId(String id);
		TermLoan.TermLoanBuilder addInstrumentId(InstrumentId instrumentId0);
		TermLoan.TermLoanBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		TermLoan.TermLoanBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		TermLoan.TermLoanBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		TermLoan.TermLoanBuilder setDescription(String description);
		TermLoan.TermLoanBuilder setFacilityRolesModel(FacilityRolesModel facilityRolesModel);
		TermLoan.TermLoanBuilder setFacilityDatesModel(FacilityDatesModel facilityDatesModel);
		TermLoan.TermLoanBuilder setFacilityCommitmentModel(FacilityCommitmentModel facilityCommitmentModel);
		TermLoan.TermLoanBuilder setGoverningLaw(GoverningLaw governingLaw);
		TermLoan.TermLoanBuilder setFacilityFeaturesModel(FacilityFeaturesModel facilityFeaturesModel);
		TermLoan.TermLoanBuilder setFacilityOptionsFeesAndRatesModel(FacilityOptionsFeesAndRatesModel facilityOptionsFeesAndRatesModel);
		TermLoan.TermLoanBuilder setMultiCurrency(MultiCurrency multiCurrency);

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
		

		TermLoan.TermLoanBuilder prune();
	}

	/*********************** Immutable Implementation of TermLoan  ***********************/
	class TermLoanImpl extends AbstractFacility.AbstractFacilityImpl implements TermLoan {
		
		protected TermLoanImpl(TermLoan.TermLoanBuilder builder) {
			super(builder);
		}
		
		@Override
		public TermLoan build() {
			return this;
		}
		
		@Override
		public TermLoan.TermLoanBuilder toBuilder() {
			TermLoan.TermLoanBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TermLoan.TermLoanBuilder builder) {
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
			return "TermLoan {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TermLoan  ***********************/
	class TermLoanBuilderImpl extends AbstractFacility.AbstractFacilityBuilderImpl  implements TermLoan.TermLoanBuilder {
	
	
		public TermLoanBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public TermLoan.TermLoanBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public TermLoan.TermLoanBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public TermLoan.TermLoanBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public TermLoan.TermLoanBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TermLoan.TermLoanBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public TermLoan.TermLoanBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("facilityRolesModel")
		public TermLoan.TermLoanBuilder setFacilityRolesModel(FacilityRolesModel facilityRolesModel) {
			this.facilityRolesModel = facilityRolesModel==null?null:facilityRolesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDatesModel")
		public TermLoan.TermLoanBuilder setFacilityDatesModel(FacilityDatesModel facilityDatesModel) {
			this.facilityDatesModel = facilityDatesModel==null?null:facilityDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityCommitmentModel")
		public TermLoan.TermLoanBuilder setFacilityCommitmentModel(FacilityCommitmentModel facilityCommitmentModel) {
			this.facilityCommitmentModel = facilityCommitmentModel==null?null:facilityCommitmentModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("governingLaw")
		public TermLoan.TermLoanBuilder setGoverningLaw(GoverningLaw governingLaw) {
			this.governingLaw = governingLaw==null?null:governingLaw.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityFeaturesModel")
		public TermLoan.TermLoanBuilder setFacilityFeaturesModel(FacilityFeaturesModel facilityFeaturesModel) {
			this.facilityFeaturesModel = facilityFeaturesModel==null?null:facilityFeaturesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityOptionsFeesAndRatesModel")
		public TermLoan.TermLoanBuilder setFacilityOptionsFeesAndRatesModel(FacilityOptionsFeesAndRatesModel facilityOptionsFeesAndRatesModel) {
			this.facilityOptionsFeesAndRatesModel = facilityOptionsFeesAndRatesModel==null?null:facilityOptionsFeesAndRatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("multiCurrency")
		public TermLoan.TermLoanBuilder setMultiCurrency(MultiCurrency multiCurrency) {
			this.multiCurrency = multiCurrency==null?null:multiCurrency.toBuilder();
			return this;
		}
		
		@Override
		public TermLoan build() {
			return new TermLoan.TermLoanImpl(this);
		}
		
		@Override
		public TermLoan.TermLoanBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TermLoan.TermLoanBuilder prune() {
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
		public TermLoan.TermLoanBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			TermLoan.TermLoanBuilder o = (TermLoan.TermLoanBuilder) other;
			
			
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
			return "TermLoanBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
