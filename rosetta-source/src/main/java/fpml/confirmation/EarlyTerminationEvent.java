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
import fpml.confirmation.EarlyTerminationEvent;
import fpml.confirmation.EarlyTerminationEvent.EarlyTerminationEventBuilder;
import fpml.confirmation.EarlyTerminationEvent.EarlyTerminationEventBuilderImpl;
import fpml.confirmation.EarlyTerminationEvent.EarlyTerminationEventImpl;
import fpml.confirmation.meta.EarlyTerminationEventMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type to define the adjusted dates associated with an early termination provision.
 * @version ${project.version}
 */
@RosettaDataType(value="EarlyTerminationEvent", builder=EarlyTerminationEvent.EarlyTerminationEventBuilderImpl.class, version="${project.version}")
public interface EarlyTerminationEvent extends RosettaModelObject {

	EarlyTerminationEventMeta metaData = new EarlyTerminationEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which option exercise takes place. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedExerciseDate();
	/**
	 * The early termination date that is applicable if an early termination provision is exercised. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedEarlyTerminationDate();
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
	EarlyTerminationEvent build();
	
	EarlyTerminationEvent.EarlyTerminationEventBuilder toBuilder();
	
	static EarlyTerminationEvent.EarlyTerminationEventBuilder builder() {
		return new EarlyTerminationEvent.EarlyTerminationEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EarlyTerminationEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EarlyTerminationEvent> getType() {
		return EarlyTerminationEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustedExerciseDate"), Date.class, getAdjustedExerciseDate(), this);
		processor.processBasic(path.newSubPath("adjustedEarlyTerminationDate"), Date.class, getAdjustedEarlyTerminationDate(), this);
		processor.processBasic(path.newSubPath("adjustedCashSettlementValuationDate"), Date.class, getAdjustedCashSettlementValuationDate(), this);
		processor.processBasic(path.newSubPath("adjustedCashSettlementPaymentDate"), Date.class, getAdjustedCashSettlementPaymentDate(), this);
		processor.processBasic(path.newSubPath("adjustedExerciseFeePaymentDate"), Date.class, getAdjustedExerciseFeePaymentDate(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EarlyTerminationEventBuilder extends EarlyTerminationEvent, RosettaModelObjectBuilder {
		EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedExerciseDate(Date adjustedExerciseDate);
		EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedEarlyTerminationDate(Date adjustedEarlyTerminationDate);
		EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedCashSettlementValuationDate(Date adjustedCashSettlementValuationDate);
		EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedCashSettlementPaymentDate(Date adjustedCashSettlementPaymentDate);
		EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedExerciseFeePaymentDate(Date adjustedExerciseFeePaymentDate);
		EarlyTerminationEvent.EarlyTerminationEventBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("adjustedExerciseDate"), Date.class, getAdjustedExerciseDate(), this);
			processor.processBasic(path.newSubPath("adjustedEarlyTerminationDate"), Date.class, getAdjustedEarlyTerminationDate(), this);
			processor.processBasic(path.newSubPath("adjustedCashSettlementValuationDate"), Date.class, getAdjustedCashSettlementValuationDate(), this);
			processor.processBasic(path.newSubPath("adjustedCashSettlementPaymentDate"), Date.class, getAdjustedCashSettlementPaymentDate(), this);
			processor.processBasic(path.newSubPath("adjustedExerciseFeePaymentDate"), Date.class, getAdjustedExerciseFeePaymentDate(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		EarlyTerminationEvent.EarlyTerminationEventBuilder prune();
	}

	/*********************** Immutable Implementation of EarlyTerminationEvent  ***********************/
	class EarlyTerminationEventImpl implements EarlyTerminationEvent {
		private final Date adjustedExerciseDate;
		private final Date adjustedEarlyTerminationDate;
		private final Date adjustedCashSettlementValuationDate;
		private final Date adjustedCashSettlementPaymentDate;
		private final Date adjustedExerciseFeePaymentDate;
		private final String id;
		
