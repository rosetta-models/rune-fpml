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
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.BusinessDayConventionEnum;
import fpml.confirmation.DateRelativeToCalculationPeriodDates;
import fpml.confirmation.DateRelativeToPaymentDates;
import fpml.confirmation.DayTypeEnum;
import fpml.confirmation.FxFixingDate;
import fpml.confirmation.FxFixingDate.FxFixingDateBuilder;
import fpml.confirmation.FxFixingDate.FxFixingDateBuilderImpl;
import fpml.confirmation.FxFixingDate.FxFixingDateImpl;
import fpml.confirmation.Offset;
import fpml.confirmation.Offset.OffsetBuilder;
import fpml.confirmation.Offset.OffsetBuilderImpl;
import fpml.confirmation.Offset.OffsetImpl;
import fpml.confirmation.PeriodEnum;
import fpml.confirmation.meta.FxFixingDateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that is extending the Offset structure for providing the ability to specify an FX fixing date as an offset to dates specified somewhere else in the document.
 * @version ${project.version}
 */
@RosettaDataType(value="FxFixingDate", builder=FxFixingDate.FxFixingDateBuilderImpl.class, version="${project.version}")
public interface FxFixingDate extends Offset {

	FxFixingDateMeta metaData = new FxFixingDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The convention for adjusting a date if it would otherwise fall on a day that is not a business day.
	 */
	BusinessDayConventionEnum getBusinessDayConvention();
	BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel();
	/**
	 * The payment date references on which settlements in non-deliverable currency are due and will then have to be converted according to the terms specified through the other parts of the nonDeliverableSettlement structure.
	 */
	DateRelativeToPaymentDates getDateRelativeToPaymentDates();
	/**
	 * The calculation period references on which settlements in non-deliverable currency are due and will then have to be converted according to the terms specified through the other parts of the nonDeliverableSettlement structure. Implemented for Brazilian-CDI swaps where it will refer to the termination date of the appropriate leg.
	 */
	DateRelativeToCalculationPeriodDates getDateRelativeToCalculationPeriodDates();

	/*********************** Build Methods  ***********************/
	FxFixingDate build();
	
	FxFixingDate.FxFixingDateBuilder toBuilder();
	
	static FxFixingDate.FxFixingDateBuilder builder() {
		return new FxFixingDate.FxFixingDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFixingDate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxFixingDate> getType() {
		return FxFixingDate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.class, getBusinessCentersOrReferenceModel());
		processRosetta(path.newSubPath("dateRelativeToPaymentDates"), processor, DateRelativeToPaymentDates.class, getDateRelativeToPaymentDates());
		processRosetta(path.newSubPath("dateRelativeToCalculationPeriodDates"), processor, DateRelativeToCalculationPeriodDates.class, getDateRelativeToCalculationPeriodDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFixingDateBuilder extends FxFixingDate, Offset.OffsetBuilder {
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel();
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder getOrCreateDateRelativeToPaymentDates();
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder getDateRelativeToPaymentDates();
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder getOrCreateDateRelativeToCalculationPeriodDates();
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder getDateRelativeToCalculationPeriodDates();
		FxFixingDate.FxFixingDateBuilder setPeriodMultiplier(Integer periodMultiplier);
		FxFixingDate.FxFixingDateBuilder setPeriod(PeriodEnum period);
		FxFixingDate.FxFixingDateBuilder setId(String id);
		FxFixingDate.FxFixingDateBuilder setDayType(DayTypeEnum dayType);
		FxFixingDate.FxFixingDateBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		FxFixingDate.FxFixingDateBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel);
		FxFixingDate.FxFixingDateBuilder setDateRelativeToPaymentDates(DateRelativeToPaymentDates dateRelativeToPaymentDates);
		FxFixingDate.FxFixingDateBuilder setDateRelativeToCalculationPeriodDates(DateRelativeToCalculationPeriodDates dateRelativeToCalculationPeriodDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder.class, getBusinessCentersOrReferenceModel());
			processRosetta(path.newSubPath("dateRelativeToPaymentDates"), processor, DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder.class, getDateRelativeToPaymentDates());
			processRosetta(path.newSubPath("dateRelativeToCalculationPeriodDates"), processor, DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder.class, getDateRelativeToCalculationPeriodDates());
		}
		

		FxFixingDate.FxFixingDateBuilder prune();
	}

