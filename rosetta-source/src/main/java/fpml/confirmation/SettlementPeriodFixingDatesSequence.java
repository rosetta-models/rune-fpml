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
import fpml.confirmation.SettlementPeriodFixingDatesSequence;
import fpml.confirmation.SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder;
import fpml.confirmation.SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilderImpl;
import fpml.confirmation.SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceImpl;
import fpml.confirmation.meta.SettlementPeriodFixingDatesSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SettlementPeriodFixingDatesSequence", builder=SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilderImpl.class, version="${project.version}")
public interface SettlementPeriodFixingDatesSequence extends RosettaModelObject {

	SettlementPeriodFixingDatesSequenceMeta metaData = new SettlementPeriodFixingDatesSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Start date of the period.
	 */
	Date getStartDate();
	/**
	 * End date of the period.
	 */
	Date getEndDate();

	/*********************** Build Methods  ***********************/
	SettlementPeriodFixingDatesSequence build();
	
	SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder toBuilder();
	
	static SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder builder() {
		return new SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPeriodFixingDatesSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementPeriodFixingDatesSequence> getType() {
		return SettlementPeriodFixingDatesSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPeriodFixingDatesSequenceBuilder extends SettlementPeriodFixingDatesSequence, RosettaModelObjectBuilder {
		SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder setStartDate(Date startDate);
		SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder setEndDate(Date endDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		}
		

		SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPeriodFixingDatesSequence  ***********************/
	class SettlementPeriodFixingDatesSequenceImpl implements SettlementPeriodFixingDatesSequence {
		private final Date startDate;
		private final Date endDate;
		
		protected SettlementPeriodFixingDatesSequenceImpl(SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder builder) {
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
		public SettlementPeriodFixingDatesSequence build() {
			return this;
		}
		
		@Override
		public SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder toBuilder() {
			SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodFixingDatesSequence _that = getType().cast(o);
		
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
			return "SettlementPeriodFixingDatesSequence {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementPeriodFixingDatesSequence  ***********************/
	class SettlementPeriodFixingDatesSequenceBuilderImpl implements SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder {
	
		protected Date startDate;
		protected Date endDate;
	
		public SettlementPeriodFixingDatesSequenceBuilderImpl() {
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
		public SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder setStartDate(Date startDate) {
			this.startDate = startDate==null?null:startDate;
			return this;
		}
		@Override
		@RosettaAttribute("endDate")
		public SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder setEndDate(Date endDate) {
			this.endDate = endDate==null?null:endDate;
			return this;
		}
		
		@Override
		public SettlementPeriodFixingDatesSequence build() {
			return new SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceImpl(this);
		}
		
		@Override
		public SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder prune() {
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
		public SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder o = (SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder) other;
			
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodFixingDatesSequence _that = getType().cast(o);
		
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
			return "SettlementPeriodFixingDatesSequenceBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}
}
