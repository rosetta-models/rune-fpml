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
import fpml.confirmation.TouchRateObservation;
import fpml.confirmation.TouchRateObservation.TouchRateObservationBuilder;
import fpml.confirmation.TouchRateObservation.TouchRateObservationBuilderImpl;
import fpml.confirmation.TouchRateObservation.TouchRateObservationImpl;
import fpml.confirmation.TouchRateObservationSequence;
import fpml.confirmation.TriggerConditionEnum;
import fpml.confirmation.TriggerRateObservation;
import fpml.confirmation.TriggerRateObservation.TriggerRateObservationBuilder;
import fpml.confirmation.TriggerRateObservation.TriggerRateObservationBuilderImpl;
import fpml.confirmation.TriggerRateObservation.TriggerRateObservationImpl;
import fpml.confirmation.TriggerRateObservationSequence0;
import fpml.confirmation.TriggerRateObservationSequence1;
import fpml.confirmation.meta.TouchRateObservationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TouchRateObservation", builder=TouchRateObservation.TouchRateObservationBuilderImpl.class, version="${project.version}")
public interface TouchRateObservation extends TriggerRateObservation {

	TouchRateObservationMeta metaData = new TouchRateObservationMeta();

	/*********************** Getter Methods  ***********************/
	TouchRateObservationSequence getTouchRateObservationSequence();
	/**
	 * If the touch or no touch event hasn&#39;t generated an exercise, then we specify whether the option is exercisable or not.
	 */
	Boolean getIsExercisable();

	/*********************** Build Methods  ***********************/
	TouchRateObservation build();
	
	TouchRateObservation.TouchRateObservationBuilder toBuilder();
	
