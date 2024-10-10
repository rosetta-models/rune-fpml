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
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.Exercise;
import fpml.confirmation.Exercise.ExerciseBuilder;
import fpml.confirmation.Exercise.ExerciseBuilderImpl;
import fpml.confirmation.Exercise.ExerciseImpl;
import fpml.confirmation.SharedAmericanExercise;
import fpml.confirmation.SharedAmericanExercise.SharedAmericanExerciseBuilder;
import fpml.confirmation.SharedAmericanExercise.SharedAmericanExerciseBuilderImpl;
import fpml.confirmation.SharedAmericanExercise.SharedAmericanExerciseImpl;
import fpml.confirmation.meta.SharedAmericanExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * TBA
 * @version ${project.version}
 */
@RosettaDataType(value="SharedAmericanExercise", builder=SharedAmericanExercise.SharedAmericanExerciseBuilderImpl.class, version="${project.version}")
public interface SharedAmericanExercise extends Exercise {

	SharedAmericanExerciseMeta metaData = new SharedAmericanExerciseMeta();

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
	 * For a Bermuda or American style option, the latest time on an exercise business day (excluding the expiration date) within the exercise period that notice can be given by the buyer to the seller or seller&#39;s agent. Notice of exercise given after this time will be deemed to have been given on the next exercise business day.
	 */
	BusinessCenterTime getLatestExerciseTime();
	/**
	 * Latest exercise time determination method.
	 */
	DeterminationMethod getLatestExerciseTimeDetermination();

	/*********************** Build Methods  ***********************/
	SharedAmericanExercise build();
	
	SharedAmericanExercise.SharedAmericanExerciseBuilder toBuilder();
	
