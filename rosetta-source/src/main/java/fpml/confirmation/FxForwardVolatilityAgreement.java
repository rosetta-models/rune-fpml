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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.FxForwardVolatilityAgreement;
import fpml.confirmation.FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder;
import fpml.confirmation.FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilderImpl;
import fpml.confirmation.FxForwardVolatilityAgreement.FxForwardVolatilityAgreementImpl;
import fpml.confirmation.FxStraddle;
import fpml.confirmation.Payment;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.meta.FxForwardVolatilityAgreementMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An FX Forward Volatility Agreement transaction definition. Describes a contract on future levels of implied volatility. The main characteristic of this product is that the underlying is a straddle (underlying options) with a specific tenor starting from the fixing (effective or pricing) date, and are priced on that fixing date using a level of volatility that is agreed at the time of execution of the volatility agreement.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxForwardVolatilityAgreement", builder=FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxForwardVolatilityAgreement extends Product {

	FxForwardVolatilityAgreementMeta metaData = new FxForwardVolatilityAgreementMeta();

	/*********************** Getter Methods  ***********************/
	BuyerSellerModel getBuyerSellerModel();
	/**
	 * A currency Pair the straddle is based on.
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 * The date when the underlying options are priced using the agreed forwardVolatilityStrikePrice and other market factors as agreed by the parties. Also known as &quot;Effective Date&quot; or &quot;Reference Date&quot;.
	 */
	Date getFixingDate();
	/**
	 * The time of the fixing date when the underlying options are priced using the agreed forwardVolatilityStrikePrice and other market factors as agreed by the parties.
	 */
	BusinessCenterTime getFixingTime();
	/**
	 * the Volatility level as agreed on the Trade Date.
	 */
	BigDecimal getForwardVolatilityStrikePrice();
	/**
	 * details of the straddle (underlying options).
	 */
	FxStraddle getStraddle();
	/**
	 * The currency, amount and payment details for the Forward Volatility Agreement, as agreed at the time of execution.
	 */
	List<? extends Payment> getAdditionalPayment();

	/*********************** Build Methods  ***********************/
	FxForwardVolatilityAgreement build();
	
	FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder toBuilder();
	
	static FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder builder() {
		return new FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxForwardVolatilityAgreement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxForwardVolatilityAgreement> getType() {
		return FxForwardVolatilityAgreement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
		processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.class, getFixingTime());
		processor.processBasic(path.newSubPath("forwardVolatilityStrikePrice"), BigDecimal.class, getForwardVolatilityStrikePrice(), this);
		processRosetta(path.newSubPath("straddle"), processor, FxStraddle.class, getStraddle());
		processRosetta(path.newSubPath("additionalPayment"), processor, Payment.class, getAdditionalPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxForwardVolatilityAgreementBuilder extends FxForwardVolatilityAgreement, Product.ProductBuilder {
		BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel();
		BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime();
		FxStraddle.FxStraddleBuilder getOrCreateStraddle();
		FxStraddle.FxStraddleBuilder getStraddle();
		Payment.PaymentBuilder getOrCreateAdditionalPayment(int _index);
		List<? extends Payment.PaymentBuilder> getAdditionalPayment();
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setProductModel(ProductModel productModel);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setId(String id);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setFixingDate(Date fixingDate);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setFixingTime(BusinessCenterTime fixingTime);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setForwardVolatilityStrikePrice(BigDecimal forwardVolatilityStrikePrice);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setStraddle(FxStraddle straddle);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAdditionalPayment(Payment additionalPayment0);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAdditionalPayment(Payment additionalPayment1, int _idx);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAdditionalPayment(List<? extends Payment> additionalPayment2);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setAdditionalPayment(List<? extends Payment> additionalPayment3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
			processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getFixingTime());
			processor.processBasic(path.newSubPath("forwardVolatilityStrikePrice"), BigDecimal.class, getForwardVolatilityStrikePrice(), this);
			processRosetta(path.newSubPath("straddle"), processor, FxStraddle.FxStraddleBuilder.class, getStraddle());
			processRosetta(path.newSubPath("additionalPayment"), processor, Payment.PaymentBuilder.class, getAdditionalPayment());
		}
		

		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder prune();
	}

	/*********************** Immutable Implementation of FxForwardVolatilityAgreement  ***********************/
	class FxForwardVolatilityAgreementImpl extends Product.ProductImpl implements FxForwardVolatilityAgreement {
		private final BuyerSellerModel buyerSellerModel;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final Date fixingDate;
		private final BusinessCenterTime fixingTime;
		private final BigDecimal forwardVolatilityStrikePrice;
		private final FxStraddle straddle;
		private final List<? extends Payment> additionalPayment;
		
		protected FxForwardVolatilityAgreementImpl(FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder builder) {
			super(builder);
			this.buyerSellerModel = ofNullable(builder.getBuyerSellerModel()).map(f->f.build()).orElse(null);
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.fixingDate = builder.getFixingDate();
			this.fixingTime = ofNullable(builder.getFixingTime()).map(f->f.build()).orElse(null);
			this.forwardVolatilityStrikePrice = builder.getForwardVolatilityStrikePrice();
			this.straddle = ofNullable(builder.getStraddle()).map(f->f.build()).orElse(null);
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		public Date getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		public BusinessCenterTime getFixingTime() {
			return fixingTime;
		}
		
		@Override
		@RosettaAttribute("forwardVolatilityStrikePrice")
		public BigDecimal getForwardVolatilityStrikePrice() {
			return forwardVolatilityStrikePrice;
		}
		
		@Override
		@RosettaAttribute("straddle")
		public FxStraddle getStraddle() {
			return straddle;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public List<? extends Payment> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public FxForwardVolatilityAgreement build() {
			return this;
		}
		
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder toBuilder() {
			FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerSellerModel()).ifPresent(builder::setBuyerSellerModel);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getFixingDate()).ifPresent(builder::setFixingDate);
			ofNullable(getFixingTime()).ifPresent(builder::setFixingTime);
			ofNullable(getForwardVolatilityStrikePrice()).ifPresent(builder::setForwardVolatilityStrikePrice);
			ofNullable(getStraddle()).ifPresent(builder::setStraddle);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxForwardVolatilityAgreement _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(forwardVolatilityStrikePrice, _that.getForwardVolatilityStrikePrice())) return false;
			if (!Objects.equals(straddle, _that.getStraddle())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (forwardVolatilityStrikePrice != null ? forwardVolatilityStrikePrice.hashCode() : 0);
			_result = 31 * _result + (straddle != null ? straddle.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxForwardVolatilityAgreement {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"fixingDate=" + this.fixingDate + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"forwardVolatilityStrikePrice=" + this.forwardVolatilityStrikePrice + ", " +
				"straddle=" + this.straddle + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxForwardVolatilityAgreement  ***********************/
	class FxForwardVolatilityAgreementBuilderImpl extends Product.ProductBuilderImpl  implements FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder {
	
		protected BuyerSellerModel.BuyerSellerModelBuilder buyerSellerModel;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected Date fixingDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder fixingTime;
		protected BigDecimal forwardVolatilityStrikePrice;
		protected FxStraddle.FxStraddleBuilder straddle;
		protected List<Payment.PaymentBuilder> additionalPayment = new ArrayList<>();
	
		public FxForwardVolatilityAgreementBuilderImpl() {
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
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		public Date getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (fixingTime!=null) {
				result = fixingTime;
			}
			else {
				result = fixingTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("forwardVolatilityStrikePrice")
		public BigDecimal getForwardVolatilityStrikePrice() {
			return forwardVolatilityStrikePrice;
		}
		
		@Override
		@RosettaAttribute("straddle")
		public FxStraddle.FxStraddleBuilder getStraddle() {
			return straddle;
		}
		
		@Override
		public FxStraddle.FxStraddleBuilder getOrCreateStraddle() {
			FxStraddle.FxStraddleBuilder result;
			if (straddle!=null) {
				result = straddle;
			}
			else {
				result = straddle = FxStraddle.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public List<? extends Payment.PaymentBuilder> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
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
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingDate")
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setFixingDate(Date fixingDate) {
			this.fixingDate = fixingDate==null?null:fixingDate;
			return this;
		}
		@Override
		@RosettaAttribute("fixingTime")
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setFixingTime(BusinessCenterTime fixingTime) {
			this.fixingTime = fixingTime==null?null:fixingTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("forwardVolatilityStrikePrice")
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setForwardVolatilityStrikePrice(BigDecimal forwardVolatilityStrikePrice) {
			this.forwardVolatilityStrikePrice = forwardVolatilityStrikePrice==null?null:forwardVolatilityStrikePrice;
			return this;
		}
		@Override
		@RosettaAttribute("straddle")
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setStraddle(FxStraddle straddle) {
			this.straddle = straddle==null?null:straddle.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("additionalPayment")
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAdditionalPayment(Payment additionalPayment) {
			if (additionalPayment!=null) this.additionalPayment.add(additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAdditionalPayment(Payment additionalPayment, int _idx) {
			getIndex(this.additionalPayment, _idx, () -> additionalPayment.toBuilder());
			return this;
		}
		@Override 
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments != null) {
				for (Payment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setAdditionalPayment(List<? extends Payment> additionalPayments) {
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
		public FxForwardVolatilityAgreement build() {
			return new FxForwardVolatilityAgreement.FxForwardVolatilityAgreementImpl(this);
		}
		
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder prune() {
			super.prune();
			if (buyerSellerModel!=null && !buyerSellerModel.prune().hasData()) buyerSellerModel = null;
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (fixingTime!=null && !fixingTime.prune().hasData()) fixingTime = null;
			if (straddle!=null && !straddle.prune().hasData()) straddle = null;
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerSellerModel()!=null && getBuyerSellerModel().hasData()) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getFixingDate()!=null) return true;
			if (getFixingTime()!=null && getFixingTime().hasData()) return true;
			if (getForwardVolatilityStrikePrice()!=null) return true;
			if (getStraddle()!=null && getStraddle().hasData()) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder o = (FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder) other;
			
			merger.mergeRosetta(getBuyerSellerModel(), o.getBuyerSellerModel(), this::setBuyerSellerModel);
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getFixingTime(), o.getFixingTime(), this::setFixingTime);
			merger.mergeRosetta(getStraddle(), o.getStraddle(), this::setStraddle);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			
			merger.mergeBasic(getFixingDate(), o.getFixingDate(), this::setFixingDate);
			merger.mergeBasic(getForwardVolatilityStrikePrice(), o.getForwardVolatilityStrikePrice(), this::setForwardVolatilityStrikePrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxForwardVolatilityAgreement _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(forwardVolatilityStrikePrice, _that.getForwardVolatilityStrikePrice())) return false;
			if (!Objects.equals(straddle, _that.getStraddle())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (forwardVolatilityStrikePrice != null ? forwardVolatilityStrikePrice.hashCode() : 0);
			_result = 31 * _result + (straddle != null ? straddle.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxForwardVolatilityAgreementBuilder {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"fixingDate=" + this.fixingDate + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"forwardVolatilityStrikePrice=" + this.forwardVolatilityStrikePrice + ", " +
				"straddle=" + this.straddle + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}
}
