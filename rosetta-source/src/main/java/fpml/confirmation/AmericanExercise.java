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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AdjustableOrRelativeDates;
import fpml.confirmation.AmericanExercise;
import fpml.confirmation.AmericanExercise.AmericanExerciseBuilder;
import fpml.confirmation.AmericanExercise.AmericanExerciseBuilderImpl;
import fpml.confirmation.AmericanExercise.AmericanExerciseImpl;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.Exercise;
import fpml.confirmation.Exercise.ExerciseBuilder;
import fpml.confirmation.Exercise.ExerciseBuilderImpl;
import fpml.confirmation.Exercise.ExerciseImpl;
import fpml.confirmation.ExerciseFeeSchedule;
import fpml.confirmation.MultipleExercise;
import fpml.confirmation.meta.AmericanExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The parameters for defining the exercise period for an American style option together with any rules governing the notional amount of the underlying which can be exercised on any given exercise date and any associated exercise fees. A type defining the exercise period for an American style option together with any rules governing the notional amount of the underlying which can be exercised on any given exercise date and any associated exercise fees.
 * @version ${project.version}
 */
@RosettaDataType(value="AmericanExercise", builder=AmericanExercise.AmericanExerciseBuilderImpl.class, version="${project.version}")
public interface AmericanExercise extends Exercise {

	AmericanExerciseMeta metaData = new AmericanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The first day of the exercise period for an American style option.
	 */
	AdjustableOrRelativeDate getCommencementDate();
	/**
	 * The last day within an exercise period for an American style option. For a European style option it is the only day within the exercise period.
	 */
	AdjustableOrRelativeDate getExpirationDate();
	/**
	 * The date on the underlying set by the exercise of an option. What this date is depends on the option (e.g. in a swaption it is the swap effective date, in an extendible/cancelable provision it is the swap termination date).
	 */
	AdjustableOrRelativeDates getRelevantUnderlyingDate();
	/**
	 * The earliest time at which notice of exercise can be given by the buyer to the seller (or seller&#39;s agent) i) on the expriation date, in the case of a European style option, (ii) on each bermuda option exercise date and the expiration date, in the case of a Bermuda style option the commencement date to, and including, the expiration date , in the case of an American option.
	 */
	BusinessCenterTime getEarliestExerciseTime();
	/**
	 * For a Bermuda or American style option, the latest time on an exercise business day (excluding the expiration date) within the exercise period that notice can be given by the buyer to the seller or seller&#39;s agent. Notice of exercise given after this time will be deemed to have been given on the next exercise business day.
	 */
	BusinessCenterTime getLatestExerciseTime();
	/**
	 * The latest time for exercise on expirationDate.
	 */
	BusinessCenterTime getExpirationTime();
	/**
	 * As defined in the 2000 ISDA Definitions, Section 12.4. Multiple Exercise, the buyer of the option has the right to exercise all or less than all the unexercised notional amount of the underlying swap on one or more days in the exercise period, but on any such day may not exercise less than the minimum notional amount or more that the maximum notional amount, and if an integral multiple amount is specified, the notional amount exercised must be equal to, or be an intergral multiple of, the integral multiple amount.
	 */
	MultipleExercise getMultipleExercise();
	/**
	 * The fees associated with an exercise date. The fees are conditional on the exercise occuring. The fees can be specified as actual currency amounts or as percentages of the notional amount being exercised.
	 */
	ExerciseFeeSchedule getExerciseFeeSchedule();

	/*********************** Build Methods  ***********************/
	AmericanExercise build();
	
	AmericanExercise.AmericanExerciseBuilder toBuilder();
	
