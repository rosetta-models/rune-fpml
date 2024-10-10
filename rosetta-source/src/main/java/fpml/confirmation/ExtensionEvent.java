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
import fpml.confirmation.ExtensionEvent;
import fpml.confirmation.ExtensionEvent.ExtensionEventBuilder;
import fpml.confirmation.ExtensionEvent.ExtensionEventBuilderImpl;
import fpml.confirmation.ExtensionEvent.ExtensionEventImpl;
import fpml.confirmation.meta.ExtensionEventMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type to define the adjusted dates associated with an individual extension event.
 * @version ${project.version}
 */
@RosettaDataType(value="ExtensionEvent", builder=ExtensionEvent.ExtensionEventBuilderImpl.class, version="${project.version}")
public interface ExtensionEvent extends RosettaModelObject {

	ExtensionEventMeta metaData = new ExtensionEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which option exercise takes place. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedExerciseDate();
	/**
	 * The termination date if an extendible provision is exercised. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedExtendedTerminationDate();
	String getId();

	/*********************** Build Methods  ***********************/
	ExtensionEvent build();
	
	ExtensionEvent.ExtensionEventBuilder toBuilder();
	
	static ExtensionEvent.ExtensionEventBuilder builder() {
		return new ExtensionEvent.ExtensionEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExtensionEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExtensionEvent> getType() {
		return ExtensionEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustedExerciseDate"), Date.class, getAdjustedExerciseDate(), this);
		processor.processBasic(path.newSubPath("adjustedExtendedTerminationDate"), Date.class, getAdjustedExtendedTerminationDate(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExtensionEventBuilder extends ExtensionEvent, RosettaModelObjectBuilder {
		ExtensionEvent.ExtensionEventBuilder setAdjustedExerciseDate(Date adjustedExerciseDate);
		ExtensionEvent.ExtensionEventBuilder setAdjustedExtendedTerminationDate(Date adjustedExtendedTerminationDate);
		ExtensionEvent.ExtensionEventBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("adjustedExerciseDate"), Date.class, getAdjustedExerciseDate(), this);
			processor.processBasic(path.newSubPath("adjustedExtendedTerminationDate"), Date.class, getAdjustedExtendedTerminationDate(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		ExtensionEvent.ExtensionEventBuilder prune();
	}

	/*********************** Immutable Implementation of ExtensionEvent  ***********************/
	class ExtensionEventImpl implements ExtensionEvent {
		private final Date adjustedExerciseDate;
		private final Date adjustedExtendedTerminationDate;
		private final String id;
		
		protected ExtensionEventImpl(ExtensionEvent.ExtensionEventBuilder builder) {
			this.adjustedExerciseDate = builder.getAdjustedExerciseDate();
			this.adjustedExtendedTerminationDate = builder.getAdjustedExtendedTerminationDate();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("adjustedExerciseDate")
		public Date getAdjustedExerciseDate() {
			return adjustedExerciseDate;
		}
		
		@Override
		@RosettaAttribute("adjustedExtendedTerminationDate")
		public Date getAdjustedExtendedTerminationDate() {
			return adjustedExtendedTerminationDate;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public ExtensionEvent build() {
			return this;
		}
		
		@Override
		public ExtensionEvent.ExtensionEventBuilder toBuilder() {
			ExtensionEvent.ExtensionEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExtensionEvent.ExtensionEventBuilder builder) {
			ofNullable(getAdjustedExerciseDate()).ifPresent(builder::setAdjustedExerciseDate);
			ofNullable(getAdjustedExtendedTerminationDate()).ifPresent(builder::setAdjustedExtendedTerminationDate);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExtensionEvent _that = getType().cast(o);
		
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedExtendedTerminationDate, _that.getAdjustedExtendedTerminationDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExtendedTerminationDate != null ? adjustedExtendedTerminationDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtensionEvent {" +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedExtendedTerminationDate=" + this.adjustedExtendedTerminationDate + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of ExtensionEvent  ***********************/
	class ExtensionEventBuilderImpl implements ExtensionEvent.ExtensionEventBuilder {
	
		protected Date adjustedExerciseDate;
		protected Date adjustedExtendedTerminationDate;
		protected String id;
	
		public ExtensionEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("adjustedExerciseDate")
		public Date getAdjustedExerciseDate() {
			return adjustedExerciseDate;
		}
		
		@Override
		@RosettaAttribute("adjustedExtendedTerminationDate")
		public Date getAdjustedExtendedTerminationDate() {
			return adjustedExtendedTerminationDate;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("adjustedExerciseDate")
		public ExtensionEvent.ExtensionEventBuilder setAdjustedExerciseDate(Date adjustedExerciseDate) {
			this.adjustedExerciseDate = adjustedExerciseDate==null?null:adjustedExerciseDate;
			return this;
		}
		@Override
		@RosettaAttribute("adjustedExtendedTerminationDate")
		public ExtensionEvent.ExtensionEventBuilder setAdjustedExtendedTerminationDate(Date adjustedExtendedTerminationDate) {
			this.adjustedExtendedTerminationDate = adjustedExtendedTerminationDate==null?null:adjustedExtendedTerminationDate;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public ExtensionEvent.ExtensionEventBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public ExtensionEvent build() {
			return new ExtensionEvent.ExtensionEventImpl(this);
		}
		
		@Override
		public ExtensionEvent.ExtensionEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtensionEvent.ExtensionEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedExerciseDate()!=null) return true;
			if (getAdjustedExtendedTerminationDate()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtensionEvent.ExtensionEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExtensionEvent.ExtensionEventBuilder o = (ExtensionEvent.ExtensionEventBuilder) other;
			
			
			merger.mergeBasic(getAdjustedExerciseDate(), o.getAdjustedExerciseDate(), this::setAdjustedExerciseDate);
			merger.mergeBasic(getAdjustedExtendedTerminationDate(), o.getAdjustedExtendedTerminationDate(), this::setAdjustedExtendedTerminationDate);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExtensionEvent _that = getType().cast(o);
		
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedExtendedTerminationDate, _that.getAdjustedExtendedTerminationDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExtendedTerminationDate != null ? adjustedExtendedTerminationDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtensionEventBuilder {" +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedExtendedTerminationDate=" + this.adjustedExtendedTerminationDate + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
