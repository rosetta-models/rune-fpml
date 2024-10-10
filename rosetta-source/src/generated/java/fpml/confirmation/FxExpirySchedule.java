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
import fpml.confirmation.FxExpirySchedule;
import fpml.confirmation.FxExpirySchedule.FxExpiryScheduleBuilder;
import fpml.confirmation.FxExpirySchedule.FxExpiryScheduleBuilderImpl;
import fpml.confirmation.FxExpirySchedule.FxExpiryScheduleImpl;
import fpml.confirmation.FxSchedule;
import fpml.confirmation.FxSchedule.FxScheduleBuilder;
import fpml.confirmation.FxSchedule.FxScheduleBuilderImpl;
import fpml.confirmation.FxSchedule.FxScheduleImpl;
import fpml.confirmation.FxScheduleSequence0;
import fpml.confirmation.FxScheduleSequence1;
import fpml.confirmation.meta.FxExpiryScheduleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the expiry/observation schedule of the target.
 * @version ${project.version}
 */
@RosettaDataType(value="FxExpirySchedule", builder=FxExpirySchedule.FxExpiryScheduleBuilderImpl.class, version="${project.version}")
public interface FxExpirySchedule extends FxSchedule {

	FxExpiryScheduleMeta metaData = new FxExpiryScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The final expiry date facilitates informing the final date without having to process all expiry dates in the schedule.
	 */
	Date getFinalExpiryDate();
	/**
	 * Time of expiration of each expiry date.
	 */
	BusinessCenterTime getExpiryTime();

	/*********************** Build Methods  ***********************/
	FxExpirySchedule build();
	
	FxExpirySchedule.FxExpiryScheduleBuilder toBuilder();
	
