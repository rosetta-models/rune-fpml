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
import fpml.confirmation.AdjustableRelativeOrPeriodicDates2;
import fpml.confirmation.CommodityPhysicalEuropeanExercise;
import fpml.confirmation.CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder;
import fpml.confirmation.CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilderImpl;
import fpml.confirmation.CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseImpl;
import fpml.confirmation.CommodityRelativeExpirationDates;
import fpml.confirmation.Exercise;
import fpml.confirmation.Exercise.ExerciseBuilder;
import fpml.confirmation.Exercise.ExerciseBuilderImpl;
import fpml.confirmation.Exercise.ExerciseImpl;
import fpml.confirmation.PrevailingTime;
import fpml.confirmation.meta.CommodityPhysicalEuropeanExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The parameters for defining the expiration date(s) and time(s) for a European style option.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityPhysicalEuropeanExercise", builder=CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilderImpl.class, version="${project.version}")
public interface CommodityPhysicalEuropeanExercise extends Exercise {

	CommodityPhysicalEuropeanExerciseMeta metaData = new CommodityPhysicalEuropeanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Expiration Date of a single expiry European-style option or the first Expiration Date of a multiple expiry or daily expiring option.
	 */
	AdjustableOrRelativeDate getExpirationDate();
	/**
	 * The Expiration Date(s) of a European-style option.
	 */
	AdjustableRelativeOrPeriodicDates2 getExpirationDates();
	/**
	 * The Expiration Date(s) of a European-style option where it is relative to the occurrence of an external event.
	 */
	CommodityRelativeExpirationDates getRelativeExpirationDates();
	/**
	 * The specific time of day at which the option expires.
	 */
	PrevailingTime getExpirationTime();

	/*********************** Build Methods  ***********************/
	CommodityPhysicalEuropeanExercise build();
	
	CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder toBuilder();
	
