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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CutName;
import fpml.confirmation.Exercise;
import fpml.confirmation.Exercise.ExerciseBuilder;
import fpml.confirmation.Exercise.ExerciseBuilderImpl;
import fpml.confirmation.Exercise.ExerciseImpl;
import fpml.confirmation.FxDigitalAmericanExercise;
import fpml.confirmation.FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder;
import fpml.confirmation.FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilderImpl;
import fpml.confirmation.FxDigitalAmericanExercise.FxDigitalAmericanExerciseImpl;
import fpml.confirmation.meta.FxDigitalAmericanExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Descrines the characteristics for American exercise in FX digital options.
 * @version ${project.version}
 */
@RosettaDataType(value="FxDigitalAmericanExercise", builder=FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilderImpl.class, version="${project.version}")
public interface FxDigitalAmericanExercise extends Exercise {

	FxDigitalAmericanExerciseMeta metaData = new FxDigitalAmericanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The earliest date on which the option can be exercised.
	 */
	AdjustableOrRelativeDate getCommencementDate();
	/**
	 * The latest date on which the option can be exercised.
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
	 * The latest date on which both currencies traded will settle.
	 */
	Date getLatestValueDate();

	/*********************** Build Methods  ***********************/
	FxDigitalAmericanExercise build();
	
	FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder toBuilder();
	