	static TouchRateObservation.TouchRateObservationBuilder builder() {
		return new TouchRateObservation.TouchRateObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TouchRateObservation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TouchRateObservation> getType() {
		return TouchRateObservation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationDate"), Date.class, getObservationDate(), this);
		processRosetta(path.newSubPath("observationTime"), processor, BusinessCenterTime.class, getObservationTime());
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
		processRosetta(path.newSubPath("triggerRateObservationSequence0"), processor, TriggerRateObservationSequence0.class, getTriggerRateObservationSequence0());
		processRosetta(path.newSubPath("triggerRateObservationSequence1"), processor, TriggerRateObservationSequence1.class, getTriggerRateObservationSequence1());
		processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
		processRosetta(path.newSubPath("touchRateObservationSequence"), processor, TouchRateObservationSequence.class, getTouchRateObservationSequence());
		processor.processBasic(path.newSubPath("isExercisable"), Boolean.class, getIsExercisable(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TouchRateObservationBuilder extends TouchRateObservation, TriggerRateObservation.TriggerRateObservationBuilder {
		TouchRateObservationSequence.TouchRateObservationSequenceBuilder getOrCreateTouchRateObservationSequence();
		TouchRateObservationSequence.TouchRateObservationSequenceBuilder getTouchRateObservationSequence();
		TouchRateObservation.TouchRateObservationBuilder setObservationDate(Date observationDate);
		TouchRateObservation.TouchRateObservationBuilder setObservationTime(BusinessCenterTime observationTime);
		TouchRateObservation.TouchRateObservationBuilder setInformationSource(InformationSource informationSource);
		TouchRateObservation.TouchRateObservationBuilder setTriggerRateObservationSequence0(TriggerRateObservationSequence0 triggerRateObservationSequence0);
		TouchRateObservation.TouchRateObservationBuilder setTriggerRateObservationSequence1(TriggerRateObservationSequence1 triggerRateObservationSequence1);
		TouchRateObservation.TouchRateObservationBuilder setTriggerCondition(TriggerConditionEnum triggerCondition);
		TouchRateObservation.TouchRateObservationBuilder setTouchRateObservationSequence(TouchRateObservationSequence touchRateObservationSequence);
		TouchRateObservation.TouchRateObservationBuilder setIsExercisable(Boolean isExercisable);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("observationDate"), Date.class, getObservationDate(), this);
			processRosetta(path.newSubPath("observationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationTime());
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("triggerRateObservationSequence0"), processor, TriggerRateObservationSequence0.TriggerRateObservationSequence0Builder.class, getTriggerRateObservationSequence0());
			processRosetta(path.newSubPath("triggerRateObservationSequence1"), processor, TriggerRateObservationSequence1.TriggerRateObservationSequence1Builder.class, getTriggerRateObservationSequence1());
			processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
			processRosetta(path.newSubPath("touchRateObservationSequence"), processor, TouchRateObservationSequence.TouchRateObservationSequenceBuilder.class, getTouchRateObservationSequence());
			processor.processBasic(path.newSubPath("isExercisable"), Boolean.class, getIsExercisable(), this);
		}
		

		TouchRateObservation.TouchRateObservationBuilder prune();
	}

	/*********************** Immutable Implementation of TouchRateObservation  ***********************/
	class TouchRateObservationImpl extends TriggerRateObservation.TriggerRateObservationImpl implements TouchRateObservation {
		private final TouchRateObservationSequence touchRateObservationSequence;
		private final Boolean isExercisable;
		
		protected TouchRateObservationImpl(TouchRateObservation.TouchRateObservationBuilder builder) {
			super(builder);
			this.touchRateObservationSequence = ofNullable(builder.getTouchRateObservationSequence()).map(f->f.build()).orElse(null);
			this.isExercisable = builder.getIsExercisable();
		}
		
		@Override
		@RosettaAttribute("touchRateObservationSequence")
		public TouchRateObservationSequence getTouchRateObservationSequence() {
			return touchRateObservationSequence;
		}
		
		@Override
		@RosettaAttribute("isExercisable")
		public Boolean getIsExercisable() {
			return isExercisable;
		}
		
		@Override
		public TouchRateObservation build() {
			return this;
		}
		
		@Override
		public TouchRateObservation.TouchRateObservationBuilder toBuilder() {
			TouchRateObservation.TouchRateObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TouchRateObservation.TouchRateObservationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTouchRateObservationSequence()).ifPresent(builder::setTouchRateObservationSequence);
			ofNullable(getIsExercisable()).ifPresent(builder::setIsExercisable);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TouchRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(touchRateObservationSequence, _that.getTouchRateObservationSequence())) return false;
			if (!Objects.equals(isExercisable, _that.getIsExercisable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (touchRateObservationSequence != null ? touchRateObservationSequence.hashCode() : 0);
			_result = 31 * _result + (isExercisable != null ? isExercisable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TouchRateObservation {" +
				"touchRateObservationSequence=" + this.touchRateObservationSequence + ", " +
				"isExercisable=" + this.isExercisable +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TouchRateObservation  ***********************/
	class TouchRateObservationBuilderImpl extends TriggerRateObservation.TriggerRateObservationBuilderImpl  implements TouchRateObservation.TouchRateObservationBuilder {
	
		protected TouchRateObservationSequence.TouchRateObservationSequenceBuilder touchRateObservationSequence;
		protected Boolean isExercisable;
	
		public TouchRateObservationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("touchRateObservationSequence")
		public TouchRateObservationSequence.TouchRateObservationSequenceBuilder getTouchRateObservationSequence() {
			return touchRateObservationSequence;
		}
		
		@Override
		public TouchRateObservationSequence.TouchRateObservationSequenceBuilder getOrCreateTouchRateObservationSequence() {
			TouchRateObservationSequence.TouchRateObservationSequenceBuilder result;
			if (touchRateObservationSequence!=null) {
				result = touchRateObservationSequence;
			}
			else {
				result = touchRateObservationSequence = TouchRateObservationSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("isExercisable")
		public Boolean getIsExercisable() {
			return isExercisable;
		}
		
		@Override
		@RosettaAttribute("observationDate")
		public TouchRateObservation.TouchRateObservationBuilder setObservationDate(Date observationDate) {
			this.observationDate = observationDate==null?null:observationDate;
			return this;
		}
		@Override
		@RosettaAttribute("observationTime")
		public TouchRateObservation.TouchRateObservationBuilder setObservationTime(BusinessCenterTime observationTime) {
			this.observationTime = observationTime==null?null:observationTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("informationSource")
		public TouchRateObservation.TouchRateObservationBuilder setInformationSource(InformationSource informationSource) {
			this.informationSource = informationSource==null?null:informationSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("triggerRateObservationSequence0")
		public TouchRateObservation.TouchRateObservationBuilder setTriggerRateObservationSequence0(TriggerRateObservationSequence0 triggerRateObservationSequence0) {
			this.triggerRateObservationSequence0 = triggerRateObservationSequence0==null?null:triggerRateObservationSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("triggerRateObservationSequence1")
		public TouchRateObservation.TouchRateObservationBuilder setTriggerRateObservationSequence1(TriggerRateObservationSequence1 triggerRateObservationSequence1) {
			this.triggerRateObservationSequence1 = triggerRateObservationSequence1==null?null:triggerRateObservationSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("triggerCondition")
		public TouchRateObservation.TouchRateObservationBuilder setTriggerCondition(TriggerConditionEnum triggerCondition) {
			this.triggerCondition = triggerCondition==null?null:triggerCondition;
			return this;
		}
		@Override
		@RosettaAttribute("touchRateObservationSequence")
		public TouchRateObservation.TouchRateObservationBuilder setTouchRateObservationSequence(TouchRateObservationSequence touchRateObservationSequence) {
			this.touchRateObservationSequence = touchRateObservationSequence==null?null:touchRateObservationSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isExercisable")
		public TouchRateObservation.TouchRateObservationBuilder setIsExercisable(Boolean isExercisable) {
			this.isExercisable = isExercisable==null?null:isExercisable;
			return this;
		}
		
		@Override
		public TouchRateObservation build() {
			return new TouchRateObservation.TouchRateObservationImpl(this);
		}
		
		@Override
		public TouchRateObservation.TouchRateObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder prune() {
			super.prune();
			if (touchRateObservationSequence!=null && !touchRateObservationSequence.prune().hasData()) touchRateObservationSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTouchRateObservationSequence()!=null && getTouchRateObservationSequence().hasData()) return true;
			if (getIsExercisable()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TouchRateObservation.TouchRateObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			TouchRateObservation.TouchRateObservationBuilder o = (TouchRateObservation.TouchRateObservationBuilder) other;
			
			merger.mergeRosetta(getTouchRateObservationSequence(), o.getTouchRateObservationSequence(), this::setTouchRateObservationSequence);
			
			merger.mergeBasic(getIsExercisable(), o.getIsExercisable(), this::setIsExercisable);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TouchRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(touchRateObservationSequence, _that.getTouchRateObservationSequence())) return false;
			if (!Objects.equals(isExercisable, _that.getIsExercisable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (touchRateObservationSequence != null ? touchRateObservationSequence.hashCode() : 0);
			_result = 31 * _result + (isExercisable != null ? isExercisable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TouchRateObservationBuilder {" +
				"touchRateObservationSequence=" + this.touchRateObservationSequence + ", " +
				"isExercisable=" + this.isExercisable +
			'}' + " " + super.toString();
		}
	}
}
