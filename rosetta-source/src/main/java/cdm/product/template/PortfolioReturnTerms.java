package cdm.product.template;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.observable.asset.Observable;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder;
import cdm.product.asset.CorrelationReturnTerms;
import cdm.product.asset.DividendReturnTerms;
import cdm.product.asset.PriceReturnTerms;
import cdm.product.asset.VarianceReturnTerms;
import cdm.product.asset.VolatilityReturnTerms;
import cdm.product.template.PortfolioReturnTerms;
import cdm.product.template.PortfolioReturnTerms.PortfolioReturnTermsBuilder;
import cdm.product.template.PortfolioReturnTerms.PortfolioReturnTermsBuilderImpl;
import cdm.product.template.PortfolioReturnTerms.PortfolioReturnTermsImpl;
import cdm.product.template.ReturnTerms;
import cdm.product.template.ReturnTerms.ReturnTermsBuilder;
import cdm.product.template.ReturnTerms.ReturnTermsBuilderImpl;
import cdm.product.template.ReturnTerms.ReturnTermsImpl;
import cdm.product.template.meta.PortfolioReturnTermsMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies an individual type of return of a Performance Payout, when such individual return is part of an aggregation of multiple similar returns, at Performance Payout level.
 * @version 6.0.0-dev.76
 */
@RosettaDataType(value="PortfolioReturnTerms", builder=PortfolioReturnTerms.PortfolioReturnTermsBuilderImpl.class, version="6.0.0-dev.76")
public interface PortfolioReturnTerms extends ReturnTerms, GlobalKey {

	PortfolioReturnTermsMeta metaData = new PortfolioReturnTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Canonical representation of the payer and receiver parties applicable to each individual return leg.
	 */
	PayerReceiver getPayerReceiver();
	/**
	 * Defines the product that is the subject of a tradable product definition, an underlying product definition, a physical exercise, a position, or other purposes.
	 */
	ReferenceWithMetaObservable getUnderlier();
	/**
	 * Specifies a quantity schedule for the underlier, which applies to each individual return leg.
	 */
	ReferenceWithMetaNonNegativeQuantitySchedule getQuantity();
	/**
	 * Specifies the initial valuation price(s) of the underlier. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
	 */
	List<? extends ReferenceWithMetaPriceSchedule> getInitialValuationPrice();
	/**
	 * Specifies the initial valuation price(s) of the underlier. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
	 */
	List<? extends ReferenceWithMetaPriceSchedule> getInterimValuationPrice();
	/**
	 * 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Final Price | Specifies the final valuation price of the underlier. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
	 */
	List<? extends ReferenceWithMetaPriceSchedule> getFinalValuationPrice();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	PortfolioReturnTerms build();
	
	PortfolioReturnTerms.PortfolioReturnTermsBuilder toBuilder();
	