	static AmericanExercise.AmericanExerciseBuilder builder() {
		return new AmericanExercise.AmericanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AmericanExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AmericanExercise> getType() {
		return AmericanExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.class, getCommencementDate());
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processRosetta(path.newSubPath("relevantUnderlyingDate"), processor, AdjustableOrRelativeDates.class, getRelevantUnderlyingDate());
		processRosetta(path.newSubPath("earliestExerciseTime"), processor, BusinessCenterTime.class, getEarliestExerciseTime());
		processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.class, getLatestExerciseTime());
		processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.class, getExpirationTime());
		processRosetta(path.newSubPath("multipleExercise"), processor, MultipleExercise.class, getMultipleExercise());
		processRosetta(path.newSubPath("exerciseFeeSchedule"), processor, ExerciseFeeSchedule.class, getExerciseFeeSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AmericanExerciseBuilder extends AmericanExercise, Exercise.ExerciseBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCommencementDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCommencementDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateRelevantUnderlyingDate();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getRelevantUnderlyingDate();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEarliestExerciseTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getEarliestExerciseTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestExerciseTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getLatestExerciseTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpirationTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getExpirationTime();
		MultipleExercise.MultipleExerciseBuilder getOrCreateMultipleExercise();
		MultipleExercise.MultipleExerciseBuilder getMultipleExercise();
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder getOrCreateExerciseFeeSchedule();
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder getExerciseFeeSchedule();
		AmericanExercise.AmericanExerciseBuilder setId(String id);
		AmericanExercise.AmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate);
		AmericanExercise.AmericanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);
		AmericanExercise.AmericanExerciseBuilder setRelevantUnderlyingDate(AdjustableOrRelativeDates relevantUnderlyingDate);
		AmericanExercise.AmericanExerciseBuilder setEarliestExerciseTime(BusinessCenterTime earliestExerciseTime);
		AmericanExercise.AmericanExerciseBuilder setLatestExerciseTime(BusinessCenterTime latestExerciseTime);
		AmericanExercise.AmericanExerciseBuilder setExpirationTime(BusinessCenterTime expirationTime);
		AmericanExercise.AmericanExerciseBuilder setMultipleExercise(MultipleExercise multipleExercise);
		AmericanExercise.AmericanExerciseBuilder setExerciseFeeSchedule(ExerciseFeeSchedule exerciseFeeSchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getCommencementDate());
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processRosetta(path.newSubPath("relevantUnderlyingDate"), processor, AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder.class, getRelevantUnderlyingDate());
			processRosetta(path.newSubPath("earliestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getEarliestExerciseTime());
			processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getLatestExerciseTime());
			processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpirationTime());
			processRosetta(path.newSubPath("multipleExercise"), processor, MultipleExercise.MultipleExerciseBuilder.class, getMultipleExercise());
			processRosetta(path.newSubPath("exerciseFeeSchedule"), processor, ExerciseFeeSchedule.ExerciseFeeScheduleBuilder.class, getExerciseFeeSchedule());
		}
		

		AmericanExercise.AmericanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of AmericanExercise  ***********************/
	class AmericanExerciseImpl extends Exercise.ExerciseImpl implements AmericanExercise {
		private final AdjustableOrRelativeDate commencementDate;
		private final AdjustableOrRelativeDate expirationDate;
		private final AdjustableOrRelativeDates relevantUnderlyingDate;
		private final BusinessCenterTime earliestExerciseTime;
		private final BusinessCenterTime latestExerciseTime;
		private final BusinessCenterTime expirationTime;
		private final MultipleExercise multipleExercise;
		private final ExerciseFeeSchedule exerciseFeeSchedule;
		
		protected AmericanExerciseImpl(AmericanExercise.AmericanExerciseBuilder builder) {
			super(builder);
			this.commencementDate = ofNullable(builder.getCommencementDate()).map(f->f.build()).orElse(null);
			this.expirationDate = ofNullable(builder.getExpirationDate()).map(f->f.build()).orElse(null);
			this.relevantUnderlyingDate = ofNullable(builder.getRelevantUnderlyingDate()).map(f->f.build()).orElse(null);
			this.earliestExerciseTime = ofNullable(builder.getEarliestExerciseTime()).map(f->f.build()).orElse(null);
			this.latestExerciseTime = ofNullable(builder.getLatestExerciseTime()).map(f->f.build()).orElse(null);
			this.expirationTime = ofNullable(builder.getExpirationTime()).map(f->f.build()).orElse(null);
			this.multipleExercise = ofNullable(builder.getMultipleExercise()).map(f->f.build()).orElse(null);
			this.exerciseFeeSchedule = ofNullable(builder.getExerciseFeeSchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commencementDate")
		public AdjustableOrRelativeDate getCommencementDate() {
			return commencementDate;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		public AdjustableOrRelativeDate getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		@RosettaAttribute("relevantUnderlyingDate")
		public AdjustableOrRelativeDates getRelevantUnderlyingDate() {
			return relevantUnderlyingDate;
		}
		
		@Override
		@RosettaAttribute("earliestExerciseTime")
		public BusinessCenterTime getEarliestExerciseTime() {
			return earliestExerciseTime;
		}
		
		@Override
		@RosettaAttribute("latestExerciseTime")
		public BusinessCenterTime getLatestExerciseTime() {
			return latestExerciseTime;
		}
		
		@Override
		@RosettaAttribute("expirationTime")
		public BusinessCenterTime getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		@RosettaAttribute("multipleExercise")
		public MultipleExercise getMultipleExercise() {
			return multipleExercise;
		}
		
		@Override
		@RosettaAttribute("exerciseFeeSchedule")
		public ExerciseFeeSchedule getExerciseFeeSchedule() {
			return exerciseFeeSchedule;
		}
		
		@Override
		public AmericanExercise build() {
			return this;
		}
		
		@Override
		public AmericanExercise.AmericanExerciseBuilder toBuilder() {
			AmericanExercise.AmericanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AmericanExercise.AmericanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommencementDate()).ifPresent(builder::setCommencementDate);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
			ofNullable(getRelevantUnderlyingDate()).ifPresent(builder::setRelevantUnderlyingDate);
			ofNullable(getEarliestExerciseTime()).ifPresent(builder::setEarliestExerciseTime);
			ofNullable(getLatestExerciseTime()).ifPresent(builder::setLatestExerciseTime);
			ofNullable(getExpirationTime()).ifPresent(builder::setExpirationTime);
			ofNullable(getMultipleExercise()).ifPresent(builder::setMultipleExercise);
			ofNullable(getExerciseFeeSchedule()).ifPresent(builder::setExerciseFeeSchedule);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(relevantUnderlyingDate, _that.getRelevantUnderlyingDate())) return false;
			if (!Objects.equals(earliestExerciseTime, _that.getEarliestExerciseTime())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(multipleExercise, _that.getMultipleExercise())) return false;
			if (!Objects.equals(exerciseFeeSchedule, _that.getExerciseFeeSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDate != null ? relevantUnderlyingDate.hashCode() : 0);
			_result = 31 * _result + (earliestExerciseTime != null ? earliestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (multipleExercise != null ? multipleExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseFeeSchedule != null ? exerciseFeeSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmericanExercise {" +
				"commencementDate=" + this.commencementDate + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"relevantUnderlyingDate=" + this.relevantUnderlyingDate + ", " +
				"earliestExerciseTime=" + this.earliestExerciseTime + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"multipleExercise=" + this.multipleExercise + ", " +
				"exerciseFeeSchedule=" + this.exerciseFeeSchedule +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AmericanExercise  ***********************/
	class AmericanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl  implements AmericanExercise.AmericanExerciseBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder commencementDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder expirationDate;
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder relevantUnderlyingDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder earliestExerciseTime;
		protected BusinessCenterTime.BusinessCenterTimeBuilder latestExerciseTime;
		protected BusinessCenterTime.BusinessCenterTimeBuilder expirationTime;
		protected MultipleExercise.MultipleExerciseBuilder multipleExercise;
		protected ExerciseFeeSchedule.ExerciseFeeScheduleBuilder exerciseFeeSchedule;
	
		public AmericanExerciseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commencementDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCommencementDate() {
			return commencementDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCommencementDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (commencementDate!=null) {
				result = commencementDate;
			}
			else {
				result = commencementDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (expirationDate!=null) {
				result = expirationDate;
			}
			else {
				result = expirationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relevantUnderlyingDate")
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getRelevantUnderlyingDate() {
			return relevantUnderlyingDate;
		}
		
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateRelevantUnderlyingDate() {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder result;
			if (relevantUnderlyingDate!=null) {
				result = relevantUnderlyingDate;
			}
			else {
				result = relevantUnderlyingDate = AdjustableOrRelativeDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("earliestExerciseTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getEarliestExerciseTime() {
			return earliestExerciseTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEarliestExerciseTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (earliestExerciseTime!=null) {
				result = earliestExerciseTime;
			}
			else {
				result = earliestExerciseTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("latestExerciseTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getLatestExerciseTime() {
			return latestExerciseTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestExerciseTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (latestExerciseTime!=null) {
				result = latestExerciseTime;
			}
			else {
				result = latestExerciseTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpirationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (expirationTime!=null) {
				result = expirationTime;
			}
			else {
				result = expirationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("multipleExercise")
		public MultipleExercise.MultipleExerciseBuilder getMultipleExercise() {
			return multipleExercise;
		}
		
		@Override
		public MultipleExercise.MultipleExerciseBuilder getOrCreateMultipleExercise() {
			MultipleExercise.MultipleExerciseBuilder result;
			if (multipleExercise!=null) {
				result = multipleExercise;
			}
			else {
				result = multipleExercise = MultipleExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseFeeSchedule")
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder getExerciseFeeSchedule() {
			return exerciseFeeSchedule;
		}
		
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder getOrCreateExerciseFeeSchedule() {
			ExerciseFeeSchedule.ExerciseFeeScheduleBuilder result;
			if (exerciseFeeSchedule!=null) {
				result = exerciseFeeSchedule;
			}
			else {
				result = exerciseFeeSchedule = ExerciseFeeSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public AmericanExercise.AmericanExerciseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("commencementDate")
		public AmericanExercise.AmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate) {
			this.commencementDate = commencementDate==null?null:commencementDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expirationDate")
		public AmericanExercise.AmericanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate) {
			this.expirationDate = expirationDate==null?null:expirationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relevantUnderlyingDate")
		public AmericanExercise.AmericanExerciseBuilder setRelevantUnderlyingDate(AdjustableOrRelativeDates relevantUnderlyingDate) {
			this.relevantUnderlyingDate = relevantUnderlyingDate==null?null:relevantUnderlyingDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("earliestExerciseTime")
		public AmericanExercise.AmericanExerciseBuilder setEarliestExerciseTime(BusinessCenterTime earliestExerciseTime) {
			this.earliestExerciseTime = earliestExerciseTime==null?null:earliestExerciseTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("latestExerciseTime")
		public AmericanExercise.AmericanExerciseBuilder setLatestExerciseTime(BusinessCenterTime latestExerciseTime) {
			this.latestExerciseTime = latestExerciseTime==null?null:latestExerciseTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expirationTime")
		public AmericanExercise.AmericanExerciseBuilder setExpirationTime(BusinessCenterTime expirationTime) {
			this.expirationTime = expirationTime==null?null:expirationTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("multipleExercise")
		public AmericanExercise.AmericanExerciseBuilder setMultipleExercise(MultipleExercise multipleExercise) {
			this.multipleExercise = multipleExercise==null?null:multipleExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseFeeSchedule")
		public AmericanExercise.AmericanExerciseBuilder setExerciseFeeSchedule(ExerciseFeeSchedule exerciseFeeSchedule) {
			this.exerciseFeeSchedule = exerciseFeeSchedule==null?null:exerciseFeeSchedule.toBuilder();
			return this;
		}
		
		@Override
		public AmericanExercise build() {
			return new AmericanExercise.AmericanExerciseImpl(this);
		}
		
		@Override
		public AmericanExercise.AmericanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmericanExercise.AmericanExerciseBuilder prune() {
			super.prune();
			if (commencementDate!=null && !commencementDate.prune().hasData()) commencementDate = null;
			if (expirationDate!=null && !expirationDate.prune().hasData()) expirationDate = null;
			if (relevantUnderlyingDate!=null && !relevantUnderlyingDate.prune().hasData()) relevantUnderlyingDate = null;
			if (earliestExerciseTime!=null && !earliestExerciseTime.prune().hasData()) earliestExerciseTime = null;
			if (latestExerciseTime!=null && !latestExerciseTime.prune().hasData()) latestExerciseTime = null;
			if (expirationTime!=null && !expirationTime.prune().hasData()) expirationTime = null;
			if (multipleExercise!=null && !multipleExercise.prune().hasData()) multipleExercise = null;
			if (exerciseFeeSchedule!=null && !exerciseFeeSchedule.prune().hasData()) exerciseFeeSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommencementDate()!=null && getCommencementDate().hasData()) return true;
			if (getExpirationDate()!=null && getExpirationDate().hasData()) return true;
			if (getRelevantUnderlyingDate()!=null && getRelevantUnderlyingDate().hasData()) return true;
			if (getEarliestExerciseTime()!=null && getEarliestExerciseTime().hasData()) return true;
			if (getLatestExerciseTime()!=null && getLatestExerciseTime().hasData()) return true;
			if (getExpirationTime()!=null && getExpirationTime().hasData()) return true;
			if (getMultipleExercise()!=null && getMultipleExercise().hasData()) return true;
			if (getExerciseFeeSchedule()!=null && getExerciseFeeSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmericanExercise.AmericanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AmericanExercise.AmericanExerciseBuilder o = (AmericanExercise.AmericanExerciseBuilder) other;
			
			merger.mergeRosetta(getCommencementDate(), o.getCommencementDate(), this::setCommencementDate);
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			merger.mergeRosetta(getRelevantUnderlyingDate(), o.getRelevantUnderlyingDate(), this::setRelevantUnderlyingDate);
			merger.mergeRosetta(getEarliestExerciseTime(), o.getEarliestExerciseTime(), this::setEarliestExerciseTime);
			merger.mergeRosetta(getLatestExerciseTime(), o.getLatestExerciseTime(), this::setLatestExerciseTime);
			merger.mergeRosetta(getExpirationTime(), o.getExpirationTime(), this::setExpirationTime);
			merger.mergeRosetta(getMultipleExercise(), o.getMultipleExercise(), this::setMultipleExercise);
			merger.mergeRosetta(getExerciseFeeSchedule(), o.getExerciseFeeSchedule(), this::setExerciseFeeSchedule);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(relevantUnderlyingDate, _that.getRelevantUnderlyingDate())) return false;
			if (!Objects.equals(earliestExerciseTime, _that.getEarliestExerciseTime())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(multipleExercise, _that.getMultipleExercise())) return false;
			if (!Objects.equals(exerciseFeeSchedule, _that.getExerciseFeeSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDate != null ? relevantUnderlyingDate.hashCode() : 0);
			_result = 31 * _result + (earliestExerciseTime != null ? earliestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (multipleExercise != null ? multipleExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseFeeSchedule != null ? exerciseFeeSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmericanExerciseBuilder {" +
				"commencementDate=" + this.commencementDate + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"relevantUnderlyingDate=" + this.relevantUnderlyingDate + ", " +
				"earliestExerciseTime=" + this.earliestExerciseTime + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"multipleExercise=" + this.multipleExercise + ", " +
				"exerciseFeeSchedule=" + this.exerciseFeeSchedule +
			'}' + " " + super.toString();
		}
	}
}
