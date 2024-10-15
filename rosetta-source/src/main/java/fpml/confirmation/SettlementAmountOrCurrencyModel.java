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
import fpml.confirmation.Money;
import fpml.confirmation.SettlementAmountOrCurrencyModel;
import fpml.confirmation.SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder;
import fpml.confirmation.SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilderImpl;
import fpml.confirmation.SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelImpl;
import fpml.confirmation.meta.SettlementAmountOrCurrencyModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SettlementAmountOrCurrencyModel", builder=SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilderImpl.class, version="${project.version}")
public interface SettlementAmountOrCurrencyModel extends RosettaModelObject {

	SettlementAmountOrCurrencyModelMeta metaData = new SettlementAmountOrCurrencyModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Settlement Amount
	 */
	Money getSettlementAmount();
	/**
	 * Settlement Currency for use where the Settlement Amount cannot be known in advance
	 */
	Currency getSettlementCurrency();

	/*********************** Build Methods  ***********************/
	SettlementAmountOrCurrencyModel build();
	
	SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder toBuilder();
	
	static SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder builder() {
		return new SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementAmountOrCurrencyModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementAmountOrCurrencyModel> getType() {
		return SettlementAmountOrCurrencyModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementAmount"), processor, Money.class, getSettlementAmount());
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementAmountOrCurrencyModelBuilder extends SettlementAmountOrCurrencyModel, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateSettlementAmount();
		Money.MoneyBuilder getSettlementAmount();
		Currency.CurrencyBuilder getOrCreateSettlementCurrency();
		Currency.CurrencyBuilder getSettlementCurrency();
		SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder setSettlementAmount(Money settlementAmount);
		SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder setSettlementCurrency(Currency settlementCurrency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementAmount"), processor, Money.MoneyBuilder.class, getSettlementAmount());
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
		}
		

		SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementAmountOrCurrencyModel  ***********************/
	class SettlementAmountOrCurrencyModelImpl implements SettlementAmountOrCurrencyModel {
		private final Money settlementAmount;
		private final Currency settlementCurrency;
		
		protected SettlementAmountOrCurrencyModelImpl(SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder builder) {
			this.settlementAmount = ofNullable(builder.getSettlementAmount()).map(f->f.build()).orElse(null);
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementAmount")
		public Money getSettlementAmount() {
			return settlementAmount;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public Currency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public SettlementAmountOrCurrencyModel build() {
			return this;
		}
		
		@Override
		public SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder toBuilder() {
			SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder builder) {
			ofNullable(getSettlementAmount()).ifPresent(builder::setSettlementAmount);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementAmountOrCurrencyModel _that = getType().cast(o);
		
			if (!Objects.equals(settlementAmount, _that.getSettlementAmount())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementAmount != null ? settlementAmount.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementAmountOrCurrencyModel {" +
				"settlementAmount=" + this.settlementAmount + ", " +
				"settlementCurrency=" + this.settlementCurrency +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementAmountOrCurrencyModel  ***********************/
	class SettlementAmountOrCurrencyModelBuilderImpl implements SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder {
	
		protected Money.MoneyBuilder settlementAmount;
		protected Currency.CurrencyBuilder settlementCurrency;
	
		public SettlementAmountOrCurrencyModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementAmount")
		public Money.MoneyBuilder getSettlementAmount() {
			return settlementAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateSettlementAmount() {
			Money.MoneyBuilder result;
			if (settlementAmount!=null) {
				result = settlementAmount;
			}
			else {
				result = settlementAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public Currency.CurrencyBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateSettlementCurrency() {
			Currency.CurrencyBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementAmount")
		public SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder setSettlementAmount(Money settlementAmount) {
			this.settlementAmount = settlementAmount==null?null:settlementAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementCurrency")
		public SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder setSettlementCurrency(Currency settlementCurrency) {
			this.settlementCurrency = settlementCurrency==null?null:settlementCurrency.toBuilder();
			return this;
		}
		
		@Override
		public SettlementAmountOrCurrencyModel build() {
			return new SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelImpl(this);
		}
		
		@Override
		public SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder prune() {
			if (settlementAmount!=null && !settlementAmount.prune().hasData()) settlementAmount = null;
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementAmount()!=null && getSettlementAmount().hasData()) return true;
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder o = (SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder) other;
			
			merger.mergeRosetta(getSettlementAmount(), o.getSettlementAmount(), this::setSettlementAmount);
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementAmountOrCurrencyModel _that = getType().cast(o);
		
			if (!Objects.equals(settlementAmount, _that.getSettlementAmount())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementAmount != null ? settlementAmount.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementAmountOrCurrencyModelBuilder {" +
				"settlementAmount=" + this.settlementAmount + ", " +
				"settlementCurrency=" + this.settlementCurrency +
			'}';
		}
	}
}
