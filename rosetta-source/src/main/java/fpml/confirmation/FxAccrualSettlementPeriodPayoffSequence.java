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
import fpml.confirmation.FxAccrualSettlementPeriodPayoffSequence;
import fpml.confirmation.FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder;
import fpml.confirmation.FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilderImpl;
import fpml.confirmation.FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceImpl;
import fpml.confirmation.meta.FxAccrualSettlementPeriodPayoffSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualSettlementPeriodPayoffSequence", builder=FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilderImpl.class, version="${project.version}")
public interface FxAccrualSettlementPeriodPayoffSequence extends RosettaModelObject {

	FxAccrualSettlementPeriodPayoffSequenceMeta metaData = new FxAccrualSettlementPeriodPayoffSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Strike for the settlement period.
	 */
	BigDecimal getStrike();
	/**
	 * Counter Currency Amount for the settlement period. Multiple Counter Currency Amount elements may appear if there are more than one strike in the settlement period.
	 */
	BigDecimal getCounterCurrencyAmount();

	/*********************** Build Methods  ***********************/
	FxAccrualSettlementPeriodPayoffSequence build();
	
	FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder toBuilder();
	
	static FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder builder() {
		return new FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualSettlementPeriodPayoffSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualSettlementPeriodPayoffSequence> getType() {
		return FxAccrualSettlementPeriodPayoffSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
		processor.processBasic(path.newSubPath("counterCurrencyAmount"), BigDecimal.class, getCounterCurrencyAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualSettlementPeriodPayoffSequenceBuilder extends FxAccrualSettlementPeriodPayoffSequence, RosettaModelObjectBuilder {
		FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder setStrike(BigDecimal strike);
		FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder setCounterCurrencyAmount(BigDecimal counterCurrencyAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
			processor.processBasic(path.newSubPath("counterCurrencyAmount"), BigDecimal.class, getCounterCurrencyAmount(), this);
		}
		

		FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualSettlementPeriodPayoffSequence  ***********************/
	class FxAccrualSettlementPeriodPayoffSequenceImpl implements FxAccrualSettlementPeriodPayoffSequence {
		private final BigDecimal strike;
		private final BigDecimal counterCurrencyAmount;
		
		protected FxAccrualSettlementPeriodPayoffSequenceImpl(FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder builder) {
			this.strike = builder.getStrike();
			this.counterCurrencyAmount = builder.getCounterCurrencyAmount();
		}
		
		@Override
		@RosettaAttribute("strike")
		public BigDecimal getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public BigDecimal getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public FxAccrualSettlementPeriodPayoffSequence build() {
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder toBuilder() {
			FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder builder) {
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getCounterCurrencyAmount()).ifPresent(builder::setCounterCurrencyAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualSettlementPeriodPayoffSequence _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualSettlementPeriodPayoffSequence {" +
				"strike=" + this.strike + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualSettlementPeriodPayoffSequence  ***********************/
	class FxAccrualSettlementPeriodPayoffSequenceBuilderImpl implements FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder {
	
		protected BigDecimal strike;
		protected BigDecimal counterCurrencyAmount;
	
		public FxAccrualSettlementPeriodPayoffSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strike")
		public BigDecimal getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public BigDecimal getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		@RosettaAttribute("strike")
		public FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder setStrike(BigDecimal strike) {
			this.strike = strike==null?null:strike;
			return this;
		}
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		public FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder setCounterCurrencyAmount(BigDecimal counterCurrencyAmount) {
			this.counterCurrencyAmount = counterCurrencyAmount==null?null:counterCurrencyAmount;
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriodPayoffSequence build() {
			return new FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceImpl(this);
		}
		
		@Override
		public FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStrike()!=null) return true;
			if (getCounterCurrencyAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder o = (FxAccrualSettlementPeriodPayoffSequence.FxAccrualSettlementPeriodPayoffSequenceBuilder) other;
			
			
			merger.mergeBasic(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeBasic(getCounterCurrencyAmount(), o.getCounterCurrencyAmount(), this::setCounterCurrencyAmount);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualSettlementPeriodPayoffSequence _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualSettlementPeriodPayoffSequenceBuilder {" +
				"strike=" + this.strike + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}
}
