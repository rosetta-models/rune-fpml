package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.AdjustableDate2;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.CashflowNotional;
import fpml.confirmation.GenericCommodityAttributesModel;
import fpml.confirmation.GenericEquityAttributesModel;
import fpml.confirmation.GenericFrequency;
import fpml.confirmation.GenericOptionAttributesModel;
import fpml.confirmation.GenericProduct;
import fpml.confirmation.GenericProduct.GenericProductBuilder;
import fpml.confirmation.GenericProduct.GenericProductBuilderImpl;
import fpml.confirmation.GenericProduct.GenericProductImpl;
import fpml.confirmation.GenericResetFrequency;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.PartyReference;
import fpml.confirmation.Payment;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.SettlementTypeEnum;
import fpml.confirmation.SimplePayment;
import fpml.confirmation.TradeUnderlyer2;
import fpml.confirmation.meta.GenericProductMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Generic products - for use in Transparency reporting to define a product that represents an OTC derivative transaction whose economics are not fully described using an FpML schema. In other views, generic products are present for convenience to support internal messaging and workflows that are cross-product. Generic products are not full trade representations as such they are not intended to be used for confirming trades. Simple product representation providing key information about a variety of different products. Generic products - for use in Transparency reporting to define a product that represents an OTC derivative transaction whose economics are not fully described using an FpML schema. In other views, generic products are present for convenience to support internal messaging and workflows that are cross-product. Generic products are not full trade representations as such they are not intended to be used for confirming trades.
 * @version ${project.version}
 */
@RosettaDataType(value="GenericProduct", builder=GenericProduct.GenericProductBuilderImpl.class, version="${project.version}")
public interface GenericProduct extends Product {

	GenericProductMeta metaData = new GenericProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates whether this transaction has multiple components, not all of which may be reported. The use of this field is not recommended, and it may be deprecated in a future version of this standard.
	 */
	Boolean getMultiLeg();
	BuyerSellerModel getBuyerSellerModel();
	List<? extends PartyReference> getCounterpartyReference();
	SimplePayment getPremium();
	/**
	 * The earliest of all the effective dates of all constituent streams.
	 */
	AdjustableDate2 getEffectiveDate();
	/**
	 * For options, the last exercise date of the option.
	 */
	AdjustableDate2 getExpirationDate();
	/**
	 * The latest of all of the termination (accrual end) dates of the constituent or underlying streams.
	 */
	AdjustableDate2 getTerminationDate();
	/**
	 * The set of underlyers to the trade that can be used in computing the trade&#39;s cashflows. If this information is needed to identify the trade, all of the trade&#39;s underlyers should be specified, whether or not they figure into the cashflow calculation. Otherwise, only those underlyers used to compute this particular cashflow need be supplied.
	 */
	List<? extends TradeUnderlyer2> getUnderlyer();
	/**
	 * The notional or notionals in effect on the reporting date.
	 */
	List<? extends CashflowNotional> getNotional();
	GenericCommodityAttributesModel getGenericCommodityAttributesModel();
	GenericEquityAttributesModel getGenericEquityAttributesModel();
	GenericOptionAttributesModel getGenericOptionAttributesModel();
	List<? extends GenericFrequency> getPaymentFrequency();
	List<? extends GenericResetFrequency> getResetFrequency();
	/**
	 * The currency or currencies in which the product can settle.
	 */
	List<? extends IdentifiedCurrency> getSettlementCurrency();
	/**
	 * How the trade settles (cash or physical). This element is also used for CFTC the &quot;Delivery Type&quot; field.
	 */
	SettlementTypeEnum getSettlementType();
	/**
	 * Additional payments between the principal parties.
	 */
	List<? extends Payment> getAdditionalPayment();

	/*********************** Build Methods  ***********************/
	GenericProduct build();
	
	GenericProduct.GenericProductBuilder toBuilder();
	
