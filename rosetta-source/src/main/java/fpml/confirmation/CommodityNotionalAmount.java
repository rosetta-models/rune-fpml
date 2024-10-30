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
import fpml.confirmation.CommodityNotionalAmount;
import fpml.confirmation.CommodityNotionalAmount.CommodityNotionalAmountBuilder;
import fpml.confirmation.CommodityNotionalAmount.CommodityNotionalAmountBuilderImpl;
import fpml.confirmation.CommodityNotionalAmount.CommodityNotionalAmountImpl;
import fpml.confirmation.Currency;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NonNegativeMoney.NonNegativeMoneyBuilder;
import fpml.confirmation.NonNegativeMoney.NonNegativeMoneyBuilderImpl;
import fpml.confirmation.NonNegativeMoney.NonNegativeMoneyImpl;
import fpml.confirmation.meta.CommodityNotionalAmountMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A complex type to specify the notional amount.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityNotionalAmount", builder=CommodityNotionalAmount.CommodityNotionalAmountBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityNotionalAmount extends NonNegativeMoney {

	CommodityNotionalAmountMeta metaData = new CommodityNotionalAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * This element indicates whether the notional amount (or equivalent) is constant across each Calculation Period or whether the notional amount in each Calculation Period (&quot;false&quot;) is the notional amount in the previous period multiplied by 1 + commodity index return in the current period (&quot;true&quot;). In cases where reinstementFeature = true the &#39;amount&#39; element is the Initial Notional Amount (or equivalent).
	 */
	Boolean getReinvestmentFeature();

	/*********************** Build Methods  ***********************/
	CommodityNotionalAmount build();
	
	CommodityNotionalAmount.CommodityNotionalAmountBuilder toBuilder();
	
	static CommodityNotionalAmount.CommodityNotionalAmountBuilder builder() {
		return new CommodityNotionalAmount.CommodityNotionalAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityNotionalAmount> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityNotionalAmount> getType() {
		return CommodityNotionalAmount.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("reinvestmentFeature"), Boolean.class, getReinvestmentFeature(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityNotionalAmountBuilder extends CommodityNotionalAmount, NonNegativeMoney.NonNegativeMoneyBuilder {
		CommodityNotionalAmount.CommodityNotionalAmountBuilder setCurrency(Currency currency);
		CommodityNotionalAmount.CommodityNotionalAmountBuilder setId(String id);
		CommodityNotionalAmount.CommodityNotionalAmountBuilder setAmount(BigDecimal amount);
		CommodityNotionalAmount.CommodityNotionalAmountBuilder setReinvestmentFeature(Boolean reinvestmentFeature);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("reinvestmentFeature"), Boolean.class, getReinvestmentFeature(), this);
		}
		

		CommodityNotionalAmount.CommodityNotionalAmountBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityNotionalAmount  ***********************/
	class CommodityNotionalAmountImpl extends NonNegativeMoney.NonNegativeMoneyImpl implements CommodityNotionalAmount {
		private final Boolean reinvestmentFeature;
		
		protected CommodityNotionalAmountImpl(CommodityNotionalAmount.CommodityNotionalAmountBuilder builder) {
			super(builder);
			this.reinvestmentFeature = builder.getReinvestmentFeature();
		}
		
		@Override
		@RosettaAttribute("reinvestmentFeature")
		public Boolean getReinvestmentFeature() {
			return reinvestmentFeature;
		}
		
		@Override
		public CommodityNotionalAmount build() {
			return this;
		}
		
		@Override
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder toBuilder() {
			CommodityNotionalAmount.CommodityNotionalAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityNotionalAmount.CommodityNotionalAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getReinvestmentFeature()).ifPresent(builder::setReinvestmentFeature);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityNotionalAmount _that = getType().cast(o);
		
			if (!Objects.equals(reinvestmentFeature, _that.getReinvestmentFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reinvestmentFeature != null ? reinvestmentFeature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNotionalAmount {" +
				"reinvestmentFeature=" + this.reinvestmentFeature +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityNotionalAmount  ***********************/
	class CommodityNotionalAmountBuilderImpl extends NonNegativeMoney.NonNegativeMoneyBuilderImpl  implements CommodityNotionalAmount.CommodityNotionalAmountBuilder {
	
		protected Boolean reinvestmentFeature;
	
		public CommodityNotionalAmountBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("reinvestmentFeature")
		public Boolean getReinvestmentFeature() {
			return reinvestmentFeature;
		}
		
		@Override
		@RosettaAttribute("currency")
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		@Override
		@RosettaAttribute("reinvestmentFeature")
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder setReinvestmentFeature(Boolean reinvestmentFeature) {
			this.reinvestmentFeature = reinvestmentFeature==null?null:reinvestmentFeature;
			return this;
		}
		
		@Override
		public CommodityNotionalAmount build() {
			return new CommodityNotionalAmount.CommodityNotionalAmountImpl(this);
		}
		
		@Override
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getReinvestmentFeature()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityNotionalAmount.CommodityNotionalAmountBuilder o = (CommodityNotionalAmount.CommodityNotionalAmountBuilder) other;
			
			
			merger.mergeBasic(getReinvestmentFeature(), o.getReinvestmentFeature(), this::setReinvestmentFeature);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityNotionalAmount _that = getType().cast(o);
		
			if (!Objects.equals(reinvestmentFeature, _that.getReinvestmentFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reinvestmentFeature != null ? reinvestmentFeature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNotionalAmountBuilder {" +
				"reinvestmentFeature=" + this.reinvestmentFeature +
			'}' + " " + super.toString();
		}
	}
}
