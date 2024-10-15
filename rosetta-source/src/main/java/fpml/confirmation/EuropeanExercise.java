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
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.EuropeanExercise;
import fpml.confirmation.EuropeanExercise.EuropeanExerciseBuilder;
import fpml.confirmation.EuropeanExercise.EuropeanExerciseBuilderImpl;
import fpml.confirmation.EuropeanExercise.EuropeanExerciseImpl;
import fpml.confirmation.Exercise;
import fpml.confirmation.Exercise.ExerciseBuilder;
import fpml.confirmation.Exercise.ExerciseBuilderImpl;
import fpml.confirmation.Exercise.ExerciseImpl;
import fpml.confirmation.ExerciseFee;
import fpml.confirmation.PartialExercise;
import fpml.confirmation.meta.EuropeanExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The parameters for defining the exercise period for a European style option together with any rules governing the notional amount of the underlying which can be exercised on any given exercise date and any associated exercise fees. A type defining the exercise period for a European style option together with any rules governing the notional amount of the underlying which can be exercised on any given exercise date and any associated exercise fees.
 * @version ${project.version}
 */
@RosettaDataType(value="EuropeanExercise", builder=EuropeanExercise.EuropeanExerciseBuilderImpl.class, version="${project.version}")
public interface EuropeanExercise extends Exercise {

	EuropeanExerciseMeta metaData = new EuropeanExerciseMeta();

	/*********************** Getter Methods  ***********************/
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
	 * The latest time for exercise on expirationDate.
	 */
	BusinessCenterTime getExpirationTime();
	/**
	 * As defined in the 2000 ISDA Definitions, Section 12.3. Partial Exercise, the buyer of the option has the right to exercise all or less than all the notional amount of the underlying swap on the expiration date, but may not exercise less than the minimum notional amount, and if an integral multiple amount is specified, the notional amount exercised must be equal to, or be an integral multiple of, the integral multiple amount.
	 */
	PartialExercise getPartialExercise();
	/**
	 * A fee to be paid on exercise. This could be represented as an amount or a rate and notional reference on which to apply the rate.
	 */
	ExerciseFee getExerciseFee();

	/*********************** Build Methods  ***********************/
	EuropeanExercise build();
	
	EuropeanExercise.EuropeanExerciseBuilder toBuilder();
	
	static EuropeanExercise.EuropeanExerciseBuilder builder() {
		return new EuropeanExercise.EuropeanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EuropeanExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EuropeanExercise> getType() {
		return EuropeanExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processRosetta(path.newSubPath("relevantUnderlyingDate"), processor, AdjustableOrRelativeDates.class, getRelevantUnderlyingDate());
		processRosetta(path.newSubPath("earliestExerciseTime"), processor, BusinessCenterTime.class, getEarliestExerciseTime());
		processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.class, getExpirationTime());
		processRosetta(path.newSubPath("partialExercise"), processor, PartialExercise.class, getPartialExercise());
		processRosetta(path.newSubPath("exerciseFee"), processor, ExerciseFee.class, getExerciseFee());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EuropeanExerciseBuilder extends EuropeanExercise, Exercise.ExerciseBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateRelevantUnderlyingDate();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getRelevantUnderlyingDate();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEarliestExerciseTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getEarliestExerciseTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpirationTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getExpirationTime();
		PartialExercise.PartialExerciseBuilder getOrCreatePartialExercise();
		PartialExercise.PartialExerciseBuilder getPartialExercise();
		ExerciseFee.ExerciseFeeBuilder getOrCreateExerciseFee();
		ExerciseFee.ExerciseFeeBuilder getExerciseFee();
		EuropeanExercise.EuropeanExerciseBuilder setId(String id);
		EuropeanExercise.EuropeanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);
		EuropeanExercise.EuropeanExerciseBuilder setRelevantUnderlyingDate(AdjustableOrRelativeDates relevantUnderlyingDate);
		EuropeanExercise.EuropeanExerciseBuilder setEarliestExerciseTime(BusinessCenterTime earliestExerciseTime);
		EuropeanExercise.EuropeanExerciseBuilder setExpirationTime(BusinessCenterTime expirationTime);
		EuropeanExercise.EuropeanExerciseBuilder setPartialExercise(PartialExercise partialExercise);
		EuropeanExercise.EuropeanExerciseBuilder setExerciseFee(ExerciseFee exerciseFee);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processRosetta(path.newSubPath("relevantUnderlyingDate"), processor, AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder.class, getRelevantUnderlyingDate());
			processRosetta(path.newSubPath("earliestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getEarliestExerciseTime());
			processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpirationTime());
			processRosetta(path.newSubPath("partialExercise"), processor, PartialExercise.PartialExerciseBuilder.class, getPartialExercise());
			processRosetta(path.newSubPath("exerciseFee"), processor, ExerciseFee.ExerciseFeeBuilder.class, getExerciseFee());
		}
		