	static CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder builder() {
		return new CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPhysicalEuropeanExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPhysicalEuropeanExercise> getType() {
		return CommodityPhysicalEuropeanExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processRosetta(path.newSubPath("expirationDates"), processor, AdjustableRelativeOrPeriodicDates2.class, getExpirationDates());
		processRosetta(path.newSubPath("relativeExpirationDates"), processor, CommodityRelativeExpirationDates.class, getRelativeExpirationDates());
		processRosetta(path.newSubPath("expirationTime"), processor, PrevailingTime.class, getExpirationTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPhysicalEuropeanExerciseBuilder extends CommodityPhysicalEuropeanExercise, Exercise.ExerciseBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate();
		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder getOrCreateExpirationDates();
		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder getExpirationDates();
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getOrCreateRelativeExpirationDates();
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getRelativeExpirationDates();
		PrevailingTime.PrevailingTimeBuilder getOrCreateExpirationTime();
		PrevailingTime.PrevailingTimeBuilder getExpirationTime();
		CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder setId(String id);
		CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);
		CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder setExpirationDates(AdjustableRelativeOrPeriodicDates2 expirationDates);
		CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder setRelativeExpirationDates(CommodityRelativeExpirationDates relativeExpirationDates);
		CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder setExpirationTime(PrevailingTime expirationTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processRosetta(path.newSubPath("expirationDates"), processor, AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder.class, getExpirationDates());
			processRosetta(path.newSubPath("relativeExpirationDates"), processor, CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder.class, getRelativeExpirationDates());
			processRosetta(path.newSubPath("expirationTime"), processor, PrevailingTime.PrevailingTimeBuilder.class, getExpirationTime());
		}
		

		CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPhysicalEuropeanExercise  ***********************/
	class CommodityPhysicalEuropeanExerciseImpl extends Exercise.ExerciseImpl implements CommodityPhysicalEuropeanExercise {
		private final AdjustableOrRelativeDate expirationDate;
		private final AdjustableRelativeOrPeriodicDates2 expirationDates;
		private final CommodityRelativeExpirationDates relativeExpirationDates;
		private final PrevailingTime expirationTime;
		
		protected CommodityPhysicalEuropeanExerciseImpl(CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder builder) {
			super(builder);
			this.expirationDate = ofNullable(builder.getExpirationDate()).map(f->f.build()).orElse(null);
			this.expirationDates = ofNullable(builder.getExpirationDates()).map(f->f.build()).orElse(null);
			this.relativeExpirationDates = ofNullable(builder.getRelativeExpirationDates()).map(f->f.build()).orElse(null);
			this.expirationTime = ofNullable(builder.getExpirationTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		public AdjustableOrRelativeDate getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		@RosettaAttribute("expirationDates")
		public AdjustableRelativeOrPeriodicDates2 getExpirationDates() {
			return expirationDates;
		}
		
		@Override
		@RosettaAttribute("relativeExpirationDates")
		public CommodityRelativeExpirationDates getRelativeExpirationDates() {
			return relativeExpirationDates;
		}
		
		@Override
		@RosettaAttribute("expirationTime")
		public PrevailingTime getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		public CommodityPhysicalEuropeanExercise build() {
			return this;
		}
		
		@Override
		public CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder toBuilder() {
			CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
			ofNullable(getExpirationDates()).ifPresent(builder::setExpirationDates);
			ofNullable(getRelativeExpirationDates()).ifPresent(builder::setRelativeExpirationDates);
			ofNullable(getExpirationTime()).ifPresent(builder::setExpirationTime);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPhysicalEuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(expirationDates, _that.getExpirationDates())) return false;
			if (!Objects.equals(relativeExpirationDates, _that.getRelativeExpirationDates())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (expirationDates != null ? expirationDates.hashCode() : 0);
			_result = 31 * _result + (relativeExpirationDates != null ? relativeExpirationDates.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalEuropeanExercise {" +
				"expirationDate=" + this.expirationDate + ", " +
				"expirationDates=" + this.expirationDates + ", " +
				"relativeExpirationDates=" + this.relativeExpirationDates + ", " +
				"expirationTime=" + this.expirationTime +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityPhysicalEuropeanExercise  ***********************/
	class CommodityPhysicalEuropeanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl  implements CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder expirationDate;
		protected AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder expirationDates;
		protected CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder relativeExpirationDates;
		protected PrevailingTime.PrevailingTimeBuilder expirationTime;
	
		public CommodityPhysicalEuropeanExerciseBuilderImpl() {
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
		@RosettaAttribute("expirationDates")
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder getExpirationDates() {
			return expirationDates;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder getOrCreateExpirationDates() {
			AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder result;
			if (expirationDates!=null) {
				result = expirationDates;
			}
			else {
				result = expirationDates = AdjustableRelativeOrPeriodicDates2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeExpirationDates")
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getRelativeExpirationDates() {
			return relativeExpirationDates;
		}
		
		@Override
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getOrCreateRelativeExpirationDates() {
			CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder result;
			if (relativeExpirationDates!=null) {
				result = relativeExpirationDates;
			}
			else {
				result = relativeExpirationDates = CommodityRelativeExpirationDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationTime")
		public PrevailingTime.PrevailingTimeBuilder getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		public PrevailingTime.PrevailingTimeBuilder getOrCreateExpirationTime() {
			PrevailingTime.PrevailingTimeBuilder result;
			if (expirationTime!=null) {
				result = expirationTime;
			}
			else {
				result = expirationTime = PrevailingTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("expirationDate")
		public CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate) {
			this.expirationDate = expirationDate==null?null:expirationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expirationDates")
		public CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder setExpirationDates(AdjustableRelativeOrPeriodicDates2 expirationDates) {
			this.expirationDates = expirationDates==null?null:expirationDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relativeExpirationDates")
		public CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder setRelativeExpirationDates(CommodityRelativeExpirationDates relativeExpirationDates) {
			this.relativeExpirationDates = relativeExpirationDates==null?null:relativeExpirationDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expirationTime")
		public CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder setExpirationTime(PrevailingTime expirationTime) {
			this.expirationTime = expirationTime==null?null:expirationTime.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPhysicalEuropeanExercise build() {
			return new CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseImpl(this);
		}
		
		@Override
		public CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder prune() {
			super.prune();
			if (expirationDate!=null && !expirationDate.prune().hasData()) expirationDate = null;
			if (expirationDates!=null && !expirationDates.prune().hasData()) expirationDates = null;
			if (relativeExpirationDates!=null && !relativeExpirationDates.prune().hasData()) relativeExpirationDates = null;
			if (expirationTime!=null && !expirationTime.prune().hasData()) expirationTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExpirationDate()!=null && getExpirationDate().hasData()) return true;
			if (getExpirationDates()!=null && getExpirationDates().hasData()) return true;
			if (getRelativeExpirationDates()!=null && getRelativeExpirationDates().hasData()) return true;
			if (getExpirationTime()!=null && getExpirationTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder o = (CommodityPhysicalEuropeanExercise.CommodityPhysicalEuropeanExerciseBuilder) other;
			
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			merger.mergeRosetta(getExpirationDates(), o.getExpirationDates(), this::setExpirationDates);
			merger.mergeRosetta(getRelativeExpirationDates(), o.getRelativeExpirationDates(), this::setRelativeExpirationDates);
			merger.mergeRosetta(getExpirationTime(), o.getExpirationTime(), this::setExpirationTime);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPhysicalEuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(expirationDates, _that.getExpirationDates())) return false;
			if (!Objects.equals(relativeExpirationDates, _that.getRelativeExpirationDates())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (expirationDates != null ? expirationDates.hashCode() : 0);
			_result = 31 * _result + (relativeExpirationDates != null ? relativeExpirationDates.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalEuropeanExerciseBuilder {" +
				"expirationDate=" + this.expirationDate + ", " +
				"expirationDates=" + this.expirationDates + ", " +
				"relativeExpirationDates=" + this.relativeExpirationDates + ", " +
				"expirationTime=" + this.expirationTime +
			'}' + " " + super.toString();
		}
	}
}
