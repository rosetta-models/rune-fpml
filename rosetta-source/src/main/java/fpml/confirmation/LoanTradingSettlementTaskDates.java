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
import fpml.confirmation.LoanTradingSettlementTaskDates;
import fpml.confirmation.LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder;
import fpml.confirmation.LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilderImpl;
import fpml.confirmation.LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesImpl;
import fpml.confirmation.meta.LoanTradingSettlementTaskDatesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that details key dates related to a task that is a prerequisite to trade settlement.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanTradingSettlementTaskDates", builder=LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanTradingSettlementTaskDates extends RosettaModelObject {

	LoanTradingSettlementTaskDatesMeta metaData = new LoanTradingSettlementTaskDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which the settlement task was raised.
	 */
	Date getRaisedDate();
	/**
	 * The date by which the settlement task is expected to be completed.
	 */
	Date getExpectedDate();
	/**
	 * The date on which the settlement task was either cleared or cancelled.
	 */
	Date getClearedDate();

	/*********************** Build Methods  ***********************/
	LoanTradingSettlementTaskDates build();
	
	LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder toBuilder();
	
	static LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder builder() {
		return new LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingSettlementTaskDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradingSettlementTaskDates> getType() {
		return LoanTradingSettlementTaskDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("raisedDate"), Date.class, getRaisedDate(), this);
		processor.processBasic(path.newSubPath("expectedDate"), Date.class, getExpectedDate(), this);
		processor.processBasic(path.newSubPath("clearedDate"), Date.class, getClearedDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingSettlementTaskDatesBuilder extends LoanTradingSettlementTaskDates, RosettaModelObjectBuilder {
		LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder setRaisedDate(Date raisedDate);
		LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder setExpectedDate(Date expectedDate);
		LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder setClearedDate(Date clearedDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("raisedDate"), Date.class, getRaisedDate(), this);
			processor.processBasic(path.newSubPath("expectedDate"), Date.class, getExpectedDate(), this);
			processor.processBasic(path.newSubPath("clearedDate"), Date.class, getClearedDate(), this);
		}
		

		LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingSettlementTaskDates  ***********************/
	class LoanTradingSettlementTaskDatesImpl implements LoanTradingSettlementTaskDates {
		private final Date raisedDate;
		private final Date expectedDate;
		private final Date clearedDate;
		
		protected LoanTradingSettlementTaskDatesImpl(LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder builder) {
			this.raisedDate = builder.getRaisedDate();
			this.expectedDate = builder.getExpectedDate();
			this.clearedDate = builder.getClearedDate();
		}
		
		@Override
		@RosettaAttribute("raisedDate")
		public Date getRaisedDate() {
			return raisedDate;
		}
		
		@Override
		@RosettaAttribute("expectedDate")
		public Date getExpectedDate() {
			return expectedDate;
		}
		
		@Override
		@RosettaAttribute("clearedDate")
		public Date getClearedDate() {
			return clearedDate;
		}
		
		@Override
		public LoanTradingSettlementTaskDates build() {
			return this;
		}
		
		@Override
		public LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder toBuilder() {
			LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder builder) {
			ofNullable(getRaisedDate()).ifPresent(builder::setRaisedDate);
			ofNullable(getExpectedDate()).ifPresent(builder::setExpectedDate);
			ofNullable(getClearedDate()).ifPresent(builder::setClearedDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingSettlementTaskDates _that = getType().cast(o);
		
			if (!Objects.equals(raisedDate, _that.getRaisedDate())) return false;
			if (!Objects.equals(expectedDate, _that.getExpectedDate())) return false;
			if (!Objects.equals(clearedDate, _that.getClearedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (raisedDate != null ? raisedDate.hashCode() : 0);
			_result = 31 * _result + (expectedDate != null ? expectedDate.hashCode() : 0);
			_result = 31 * _result + (clearedDate != null ? clearedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingSettlementTaskDates {" +
				"raisedDate=" + this.raisedDate + ", " +
				"expectedDate=" + this.expectedDate + ", " +
				"clearedDate=" + this.clearedDate +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingSettlementTaskDates  ***********************/
	class LoanTradingSettlementTaskDatesBuilderImpl implements LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder {
	
		protected Date raisedDate;
		protected Date expectedDate;
		protected Date clearedDate;
	
		public LoanTradingSettlementTaskDatesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("raisedDate")
		public Date getRaisedDate() {
			return raisedDate;
		}
		
		@Override
		@RosettaAttribute("expectedDate")
		public Date getExpectedDate() {
			return expectedDate;
		}
		
		@Override
		@RosettaAttribute("clearedDate")
		public Date getClearedDate() {
			return clearedDate;
		}
		
		@Override
		@RosettaAttribute("raisedDate")
		public LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder setRaisedDate(Date raisedDate) {
			this.raisedDate = raisedDate==null?null:raisedDate;
			return this;
		}
		@Override
		@RosettaAttribute("expectedDate")
		public LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder setExpectedDate(Date expectedDate) {
			this.expectedDate = expectedDate==null?null:expectedDate;
			return this;
		}
		@Override
		@RosettaAttribute("clearedDate")
		public LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder setClearedDate(Date clearedDate) {
			this.clearedDate = clearedDate==null?null:clearedDate;
			return this;
		}
		
		@Override
		public LoanTradingSettlementTaskDates build() {
			return new LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesImpl(this);
		}
		
		@Override
		public LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRaisedDate()!=null) return true;
			if (getExpectedDate()!=null) return true;
			if (getClearedDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder o = (LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder) other;
			
			
			merger.mergeBasic(getRaisedDate(), o.getRaisedDate(), this::setRaisedDate);
			merger.mergeBasic(getExpectedDate(), o.getExpectedDate(), this::setExpectedDate);
			merger.mergeBasic(getClearedDate(), o.getClearedDate(), this::setClearedDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingSettlementTaskDates _that = getType().cast(o);
		
			if (!Objects.equals(raisedDate, _that.getRaisedDate())) return false;
			if (!Objects.equals(expectedDate, _that.getExpectedDate())) return false;
			if (!Objects.equals(clearedDate, _that.getClearedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (raisedDate != null ? raisedDate.hashCode() : 0);
			_result = 31 * _result + (expectedDate != null ? expectedDate.hashCode() : 0);
			_result = 31 * _result + (clearedDate != null ? clearedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingSettlementTaskDatesBuilder {" +
				"raisedDate=" + this.raisedDate + ", " +
				"expectedDate=" + this.expectedDate + ", " +
				"clearedDate=" + this.clearedDate +
			'}';
		}
	}
}
