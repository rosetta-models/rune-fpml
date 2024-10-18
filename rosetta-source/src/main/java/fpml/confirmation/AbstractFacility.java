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
import fpml.confirmation.FacilitySummary;
import fpml.confirmation.FacilitySummary.FacilitySummaryBuilder;
import fpml.confirmation.FacilitySummary.FacilitySummaryBuilderImpl;
import fpml.confirmation.FacilitySummary.FacilitySummaryImpl;
import fpml.confirmation.GoverningLaw;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.MultiCurrency;
import fpml.confirmation.meta.AbstractFacilityMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract type defining a facility baseline structure.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractFacility", builder=AbstractFacility.AbstractFacilityBuilderImpl.class, version="${project.version}")
public interface AbstractFacility extends FacilitySummary {

	AbstractFacilityMeta metaData = new AbstractFacilityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the governing law (jurisdiction) under which the facility operates.
	 */
	GoverningLaw getGoverningLaw();
	FacilityFeaturesModel getFacilityFeaturesModel();
	FacilityOptionsFeesAndRatesModel getFacilityOptionsFeesAndRatesModel();
	/**
	 * A container to denote whether funds may be drawn in multiple currency denominations, in addition to the base (facility) currency. The current commitment amount defines the base currency associated with the facility.
	 */
	MultiCurrency getMultiCurrency();

	/*********************** Build Methods  ***********************/
	AbstractFacility build();
	
	AbstractFacility.AbstractFacilityBuilder toBuilder();
	
