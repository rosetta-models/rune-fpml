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
import fpml.confirmation.FxExchangedCurrency;
import fpml.confirmation.FxExchangedCurrency.FxExchangedCurrencyBuilder;
import fpml.confirmation.FxExchangedCurrency.FxExchangedCurrencyBuilderImpl;
import fpml.confirmation.FxExchangedCurrency.FxExchangedCurrencyImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.meta.FxExchangedCurrencyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Indicates the direction who pays and receives a specific currency without specifying the amount.
 * @version ${project.version}
 */
@RosettaDataType(value="FxExchangedCurrency", builder=FxExchangedCurrency.FxExchangedCurrencyBuilderImpl.class, version="${project.version}")
public interface FxExchangedCurrency extends RosettaModelObject {

	FxExchangedCurrencyMeta metaData = new FxExchangedCurrencyMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	Currency getCurrency();

	/*********************** Build Methods  ***********************/
	FxExchangedCurrency build();
	
	FxExchangedCurrency.FxExchangedCurrencyBuilder toBuilder();
	
	static FxExchangedCurrency.FxExchangedCurrencyBuilder builder() {
		return new FxExchangedCurrency.FxExchangedCurrencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxExchangedCurrency> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxExchangedCurrency> getType() {
		return FxExchangedCurrency.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxExchangedCurrencyBuilder extends FxExchangedCurrency, RosettaModelObjectBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		FxExchangedCurrency.FxExchangedCurrencyBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		FxExchangedCurrency.FxExchangedCurrencyBuilder setCurrency(Currency currency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
		}
		

		FxExchangedCurrency.FxExchangedCurrencyBuilder prune();
	}

	/*********************** Immutable Implementation of FxExchangedCurrency  ***********************/
	class FxExchangedCurrencyImpl implements FxExchangedCurrency {
		private final PayerReceiverModel payerReceiverModel;
		private final Currency currency;
		
		protected FxExchangedCurrencyImpl(FxExchangedCurrency.FxExchangedCurrencyBuilder builder) {
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		public FxExchangedCurrency build() {
			return this;
		}
		
		@Override
		public FxExchangedCurrency.FxExchangedCurrencyBuilder toBuilder() {
			FxExchangedCurrency.FxExchangedCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxExchangedCurrency.FxExchangedCurrencyBuilder builder) {
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxExchangedCurrency _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxExchangedCurrency {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"currency=" + this.currency +
			'}';
		}
	}

	/*********************** Builder Implementation of FxExchangedCurrency  ***********************/
	class FxExchangedCurrencyBuilderImpl implements FxExchangedCurrency.FxExchangedCurrencyBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected Currency.CurrencyBuilder currency;
	
		public FxExchangedCurrencyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		public PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel() {
			PayerReceiverModel.PayerReceiverModelBuilder result;
			if (payerReceiverModel!=null) {
				result = payerReceiverModel;
			}
			else {
				result = payerReceiverModel = PayerReceiverModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public FxExchangedCurrency.FxExchangedCurrencyBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public FxExchangedCurrency.FxExchangedCurrencyBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public FxExchangedCurrency build() {
			return new FxExchangedCurrency.FxExchangedCurrencyImpl(this);
		}
		
		@Override
		public FxExchangedCurrency.FxExchangedCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxExchangedCurrency.FxExchangedCurrencyBuilder prune() {
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxExchangedCurrency.FxExchangedCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxExchangedCurrency.FxExchangedCurrencyBuilder o = (FxExchangedCurrency.FxExchangedCurrencyBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxExchangedCurrency _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxExchangedCurrencyBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"currency=" + this.currency +
			'}';
		}
	}
}
