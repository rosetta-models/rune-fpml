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
import fpml.confirmation.AdjustableDateOrRelativeDateSequence;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.EquityValuation;
import fpml.confirmation.EquityValuation.EquityValuationBuilder;
import fpml.confirmation.EquityValuation.EquityValuationBuilderImpl;
import fpml.confirmation.EquityValuation.EquityValuationImpl;
import fpml.confirmation.FPVFinalPriceElectionFallbackEnum;
import fpml.confirmation.TimeTypeEnum;
import fpml.confirmation.meta.EquityValuationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining how and when an equity option is to be valued.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EquityValuation", builder=EquityValuation.EquityValuationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EquityValuation extends RosettaModelObject {

	EquityValuationMeta metaData = new EquityValuationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The term &quot;Valuation Date&quot; is assumed to have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions. Cash Settlement Payment Date in accordance with the ISDA 2002 Equity Derivatives Definitions. SettlementCycle in accordance with the ISDA 2011 Equity Derivatives Definitions.
	 */
	AdjustableDateOrRelativeDateSequence getValuationDate();
	/**
	 * Specifies the interim equity valuation dates of a swap.
	 */
	AdjustableRelativeOrPeriodicDates getValuationDates();
	/**
	 * The time of day at which the calculation agent values the underlying, for example the official closing time of the exchange.
	 */
	TimeTypeEnum getValuationTimeType();
	/**
	 * The specific time of day at which the calculation agent values the underlying. The SpecificTime is the only case when the valuationTime (time + business center location – e.g. 10:00:00 USNY) should be provided. You should be able to provide just the valuationTime without valuationTimeType, which infer that this is a specific time.
	 */
	BusinessCenterTime getValuationTime();
	/**
	 * The official settlement price as announced by the related exchange is applicable, in accordance with the ISDA 2002 definitions.
	 */
	Boolean getFuturesPriceValuation();
	/**
	 * The official settlement price as announced by the related exchange is applicable, in accordance with the ISDA 2002 definitions.
	 */
	Boolean getOptionsPriceValuation();
	/**
	 * The number of valuation dates between valuation start date and valuation end date.
	 */
	Integer getNumberOfValuationDates();
	/**
	 * Specifies the dividend valuation dates of the swap.
	 */
	AdjustableRelativeOrPeriodicDates getDividendValuationDates();
	/**
	 * Specifies the fallback provisions for Hedging Party in the determination of the Final Price.
	 */
	FPVFinalPriceElectionFallbackEnum getFPVFinalPriceElectionFallback();
	String getId();

	/*********************** Build Methods  ***********************/
	EquityValuation build();
	
	EquityValuation.EquityValuationBuilder toBuilder();
	
	static EquityValuation.EquityValuationBuilder builder() {
		return new EquityValuation.EquityValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityValuation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityValuation> getType() {
		return EquityValuation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("valuationDate"), processor, AdjustableDateOrRelativeDateSequence.class, getValuationDate());
		processRosetta(path.newSubPath("valuationDates"), processor, AdjustableRelativeOrPeriodicDates.class, getValuationDates());
		processor.processBasic(path.newSubPath("valuationTimeType"), TimeTypeEnum.class, getValuationTimeType(), this);
		processRosetta(path.newSubPath("valuationTime"), processor, BusinessCenterTime.class, getValuationTime());
		processor.processBasic(path.newSubPath("futuresPriceValuation"), Boolean.class, getFuturesPriceValuation(), this);
		processor.processBasic(path.newSubPath("optionsPriceValuation"), Boolean.class, getOptionsPriceValuation(), this);
		processor.processBasic(path.newSubPath("numberOfValuationDates"), Integer.class, getNumberOfValuationDates(), this);
		processRosetta(path.newSubPath("dividendValuationDates"), processor, AdjustableRelativeOrPeriodicDates.class, getDividendValuationDates());
		processor.processBasic(path.newSubPath("fPVFinalPriceElectionFallback"), FPVFinalPriceElectionFallbackEnum.class, getFPVFinalPriceElectionFallback(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityValuationBuilder extends EquityValuation, RosettaModelObjectBuilder {
		AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder getOrCreateValuationDate();
		AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder getValuationDate();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateValuationDates();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getValuationDates();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateValuationTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getValuationTime();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateDividendValuationDates();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getDividendValuationDates();
		EquityValuation.EquityValuationBuilder setValuationDate(AdjustableDateOrRelativeDateSequence valuationDate);
		EquityValuation.EquityValuationBuilder setValuationDates(AdjustableRelativeOrPeriodicDates valuationDates);
		EquityValuation.EquityValuationBuilder setValuationTimeType(TimeTypeEnum valuationTimeType);
		EquityValuation.EquityValuationBuilder setValuationTime(BusinessCenterTime valuationTime);
		EquityValuation.EquityValuationBuilder setFuturesPriceValuation(Boolean futuresPriceValuation);
		EquityValuation.EquityValuationBuilder setOptionsPriceValuation(Boolean optionsPriceValuation);
		EquityValuation.EquityValuationBuilder setNumberOfValuationDates(Integer numberOfValuationDates);
		EquityValuation.EquityValuationBuilder setDividendValuationDates(AdjustableRelativeOrPeriodicDates dividendValuationDates);
		EquityValuation.EquityValuationBuilder setFPVFinalPriceElectionFallback(FPVFinalPriceElectionFallbackEnum fPVFinalPriceElectionFallback);
		EquityValuation.EquityValuationBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("valuationDate"), processor, AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder.class, getValuationDate());
			processRosetta(path.newSubPath("valuationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getValuationDates());
			processor.processBasic(path.newSubPath("valuationTimeType"), TimeTypeEnum.class, getValuationTimeType(), this);
			processRosetta(path.newSubPath("valuationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getValuationTime());
			processor.processBasic(path.newSubPath("futuresPriceValuation"), Boolean.class, getFuturesPriceValuation(), this);
			processor.processBasic(path.newSubPath("optionsPriceValuation"), Boolean.class, getOptionsPriceValuation(), this);
			processor.processBasic(path.newSubPath("numberOfValuationDates"), Integer.class, getNumberOfValuationDates(), this);
			processRosetta(path.newSubPath("dividendValuationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getDividendValuationDates());
			processor.processBasic(path.newSubPath("fPVFinalPriceElectionFallback"), FPVFinalPriceElectionFallbackEnum.class, getFPVFinalPriceElectionFallback(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		EquityValuation.EquityValuationBuilder prune();
	}

	/*********************** Immutable Implementation of EquityValuation  ***********************/
	class EquityValuationImpl implements EquityValuation {
		private final AdjustableDateOrRelativeDateSequence valuationDate;
		private final AdjustableRelativeOrPeriodicDates valuationDates;
		private final TimeTypeEnum valuationTimeType;
		private final BusinessCenterTime valuationTime;
		private final Boolean futuresPriceValuation;
		private final Boolean optionsPriceValuation;
		private final Integer numberOfValuationDates;
		private final AdjustableRelativeOrPeriodicDates dividendValuationDates;
		private final FPVFinalPriceElectionFallbackEnum fPVFinalPriceElectionFallback;
		private final String id;
		
		protected EquityValuationImpl(EquityValuation.EquityValuationBuilder builder) {
			this.valuationDate = ofNullable(builder.getValuationDate()).map(f->f.build()).orElse(null);
			this.valuationDates = ofNullable(builder.getValuationDates()).map(f->f.build()).orElse(null);
			this.valuationTimeType = builder.getValuationTimeType();
			this.valuationTime = ofNullable(builder.getValuationTime()).map(f->f.build()).orElse(null);
			this.futuresPriceValuation = builder.getFuturesPriceValuation();
			this.optionsPriceValuation = builder.getOptionsPriceValuation();
			this.numberOfValuationDates = builder.getNumberOfValuationDates();
			this.dividendValuationDates = ofNullable(builder.getDividendValuationDates()).map(f->f.build()).orElse(null);
			this.fPVFinalPriceElectionFallback = builder.getFPVFinalPriceElectionFallback();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		public AdjustableDateOrRelativeDateSequence getValuationDate() {
			return valuationDate;
		}
		
		@Override
		@RosettaAttribute("valuationDates")
		public AdjustableRelativeOrPeriodicDates getValuationDates() {
			return valuationDates;
		}
		
		@Override
		@RosettaAttribute("valuationTimeType")
		public TimeTypeEnum getValuationTimeType() {
			return valuationTimeType;
		}
		
		@Override
		@RosettaAttribute("valuationTime")
		public BusinessCenterTime getValuationTime() {
			return valuationTime;
		}
		
		@Override
		@RosettaAttribute("futuresPriceValuation")
		public Boolean getFuturesPriceValuation() {
			return futuresPriceValuation;
		}
		
		@Override
		@RosettaAttribute("optionsPriceValuation")
		public Boolean getOptionsPriceValuation() {
			return optionsPriceValuation;
		}
		
		@Override
		@RosettaAttribute("numberOfValuationDates")
		public Integer getNumberOfValuationDates() {
			return numberOfValuationDates;
		}
		
		@Override
		@RosettaAttribute("dividendValuationDates")
		public AdjustableRelativeOrPeriodicDates getDividendValuationDates() {
			return dividendValuationDates;
		}
		
		@Override
		@RosettaAttribute("fPVFinalPriceElectionFallback")
		public FPVFinalPriceElectionFallbackEnum getFPVFinalPriceElectionFallback() {
			return fPVFinalPriceElectionFallback;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public EquityValuation build() {
			return this;
		}
		
		@Override
		public EquityValuation.EquityValuationBuilder toBuilder() {
			EquityValuation.EquityValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityValuation.EquityValuationBuilder builder) {
			ofNullable(getValuationDate()).ifPresent(builder::setValuationDate);
			ofNullable(getValuationDates()).ifPresent(builder::setValuationDates);
			ofNullable(getValuationTimeType()).ifPresent(builder::setValuationTimeType);
			ofNullable(getValuationTime()).ifPresent(builder::setValuationTime);
			ofNullable(getFuturesPriceValuation()).ifPresent(builder::setFuturesPriceValuation);
			ofNullable(getOptionsPriceValuation()).ifPresent(builder::setOptionsPriceValuation);
			ofNullable(getNumberOfValuationDates()).ifPresent(builder::setNumberOfValuationDates);
			ofNullable(getDividendValuationDates()).ifPresent(builder::setDividendValuationDates);
			ofNullable(getFPVFinalPriceElectionFallback()).ifPresent(builder::setFPVFinalPriceElectionFallback);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityValuation _that = getType().cast(o);
		
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(valuationTimeType, _that.getValuationTimeType())) return false;
			if (!Objects.equals(valuationTime, _that.getValuationTime())) return false;
			if (!Objects.equals(futuresPriceValuation, _that.getFuturesPriceValuation())) return false;
			if (!Objects.equals(optionsPriceValuation, _that.getOptionsPriceValuation())) return false;
			if (!Objects.equals(numberOfValuationDates, _that.getNumberOfValuationDates())) return false;
			if (!Objects.equals(dividendValuationDates, _that.getDividendValuationDates())) return false;
			if (!Objects.equals(fPVFinalPriceElectionFallback, _that.getFPVFinalPriceElectionFallback())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (valuationTimeType != null ? valuationTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationTime != null ? valuationTime.hashCode() : 0);
			_result = 31 * _result + (futuresPriceValuation != null ? futuresPriceValuation.hashCode() : 0);
			_result = 31 * _result + (optionsPriceValuation != null ? optionsPriceValuation.hashCode() : 0);
			_result = 31 * _result + (numberOfValuationDates != null ? numberOfValuationDates.hashCode() : 0);
			_result = 31 * _result + (dividendValuationDates != null ? dividendValuationDates.hashCode() : 0);
			_result = 31 * _result + (fPVFinalPriceElectionFallback != null ? fPVFinalPriceElectionFallback.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityValuation {" +
				"valuationDate=" + this.valuationDate + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"valuationTimeType=" + this.valuationTimeType + ", " +
				"valuationTime=" + this.valuationTime + ", " +
				"futuresPriceValuation=" + this.futuresPriceValuation + ", " +
				"optionsPriceValuation=" + this.optionsPriceValuation + ", " +
				"numberOfValuationDates=" + this.numberOfValuationDates + ", " +
				"dividendValuationDates=" + this.dividendValuationDates + ", " +
				"fPVFinalPriceElectionFallback=" + this.fPVFinalPriceElectionFallback + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of EquityValuation  ***********************/
	class EquityValuationBuilderImpl implements EquityValuation.EquityValuationBuilder {
	
		protected AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder valuationDate;
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder valuationDates;
		protected TimeTypeEnum valuationTimeType;
		protected BusinessCenterTime.BusinessCenterTimeBuilder valuationTime;
		protected Boolean futuresPriceValuation;
		protected Boolean optionsPriceValuation;
		protected Integer numberOfValuationDates;
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder dividendValuationDates;
		protected FPVFinalPriceElectionFallbackEnum fPVFinalPriceElectionFallback;
		protected String id;
	
		public EquityValuationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("valuationDate")
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder getValuationDate() {
			return valuationDate;
		}
		
		@Override
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder getOrCreateValuationDate() {
			AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder result;
			if (valuationDate!=null) {
				result = valuationDate;
			}
			else {
				result = valuationDate = AdjustableDateOrRelativeDateSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationDates")
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getValuationDates() {
			return valuationDates;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateValuationDates() {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder result;
			if (valuationDates!=null) {
				result = valuationDates;
			}
			else {
				result = valuationDates = AdjustableRelativeOrPeriodicDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationTimeType")
		public TimeTypeEnum getValuationTimeType() {
			return valuationTimeType;
		}
		
		@Override
		@RosettaAttribute("valuationTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getValuationTime() {
			return valuationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateValuationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (valuationTime!=null) {
				result = valuationTime;
			}
			else {
				result = valuationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("futuresPriceValuation")
		public Boolean getFuturesPriceValuation() {
			return futuresPriceValuation;
		}
		
		@Override
		@RosettaAttribute("optionsPriceValuation")
		public Boolean getOptionsPriceValuation() {
			return optionsPriceValuation;
		}
		
		@Override
		@RosettaAttribute("numberOfValuationDates")
		public Integer getNumberOfValuationDates() {
			return numberOfValuationDates;
		}
		
		@Override
		@RosettaAttribute("dividendValuationDates")
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getDividendValuationDates() {
			return dividendValuationDates;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateDividendValuationDates() {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder result;
			if (dividendValuationDates!=null) {
				result = dividendValuationDates;
			}
			else {
				result = dividendValuationDates = AdjustableRelativeOrPeriodicDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fPVFinalPriceElectionFallback")
		public FPVFinalPriceElectionFallbackEnum getFPVFinalPriceElectionFallback() {
			return fPVFinalPriceElectionFallback;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		public EquityValuation.EquityValuationBuilder setValuationDate(AdjustableDateOrRelativeDateSequence valuationDate) {
			this.valuationDate = valuationDate==null?null:valuationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationDates")
		public EquityValuation.EquityValuationBuilder setValuationDates(AdjustableRelativeOrPeriodicDates valuationDates) {
			this.valuationDates = valuationDates==null?null:valuationDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationTimeType")
		public EquityValuation.EquityValuationBuilder setValuationTimeType(TimeTypeEnum valuationTimeType) {
			this.valuationTimeType = valuationTimeType==null?null:valuationTimeType;
			return this;
		}
		@Override
		@RosettaAttribute("valuationTime")
		public EquityValuation.EquityValuationBuilder setValuationTime(BusinessCenterTime valuationTime) {
			this.valuationTime = valuationTime==null?null:valuationTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("futuresPriceValuation")
		public EquityValuation.EquityValuationBuilder setFuturesPriceValuation(Boolean futuresPriceValuation) {
			this.futuresPriceValuation = futuresPriceValuation==null?null:futuresPriceValuation;
			return this;
		}
		@Override
		@RosettaAttribute("optionsPriceValuation")
		public EquityValuation.EquityValuationBuilder setOptionsPriceValuation(Boolean optionsPriceValuation) {
			this.optionsPriceValuation = optionsPriceValuation==null?null:optionsPriceValuation;
			return this;
		}
		@Override
		@RosettaAttribute("numberOfValuationDates")
		public EquityValuation.EquityValuationBuilder setNumberOfValuationDates(Integer numberOfValuationDates) {
			this.numberOfValuationDates = numberOfValuationDates==null?null:numberOfValuationDates;
			return this;
		}
		@Override
		@RosettaAttribute("dividendValuationDates")
		public EquityValuation.EquityValuationBuilder setDividendValuationDates(AdjustableRelativeOrPeriodicDates dividendValuationDates) {
			this.dividendValuationDates = dividendValuationDates==null?null:dividendValuationDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fPVFinalPriceElectionFallback")
		public EquityValuation.EquityValuationBuilder setFPVFinalPriceElectionFallback(FPVFinalPriceElectionFallbackEnum fPVFinalPriceElectionFallback) {
			this.fPVFinalPriceElectionFallback = fPVFinalPriceElectionFallback==null?null:fPVFinalPriceElectionFallback;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public EquityValuation.EquityValuationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public EquityValuation build() {
			return new EquityValuation.EquityValuationImpl(this);
		}
		
		@Override
		public EquityValuation.EquityValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityValuation.EquityValuationBuilder prune() {
			if (valuationDate!=null && !valuationDate.prune().hasData()) valuationDate = null;
			if (valuationDates!=null && !valuationDates.prune().hasData()) valuationDates = null;
			if (valuationTime!=null && !valuationTime.prune().hasData()) valuationTime = null;
			if (dividendValuationDates!=null && !dividendValuationDates.prune().hasData()) dividendValuationDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValuationDate()!=null && getValuationDate().hasData()) return true;
			if (getValuationDates()!=null && getValuationDates().hasData()) return true;
			if (getValuationTimeType()!=null) return true;
			if (getValuationTime()!=null && getValuationTime().hasData()) return true;
			if (getFuturesPriceValuation()!=null) return true;
			if (getOptionsPriceValuation()!=null) return true;
			if (getNumberOfValuationDates()!=null) return true;
			if (getDividendValuationDates()!=null && getDividendValuationDates().hasData()) return true;
			if (getFPVFinalPriceElectionFallback()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityValuation.EquityValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityValuation.EquityValuationBuilder o = (EquityValuation.EquityValuationBuilder) other;
			
			merger.mergeRosetta(getValuationDate(), o.getValuationDate(), this::setValuationDate);
			merger.mergeRosetta(getValuationDates(), o.getValuationDates(), this::setValuationDates);
			merger.mergeRosetta(getValuationTime(), o.getValuationTime(), this::setValuationTime);
			merger.mergeRosetta(getDividendValuationDates(), o.getDividendValuationDates(), this::setDividendValuationDates);
			
			merger.mergeBasic(getValuationTimeType(), o.getValuationTimeType(), this::setValuationTimeType);
			merger.mergeBasic(getFuturesPriceValuation(), o.getFuturesPriceValuation(), this::setFuturesPriceValuation);
			merger.mergeBasic(getOptionsPriceValuation(), o.getOptionsPriceValuation(), this::setOptionsPriceValuation);
			merger.mergeBasic(getNumberOfValuationDates(), o.getNumberOfValuationDates(), this::setNumberOfValuationDates);
			merger.mergeBasic(getFPVFinalPriceElectionFallback(), o.getFPVFinalPriceElectionFallback(), this::setFPVFinalPriceElectionFallback);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityValuation _that = getType().cast(o);
		
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(valuationTimeType, _that.getValuationTimeType())) return false;
			if (!Objects.equals(valuationTime, _that.getValuationTime())) return false;
			if (!Objects.equals(futuresPriceValuation, _that.getFuturesPriceValuation())) return false;
			if (!Objects.equals(optionsPriceValuation, _that.getOptionsPriceValuation())) return false;
			if (!Objects.equals(numberOfValuationDates, _that.getNumberOfValuationDates())) return false;
			if (!Objects.equals(dividendValuationDates, _that.getDividendValuationDates())) return false;
			if (!Objects.equals(fPVFinalPriceElectionFallback, _that.getFPVFinalPriceElectionFallback())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (valuationTimeType != null ? valuationTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationTime != null ? valuationTime.hashCode() : 0);
			_result = 31 * _result + (futuresPriceValuation != null ? futuresPriceValuation.hashCode() : 0);
			_result = 31 * _result + (optionsPriceValuation != null ? optionsPriceValuation.hashCode() : 0);
			_result = 31 * _result + (numberOfValuationDates != null ? numberOfValuationDates.hashCode() : 0);
			_result = 31 * _result + (dividendValuationDates != null ? dividendValuationDates.hashCode() : 0);
			_result = 31 * _result + (fPVFinalPriceElectionFallback != null ? fPVFinalPriceElectionFallback.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityValuationBuilder {" +
				"valuationDate=" + this.valuationDate + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"valuationTimeType=" + this.valuationTimeType + ", " +
				"valuationTime=" + this.valuationTime + ", " +
				"futuresPriceValuation=" + this.futuresPriceValuation + ", " +
				"optionsPriceValuation=" + this.optionsPriceValuation + ", " +
				"numberOfValuationDates=" + this.numberOfValuationDates + ", " +
				"dividendValuationDates=" + this.dividendValuationDates + ", " +
				"fPVFinalPriceElectionFallback=" + this.fPVFinalPriceElectionFallback + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