		EuropeanExercise.EuropeanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of EuropeanExercise  ***********************/
	class EuropeanExerciseImpl extends Exercise.ExerciseImpl implements EuropeanExercise {
		private final AdjustableOrRelativeDate expirationDate;
		private final AdjustableOrRelativeDates relevantUnderlyingDate;
		private final BusinessCenterTime earliestExerciseTime;
		private final BusinessCenterTime expirationTime;
		private final PartialExercise partialExercise;
		private final ExerciseFee exerciseFee;
		
		protected EuropeanExerciseImpl(EuropeanExercise.EuropeanExerciseBuilder builder) {
			super(builder);
			this.expirationDate = ofNullable(builder.getExpirationDate()).map(f->f.build()).orElse(null);
			this.relevantUnderlyingDate = ofNullable(builder.getRelevantUnderlyingDate()).map(f->f.build()).orElse(null);
			this.earliestExerciseTime = ofNullable(builder.getEarliestExerciseTime()).map(f->f.build()).orElse(null);
			this.expirationTime = ofNullable(builder.getExpirationTime()).map(f->f.build()).orElse(null);
			this.partialExercise = ofNullable(builder.getPartialExercise()).map(f->f.build()).orElse(null);
			this.exerciseFee = ofNullable(builder.getExerciseFee()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("expirationTime")
		public BusinessCenterTime getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		@RosettaAttribute("partialExercise")
		public PartialExercise getPartialExercise() {
			return partialExercise;
		}
		
		@Override
		@RosettaAttribute("exerciseFee")
		public ExerciseFee getExerciseFee() {
			return exerciseFee;
		}
		
		@Override
		public EuropeanExercise build() {
			return this;
		}
		
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder toBuilder() {
			EuropeanExercise.EuropeanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EuropeanExercise.EuropeanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
			ofNullable(getRelevantUnderlyingDate()).ifPresent(builder::setRelevantUnderlyingDate);
			ofNullable(getEarliestExerciseTime()).ifPresent(builder::setEarliestExerciseTime);
			ofNullable(getExpirationTime()).ifPresent(builder::setExpirationTime);
			ofNullable(getPartialExercise()).ifPresent(builder::setPartialExercise);
			ofNullable(getExerciseFee()).ifPresent(builder::setExerciseFee);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(relevantUnderlyingDate, _that.getRelevantUnderlyingDate())) return false;
			if (!Objects.equals(earliestExerciseTime, _that.getEarliestExerciseTime())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(partialExercise, _that.getPartialExercise())) return false;
			if (!Objects.equals(exerciseFee, _that.getExerciseFee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDate != null ? relevantUnderlyingDate.hashCode() : 0);
			_result = 31 * _result + (earliestExerciseTime != null ? earliestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (partialExercise != null ? partialExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseFee != null ? exerciseFee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EuropeanExercise {" +
				"expirationDate=" + this.expirationDate + ", " +
				"relevantUnderlyingDate=" + this.relevantUnderlyingDate + ", " +
				"earliestExerciseTime=" + this.earliestExerciseTime + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"partialExercise=" + this.partialExercise + ", " +
				"exerciseFee=" + this.exerciseFee +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EuropeanExercise  ***********************/
	class EuropeanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl  implements EuropeanExercise.EuropeanExerciseBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder expirationDate;
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder relevantUnderlyingDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder earliestExerciseTime;
		protected BusinessCenterTime.BusinessCenterTimeBuilder expirationTime;
		protected PartialExercise.PartialExerciseBuilder partialExercise;
		protected ExerciseFee.ExerciseFeeBuilder exerciseFee;
	
		public EuropeanExerciseBuilderImpl() {
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
		@RosettaAttribute("partialExercise")
		public PartialExercise.PartialExerciseBuilder getPartialExercise() {
			return partialExercise;
		}
		
		@Override
		public PartialExercise.PartialExerciseBuilder getOrCreatePartialExercise() {
			PartialExercise.PartialExerciseBuilder result;
			if (partialExercise!=null) {
				result = partialExercise;
			}
			else {
				result = partialExercise = PartialExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseFee")
		public ExerciseFee.ExerciseFeeBuilder getExerciseFee() {
			return exerciseFee;
		}
		
		@Override
		public ExerciseFee.ExerciseFeeBuilder getOrCreateExerciseFee() {
			ExerciseFee.ExerciseFeeBuilder result;
			if (exerciseFee!=null) {
				result = exerciseFee;
			}
			else {
				result = exerciseFee = ExerciseFee.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public EuropeanExercise.EuropeanExerciseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("expirationDate")
		public EuropeanExercise.EuropeanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate) {
			this.expirationDate = expirationDate==null?null:expirationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relevantUnderlyingDate")
		public EuropeanExercise.EuropeanExerciseBuilder setRelevantUnderlyingDate(AdjustableOrRelativeDates relevantUnderlyingDate) {
			this.relevantUnderlyingDate = relevantUnderlyingDate==null?null:relevantUnderlyingDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("earliestExerciseTime")
		public EuropeanExercise.EuropeanExerciseBuilder setEarliestExerciseTime(BusinessCenterTime earliestExerciseTime) {
			this.earliestExerciseTime = earliestExerciseTime==null?null:earliestExerciseTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expirationTime")
		public EuropeanExercise.EuropeanExerciseBuilder setExpirationTime(BusinessCenterTime expirationTime) {
			this.expirationTime = expirationTime==null?null:expirationTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partialExercise")
		public EuropeanExercise.EuropeanExerciseBuilder setPartialExercise(PartialExercise partialExercise) {
			this.partialExercise = partialExercise==null?null:partialExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseFee")
		public EuropeanExercise.EuropeanExerciseBuilder setExerciseFee(ExerciseFee exerciseFee) {
			this.exerciseFee = exerciseFee==null?null:exerciseFee.toBuilder();
			return this;
		}
		
		@Override
		public EuropeanExercise build() {
			return new EuropeanExercise.EuropeanExerciseImpl(this);
		}
		
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder prune() {
			super.prune();
			if (expirationDate!=null && !expirationDate.prune().hasData()) expirationDate = null;
			if (relevantUnderlyingDate!=null && !relevantUnderlyingDate.prune().hasData()) relevantUnderlyingDate = null;
			if (earliestExerciseTime!=null && !earliestExerciseTime.prune().hasData()) earliestExerciseTime = null;
			if (expirationTime!=null && !expirationTime.prune().hasData()) expirationTime = null;
			if (partialExercise!=null && !partialExercise.prune().hasData()) partialExercise = null;
			if (exerciseFee!=null && !exerciseFee.prune().hasData()) exerciseFee = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExpirationDate()!=null && getExpirationDate().hasData()) return true;
			if (getRelevantUnderlyingDate()!=null && getRelevantUnderlyingDate().hasData()) return true;
			if (getEarliestExerciseTime()!=null && getEarliestExerciseTime().hasData()) return true;
			if (getExpirationTime()!=null && getExpirationTime().hasData()) return true;
			if (getPartialExercise()!=null && getPartialExercise().hasData()) return true;
			if (getExerciseFee()!=null && getExerciseFee().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EuropeanExercise.EuropeanExerciseBuilder o = (EuropeanExercise.EuropeanExerciseBuilder) other;
			
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			merger.mergeRosetta(getRelevantUnderlyingDate(), o.getRelevantUnderlyingDate(), this::setRelevantUnderlyingDate);
			merger.mergeRosetta(getEarliestExerciseTime(), o.getEarliestExerciseTime(), this::setEarliestExerciseTime);
			merger.mergeRosetta(getExpirationTime(), o.getExpirationTime(), this::setExpirationTime);
			merger.mergeRosetta(getPartialExercise(), o.getPartialExercise(), this::setPartialExercise);
			merger.mergeRosetta(getExerciseFee(), o.getExerciseFee(), this::setExerciseFee);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(relevantUnderlyingDate, _that.getRelevantUnderlyingDate())) return false;
			if (!Objects.equals(earliestExerciseTime, _that.getEarliestExerciseTime())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(partialExercise, _that.getPartialExercise())) return false;
			if (!Objects.equals(exerciseFee, _that.getExerciseFee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDate != null ? relevantUnderlyingDate.hashCode() : 0);
			_result = 31 * _result + (earliestExerciseTime != null ? earliestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (partialExercise != null ? partialExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseFee != null ? exerciseFee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EuropeanExerciseBuilder {" +
				"expirationDate=" + this.expirationDate + ", " +
				"relevantUnderlyingDate=" + this.relevantUnderlyingDate + ", " +
				"earliestExerciseTime=" + this.earliestExerciseTime + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"partialExercise=" + this.partialExercise + ", " +
				"exerciseFee=" + this.exerciseFee +
			'}' + " " + super.toString();
		}
	}
}
