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
import fpml.confirmation.SettlementPeriodLeverageSequence;
import fpml.confirmation.SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder;
import fpml.confirmation.SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilderImpl;
import fpml.confirmation.SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceImpl;
import fpml.confirmation.meta.SettlementPeriodLeverageSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="SettlementPeriodLeverageSequence", builder=SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface SettlementPeriodLeverageSequence extends RosettaModelObject {

	SettlementPeriodLeverageSequenceMeta metaData = new SettlementPeriodLeverageSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Leverage notional.
	 */
	BigDecimal getNotionalAmount();
	/**
	 * Leverage counter currency notional.
	 */
	BigDecimal getCounterCurrencyAmount();

	/*********************** Build Methods  ***********************/
	SettlementPeriodLeverageSequence build();
	
	SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder toBuilder();
	
	static SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder builder() {
		return new SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPeriodLeverageSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementPeriodLeverageSequence> getType() {
		return SettlementPeriodLeverageSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
		processor.processBasic(path.newSubPath("counterCurrencyAmount"), BigDecimal.class, getCounterCurrencyAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPeriodLeverageSequenceBuilder extends SettlementPeriodLeverageSequence, RosettaModelObjectBuilder {
		SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder setNotionalAmount(BigDecimal notionalAmount);
		SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder setCounterCurrencyAmount(BigDecimal counterCurrencyAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
			processor.processBasic(path.newSubPath("counterCurrencyAmount"), BigDecimal.class, getCounterCurrencyAmount(), this);
		}
		

		SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPeriodLeverageSequence  ***********************/
	class SettlementPeriodLeverageSequenceImpl implements SettlementPeriodLeverageSequence {
		private final BigDecimal notionalAmount;
		private final BigDecimal counterCurrencyAmount;
		
		protected SettlementPeriodLeverageSequenceImpl(SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder builder) {
			this.notionalAmount = builder.getNotionalAmount();
			this.counterCurrencyAmount = builder.getCounterCurrencyAmount();
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public BigDecimal getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public BigDecimal getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public SettlementPeriodLeverageSequence build() {
			return this;
		}
		
		@Override
		public SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder toBuilder() {
			SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder builder) {
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getCounterCurrencyAmount()).ifPresent(builder::setCounterCurrencyAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodLeverageSequence _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodLeverageSequence {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementPeriodLeverageSequence  ***********************/
	class SettlementPeriodLeverageSequenceBuilderImpl implements SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder {
	
		protected BigDecimal notionalAmount;
		protected BigDecimal counterCurrencyAmount;
	
		public SettlementPeriodLeverageSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalAmount")
		public BigDecimal getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public BigDecimal getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder setNotionalAmount(BigDecimal notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount;
			return this;
		}
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder setCounterCurrencyAmount(BigDecimal counterCurrencyAmount) {
			this.counterCurrencyAmount = counterCurrencyAmount==null?null:counterCurrencyAmount;
			return this;
		}
		
		@Override
		public SettlementPeriodLeverageSequence build() {
			return new SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceImpl(this);
		}
		
		@Override
		public SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalAmount()!=null) return true;
			if (getCounterCurrencyAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder o = (SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder) other;
			
			
			merger.mergeBasic(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeBasic(getCounterCurrencyAmount(), o.getCounterCurrencyAmount(), this::setCounterCurrencyAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodLeverageSequence _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodLeverageSequenceBuilder {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}
}
