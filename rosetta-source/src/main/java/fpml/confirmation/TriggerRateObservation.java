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
import fpml.confirmation.InformationSource;
import fpml.confirmation.TriggerConditionEnum;
import fpml.confirmation.TriggerRateObservation;
import fpml.confirmation.TriggerRateObservation.TriggerRateObservationBuilder;
import fpml.confirmation.TriggerRateObservation.TriggerRateObservationBuilderImpl;
import fpml.confirmation.TriggerRateObservation.TriggerRateObservationImpl;
import fpml.confirmation.TriggerRateObservationSequence0;
import fpml.confirmation.TriggerRateObservationSequence1;
import fpml.confirmation.meta.TriggerRateObservationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="TriggerRateObservation", builder=TriggerRateObservation.TriggerRateObservationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface TriggerRateObservation extends RosettaModelObject {

	TriggerRateObservationMeta metaData = new TriggerRateObservationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which the rate observation occurred, in order to trigger the barrier event.observationDate
	 */
	Date getObservationDate();
	/**
	 * The time at which the observation occurred.
	 */
	BusinessCenterTime getObservationTime();
	InformationSource getInformationSource();
	TriggerRateObservationSequence0 getTriggerRateObservationSequence0();
	TriggerRateObservationSequence1 getTriggerRateObservationSequence1();
	/**
	 * The side of the trigger rate/price (level) on which a rate observation occurred, in order to trigger the barrier event.
	 */
	TriggerConditionEnum getTriggerCondition();

	/*********************** Build Methods  ***********************/
	TriggerRateObservation build();
	
	TriggerRateObservation.TriggerRateObservationBuilder toBuilder();
	
	static TriggerRateObservation.TriggerRateObservationBuilder builder() {
		return new TriggerRateObservation.TriggerRateObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TriggerRateObservation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TriggerRateObservation> getType() {
		return TriggerRateObservation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationDate"), Date.class, getObservationDate(), this);
		processRosetta(path.newSubPath("observationTime"), processor, BusinessCenterTime.class, getObservationTime());
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
		processRosetta(path.newSubPath("triggerRateObservationSequence0"), processor, TriggerRateObservationSequence0.class, getTriggerRateObservationSequence0());
		processRosetta(path.newSubPath("triggerRateObservationSequence1"), processor, TriggerRateObservationSequence1.class, getTriggerRateObservationSequence1());
		processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TriggerRateObservationBuilder extends TriggerRateObservation, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getObservationTime();
		InformationSource.InformationSourceBuilder getOrCreateInformationSource();
		InformationSource.InformationSourceBuilder getInformationSource();
		TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder getOrCreateTriggerRateObservationSequence0();
		TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder getTriggerRateObservationSequence0();
		TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder getOrCreateTriggerRateObservationSequence1();
		TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder getTriggerRateObservationSequence1();
		TriggerRateObservation.TriggerRateObservationBuilder setObservationDate(Date observationDate);
		TriggerRateObservation.TriggerRateObservationBuilder setObservationTime(BusinessCenterTime observationTime);
		TriggerRateObservation.TriggerRateObservationBuilder setInformationSource(InformationSource informationSource);
		TriggerRateObservation.TriggerRateObservationBuilder setTriggerRateObservationSequence0(TriggerRateObservationSequence0 triggerRateObservationSequence0);
		TriggerRateObservation.TriggerRateObservationBuilder setTriggerRateObservationSequence1(TriggerRateObservationSequence1 triggerRateObservationSequence1);
		TriggerRateObservation.TriggerRateObservationBuilder setTriggerCondition(TriggerConditionEnum triggerCondition);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("observationDate"), Date.class, getObservationDate(), this);
			processRosetta(path.newSubPath("observationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationTime());
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("triggerRateObservationSequence0"), processor, TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder.class, getTriggerRateObservationSequence0());
			processRosetta(path.newSubPath("triggerRateObservationSequence1"), processor, TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder.class, getTriggerRateObservationSequence1());
			processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
		}
		

		TriggerRateObservation.TriggerRateObservationBuilder prune();
	}

	/*********************** Immutable Implementation of TriggerRateObservation  ***********************/
	class TriggerRateObservationImpl implements TriggerRateObservation {
		private final Date observationDate;
		private final BusinessCenterTime observationTime;
		private final InformationSource informationSource;
		private final TriggerRateObservationSequence0 triggerRateObservationSequence0;
		private final TriggerRateObservationSequence1 triggerRateObservationSequence1;
		private final TriggerConditionEnum triggerCondition;
		
		protected TriggerRateObservationImpl(TriggerRateObservation.TriggerRateObservationBuilder builder) {
			this.observationDate = builder.getObservationDate();
			this.observationTime = ofNullable(builder.getObservationTime()).map(f->f.build()).orElse(null);
			this.informationSource = ofNullable(builder.getInformationSource()).map(f->f.build()).orElse(null);
			this.triggerRateObservationSequence0 = ofNullable(builder.getTriggerRateObservationSequence0()).map(f->f.build()).orElse(null);
			this.triggerRateObservationSequence1 = ofNullable(builder.getTriggerRateObservationSequence1()).map(f->f.build()).orElse(null);
			this.triggerCondition = builder.getTriggerCondition();
		}
		
		@Override
		@RosettaAttribute("observationDate")
		public Date getObservationDate() {
			return observationDate;
		}
		
		@Override
		@RosettaAttribute("observationTime")
		public BusinessCenterTime getObservationTime() {
			return observationTime;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		public InformationSource getInformationSource() {
			return informationSource;
		}
		
		@Override
		@RosettaAttribute("triggerRateObservationSequence0")
		public TriggerRateObservationSequence0 getTriggerRateObservationSequence0() {
			return triggerRateObservationSequence0;
		}
		
		@Override
		@RosettaAttribute("triggerRateObservationSequence1")
		public TriggerRateObservationSequence1 getTriggerRateObservationSequence1() {
			return triggerRateObservationSequence1;
		}
		
		@Override
		@RosettaAttribute("triggerCondition")
		public TriggerConditionEnum getTriggerCondition() {
			return triggerCondition;
		}
		
		@Override
		public TriggerRateObservation build() {
			return this;
		}
		
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder toBuilder() {
			TriggerRateObservation.TriggerRateObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TriggerRateObservation.TriggerRateObservationBuilder builder) {
			ofNullable(getObservationDate()).ifPresent(builder::setObservationDate);
			ofNullable(getObservationTime()).ifPresent(builder::setObservationTime);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
			ofNullable(getTriggerRateObservationSequence0()).ifPresent(builder::setTriggerRateObservationSequence0);
			ofNullable(getTriggerRateObservationSequence1()).ifPresent(builder::setTriggerRateObservationSequence1);
			ofNullable(getTriggerCondition()).ifPresent(builder::setTriggerCondition);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TriggerRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(observationDate, _that.getObservationDate())) return false;
			if (!Objects.equals(observationTime, _that.getObservationTime())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(triggerRateObservationSequence0, _that.getTriggerRateObservationSequence0())) return false;
			if (!Objects.equals(triggerRateObservationSequence1, _that.getTriggerRateObservationSequence1())) return false;
			if (!Objects.equals(triggerCondition, _that.getTriggerCondition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationDate != null ? observationDate.hashCode() : 0);
			_result = 31 * _result + (observationTime != null ? observationTime.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (triggerRateObservationSequence0 != null ? triggerRateObservationSequence0.hashCode() : 0);
			_result = 31 * _result + (triggerRateObservationSequence1 != null ? triggerRateObservationSequence1.hashCode() : 0);
			_result = 31 * _result + (triggerCondition != null ? triggerCondition.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriggerRateObservation {" +
				"observationDate=" + this.observationDate + ", " +
				"observationTime=" + this.observationTime + ", " +
				"informationSource=" + this.informationSource + ", " +
				"triggerRateObservationSequence0=" + this.triggerRateObservationSequence0 + ", " +
				"triggerRateObservationSequence1=" + this.triggerRateObservationSequence1 + ", " +
				"triggerCondition=" + this.triggerCondition +
			'}';
		}
	}

	/*********************** Builder Implementation of TriggerRateObservation  ***********************/
	class TriggerRateObservationBuilderImpl implements TriggerRateObservation.TriggerRateObservationBuilder {
	
		protected Date observationDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder observationTime;
		protected InformationSource.InformationSourceBuilder informationSource;
		protected TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder triggerRateObservationSequence0;
		protected TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder triggerRateObservationSequence1;
		protected TriggerConditionEnum triggerCondition;
	
		public TriggerRateObservationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("observationDate")
		public Date getObservationDate() {
			return observationDate;
		}
		
		@Override
		@RosettaAttribute("observationTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getObservationTime() {
			return observationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (observationTime!=null) {
				result = observationTime;
			}
			else {
				result = observationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		public InformationSource.InformationSourceBuilder getInformationSource() {
			return informationSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateInformationSource() {
			InformationSource.InformationSourceBuilder result;
			if (informationSource!=null) {
				result = informationSource;
			}
			else {
				result = informationSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerRateObservationSequence0")
		public TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder getTriggerRateObservationSequence0() {
			return triggerRateObservationSequence0;
		}
		
		@Override
		public TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder getOrCreateTriggerRateObservationSequence0() {
			TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder result;
			if (triggerRateObservationSequence0!=null) {
				result = triggerRateObservationSequence0;
			}
			else {
				result = triggerRateObservationSequence0 = TriggerRateObservationSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerRateObservationSequence1")
		public TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder getTriggerRateObservationSequence1() {
			return triggerRateObservationSequence1;
		}
		
		@Override
		public TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder getOrCreateTriggerRateObservationSequence1() {
			TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder result;
			if (triggerRateObservationSequence1!=null) {
				result = triggerRateObservationSequence1;
			}
			else {
				result = triggerRateObservationSequence1 = TriggerRateObservationSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerCondition")
		public TriggerConditionEnum getTriggerCondition() {
			return triggerCondition;
		}
		
		@Override
		@RosettaAttribute("observationDate")
		public TriggerRateObservation.TriggerRateObservationBuilder setObservationDate(Date observationDate) {
			this.observationDate = observationDate==null?null:observationDate;
			return this;
		}
		@Override
		@RosettaAttribute("observationTime")
		public TriggerRateObservation.TriggerRateObservationBuilder setObservationTime(BusinessCenterTime observationTime) {
			this.observationTime = observationTime==null?null:observationTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("informationSource")
		public TriggerRateObservation.TriggerRateObservationBuilder setInformationSource(InformationSource informationSource) {
			this.informationSource = informationSource==null?null:informationSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("triggerRateObservationSequence0")
		public TriggerRateObservation.TriggerRateObservationBuilder setTriggerRateObservationSequence0(TriggerRateObservationSequence0 triggerRateObservationSequence0) {
			this.triggerRateObservationSequence0 = triggerRateObservationSequence0==null?null:triggerRateObservationSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("triggerRateObservationSequence1")
		public TriggerRateObservation.TriggerRateObservationBuilder setTriggerRateObservationSequence1(TriggerRateObservationSequence1 triggerRateObservationSequence1) {
			this.triggerRateObservationSequence1 = triggerRateObservationSequence1==null?null:triggerRateObservationSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("triggerCondition")
		public TriggerRateObservation.TriggerRateObservationBuilder setTriggerCondition(TriggerConditionEnum triggerCondition) {
			this.triggerCondition = triggerCondition==null?null:triggerCondition;
			return this;
		}
		
		@Override
		public TriggerRateObservation build() {
			return new TriggerRateObservation.TriggerRateObservationImpl(this);
		}
		
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder prune() {
			if (observationTime!=null && !observationTime.prune().hasData()) observationTime = null;
			if (informationSource!=null && !informationSource.prune().hasData()) informationSource = null;
			if (triggerRateObservationSequence0!=null && !triggerRateObservationSequence0.prune().hasData()) triggerRateObservationSequence0 = null;
			if (triggerRateObservationSequence1!=null && !triggerRateObservationSequence1.prune().hasData()) triggerRateObservationSequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationDate()!=null) return true;
			if (getObservationTime()!=null && getObservationTime().hasData()) return true;
			if (getInformationSource()!=null && getInformationSource().hasData()) return true;
			if (getTriggerRateObservationSequence0()!=null && getTriggerRateObservationSequence0().hasData()) return true;
			if (getTriggerRateObservationSequence1()!=null && getTriggerRateObservationSequence1().hasData()) return true;
			if (getTriggerCondition()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TriggerRateObservation.TriggerRateObservationBuilder o = (TriggerRateObservation.TriggerRateObservationBuilder) other;
			
			merger.mergeRosetta(getObservationTime(), o.getObservationTime(), this::setObservationTime);
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::setInformationSource);
			merger.mergeRosetta(getTriggerRateObservationSequence0(), o.getTriggerRateObservationSequence0(), this::setTriggerRateObservationSequence0);
			merger.mergeRosetta(getTriggerRateObservationSequence1(), o.getTriggerRateObservationSequence1(), this::setTriggerRateObservationSequence1);
			
			merger.mergeBasic(getObservationDate(), o.getObservationDate(), this::setObservationDate);
			merger.mergeBasic(getTriggerCondition(), o.getTriggerCondition(), this::setTriggerCondition);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TriggerRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(observationDate, _that.getObservationDate())) return false;
			if (!Objects.equals(observationTime, _that.getObservationTime())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(triggerRateObservationSequence0, _that.getTriggerRateObservationSequence0())) return false;
			if (!Objects.equals(triggerRateObservationSequence1, _that.getTriggerRateObservationSequence1())) return false;
			if (!Objects.equals(triggerCondition, _that.getTriggerCondition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationDate != null ? observationDate.hashCode() : 0);
			_result = 31 * _result + (observationTime != null ? observationTime.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (triggerRateObservationSequence0 != null ? triggerRateObservationSequence0.hashCode() : 0);
			_result = 31 * _result + (triggerRateObservationSequence1 != null ? triggerRateObservationSequence1.hashCode() : 0);
			_result = 31 * _result + (triggerCondition != null ? triggerCondition.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriggerRateObservationBuilder {" +
				"observationDate=" + this.observationDate + ", " +
				"observationTime=" + this.observationTime + ", " +
				"informationSource=" + this.informationSource + ", " +
				"triggerRateObservationSequence0=" + this.triggerRateObservationSequence0 + ", " +
				"triggerRateObservationSequence1=" + this.triggerRateObservationSequence1 + ", " +
				"triggerCondition=" + this.triggerCondition +
			'}';
		}
	}
}
