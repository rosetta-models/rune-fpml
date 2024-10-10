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
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CutName;
import fpml.confirmation.Exercise;
import fpml.confirmation.Exercise.ExerciseBuilder;
import fpml.confirmation.Exercise.ExerciseBuilderImpl;
import fpml.confirmation.Exercise.ExerciseImpl;
import fpml.confirmation.FxEuropeanExercise;
import fpml.confirmation.FxEuropeanExercise.FxEuropeanExerciseBuilder;
import fpml.confirmation.FxEuropeanExercise.FxEuropeanExerciseBuilderImpl;
import fpml.confirmation.FxEuropeanExercise.FxEuropeanExerciseImpl;
import fpml.confirmation.meta.FxEuropeanExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes the characteristics for European exercise of FX products.
 * @version ${project.version}
 */
@RosettaDataType(value="FxEuropeanExercise", builder=FxEuropeanExercise.FxEuropeanExerciseBuilderImpl.class, version="${project.version}")
public interface FxEuropeanExercise extends Exercise {

	FxEuropeanExerciseMeta metaData = new FxEuropeanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Represents a standard expiry date as defined for an FX OTC option.
	 */
	Date getExpiryDate();
	/**
	 * Time at which the option expires on the expiry date, at the specified business center. This component represents the formal definition of option expiry time.
	 */
	BusinessCenterTime getExpiryTime();
	/**
	 * A code by which the expiry time is known in the market. This element is available to supplement the formal definition of expiry time, and must not be used in absence of the expiryTime element.
	 */
	CutName getCutName();
	/**
	 * The date on which both currencies traded will settle.
	 */
	Date getValueDate();

	/*********************** Build Methods  ***********************/
	FxEuropeanExercise build();
	
	FxEuropeanExercise.FxEuropeanExerciseBuilder toBuilder();
	
