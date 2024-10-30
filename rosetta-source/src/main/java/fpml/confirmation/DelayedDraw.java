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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.AbstractFacility;
import fpml.confirmation.AbstractFacility.AbstractFacilityBuilder;
import fpml.confirmation.AbstractFacility.AbstractFacilityBuilderImpl;
import fpml.confirmation.AbstractFacility.AbstractFacilityImpl;
import fpml.confirmation.DelayedDraw;
import fpml.confirmation.DelayedDraw.DelayedDrawBuilder;
import fpml.confirmation.DelayedDraw.DelayedDrawBuilderImpl;
import fpml.confirmation.DelayedDraw.DelayedDrawImpl;
import fpml.confirmation.FacilityCommitmentModel;
import fpml.confirmation.FacilityDatesModel;
import fpml.confirmation.FacilityFeaturesModel;
import fpml.confirmation.FacilityOptionsFeesAndRatesModel;
import fpml.confirmation.FacilityRolesModel;
import fpml.confirmation.GoverningLaw;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.MultiCurrency;
import fpml.confirmation.meta.DelayedDrawMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A revolver facility. A facility which can be drawn at any point during a pre-defined period after the initial deal closing date,
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="DelayedDraw", builder=DelayedDraw.DelayedDrawBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface DelayedDraw extends AbstractFacility {

	DelayedDrawMeta metaData = new DelayedDrawMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A flag to determine whether the Term Loan has a delayed draw feature.
	 */
	Boolean getDelayedDraw();
	/**
	 * The date by which funds must be drawn.
	 */
	Date getMustDrawByDate();

	/*********************** Build Methods  ***********************/
	DelayedDraw build();
	
	DelayedDraw.DelayedDrawBuilder toBuilder();
	
	static DelayedDraw.DelayedDrawBuilder builder() {
		return new DelayedDraw.DelayedDrawBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DelayedDraw> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DelayedDraw> getType() {
		return DelayedDraw.class;
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
		processor.processBasic(path.newSubPath("delayedDraw"), Boolean.class, getDelayedDraw(), this);
		processor.processBasic(path.newSubPath("mustDrawByDate"), Date.class, getMustDrawByDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DelayedDrawBuilder extends DelayedDraw, AbstractFacility.AbstractFacilityBuilder {
		DelayedDraw.DelayedDrawBuilder setId(String id);
		DelayedDraw.DelayedDrawBuilder addInstrumentId(InstrumentId instrumentId0);
		DelayedDraw.DelayedDrawBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		DelayedDraw.DelayedDrawBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		DelayedDraw.DelayedDrawBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		DelayedDraw.DelayedDrawBuilder setDescription(String description);
		DelayedDraw.DelayedDrawBuilder setFacilityRolesModel(FacilityRolesModel facilityRolesModel);
		DelayedDraw.DelayedDrawBuilder setFacilityDatesModel(FacilityDatesModel facilityDatesModel);
		DelayedDraw.DelayedDrawBuilder setFacilityCommitmentModel(FacilityCommitmentModel facilityCommitmentModel);
		DelayedDraw.DelayedDrawBuilder setGoverningLaw(GoverningLaw governingLaw);
		DelayedDraw.DelayedDrawBuilder setFacilityFeaturesModel(FacilityFeaturesModel facilityFeaturesModel);
		DelayedDraw.DelayedDrawBuilder setFacilityOptionsFeesAndRatesModel(FacilityOptionsFeesAndRatesModel facilityOptionsFeesAndRatesModel);
		DelayedDraw.DelayedDrawBuilder setMultiCurrency(MultiCurrency multiCurrency);
		DelayedDraw.DelayedDrawBuilder setDelayedDraw(Boolean delayedDraw);
		DelayedDraw.DelayedDrawBuilder setMustDrawByDate(Date mustDrawByDate);

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
			processor.processBasic(path.newSubPath("delayedDraw"), Boolean.class, getDelayedDraw(), this);
			processor.processBasic(path.newSubPath("mustDrawByDate"), Date.class, getMustDrawByDate(), this);
		}
		

		DelayedDraw.DelayedDrawBuilder prune();
	}

	/*********************** Immutable Implementation of DelayedDraw  ***********************/
	class DelayedDrawImpl extends AbstractFacility.AbstractFacilityImpl implements DelayedDraw {
		private final Boolean delayedDraw;
		private final Date mustDrawByDate;
		
		protected DelayedDrawImpl(DelayedDraw.DelayedDrawBuilder builder) {
			super(builder);
			this.delayedDraw = builder.getDelayedDraw();
			this.mustDrawByDate = builder.getMustDrawByDate();
		}
		
		@Override
		@RosettaAttribute("delayedDraw")
		public Boolean getDelayedDraw() {
			return delayedDraw;
		}
		
		@Override
		@RosettaAttribute("mustDrawByDate")
		public Date getMustDrawByDate() {
			return mustDrawByDate;
		}
		
		@Override
		public DelayedDraw build() {
			return this;
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder toBuilder() {
			DelayedDraw.DelayedDrawBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DelayedDraw.DelayedDrawBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDelayedDraw()).ifPresent(builder::setDelayedDraw);
			ofNullable(getMustDrawByDate()).ifPresent(builder::setMustDrawByDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DelayedDraw _that = getType().cast(o);
		
			if (!Objects.equals(delayedDraw, _that.getDelayedDraw())) return false;
			if (!Objects.equals(mustDrawByDate, _that.getMustDrawByDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (delayedDraw != null ? delayedDraw.hashCode() : 0);
			_result = 31 * _result + (mustDrawByDate != null ? mustDrawByDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DelayedDraw {" +
				"delayedDraw=" + this.delayedDraw + ", " +
				"mustDrawByDate=" + this.mustDrawByDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DelayedDraw  ***********************/
	class DelayedDrawBuilderImpl extends AbstractFacility.AbstractFacilityBuilderImpl  implements DelayedDraw.DelayedDrawBuilder {
	
		protected Boolean delayedDraw;
		protected Date mustDrawByDate;
	
		public DelayedDrawBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("delayedDraw")
		public Boolean getDelayedDraw() {
			return delayedDraw;
		}
		
		@Override
		@RosettaAttribute("mustDrawByDate")
		public Date getMustDrawByDate() {
			return mustDrawByDate;
		}
		
		@Override
		@RosettaAttribute("id")
		public DelayedDraw.DelayedDrawBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public DelayedDraw.DelayedDrawBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public DelayedDraw.DelayedDrawBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DelayedDraw.DelayedDrawBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public DelayedDraw.DelayedDrawBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("facilityRolesModel")
		public DelayedDraw.DelayedDrawBuilder setFacilityRolesModel(FacilityRolesModel facilityRolesModel) {
			this.facilityRolesModel = facilityRolesModel==null?null:facilityRolesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDatesModel")
		public DelayedDraw.DelayedDrawBuilder setFacilityDatesModel(FacilityDatesModel facilityDatesModel) {
			this.facilityDatesModel = facilityDatesModel==null?null:facilityDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityCommitmentModel")
		public DelayedDraw.DelayedDrawBuilder setFacilityCommitmentModel(FacilityCommitmentModel facilityCommitmentModel) {
			this.facilityCommitmentModel = facilityCommitmentModel==null?null:facilityCommitmentModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("governingLaw")
		public DelayedDraw.DelayedDrawBuilder setGoverningLaw(GoverningLaw governingLaw) {
			this.governingLaw = governingLaw==null?null:governingLaw.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityFeaturesModel")
		public DelayedDraw.DelayedDrawBuilder setFacilityFeaturesModel(FacilityFeaturesModel facilityFeaturesModel) {
			this.facilityFeaturesModel = facilityFeaturesModel==null?null:facilityFeaturesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityOptionsFeesAndRatesModel")
		public DelayedDraw.DelayedDrawBuilder setFacilityOptionsFeesAndRatesModel(FacilityOptionsFeesAndRatesModel facilityOptionsFeesAndRatesModel) {
			this.facilityOptionsFeesAndRatesModel = facilityOptionsFeesAndRatesModel==null?null:facilityOptionsFeesAndRatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("multiCurrency")
		public DelayedDraw.DelayedDrawBuilder setMultiCurrency(MultiCurrency multiCurrency) {
			this.multiCurrency = multiCurrency==null?null:multiCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("delayedDraw")
		public DelayedDraw.DelayedDrawBuilder setDelayedDraw(Boolean delayedDraw) {
			this.delayedDraw = delayedDraw==null?null:delayedDraw;
			return this;
		}
		@Override
		@RosettaAttribute("mustDrawByDate")
		public DelayedDraw.DelayedDrawBuilder setMustDrawByDate(Date mustDrawByDate) {
			this.mustDrawByDate = mustDrawByDate==null?null:mustDrawByDate;
			return this;
		}
		
		@Override
		public DelayedDraw build() {
			return new DelayedDraw.DelayedDrawImpl(this);
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DelayedDraw.DelayedDrawBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDelayedDraw()!=null) return true;
			if (getMustDrawByDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DelayedDraw.DelayedDrawBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DelayedDraw.DelayedDrawBuilder o = (DelayedDraw.DelayedDrawBuilder) other;
			
			
			merger.mergeBasic(getDelayedDraw(), o.getDelayedDraw(), this::setDelayedDraw);
			merger.mergeBasic(getMustDrawByDate(), o.getMustDrawByDate(), this::setMustDrawByDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DelayedDraw _that = getType().cast(o);
		
			if (!Objects.equals(delayedDraw, _that.getDelayedDraw())) return false;
			if (!Objects.equals(mustDrawByDate, _that.getMustDrawByDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (delayedDraw != null ? delayedDraw.hashCode() : 0);
			_result = 31 * _result + (mustDrawByDate != null ? mustDrawByDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DelayedDrawBuilder {" +
				"delayedDraw=" + this.delayedDraw + ", " +
				"mustDrawByDate=" + this.mustDrawByDate +
			'}' + " " + super.toString();
		}
	}
}
