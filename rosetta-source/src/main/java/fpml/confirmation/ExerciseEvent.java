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
import fpml.confirmation.ExerciseEvent;
import fpml.confirmation.ExerciseEvent.ExerciseEventBuilder;
import fpml.confirmation.ExerciseEvent.ExerciseEventBuilderImpl;
import fpml.confirmation.ExerciseEvent.ExerciseEventImpl;
import fpml.confirmation.meta.ExerciseEventMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the adjusted dates associated with a particular exercise event.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ExerciseEvent", builder=ExerciseEvent.ExerciseEventBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ExerciseEvent extends RosettaModelObject {

	ExerciseEventMeta metaData = new ExerciseEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which option exercise takes place. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedExerciseDate();
	/**
	 * The effective date of the underlying swap associated with a given exercise date. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedRelevantSwapEffectiveDate();
	/**
	 * The date by which the cash settlement amount must be agreed. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedCashSettlementValuationDate();
	/**
	 * The date on which the cash settlement amount is paid. This date should already be adjusted for any applicable business dat convention.
	 */
	Date getAdjustedCashSettlementPaymentDate();
	/**
	 * The date on which the exercise fee amount is paid. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedExerciseFeePaymentDate();
	String getId();

	/*********************** Build Methods  ***********************/
	ExerciseEvent build();
	
	ExerciseEvent.ExerciseEventBuilder toBuilder();
	
	static ExerciseEvent.ExerciseEventBuilder builder() {
		return new ExerciseEvent.ExerciseEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExerciseEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExerciseEvent> getType() {
		return ExerciseEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustedExerciseDate"), Date.class, getAdjustedExerciseDate(), this);
		processor.processBasic(path.newSubPath("adjustedRelevantSwapEffectiveDate"), Date.class, getAdjustedRelevantSwapEffectiveDate(), this);
		processor.processBasic(path.newSubPath("adjustedCashSettlementValuationDate"), Date.class, getAdjustedCashSettlementValuationDate(), this);
		processor.processBasic(path.newSubPath("adjustedCashSettlementPaymentDate"), Date.class, getAdjustedCashSettlementPaymentDate(), this);
		processor.processBasic(path.newSubPath("adjustedExerciseFeePaymentDate"), Date.class, getAdjustedExerciseFeePaymentDate(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExerciseEventBuilder extends ExerciseEvent, RosettaModelObjectBuilder {
		ExerciseEvent.ExerciseEventBuilder setAdjustedExerciseDate(Date adjustedExerciseDate);
		ExerciseEvent.ExerciseEventBuilder setAdjustedRelevantSwapEffectiveDate(Date adjustedRelevantSwapEffectiveDate);
		ExerciseEvent.ExerciseEventBuilder setAdjustedCashSettlementValuationDate(Date adjustedCashSettlementValuationDate);
		ExerciseEvent.ExerciseEventBuilder setAdjustedCashSettlementPaymentDate(Date adjustedCashSettlementPaymentDate);
		ExerciseEvent.ExerciseEventBuilder setAdjustedExerciseFeePaymentDate(Date adjustedExerciseFeePaymentDate);
		ExerciseEvent.ExerciseEventBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("adjustedExerciseDate"), Date.class, getAdjustedExerciseDate(), this);
			processor.processBasic(path.newSubPath("adjustedRelevantSwapEffectiveDate"), Date.class, getAdjustedRelevantSwapEffectiveDate(), this);
			processor.processBasic(path.newSubPath("adjustedCashSettlementValuationDate"), Date.class, getAdjustedCashSettlementValuationDate(), this);
			processor.processBasic(path.newSubPath("adjustedCashSettlementPaymentDate"), Date.class, getAdjustedCashSettlementPaymentDate(), this);
			processor.processBasic(path.newSubPath("adjustedExerciseFeePaymentDate"), Date.class, getAdjustedExerciseFeePaymentDate(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		ExerciseEvent.ExerciseEventBuilder prune();
	}

	/*********************** Immutable Implementation of ExerciseEvent  ***********************/
	class ExerciseEventImpl implements ExerciseEvent {
		private final Date adjustedExerciseDate;
		private final Date adjustedRelevantSwapEffectiveDate;
		private final Date adjustedCashSettlementValuationDate;
		private final Date adjustedCashSettlementPaymentDate;
		private final Date adjustedExerciseFeePaymentDate;
		private final String id;
		
		protected ExerciseEventImpl(ExerciseEvent.ExerciseEventBuilder builder) {
			this.adjustedExerciseDate = builder.getAdjustedExerciseDate();
			this.adjustedRelevantSwapEffectiveDate = builder.getAdjustedRelevantSwapEffectiveDate();
			this.adjustedCashSettlementValuationDate = builder.getAdjustedCashSettlementValuationDate();
			this.adjustedCashSettlementPaymentDate = builder.getAdjustedCashSettlementPaymentDate();
			this.adjustedExerciseFeePaymentDate = builder.getAdjustedExerciseFeePaymentDate();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("adjustedExerciseDate")
		public Date getAdjustedExerciseDate() {
			return adjustedExerciseDate;
		}
		
		@Override
		@RosettaAttribute("adjustedRelevantSwapEffectiveDate")
		public Date getAdjustedRelevantSwapEffectiveDate() {
			return adjustedRelevantSwapEffectiveDate;
		}
		
		@Override
		@RosettaAttribute("adjustedCashSettlementValuationDate")
		public Date getAdjustedCashSettlementValuationDate() {
			return adjustedCashSettlementValuationDate;
		}
		
		@Override
		@RosettaAttribute("adjustedCashSettlementPaymentDate")
		public Date getAdjustedCashSettlementPaymentDate() {
			return adjustedCashSettlementPaymentDate;
		}
		
		@Override
		@RosettaAttribute("adjustedExerciseFeePaymentDate")
		public Date getAdjustedExerciseFeePaymentDate() {
			return adjustedExerciseFeePaymentDate;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public ExerciseEvent build() {
			return this;
		}
		
		@Override
		public ExerciseEvent.ExerciseEventBuilder toBuilder() {
			ExerciseEvent.ExerciseEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExerciseEvent.ExerciseEventBuilder builder) {
			ofNullable(getAdjustedExerciseDate()).ifPresent(builder::setAdjustedExerciseDate);
			ofNullable(getAdjustedRelevantSwapEffectiveDate()).ifPresent(builder::setAdjustedRelevantSwapEffectiveDate);
			ofNullable(getAdjustedCashSettlementValuationDate()).ifPresent(builder::setAdjustedCashSettlementValuationDate);
			ofNullable(getAdjustedCashSettlementPaymentDate()).ifPresent(builder::setAdjustedCashSettlementPaymentDate);
			ofNullable(getAdjustedExerciseFeePaymentDate()).ifPresent(builder::setAdjustedExerciseFeePaymentDate);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseEvent _that = getType().cast(o);
		
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedRelevantSwapEffectiveDate, _that.getAdjustedRelevantSwapEffectiveDate())) return false;
			if (!Objects.equals(adjustedCashSettlementValuationDate, _that.getAdjustedCashSettlementValuationDate())) return false;
			if (!Objects.equals(adjustedCashSettlementPaymentDate, _that.getAdjustedCashSettlementPaymentDate())) return false;
			if (!Objects.equals(adjustedExerciseFeePaymentDate, _that.getAdjustedExerciseFeePaymentDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (adjustedRelevantSwapEffectiveDate != null ? adjustedRelevantSwapEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementValuationDate != null ? adjustedCashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementPaymentDate != null ? adjustedCashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseFeePaymentDate != null ? adjustedExerciseFeePaymentDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseEvent {" +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedRelevantSwapEffectiveDate=" + this.adjustedRelevantSwapEffectiveDate + ", " +
				"adjustedCashSettlementValuationDate=" + this.adjustedCashSettlementValuationDate + ", " +
				"adjustedCashSettlementPaymentDate=" + this.adjustedCashSettlementPaymentDate + ", " +
				"adjustedExerciseFeePaymentDate=" + this.adjustedExerciseFeePaymentDate + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of ExerciseEvent  ***********************/
	class ExerciseEventBuilderImpl implements ExerciseEvent.ExerciseEventBuilder {
	
		protected Date adjustedExerciseDate;
		protected Date adjustedRelevantSwapEffectiveDate;
		protected Date adjustedCashSettlementValuationDate;
		protected Date adjustedCashSettlementPaymentDate;
		protected Date adjustedExerciseFeePaymentDate;
		protected String id;
	
		public ExerciseEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("adjustedExerciseDate")
		public Date getAdjustedExerciseDate() {
			return adjustedExerciseDate;
		}
		
		@Override
		@RosettaAttribute("adjustedRelevantSwapEffectiveDate")
		public Date getAdjustedRelevantSwapEffectiveDate() {
			return adjustedRelevantSwapEffectiveDate;
		}
		
		@Override
		@RosettaAttribute("adjustedCashSettlementValuationDate")
		public Date getAdjustedCashSettlementValuationDate() {
			return adjustedCashSettlementValuationDate;
		}
		
		@Override
		@RosettaAttribute("adjustedCashSettlementPaymentDate")
		public Date getAdjustedCashSettlementPaymentDate() {
			return adjustedCashSettlementPaymentDate;
		}
		
		@Override
		@RosettaAttribute("adjustedExerciseFeePaymentDate")
		public Date getAdjustedExerciseFeePaymentDate() {
			return adjustedExerciseFeePaymentDate;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("adjustedExerciseDate")
		public ExerciseEvent.ExerciseEventBuilder setAdjustedExerciseDate(Date adjustedExerciseDate) {
			this.adjustedExerciseDate = adjustedExerciseDate==null?null:adjustedExerciseDate;
			return this;
		}
		@Override
		@RosettaAttribute("adjustedRelevantSwapEffectiveDate")
		public ExerciseEvent.ExerciseEventBuilder setAdjustedRelevantSwapEffectiveDate(Date adjustedRelevantSwapEffectiveDate) {
			this.adjustedRelevantSwapEffectiveDate = adjustedRelevantSwapEffectiveDate==null?null:adjustedRelevantSwapEffectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("adjustedCashSettlementValuationDate")
		public ExerciseEvent.ExerciseEventBuilder setAdjustedCashSettlementValuationDate(Date adjustedCashSettlementValuationDate) {
			this.adjustedCashSettlementValuationDate = adjustedCashSettlementValuationDate==null?null:adjustedCashSettlementValuationDate;
			return this;
		}
		@Override
		@RosettaAttribute("adjustedCashSettlementPaymentDate")
		public ExerciseEvent.ExerciseEventBuilder setAdjustedCashSettlementPaymentDate(Date adjustedCashSettlementPaymentDate) {
			this.adjustedCashSettlementPaymentDate = adjustedCashSettlementPaymentDate==null?null:adjustedCashSettlementPaymentDate;
			return this;
		}
		@Override
		@RosettaAttribute("adjustedExerciseFeePaymentDate")
		public ExerciseEvent.ExerciseEventBuilder setAdjustedExerciseFeePaymentDate(Date adjustedExerciseFeePaymentDate) {
			this.adjustedExerciseFeePaymentDate = adjustedExerciseFeePaymentDate==null?null:adjustedExerciseFeePaymentDate;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public ExerciseEvent.ExerciseEventBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public ExerciseEvent build() {
			return new ExerciseEvent.ExerciseEventImpl(this);
		}
		
		@Override
		public ExerciseEvent.ExerciseEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseEvent.ExerciseEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedExerciseDate()!=null) return true;
			if (getAdjustedRelevantSwapEffectiveDate()!=null) return true;
			if (getAdjustedCashSettlementValuationDate()!=null) return true;
			if (getAdjustedCashSettlementPaymentDate()!=null) return true;
			if (getAdjustedExerciseFeePaymentDate()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseEvent.ExerciseEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExerciseEvent.ExerciseEventBuilder o = (ExerciseEvent.ExerciseEventBuilder) other;
			
			
			merger.mergeBasic(getAdjustedExerciseDate(), o.getAdjustedExerciseDate(), this::setAdjustedExerciseDate);
			merger.mergeBasic(getAdjustedRelevantSwapEffectiveDate(), o.getAdjustedRelevantSwapEffectiveDate(), this::setAdjustedRelevantSwapEffectiveDate);
			merger.mergeBasic(getAdjustedCashSettlementValuationDate(), o.getAdjustedCashSettlementValuationDate(), this::setAdjustedCashSettlementValuationDate);
			merger.mergeBasic(getAdjustedCashSettlementPaymentDate(), o.getAdjustedCashSettlementPaymentDate(), this::setAdjustedCashSettlementPaymentDate);
			merger.mergeBasic(getAdjustedExerciseFeePaymentDate(), o.getAdjustedExerciseFeePaymentDate(), this::setAdjustedExerciseFeePaymentDate);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseEvent _that = getType().cast(o);
		
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedRelevantSwapEffectiveDate, _that.getAdjustedRelevantSwapEffectiveDate())) return false;
			if (!Objects.equals(adjustedCashSettlementValuationDate, _that.getAdjustedCashSettlementValuationDate())) return false;
			if (!Objects.equals(adjustedCashSettlementPaymentDate, _that.getAdjustedCashSettlementPaymentDate())) return false;
			if (!Objects.equals(adjustedExerciseFeePaymentDate, _that.getAdjustedExerciseFeePaymentDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (adjustedRelevantSwapEffectiveDate != null ? adjustedRelevantSwapEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementValuationDate != null ? adjustedCashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementPaymentDate != null ? adjustedCashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseFeePaymentDate != null ? adjustedExerciseFeePaymentDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseEventBuilder {" +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedRelevantSwapEffectiveDate=" + this.adjustedRelevantSwapEffectiveDate + ", " +
				"adjustedCashSettlementValuationDate=" + this.adjustedCashSettlementValuationDate + ", " +
				"adjustedCashSettlementPaymentDate=" + this.adjustedCashSettlementPaymentDate + ", " +
				"adjustedExerciseFeePaymentDate=" + this.adjustedExerciseFeePaymentDate + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
