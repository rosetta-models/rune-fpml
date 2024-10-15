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
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.ObservationFrequency;
import fpml.confirmation.ParametricScheduleModelSequence1;
import fpml.confirmation.ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder;
import fpml.confirmation.ParametricScheduleModelSequence1.ParametricScheduleModelSequence1BuilderImpl;
import fpml.confirmation.ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Impl;
import fpml.confirmation.meta.ParametricScheduleModelSequence1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ParametricScheduleModelSequence1", builder=ParametricScheduleModelSequence1.ParametricScheduleModelSequence1BuilderImpl.class, version="${project.version}")
public interface ParametricScheduleModelSequence1 extends RosettaModelObject {

	ParametricScheduleModelSequence1Meta metaData = new ParametricScheduleModelSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the frequency at which calculation period end dates occur within the period schedule and their roll date convention.
	 */
	ObservationFrequency getObservationFrequency();
	/**
	 * Date adjustments applied to the schedule including the business day convention and the business centers.
	 */
	BusinessDayAdjustments getDateAdjustments();

	/*********************** Build Methods  ***********************/
	ParametricScheduleModelSequence1 build();
	
	ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder toBuilder();
	
	static ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder builder() {
		return new ParametricScheduleModelSequence1.ParametricScheduleModelSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ParametricScheduleModelSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ParametricScheduleModelSequence1> getType() {
		return ParametricScheduleModelSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("observationFrequency"), processor, ObservationFrequency.class, getObservationFrequency());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ParametricScheduleModelSequence1Builder extends ParametricScheduleModelSequence1, RosettaModelObjectBuilder {
		ObservationFrequency.ObservationFrequencyBuilder getOrCreateObservationFrequency();
		ObservationFrequency.ObservationFrequencyBuilder getObservationFrequency();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder setObservationFrequency(ObservationFrequency observationFrequency);
		ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder setDateAdjustments(BusinessDayAdjustments dateAdjustments);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("observationFrequency"), processor, ObservationFrequency.ObservationFrequencyBuilder.class, getObservationFrequency());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
		}
		

		ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder prune();
	}

	/*********************** Immutable Implementation of ParametricScheduleModelSequence1  ***********************/
	class ParametricScheduleModelSequence1Impl implements ParametricScheduleModelSequence1 {
		private final ObservationFrequency observationFrequency;
		private final BusinessDayAdjustments dateAdjustments;
		
		protected ParametricScheduleModelSequence1Impl(ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder builder) {
			this.observationFrequency = ofNullable(builder.getObservationFrequency()).map(f->f.build()).orElse(null);
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("observationFrequency")
		public ObservationFrequency getObservationFrequency() {
			return observationFrequency;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public ParametricScheduleModelSequence1 build() {
			return this;
		}
		
		@Override
		public ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder toBuilder() {
			ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder builder) {
			ofNullable(getObservationFrequency()).ifPresent(builder::setObservationFrequency);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ParametricScheduleModelSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(observationFrequency, _that.getObservationFrequency())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationFrequency != null ? observationFrequency.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParametricScheduleModelSequence1 {" +
				"observationFrequency=" + this.observationFrequency + ", " +
				"dateAdjustments=" + this.dateAdjustments +
			'}';
		}
	}

	/*********************** Builder Implementation of ParametricScheduleModelSequence1  ***********************/
	class ParametricScheduleModelSequence1BuilderImpl implements ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder {
	
		protected ObservationFrequency.ObservationFrequencyBuilder observationFrequency;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
	
		public ParametricScheduleModelSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("observationFrequency")
		public ObservationFrequency.ObservationFrequencyBuilder getObservationFrequency() {
			return observationFrequency;
		}
		
		@Override
		public ObservationFrequency.ObservationFrequencyBuilder getOrCreateObservationFrequency() {
			ObservationFrequency.ObservationFrequencyBuilder result;
			if (observationFrequency!=null) {
				result = observationFrequency;
			}
			else {
				result = observationFrequency = ObservationFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (dateAdjustments!=null) {
				result = dateAdjustments;
			}
			else {
				result = dateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationFrequency")
		public ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder setObservationFrequency(ObservationFrequency observationFrequency) {
			this.observationFrequency = observationFrequency==null?null:observationFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dateAdjustments")
		public ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder setDateAdjustments(BusinessDayAdjustments dateAdjustments) {
			this.dateAdjustments = dateAdjustments==null?null:dateAdjustments.toBuilder();
			return this;
		}
		
		@Override
		public ParametricScheduleModelSequence1 build() {
			return new ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Impl(this);
		}
		
		@Override
		public ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder prune() {
			if (observationFrequency!=null && !observationFrequency.prune().hasData()) observationFrequency = null;
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationFrequency()!=null && getObservationFrequency().hasData()) return true;
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder o = (ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder) other;
			
			merger.mergeRosetta(getObservationFrequency(), o.getObservationFrequency(), this::setObservationFrequency);
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ParametricScheduleModelSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(observationFrequency, _that.getObservationFrequency())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationFrequency != null ? observationFrequency.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParametricScheduleModelSequence1Builder {" +
				"observationFrequency=" + this.observationFrequency + ", " +
				"dateAdjustments=" + this.dateAdjustments +
			'}';
		}
	}
}