	static GenericProduct.GenericProductBuilder builder() {
		return new GenericProduct.GenericProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericProduct> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GenericProduct> getType() {
		return GenericProduct.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("multiLeg"), Boolean.class, getMultiLeg(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("counterpartyReference"), processor, PartyReference.class, getCounterpartyReference());
		processRosetta(path.newSubPath("premium"), processor, SimplePayment.class, getPremium());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableDate2.class, getEffectiveDate());
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableDate2.class, getExpirationDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableDate2.class, getTerminationDate());
		processRosetta(path.newSubPath("underlyer"), processor, TradeUnderlyer2.class, getUnderlyer());
		processRosetta(path.newSubPath("notional"), processor, CashflowNotional.class, getNotional());
		processRosetta(path.newSubPath("genericCommodityAttributesModel"), processor, GenericCommodityAttributesModel.class, getGenericCommodityAttributesModel());
		processRosetta(path.newSubPath("genericEquityAttributesModel"), processor, GenericEquityAttributesModel.class, getGenericEquityAttributesModel());
		processRosetta(path.newSubPath("genericOptionAttributesModel"), processor, GenericOptionAttributesModel.class, getGenericOptionAttributesModel());
		processRosetta(path.newSubPath("paymentFrequency"), processor, GenericFrequency.class, getPaymentFrequency());
		processRosetta(path.newSubPath("resetFrequency"), processor, GenericResetFrequency.class, getResetFrequency());
		processRosetta(path.newSubPath("settlementCurrency"), processor, IdentifiedCurrency.class, getSettlementCurrency());
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("additionalPayment"), processor, Payment.class, getAdditionalPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericProductBuilder extends GenericProduct, Product.ProductBuilder {
		BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel();
		BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel();
		PartyReference.PartyReferenceBuilder getOrCreateCounterpartyReference(int _index);
		List<? extends PartyReference.PartyReferenceBuilder> getCounterpartyReference();
		SimplePayment.SimplePaymentBuilder getOrCreatePremium();
		SimplePayment.SimplePaymentBuilder getPremium();
		AdjustableDate2.AdjustableDate2Builder getOrCreateEffectiveDate();
		AdjustableDate2.AdjustableDate2Builder getEffectiveDate();
		AdjustableDate2.AdjustableDate2Builder getOrCreateExpirationDate();
		AdjustableDate2.AdjustableDate2Builder getExpirationDate();
		AdjustableDate2.AdjustableDate2Builder getOrCreateTerminationDate();
		AdjustableDate2.AdjustableDate2Builder getTerminationDate();
		TradeUnderlyer2.TradeUnderlyer2Builder getOrCreateUnderlyer(int _index);
		List<? extends TradeUnderlyer2.TradeUnderlyer2Builder> getUnderlyer();
		CashflowNotional.CashflowNotionalBuilder getOrCreateNotional(int _index);
		List<? extends CashflowNotional.CashflowNotionalBuilder> getNotional();
		GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder getOrCreateGenericCommodityAttributesModel();
		GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder getGenericCommodityAttributesModel();
		GenericEquityAttributesModel.GenericEquityAttributesModelBuilder getOrCreateGenericEquityAttributesModel();
		GenericEquityAttributesModel.GenericEquityAttributesModelBuilder getGenericEquityAttributesModel();
		GenericOptionAttributesModel.GenericOptionAttributesModelBuilder getOrCreateGenericOptionAttributesModel();
		GenericOptionAttributesModel.GenericOptionAttributesModelBuilder getGenericOptionAttributesModel();
		GenericFrequency.GenericFrequencyBuilder getOrCreatePaymentFrequency(int _index);
		List<? extends GenericFrequency.GenericFrequencyBuilder> getPaymentFrequency();
		GenericResetFrequency.GenericResetFrequencyBuilder getOrCreateResetFrequency(int _index);
		List<? extends GenericResetFrequency.GenericResetFrequencyBuilder> getResetFrequency();
		IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateSettlementCurrency(int _index);
		List<? extends IdentifiedCurrency.IdentifiedCurrencyBuilder> getSettlementCurrency();
		Payment.PaymentBuilder getOrCreateAdditionalPayment(int _index);
		List<? extends Payment.PaymentBuilder> getAdditionalPayment();
		GenericProduct.GenericProductBuilder setProductModel(ProductModel productModel);
		GenericProduct.GenericProductBuilder setId(String id);
		GenericProduct.GenericProductBuilder setMultiLeg(Boolean multiLeg);
		GenericProduct.GenericProductBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		GenericProduct.GenericProductBuilder addCounterpartyReference(PartyReference counterpartyReference0);
		GenericProduct.GenericProductBuilder addCounterpartyReference(PartyReference counterpartyReference1, int _idx);
		GenericProduct.GenericProductBuilder addCounterpartyReference(List<? extends PartyReference> counterpartyReference2);
		GenericProduct.GenericProductBuilder setCounterpartyReference(List<? extends PartyReference> counterpartyReference3);
		GenericProduct.GenericProductBuilder setPremium(SimplePayment premium);
		GenericProduct.GenericProductBuilder setEffectiveDate(AdjustableDate2 effectiveDate);
		GenericProduct.GenericProductBuilder setExpirationDate(AdjustableDate2 expirationDate);
		GenericProduct.GenericProductBuilder setTerminationDate(AdjustableDate2 terminationDate);
		GenericProduct.GenericProductBuilder addUnderlyer(TradeUnderlyer2 underlyer0);
		GenericProduct.GenericProductBuilder addUnderlyer(TradeUnderlyer2 underlyer1, int _idx);
		GenericProduct.GenericProductBuilder addUnderlyer(List<? extends TradeUnderlyer2> underlyer2);
		GenericProduct.GenericProductBuilder setUnderlyer(List<? extends TradeUnderlyer2> underlyer3);
		GenericProduct.GenericProductBuilder addNotional(CashflowNotional notional0);
		GenericProduct.GenericProductBuilder addNotional(CashflowNotional notional1, int _idx);
		GenericProduct.GenericProductBuilder addNotional(List<? extends CashflowNotional> notional2);
		GenericProduct.GenericProductBuilder setNotional(List<? extends CashflowNotional> notional3);
		GenericProduct.GenericProductBuilder setGenericCommodityAttributesModel(GenericCommodityAttributesModel genericCommodityAttributesModel);
		GenericProduct.GenericProductBuilder setGenericEquityAttributesModel(GenericEquityAttributesModel genericEquityAttributesModel);
		GenericProduct.GenericProductBuilder setGenericOptionAttributesModel(GenericOptionAttributesModel genericOptionAttributesModel);
		GenericProduct.GenericProductBuilder addPaymentFrequency(GenericFrequency paymentFrequency0);
		GenericProduct.GenericProductBuilder addPaymentFrequency(GenericFrequency paymentFrequency1, int _idx);
		GenericProduct.GenericProductBuilder addPaymentFrequency(List<? extends GenericFrequency> paymentFrequency2);
		GenericProduct.GenericProductBuilder setPaymentFrequency(List<? extends GenericFrequency> paymentFrequency3);
		GenericProduct.GenericProductBuilder addResetFrequency(GenericResetFrequency resetFrequency0);
		GenericProduct.GenericProductBuilder addResetFrequency(GenericResetFrequency resetFrequency1, int _idx);
		GenericProduct.GenericProductBuilder addResetFrequency(List<? extends GenericResetFrequency> resetFrequency2);
		GenericProduct.GenericProductBuilder setResetFrequency(List<? extends GenericResetFrequency> resetFrequency3);
		GenericProduct.GenericProductBuilder addSettlementCurrency(IdentifiedCurrency settlementCurrency0);
		GenericProduct.GenericProductBuilder addSettlementCurrency(IdentifiedCurrency settlementCurrency1, int _idx);
		GenericProduct.GenericProductBuilder addSettlementCurrency(List<? extends IdentifiedCurrency> settlementCurrency2);
		GenericProduct.GenericProductBuilder setSettlementCurrency(List<? extends IdentifiedCurrency> settlementCurrency3);
		GenericProduct.GenericProductBuilder setSettlementType(SettlementTypeEnum settlementType);
		GenericProduct.GenericProductBuilder addAdditionalPayment(Payment additionalPayment0);
		GenericProduct.GenericProductBuilder addAdditionalPayment(Payment additionalPayment1, int _idx);
		GenericProduct.GenericProductBuilder addAdditionalPayment(List<? extends Payment> additionalPayment2);
		GenericProduct.GenericProductBuilder setAdditionalPayment(List<? extends Payment> additionalPayment3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("multiLeg"), Boolean.class, getMultiLeg(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("counterpartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getCounterpartyReference());
			processRosetta(path.newSubPath("premium"), processor, SimplePayment.SimplePaymentBuilder.class, getPremium());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableDate2.AdjustableDate2Builder.class, getEffectiveDate());
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableDate2.AdjustableDate2Builder.class, getExpirationDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableDate2.AdjustableDate2Builder.class, getTerminationDate());
			processRosetta(path.newSubPath("underlyer"), processor, TradeUnderlyer2.TradeUnderlyer2Builder.class, getUnderlyer());
			processRosetta(path.newSubPath("notional"), processor, CashflowNotional.CashflowNotionalBuilder.class, getNotional());
			processRosetta(path.newSubPath("genericCommodityAttributesModel"), processor, GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder.class, getGenericCommodityAttributesModel());
			processRosetta(path.newSubPath("genericEquityAttributesModel"), processor, GenericEquityAttributesModel.GenericEquityAttributesModelBuilder.class, getGenericEquityAttributesModel());
			processRosetta(path.newSubPath("genericOptionAttributesModel"), processor, GenericOptionAttributesModel.GenericOptionAttributesModelBuilder.class, getGenericOptionAttributesModel());
			processRosetta(path.newSubPath("paymentFrequency"), processor, GenericFrequency.GenericFrequencyBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("resetFrequency"), processor, GenericResetFrequency.GenericResetFrequencyBuilder.class, getResetFrequency());
			processRosetta(path.newSubPath("settlementCurrency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getSettlementCurrency());
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("additionalPayment"), processor, Payment.PaymentBuilder.class, getAdditionalPayment());
		}
		

		GenericProduct.GenericProductBuilder prune();
	}

	/*********************** Immutable Implementation of GenericProduct  ***********************/
	class GenericProductImpl extends Product.ProductImpl implements GenericProduct {
		private final Boolean multiLeg;
		private final BuyerSellerModel buyerSellerModel;
		private final List<? extends PartyReference> counterpartyReference;
		private final SimplePayment premium;
		private final AdjustableDate2 effectiveDate;
		private final AdjustableDate2 expirationDate;
		private final AdjustableDate2 terminationDate;
		private final List<? extends TradeUnderlyer2> underlyer;
		private final List<? extends CashflowNotional> notional;
		private final GenericCommodityAttributesModel genericCommodityAttributesModel;
		private final GenericEquityAttributesModel genericEquityAttributesModel;
		private final GenericOptionAttributesModel genericOptionAttributesModel;
		private final List<? extends GenericFrequency> paymentFrequency;
		private final List<? extends GenericResetFrequency> resetFrequency;
		private final List<? extends IdentifiedCurrency> settlementCurrency;
		private final SettlementTypeEnum settlementType;
		private final List<? extends Payment> additionalPayment;
		
		protected GenericProductImpl(GenericProduct.GenericProductBuilder builder) {
			super(builder);
			this.multiLeg = builder.getMultiLeg();
			this.buyerSellerModel = ofNullable(builder.getBuyerSellerModel()).map(f->f.build()).orElse(null);
			this.counterpartyReference = ofNullable(builder.getCounterpartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.premium = ofNullable(builder.getPremium()).map(f->f.build()).orElse(null);
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.expirationDate = ofNullable(builder.getExpirationDate()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
			this.underlyer = ofNullable(builder.getUnderlyer()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.notional = ofNullable(builder.getNotional()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.genericCommodityAttributesModel = ofNullable(builder.getGenericCommodityAttributesModel()).map(f->f.build()).orElse(null);
			this.genericEquityAttributesModel = ofNullable(builder.getGenericEquityAttributesModel()).map(f->f.build()).orElse(null);
			this.genericOptionAttributesModel = ofNullable(builder.getGenericOptionAttributesModel()).map(f->f.build()).orElse(null);
			this.paymentFrequency = ofNullable(builder.getPaymentFrequency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.resetFrequency = ofNullable(builder.getResetFrequency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementType = builder.getSettlementType();
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("multiLeg")
		public Boolean getMultiLeg() {
			return multiLeg;
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		@RosettaAttribute("counterpartyReference")
		public List<? extends PartyReference> getCounterpartyReference() {
			return counterpartyReference;
		}
		
		@Override
		@RosettaAttribute("premium")
		public SimplePayment getPremium() {
			return premium;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableDate2 getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		public AdjustableDate2 getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public AdjustableDate2 getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		public List<? extends TradeUnderlyer2> getUnderlyer() {
			return underlyer;
		}
		
		@Override
		@RosettaAttribute("notional")
		public List<? extends CashflowNotional> getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("genericCommodityAttributesModel")
		public GenericCommodityAttributesModel getGenericCommodityAttributesModel() {
			return genericCommodityAttributesModel;
		}
		
		@Override
		@RosettaAttribute("genericEquityAttributesModel")
		public GenericEquityAttributesModel getGenericEquityAttributesModel() {
			return genericEquityAttributesModel;
		}
		
		@Override
		@RosettaAttribute("genericOptionAttributesModel")
		public GenericOptionAttributesModel getGenericOptionAttributesModel() {
			return genericOptionAttributesModel;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		public List<? extends GenericFrequency> getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		@RosettaAttribute("resetFrequency")
		public List<? extends GenericResetFrequency> getResetFrequency() {
			return resetFrequency;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public List<? extends IdentifiedCurrency> getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public List<? extends Payment> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public GenericProduct build() {
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder toBuilder() {
			GenericProduct.GenericProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericProduct.GenericProductBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMultiLeg()).ifPresent(builder::setMultiLeg);
			ofNullable(getBuyerSellerModel()).ifPresent(builder::setBuyerSellerModel);
			ofNullable(getCounterpartyReference()).ifPresent(builder::setCounterpartyReference);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
			ofNullable(getUnderlyer()).ifPresent(builder::setUnderlyer);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getGenericCommodityAttributesModel()).ifPresent(builder::setGenericCommodityAttributesModel);
			ofNullable(getGenericEquityAttributesModel()).ifPresent(builder::setGenericEquityAttributesModel);
			ofNullable(getGenericOptionAttributesModel()).ifPresent(builder::setGenericOptionAttributesModel);
			ofNullable(getPaymentFrequency()).ifPresent(builder::setPaymentFrequency);
			ofNullable(getResetFrequency()).ifPresent(builder::setResetFrequency);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericProduct _that = getType().cast(o);
		
			if (!Objects.equals(multiLeg, _that.getMultiLeg())) return false;
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!ListEquals.listEquals(counterpartyReference, _that.getCounterpartyReference())) return false;
			if (!Objects.equals(premium, _that.getPremium())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!ListEquals.listEquals(underlyer, _that.getUnderlyer())) return false;
			if (!ListEquals.listEquals(notional, _that.getNotional())) return false;
			if (!Objects.equals(genericCommodityAttributesModel, _that.getGenericCommodityAttributesModel())) return false;
			if (!Objects.equals(genericEquityAttributesModel, _that.getGenericEquityAttributesModel())) return false;
			if (!Objects.equals(genericOptionAttributesModel, _that.getGenericOptionAttributesModel())) return false;
			if (!ListEquals.listEquals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!ListEquals.listEquals(resetFrequency, _that.getResetFrequency())) return false;
			if (!ListEquals.listEquals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multiLeg != null ? multiLeg.hashCode() : 0);
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (counterpartyReference != null ? counterpartyReference.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (genericCommodityAttributesModel != null ? genericCommodityAttributesModel.hashCode() : 0);
			_result = 31 * _result + (genericEquityAttributesModel != null ? genericEquityAttributesModel.hashCode() : 0);
			_result = 31 * _result + (genericOptionAttributesModel != null ? genericOptionAttributesModel.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (resetFrequency != null ? resetFrequency.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericProduct {" +
				"multiLeg=" + this.multiLeg + ", " +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"counterpartyReference=" + this.counterpartyReference + ", " +
				"premium=" + this.premium + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"underlyer=" + this.underlyer + ", " +
				"notional=" + this.notional + ", " +
				"genericCommodityAttributesModel=" + this.genericCommodityAttributesModel + ", " +
				"genericEquityAttributesModel=" + this.genericEquityAttributesModel + ", " +
				"genericOptionAttributesModel=" + this.genericOptionAttributesModel + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"resetFrequency=" + this.resetFrequency + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"settlementType=" + this.settlementType + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GenericProduct  ***********************/
	class GenericProductBuilderImpl extends Product.ProductBuilderImpl  implements GenericProduct.GenericProductBuilder {
	
		protected Boolean multiLeg;
		protected BuyerSellerModel.BuyerSellerModelBuilder buyerSellerModel;
		protected List<PartyReference.PartyReferenceBuilder> counterpartyReference = new ArrayList<>();
		protected SimplePayment.SimplePaymentBuilder premium;
		protected AdjustableDate2.AdjustableDate2Builder effectiveDate;
		protected AdjustableDate2.AdjustableDate2Builder expirationDate;
		protected AdjustableDate2.AdjustableDate2Builder terminationDate;
		protected List<TradeUnderlyer2.TradeUnderlyer2Builder> underlyer = new ArrayList<>();
		protected List<CashflowNotional.CashflowNotionalBuilder> notional = new ArrayList<>();
		protected GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder genericCommodityAttributesModel;
		protected GenericEquityAttributesModel.GenericEquityAttributesModelBuilder genericEquityAttributesModel;
		protected GenericOptionAttributesModel.GenericOptionAttributesModelBuilder genericOptionAttributesModel;
		protected List<GenericFrequency.GenericFrequencyBuilder> paymentFrequency = new ArrayList<>();
		protected List<GenericResetFrequency.GenericResetFrequencyBuilder> resetFrequency = new ArrayList<>();
		protected List<IdentifiedCurrency.IdentifiedCurrencyBuilder> settlementCurrency = new ArrayList<>();
		protected SettlementTypeEnum settlementType;
		protected List<Payment.PaymentBuilder> additionalPayment = new ArrayList<>();
	
		public GenericProductBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("multiLeg")
		public Boolean getMultiLeg() {
			return multiLeg;
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		public BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel() {
			BuyerSellerModel.BuyerSellerModelBuilder result;
			if (buyerSellerModel!=null) {
				result = buyerSellerModel;
			}
			else {
				result = buyerSellerModel = BuyerSellerModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("counterpartyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getCounterpartyReference() {
			return counterpartyReference;
		}
		
		public PartyReference.PartyReferenceBuilder getOrCreateCounterpartyReference(int _index) {
		
			if (counterpartyReference==null) {
				this.counterpartyReference = new ArrayList<>();
			}
			PartyReference.PartyReferenceBuilder result;
			return getIndex(counterpartyReference, _index, () -> {
						PartyReference.PartyReferenceBuilder newCounterpartyReference = PartyReference.builder();
						return newCounterpartyReference;
					});
		}
		
		@Override
		@RosettaAttribute("premium")
		public SimplePayment.SimplePaymentBuilder getPremium() {
			return premium;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder getOrCreatePremium() {
			SimplePayment.SimplePaymentBuilder result;
			if (premium!=null) {
				result = premium;
			}
			else {
				result = premium = SimplePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableDate2.AdjustableDate2Builder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableDate2.AdjustableDate2Builder getOrCreateEffectiveDate() {
			AdjustableDate2.AdjustableDate2Builder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableDate2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		public AdjustableDate2.AdjustableDate2Builder getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public AdjustableDate2.AdjustableDate2Builder getOrCreateExpirationDate() {
			AdjustableDate2.AdjustableDate2Builder result;
			if (expirationDate!=null) {
				result = expirationDate;
			}
			else {
				result = expirationDate = AdjustableDate2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public AdjustableDate2.AdjustableDate2Builder getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public AdjustableDate2.AdjustableDate2Builder getOrCreateTerminationDate() {
			AdjustableDate2.AdjustableDate2Builder result;
			if (terminationDate!=null) {
				result = terminationDate;
			}
			else {
				result = terminationDate = AdjustableDate2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		public List<? extends TradeUnderlyer2.TradeUnderlyer2Builder> getUnderlyer() {
			return underlyer;
		}
		
		public TradeUnderlyer2.TradeUnderlyer2Builder getOrCreateUnderlyer(int _index) {
		
			if (underlyer==null) {
				this.underlyer = new ArrayList<>();
			}
			TradeUnderlyer2.TradeUnderlyer2Builder result;
			return getIndex(underlyer, _index, () -> {
						TradeUnderlyer2.TradeUnderlyer2Builder newUnderlyer = TradeUnderlyer2.builder();
						return newUnderlyer;
					});
		}
		
		@Override
		@RosettaAttribute("notional")
		public List<? extends CashflowNotional.CashflowNotionalBuilder> getNotional() {
			return notional;
		}
		
		public CashflowNotional.CashflowNotionalBuilder getOrCreateNotional(int _index) {
		
			if (notional==null) {
				this.notional = new ArrayList<>();
			}
			CashflowNotional.CashflowNotionalBuilder result;
			return getIndex(notional, _index, () -> {
						CashflowNotional.CashflowNotionalBuilder newNotional = CashflowNotional.builder();
						return newNotional;
					});
		}
		
		@Override
		@RosettaAttribute("genericCommodityAttributesModel")
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder getGenericCommodityAttributesModel() {
			return genericCommodityAttributesModel;
		}
		
		@Override
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder getOrCreateGenericCommodityAttributesModel() {
			GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder result;
			if (genericCommodityAttributesModel!=null) {
				result = genericCommodityAttributesModel;
			}
			else {
				result = genericCommodityAttributesModel = GenericCommodityAttributesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("genericEquityAttributesModel")
		public GenericEquityAttributesModel.GenericEquityAttributesModelBuilder getGenericEquityAttributesModel() {
			return genericEquityAttributesModel;
		}
		
		@Override
		public GenericEquityAttributesModel.GenericEquityAttributesModelBuilder getOrCreateGenericEquityAttributesModel() {
			GenericEquityAttributesModel.GenericEquityAttributesModelBuilder result;
			if (genericEquityAttributesModel!=null) {
				result = genericEquityAttributesModel;
			}
			else {
				result = genericEquityAttributesModel = GenericEquityAttributesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("genericOptionAttributesModel")
		public GenericOptionAttributesModel.GenericOptionAttributesModelBuilder getGenericOptionAttributesModel() {
			return genericOptionAttributesModel;
		}
		
		@Override
		public GenericOptionAttributesModel.GenericOptionAttributesModelBuilder getOrCreateGenericOptionAttributesModel() {
			GenericOptionAttributesModel.GenericOptionAttributesModelBuilder result;
			if (genericOptionAttributesModel!=null) {
				result = genericOptionAttributesModel;
			}
			else {
				result = genericOptionAttributesModel = GenericOptionAttributesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		public List<? extends GenericFrequency.GenericFrequencyBuilder> getPaymentFrequency() {
			return paymentFrequency;
		}
		
		public GenericFrequency.GenericFrequencyBuilder getOrCreatePaymentFrequency(int _index) {
		
			if (paymentFrequency==null) {
				this.paymentFrequency = new ArrayList<>();
			}
			GenericFrequency.GenericFrequencyBuilder result;
			return getIndex(paymentFrequency, _index, () -> {
						GenericFrequency.GenericFrequencyBuilder newPaymentFrequency = GenericFrequency.builder();
						return newPaymentFrequency;
					});
		}
		
		@Override
		@RosettaAttribute("resetFrequency")
		public List<? extends GenericResetFrequency.GenericResetFrequencyBuilder> getResetFrequency() {
			return resetFrequency;
		}
		
		public GenericResetFrequency.GenericResetFrequencyBuilder getOrCreateResetFrequency(int _index) {
		
			if (resetFrequency==null) {
				this.resetFrequency = new ArrayList<>();
			}
			GenericResetFrequency.GenericResetFrequencyBuilder result;
			return getIndex(resetFrequency, _index, () -> {
						GenericResetFrequency.GenericResetFrequencyBuilder newResetFrequency = GenericResetFrequency.builder();
						return newResetFrequency;
					});
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public List<? extends IdentifiedCurrency.IdentifiedCurrencyBuilder> getSettlementCurrency() {
			return settlementCurrency;
		}
		
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateSettlementCurrency(int _index) {
		
			if (settlementCurrency==null) {
				this.settlementCurrency = new ArrayList<>();
			}
			IdentifiedCurrency.IdentifiedCurrencyBuilder result;
			return getIndex(settlementCurrency, _index, () -> {
						IdentifiedCurrency.IdentifiedCurrencyBuilder newSettlementCurrency = IdentifiedCurrency.builder();
						return newSettlementCurrency;
					});
		}
		
		@Override
		@RosettaAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public List<? extends Payment.PaymentBuilder> getAdditionalPayment() {
			return additionalPayment;
		}
		
		public Payment.PaymentBuilder getOrCreateAdditionalPayment(int _index) {
		
			if (additionalPayment==null) {
				this.additionalPayment = new ArrayList<>();
			}
			Payment.PaymentBuilder result;
			return getIndex(additionalPayment, _index, () -> {
						Payment.PaymentBuilder newAdditionalPayment = Payment.builder();
						return newAdditionalPayment;
					});
		}
		
		@Override
		@RosettaAttribute("productModel")
		public GenericProduct.GenericProductBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public GenericProduct.GenericProductBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("multiLeg")
		public GenericProduct.GenericProductBuilder setMultiLeg(Boolean multiLeg) {
			this.multiLeg = multiLeg==null?null:multiLeg;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public GenericProduct.GenericProductBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		public GenericProduct.GenericProductBuilder addCounterpartyReference(PartyReference counterpartyReference) {
			if (counterpartyReference!=null) this.counterpartyReference.add(counterpartyReference.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addCounterpartyReference(PartyReference counterpartyReference, int _idx) {
			getIndex(this.counterpartyReference, _idx, () -> counterpartyReference.toBuilder());
			return this;
		}
		@Override 
		public GenericProduct.GenericProductBuilder addCounterpartyReference(List<? extends PartyReference> counterpartyReferences) {
			if (counterpartyReferences != null) {
				for (PartyReference toAdd : counterpartyReferences) {
					this.counterpartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("counterpartyReference")
		public GenericProduct.GenericProductBuilder setCounterpartyReference(List<? extends PartyReference> counterpartyReferences) {
			if (counterpartyReferences == null)  {
				this.counterpartyReference = new ArrayList<>();
			}
			else {
				this.counterpartyReference = counterpartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("premium")
		public GenericProduct.GenericProductBuilder setPremium(SimplePayment premium) {
			this.premium = premium==null?null:premium.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public GenericProduct.GenericProductBuilder setEffectiveDate(AdjustableDate2 effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expirationDate")
		public GenericProduct.GenericProductBuilder setExpirationDate(AdjustableDate2 expirationDate) {
			this.expirationDate = expirationDate==null?null:expirationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public GenericProduct.GenericProductBuilder setTerminationDate(AdjustableDate2 terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		public GenericProduct.GenericProductBuilder addUnderlyer(TradeUnderlyer2 underlyer) {
			if (underlyer!=null) this.underlyer.add(underlyer.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addUnderlyer(TradeUnderlyer2 underlyer, int _idx) {
			getIndex(this.underlyer, _idx, () -> underlyer.toBuilder());
			return this;
		}
		@Override 
		public GenericProduct.GenericProductBuilder addUnderlyer(List<? extends TradeUnderlyer2> underlyers) {
			if (underlyers != null) {
				for (TradeUnderlyer2 toAdd : underlyers) {
					this.underlyer.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("underlyer")
		public GenericProduct.GenericProductBuilder setUnderlyer(List<? extends TradeUnderlyer2> underlyers) {
			if (underlyers == null)  {
				this.underlyer = new ArrayList<>();
			}
			else {
				this.underlyer = underlyers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addNotional(CashflowNotional notional) {
			if (notional!=null) this.notional.add(notional.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addNotional(CashflowNotional notional, int _idx) {
			getIndex(this.notional, _idx, () -> notional.toBuilder());
			return this;
		}
		@Override 
		public GenericProduct.GenericProductBuilder addNotional(List<? extends CashflowNotional> notionals) {
			if (notionals != null) {
				for (CashflowNotional toAdd : notionals) {
					this.notional.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("notional")
		public GenericProduct.GenericProductBuilder setNotional(List<? extends CashflowNotional> notionals) {
			if (notionals == null)  {
				this.notional = new ArrayList<>();
			}
			else {
				this.notional = notionals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("genericCommodityAttributesModel")
		public GenericProduct.GenericProductBuilder setGenericCommodityAttributesModel(GenericCommodityAttributesModel genericCommodityAttributesModel) {
			this.genericCommodityAttributesModel = genericCommodityAttributesModel==null?null:genericCommodityAttributesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("genericEquityAttributesModel")
		public GenericProduct.GenericProductBuilder setGenericEquityAttributesModel(GenericEquityAttributesModel genericEquityAttributesModel) {
			this.genericEquityAttributesModel = genericEquityAttributesModel==null?null:genericEquityAttributesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("genericOptionAttributesModel")
		public GenericProduct.GenericProductBuilder setGenericOptionAttributesModel(GenericOptionAttributesModel genericOptionAttributesModel) {
			this.genericOptionAttributesModel = genericOptionAttributesModel==null?null:genericOptionAttributesModel.toBuilder();
			return this;
		}
		@Override
		public GenericProduct.GenericProductBuilder addPaymentFrequency(GenericFrequency paymentFrequency) {
			if (paymentFrequency!=null) this.paymentFrequency.add(paymentFrequency.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addPaymentFrequency(GenericFrequency paymentFrequency, int _idx) {
			getIndex(this.paymentFrequency, _idx, () -> paymentFrequency.toBuilder());
			return this;
		}
		@Override 
		public GenericProduct.GenericProductBuilder addPaymentFrequency(List<? extends GenericFrequency> paymentFrequencys) {
			if (paymentFrequencys != null) {
				for (GenericFrequency toAdd : paymentFrequencys) {
					this.paymentFrequency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("paymentFrequency")
		public GenericProduct.GenericProductBuilder setPaymentFrequency(List<? extends GenericFrequency> paymentFrequencys) {
			if (paymentFrequencys == null)  {
				this.paymentFrequency = new ArrayList<>();
			}
			else {
				this.paymentFrequency = paymentFrequencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addResetFrequency(GenericResetFrequency resetFrequency) {
			if (resetFrequency!=null) this.resetFrequency.add(resetFrequency.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addResetFrequency(GenericResetFrequency resetFrequency, int _idx) {
			getIndex(this.resetFrequency, _idx, () -> resetFrequency.toBuilder());
			return this;
		}
		@Override 
		public GenericProduct.GenericProductBuilder addResetFrequency(List<? extends GenericResetFrequency> resetFrequencys) {
			if (resetFrequencys != null) {
				for (GenericResetFrequency toAdd : resetFrequencys) {
					this.resetFrequency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("resetFrequency")
		public GenericProduct.GenericProductBuilder setResetFrequency(List<? extends GenericResetFrequency> resetFrequencys) {
			if (resetFrequencys == null)  {
				this.resetFrequency = new ArrayList<>();
			}
			else {
				this.resetFrequency = resetFrequencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addSettlementCurrency(IdentifiedCurrency settlementCurrency) {
			if (settlementCurrency!=null) this.settlementCurrency.add(settlementCurrency.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addSettlementCurrency(IdentifiedCurrency settlementCurrency, int _idx) {
			getIndex(this.settlementCurrency, _idx, () -> settlementCurrency.toBuilder());
			return this;
		}
		@Override 
		public GenericProduct.GenericProductBuilder addSettlementCurrency(List<? extends IdentifiedCurrency> settlementCurrencys) {
			if (settlementCurrencys != null) {
				for (IdentifiedCurrency toAdd : settlementCurrencys) {
					this.settlementCurrency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlementCurrency")
		public GenericProduct.GenericProductBuilder setSettlementCurrency(List<? extends IdentifiedCurrency> settlementCurrencys) {
			if (settlementCurrencys == null)  {
				this.settlementCurrency = new ArrayList<>();
			}
			else {
				this.settlementCurrency = settlementCurrencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		public GenericProduct.GenericProductBuilder setSettlementType(SettlementTypeEnum settlementType) {
			this.settlementType = settlementType==null?null:settlementType;
			return this;
		}
		@Override
		public GenericProduct.GenericProductBuilder addAdditionalPayment(Payment additionalPayment) {
			if (additionalPayment!=null) this.additionalPayment.add(additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addAdditionalPayment(Payment additionalPayment, int _idx) {
			getIndex(this.additionalPayment, _idx, () -> additionalPayment.toBuilder());
			return this;
		}
		@Override 
		public GenericProduct.GenericProductBuilder addAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments != null) {
				for (Payment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("additionalPayment")
		public GenericProduct.GenericProductBuilder setAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments == null)  {
				this.additionalPayment = new ArrayList<>();
			}
			else {
				this.additionalPayment = additionalPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public GenericProduct build() {
			return new GenericProduct.GenericProductImpl(this);
		}
		
		@Override
		public GenericProduct.GenericProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericProduct.GenericProductBuilder prune() {
			super.prune();
			if (buyerSellerModel!=null && !buyerSellerModel.prune().hasData()) buyerSellerModel = null;
			counterpartyReference = counterpartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (premium!=null && !premium.prune().hasData()) premium = null;
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (expirationDate!=null && !expirationDate.prune().hasData()) expirationDate = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			underlyer = underlyer.stream().filter(b->b!=null).<TradeUnderlyer2.TradeUnderlyer2Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			notional = notional.stream().filter(b->b!=null).<CashflowNotional.CashflowNotionalBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (genericCommodityAttributesModel!=null && !genericCommodityAttributesModel.prune().hasData()) genericCommodityAttributesModel = null;
			if (genericEquityAttributesModel!=null && !genericEquityAttributesModel.prune().hasData()) genericEquityAttributesModel = null;
			if (genericOptionAttributesModel!=null && !genericOptionAttributesModel.prune().hasData()) genericOptionAttributesModel = null;
			paymentFrequency = paymentFrequency.stream().filter(b->b!=null).<GenericFrequency.GenericFrequencyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			resetFrequency = resetFrequency.stream().filter(b->b!=null).<GenericResetFrequency.GenericResetFrequencyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			settlementCurrency = settlementCurrency.stream().filter(b->b!=null).<IdentifiedCurrency.IdentifiedCurrencyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMultiLeg()!=null) return true;
			if (getBuyerSellerModel()!=null && getBuyerSellerModel().hasData()) return true;
			if (getCounterpartyReference()!=null && getCounterpartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPremium()!=null && getPremium().hasData()) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getExpirationDate()!=null && getExpirationDate().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			if (getUnderlyer()!=null && getUnderlyer().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNotional()!=null && getNotional().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getGenericCommodityAttributesModel()!=null && getGenericCommodityAttributesModel().hasData()) return true;
			if (getGenericEquityAttributesModel()!=null && getGenericEquityAttributesModel().hasData()) return true;
			if (getGenericOptionAttributesModel()!=null && getGenericOptionAttributesModel().hasData()) return true;
			if (getPaymentFrequency()!=null && getPaymentFrequency().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getResetFrequency()!=null && getResetFrequency().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementCurrency()!=null && getSettlementCurrency().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementType()!=null) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericProduct.GenericProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			GenericProduct.GenericProductBuilder o = (GenericProduct.GenericProductBuilder) other;
			
			merger.mergeRosetta(getBuyerSellerModel(), o.getBuyerSellerModel(), this::setBuyerSellerModel);
			merger.mergeRosetta(getCounterpartyReference(), o.getCounterpartyReference(), this::getOrCreateCounterpartyReference);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::setPremium);
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			merger.mergeRosetta(getUnderlyer(), o.getUnderlyer(), this::getOrCreateUnderlyer);
			merger.mergeRosetta(getNotional(), o.getNotional(), this::getOrCreateNotional);
			merger.mergeRosetta(getGenericCommodityAttributesModel(), o.getGenericCommodityAttributesModel(), this::setGenericCommodityAttributesModel);
			merger.mergeRosetta(getGenericEquityAttributesModel(), o.getGenericEquityAttributesModel(), this::setGenericEquityAttributesModel);
			merger.mergeRosetta(getGenericOptionAttributesModel(), o.getGenericOptionAttributesModel(), this::setGenericOptionAttributesModel);
			merger.mergeRosetta(getPaymentFrequency(), o.getPaymentFrequency(), this::getOrCreatePaymentFrequency);
			merger.mergeRosetta(getResetFrequency(), o.getResetFrequency(), this::getOrCreateResetFrequency);
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::getOrCreateSettlementCurrency);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			
			merger.mergeBasic(getMultiLeg(), o.getMultiLeg(), this::setMultiLeg);
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericProduct _that = getType().cast(o);
		
			if (!Objects.equals(multiLeg, _that.getMultiLeg())) return false;
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!ListEquals.listEquals(counterpartyReference, _that.getCounterpartyReference())) return false;
			if (!Objects.equals(premium, _that.getPremium())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!ListEquals.listEquals(underlyer, _that.getUnderlyer())) return false;
			if (!ListEquals.listEquals(notional, _that.getNotional())) return false;
			if (!Objects.equals(genericCommodityAttributesModel, _that.getGenericCommodityAttributesModel())) return false;
			if (!Objects.equals(genericEquityAttributesModel, _that.getGenericEquityAttributesModel())) return false;
			if (!Objects.equals(genericOptionAttributesModel, _that.getGenericOptionAttributesModel())) return false;
			if (!ListEquals.listEquals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!ListEquals.listEquals(resetFrequency, _that.getResetFrequency())) return false;
			if (!ListEquals.listEquals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multiLeg != null ? multiLeg.hashCode() : 0);
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (counterpartyReference != null ? counterpartyReference.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (genericCommodityAttributesModel != null ? genericCommodityAttributesModel.hashCode() : 0);
			_result = 31 * _result + (genericEquityAttributesModel != null ? genericEquityAttributesModel.hashCode() : 0);
			_result = 31 * _result + (genericOptionAttributesModel != null ? genericOptionAttributesModel.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (resetFrequency != null ? resetFrequency.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericProductBuilder {" +
				"multiLeg=" + this.multiLeg + ", " +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"counterpartyReference=" + this.counterpartyReference + ", " +
				"premium=" + this.premium + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"underlyer=" + this.underlyer + ", " +
				"notional=" + this.notional + ", " +
				"genericCommodityAttributesModel=" + this.genericCommodityAttributesModel + ", " +
				"genericEquityAttributesModel=" + this.genericEquityAttributesModel + ", " +
				"genericOptionAttributesModel=" + this.genericOptionAttributesModel + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"resetFrequency=" + this.resetFrequency + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"settlementType=" + this.settlementType + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}
}