	/*********************** Immutable Implementation of FxFixingDate  ***********************/
	class FxFixingDateImpl extends Offset.OffsetImpl implements FxFixingDate {
		private final BusinessDayConventionEnum businessDayConvention;
		private final BusinessCentersOrReferenceModel businessCentersOrReferenceModel;
		private final DateRelativeToPaymentDates dateRelativeToPaymentDates;
		private final DateRelativeToCalculationPeriodDates dateRelativeToCalculationPeriodDates;
		
		protected FxFixingDateImpl(FxFixingDate.FxFixingDateBuilder builder) {
			super(builder);
			this.businessDayConvention = builder.getBusinessDayConvention();
			this.businessCentersOrReferenceModel = ofNullable(builder.getBusinessCentersOrReferenceModel()).map(f->f.build()).orElse(null);
			this.dateRelativeToPaymentDates = ofNullable(builder.getDateRelativeToPaymentDates()).map(f->f.build()).orElse(null);
			this.dateRelativeToCalculationPeriodDates = ofNullable(builder.getDateRelativeToCalculationPeriodDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel() {
			return businessCentersOrReferenceModel;
		}
		
		@Override
		@RosettaAttribute("dateRelativeToPaymentDates")
		public DateRelativeToPaymentDates getDateRelativeToPaymentDates() {
			return dateRelativeToPaymentDates;
		}
		
		@Override
		@RosettaAttribute("dateRelativeToCalculationPeriodDates")
		public DateRelativeToCalculationPeriodDates getDateRelativeToCalculationPeriodDates() {
			return dateRelativeToCalculationPeriodDates;
		}
		
		@Override
		public FxFixingDate build() {
			return this;
		}
		
		@Override
		public FxFixingDate.FxFixingDateBuilder toBuilder() {
			FxFixingDate.FxFixingDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFixingDate.FxFixingDateBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
			ofNullable(getBusinessCentersOrReferenceModel()).ifPresent(builder::setBusinessCentersOrReferenceModel);
			ofNullable(getDateRelativeToPaymentDates()).ifPresent(builder::setDateRelativeToPaymentDates);
			ofNullable(getDateRelativeToCalculationPeriodDates()).ifPresent(builder::setDateRelativeToCalculationPeriodDates);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFixingDate _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			if (!Objects.equals(dateRelativeToPaymentDates, _that.getDateRelativeToPaymentDates())) return false;
			if (!Objects.equals(dateRelativeToCalculationPeriodDates, _that.getDateRelativeToCalculationPeriodDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (dateRelativeToPaymentDates != null ? dateRelativeToPaymentDates.hashCode() : 0);
			_result = 31 * _result + (dateRelativeToCalculationPeriodDates != null ? dateRelativeToCalculationPeriodDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingDate {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel + ", " +
				"dateRelativeToPaymentDates=" + this.dateRelativeToPaymentDates + ", " +
				"dateRelativeToCalculationPeriodDates=" + this.dateRelativeToCalculationPeriodDates +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxFixingDate  ***********************/
	class FxFixingDateBuilderImpl extends Offset.OffsetBuilderImpl  implements FxFixingDate.FxFixingDateBuilder {
	
		protected BusinessDayConventionEnum businessDayConvention;
		protected BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder businessCentersOrReferenceModel;
		protected DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder dateRelativeToPaymentDates;
		protected DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder dateRelativeToCalculationPeriodDates;
	
		public FxFixingDateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel() {
			return businessCentersOrReferenceModel;
		}
		
		@Override
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel() {
			BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder result;
			if (businessCentersOrReferenceModel!=null) {
				result = businessCentersOrReferenceModel;
			}
			else {
				result = businessCentersOrReferenceModel = BusinessCentersOrReferenceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dateRelativeToPaymentDates")
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder getDateRelativeToPaymentDates() {
			return dateRelativeToPaymentDates;
		}
		
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder getOrCreateDateRelativeToPaymentDates() {
			DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder result;
			if (dateRelativeToPaymentDates!=null) {
				result = dateRelativeToPaymentDates;
			}
			else {
				result = dateRelativeToPaymentDates = DateRelativeToPaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dateRelativeToCalculationPeriodDates")
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder getDateRelativeToCalculationPeriodDates() {
			return dateRelativeToCalculationPeriodDates;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder getOrCreateDateRelativeToCalculationPeriodDates() {
			DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder result;
			if (dateRelativeToCalculationPeriodDates!=null) {
				result = dateRelativeToCalculationPeriodDates;
			}
			else {
				result = dateRelativeToCalculationPeriodDates = DateRelativeToCalculationPeriodDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		public FxFixingDate.FxFixingDateBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		@Override
		@RosettaAttribute("period")
		public FxFixingDate.FxFixingDateBuilder setPeriod(PeriodEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxFixingDate.FxFixingDateBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("dayType")
		public FxFixingDate.FxFixingDateBuilder setDayType(DayTypeEnum dayType) {
			this.dayType = dayType==null?null:dayType;
			return this;
		}
		@Override
		@RosettaAttribute("businessDayConvention")
		public FxFixingDate.FxFixingDateBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention) {
			this.businessDayConvention = businessDayConvention==null?null:businessDayConvention;
			return this;
		}
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public FxFixingDate.FxFixingDateBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel) {
			this.businessCentersOrReferenceModel = businessCentersOrReferenceModel==null?null:businessCentersOrReferenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dateRelativeToPaymentDates")
		public FxFixingDate.FxFixingDateBuilder setDateRelativeToPaymentDates(DateRelativeToPaymentDates dateRelativeToPaymentDates) {
			this.dateRelativeToPaymentDates = dateRelativeToPaymentDates==null?null:dateRelativeToPaymentDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dateRelativeToCalculationPeriodDates")
		public FxFixingDate.FxFixingDateBuilder setDateRelativeToCalculationPeriodDates(DateRelativeToCalculationPeriodDates dateRelativeToCalculationPeriodDates) {
			this.dateRelativeToCalculationPeriodDates = dateRelativeToCalculationPeriodDates==null?null:dateRelativeToCalculationPeriodDates.toBuilder();
			return this;
		}
		
		@Override
		public FxFixingDate build() {
			return new FxFixingDate.FxFixingDateImpl(this);
		}
		
		@Override
		public FxFixingDate.FxFixingDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingDate.FxFixingDateBuilder prune() {
			super.prune();
			if (businessCentersOrReferenceModel!=null && !businessCentersOrReferenceModel.prune().hasData()) businessCentersOrReferenceModel = null;
			if (dateRelativeToPaymentDates!=null && !dateRelativeToPaymentDates.prune().hasData()) dateRelativeToPaymentDates = null;
			if (dateRelativeToCalculationPeriodDates!=null && !dateRelativeToCalculationPeriodDates.prune().hasData()) dateRelativeToCalculationPeriodDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBusinessDayConvention()!=null) return true;
			if (getBusinessCentersOrReferenceModel()!=null && getBusinessCentersOrReferenceModel().hasData()) return true;
			if (getDateRelativeToPaymentDates()!=null && getDateRelativeToPaymentDates().hasData()) return true;
			if (getDateRelativeToCalculationPeriodDates()!=null && getDateRelativeToCalculationPeriodDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingDate.FxFixingDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxFixingDate.FxFixingDateBuilder o = (FxFixingDate.FxFixingDateBuilder) other;
			
			merger.mergeRosetta(getBusinessCentersOrReferenceModel(), o.getBusinessCentersOrReferenceModel(), this::setBusinessCentersOrReferenceModel);
			merger.mergeRosetta(getDateRelativeToPaymentDates(), o.getDateRelativeToPaymentDates(), this::setDateRelativeToPaymentDates);
			merger.mergeRosetta(getDateRelativeToCalculationPeriodDates(), o.getDateRelativeToCalculationPeriodDates(), this::setDateRelativeToCalculationPeriodDates);
			
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFixingDate _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			if (!Objects.equals(dateRelativeToPaymentDates, _that.getDateRelativeToPaymentDates())) return false;
			if (!Objects.equals(dateRelativeToCalculationPeriodDates, _that.getDateRelativeToCalculationPeriodDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (dateRelativeToPaymentDates != null ? dateRelativeToPaymentDates.hashCode() : 0);
			_result = 31 * _result + (dateRelativeToCalculationPeriodDates != null ? dateRelativeToCalculationPeriodDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingDateBuilder {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel + ", " +
				"dateRelativeToPaymentDates=" + this.dateRelativeToPaymentDates + ", " +
				"dateRelativeToCalculationPeriodDates=" + this.dateRelativeToCalculationPeriodDates +
			'}' + " " + super.toString();
		}
	}
}
