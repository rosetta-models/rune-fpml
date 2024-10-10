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
import fpml.confirmation.CancellationEvent;
import fpml.confirmation.CancellationEvent.CancellationEventBuilder;
import fpml.confirmation.CancellationEvent.CancellationEventBuilderImpl;
import fpml.confirmation.CancellationEvent.CancellationEventImpl;
import fpml.confirmation.meta.CancellationEventMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The adjusted dates for a specific cancellation date, including the adjusted exercise date and adjusted termination date.
 * @version ${project.version}
 */
@RosettaDataType(value="CancellationEvent", builder=CancellationEvent.CancellationEventBuilderImpl.class, version="${project.version}")
public interface CancellationEvent extends RosettaModelObject {

	CancellationEventMeta metaData = new CancellationEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which option exercise takes place. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedExerciseDate();
	/**
	 * The early termination date that is applicable if an early termination provision is exercised. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedEarlyTerminationDate();
	String getId();

	/*********************** Build Methods  ***********************/
	CancellationEvent build();
	
	CancellationEvent.CancellationEventBuilder toBuilder();
	
	static CancellationEvent.CancellationEventBuilder builder() {
		return new CancellationEvent.CancellationEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CancellationEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CancellationEvent> getType() {
		return CancellationEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustedExerciseDate"), Date.class, getAdjustedExerciseDate(), this);
		processor.processBasic(path.newSubPath("adjustedEarlyTerminationDate"), Date.class, getAdjustedEarlyTerminationDate(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CancellationEventBuilder extends CancellationEvent, RosettaModelObjectBuilder {
		CancellationEvent.CancellationEventBuilder setAdjustedExerciseDate(Date adjustedExerciseDate);
		CancellationEvent.CancellationEventBuilder setAdjustedEarlyTerminationDate(Date adjustedEarlyTerminationDate);
		CancellationEvent.CancellationEventBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("adjustedExerciseDate"), Date.class, getAdjustedExerciseDate(), this);
			processor.processBasic(path.newSubPath("adjustedEarlyTerminationDate"), Date.class, getAdjustedEarlyTerminationDate(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CancellationEvent.CancellationEventBuilder prune();
	}

	/*********************** Immutable Implementation of CancellationEvent  ***********************/
	class CancellationEventImpl implements CancellationEvent {
		private final Date adjustedExerciseDate;
		private final Date adjustedEarlyTerminationDate;
		private final String id;
		
		protected CancellationEventImpl(CancellationEvent.CancellationEventBuilder builder) {
			this.adjustedExerciseDate = builder.getAdjustedExerciseDate();
			this.adjustedEarlyTerminationDate = builder.getAdjustedEarlyTerminationDate();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("adjustedExerciseDate")
		public Date getAdjustedExerciseDate() {
			return adjustedExerciseDate;
		}
		
		@Override
		@RosettaAttribute("adjustedEarlyTerminationDate")
		public Date getAdjustedEarlyTerminationDate() {
			return adjustedEarlyTerminationDate;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CancellationEvent build() {
			return this;
		}
		
		@Override
		public CancellationEvent.CancellationEventBuilder toBuilder() {
			CancellationEvent.CancellationEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CancellationEvent.CancellationEventBuilder builder) {
			ofNullable(getAdjustedExerciseDate()).ifPresent(builder::setAdjustedExerciseDate);
			ofNullable(getAdjustedEarlyTerminationDate()).ifPresent(builder::setAdjustedEarlyTerminationDate);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CancellationEvent _that = getType().cast(o);
		
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedEarlyTerminationDate, _that.getAdjustedEarlyTerminationDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (adjustedEarlyTerminationDate != null ? adjustedEarlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CancellationEvent {" +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedEarlyTerminationDate=" + this.adjustedEarlyTerminationDate + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CancellationEvent  ***********************/
	class CancellationEventBuilderImpl implements CancellationEvent.CancellationEventBuilder {
	
		protected Date adjustedExerciseDate;
		protected Date adjustedEarlyTerminationDate;
		protected String id;
	
		public CancellationEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("adjustedExerciseDate")
		public Date getAdjustedExerciseDate() {
			return adjustedExerciseDate;
		}
		
		@Override
		@RosettaAttribute("adjustedEarlyTerminationDate")
		public Date getAdjustedEarlyTerminationDate() {
			return adjustedEarlyTerminationDate;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("adjustedExerciseDate")
		public CancellationEvent.CancellationEventBuilder setAdjustedExerciseDate(Date adjustedExerciseDate) {
			this.adjustedExerciseDate = adjustedExerciseDate==null?null:adjustedExerciseDate;
			return this;
		}
		@Override
		@RosettaAttribute("adjustedEarlyTerminationDate")
		public CancellationEvent.CancellationEventBuilder setAdjustedEarlyTerminationDate(Date adjustedEarlyTerminationDate) {
			this.adjustedEarlyTerminationDate = adjustedEarlyTerminationDate==null?null:adjustedEarlyTerminationDate;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CancellationEvent.CancellationEventBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CancellationEvent build() {
			return new CancellationEvent.CancellationEventImpl(this);
		}
		
		@Override
		public CancellationEvent.CancellationEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CancellationEvent.CancellationEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedExerciseDate()!=null) return true;
			if (getAdjustedEarlyTerminationDate()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CancellationEvent.CancellationEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CancellationEvent.CancellationEventBuilder o = (CancellationEvent.CancellationEventBuilder) other;
			
			
			merger.mergeBasic(getAdjustedExerciseDate(), o.getAdjustedExerciseDate(), this::setAdjustedExerciseDate);
			merger.mergeBasic(getAdjustedEarlyTerminationDate(), o.getAdjustedEarlyTerminationDate(), this::setAdjustedEarlyTerminationDate);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CancellationEvent _that = getType().cast(o);
		
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedEarlyTerminationDate, _that.getAdjustedEarlyTerminationDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (adjustedEarlyTerminationDate != null ? adjustedEarlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CancellationEventBuilder {" +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedEarlyTerminationDate=" + this.adjustedEarlyTerminationDate + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