	static PortfolioReturnTerms.PortfolioReturnTermsBuilder builder() {
		return new PortfolioReturnTerms.PortfolioReturnTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PortfolioReturnTerms> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PortfolioReturnTerms> getType() {
		return PortfolioReturnTerms.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("priceReturnTerms"), processor, PriceReturnTerms.class, getPriceReturnTerms());
		processRosetta(path.newSubPath("dividendReturnTerms"), processor, DividendReturnTerms.class, getDividendReturnTerms());
		processRosetta(path.newSubPath("varianceReturnTerms"), processor, VarianceReturnTerms.class, getVarianceReturnTerms());
		processRosetta(path.newSubPath("volatilityReturnTerms"), processor, VolatilityReturnTerms.class, getVolatilityReturnTerms());
		processRosetta(path.newSubPath("correlationReturnTerms"), processor, CorrelationReturnTerms.class, getCorrelationReturnTerms());
		processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.class, getPayerReceiver());
		processRosetta(path.newSubPath("underlier"), processor, ReferenceWithMetaObservable.class, getUnderlier());
		processRosetta(path.newSubPath("quantity"), processor, ReferenceWithMetaNonNegativeQuantitySchedule.class, getQuantity());
		processRosetta(path.newSubPath("initialValuationPrice"), processor, ReferenceWithMetaPriceSchedule.class, getInitialValuationPrice());
		processRosetta(path.newSubPath("interimValuationPrice"), processor, ReferenceWithMetaPriceSchedule.class, getInterimValuationPrice());
		processRosetta(path.newSubPath("finalValuationPrice"), processor, ReferenceWithMetaPriceSchedule.class, getFinalValuationPrice());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioReturnTermsBuilder extends PortfolioReturnTerms, ReturnTerms.ReturnTermsBuilder {
		PayerReceiver.PayerReceiverBuilder getOrCreatePayerReceiver();
		PayerReceiver.PayerReceiverBuilder getPayerReceiver();
		ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder getOrCreateUnderlier();
		ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder getUnderlier();
		ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder getOrCreateQuantity();
		ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder getQuantity();
		ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateInitialValuationPrice(int _index);
		List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getInitialValuationPrice();
		ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateInterimValuationPrice(int _index);
		List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getInterimValuationPrice();
		ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateFinalValuationPrice(int _index);
		List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getFinalValuationPrice();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		PortfolioReturnTerms.PortfolioReturnTermsBuilder setPriceReturnTerms(PriceReturnTerms priceReturnTerms);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder setDividendReturnTerms(DividendReturnTerms dividendReturnTerms);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder setVarianceReturnTerms(VarianceReturnTerms varianceReturnTerms);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder setVolatilityReturnTerms(VolatilityReturnTerms volatilityReturnTerms);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder setCorrelationReturnTerms(CorrelationReturnTerms correlationReturnTerms);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder setPayerReceiver(PayerReceiver payerReceiver);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder setUnderlier(ReferenceWithMetaObservable underlier0);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder setUnderlierValue(Observable underlier1);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder setQuantity(ReferenceWithMetaNonNegativeQuantitySchedule quantity0);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder setQuantityValue(NonNegativeQuantitySchedule quantity1);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addInitialValuationPrice(ReferenceWithMetaPriceSchedule initialValuationPrice0);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addInitialValuationPrice(ReferenceWithMetaPriceSchedule initialValuationPrice1, int _idx);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addInitialValuationPriceValue(PriceSchedule initialValuationPrice2);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addInitialValuationPriceValue(PriceSchedule initialValuationPrice3, int _idx);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addInitialValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> initialValuationPrice4);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder setInitialValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> initialValuationPrice5);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addInitialValuationPriceValue(List<? extends PriceSchedule> initialValuationPrice6);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder setInitialValuationPriceValue(List<? extends PriceSchedule> initialValuationPrice7);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addInterimValuationPrice(ReferenceWithMetaPriceSchedule interimValuationPrice0);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addInterimValuationPrice(ReferenceWithMetaPriceSchedule interimValuationPrice1, int _idx);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addInterimValuationPriceValue(PriceSchedule interimValuationPrice2);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addInterimValuationPriceValue(PriceSchedule interimValuationPrice3, int _idx);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addInterimValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> interimValuationPrice4);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder setInterimValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> interimValuationPrice5);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addInterimValuationPriceValue(List<? extends PriceSchedule> interimValuationPrice6);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder setInterimValuationPriceValue(List<? extends PriceSchedule> interimValuationPrice7);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addFinalValuationPrice(ReferenceWithMetaPriceSchedule finalValuationPrice0);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addFinalValuationPrice(ReferenceWithMetaPriceSchedule finalValuationPrice1, int _idx);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addFinalValuationPriceValue(PriceSchedule finalValuationPrice2);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addFinalValuationPriceValue(PriceSchedule finalValuationPrice3, int _idx);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addFinalValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> finalValuationPrice4);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder setFinalValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> finalValuationPrice5);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder addFinalValuationPriceValue(List<? extends PriceSchedule> finalValuationPrice6);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder setFinalValuationPriceValue(List<? extends PriceSchedule> finalValuationPrice7);
		PortfolioReturnTerms.PortfolioReturnTermsBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("priceReturnTerms"), processor, PriceReturnTerms.PriceReturnTermsBuilder.class, getPriceReturnTerms());
			processRosetta(path.newSubPath("dividendReturnTerms"), processor, DividendReturnTerms.DividendReturnTermsBuilder.class, getDividendReturnTerms());
			processRosetta(path.newSubPath("varianceReturnTerms"), processor, VarianceReturnTerms.VarianceReturnTermsBuilder.class, getVarianceReturnTerms());
			processRosetta(path.newSubPath("volatilityReturnTerms"), processor, VolatilityReturnTerms.VolatilityReturnTermsBuilder.class, getVolatilityReturnTerms());
			processRosetta(path.newSubPath("correlationReturnTerms"), processor, CorrelationReturnTerms.CorrelationReturnTermsBuilder.class, getCorrelationReturnTerms());
			processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.PayerReceiverBuilder.class, getPayerReceiver());
			processRosetta(path.newSubPath("underlier"), processor, ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder.class, getUnderlier());
			processRosetta(path.newSubPath("quantity"), processor, ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder.class, getQuantity());
			processRosetta(path.newSubPath("initialValuationPrice"), processor, ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder.class, getInitialValuationPrice());
			processRosetta(path.newSubPath("interimValuationPrice"), processor, ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder.class, getInterimValuationPrice());
			processRosetta(path.newSubPath("finalValuationPrice"), processor, ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder.class, getFinalValuationPrice());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		PortfolioReturnTerms.PortfolioReturnTermsBuilder prune();
	}

	/*********************** Immutable Implementation of PortfolioReturnTerms  ***********************/
	class PortfolioReturnTermsImpl extends ReturnTerms.ReturnTermsImpl implements PortfolioReturnTerms {
		private final PayerReceiver payerReceiver;
		private final ReferenceWithMetaObservable underlier;
		private final ReferenceWithMetaNonNegativeQuantitySchedule quantity;
		private final List<? extends ReferenceWithMetaPriceSchedule> initialValuationPrice;
		private final List<? extends ReferenceWithMetaPriceSchedule> interimValuationPrice;
		private final List<? extends ReferenceWithMetaPriceSchedule> finalValuationPrice;
		private final MetaFields meta;
		
		protected PortfolioReturnTermsImpl(PortfolioReturnTerms.PortfolioReturnTermsBuilder builder) {
			super(builder);
			this.payerReceiver = ofNullable(builder.getPayerReceiver()).map(f->f.build()).orElse(null);
			this.underlier = ofNullable(builder.getUnderlier()).map(f->f.build()).orElse(null);
			this.quantity = ofNullable(builder.getQuantity()).map(f->f.build()).orElse(null);
			this.initialValuationPrice = ofNullable(builder.getInitialValuationPrice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.interimValuationPrice = ofNullable(builder.getInterimValuationPrice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.finalValuationPrice = ofNullable(builder.getFinalValuationPrice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiver")
		public PayerReceiver getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		@RosettaAttribute("underlier")
		public ReferenceWithMetaObservable getUnderlier() {
			return underlier;
		}
		
		@Override
		@RosettaAttribute("quantity")
		public ReferenceWithMetaNonNegativeQuantitySchedule getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("initialValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule> getInitialValuationPrice() {
			return initialValuationPrice;
		}
		
		@Override
		@RosettaAttribute("interimValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule> getInterimValuationPrice() {
			return interimValuationPrice;
		}
		
		@Override
		@RosettaAttribute("finalValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule> getFinalValuationPrice() {
			return finalValuationPrice;
		}
		
		@Override
		@RosettaAttribute("meta")
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public PortfolioReturnTerms build() {
			return this;
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder toBuilder() {
			PortfolioReturnTerms.PortfolioReturnTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PortfolioReturnTerms.PortfolioReturnTermsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiver()).ifPresent(builder::setPayerReceiver);
			ofNullable(getUnderlier()).ifPresent(builder::setUnderlier);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getInitialValuationPrice()).ifPresent(builder::setInitialValuationPrice);
			ofNullable(getInterimValuationPrice()).ifPresent(builder::setInterimValuationPrice);
			ofNullable(getFinalValuationPrice()).ifPresent(builder::setFinalValuationPrice);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PortfolioReturnTerms _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!ListEquals.listEquals(initialValuationPrice, _that.getInitialValuationPrice())) return false;
			if (!ListEquals.listEquals(interimValuationPrice, _that.getInterimValuationPrice())) return false;
			if (!ListEquals.listEquals(finalValuationPrice, _that.getFinalValuationPrice())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (initialValuationPrice != null ? initialValuationPrice.hashCode() : 0);
			_result = 31 * _result + (interimValuationPrice != null ? interimValuationPrice.hashCode() : 0);
			_result = 31 * _result + (finalValuationPrice != null ? finalValuationPrice.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioReturnTerms {" +
				"payerReceiver=" + this.payerReceiver + ", " +
				"underlier=" + this.underlier + ", " +
				"quantity=" + this.quantity + ", " +
				"initialValuationPrice=" + this.initialValuationPrice + ", " +
				"interimValuationPrice=" + this.interimValuationPrice + ", " +
				"finalValuationPrice=" + this.finalValuationPrice + ", " +
				"meta=" + this.meta +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PortfolioReturnTerms  ***********************/
	class PortfolioReturnTermsBuilderImpl extends ReturnTerms.ReturnTermsBuilderImpl  implements PortfolioReturnTerms.PortfolioReturnTermsBuilder, GlobalKeyBuilder {
	
		protected PayerReceiver.PayerReceiverBuilder payerReceiver;
		protected ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder underlier;
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantity;
		protected List<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> initialValuationPrice = new ArrayList<>();
		protected List<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> interimValuationPrice = new ArrayList<>();
		protected List<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> finalValuationPrice = new ArrayList<>();
		protected MetaFields.MetaFieldsBuilder meta;
	
		public PortfolioReturnTermsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payerReceiver")
		public PayerReceiver.PayerReceiverBuilder getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		public PayerReceiver.PayerReceiverBuilder getOrCreatePayerReceiver() {
			PayerReceiver.PayerReceiverBuilder result;
			if (payerReceiver!=null) {
				result = payerReceiver;
			}
			else {
				result = payerReceiver = PayerReceiver.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlier")
		public ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder getUnderlier() {
			return underlier;
		}
		
		@Override
		public ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder getOrCreateUnderlier() {
			ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder result;
			if (underlier!=null) {
				result = underlier;
			}
			else {
				result = underlier = ReferenceWithMetaObservable.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quantity")
		public ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder getQuantity() {
			return quantity;
		}
		
		@Override
		public ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder getOrCreateQuantity() {
			ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder result;
			if (quantity!=null) {
				result = quantity;
			}
			else {
				result = quantity = ReferenceWithMetaNonNegativeQuantitySchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getInitialValuationPrice() {
			return initialValuationPrice;
		}
		
		@Override
		public ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateInitialValuationPrice(int _index) {
		
			if (initialValuationPrice==null) {
				this.initialValuationPrice = new ArrayList<>();
			}
			ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder result;
			return getIndex(initialValuationPrice, _index, () -> {
						ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder newInitialValuationPrice = ReferenceWithMetaPriceSchedule.builder();
						return newInitialValuationPrice;
					});
		}
		
		@Override
		@RosettaAttribute("interimValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getInterimValuationPrice() {
			return interimValuationPrice;
		}
		
		@Override
		public ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateInterimValuationPrice(int _index) {
		
			if (interimValuationPrice==null) {
				this.interimValuationPrice = new ArrayList<>();
			}
			ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder result;
			return getIndex(interimValuationPrice, _index, () -> {
						ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder newInterimValuationPrice = ReferenceWithMetaPriceSchedule.builder();
						return newInterimValuationPrice;
					});
		}
		
		@Override
		@RosettaAttribute("finalValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getFinalValuationPrice() {
			return finalValuationPrice;
		}
		
		@Override
		public ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateFinalValuationPrice(int _index) {
		
			if (finalValuationPrice==null) {
				this.finalValuationPrice = new ArrayList<>();
			}
			ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder result;
			return getIndex(finalValuationPrice, _index, () -> {
						ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder newFinalValuationPrice = ReferenceWithMetaPriceSchedule.builder();
						return newFinalValuationPrice;
					});
		}
		
		@Override
		@RosettaAttribute("meta")
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priceReturnTerms")
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder setPriceReturnTerms(PriceReturnTerms priceReturnTerms) {
			this.priceReturnTerms = priceReturnTerms==null?null:priceReturnTerms.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dividendReturnTerms")
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder setDividendReturnTerms(DividendReturnTerms dividendReturnTerms) {
			this.dividendReturnTerms = dividendReturnTerms==null?null:dividendReturnTerms.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("varianceReturnTerms")
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder setVarianceReturnTerms(VarianceReturnTerms varianceReturnTerms) {
			this.varianceReturnTerms = varianceReturnTerms==null?null:varianceReturnTerms.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("volatilityReturnTerms")
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder setVolatilityReturnTerms(VolatilityReturnTerms volatilityReturnTerms) {
			this.volatilityReturnTerms = volatilityReturnTerms==null?null:volatilityReturnTerms.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationReturnTerms")
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder setCorrelationReturnTerms(CorrelationReturnTerms correlationReturnTerms) {
			this.correlationReturnTerms = correlationReturnTerms==null?null:correlationReturnTerms.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiver")
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder setPayerReceiver(PayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlier")
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder setUnderlier(ReferenceWithMetaObservable underlier) {
			this.underlier = underlier==null?null:underlier.toBuilder();
			return this;
		}
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder setUnderlierValue(Observable underlier) {
			this.getOrCreateUnderlier().setValue(underlier);
			return this;
		}
		@Override
		@RosettaAttribute("quantity")
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder setQuantity(ReferenceWithMetaNonNegativeQuantitySchedule quantity) {
			this.quantity = quantity==null?null:quantity.toBuilder();
			return this;
		}
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder setQuantityValue(NonNegativeQuantitySchedule quantity) {
			this.getOrCreateQuantity().setValue(quantity);
			return this;
		}
		@Override
		@RosettaAttribute("initialValuationPrice")
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addInitialValuationPrice(ReferenceWithMetaPriceSchedule initialValuationPrice) {
			if (initialValuationPrice!=null) this.initialValuationPrice.add(initialValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addInitialValuationPrice(ReferenceWithMetaPriceSchedule initialValuationPrice, int _idx) {
			getIndex(this.initialValuationPrice, _idx, () -> initialValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addInitialValuationPriceValue(PriceSchedule initialValuationPrice) {
			this.getOrCreateInitialValuationPrice(-1).setValue(initialValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addInitialValuationPriceValue(PriceSchedule initialValuationPrice, int _idx) {
			this.getOrCreateInitialValuationPrice(_idx).setValue(initialValuationPrice.toBuilder());
			return this;
		}
		@Override 
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addInitialValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> initialValuationPrices) {
			if (initialValuationPrices != null) {
				for (ReferenceWithMetaPriceSchedule toAdd : initialValuationPrices) {
					this.initialValuationPrice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder setInitialValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> initialValuationPrices) {
			if (initialValuationPrices == null)  {
				this.initialValuationPrice = new ArrayList<>();
			}
			else {
				this.initialValuationPrice = initialValuationPrices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addInitialValuationPriceValue(List<? extends PriceSchedule> initialValuationPrices) {
			if (initialValuationPrices != null) {
				for (PriceSchedule toAdd : initialValuationPrices) {
					this.addInitialValuationPriceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder setInitialValuationPriceValue(List<? extends PriceSchedule> initialValuationPrices) {
			this.initialValuationPrice.clear();
			if (initialValuationPrices!=null) {
				initialValuationPrices.forEach(this::addInitialValuationPriceValue);
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("interimValuationPrice")
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addInterimValuationPrice(ReferenceWithMetaPriceSchedule interimValuationPrice) {
			if (interimValuationPrice!=null) this.interimValuationPrice.add(interimValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addInterimValuationPrice(ReferenceWithMetaPriceSchedule interimValuationPrice, int _idx) {
			getIndex(this.interimValuationPrice, _idx, () -> interimValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addInterimValuationPriceValue(PriceSchedule interimValuationPrice) {
			this.getOrCreateInterimValuationPrice(-1).setValue(interimValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addInterimValuationPriceValue(PriceSchedule interimValuationPrice, int _idx) {
			this.getOrCreateInterimValuationPrice(_idx).setValue(interimValuationPrice.toBuilder());
			return this;
		}
		@Override 
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addInterimValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> interimValuationPrices) {
			if (interimValuationPrices != null) {
				for (ReferenceWithMetaPriceSchedule toAdd : interimValuationPrices) {
					this.interimValuationPrice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder setInterimValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> interimValuationPrices) {
			if (interimValuationPrices == null)  {
				this.interimValuationPrice = new ArrayList<>();
			}
			else {
				this.interimValuationPrice = interimValuationPrices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addInterimValuationPriceValue(List<? extends PriceSchedule> interimValuationPrices) {
			if (interimValuationPrices != null) {
				for (PriceSchedule toAdd : interimValuationPrices) {
					this.addInterimValuationPriceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder setInterimValuationPriceValue(List<? extends PriceSchedule> interimValuationPrices) {
			this.interimValuationPrice.clear();
			if (interimValuationPrices!=null) {
				interimValuationPrices.forEach(this::addInterimValuationPriceValue);
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("finalValuationPrice")
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addFinalValuationPrice(ReferenceWithMetaPriceSchedule finalValuationPrice) {
			if (finalValuationPrice!=null) this.finalValuationPrice.add(finalValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addFinalValuationPrice(ReferenceWithMetaPriceSchedule finalValuationPrice, int _idx) {
			getIndex(this.finalValuationPrice, _idx, () -> finalValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addFinalValuationPriceValue(PriceSchedule finalValuationPrice) {
			this.getOrCreateFinalValuationPrice(-1).setValue(finalValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addFinalValuationPriceValue(PriceSchedule finalValuationPrice, int _idx) {
			this.getOrCreateFinalValuationPrice(_idx).setValue(finalValuationPrice.toBuilder());
			return this;
		}
		@Override 
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addFinalValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> finalValuationPrices) {
			if (finalValuationPrices != null) {
				for (ReferenceWithMetaPriceSchedule toAdd : finalValuationPrices) {
					this.finalValuationPrice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder setFinalValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> finalValuationPrices) {
			if (finalValuationPrices == null)  {
				this.finalValuationPrice = new ArrayList<>();
			}
			else {
				this.finalValuationPrice = finalValuationPrices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder addFinalValuationPriceValue(List<? extends PriceSchedule> finalValuationPrices) {
			if (finalValuationPrices != null) {
				for (PriceSchedule toAdd : finalValuationPrices) {
					this.addFinalValuationPriceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder setFinalValuationPriceValue(List<? extends PriceSchedule> finalValuationPrices) {
			this.finalValuationPrice.clear();
			if (finalValuationPrices!=null) {
				finalValuationPrices.forEach(this::addFinalValuationPriceValue);
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		
		@Override
		public PortfolioReturnTerms build() {
			return new PortfolioReturnTerms.PortfolioReturnTermsImpl(this);
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder prune() {
			super.prune();
			if (payerReceiver!=null && !payerReceiver.prune().hasData()) payerReceiver = null;
			if (underlier!=null && !underlier.prune().hasData()) underlier = null;
			if (quantity!=null && !quantity.prune().hasData()) quantity = null;
			initialValuationPrice = initialValuationPrice.stream().filter(b->b!=null).<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			interimValuationPrice = interimValuationPrice.stream().filter(b->b!=null).<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			finalValuationPrice = finalValuationPrice.stream().filter(b->b!=null).<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerReceiver()!=null && getPayerReceiver().hasData()) return true;
			if (getUnderlier()!=null && getUnderlier().hasData()) return true;
			if (getQuantity()!=null && getQuantity().hasData()) return true;
			if (getInitialValuationPrice()!=null && getInitialValuationPrice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getInterimValuationPrice()!=null && getInterimValuationPrice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFinalValuationPrice()!=null && getFinalValuationPrice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PortfolioReturnTerms.PortfolioReturnTermsBuilder o = (PortfolioReturnTerms.PortfolioReturnTermsBuilder) other;
			
			merger.mergeRosetta(getPayerReceiver(), o.getPayerReceiver(), this::setPayerReceiver);
			merger.mergeRosetta(getUnderlier(), o.getUnderlier(), this::setUnderlier);
			merger.mergeRosetta(getQuantity(), o.getQuantity(), this::setQuantity);
			merger.mergeRosetta(getInitialValuationPrice(), o.getInitialValuationPrice(), this::getOrCreateInitialValuationPrice);
			merger.mergeRosetta(getInterimValuationPrice(), o.getInterimValuationPrice(), this::getOrCreateInterimValuationPrice);
			merger.mergeRosetta(getFinalValuationPrice(), o.getFinalValuationPrice(), this::getOrCreateFinalValuationPrice);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PortfolioReturnTerms _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!ListEquals.listEquals(initialValuationPrice, _that.getInitialValuationPrice())) return false;
			if (!ListEquals.listEquals(interimValuationPrice, _that.getInterimValuationPrice())) return false;
			if (!ListEquals.listEquals(finalValuationPrice, _that.getFinalValuationPrice())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (initialValuationPrice != null ? initialValuationPrice.hashCode() : 0);
			_result = 31 * _result + (interimValuationPrice != null ? interimValuationPrice.hashCode() : 0);
			_result = 31 * _result + (finalValuationPrice != null ? finalValuationPrice.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioReturnTermsBuilder {" +
				"payerReceiver=" + this.payerReceiver + ", " +
				"underlier=" + this.underlier + ", " +
				"quantity=" + this.quantity + ", " +
				"initialValuationPrice=" + this.initialValuationPrice + ", " +
				"interimValuationPrice=" + this.interimValuationPrice + ", " +
				"finalValuationPrice=" + this.finalValuationPrice + ", " +
				"meta=" + this.meta +
			'}' + " " + super.toString();
		}
	}
}