	static FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder builder() {
		return new FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxDigitalAmericanExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxDigitalAmericanExercise> getType() {
		return FxDigitalAmericanExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.class, getCommencementDate());
		processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
		processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.class, getExpiryTime());
		processRosetta(path.newSubPath("cutName"), processor, CutName.class, getCutName());
		processor.processBasic(path.newSubPath("latestValueDate"), Date.class, getLatestValueDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxDigitalAmericanExerciseBuilder extends FxDigitalAmericanExercise, Exercise.ExerciseBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCommencementDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCommencementDate();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpiryTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getExpiryTime();
		CutName.CutNameBuilder getOrCreateCutName();
		CutName.CutNameBuilder getCutName();
		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setId(String id);
		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate);
		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setExpiryDate(Date expiryDate);
		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setExpiryTime(BusinessCenterTime expiryTime);
		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setCutName(CutName cutName);
		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setLatestValueDate(Date latestValueDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getCommencementDate());
			processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
			processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpiryTime());
			processRosetta(path.newSubPath("cutName"), processor, CutName.CutNameBuilder.class, getCutName());
			processor.processBasic(path.newSubPath("latestValueDate"), Date.class, getLatestValueDate(), this);
		}
		

		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of FxDigitalAmericanExercise  ***********************/
	class FxDigitalAmericanExerciseImpl extends Exercise.ExerciseImpl implements FxDigitalAmericanExercise {
		private final AdjustableOrRelativeDate commencementDate;
		private final Date expiryDate;
		private final BusinessCenterTime expiryTime;
		private final CutName cutName;
		private final Date latestValueDate;
		
		protected FxDigitalAmericanExerciseImpl(FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder builder) {
			super(builder);
			this.commencementDate = ofNullable(builder.getCommencementDate()).map(f->f.build()).orElse(null);
			this.expiryDate = builder.getExpiryDate();
			this.expiryTime = ofNullable(builder.getExpiryTime()).map(f->f.build()).orElse(null);
			this.cutName = ofNullable(builder.getCutName()).map(f->f.build()).orElse(null);
			this.latestValueDate = builder.getLatestValueDate();
		}
		
		@Override
		@RosettaAttribute("commencementDate")
		public AdjustableOrRelativeDate getCommencementDate() {
			return commencementDate;
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
		@RosettaAttribute("latestValueDate")
		public Date getLatestValueDate() {
			return latestValueDate;
		}
		
		@Override
		public FxDigitalAmericanExercise build() {
			return this;
		}
		
		@Override
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder toBuilder() {
			FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommencementDate()).ifPresent(builder::setCommencementDate);
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getExpiryTime()).ifPresent(builder::setExpiryTime);
			ofNullable(getCutName()).ifPresent(builder::setCutName);
			ofNullable(getLatestValueDate()).ifPresent(builder::setLatestValueDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxDigitalAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			if (!Objects.equals(cutName, _that.getCutName())) return false;
			if (!Objects.equals(latestValueDate, _that.getLatestValueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			_result = 31 * _result + (cutName != null ? cutName.hashCode() : 0);
			_result = 31 * _result + (latestValueDate != null ? latestValueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDigitalAmericanExercise {" +
				"commencementDate=" + this.commencementDate + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"expiryTime=" + this.expiryTime + ", " +
				"cutName=" + this.cutName + ", " +
				"latestValueDate=" + this.latestValueDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxDigitalAmericanExercise  ***********************/
	class FxDigitalAmericanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl  implements FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder commencementDate;
		protected Date expiryDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder expiryTime;
		protected CutName.CutNameBuilder cutName;
		protected Date latestValueDate;
	
		public FxDigitalAmericanExerciseBuilderImpl() {
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
		@RosettaAttribute("latestValueDate")
		public Date getLatestValueDate() {
			return latestValueDate;
		}
		
		@Override
		@RosettaAttribute("id")
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("commencementDate")
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate) {
			this.commencementDate = commencementDate==null?null:commencementDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expiryDate")
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setExpiryDate(Date expiryDate) {
			this.expiryDate = expiryDate==null?null:expiryDate;
			return this;
		}
		@Override
		@RosettaAttribute("expiryTime")
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setExpiryTime(BusinessCenterTime expiryTime) {
			this.expiryTime = expiryTime==null?null:expiryTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cutName")
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setCutName(CutName cutName) {
			this.cutName = cutName==null?null:cutName.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("latestValueDate")
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setLatestValueDate(Date latestValueDate) {
			this.latestValueDate = latestValueDate==null?null:latestValueDate;
			return this;
		}
		
		@Override
		public FxDigitalAmericanExercise build() {
			return new FxDigitalAmericanExercise.FxDigitalAmericanExerciseImpl(this);
		}
		
		@Override
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder prune() {
			super.prune();
			if (commencementDate!=null && !commencementDate.prune().hasData()) commencementDate = null;
			if (expiryTime!=null && !expiryTime.prune().hasData()) expiryTime = null;
			if (cutName!=null && !cutName.prune().hasData()) cutName = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommencementDate()!=null && getCommencementDate().hasData()) return true;
			if (getExpiryDate()!=null) return true;
			if (getExpiryTime()!=null && getExpiryTime().hasData()) return true;
			if (getCutName()!=null && getCutName().hasData()) return true;
			if (getLatestValueDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder o = (FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder) other;
			
			merger.mergeRosetta(getCommencementDate(), o.getCommencementDate(), this::setCommencementDate);
			merger.mergeRosetta(getExpiryTime(), o.getExpiryTime(), this::setExpiryTime);
			merger.mergeRosetta(getCutName(), o.getCutName(), this::setCutName);
			
			merger.mergeBasic(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeBasic(getLatestValueDate(), o.getLatestValueDate(), this::setLatestValueDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxDigitalAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			if (!Objects.equals(cutName, _that.getCutName())) return false;
			if (!Objects.equals(latestValueDate, _that.getLatestValueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			_result = 31 * _result + (cutName != null ? cutName.hashCode() : 0);
			_result = 31 * _result + (latestValueDate != null ? latestValueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDigitalAmericanExerciseBuilder {" +
				"commencementDate=" + this.commencementDate + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"expiryTime=" + this.expiryTime + ", " +
				"cutName=" + this.cutName + ", " +
				"latestValueDate=" + this.latestValueDate +
			'}' + " " + super.toString();
		}
	}
}
