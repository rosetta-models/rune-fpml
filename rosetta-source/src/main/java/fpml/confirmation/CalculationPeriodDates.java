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
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.AdjustedRelativeDateOffset;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.CalculationPeriodDates;
import fpml.confirmation.CalculationPeriodDates.CalculationPeriodDatesBuilder;
import fpml.confirmation.CalculationPeriodDates.CalculationPeriodDatesBuilderImpl;
import fpml.confirmation.CalculationPeriodDates.CalculationPeriodDatesImpl;
import fpml.confirmation.CalculationPeriodFrequency;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.StubPeriodTypeEnum;
import fpml.confirmation.meta.CalculationPeriodDatesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the parameters used to generate the calculation period dates schedule, including the specification of any initial or final stub calculation periods. A calculation perod schedule consists of an optional initial stub calculation period, one or more regular calculation periods and an optional final stub calculation period. In the absence of any initial or final stub calculation periods, the regular part of the calculation period schedule is assumed to be between the effective date and the termination date. No implicit stubs are allowed, i.e. stubs must be explicitly specified using an appropriate combination of firstPeriodStateDate, firstRegularPeriodStartDate and lastRegularPeriodEndDate.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CalculationPeriodDates", builder=CalculationPeriodDates.CalculationPeriodDatesBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CalculationPeriodDates extends RosettaModelObject {

	CalculationPeriodDatesMeta metaData = new CalculationPeriodDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The first day of the term of the trade. This day may be subject to adjustment in accordance with a business day convention.
	 */
	AdjustableDate getEffectiveDate();
	/**
	 * Defines the effective date.
	 */
	AdjustedRelativeDateOffset getRelativeEffectiveDate();
	/**
	 * The last day of the term of the trade. This day may be subject to adjustment in accordance with a business day convention.
	 */
	AdjustableDate getTerminationDate();
	/**
	 * The term/maturity of the swap, express as a tenor (typically in years).
	 */
	RelativeDateOffset getRelativeTerminationDate();
	/**
	 * The business day convention to apply to each calculation period end date if it would otherwise fall on a day that is not a business day in the specified financial business centers.
	 */
	BusinessDayAdjustments getCalculationPeriodDatesAdjustments();
	/**
	 * The start date of the calculation period if the date falls before the effective date. It must only be specified if it is not equal to the effective date. This date may be subject to adjustment in accordance with a business day convention.
	 */
	AdjustableDate getFirstPeriodStartDate();
	/**
	 * The start date of the regular part of the calculation period schedule. It must only be specified if there is an initial stub calculation period. This day may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 */
	Date getFirstRegularPeriodStartDate();
	/**
	 * The end date of the initial compounding period when compounding is applicable. It must only be specified when the compoundingMethod element is present and not equal to a value of None. This date may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 */
	Date getFirstCompoundingPeriodEndDate();
	/**
	 * The end date of the regular part of the calculation period schedule. It must only be specified if there is a final stub calculation period. This day may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 */
	Date getLastRegularPeriodEndDate();
	/**
	 * Method to allocate any irregular period remaining after regular periods have been allocated between the effective and termination date.
	 */
	StubPeriodTypeEnum getStubPeriodType();
	/**
	 * The frequency at which calculation period end dates occur with the regular part of the calculation period schedule and their roll date convention.
	 */
	CalculationPeriodFrequency getCalculationPeriodFrequency();
	String getId();

	/*********************** Build Methods  ***********************/
	CalculationPeriodDates build();
	
	CalculationPeriodDates.CalculationPeriodDatesBuilder toBuilder();
	
	static CalculationPeriodDates.CalculationPeriodDatesBuilder builder() {
		return new CalculationPeriodDates.CalculationPeriodDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationPeriodDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CalculationPeriodDates> getType() {
		return CalculationPeriodDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("relativeEffectiveDate"), processor, AdjustedRelativeDateOffset.class, getRelativeEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableDate.class, getTerminationDate());
		processRosetta(path.newSubPath("relativeTerminationDate"), processor, RelativeDateOffset.class, getRelativeTerminationDate());
		processRosetta(path.newSubPath("calculationPeriodDatesAdjustments"), processor, BusinessDayAdjustments.class, getCalculationPeriodDatesAdjustments());
		processRosetta(path.newSubPath("firstPeriodStartDate"), processor, AdjustableDate.class, getFirstPeriodStartDate());
		processor.processBasic(path.newSubPath("firstRegularPeriodStartDate"), Date.class, getFirstRegularPeriodStartDate(), this);
		processor.processBasic(path.newSubPath("firstCompoundingPeriodEndDate"), Date.class, getFirstCompoundingPeriodEndDate(), this);
		processor.processBasic(path.newSubPath("lastRegularPeriodEndDate"), Date.class, getLastRegularPeriodEndDate(), this);
		processor.processBasic(path.newSubPath("stubPeriodType"), StubPeriodTypeEnum.class, getStubPeriodType(), this);
		processRosetta(path.newSubPath("calculationPeriodFrequency"), processor, CalculationPeriodFrequency.class, getCalculationPeriodFrequency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationPeriodDatesBuilder extends CalculationPeriodDates, RosettaModelObjectBuilder {
		AdjustableDate.AdjustableDateBuilder getOrCreateEffectiveDate();
		AdjustableDate.AdjustableDateBuilder getEffectiveDate();
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getOrCreateRelativeEffectiveDate();
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getRelativeEffectiveDate();
		AdjustableDate.AdjustableDateBuilder getOrCreateTerminationDate();
		AdjustableDate.AdjustableDateBuilder getTerminationDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeTerminationDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getRelativeTerminationDate();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateCalculationPeriodDatesAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getCalculationPeriodDatesAdjustments();
		AdjustableDate.AdjustableDateBuilder getOrCreateFirstPeriodStartDate();
		AdjustableDate.AdjustableDateBuilder getFirstPeriodStartDate();
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreateCalculationPeriodFrequency();
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getCalculationPeriodFrequency();
		CalculationPeriodDates.CalculationPeriodDatesBuilder setEffectiveDate(AdjustableDate effectiveDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setRelativeEffectiveDate(AdjustedRelativeDateOffset relativeEffectiveDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setTerminationDate(AdjustableDate terminationDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setRelativeTerminationDate(RelativeDateOffset relativeTerminationDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setCalculationPeriodDatesAdjustments(BusinessDayAdjustments calculationPeriodDatesAdjustments);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstPeriodStartDate(AdjustableDate firstPeriodStartDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstRegularPeriodStartDate(Date firstRegularPeriodStartDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstCompoundingPeriodEndDate(Date firstCompoundingPeriodEndDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setLastRegularPeriodEndDate(Date lastRegularPeriodEndDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setStubPeriodType(StubPeriodTypeEnum stubPeriodType);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setCalculationPeriodFrequency(CalculationPeriodFrequency calculationPeriodFrequency);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("relativeEffectiveDate"), processor, AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder.class, getRelativeEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("relativeTerminationDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getRelativeTerminationDate());
			processRosetta(path.newSubPath("calculationPeriodDatesAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getCalculationPeriodDatesAdjustments());
			processRosetta(path.newSubPath("firstPeriodStartDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getFirstPeriodStartDate());
			processor.processBasic(path.newSubPath("firstRegularPeriodStartDate"), Date.class, getFirstRegularPeriodStartDate(), this);
			processor.processBasic(path.newSubPath("firstCompoundingPeriodEndDate"), Date.class, getFirstCompoundingPeriodEndDate(), this);
			processor.processBasic(path.newSubPath("lastRegularPeriodEndDate"), Date.class, getLastRegularPeriodEndDate(), this);
			processor.processBasic(path.newSubPath("stubPeriodType"), StubPeriodTypeEnum.class, getStubPeriodType(), this);
			processRosetta(path.newSubPath("calculationPeriodFrequency"), processor, CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder.class, getCalculationPeriodFrequency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CalculationPeriodDates.CalculationPeriodDatesBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationPeriodDates  ***********************/
	class CalculationPeriodDatesImpl implements CalculationPeriodDates {
		private final AdjustableDate effectiveDate;
		private final AdjustedRelativeDateOffset relativeEffectiveDate;
		private final AdjustableDate terminationDate;
		private final RelativeDateOffset relativeTerminationDate;
		private final BusinessDayAdjustments calculationPeriodDatesAdjustments;
		private final AdjustableDate firstPeriodStartDate;
		private final Date firstRegularPeriodStartDate;
		private final Date firstCompoundingPeriodEndDate;
		private final Date lastRegularPeriodEndDate;
		private final StubPeriodTypeEnum stubPeriodType;
		private final CalculationPeriodFrequency calculationPeriodFrequency;
		private final String id;
		
		protected CalculationPeriodDatesImpl(CalculationPeriodDates.CalculationPeriodDatesBuilder builder) {
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.relativeEffectiveDate = ofNullable(builder.getRelativeEffectiveDate()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
			this.relativeTerminationDate = ofNullable(builder.getRelativeTerminationDate()).map(f->f.build()).orElse(null);
			this.calculationPeriodDatesAdjustments = ofNullable(builder.getCalculationPeriodDatesAdjustments()).map(f->f.build()).orElse(null);
			this.firstPeriodStartDate = ofNullable(builder.getFirstPeriodStartDate()).map(f->f.build()).orElse(null);
			this.firstRegularPeriodStartDate = builder.getFirstRegularPeriodStartDate();
			this.firstCompoundingPeriodEndDate = builder.getFirstCompoundingPeriodEndDate();
			this.lastRegularPeriodEndDate = builder.getLastRegularPeriodEndDate();
			this.stubPeriodType = builder.getStubPeriodType();
			this.calculationPeriodFrequency = ofNullable(builder.getCalculationPeriodFrequency()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("relativeEffectiveDate")
		public AdjustedRelativeDateOffset getRelativeEffectiveDate() {
			return relativeEffectiveDate;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public AdjustableDate getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		@RosettaAttribute("relativeTerminationDate")
		public RelativeDateOffset getRelativeTerminationDate() {
			return relativeTerminationDate;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesAdjustments")
		public BusinessDayAdjustments getCalculationPeriodDatesAdjustments() {
			return calculationPeriodDatesAdjustments;
		}
		
		@Override
		@RosettaAttribute("firstPeriodStartDate")
		public AdjustableDate getFirstPeriodStartDate() {
			return firstPeriodStartDate;
		}
		
		@Override
		@RosettaAttribute("firstRegularPeriodStartDate")
		public Date getFirstRegularPeriodStartDate() {
			return firstRegularPeriodStartDate;
		}
		
		@Override
		@RosettaAttribute("firstCompoundingPeriodEndDate")
		public Date getFirstCompoundingPeriodEndDate() {
			return firstCompoundingPeriodEndDate;
		}
		
		@Override
		@RosettaAttribute("lastRegularPeriodEndDate")
		public Date getLastRegularPeriodEndDate() {
			return lastRegularPeriodEndDate;
		}
		
		@Override
		@RosettaAttribute("stubPeriodType")
		public StubPeriodTypeEnum getStubPeriodType() {
			return stubPeriodType;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodFrequency")
		public CalculationPeriodFrequency getCalculationPeriodFrequency() {
			return calculationPeriodFrequency;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CalculationPeriodDates build() {
			return this;
		}
		
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder toBuilder() {
			CalculationPeriodDates.CalculationPeriodDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationPeriodDates.CalculationPeriodDatesBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getRelativeEffectiveDate()).ifPresent(builder::setRelativeEffectiveDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
			ofNullable(getRelativeTerminationDate()).ifPresent(builder::setRelativeTerminationDate);
			ofNullable(getCalculationPeriodDatesAdjustments()).ifPresent(builder::setCalculationPeriodDatesAdjustments);
			ofNullable(getFirstPeriodStartDate()).ifPresent(builder::setFirstPeriodStartDate);
			ofNullable(getFirstRegularPeriodStartDate()).ifPresent(builder::setFirstRegularPeriodStartDate);
			ofNullable(getFirstCompoundingPeriodEndDate()).ifPresent(builder::setFirstCompoundingPeriodEndDate);
			ofNullable(getLastRegularPeriodEndDate()).ifPresent(builder::setLastRegularPeriodEndDate);
			ofNullable(getStubPeriodType()).ifPresent(builder::setStubPeriodType);
			ofNullable(getCalculationPeriodFrequency()).ifPresent(builder::setCalculationPeriodFrequency);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationPeriodDates _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(relativeEffectiveDate, _that.getRelativeEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(relativeTerminationDate, _that.getRelativeTerminationDate())) return false;
			if (!Objects.equals(calculationPeriodDatesAdjustments, _that.getCalculationPeriodDatesAdjustments())) return false;
			if (!Objects.equals(firstPeriodStartDate, _that.getFirstPeriodStartDate())) return false;
			if (!Objects.equals(firstRegularPeriodStartDate, _that.getFirstRegularPeriodStartDate())) return false;
			if (!Objects.equals(firstCompoundingPeriodEndDate, _that.getFirstCompoundingPeriodEndDate())) return false;
			if (!Objects.equals(lastRegularPeriodEndDate, _that.getLastRegularPeriodEndDate())) return false;
			if (!Objects.equals(stubPeriodType, _that.getStubPeriodType())) return false;
			if (!Objects.equals(calculationPeriodFrequency, _that.getCalculationPeriodFrequency())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (relativeEffectiveDate != null ? relativeEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (relativeTerminationDate != null ? relativeTerminationDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDatesAdjustments != null ? calculationPeriodDatesAdjustments.hashCode() : 0);
			_result = 31 * _result + (firstPeriodStartDate != null ? firstPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (firstRegularPeriodStartDate != null ? firstRegularPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (firstCompoundingPeriodEndDate != null ? firstCompoundingPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (lastRegularPeriodEndDate != null ? lastRegularPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (stubPeriodType != null ? stubPeriodType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calculationPeriodFrequency != null ? calculationPeriodFrequency.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodDates {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"relativeEffectiveDate=" + this.relativeEffectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"relativeTerminationDate=" + this.relativeTerminationDate + ", " +
				"calculationPeriodDatesAdjustments=" + this.calculationPeriodDatesAdjustments + ", " +
				"firstPeriodStartDate=" + this.firstPeriodStartDate + ", " +
				"firstRegularPeriodStartDate=" + this.firstRegularPeriodStartDate + ", " +
				"firstCompoundingPeriodEndDate=" + this.firstCompoundingPeriodEndDate + ", " +
				"lastRegularPeriodEndDate=" + this.lastRegularPeriodEndDate + ", " +
				"stubPeriodType=" + this.stubPeriodType + ", " +
				"calculationPeriodFrequency=" + this.calculationPeriodFrequency + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculationPeriodDates  ***********************/
	class CalculationPeriodDatesBuilderImpl implements CalculationPeriodDates.CalculationPeriodDatesBuilder {
	
		protected AdjustableDate.AdjustableDateBuilder effectiveDate;
		protected AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder relativeEffectiveDate;
		protected AdjustableDate.AdjustableDateBuilder terminationDate;
		protected RelativeDateOffset.RelativeDateOffsetBuilder relativeTerminationDate;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder calculationPeriodDatesAdjustments;
		protected AdjustableDate.AdjustableDateBuilder firstPeriodStartDate;
		protected Date firstRegularPeriodStartDate;
		protected Date firstCompoundingPeriodEndDate;
		protected Date lastRegularPeriodEndDate;
		protected StubPeriodTypeEnum stubPeriodType;
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequency;
		protected String id;
	
		public CalculationPeriodDatesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableDate.AdjustableDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateEffectiveDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeEffectiveDate")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getRelativeEffectiveDate() {
			return relativeEffectiveDate;
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getOrCreateRelativeEffectiveDate() {
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder result;
			if (relativeEffectiveDate!=null) {
				result = relativeEffectiveDate;
			}
			else {
				result = relativeEffectiveDate = AdjustedRelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public AdjustableDate.AdjustableDateBuilder getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateTerminationDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (terminationDate!=null) {
				result = terminationDate;
			}
			else {
				result = terminationDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeTerminationDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder getRelativeTerminationDate() {
			return relativeTerminationDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeTerminationDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (relativeTerminationDate!=null) {
				result = relativeTerminationDate;
			}
			else {
				result = relativeTerminationDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getCalculationPeriodDatesAdjustments() {
			return calculationPeriodDatesAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateCalculationPeriodDatesAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (calculationPeriodDatesAdjustments!=null) {
				result = calculationPeriodDatesAdjustments;
			}
			else {
				result = calculationPeriodDatesAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("firstPeriodStartDate")
		public AdjustableDate.AdjustableDateBuilder getFirstPeriodStartDate() {
			return firstPeriodStartDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateFirstPeriodStartDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (firstPeriodStartDate!=null) {
				result = firstPeriodStartDate;
			}
			else {
				result = firstPeriodStartDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("firstRegularPeriodStartDate")
		public Date getFirstRegularPeriodStartDate() {
			return firstRegularPeriodStartDate;
		}
		
		@Override
		@RosettaAttribute("firstCompoundingPeriodEndDate")
		public Date getFirstCompoundingPeriodEndDate() {
			return firstCompoundingPeriodEndDate;
		}
		
		@Override
		@RosettaAttribute("lastRegularPeriodEndDate")
		public Date getLastRegularPeriodEndDate() {
			return lastRegularPeriodEndDate;
		}
		
		@Override
		@RosettaAttribute("stubPeriodType")
		public StubPeriodTypeEnum getStubPeriodType() {
			return stubPeriodType;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodFrequency")
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getCalculationPeriodFrequency() {
			return calculationPeriodFrequency;
		}
		
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreateCalculationPeriodFrequency() {
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder result;
			if (calculationPeriodFrequency!=null) {
				result = calculationPeriodFrequency;
			}
			else {
				result = calculationPeriodFrequency = CalculationPeriodFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setEffectiveDate(AdjustableDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relativeEffectiveDate")
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setRelativeEffectiveDate(AdjustedRelativeDateOffset relativeEffectiveDate) {
			this.relativeEffectiveDate = relativeEffectiveDate==null?null:relativeEffectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setTerminationDate(AdjustableDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relativeTerminationDate")
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setRelativeTerminationDate(RelativeDateOffset relativeTerminationDate) {
			this.relativeTerminationDate = relativeTerminationDate==null?null:relativeTerminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationPeriodDatesAdjustments")
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setCalculationPeriodDatesAdjustments(BusinessDayAdjustments calculationPeriodDatesAdjustments) {
			this.calculationPeriodDatesAdjustments = calculationPeriodDatesAdjustments==null?null:calculationPeriodDatesAdjustments.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("firstPeriodStartDate")
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstPeriodStartDate(AdjustableDate firstPeriodStartDate) {
			this.firstPeriodStartDate = firstPeriodStartDate==null?null:firstPeriodStartDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("firstRegularPeriodStartDate")
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstRegularPeriodStartDate(Date firstRegularPeriodStartDate) {
			this.firstRegularPeriodStartDate = firstRegularPeriodStartDate==null?null:firstRegularPeriodStartDate;
			return this;
		}
		@Override
		@RosettaAttribute("firstCompoundingPeriodEndDate")
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstCompoundingPeriodEndDate(Date firstCompoundingPeriodEndDate) {
			this.firstCompoundingPeriodEndDate = firstCompoundingPeriodEndDate==null?null:firstCompoundingPeriodEndDate;
			return this;
		}
		@Override
		@RosettaAttribute("lastRegularPeriodEndDate")
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setLastRegularPeriodEndDate(Date lastRegularPeriodEndDate) {
			this.lastRegularPeriodEndDate = lastRegularPeriodEndDate==null?null:lastRegularPeriodEndDate;
			return this;
		}
		@Override
		@RosettaAttribute("stubPeriodType")
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setStubPeriodType(StubPeriodTypeEnum stubPeriodType) {
			this.stubPeriodType = stubPeriodType==null?null:stubPeriodType;
			return this;
		}
		@Override
		@RosettaAttribute("calculationPeriodFrequency")
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setCalculationPeriodFrequency(CalculationPeriodFrequency calculationPeriodFrequency) {
			this.calculationPeriodFrequency = calculationPeriodFrequency==null?null:calculationPeriodFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CalculationPeriodDates build() {
			return new CalculationPeriodDates.CalculationPeriodDatesImpl(this);
		}
		
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (relativeEffectiveDate!=null && !relativeEffectiveDate.prune().hasData()) relativeEffectiveDate = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			if (relativeTerminationDate!=null && !relativeTerminationDate.prune().hasData()) relativeTerminationDate = null;
			if (calculationPeriodDatesAdjustments!=null && !calculationPeriodDatesAdjustments.prune().hasData()) calculationPeriodDatesAdjustments = null;
			if (firstPeriodStartDate!=null && !firstPeriodStartDate.prune().hasData()) firstPeriodStartDate = null;
			if (calculationPeriodFrequency!=null && !calculationPeriodFrequency.prune().hasData()) calculationPeriodFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getRelativeEffectiveDate()!=null && getRelativeEffectiveDate().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			if (getRelativeTerminationDate()!=null && getRelativeTerminationDate().hasData()) return true;
			if (getCalculationPeriodDatesAdjustments()!=null && getCalculationPeriodDatesAdjustments().hasData()) return true;
			if (getFirstPeriodStartDate()!=null && getFirstPeriodStartDate().hasData()) return true;
			if (getFirstRegularPeriodStartDate()!=null) return true;
			if (getFirstCompoundingPeriodEndDate()!=null) return true;
			if (getLastRegularPeriodEndDate()!=null) return true;
			if (getStubPeriodType()!=null) return true;
			if (getCalculationPeriodFrequency()!=null && getCalculationPeriodFrequency().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationPeriodDates.CalculationPeriodDatesBuilder o = (CalculationPeriodDates.CalculationPeriodDatesBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getRelativeEffectiveDate(), o.getRelativeEffectiveDate(), this::setRelativeEffectiveDate);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			merger.mergeRosetta(getRelativeTerminationDate(), o.getRelativeTerminationDate(), this::setRelativeTerminationDate);
			merger.mergeRosetta(getCalculationPeriodDatesAdjustments(), o.getCalculationPeriodDatesAdjustments(), this::setCalculationPeriodDatesAdjustments);
			merger.mergeRosetta(getFirstPeriodStartDate(), o.getFirstPeriodStartDate(), this::setFirstPeriodStartDate);
			merger.mergeRosetta(getCalculationPeriodFrequency(), o.getCalculationPeriodFrequency(), this::setCalculationPeriodFrequency);
			
			merger.mergeBasic(getFirstRegularPeriodStartDate(), o.getFirstRegularPeriodStartDate(), this::setFirstRegularPeriodStartDate);
			merger.mergeBasic(getFirstCompoundingPeriodEndDate(), o.getFirstCompoundingPeriodEndDate(), this::setFirstCompoundingPeriodEndDate);
			merger.mergeBasic(getLastRegularPeriodEndDate(), o.getLastRegularPeriodEndDate(), this::setLastRegularPeriodEndDate);
			merger.mergeBasic(getStubPeriodType(), o.getStubPeriodType(), this::setStubPeriodType);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationPeriodDates _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(relativeEffectiveDate, _that.getRelativeEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(relativeTerminationDate, _that.getRelativeTerminationDate())) return false;
			if (!Objects.equals(calculationPeriodDatesAdjustments, _that.getCalculationPeriodDatesAdjustments())) return false;
			if (!Objects.equals(firstPeriodStartDate, _that.getFirstPeriodStartDate())) return false;
			if (!Objects.equals(firstRegularPeriodStartDate, _that.getFirstRegularPeriodStartDate())) return false;
			if (!Objects.equals(firstCompoundingPeriodEndDate, _that.getFirstCompoundingPeriodEndDate())) return false;
			if (!Objects.equals(lastRegularPeriodEndDate, _that.getLastRegularPeriodEndDate())) return false;
			if (!Objects.equals(stubPeriodType, _that.getStubPeriodType())) return false;
			if (!Objects.equals(calculationPeriodFrequency, _that.getCalculationPeriodFrequency())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (relativeEffectiveDate != null ? relativeEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (relativeTerminationDate != null ? relativeTerminationDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDatesAdjustments != null ? calculationPeriodDatesAdjustments.hashCode() : 0);
			_result = 31 * _result + (firstPeriodStartDate != null ? firstPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (firstRegularPeriodStartDate != null ? firstRegularPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (firstCompoundingPeriodEndDate != null ? firstCompoundingPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (lastRegularPeriodEndDate != null ? lastRegularPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (stubPeriodType != null ? stubPeriodType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calculationPeriodFrequency != null ? calculationPeriodFrequency.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodDatesBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"relativeEffectiveDate=" + this.relativeEffectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"relativeTerminationDate=" + this.relativeTerminationDate + ", " +
				"calculationPeriodDatesAdjustments=" + this.calculationPeriodDatesAdjustments + ", " +
				"firstPeriodStartDate=" + this.firstPeriodStartDate + ", " +
				"firstRegularPeriodStartDate=" + this.firstRegularPeriodStartDate + ", " +
				"firstCompoundingPeriodEndDate=" + this.firstCompoundingPeriodEndDate + ", " +
				"lastRegularPeriodEndDate=" + this.lastRegularPeriodEndDate + ", " +
				"stubPeriodType=" + this.stubPeriodType + ", " +
				"calculationPeriodFrequency=" + this.calculationPeriodFrequency + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
