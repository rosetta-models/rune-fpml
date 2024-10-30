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
import fpml.confirmation.ExchangeTradedContract;
import fpml.confirmation.ReturnLegValuation;
import fpml.confirmation.ReturnLegValuation.ReturnLegValuationBuilder;
import fpml.confirmation.ReturnLegValuation.ReturnLegValuationBuilderImpl;
import fpml.confirmation.ReturnLegValuation.ReturnLegValuationImpl;
import fpml.confirmation.ReturnLegValuationPrice;
import fpml.confirmation.ReturnSwapPaymentDates;
import fpml.confirmation.meta.ReturnLegValuationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the initial and final valuation of the underlyer.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ReturnLegValuation", builder=ReturnLegValuation.ReturnLegValuationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ReturnLegValuation extends RosettaModelObject {

	ReturnLegValuationMeta metaData = new ReturnLegValuationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the initial reference price of the underlyer. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
	 */
	ReturnLegValuationPrice getInitialPrice();
	/**
	 * For return swaps, this element is equivalent to the term &quot;Equity Notional Reset&quot; as defined in the ISDA 2002 Equity Derivatives Definitions. The reference to the ISDA definition is either &quot;Applicable&quot; or &#39;Inapplicable&quot;.
	 */
	Boolean getNotionalReset();
	/**
	 * Specifies the final valuation price of the underlyer. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
	 */
	ReturnLegValuationPrice getValuationPriceInterim();
	/**
	 * Specifies the final valuation price of the underlyer. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
	 */
	ReturnLegValuationPrice getValuationPriceFinal();
	/**
	 * Specifies the payment dates of the swap.
	 */
	ReturnSwapPaymentDates getPaymentDates();
	/**
	 * References a Contract on the Exchange.
	 */
	ExchangeTradedContract getExchangeTradedContractNearest();

	/*********************** Build Methods  ***********************/
	ReturnLegValuation build();
	
	ReturnLegValuation.ReturnLegValuationBuilder toBuilder();
	
	static ReturnLegValuation.ReturnLegValuationBuilder builder() {
		return new ReturnLegValuation.ReturnLegValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnLegValuation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReturnLegValuation> getType() {
		return ReturnLegValuation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("initialPrice"), processor, ReturnLegValuationPrice.class, getInitialPrice());
		processor.processBasic(path.newSubPath("notionalReset"), Boolean.class, getNotionalReset(), this);
		processRosetta(path.newSubPath("valuationPriceInterim"), processor, ReturnLegValuationPrice.class, getValuationPriceInterim());
		processRosetta(path.newSubPath("valuationPriceFinal"), processor, ReturnLegValuationPrice.class, getValuationPriceFinal());
		processRosetta(path.newSubPath("paymentDates"), processor, ReturnSwapPaymentDates.class, getPaymentDates());
		processRosetta(path.newSubPath("exchangeTradedContractNearest"), processor, ExchangeTradedContract.class, getExchangeTradedContractNearest());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnLegValuationBuilder extends ReturnLegValuation, RosettaModelObjectBuilder {
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getOrCreateInitialPrice();
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getInitialPrice();
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getOrCreateValuationPriceInterim();
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getValuationPriceInterim();
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getOrCreateValuationPriceFinal();
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getValuationPriceFinal();
		ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder getOrCreatePaymentDates();
		ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder getPaymentDates();
		ExchangeTradedContract.ExchangeTradedContractBuilder getOrCreateExchangeTradedContractNearest();
		ExchangeTradedContract.ExchangeTradedContractBuilder getExchangeTradedContractNearest();
		ReturnLegValuation.ReturnLegValuationBuilder setInitialPrice(ReturnLegValuationPrice initialPrice);
		ReturnLegValuation.ReturnLegValuationBuilder setNotionalReset(Boolean notionalReset);
		ReturnLegValuation.ReturnLegValuationBuilder setValuationPriceInterim(ReturnLegValuationPrice valuationPriceInterim);
		ReturnLegValuation.ReturnLegValuationBuilder setValuationPriceFinal(ReturnLegValuationPrice valuationPriceFinal);
		ReturnLegValuation.ReturnLegValuationBuilder setPaymentDates(ReturnSwapPaymentDates paymentDates);
		ReturnLegValuation.ReturnLegValuationBuilder setExchangeTradedContractNearest(ExchangeTradedContract exchangeTradedContractNearest);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("initialPrice"), processor, ReturnLegValuationPrice.ReturnLegValuationPriceBuilder.class, getInitialPrice());
			processor.processBasic(path.newSubPath("notionalReset"), Boolean.class, getNotionalReset(), this);
			processRosetta(path.newSubPath("valuationPriceInterim"), processor, ReturnLegValuationPrice.ReturnLegValuationPriceBuilder.class, getValuationPriceInterim());
			processRosetta(path.newSubPath("valuationPriceFinal"), processor, ReturnLegValuationPrice.ReturnLegValuationPriceBuilder.class, getValuationPriceFinal());
			processRosetta(path.newSubPath("paymentDates"), processor, ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder.class, getPaymentDates());
			processRosetta(path.newSubPath("exchangeTradedContractNearest"), processor, ExchangeTradedContract.ExchangeTradedContractBuilder.class, getExchangeTradedContractNearest());
		}
		

		ReturnLegValuation.ReturnLegValuationBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnLegValuation  ***********************/
	class ReturnLegValuationImpl implements ReturnLegValuation {
		private final ReturnLegValuationPrice initialPrice;
		private final Boolean notionalReset;
		private final ReturnLegValuationPrice valuationPriceInterim;
		private final ReturnLegValuationPrice valuationPriceFinal;
		private final ReturnSwapPaymentDates paymentDates;
		private final ExchangeTradedContract exchangeTradedContractNearest;
		
		protected ReturnLegValuationImpl(ReturnLegValuation.ReturnLegValuationBuilder builder) {
			this.initialPrice = ofNullable(builder.getInitialPrice()).map(f->f.build()).orElse(null);
			this.notionalReset = builder.getNotionalReset();
			this.valuationPriceInterim = ofNullable(builder.getValuationPriceInterim()).map(f->f.build()).orElse(null);
			this.valuationPriceFinal = ofNullable(builder.getValuationPriceFinal()).map(f->f.build()).orElse(null);
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
			this.exchangeTradedContractNearest = ofNullable(builder.getExchangeTradedContractNearest()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initialPrice")
		public ReturnLegValuationPrice getInitialPrice() {
			return initialPrice;
		}
		
		@Override
		@RosettaAttribute("notionalReset")
		public Boolean getNotionalReset() {
			return notionalReset;
		}
		
		@Override
		@RosettaAttribute("valuationPriceInterim")
		public ReturnLegValuationPrice getValuationPriceInterim() {
			return valuationPriceInterim;
		}
		
		@Override
		@RosettaAttribute("valuationPriceFinal")
		public ReturnLegValuationPrice getValuationPriceFinal() {
			return valuationPriceFinal;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		public ReturnSwapPaymentDates getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		@RosettaAttribute("exchangeTradedContractNearest")
		public ExchangeTradedContract getExchangeTradedContractNearest() {
			return exchangeTradedContractNearest;
		}
		
		@Override
		public ReturnLegValuation build() {
			return this;
		}
		
		@Override
		public ReturnLegValuation.ReturnLegValuationBuilder toBuilder() {
			ReturnLegValuation.ReturnLegValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnLegValuation.ReturnLegValuationBuilder builder) {
			ofNullable(getInitialPrice()).ifPresent(builder::setInitialPrice);
			ofNullable(getNotionalReset()).ifPresent(builder::setNotionalReset);
			ofNullable(getValuationPriceInterim()).ifPresent(builder::setValuationPriceInterim);
			ofNullable(getValuationPriceFinal()).ifPresent(builder::setValuationPriceFinal);
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
			ofNullable(getExchangeTradedContractNearest()).ifPresent(builder::setExchangeTradedContractNearest);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnLegValuation _that = getType().cast(o);
		
			if (!Objects.equals(initialPrice, _that.getInitialPrice())) return false;
			if (!Objects.equals(notionalReset, _that.getNotionalReset())) return false;
			if (!Objects.equals(valuationPriceInterim, _that.getValuationPriceInterim())) return false;
			if (!Objects.equals(valuationPriceFinal, _that.getValuationPriceFinal())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(exchangeTradedContractNearest, _that.getExchangeTradedContractNearest())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialPrice != null ? initialPrice.hashCode() : 0);
			_result = 31 * _result + (notionalReset != null ? notionalReset.hashCode() : 0);
			_result = 31 * _result + (valuationPriceInterim != null ? valuationPriceInterim.hashCode() : 0);
			_result = 31 * _result + (valuationPriceFinal != null ? valuationPriceFinal.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (exchangeTradedContractNearest != null ? exchangeTradedContractNearest.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnLegValuation {" +
				"initialPrice=" + this.initialPrice + ", " +
				"notionalReset=" + this.notionalReset + ", " +
				"valuationPriceInterim=" + this.valuationPriceInterim + ", " +
				"valuationPriceFinal=" + this.valuationPriceFinal + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"exchangeTradedContractNearest=" + this.exchangeTradedContractNearest +
			'}';
		}
	}

	/*********************** Builder Implementation of ReturnLegValuation  ***********************/
	class ReturnLegValuationBuilderImpl implements ReturnLegValuation.ReturnLegValuationBuilder {
	
		protected ReturnLegValuationPrice.ReturnLegValuationPriceBuilder initialPrice;
		protected Boolean notionalReset;
		protected ReturnLegValuationPrice.ReturnLegValuationPriceBuilder valuationPriceInterim;
		protected ReturnLegValuationPrice.ReturnLegValuationPriceBuilder valuationPriceFinal;
		protected ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder paymentDates;
		protected ExchangeTradedContract.ExchangeTradedContractBuilder exchangeTradedContractNearest;
	
		public ReturnLegValuationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("initialPrice")
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getInitialPrice() {
			return initialPrice;
		}
		
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getOrCreateInitialPrice() {
			ReturnLegValuationPrice.ReturnLegValuationPriceBuilder result;
			if (initialPrice!=null) {
				result = initialPrice;
			}
			else {
				result = initialPrice = ReturnLegValuationPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalReset")
		public Boolean getNotionalReset() {
			return notionalReset;
		}
		
		@Override
		@RosettaAttribute("valuationPriceInterim")
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getValuationPriceInterim() {
			return valuationPriceInterim;
		}
		
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getOrCreateValuationPriceInterim() {
			ReturnLegValuationPrice.ReturnLegValuationPriceBuilder result;
			if (valuationPriceInterim!=null) {
				result = valuationPriceInterim;
			}
			else {
				result = valuationPriceInterim = ReturnLegValuationPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationPriceFinal")
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getValuationPriceFinal() {
			return valuationPriceFinal;
		}
		
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getOrCreateValuationPriceFinal() {
			ReturnLegValuationPrice.ReturnLegValuationPriceBuilder result;
			if (valuationPriceFinal!=null) {
				result = valuationPriceFinal;
			}
			else {
				result = valuationPriceFinal = ReturnLegValuationPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder getOrCreatePaymentDates() {
			ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder result;
			if (paymentDates!=null) {
				result = paymentDates;
			}
			else {
				result = paymentDates = ReturnSwapPaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangeTradedContractNearest")
		public ExchangeTradedContract.ExchangeTradedContractBuilder getExchangeTradedContractNearest() {
			return exchangeTradedContractNearest;
		}
		
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder getOrCreateExchangeTradedContractNearest() {
			ExchangeTradedContract.ExchangeTradedContractBuilder result;
			if (exchangeTradedContractNearest!=null) {
				result = exchangeTradedContractNearest;
			}
			else {
				result = exchangeTradedContractNearest = ExchangeTradedContract.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialPrice")
		public ReturnLegValuation.ReturnLegValuationBuilder setInitialPrice(ReturnLegValuationPrice initialPrice) {
			this.initialPrice = initialPrice==null?null:initialPrice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalReset")
		public ReturnLegValuation.ReturnLegValuationBuilder setNotionalReset(Boolean notionalReset) {
			this.notionalReset = notionalReset==null?null:notionalReset;
			return this;
		}
		@Override
		@RosettaAttribute("valuationPriceInterim")
		public ReturnLegValuation.ReturnLegValuationBuilder setValuationPriceInterim(ReturnLegValuationPrice valuationPriceInterim) {
			this.valuationPriceInterim = valuationPriceInterim==null?null:valuationPriceInterim.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationPriceFinal")
		public ReturnLegValuation.ReturnLegValuationBuilder setValuationPriceFinal(ReturnLegValuationPrice valuationPriceFinal) {
			this.valuationPriceFinal = valuationPriceFinal==null?null:valuationPriceFinal.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDates")
		public ReturnLegValuation.ReturnLegValuationBuilder setPaymentDates(ReturnSwapPaymentDates paymentDates) {
			this.paymentDates = paymentDates==null?null:paymentDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeTradedContractNearest")
		public ReturnLegValuation.ReturnLegValuationBuilder setExchangeTradedContractNearest(ExchangeTradedContract exchangeTradedContractNearest) {
			this.exchangeTradedContractNearest = exchangeTradedContractNearest==null?null:exchangeTradedContractNearest.toBuilder();
			return this;
		}
		
		@Override
		public ReturnLegValuation build() {
			return new ReturnLegValuation.ReturnLegValuationImpl(this);
		}
		
		@Override
		public ReturnLegValuation.ReturnLegValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnLegValuation.ReturnLegValuationBuilder prune() {
			if (initialPrice!=null && !initialPrice.prune().hasData()) initialPrice = null;
			if (valuationPriceInterim!=null && !valuationPriceInterim.prune().hasData()) valuationPriceInterim = null;
			if (valuationPriceFinal!=null && !valuationPriceFinal.prune().hasData()) valuationPriceFinal = null;
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			if (exchangeTradedContractNearest!=null && !exchangeTradedContractNearest.prune().hasData()) exchangeTradedContractNearest = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitialPrice()!=null && getInitialPrice().hasData()) return true;
			if (getNotionalReset()!=null) return true;
			if (getValuationPriceInterim()!=null && getValuationPriceInterim().hasData()) return true;
			if (getValuationPriceFinal()!=null && getValuationPriceFinal().hasData()) return true;
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			if (getExchangeTradedContractNearest()!=null && getExchangeTradedContractNearest().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnLegValuation.ReturnLegValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReturnLegValuation.ReturnLegValuationBuilder o = (ReturnLegValuation.ReturnLegValuationBuilder) other;
			
			merger.mergeRosetta(getInitialPrice(), o.getInitialPrice(), this::setInitialPrice);
			merger.mergeRosetta(getValuationPriceInterim(), o.getValuationPriceInterim(), this::setValuationPriceInterim);
			merger.mergeRosetta(getValuationPriceFinal(), o.getValuationPriceFinal(), this::setValuationPriceFinal);
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			merger.mergeRosetta(getExchangeTradedContractNearest(), o.getExchangeTradedContractNearest(), this::setExchangeTradedContractNearest);
			
			merger.mergeBasic(getNotionalReset(), o.getNotionalReset(), this::setNotionalReset);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnLegValuation _that = getType().cast(o);
		
			if (!Objects.equals(initialPrice, _that.getInitialPrice())) return false;
			if (!Objects.equals(notionalReset, _that.getNotionalReset())) return false;
			if (!Objects.equals(valuationPriceInterim, _that.getValuationPriceInterim())) return false;
			if (!Objects.equals(valuationPriceFinal, _that.getValuationPriceFinal())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(exchangeTradedContractNearest, _that.getExchangeTradedContractNearest())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialPrice != null ? initialPrice.hashCode() : 0);
			_result = 31 * _result + (notionalReset != null ? notionalReset.hashCode() : 0);
			_result = 31 * _result + (valuationPriceInterim != null ? valuationPriceInterim.hashCode() : 0);
			_result = 31 * _result + (valuationPriceFinal != null ? valuationPriceFinal.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (exchangeTradedContractNearest != null ? exchangeTradedContractNearest.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnLegValuationBuilder {" +
				"initialPrice=" + this.initialPrice + ", " +
				"notionalReset=" + this.notionalReset + ", " +
				"valuationPriceInterim=" + this.valuationPriceInterim + ", " +
				"valuationPriceFinal=" + this.valuationPriceFinal + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"exchangeTradedContractNearest=" + this.exchangeTradedContractNearest +
			'}';
		}
	}
}
