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
import fpml.confirmation.Currency;
import fpml.confirmation.FxOptionPayout;
import fpml.confirmation.FxOptionPayout.FxOptionPayoutBuilder;
import fpml.confirmation.FxOptionPayout.FxOptionPayoutBuilderImpl;
import fpml.confirmation.FxOptionPayout.FxOptionPayoutImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NonNegativeMoney.NonNegativeMoneyBuilder;
import fpml.confirmation.NonNegativeMoney.NonNegativeMoneyBuilderImpl;
import fpml.confirmation.NonNegativeMoney.NonNegativeMoneyImpl;
import fpml.confirmation.PayoutEnum;
import fpml.confirmation.SettlementInformation;
import fpml.confirmation.meta.FxOptionPayoutMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that contains full details of a predefined fixed payout which may occur (or not) in a Barrier Option or Digital Option when a trigger event occurs (or not).
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxOptionPayout", builder=FxOptionPayout.FxOptionPayoutBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxOptionPayout extends NonNegativeMoney {

	FxOptionPayoutMeta metaData = new FxOptionPayoutMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The trigger event and payout may be asynchonous. A payout may become due on the trigger event, or the payout may (by agreeement at initiation) be deferred (for example) to the maturity date.
	 */
	PayoutEnum getPayoutStyle();
	/**
	 * The information required to settle a currency payment that results from a trade.
	 */
	SettlementInformation getSettlementInformation();

	/*********************** Build Methods  ***********************/
	FxOptionPayout build();
	
	FxOptionPayout.FxOptionPayoutBuilder toBuilder();
	
	static FxOptionPayout.FxOptionPayoutBuilder builder() {
		return new FxOptionPayout.FxOptionPayoutBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxOptionPayout> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxOptionPayout> getType() {
		return FxOptionPayout.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("payoutStyle"), PayoutEnum.class, getPayoutStyle(), this);
		processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.class, getSettlementInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxOptionPayoutBuilder extends FxOptionPayout, NonNegativeMoney.NonNegativeMoneyBuilder {
		SettlementInformation.SettlementInformationBuilder getOrCreateSettlementInformation();
		SettlementInformation.SettlementInformationBuilder getSettlementInformation();
		FxOptionPayout.FxOptionPayoutBuilder setCurrency(Currency currency);
		FxOptionPayout.FxOptionPayoutBuilder setId(String id);
		FxOptionPayout.FxOptionPayoutBuilder setAmount(BigDecimal amount);
		FxOptionPayout.FxOptionPayoutBuilder setPayoutStyle(PayoutEnum payoutStyle);
		FxOptionPayout.FxOptionPayoutBuilder setSettlementInformation(SettlementInformation settlementInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("payoutStyle"), PayoutEnum.class, getPayoutStyle(), this);
			processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.SettlementInformationBuilder.class, getSettlementInformation());
		}
		

		FxOptionPayout.FxOptionPayoutBuilder prune();
	}

	/*********************** Immutable Implementation of FxOptionPayout  ***********************/
	class FxOptionPayoutImpl extends NonNegativeMoney.NonNegativeMoneyImpl implements FxOptionPayout {
		private final PayoutEnum payoutStyle;
		private final SettlementInformation settlementInformation;
		
		protected FxOptionPayoutImpl(FxOptionPayout.FxOptionPayoutBuilder builder) {
			super(builder);
			this.payoutStyle = builder.getPayoutStyle();
			this.settlementInformation = ofNullable(builder.getSettlementInformation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payoutStyle")
		public PayoutEnum getPayoutStyle() {
			return payoutStyle;
		}
		
		@Override
		@RosettaAttribute("settlementInformation")
		public SettlementInformation getSettlementInformation() {
			return settlementInformation;
		}
		
		@Override
		public FxOptionPayout build() {
			return this;
		}
		
		@Override
		public FxOptionPayout.FxOptionPayoutBuilder toBuilder() {
			FxOptionPayout.FxOptionPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxOptionPayout.FxOptionPayoutBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayoutStyle()).ifPresent(builder::setPayoutStyle);
			ofNullable(getSettlementInformation()).ifPresent(builder::setSettlementInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxOptionPayout _that = getType().cast(o);
		
			if (!Objects.equals(payoutStyle, _that.getPayoutStyle())) return false;
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payoutStyle != null ? payoutStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionPayout {" +
				"payoutStyle=" + this.payoutStyle + ", " +
				"settlementInformation=" + this.settlementInformation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxOptionPayout  ***********************/
	class FxOptionPayoutBuilderImpl extends NonNegativeMoney.NonNegativeMoneyBuilderImpl  implements FxOptionPayout.FxOptionPayoutBuilder {
	
		protected PayoutEnum payoutStyle;
		protected SettlementInformation.SettlementInformationBuilder settlementInformation;
	
		public FxOptionPayoutBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payoutStyle")
		public PayoutEnum getPayoutStyle() {
			return payoutStyle;
		}
		
		@Override
		@RosettaAttribute("settlementInformation")
		public SettlementInformation.SettlementInformationBuilder getSettlementInformation() {
			return settlementInformation;
		}
		
		@Override
		public SettlementInformation.SettlementInformationBuilder getOrCreateSettlementInformation() {
			SettlementInformation.SettlementInformationBuilder result;
			if (settlementInformation!=null) {
				result = settlementInformation;
			}
			else {
				result = settlementInformation = SettlementInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currency")
		public FxOptionPayout.FxOptionPayoutBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxOptionPayout.FxOptionPayoutBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public FxOptionPayout.FxOptionPayoutBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		@Override
		@RosettaAttribute("payoutStyle")
		public FxOptionPayout.FxOptionPayoutBuilder setPayoutStyle(PayoutEnum payoutStyle) {
			this.payoutStyle = payoutStyle==null?null:payoutStyle;
			return this;
		}
		@Override
		@RosettaAttribute("settlementInformation")
		public FxOptionPayout.FxOptionPayoutBuilder setSettlementInformation(SettlementInformation settlementInformation) {
			this.settlementInformation = settlementInformation==null?null:settlementInformation.toBuilder();
			return this;
		}
		
		@Override
		public FxOptionPayout build() {
			return new FxOptionPayout.FxOptionPayoutImpl(this);
		}
		
		@Override
		public FxOptionPayout.FxOptionPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionPayout.FxOptionPayoutBuilder prune() {
			super.prune();
			if (settlementInformation!=null && !settlementInformation.prune().hasData()) settlementInformation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayoutStyle()!=null) return true;
			if (getSettlementInformation()!=null && getSettlementInformation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionPayout.FxOptionPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxOptionPayout.FxOptionPayoutBuilder o = (FxOptionPayout.FxOptionPayoutBuilder) other;
			
			merger.mergeRosetta(getSettlementInformation(), o.getSettlementInformation(), this::setSettlementInformation);
			
			merger.mergeBasic(getPayoutStyle(), o.getPayoutStyle(), this::setPayoutStyle);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxOptionPayout _that = getType().cast(o);
		
			if (!Objects.equals(payoutStyle, _that.getPayoutStyle())) return false;
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payoutStyle != null ? payoutStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionPayoutBuilder {" +
				"payoutStyle=" + this.payoutStyle + ", " +
				"settlementInformation=" + this.settlementInformation +
			'}' + " " + super.toString();
		}
	}
}
