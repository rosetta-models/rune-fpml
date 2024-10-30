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
import fpml.confirmation.LoanTransferFeePaidByEnum;
import fpml.confirmation.LoanTransferFeeSequence;
import fpml.confirmation.LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder;
import fpml.confirmation.LoanTransferFeeSequence.LoanTransferFeeSequenceBuilderImpl;
import fpml.confirmation.LoanTransferFeeSequence.LoanTransferFeeSequenceImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.LoanTransferFeeSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanTransferFeeSequence", builder=LoanTransferFeeSequence.LoanTransferFeeSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanTransferFeeSequence extends RosettaModelObject {

	LoanTransferFeeSequenceMeta metaData = new LoanTransferFeeSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Rule enumeration for transfer fee split and paid by.
	 */
	LoanTransferFeePaidByEnum getPaidBy();
	/**
	 * The amount payable to the agent for re-assigning a share in one of the underlying facilities within the deal.
	 */
	NonNegativeMoney getTotalAmount();

	/*********************** Build Methods  ***********************/
	LoanTransferFeeSequence build();
	
	LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder toBuilder();
	
	static LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder builder() {
		return new LoanTransferFeeSequence.LoanTransferFeeSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTransferFeeSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTransferFeeSequence> getType() {
		return LoanTransferFeeSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("paidBy"), LoanTransferFeePaidByEnum.class, getPaidBy(), this);
		processRosetta(path.newSubPath("totalAmount"), processor, NonNegativeMoney.class, getTotalAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTransferFeeSequenceBuilder extends LoanTransferFeeSequence, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateTotalAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getTotalAmount();
		LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder setPaidBy(LoanTransferFeePaidByEnum paidBy);
		LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder setTotalAmount(NonNegativeMoney totalAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("paidBy"), LoanTransferFeePaidByEnum.class, getPaidBy(), this);
			processRosetta(path.newSubPath("totalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getTotalAmount());
		}
		

		LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTransferFeeSequence  ***********************/
	class LoanTransferFeeSequenceImpl implements LoanTransferFeeSequence {
		private final LoanTransferFeePaidByEnum paidBy;
		private final NonNegativeMoney totalAmount;
		
		protected LoanTransferFeeSequenceImpl(LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder builder) {
			this.paidBy = builder.getPaidBy();
			this.totalAmount = ofNullable(builder.getTotalAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paidBy")
		public LoanTransferFeePaidByEnum getPaidBy() {
			return paidBy;
		}
		
		@Override
		@RosettaAttribute("totalAmount")
		public NonNegativeMoney getTotalAmount() {
			return totalAmount;
		}
		
		@Override
		public LoanTransferFeeSequence build() {
			return this;
		}
		
		@Override
		public LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder toBuilder() {
			LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder builder) {
			ofNullable(getPaidBy()).ifPresent(builder::setPaidBy);
			ofNullable(getTotalAmount()).ifPresent(builder::setTotalAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTransferFeeSequence _that = getType().cast(o);
		
			if (!Objects.equals(paidBy, _that.getPaidBy())) return false;
			if (!Objects.equals(totalAmount, _that.getTotalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paidBy != null ? paidBy.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (totalAmount != null ? totalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTransferFeeSequence {" +
				"paidBy=" + this.paidBy + ", " +
				"totalAmount=" + this.totalAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTransferFeeSequence  ***********************/
	class LoanTransferFeeSequenceBuilderImpl implements LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder {
	
		protected LoanTransferFeePaidByEnum paidBy;
		protected NonNegativeMoney.NonNegativeMoneyBuilder totalAmount;
	
		public LoanTransferFeeSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("paidBy")
		public LoanTransferFeePaidByEnum getPaidBy() {
			return paidBy;
		}
		
		@Override
		@RosettaAttribute("totalAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getTotalAmount() {
			return totalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateTotalAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (totalAmount!=null) {
				result = totalAmount;
			}
			else {
				result = totalAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paidBy")
		public LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder setPaidBy(LoanTransferFeePaidByEnum paidBy) {
			this.paidBy = paidBy==null?null:paidBy;
			return this;
		}
		@Override
		@RosettaAttribute("totalAmount")
		public LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder setTotalAmount(NonNegativeMoney totalAmount) {
			this.totalAmount = totalAmount==null?null:totalAmount.toBuilder();
			return this;
		}
		
		@Override
		public LoanTransferFeeSequence build() {
			return new LoanTransferFeeSequence.LoanTransferFeeSequenceImpl(this);
		}
		
		@Override
		public LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder prune() {
			if (totalAmount!=null && !totalAmount.prune().hasData()) totalAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPaidBy()!=null) return true;
			if (getTotalAmount()!=null && getTotalAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder o = (LoanTransferFeeSequence.LoanTransferFeeSequenceBuilder) other;
			
			merger.mergeRosetta(getTotalAmount(), o.getTotalAmount(), this::setTotalAmount);
			
			merger.mergeBasic(getPaidBy(), o.getPaidBy(), this::setPaidBy);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTransferFeeSequence _that = getType().cast(o);
		
			if (!Objects.equals(paidBy, _that.getPaidBy())) return false;
			if (!Objects.equals(totalAmount, _that.getTotalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paidBy != null ? paidBy.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (totalAmount != null ? totalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTransferFeeSequenceBuilder {" +
				"paidBy=" + this.paidBy + ", " +
				"totalAmount=" + this.totalAmount +
			'}';
		}
	}
}