	static FxEuropeanExercise.FxEuropeanExerciseBuilder builder() {
		return new FxEuropeanExercise.FxEuropeanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxEuropeanExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxEuropeanExercise> getType() {
		return FxEuropeanExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
		processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.class, getExpiryTime());
		processRosetta(path.newSubPath("cutName"), processor, CutName.class, getCutName());
		processor.processBasic(path.newSubPath("valueDate"), Date.class, getValueDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxEuropeanExerciseBuilder extends FxEuropeanExercise, Exercise.ExerciseBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpiryTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getExpiryTime();
		CutName.CutNameBuilder getOrCreateCutName();
		CutName.CutNameBuilder getCutName();
		FxEuropeanExercise.FxEuropeanExerciseBuilder setId(String id);
		FxEuropeanExercise.FxEuropeanExerciseBuilder setExpiryDate(Date expiryDate);
		FxEuropeanExercise.FxEuropeanExerciseBuilder setExpiryTime(BusinessCenterTime expiryTime);
		FxEuropeanExercise.FxEuropeanExerciseBuilder setCutName(CutName cutName);
		FxEuropeanExercise.FxEuropeanExerciseBuilder setValueDate(Date valueDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
			processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpiryTime());
			processRosetta(path.newSubPath("cutName"), processor, CutName.CutNameBuilder.class, getCutName());
			processor.processBasic(path.newSubPath("valueDate"), Date.class, getValueDate(), this);
		}
		

		FxEuropeanExercise.FxEuropeanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of FxEuropeanExercise  ***********************/
	class FxEuropeanExerciseImpl extends Exercise.ExerciseImpl implements FxEuropeanExercise {
		private final Date expiryDate;
		private final BusinessCenterTime expiryTime;
		private final CutName cutName;
		private final Date valueDate;
		
		protected FxEuropeanExerciseImpl(FxEuropeanExercise.FxEuropeanExerciseBuilder builder) {
			super(builder);
			this.expiryDate = builder.getExpiryDate();
			this.expiryTime = ofNullable(builder.getExpiryTime()).map(f->f.build()).orElse(null);
			this.cutName = ofNullable(builder.getCutName()).map(f->f.build()).orElse(null);
			this.valueDate = builder.getValueDate();
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		public Date getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("expiryTime")
		public BusinessCenterTime getExpiryTime() {
			return expiryTime;
		}
		
		@Override
		@RosettaAttribute("cutName")
		public CutName getCutName() {
			return cutName;
		}
		
		@Override
		@RosettaAttribute("valueDate")
		public Date getValueDate() {
			return valueDate;
		}
		
		@Override
		public FxEuropeanExercise build() {
			return this;
		}
		
		@Override
		public FxEuropeanExercise.FxEuropeanExerciseBuilder toBuilder() {
			FxEuropeanExercise.FxEuropeanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxEuropeanExercise.FxEuropeanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getExpiryTime()).ifPresent(builder::setExpiryTime);
			ofNullable(getCutName()).ifPresent(builder::setCutName);
			ofNullable(getValueDate()).ifPresent(builder::setValueDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxEuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			if (!Objects.equals(cutName, _that.getCutName())) return false;
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			_result = 31 * _result + (cutName != null ? cutName.hashCode() : 0);
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxEuropeanExercise {" +
				"expiryDate=" + this.expiryDate + ", " +
				"expiryTime=" + this.expiryTime + ", " +
				"cutName=" + this.cutName + ", " +
				"valueDate=" + this.valueDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxEuropeanExercise  ***********************/
	class FxEuropeanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl  implements FxEuropeanExercise.FxEuropeanExerciseBuilder {
	
		protected Date expiryDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder expiryTime;
		protected CutName.CutNameBuilder cutName;
		protected Date valueDate;
	
		public FxEuropeanExerciseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expiryDate")
		public Date getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("expiryTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getExpiryTime() {
			return expiryTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpiryTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (expiryTime!=null) {
				result = expiryTime;
			}
			else {
				result = expiryTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cutName")
		public CutName.CutNameBuilder getCutName() {
			return cutName;
		}
		
		@Override
		public CutName.CutNameBuilder getOrCreateCutName() {
			CutName.CutNameBuilder result;
			if (cutName!=null) {
				result = cutName;
			}
			else {
				result = cutName = CutName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valueDate")
		public Date getValueDate() {
			return valueDate;
		}
		
		@Override
		@RosettaAttribute("id")
		public FxEuropeanExercise.FxEuropeanExerciseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("expiryDate")
		public FxEuropeanExercise.FxEuropeanExerciseBuilder setExpiryDate(Date expiryDate) {
			this.expiryDate = expiryDate==null?null:expiryDate;
			return this;
		}
		@Override
		@RosettaAttribute("expiryTime")
		public FxEuropeanExercise.FxEuropeanExerciseBuilder setExpiryTime(BusinessCenterTime expiryTime) {
			this.expiryTime = expiryTime==null?null:expiryTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cutName")
		public FxEuropeanExercise.FxEuropeanExerciseBuilder setCutName(CutName cutName) {
			this.cutName = cutName==null?null:cutName.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valueDate")
		public FxEuropeanExercise.FxEuropeanExerciseBuilder setValueDate(Date valueDate) {
			this.valueDate = valueDate==null?null:valueDate;
			return this;
		}
		
		@Override
		public FxEuropeanExercise build() {
			return new FxEuropeanExercise.FxEuropeanExerciseImpl(this);
		}
		
		@Override
		public FxEuropeanExercise.FxEuropeanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxEuropeanExercise.FxEuropeanExerciseBuilder prune() {
			super.prune();
			if (expiryTime!=null && !expiryTime.prune().hasData()) expiryTime = null;
			if (cutName!=null && !cutName.prune().hasData()) cutName = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExpiryDate()!=null) return true;
			if (getExpiryTime()!=null && getExpiryTime().hasData()) return true;
			if (getCutName()!=null && getCutName().hasData()) return true;
			if (getValueDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxEuropeanExercise.FxEuropeanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxEuropeanExercise.FxEuropeanExerciseBuilder o = (FxEuropeanExercise.FxEuropeanExerciseBuilder) other;
			
			merger.mergeRosetta(getExpiryTime(), o.getExpiryTime(), this::setExpiryTime);
			merger.mergeRosetta(getCutName(), o.getCutName(), this::setCutName);
			
			merger.mergeBasic(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeBasic(getValueDate(), o.getValueDate(), this::setValueDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxEuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			if (!Objects.equals(cutName, _that.getCutName())) return false;
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			_result = 31 * _result + (cutName != null ? cutName.hashCode() : 0);
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxEuropeanExerciseBuilder {" +
				"expiryDate=" + this.expiryDate + ", " +
				"expiryTime=" + this.expiryTime + ", " +
				"cutName=" + this.cutName + ", " +
				"valueDate=" + this.valueDate +
			'}' + " " + super.toString();
		}
	}
}