	static AbstractFacility.AbstractFacilityBuilder builder() {
		return new AbstractFacility.AbstractFacilityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractFacility> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractFacility> getType() {
		return AbstractFacility.class;
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
	interface AbstractFacilityBuilder extends AbstractFacility, FacilitySummary.FacilitySummaryBuilder {
		GoverningLaw.GoverningLawBuilder getOrCreateGoverningLaw();
		GoverningLaw.GoverningLawBuilder getGoverningLaw();
		FacilityFeaturesModel.FacilityFeaturesModelBuilder getOrCreateFacilityFeaturesModel();
		FacilityFeaturesModel.FacilityFeaturesModelBuilder getFacilityFeaturesModel();
		FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder getOrCreateFacilityOptionsFeesAndRatesModel();
		FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder getFacilityOptionsFeesAndRatesModel();
		MultiCurrency.MultiCurrencyBuilder getOrCreateMultiCurrency();
		MultiCurrency.MultiCurrencyBuilder getMultiCurrency();
		AbstractFacility.AbstractFacilityBuilder setId(String id);
		AbstractFacility.AbstractFacilityBuilder addInstrumentId(InstrumentId instrumentId0);
		AbstractFacility.AbstractFacilityBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		AbstractFacility.AbstractFacilityBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		AbstractFacility.AbstractFacilityBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		AbstractFacility.AbstractFacilityBuilder setDescription(String description);
		AbstractFacility.AbstractFacilityBuilder setFacilityRolesModel(FacilityRolesModel facilityRolesModel);
		AbstractFacility.AbstractFacilityBuilder setFacilityDatesModel(FacilityDatesModel facilityDatesModel);
		AbstractFacility.AbstractFacilityBuilder setFacilityCommitmentModel(FacilityCommitmentModel facilityCommitmentModel);
		AbstractFacility.AbstractFacilityBuilder setGoverningLaw(GoverningLaw governingLaw);
		AbstractFacility.AbstractFacilityBuilder setFacilityFeaturesModel(FacilityFeaturesModel facilityFeaturesModel);
		AbstractFacility.AbstractFacilityBuilder setFacilityOptionsFeesAndRatesModel(FacilityOptionsFeesAndRatesModel facilityOptionsFeesAndRatesModel);
		AbstractFacility.AbstractFacilityBuilder setMultiCurrency(MultiCurrency multiCurrency);

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
		

		AbstractFacility.AbstractFacilityBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractFacility  ***********************/
	class AbstractFacilityImpl extends FacilitySummary.FacilitySummaryImpl implements AbstractFacility {
		private final GoverningLaw governingLaw;
		private final FacilityFeaturesModel facilityFeaturesModel;
		private final FacilityOptionsFeesAndRatesModel facilityOptionsFeesAndRatesModel;
		private final MultiCurrency multiCurrency;
		
		protected AbstractFacilityImpl(AbstractFacility.AbstractFacilityBuilder builder) {
			super(builder);
			this.governingLaw = ofNullable(builder.getGoverningLaw()).map(f->f.build()).orElse(null);
			this.facilityFeaturesModel = ofNullable(builder.getFacilityFeaturesModel()).map(f->f.build()).orElse(null);
			this.facilityOptionsFeesAndRatesModel = ofNullable(builder.getFacilityOptionsFeesAndRatesModel()).map(f->f.build()).orElse(null);
			this.multiCurrency = ofNullable(builder.getMultiCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("governingLaw")
		public GoverningLaw getGoverningLaw() {
			return governingLaw;
		}
		
		@Override
		@RosettaAttribute("facilityFeaturesModel")
		public FacilityFeaturesModel getFacilityFeaturesModel() {
			return facilityFeaturesModel;
		}
		
		@Override
		@RosettaAttribute("facilityOptionsFeesAndRatesModel")
		public FacilityOptionsFeesAndRatesModel getFacilityOptionsFeesAndRatesModel() {
			return facilityOptionsFeesAndRatesModel;
		}
		
		@Override
		@RosettaAttribute("multiCurrency")
		public MultiCurrency getMultiCurrency() {
			return multiCurrency;
		}
		
		@Override
		public AbstractFacility build() {
			return this;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder toBuilder() {
			AbstractFacility.AbstractFacilityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractFacility.AbstractFacilityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getGoverningLaw()).ifPresent(builder::setGoverningLaw);
			ofNullable(getFacilityFeaturesModel()).ifPresent(builder::setFacilityFeaturesModel);
			ofNullable(getFacilityOptionsFeesAndRatesModel()).ifPresent(builder::setFacilityOptionsFeesAndRatesModel);
			ofNullable(getMultiCurrency()).ifPresent(builder::setMultiCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacility _that = getType().cast(o);
		
			if (!Objects.equals(governingLaw, _that.getGoverningLaw())) return false;
			if (!Objects.equals(facilityFeaturesModel, _that.getFacilityFeaturesModel())) return false;
			if (!Objects.equals(facilityOptionsFeesAndRatesModel, _that.getFacilityOptionsFeesAndRatesModel())) return false;
			if (!Objects.equals(multiCurrency, _that.getMultiCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (governingLaw != null ? governingLaw.hashCode() : 0);
			_result = 31 * _result + (facilityFeaturesModel != null ? facilityFeaturesModel.hashCode() : 0);
			_result = 31 * _result + (facilityOptionsFeesAndRatesModel != null ? facilityOptionsFeesAndRatesModel.hashCode() : 0);
			_result = 31 * _result + (multiCurrency != null ? multiCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacility {" +
				"governingLaw=" + this.governingLaw + ", " +
				"facilityFeaturesModel=" + this.facilityFeaturesModel + ", " +
				"facilityOptionsFeesAndRatesModel=" + this.facilityOptionsFeesAndRatesModel + ", " +
				"multiCurrency=" + this.multiCurrency +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractFacility  ***********************/
	class AbstractFacilityBuilderImpl extends FacilitySummary.FacilitySummaryBuilderImpl  implements AbstractFacility.AbstractFacilityBuilder {
	
		protected GoverningLaw.GoverningLawBuilder governingLaw;
		protected FacilityFeaturesModel.FacilityFeaturesModelBuilder facilityFeaturesModel;
		protected FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder facilityOptionsFeesAndRatesModel;
		protected MultiCurrency.MultiCurrencyBuilder multiCurrency;
	
		public AbstractFacilityBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("governingLaw")
		public GoverningLaw.GoverningLawBuilder getGoverningLaw() {
			return governingLaw;
		}
		
		@Override
		public GoverningLaw.GoverningLawBuilder getOrCreateGoverningLaw() {
			GoverningLaw.GoverningLawBuilder result;
			if (governingLaw!=null) {
				result = governingLaw;
			}
			else {
				result = governingLaw = GoverningLaw.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityFeaturesModel")
		public FacilityFeaturesModel.FacilityFeaturesModelBuilder getFacilityFeaturesModel() {
			return facilityFeaturesModel;
		}
		
		@Override
		public FacilityFeaturesModel.FacilityFeaturesModelBuilder getOrCreateFacilityFeaturesModel() {
			FacilityFeaturesModel.FacilityFeaturesModelBuilder result;
			if (facilityFeaturesModel!=null) {
				result = facilityFeaturesModel;
			}
			else {
				result = facilityFeaturesModel = FacilityFeaturesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityOptionsFeesAndRatesModel")
		public FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder getFacilityOptionsFeesAndRatesModel() {
			return facilityOptionsFeesAndRatesModel;
		}
		
		@Override
		public FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder getOrCreateFacilityOptionsFeesAndRatesModel() {
			FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder result;
			if (facilityOptionsFeesAndRatesModel!=null) {
				result = facilityOptionsFeesAndRatesModel;
			}
			else {
				result = facilityOptionsFeesAndRatesModel = FacilityOptionsFeesAndRatesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("multiCurrency")
		public MultiCurrency.MultiCurrencyBuilder getMultiCurrency() {
			return multiCurrency;
		}
		
		@Override
		public MultiCurrency.MultiCurrencyBuilder getOrCreateMultiCurrency() {
			MultiCurrency.MultiCurrencyBuilder result;
			if (multiCurrency!=null) {
				result = multiCurrency;
			}
			else {
				result = multiCurrency = MultiCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public AbstractFacility.AbstractFacilityBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public AbstractFacility.AbstractFacilityBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public AbstractFacility.AbstractFacilityBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AbstractFacility.AbstractFacilityBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public AbstractFacility.AbstractFacilityBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("facilityRolesModel")
		public AbstractFacility.AbstractFacilityBuilder setFacilityRolesModel(FacilityRolesModel facilityRolesModel) {
			this.facilityRolesModel = facilityRolesModel==null?null:facilityRolesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDatesModel")
		public AbstractFacility.AbstractFacilityBuilder setFacilityDatesModel(FacilityDatesModel facilityDatesModel) {
			this.facilityDatesModel = facilityDatesModel==null?null:facilityDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityCommitmentModel")
		public AbstractFacility.AbstractFacilityBuilder setFacilityCommitmentModel(FacilityCommitmentModel facilityCommitmentModel) {
			this.facilityCommitmentModel = facilityCommitmentModel==null?null:facilityCommitmentModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("governingLaw")
		public AbstractFacility.AbstractFacilityBuilder setGoverningLaw(GoverningLaw governingLaw) {
			this.governingLaw = governingLaw==null?null:governingLaw.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityFeaturesModel")
		public AbstractFacility.AbstractFacilityBuilder setFacilityFeaturesModel(FacilityFeaturesModel facilityFeaturesModel) {
			this.facilityFeaturesModel = facilityFeaturesModel==null?null:facilityFeaturesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityOptionsFeesAndRatesModel")
		public AbstractFacility.AbstractFacilityBuilder setFacilityOptionsFeesAndRatesModel(FacilityOptionsFeesAndRatesModel facilityOptionsFeesAndRatesModel) {
			this.facilityOptionsFeesAndRatesModel = facilityOptionsFeesAndRatesModel==null?null:facilityOptionsFeesAndRatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("multiCurrency")
		public AbstractFacility.AbstractFacilityBuilder setMultiCurrency(MultiCurrency multiCurrency) {
			this.multiCurrency = multiCurrency==null?null:multiCurrency.toBuilder();
			return this;
		}
		
		@Override
		public AbstractFacility build() {
			return new AbstractFacility.AbstractFacilityImpl(this);
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacility.AbstractFacilityBuilder prune() {
			super.prune();
			if (governingLaw!=null && !governingLaw.prune().hasData()) governingLaw = null;
			if (facilityFeaturesModel!=null && !facilityFeaturesModel.prune().hasData()) facilityFeaturesModel = null;
			if (facilityOptionsFeesAndRatesModel!=null && !facilityOptionsFeesAndRatesModel.prune().hasData()) facilityOptionsFeesAndRatesModel = null;
			if (multiCurrency!=null && !multiCurrency.prune().hasData()) multiCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getGoverningLaw()!=null && getGoverningLaw().hasData()) return true;
			if (getFacilityFeaturesModel()!=null && getFacilityFeaturesModel().hasData()) return true;
			if (getFacilityOptionsFeesAndRatesModel()!=null && getFacilityOptionsFeesAndRatesModel().hasData()) return true;
			if (getMultiCurrency()!=null && getMultiCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacility.AbstractFacilityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractFacility.AbstractFacilityBuilder o = (AbstractFacility.AbstractFacilityBuilder) other;
			
			merger.mergeRosetta(getGoverningLaw(), o.getGoverningLaw(), this::setGoverningLaw);
			merger.mergeRosetta(getFacilityFeaturesModel(), o.getFacilityFeaturesModel(), this::setFacilityFeaturesModel);
			merger.mergeRosetta(getFacilityOptionsFeesAndRatesModel(), o.getFacilityOptionsFeesAndRatesModel(), this::setFacilityOptionsFeesAndRatesModel);
			merger.mergeRosetta(getMultiCurrency(), o.getMultiCurrency(), this::setMultiCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacility _that = getType().cast(o);
		
			if (!Objects.equals(governingLaw, _that.getGoverningLaw())) return false;
			if (!Objects.equals(facilityFeaturesModel, _that.getFacilityFeaturesModel())) return false;
			if (!Objects.equals(facilityOptionsFeesAndRatesModel, _that.getFacilityOptionsFeesAndRatesModel())) return false;
			if (!Objects.equals(multiCurrency, _that.getMultiCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (governingLaw != null ? governingLaw.hashCode() : 0);
			_result = 31 * _result + (facilityFeaturesModel != null ? facilityFeaturesModel.hashCode() : 0);
			_result = 31 * _result + (facilityOptionsFeesAndRatesModel != null ? facilityOptionsFeesAndRatesModel.hashCode() : 0);
			_result = 31 * _result + (multiCurrency != null ? multiCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityBuilder {" +
				"governingLaw=" + this.governingLaw + ", " +
				"facilityFeaturesModel=" + this.facilityFeaturesModel + ", " +
				"facilityOptionsFeesAndRatesModel=" + this.facilityOptionsFeesAndRatesModel + ", " +
				"multiCurrency=" + this.multiCurrency +
			'}' + " " + super.toString();
		}
	}
}