		protected EarlyTerminationEventImpl(EarlyTerminationEvent.EarlyTerminationEventBuilder builder) {
			this.adjustedExerciseDate = builder.getAdjustedExerciseDate();
			this.adjustedEarlyTerminationDate = builder.getAdjustedEarlyTerminationDate();
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
		@RosettaAttribute("adjustedEarlyTerminationDate")
		public Date getAdjustedEarlyTerminationDate() {
			return adjustedEarlyTerminationDate;
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
		public EarlyTerminationEvent build() {
			return this;
		}
		
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder toBuilder() {
			EarlyTerminationEvent.EarlyTerminationEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EarlyTerminationEvent.EarlyTerminationEventBuilder builder) {
			ofNullable(getAdjustedExerciseDate()).ifPresent(builder::setAdjustedExerciseDate);
			ofNullable(getAdjustedEarlyTerminationDate()).ifPresent(builder::setAdjustedEarlyTerminationDate);
			ofNullable(getAdjustedCashSettlementValuationDate()).ifPresent(builder::setAdjustedCashSettlementValuationDate);
			ofNullable(getAdjustedCashSettlementPaymentDate()).ifPresent(builder::setAdjustedCashSettlementPaymentDate);
			ofNullable(getAdjustedExerciseFeePaymentDate()).ifPresent(builder::setAdjustedExerciseFeePaymentDate);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EarlyTerminationEvent _that = getType().cast(o);
		
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedEarlyTerminationDate, _that.getAdjustedEarlyTerminationDate())) return false;
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
			_result = 31 * _result + (adjustedEarlyTerminationDate != null ? adjustedEarlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementValuationDate != null ? adjustedCashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementPaymentDate != null ? adjustedCashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseFeePaymentDate != null ? adjustedExerciseFeePaymentDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EarlyTerminationEvent {" +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedEarlyTerminationDate=" + this.adjustedEarlyTerminationDate + ", " +
				"adjustedCashSettlementValuationDate=" + this.adjustedCashSettlementValuationDate + ", " +
				"adjustedCashSettlementPaymentDate=" + this.adjustedCashSettlementPaymentDate + ", " +
				"adjustedExerciseFeePaymentDate=" + this.adjustedExerciseFeePaymentDate + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of EarlyTerminationEvent  ***********************/
	class EarlyTerminationEventBuilderImpl implements EarlyTerminationEvent.EarlyTerminationEventBuilder {
	
		protected Date adjustedExerciseDate;
		protected Date adjustedEarlyTerminationDate;
		protected Date adjustedCashSettlementValuationDate;
		protected Date adjustedCashSettlementPaymentDate;
		protected Date adjustedExerciseFeePaymentDate;
		protected String id;
	
		public EarlyTerminationEventBuilderImpl() {
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
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedExerciseDate(Date adjustedExerciseDate) {
			this.adjustedExerciseDate = adjustedExerciseDate==null?null:adjustedExerciseDate;
			return this;
		}
		@Override
		@RosettaAttribute("adjustedEarlyTerminationDate")
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedEarlyTerminationDate(Date adjustedEarlyTerminationDate) {
			this.adjustedEarlyTerminationDate = adjustedEarlyTerminationDate==null?null:adjustedEarlyTerminationDate;
			return this;
		}
		@Override
		@RosettaAttribute("adjustedCashSettlementValuationDate")
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedCashSettlementValuationDate(Date adjustedCashSettlementValuationDate) {
			this.adjustedCashSettlementValuationDate = adjustedCashSettlementValuationDate==null?null:adjustedCashSettlementValuationDate;
			return this;
		}
		@Override
		@RosettaAttribute("adjustedCashSettlementPaymentDate")
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedCashSettlementPaymentDate(Date adjustedCashSettlementPaymentDate) {
			this.adjustedCashSettlementPaymentDate = adjustedCashSettlementPaymentDate==null?null:adjustedCashSettlementPaymentDate;
			return this;
		}
		@Override
		@RosettaAttribute("adjustedExerciseFeePaymentDate")
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedExerciseFeePaymentDate(Date adjustedExerciseFeePaymentDate) {
			this.adjustedExerciseFeePaymentDate = adjustedExerciseFeePaymentDate==null?null:adjustedExerciseFeePaymentDate;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public EarlyTerminationEvent build() {
			return new EarlyTerminationEvent.EarlyTerminationEventImpl(this);
		}
		
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedExerciseDate()!=null) return true;
			if (getAdjustedEarlyTerminationDate()!=null) return true;
			if (getAdjustedCashSettlementValuationDate()!=null) return true;
			if (getAdjustedCashSettlementPaymentDate()!=null) return true;
			if (getAdjustedExerciseFeePaymentDate()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EarlyTerminationEvent.EarlyTerminationEventBuilder o = (EarlyTerminationEvent.EarlyTerminationEventBuilder) other;
			
			
			merger.mergeBasic(getAdjustedExerciseDate(), o.getAdjustedExerciseDate(), this::setAdjustedExerciseDate);
			merger.mergeBasic(getAdjustedEarlyTerminationDate(), o.getAdjustedEarlyTerminationDate(), this::setAdjustedEarlyTerminationDate);
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
		
			EarlyTerminationEvent _that = getType().cast(o);
		
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedEarlyTerminationDate, _that.getAdjustedEarlyTerminationDate())) return false;
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
			_result = 31 * _result + (adjustedEarlyTerminationDate != null ? adjustedEarlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementValuationDate != null ? adjustedCashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementPaymentDate != null ? adjustedCashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseFeePaymentDate != null ? adjustedExerciseFeePaymentDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EarlyTerminationEventBuilder {" +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedEarlyTerminationDate=" + this.adjustedEarlyTerminationDate + ", " +
				"adjustedCashSettlementValuationDate=" + this.adjustedCashSettlementValuationDate + ", " +
				"adjustedCashSettlementPaymentDate=" + this.adjustedCashSettlementPaymentDate + ", " +
				"adjustedExerciseFeePaymentDate=" + this.adjustedExerciseFeePaymentDate + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
