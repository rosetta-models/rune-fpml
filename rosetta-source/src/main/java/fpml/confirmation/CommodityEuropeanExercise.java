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
import fpml.confirmation.CommodityEuropeanExercise;
import fpml.confirmation.CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder;
import fpml.confirmation.CommodityEuropeanExercise.CommodityEuropeanExerciseBuilderImpl;
import fpml.confirmation.CommodityEuropeanExercise.CommodityEuropeanExerciseImpl;
import fpml.confirmation.CommodityEuropeanExerciseSequence;
import fpml.confirmation.Exercise;
import fpml.confirmation.Exercise.ExerciseBuilder;
import fpml.confirmation.Exercise.ExerciseBuilderImpl;
import fpml.confirmation.Exercise.ExerciseImpl;
import fpml.confirmation.meta.CommodityEuropeanExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining exercise procedures associated with a European style exercise of a commodity option.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityEuropeanExercise", builder=CommodityEuropeanExercise.CommodityEuropeanExerciseBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityEuropeanExercise extends Exercise {

	CommodityEuropeanExerciseMeta metaData = new CommodityEuropeanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The last day within an exercise period for an American style option. For a European style option it is the only day within the exercise period. For an averaging option this is equivalent to the Termination Date.
	 */
	AdjustableOrRelativeDate getExpirationDate();
	CommodityEuropeanExerciseSequence getCommodityEuropeanExerciseSequence();
	/**
	 * The specific time of day on which the option expires.
	 */
	BusinessCenterTime getExpirationTime();

	/*********************** Build Methods  ***********************/
	CommodityEuropeanExercise build();
	
	CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder toBuilder();
	
	static CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder builder() {
		return new CommodityEuropeanExercise.CommodityEuropeanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityEuropeanExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityEuropeanExercise> getType() {
		return CommodityEuropeanExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processRosetta(path.newSubPath("commodityEuropeanExerciseSequence"), processor, CommodityEuropeanExerciseSequence.class, getCommodityEuropeanExerciseSequence());
		processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.class, getExpirationTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityEuropeanExerciseBuilder extends CommodityEuropeanExercise, Exercise.ExerciseBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate();
		CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder getOrCreateCommodityEuropeanExerciseSequence();
		CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder getCommodityEuropeanExerciseSequence();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpirationTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getExpirationTime();
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder setId(String id);
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder setCommodityEuropeanExerciseSequence(CommodityEuropeanExerciseSequence commodityEuropeanExerciseSequence);
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder setExpirationTime(BusinessCenterTime expirationTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processRosetta(path.newSubPath("commodityEuropeanExerciseSequence"), processor, CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder.class, getCommodityEuropeanExerciseSequence());
			processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpirationTime());
		}
		

		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityEuropeanExercise  ***********************/
	class CommodityEuropeanExerciseImpl extends Exercise.ExerciseImpl implements CommodityEuropeanExercise {
		private final AdjustableOrRelativeDate expirationDate;
		private final CommodityEuropeanExerciseSequence commodityEuropeanExerciseSequence;
		private final BusinessCenterTime expirationTime;
		
		protected CommodityEuropeanExerciseImpl(CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder builder) {
			super(builder);
			this.expirationDate = ofNullable(builder.getExpirationDate()).map(f->f.build()).orElse(null);
			this.commodityEuropeanExerciseSequence = ofNullable(builder.getCommodityEuropeanExerciseSequence()).map(f->f.build()).orElse(null);
			this.expirationTime = ofNullable(builder.getExpirationTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		public AdjustableOrRelativeDate getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		@RosettaAttribute("commodityEuropeanExerciseSequence")
		public CommodityEuropeanExerciseSequence getCommodityEuropeanExerciseSequence() {
			return commodityEuropeanExerciseSequence;
		}
		
		@Override
		@RosettaAttribute("expirationTime")
		public BusinessCenterTime getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		public CommodityEuropeanExercise build() {
			return this;
		}
		
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder toBuilder() {
			CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
			ofNullable(getCommodityEuropeanExerciseSequence()).ifPresent(builder::setCommodityEuropeanExerciseSequence);
			ofNullable(getExpirationTime()).ifPresent(builder::setExpirationTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityEuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(commodityEuropeanExerciseSequence, _that.getCommodityEuropeanExerciseSequence())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (commodityEuropeanExerciseSequence != null ? commodityEuropeanExerciseSequence.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityEuropeanExercise {" +
				"expirationDate=" + this.expirationDate + ", " +
				"commodityEuropeanExerciseSequence=" + this.commodityEuropeanExerciseSequence + ", " +
				"expirationTime=" + this.expirationTime +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityEuropeanExercise  ***********************/
	class CommodityEuropeanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl  implements CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder expirationDate;
		protected CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder commodityEuropeanExerciseSequence;
		protected BusinessCenterTime.BusinessCenterTimeBuilder expirationTime;
	
		public CommodityEuropeanExerciseBuilderImpl() {
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
		@RosettaAttribute("commodityEuropeanExerciseSequence")
		public CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder getCommodityEuropeanExerciseSequence() {
			return commodityEuropeanExerciseSequence;
		}
		
		@Override
		public CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder getOrCreateCommodityEuropeanExerciseSequence() {
			CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder result;
			if (commodityEuropeanExerciseSequence!=null) {
				result = commodityEuropeanExerciseSequence;
			}
			else {
				result = commodityEuropeanExerciseSequence = CommodityEuropeanExerciseSequence.builder();
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
		@RosettaAttribute("id")
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("expirationDate")
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate) {
			this.expirationDate = expirationDate==null?null:expirationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityEuropeanExerciseSequence")
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder setCommodityEuropeanExerciseSequence(CommodityEuropeanExerciseSequence commodityEuropeanExerciseSequence) {
			this.commodityEuropeanExerciseSequence = commodityEuropeanExerciseSequence==null?null:commodityEuropeanExerciseSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expirationTime")
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder setExpirationTime(BusinessCenterTime expirationTime) {
			this.expirationTime = expirationTime==null?null:expirationTime.toBuilder();
			return this;
		}
		
		@Override
		public CommodityEuropeanExercise build() {
			return new CommodityEuropeanExercise.CommodityEuropeanExerciseImpl(this);
		}
		
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder prune() {
			super.prune();
			if (expirationDate!=null && !expirationDate.prune().hasData()) expirationDate = null;
			if (commodityEuropeanExerciseSequence!=null && !commodityEuropeanExerciseSequence.prune().hasData()) commodityEuropeanExerciseSequence = null;
			if (expirationTime!=null && !expirationTime.prune().hasData()) expirationTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExpirationDate()!=null && getExpirationDate().hasData()) return true;
			if (getCommodityEuropeanExerciseSequence()!=null && getCommodityEuropeanExerciseSequence().hasData()) return true;
			if (getExpirationTime()!=null && getExpirationTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder o = (CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder) other;
			
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			merger.mergeRosetta(getCommodityEuropeanExerciseSequence(), o.getCommodityEuropeanExerciseSequence(), this::setCommodityEuropeanExerciseSequence);
			merger.mergeRosetta(getExpirationTime(), o.getExpirationTime(), this::setExpirationTime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityEuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(commodityEuropeanExerciseSequence, _that.getCommodityEuropeanExerciseSequence())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (commodityEuropeanExerciseSequence != null ? commodityEuropeanExerciseSequence.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityEuropeanExerciseBuilder {" +
				"expirationDate=" + this.expirationDate + ", " +
				"commodityEuropeanExerciseSequence=" + this.commodityEuropeanExerciseSequence + ", " +
				"expirationTime=" + this.expirationTime +
			'}' + " " + super.toString();
		}
	}
}
