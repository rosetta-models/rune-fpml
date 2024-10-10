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
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CommodityAmericanExercise;
import fpml.confirmation.CommodityAmericanExercise.CommodityAmericanExerciseBuilder;
import fpml.confirmation.CommodityAmericanExercise.CommodityAmericanExerciseBuilderImpl;
import fpml.confirmation.CommodityAmericanExercise.CommodityAmericanExerciseImpl;
import fpml.confirmation.CommodityAmericanExerciseSequence;
import fpml.confirmation.CommodityExercisePeriods;
import fpml.confirmation.CommodityMultipleExercise;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.Exercise;
import fpml.confirmation.Exercise.ExerciseBuilder;
import fpml.confirmation.Exercise.ExerciseBuilderImpl;
import fpml.confirmation.Exercise.ExerciseImpl;
import fpml.confirmation.meta.CommodityAmericanExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining exercise procedures associated with an American style exercise of a commodity option.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityAmericanExercise", builder=CommodityAmericanExercise.CommodityAmericanExerciseBuilderImpl.class, version="${project.version}")
public interface CommodityAmericanExercise extends Exercise {

	CommodityAmericanExerciseMeta metaData = new CommodityAmericanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Describes the American exercise periods.
	 */
	CommodityExercisePeriods getExercisePeriod();
	CommodityAmericanExerciseSequence getCommodityAmericanExerciseSequence();
	/**
	 * For a Bermuda or American style option, the latest time on an exercise business day (excluding the expiration date) within the exercise period that notice can be given by the buyer to the seller or seller&#39;s agent. Notice of exercise given after this time will be deemed to have been given on the next exercise business day.
	 */
	BusinessCenterTime getLatestExerciseTime();
	/**
	 * Latest exercise time determination method.
	 */
	DeterminationMethod getLatestExerciseTimeDetermination();
	/**
	 * The specific time of day on which the option expires.
	 */
	BusinessCenterTime getExpirationTime();
	/**
	 * The presence of this element indicates that the option may be partially exercised. It is not applicable to European or Asian options.
	 */
	CommodityMultipleExercise getMultipleExercise();

	/*********************** Build Methods  ***********************/
	CommodityAmericanExercise build();
	
	CommodityAmericanExercise.CommodityAmericanExerciseBuilder toBuilder();
	
