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
import fpml.confirmation.FxFixingScheduleSimpleSequence;
import fpml.confirmation.FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder;
import fpml.confirmation.FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilderImpl;
import fpml.confirmation.FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceImpl;
import fpml.confirmation.meta.FxFixingScheduleSimpleSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxFixingScheduleSimpleSequence", builder=FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxFixingScheduleSimpleSequence extends RosettaModelObject {

	FxFixingScheduleSimpleSequenceMeta metaData = new FxFixingScheduleSimpleSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The start of the period over which observations are made to determine whether a trigger has occurred.
	 */
	Date getStartDate();
	/**
	 * The end of the period over which observations are made to determine whether a trigger event has occurred.
	 */
	Date getEndDate();

	/*********************** Build Methods  ***********************/
	FxFixingScheduleSimpleSequence build();
	
	FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder toBuilder();
	
	static FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder builder() {
		return new FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFixingScheduleSimpleSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxFixingScheduleSimpleSequence> getType() {
		return FxFixingScheduleSimpleSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFixingScheduleSimpleSequenceBuilder extends FxFixingScheduleSimpleSequence, RosettaModelObjectBuilder {
		FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder setStartDate(Date startDate);
		FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder setEndDate(Date endDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		}
		

		FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxFixingScheduleSimpleSequence  ***********************/
	class FxFixingScheduleSimpleSequenceImpl implements FxFixingScheduleSimpleSequence {
		private final Date startDate;
		private final Date endDate;
		
		protected FxFixingScheduleSimpleSequenceImpl(FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder builder) {
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
		}
		
		@Override
		@RosettaAttribute("startDate")
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		public FxFixingScheduleSimpleSequence build() {
			return this;
		}
		
		@Override
		public FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder toBuilder() {
			FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixingScheduleSimpleSequence _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingScheduleSimpleSequence {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxFixingScheduleSimpleSequence  ***********************/
	class FxFixingScheduleSimpleSequenceBuilderImpl implements FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder {
	
		protected Date startDate;
		protected Date endDate;
	
		public FxFixingScheduleSimpleSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("startDate")
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("startDate")
		public FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder setStartDate(Date startDate) {
			this.startDate = startDate==null?null:startDate;
			return this;
		}
		@Override
		@RosettaAttribute("endDate")
		public FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder setEndDate(Date endDate) {
			this.endDate = endDate==null?null:endDate;
			return this;
		}
		
		@Override
		public FxFixingScheduleSimpleSequence build() {
			return new FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceImpl(this);
		}
		
		@Override
		public FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder o = (FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder) other;
			
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixingScheduleSimpleSequence _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingScheduleSimpleSequenceBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}
}