	static FxExpirySchedule.FxExpiryScheduleBuilder builder() {
		return new FxExpirySchedule.FxExpiryScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxExpirySchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxExpirySchedule> getType() {
		return FxExpirySchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxScheduleSequence0"), processor, FxScheduleSequence0.class, getFxScheduleSequence0());
		processRosetta(path.newSubPath("fxScheduleSequence1"), processor, FxScheduleSequence1.class, getFxScheduleSequence1());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("finalExpiryDate"), Date.class, getFinalExpiryDate(), this);
		processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.class, getExpiryTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxExpiryScheduleBuilder extends FxExpirySchedule, FxSchedule.FxScheduleBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpiryTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getExpiryTime();
		FxExpirySchedule.FxExpiryScheduleBuilder setFxScheduleSequence0(FxScheduleSequence0 fxScheduleSequence0);
		FxExpirySchedule.FxExpiryScheduleBuilder setFxScheduleSequence1(FxScheduleSequence1 fxScheduleSequence1);
		FxExpirySchedule.FxExpiryScheduleBuilder setId(String id);
		FxExpirySchedule.FxExpiryScheduleBuilder setFinalExpiryDate(Date finalExpiryDate);
		FxExpirySchedule.FxExpiryScheduleBuilder setExpiryTime(BusinessCenterTime expiryTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxScheduleSequence0"), processor, FxScheduleSequence0.FxScheduleSequence0Builder.class, getFxScheduleSequence0());
			processRosetta(path.newSubPath("fxScheduleSequence1"), processor, FxScheduleSequence1.FxScheduleSequence1Builder.class, getFxScheduleSequence1());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("finalExpiryDate"), Date.class, getFinalExpiryDate(), this);
			processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpiryTime());
		}
		

		FxExpirySchedule.FxExpiryScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of FxExpirySchedule  ***********************/
	class FxExpiryScheduleImpl extends FxSchedule.FxScheduleImpl implements FxExpirySchedule {
		private final Date finalExpiryDate;
		private final BusinessCenterTime expiryTime;
		
		protected FxExpiryScheduleImpl(FxExpirySchedule.FxExpiryScheduleBuilder builder) {
			super(builder);
			this.finalExpiryDate = builder.getFinalExpiryDate();
			this.expiryTime = ofNullable(builder.getExpiryTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("finalExpiryDate")
		public Date getFinalExpiryDate() {
			return finalExpiryDate;
		}
		
		@Override
		@RosettaAttribute("expiryTime")
		public BusinessCenterTime getExpiryTime() {
			return expiryTime;
		}
		
		@Override
		public FxExpirySchedule build() {
			return this;
		}
		
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder toBuilder() {
			FxExpirySchedule.FxExpiryScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxExpirySchedule.FxExpiryScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFinalExpiryDate()).ifPresent(builder::setFinalExpiryDate);
			ofNullable(getExpiryTime()).ifPresent(builder::setExpiryTime);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxExpirySchedule _that = getType().cast(o);
		
			if (!Objects.equals(finalExpiryDate, _that.getFinalExpiryDate())) return false;
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (finalExpiryDate != null ? finalExpiryDate.hashCode() : 0);
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxExpirySchedule {" +
				"finalExpiryDate=" + this.finalExpiryDate + ", " +
				"expiryTime=" + this.expiryTime +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxExpirySchedule  ***********************/
	class FxExpiryScheduleBuilderImpl extends FxSchedule.FxScheduleBuilderImpl  implements FxExpirySchedule.FxExpiryScheduleBuilder {
	
		protected Date finalExpiryDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder expiryTime;
	
		public FxExpiryScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("finalExpiryDate")
		public Date getFinalExpiryDate() {
			return finalExpiryDate;
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
		@RosettaAttribute("fxScheduleSequence0")
		public FxExpirySchedule.FxExpiryScheduleBuilder setFxScheduleSequence0(FxScheduleSequence0 fxScheduleSequence0) {
			this.fxScheduleSequence0 = fxScheduleSequence0==null?null:fxScheduleSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxScheduleSequence1")
		public FxExpirySchedule.FxExpiryScheduleBuilder setFxScheduleSequence1(FxScheduleSequence1 fxScheduleSequence1) {
			this.fxScheduleSequence1 = fxScheduleSequence1==null?null:fxScheduleSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxExpirySchedule.FxExpiryScheduleBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("finalExpiryDate")
		public FxExpirySchedule.FxExpiryScheduleBuilder setFinalExpiryDate(Date finalExpiryDate) {
			this.finalExpiryDate = finalExpiryDate==null?null:finalExpiryDate;
			return this;
		}
		@Override
		@RosettaAttribute("expiryTime")
		public FxExpirySchedule.FxExpiryScheduleBuilder setExpiryTime(BusinessCenterTime expiryTime) {
			this.expiryTime = expiryTime==null?null:expiryTime.toBuilder();
			return this;
		}
		
		@Override
		public FxExpirySchedule build() {
			return new FxExpirySchedule.FxExpiryScheduleImpl(this);
		}
		
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder prune() {
			super.prune();
			if (expiryTime!=null && !expiryTime.prune().hasData()) expiryTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFinalExpiryDate()!=null) return true;
			if (getExpiryTime()!=null && getExpiryTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxExpirySchedule.FxExpiryScheduleBuilder o = (FxExpirySchedule.FxExpiryScheduleBuilder) other;
			
			merger.mergeRosetta(getExpiryTime(), o.getExpiryTime(), this::setExpiryTime);
			
			merger.mergeBasic(getFinalExpiryDate(), o.getFinalExpiryDate(), this::setFinalExpiryDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxExpirySchedule _that = getType().cast(o);
		
			if (!Objects.equals(finalExpiryDate, _that.getFinalExpiryDate())) return false;
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (finalExpiryDate != null ? finalExpiryDate.hashCode() : 0);
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxExpiryScheduleBuilder {" +
				"finalExpiryDate=" + this.finalExpiryDate + ", " +
				"expiryTime=" + this.expiryTime +
			'}' + " " + super.toString();
		}
	}
}