	static CommodityAmericanExercise.CommodityAmericanExerciseBuilder builder() {
		return new CommodityAmericanExercise.CommodityAmericanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityAmericanExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityAmericanExercise> getType() {
		return CommodityAmericanExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("exercisePeriod"), processor, CommodityExercisePeriods.class, getExercisePeriod());
		processRosetta(path.newSubPath("commodityAmericanExerciseSequence"), processor, CommodityAmericanExerciseSequence.class, getCommodityAmericanExerciseSequence());
		processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.class, getLatestExerciseTime());
		processRosetta(path.newSubPath("latestExerciseTimeDetermination"), processor, DeterminationMethod.class, getLatestExerciseTimeDetermination());
		processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.class, getExpirationTime());
		processRosetta(path.newSubPath("multipleExercise"), processor, CommodityMultipleExercise.class, getMultipleExercise());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityAmericanExerciseBuilder extends CommodityAmericanExercise, Exercise.ExerciseBuilder {
		CommodityExercisePeriods.CommodityExercisePeriodsBuilder getOrCreateExercisePeriod();
		CommodityExercisePeriods.CommodityExercisePeriodsBuilder getExercisePeriod();
		CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder getOrCreateCommodityAmericanExerciseSequence();
		CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder getCommodityAmericanExerciseSequence();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestExerciseTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getLatestExerciseTime();
		DeterminationMethod.DeterminationMethodBuilder getOrCreateLatestExerciseTimeDetermination();
		DeterminationMethod.DeterminationMethodBuilder getLatestExerciseTimeDetermination();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpirationTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getExpirationTime();
		CommodityMultipleExercise.CommodityMultipleExerciseBuilder getOrCreateMultipleExercise();
		CommodityMultipleExercise.CommodityMultipleExerciseBuilder getMultipleExercise();
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder setId(String id);
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder setExercisePeriod(CommodityExercisePeriods exercisePeriod);
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder setCommodityAmericanExerciseSequence(CommodityAmericanExerciseSequence commodityAmericanExerciseSequence);
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder setLatestExerciseTime(BusinessCenterTime latestExerciseTime);
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder setLatestExerciseTimeDetermination(DeterminationMethod latestExerciseTimeDetermination);
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder setExpirationTime(BusinessCenterTime expirationTime);
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder setMultipleExercise(CommodityMultipleExercise multipleExercise);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("exercisePeriod"), processor, CommodityExercisePeriods.CommodityExercisePeriodsBuilder.class, getExercisePeriod());
			processRosetta(path.newSubPath("commodityAmericanExerciseSequence"), processor, CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder.class, getCommodityAmericanExerciseSequence());
			processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getLatestExerciseTime());
			processRosetta(path.newSubPath("latestExerciseTimeDetermination"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getLatestExerciseTimeDetermination());
			processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpirationTime());
			processRosetta(path.newSubPath("multipleExercise"), processor, CommodityMultipleExercise.CommodityMultipleExerciseBuilder.class, getMultipleExercise());
		}
		

		CommodityAmericanExercise.CommodityAmericanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityAmericanExercise  ***********************/
	class CommodityAmericanExerciseImpl extends Exercise.ExerciseImpl implements CommodityAmericanExercise {
		private final CommodityExercisePeriods exercisePeriod;
		private final CommodityAmericanExerciseSequence commodityAmericanExerciseSequence;
		private final BusinessCenterTime latestExerciseTime;
		private final DeterminationMethod latestExerciseTimeDetermination;
		private final BusinessCenterTime expirationTime;
		private final CommodityMultipleExercise multipleExercise;
		
		protected CommodityAmericanExerciseImpl(CommodityAmericanExercise.CommodityAmericanExerciseBuilder builder) {
			super(builder);
			this.exercisePeriod = ofNullable(builder.getExercisePeriod()).map(f->f.build()).orElse(null);
			this.commodityAmericanExerciseSequence = ofNullable(builder.getCommodityAmericanExerciseSequence()).map(f->f.build()).orElse(null);
			this.latestExerciseTime = ofNullable(builder.getLatestExerciseTime()).map(f->f.build()).orElse(null);
			this.latestExerciseTimeDetermination = ofNullable(builder.getLatestExerciseTimeDetermination()).map(f->f.build()).orElse(null);
			this.expirationTime = ofNullable(builder.getExpirationTime()).map(f->f.build()).orElse(null);
			this.multipleExercise = ofNullable(builder.getMultipleExercise()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exercisePeriod")
		public CommodityExercisePeriods getExercisePeriod() {
			return exercisePeriod;
		}
		
		@Override
		@RosettaAttribute("commodityAmericanExerciseSequence")
		public CommodityAmericanExerciseSequence getCommodityAmericanExerciseSequence() {
			return commodityAmericanExerciseSequence;
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
		@RosettaAttribute("expirationTime")
		public BusinessCenterTime getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		@RosettaAttribute("multipleExercise")
		public CommodityMultipleExercise getMultipleExercise() {
			return multipleExercise;
		}
		
		@Override
		public CommodityAmericanExercise build() {
			return this;
		}
		
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder toBuilder() {
			CommodityAmericanExercise.CommodityAmericanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityAmericanExercise.CommodityAmericanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExercisePeriod()).ifPresent(builder::setExercisePeriod);
			ofNullable(getCommodityAmericanExerciseSequence()).ifPresent(builder::setCommodityAmericanExerciseSequence);
			ofNullable(getLatestExerciseTime()).ifPresent(builder::setLatestExerciseTime);
			ofNullable(getLatestExerciseTimeDetermination()).ifPresent(builder::setLatestExerciseTimeDetermination);
			ofNullable(getExpirationTime()).ifPresent(builder::setExpirationTime);
			ofNullable(getMultipleExercise()).ifPresent(builder::setMultipleExercise);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(exercisePeriod, _that.getExercisePeriod())) return false;
			if (!Objects.equals(commodityAmericanExerciseSequence, _that.getCommodityAmericanExerciseSequence())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(latestExerciseTimeDetermination, _that.getLatestExerciseTimeDetermination())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(multipleExercise, _that.getMultipleExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exercisePeriod != null ? exercisePeriod.hashCode() : 0);
			_result = 31 * _result + (commodityAmericanExerciseSequence != null ? commodityAmericanExerciseSequence.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTimeDetermination != null ? latestExerciseTimeDetermination.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (multipleExercise != null ? multipleExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityAmericanExercise {" +
				"exercisePeriod=" + this.exercisePeriod + ", " +
				"commodityAmericanExerciseSequence=" + this.commodityAmericanExerciseSequence + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"latestExerciseTimeDetermination=" + this.latestExerciseTimeDetermination + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"multipleExercise=" + this.multipleExercise +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityAmericanExercise  ***********************/
	class CommodityAmericanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl  implements CommodityAmericanExercise.CommodityAmericanExerciseBuilder {
	
		protected CommodityExercisePeriods.CommodityExercisePeriodsBuilder exercisePeriod;
		protected CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder commodityAmericanExerciseSequence;
		protected BusinessCenterTime.BusinessCenterTimeBuilder latestExerciseTime;
		protected DeterminationMethod.DeterminationMethodBuilder latestExerciseTimeDetermination;
		protected BusinessCenterTime.BusinessCenterTimeBuilder expirationTime;
		protected CommodityMultipleExercise.CommodityMultipleExerciseBuilder multipleExercise;
	
		public CommodityAmericanExerciseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("exercisePeriod")
		public CommodityExercisePeriods.CommodityExercisePeriodsBuilder getExercisePeriod() {
			return exercisePeriod;
		}
		
		@Override
		public CommodityExercisePeriods.CommodityExercisePeriodsBuilder getOrCreateExercisePeriod() {
			CommodityExercisePeriods.CommodityExercisePeriodsBuilder result;
			if (exercisePeriod!=null) {
				result = exercisePeriod;
			}
			else {
				result = exercisePeriod = CommodityExercisePeriods.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityAmericanExerciseSequence")
		public CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder getCommodityAmericanExerciseSequence() {
			return commodityAmericanExerciseSequence;
		}
		
		@Override
		public CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder getOrCreateCommodityAmericanExerciseSequence() {
			CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder result;
			if (commodityAmericanExerciseSequence!=null) {
				result = commodityAmericanExerciseSequence;
			}
			else {
				result = commodityAmericanExerciseSequence = CommodityAmericanExerciseSequence.builder();
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
		public CommodityMultipleExercise.CommodityMultipleExerciseBuilder getMultipleExercise() {
			return multipleExercise;
		}
		
		@Override
		public CommodityMultipleExercise.CommodityMultipleExerciseBuilder getOrCreateMultipleExercise() {
			CommodityMultipleExercise.CommodityMultipleExerciseBuilder result;
			if (multipleExercise!=null) {
				result = multipleExercise;
			}
			else {
				result = multipleExercise = CommodityMultipleExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("exercisePeriod")
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder setExercisePeriod(CommodityExercisePeriods exercisePeriod) {
			this.exercisePeriod = exercisePeriod==null?null:exercisePeriod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityAmericanExerciseSequence")
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder setCommodityAmericanExerciseSequence(CommodityAmericanExerciseSequence commodityAmericanExerciseSequence) {
			this.commodityAmericanExerciseSequence = commodityAmericanExerciseSequence==null?null:commodityAmericanExerciseSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("latestExerciseTime")
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder setLatestExerciseTime(BusinessCenterTime latestExerciseTime) {
			this.latestExerciseTime = latestExerciseTime==null?null:latestExerciseTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("latestExerciseTimeDetermination")
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder setLatestExerciseTimeDetermination(DeterminationMethod latestExerciseTimeDetermination) {
			this.latestExerciseTimeDetermination = latestExerciseTimeDetermination==null?null:latestExerciseTimeDetermination.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expirationTime")
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder setExpirationTime(BusinessCenterTime expirationTime) {
			this.expirationTime = expirationTime==null?null:expirationTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("multipleExercise")
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder setMultipleExercise(CommodityMultipleExercise multipleExercise) {
			this.multipleExercise = multipleExercise==null?null:multipleExercise.toBuilder();
			return this;
		}
		
		@Override
		public CommodityAmericanExercise build() {
			return new CommodityAmericanExercise.CommodityAmericanExerciseImpl(this);
		}
		
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder prune() {
			super.prune();
			if (exercisePeriod!=null && !exercisePeriod.prune().hasData()) exercisePeriod = null;
			if (commodityAmericanExerciseSequence!=null && !commodityAmericanExerciseSequence.prune().hasData()) commodityAmericanExerciseSequence = null;
			if (latestExerciseTime!=null && !latestExerciseTime.prune().hasData()) latestExerciseTime = null;
			if (latestExerciseTimeDetermination!=null && !latestExerciseTimeDetermination.prune().hasData()) latestExerciseTimeDetermination = null;
			if (expirationTime!=null && !expirationTime.prune().hasData()) expirationTime = null;
			if (multipleExercise!=null && !multipleExercise.prune().hasData()) multipleExercise = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExercisePeriod()!=null && getExercisePeriod().hasData()) return true;
			if (getCommodityAmericanExerciseSequence()!=null && getCommodityAmericanExerciseSequence().hasData()) return true;
			if (getLatestExerciseTime()!=null && getLatestExerciseTime().hasData()) return true;
			if (getLatestExerciseTimeDetermination()!=null && getLatestExerciseTimeDetermination().hasData()) return true;
			if (getExpirationTime()!=null && getExpirationTime().hasData()) return true;
			if (getMultipleExercise()!=null && getMultipleExercise().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityAmericanExercise.CommodityAmericanExerciseBuilder o = (CommodityAmericanExercise.CommodityAmericanExerciseBuilder) other;
			
			merger.mergeRosetta(getExercisePeriod(), o.getExercisePeriod(), this::setExercisePeriod);
			merger.mergeRosetta(getCommodityAmericanExerciseSequence(), o.getCommodityAmericanExerciseSequence(), this::setCommodityAmericanExerciseSequence);
			merger.mergeRosetta(getLatestExerciseTime(), o.getLatestExerciseTime(), this::setLatestExerciseTime);
			merger.mergeRosetta(getLatestExerciseTimeDetermination(), o.getLatestExerciseTimeDetermination(), this::setLatestExerciseTimeDetermination);
			merger.mergeRosetta(getExpirationTime(), o.getExpirationTime(), this::setExpirationTime);
			merger.mergeRosetta(getMultipleExercise(), o.getMultipleExercise(), this::setMultipleExercise);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(exercisePeriod, _that.getExercisePeriod())) return false;
			if (!Objects.equals(commodityAmericanExerciseSequence, _that.getCommodityAmericanExerciseSequence())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(latestExerciseTimeDetermination, _that.getLatestExerciseTimeDetermination())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(multipleExercise, _that.getMultipleExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exercisePeriod != null ? exercisePeriod.hashCode() : 0);
			_result = 31 * _result + (commodityAmericanExerciseSequence != null ? commodityAmericanExerciseSequence.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTimeDetermination != null ? latestExerciseTimeDetermination.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (multipleExercise != null ? multipleExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityAmericanExerciseBuilder {" +
				"exercisePeriod=" + this.exercisePeriod + ", " +
				"commodityAmericanExerciseSequence=" + this.commodityAmericanExerciseSequence + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"latestExerciseTimeDetermination=" + this.latestExerciseTimeDetermination + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"multipleExercise=" + this.multipleExercise +
			'}' + " " + super.toString();
		}
	}
}