	static SharedAmericanExercise.SharedAmericanExerciseBuilder builder() {
		return new SharedAmericanExercise.SharedAmericanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SharedAmericanExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SharedAmericanExercise> getType() {
		return SharedAmericanExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.class, getCommencementDate());
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.class, getLatestExerciseTime());
		processRosetta(path.newSubPath("latestExerciseTimeDetermination"), processor, DeterminationMethod.class, getLatestExerciseTimeDetermination());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SharedAmericanExerciseBuilder extends SharedAmericanExercise, Exercise.ExerciseBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCommencementDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCommencementDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestExerciseTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getLatestExerciseTime();
		DeterminationMethod.DeterminationMethodBuilder getOrCreateLatestExerciseTimeDetermination();
		DeterminationMethod.DeterminationMethodBuilder getLatestExerciseTimeDetermination();
		SharedAmericanExercise.SharedAmericanExerciseBuilder setId(String id);
		SharedAmericanExercise.SharedAmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate);
		SharedAmericanExercise.SharedAmericanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);
		SharedAmericanExercise.SharedAmericanExerciseBuilder setLatestExerciseTime(BusinessCenterTime latestExerciseTime);
		SharedAmericanExercise.SharedAmericanExerciseBuilder setLatestExerciseTimeDetermination(DeterminationMethod latestExerciseTimeDetermination);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getCommencementDate());
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getLatestExerciseTime());
			processRosetta(path.newSubPath("latestExerciseTimeDetermination"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getLatestExerciseTimeDetermination());
		}
		

		SharedAmericanExercise.SharedAmericanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of SharedAmericanExercise  ***********************/
	class SharedAmericanExerciseImpl extends Exercise.ExerciseImpl implements SharedAmericanExercise {
		private final AdjustableOrRelativeDate commencementDate;
		private final AdjustableOrRelativeDate expirationDate;
		private final BusinessCenterTime latestExerciseTime;
		private final DeterminationMethod latestExerciseTimeDetermination;
		
		protected SharedAmericanExerciseImpl(SharedAmericanExercise.SharedAmericanExerciseBuilder builder) {
			super(builder);
			this.commencementDate = ofNullable(builder.getCommencementDate()).map(f->f.build()).orElse(null);
			this.expirationDate = ofNullable(builder.getExpirationDate()).map(f->f.build()).orElse(null);
			this.latestExerciseTime = ofNullable(builder.getLatestExerciseTime()).map(f->f.build()).orElse(null);
			this.latestExerciseTimeDetermination = ofNullable(builder.getLatestExerciseTimeDetermination()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("latestExerciseTime")
		public BusinessCenterTime getLatestExerciseTime() {
			return latestExerciseTime;
		}
		
		@Override
		@RosettaAttribute("latestExerciseTimeDetermination")
		public DeterminationMethod getLatestExerciseTimeDetermination() {
			return latestExerciseTimeDetermination;
		}
		
		@Override
		public SharedAmericanExercise build() {
			return this;
		}
		
		@Override
		public SharedAmericanExercise.SharedAmericanExerciseBuilder toBuilder() {
			SharedAmericanExercise.SharedAmericanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SharedAmericanExercise.SharedAmericanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommencementDate()).ifPresent(builder::setCommencementDate);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
			ofNullable(getLatestExerciseTime()).ifPresent(builder::setLatestExerciseTime);
			ofNullable(getLatestExerciseTimeDetermination()).ifPresent(builder::setLatestExerciseTimeDetermination);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SharedAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(latestExerciseTimeDetermination, _that.getLatestExerciseTimeDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTimeDetermination != null ? latestExerciseTimeDetermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SharedAmericanExercise {" +
				"commencementDate=" + this.commencementDate + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"latestExerciseTimeDetermination=" + this.latestExerciseTimeDetermination +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SharedAmericanExercise  ***********************/
	class SharedAmericanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl  implements SharedAmericanExercise.SharedAmericanExerciseBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder commencementDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder expirationDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder latestExerciseTime;
		protected DeterminationMethod.DeterminationMethodBuilder latestExerciseTimeDetermination;
	
		public SharedAmericanExerciseBuilderImpl() {
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
		@RosettaAttribute("latestExerciseTimeDetermination")
		public DeterminationMethod.DeterminationMethodBuilder getLatestExerciseTimeDetermination() {
			return latestExerciseTimeDetermination;
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder getOrCreateLatestExerciseTimeDetermination() {
			DeterminationMethod.DeterminationMethodBuilder result;
			if (latestExerciseTimeDetermination!=null) {
				result = latestExerciseTimeDetermination;
			}
			else {
				result = latestExerciseTimeDetermination = DeterminationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public SharedAmericanExercise.SharedAmericanExerciseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("commencementDate")
		public SharedAmericanExercise.SharedAmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate) {
			this.commencementDate = commencementDate==null?null:commencementDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expirationDate")
		public SharedAmericanExercise.SharedAmericanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate) {
			this.expirationDate = expirationDate==null?null:expirationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("latestExerciseTime")
		public SharedAmericanExercise.SharedAmericanExerciseBuilder setLatestExerciseTime(BusinessCenterTime latestExerciseTime) {
			this.latestExerciseTime = latestExerciseTime==null?null:latestExerciseTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("latestExerciseTimeDetermination")
		public SharedAmericanExercise.SharedAmericanExerciseBuilder setLatestExerciseTimeDetermination(DeterminationMethod latestExerciseTimeDetermination) {
			this.latestExerciseTimeDetermination = latestExerciseTimeDetermination==null?null:latestExerciseTimeDetermination.toBuilder();
			return this;
		}
		
		@Override
		public SharedAmericanExercise build() {
			return new SharedAmericanExercise.SharedAmericanExerciseImpl(this);
		}
		
		@Override
		public SharedAmericanExercise.SharedAmericanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SharedAmericanExercise.SharedAmericanExerciseBuilder prune() {
			super.prune();
			if (commencementDate!=null && !commencementDate.prune().hasData()) commencementDate = null;
			if (expirationDate!=null && !expirationDate.prune().hasData()) expirationDate = null;
			if (latestExerciseTime!=null && !latestExerciseTime.prune().hasData()) latestExerciseTime = null;
			if (latestExerciseTimeDetermination!=null && !latestExerciseTimeDetermination.prune().hasData()) latestExerciseTimeDetermination = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommencementDate()!=null && getCommencementDate().hasData()) return true;
			if (getExpirationDate()!=null && getExpirationDate().hasData()) return true;
			if (getLatestExerciseTime()!=null && getLatestExerciseTime().hasData()) return true;
			if (getLatestExerciseTimeDetermination()!=null && getLatestExerciseTimeDetermination().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SharedAmericanExercise.SharedAmericanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SharedAmericanExercise.SharedAmericanExerciseBuilder o = (SharedAmericanExercise.SharedAmericanExerciseBuilder) other;
			
			merger.mergeRosetta(getCommencementDate(), o.getCommencementDate(), this::setCommencementDate);
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			merger.mergeRosetta(getLatestExerciseTime(), o.getLatestExerciseTime(), this::setLatestExerciseTime);
			merger.mergeRosetta(getLatestExerciseTimeDetermination(), o.getLatestExerciseTimeDetermination(), this::setLatestExerciseTimeDetermination);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SharedAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(latestExerciseTimeDetermination, _that.getLatestExerciseTimeDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTimeDetermination != null ? latestExerciseTimeDetermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SharedAmericanExerciseBuilder {" +
				"commencementDate=" + this.commencementDate + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"latestExerciseTimeDetermination=" + this.latestExerciseTimeDetermination +
			'}' + " " + super.toString();
		}
	}
}
