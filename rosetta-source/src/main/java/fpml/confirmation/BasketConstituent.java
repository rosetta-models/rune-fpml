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
import fpml.confirmation.Asset;
import fpml.confirmation.BasketConstituent;
import fpml.confirmation.BasketConstituent.BasketConstituentBuilder;
import fpml.confirmation.BasketConstituent.BasketConstituentBuilderImpl;
import fpml.confirmation.BasketConstituent.BasketConstituentImpl;
import fpml.confirmation.Collateral;
import fpml.confirmation.ConstituentWeight;
import fpml.confirmation.DividendPayout;
import fpml.confirmation.Money;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PendingPayment;
import fpml.confirmation.Price;
import fpml.confirmation.SpreadScheduleReference;
import fpml.confirmation.UnderlyerInterestLeg;
import fpml.confirmation.UnderlyerLoanRate;
import fpml.confirmation.meta.BasketConstituentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing each of the constituents of a basket.
 * @version ${project.version}
 */
@RosettaDataType(value="BasketConstituent", builder=BasketConstituent.BasketConstituentBuilderImpl.class, version="${project.version}")
public interface BasketConstituent extends RosettaModelObject {

	BasketConstituentMeta metaData = new BasketConstituentMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	Asset getUnderlyingAsset();
	/**
	 * Specifies the weight of each of the underlyer constituent within the basket, either in absolute or relative terms. This is an optional component, as certain swaps do not specify a specific weight for each of their basket constituents.
	 */
	ConstituentWeight getConstituentWeight();
	/**
	 * Specifies the dividend payout ratio associated with an equity underlyer. A basket swap can have different payout ratios across the various underlying constituents. In certain cases the actual ratio is not known on trade inception, and only general conditions are then specified. Users should note that FpML makes a distinction between the derivative contract and the underlyer of the contract. It would be better if the agreed dividend payout on a derivative contract was modelled at the level of the derivative contract, an approach which may be adopted in the next major version of FpML.
	 */
	DividendPayout getDividendPayout();
	/**
	 * Specifies the price that is associated with each of the basket constituents. This component is optional, as it is not absolutely required to accurately describe the economics of the trade, considering the price that characterizes the equity swap is associated to the leg of the trade.
	 */
	Price getUnderlyerPrice();
	/**
	 * Specifies the notional (i.e. price * quantity) that is associated with each of the basket constituents. This component is optional, as it is not absolutely required to accurately describe the economics of the trade, considering the notional that characterizes the equity swap is associated to the leg of the trade.
	 */
	Money getUnderlyerNotional();
	/**
	 * Provides a link to the spread schedule used for this underlyer.
	 */
	SpreadScheduleReference getUnderlyerSpread();
	/**
	 * The next upcoming coupon payment.
	 */
	PendingPayment getCouponPayment();
	/**
	 * Financing terms associated with this underlyer
	 */
	UnderlyerInterestLeg getUnderlyerFinancing();
	/**
	 * Loan rate terms associated with this underlyer. Commonly used for stock loan. You must not duplicate data elements already contained within dividend conditions at transaction level
	 */
	UnderlyerLoanRate getUnderlyerLoanRate();
	/**
	 * Collateral associated with this underlyer. Note that this is not typical usage, collateral is more often at transaction level
	 */
	Collateral getUnderlyerCollateral();
	String getId();

	/*********************** Build Methods  ***********************/
	BasketConstituent build();
	
	BasketConstituent.BasketConstituentBuilder toBuilder();
	
	static BasketConstituent.BasketConstituentBuilder builder() {
		return new BasketConstituent.BasketConstituentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasketConstituent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BasketConstituent> getType() {
		return BasketConstituent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.class, getUnderlyingAsset());
		processRosetta(path.newSubPath("constituentWeight"), processor, ConstituentWeight.class, getConstituentWeight());
		processRosetta(path.newSubPath("dividendPayout"), processor, DividendPayout.class, getDividendPayout());
		processRosetta(path.newSubPath("underlyerPrice"), processor, Price.class, getUnderlyerPrice());
		processRosetta(path.newSubPath("underlyerNotional"), processor, Money.class, getUnderlyerNotional());
		processRosetta(path.newSubPath("underlyerSpread"), processor, SpreadScheduleReference.class, getUnderlyerSpread());
		processRosetta(path.newSubPath("couponPayment"), processor, PendingPayment.class, getCouponPayment());
		processRosetta(path.newSubPath("underlyerFinancing"), processor, UnderlyerInterestLeg.class, getUnderlyerFinancing());
		processRosetta(path.newSubPath("underlyerLoanRate"), processor, UnderlyerLoanRate.class, getUnderlyerLoanRate());
		processRosetta(path.newSubPath("underlyerCollateral"), processor, Collateral.class, getUnderlyerCollateral());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketConstituentBuilder extends BasketConstituent, RosettaModelObjectBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		Asset.AssetBuilder getOrCreateUnderlyingAsset();
		Asset.AssetBuilder getUnderlyingAsset();
		ConstituentWeight.ConstituentWeightBuilder getOrCreateConstituentWeight();
		ConstituentWeight.ConstituentWeightBuilder getConstituentWeight();
		DividendPayout.DividendPayoutBuilder getOrCreateDividendPayout();
		DividendPayout.DividendPayoutBuilder getDividendPayout();
		Price.PriceBuilder getOrCreateUnderlyerPrice();
		Price.PriceBuilder getUnderlyerPrice();
		Money.MoneyBuilder getOrCreateUnderlyerNotional();
		Money.MoneyBuilder getUnderlyerNotional();
		SpreadScheduleReference.SpreadScheduleReferenceBuilder getOrCreateUnderlyerSpread();
		SpreadScheduleReference.SpreadScheduleReferenceBuilder getUnderlyerSpread();
		PendingPayment.PendingPaymentBuilder getOrCreateCouponPayment();
		PendingPayment.PendingPaymentBuilder getCouponPayment();
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder getOrCreateUnderlyerFinancing();
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder getUnderlyerFinancing();
		UnderlyerLoanRate.UnderlyerLoanRateBuilder getOrCreateUnderlyerLoanRate();
		UnderlyerLoanRate.UnderlyerLoanRateBuilder getUnderlyerLoanRate();
		Collateral.CollateralBuilder getOrCreateUnderlyerCollateral();
		Collateral.CollateralBuilder getUnderlyerCollateral();
		BasketConstituent.BasketConstituentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		BasketConstituent.BasketConstituentBuilder setUnderlyingAsset(Asset underlyingAsset);
		BasketConstituent.BasketConstituentBuilder setConstituentWeight(ConstituentWeight constituentWeight);
		BasketConstituent.BasketConstituentBuilder setDividendPayout(DividendPayout dividendPayout);
		BasketConstituent.BasketConstituentBuilder setUnderlyerPrice(Price underlyerPrice);
		BasketConstituent.BasketConstituentBuilder setUnderlyerNotional(Money underlyerNotional);
		BasketConstituent.BasketConstituentBuilder setUnderlyerSpread(SpreadScheduleReference underlyerSpread);
		BasketConstituent.BasketConstituentBuilder setCouponPayment(PendingPayment couponPayment);
		BasketConstituent.BasketConstituentBuilder setUnderlyerFinancing(UnderlyerInterestLeg underlyerFinancing);
		BasketConstituent.BasketConstituentBuilder setUnderlyerLoanRate(UnderlyerLoanRate underlyerLoanRate);
		BasketConstituent.BasketConstituentBuilder setUnderlyerCollateral(Collateral underlyerCollateral);
		BasketConstituent.BasketConstituentBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.AssetBuilder.class, getUnderlyingAsset());
			processRosetta(path.newSubPath("constituentWeight"), processor, ConstituentWeight.ConstituentWeightBuilder.class, getConstituentWeight());
			processRosetta(path.newSubPath("dividendPayout"), processor, DividendPayout.DividendPayoutBuilder.class, getDividendPayout());
			processRosetta(path.newSubPath("underlyerPrice"), processor, Price.PriceBuilder.class, getUnderlyerPrice());
			processRosetta(path.newSubPath("underlyerNotional"), processor, Money.MoneyBuilder.class, getUnderlyerNotional());
			processRosetta(path.newSubPath("underlyerSpread"), processor, SpreadScheduleReference.SpreadScheduleReferenceBuilder.class, getUnderlyerSpread());
			processRosetta(path.newSubPath("couponPayment"), processor, PendingPayment.PendingPaymentBuilder.class, getCouponPayment());
			processRosetta(path.newSubPath("underlyerFinancing"), processor, UnderlyerInterestLeg.UnderlyerInterestLegBuilder.class, getUnderlyerFinancing());
			processRosetta(path.newSubPath("underlyerLoanRate"), processor, UnderlyerLoanRate.UnderlyerLoanRateBuilder.class, getUnderlyerLoanRate());
			processRosetta(path.newSubPath("underlyerCollateral"), processor, Collateral.CollateralBuilder.class, getUnderlyerCollateral());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		BasketConstituent.BasketConstituentBuilder prune();
	}

	/*********************** Immutable Implementation of BasketConstituent  ***********************/
	class BasketConstituentImpl implements BasketConstituent {
		private final PayerReceiverModel payerReceiverModel;
		private final Asset underlyingAsset;
		private final ConstituentWeight constituentWeight;
		private final DividendPayout dividendPayout;
		private final Price underlyerPrice;
		private final Money underlyerNotional;
		private final SpreadScheduleReference underlyerSpread;
		private final PendingPayment couponPayment;
		private final UnderlyerInterestLeg underlyerFinancing;
		private final UnderlyerLoanRate underlyerLoanRate;
		private final Collateral underlyerCollateral;
		private final String id;
		
		protected BasketConstituentImpl(BasketConstituent.BasketConstituentBuilder builder) {
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.underlyingAsset = ofNullable(builder.getUnderlyingAsset()).map(f->f.build()).orElse(null);
			this.constituentWeight = ofNullable(builder.getConstituentWeight()).map(f->f.build()).orElse(null);
			this.dividendPayout = ofNullable(builder.getDividendPayout()).map(f->f.build()).orElse(null);
			this.underlyerPrice = ofNullable(builder.getUnderlyerPrice()).map(f->f.build()).orElse(null);
			this.underlyerNotional = ofNullable(builder.getUnderlyerNotional()).map(f->f.build()).orElse(null);
			this.underlyerSpread = ofNullable(builder.getUnderlyerSpread()).map(f->f.build()).orElse(null);
			this.couponPayment = ofNullable(builder.getCouponPayment()).map(f->f.build()).orElse(null);
			this.underlyerFinancing = ofNullable(builder.getUnderlyerFinancing()).map(f->f.build()).orElse(null);
			this.underlyerLoanRate = ofNullable(builder.getUnderlyerLoanRate()).map(f->f.build()).orElse(null);
			this.underlyerCollateral = ofNullable(builder.getUnderlyerCollateral()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		public Asset getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		@RosettaAttribute("constituentWeight")
		public ConstituentWeight getConstituentWeight() {
			return constituentWeight;
		}
		
		@Override
		@RosettaAttribute("dividendPayout")
		public DividendPayout getDividendPayout() {
			return dividendPayout;
		}
		
		@Override
		@RosettaAttribute("underlyerPrice")
		public Price getUnderlyerPrice() {
			return underlyerPrice;
		}
		
		@Override
		@RosettaAttribute("underlyerNotional")
		public Money getUnderlyerNotional() {
			return underlyerNotional;
		}
		
		@Override
		@RosettaAttribute("underlyerSpread")
		public SpreadScheduleReference getUnderlyerSpread() {
			return underlyerSpread;
		}
		
		@Override
		@RosettaAttribute("couponPayment")
		public PendingPayment getCouponPayment() {
			return couponPayment;
		}
		
		@Override
		@RosettaAttribute("underlyerFinancing")
		public UnderlyerInterestLeg getUnderlyerFinancing() {
			return underlyerFinancing;
		}
		
		@Override
		@RosettaAttribute("underlyerLoanRate")
		public UnderlyerLoanRate getUnderlyerLoanRate() {
			return underlyerLoanRate;
		}
		
		@Override
		@RosettaAttribute("underlyerCollateral")
		public Collateral getUnderlyerCollateral() {
			return underlyerCollateral;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public BasketConstituent build() {
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder toBuilder() {
			BasketConstituent.BasketConstituentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketConstituent.BasketConstituentBuilder builder) {
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getUnderlyingAsset()).ifPresent(builder::setUnderlyingAsset);
			ofNullable(getConstituentWeight()).ifPresent(builder::setConstituentWeight);
			ofNullable(getDividendPayout()).ifPresent(builder::setDividendPayout);
			ofNullable(getUnderlyerPrice()).ifPresent(builder::setUnderlyerPrice);
			ofNullable(getUnderlyerNotional()).ifPresent(builder::setUnderlyerNotional);
			ofNullable(getUnderlyerSpread()).ifPresent(builder::setUnderlyerSpread);
			ofNullable(getCouponPayment()).ifPresent(builder::setCouponPayment);
			ofNullable(getUnderlyerFinancing()).ifPresent(builder::setUnderlyerFinancing);
			ofNullable(getUnderlyerLoanRate()).ifPresent(builder::setUnderlyerLoanRate);
			ofNullable(getUnderlyerCollateral()).ifPresent(builder::setUnderlyerCollateral);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketConstituent _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(constituentWeight, _that.getConstituentWeight())) return false;
			if (!Objects.equals(dividendPayout, _that.getDividendPayout())) return false;
			if (!Objects.equals(underlyerPrice, _that.getUnderlyerPrice())) return false;
			if (!Objects.equals(underlyerNotional, _that.getUnderlyerNotional())) return false;
			if (!Objects.equals(underlyerSpread, _that.getUnderlyerSpread())) return false;
			if (!Objects.equals(couponPayment, _that.getCouponPayment())) return false;
			if (!Objects.equals(underlyerFinancing, _that.getUnderlyerFinancing())) return false;
			if (!Objects.equals(underlyerLoanRate, _that.getUnderlyerLoanRate())) return false;
			if (!Objects.equals(underlyerCollateral, _that.getUnderlyerCollateral())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (constituentWeight != null ? constituentWeight.hashCode() : 0);
			_result = 31 * _result + (dividendPayout != null ? dividendPayout.hashCode() : 0);
			_result = 31 * _result + (underlyerPrice != null ? underlyerPrice.hashCode() : 0);
			_result = 31 * _result + (underlyerNotional != null ? underlyerNotional.hashCode() : 0);
			_result = 31 * _result + (underlyerSpread != null ? underlyerSpread.hashCode() : 0);
			_result = 31 * _result + (couponPayment != null ? couponPayment.hashCode() : 0);
			_result = 31 * _result + (underlyerFinancing != null ? underlyerFinancing.hashCode() : 0);
			_result = 31 * _result + (underlyerLoanRate != null ? underlyerLoanRate.hashCode() : 0);
			_result = 31 * _result + (underlyerCollateral != null ? underlyerCollateral.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketConstituent {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"constituentWeight=" + this.constituentWeight + ", " +
				"dividendPayout=" + this.dividendPayout + ", " +
				"underlyerPrice=" + this.underlyerPrice + ", " +
				"underlyerNotional=" + this.underlyerNotional + ", " +
				"underlyerSpread=" + this.underlyerSpread + ", " +
				"couponPayment=" + this.couponPayment + ", " +
				"underlyerFinancing=" + this.underlyerFinancing + ", " +
				"underlyerLoanRate=" + this.underlyerLoanRate + ", " +
				"underlyerCollateral=" + this.underlyerCollateral + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of BasketConstituent  ***********************/
	class BasketConstituentBuilderImpl implements BasketConstituent.BasketConstituentBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected Asset.AssetBuilder underlyingAsset;
		protected ConstituentWeight.ConstituentWeightBuilder constituentWeight;
		protected DividendPayout.DividendPayoutBuilder dividendPayout;
		protected Price.PriceBuilder underlyerPrice;
		protected Money.MoneyBuilder underlyerNotional;
		protected SpreadScheduleReference.SpreadScheduleReferenceBuilder underlyerSpread;
		protected PendingPayment.PendingPaymentBuilder couponPayment;
		protected UnderlyerInterestLeg.UnderlyerInterestLegBuilder underlyerFinancing;
		protected UnderlyerLoanRate.UnderlyerLoanRateBuilder underlyerLoanRate;
		protected Collateral.CollateralBuilder underlyerCollateral;
		protected String id;
	
		public BasketConstituentBuilderImpl() {
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
		@RosettaAttribute("underlyingAsset")
		public Asset.AssetBuilder getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		public Asset.AssetBuilder getOrCreateUnderlyingAsset() {
			Asset.AssetBuilder result;
			if (underlyingAsset!=null) {
				result = underlyingAsset;
			}
			else {
				result = underlyingAsset = Asset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("constituentWeight")
		public ConstituentWeight.ConstituentWeightBuilder getConstituentWeight() {
			return constituentWeight;
		}
		
		@Override
		public ConstituentWeight.ConstituentWeightBuilder getOrCreateConstituentWeight() {
			ConstituentWeight.ConstituentWeightBuilder result;
			if (constituentWeight!=null) {
				result = constituentWeight;
			}
			else {
				result = constituentWeight = ConstituentWeight.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dividendPayout")
		public DividendPayout.DividendPayoutBuilder getDividendPayout() {
			return dividendPayout;
		}
		
		@Override
		public DividendPayout.DividendPayoutBuilder getOrCreateDividendPayout() {
			DividendPayout.DividendPayoutBuilder result;
			if (dividendPayout!=null) {
				result = dividendPayout;
			}
			else {
				result = dividendPayout = DividendPayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyerPrice")
		public Price.PriceBuilder getUnderlyerPrice() {
			return underlyerPrice;
		}
		
		@Override
		public Price.PriceBuilder getOrCreateUnderlyerPrice() {
			Price.PriceBuilder result;
			if (underlyerPrice!=null) {
				result = underlyerPrice;
			}
			else {
				result = underlyerPrice = Price.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyerNotional")
		public Money.MoneyBuilder getUnderlyerNotional() {
			return underlyerNotional;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateUnderlyerNotional() {
			Money.MoneyBuilder result;
			if (underlyerNotional!=null) {
				result = underlyerNotional;
			}
			else {
				result = underlyerNotional = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyerSpread")
		public SpreadScheduleReference.SpreadScheduleReferenceBuilder getUnderlyerSpread() {
			return underlyerSpread;
		}
		
		@Override
		public SpreadScheduleReference.SpreadScheduleReferenceBuilder getOrCreateUnderlyerSpread() {
			SpreadScheduleReference.SpreadScheduleReferenceBuilder result;
			if (underlyerSpread!=null) {
				result = underlyerSpread;
			}
			else {
				result = underlyerSpread = SpreadScheduleReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("couponPayment")
		public PendingPayment.PendingPaymentBuilder getCouponPayment() {
			return couponPayment;
		}
		
		@Override
		public PendingPayment.PendingPaymentBuilder getOrCreateCouponPayment() {
			PendingPayment.PendingPaymentBuilder result;
			if (couponPayment!=null) {
				result = couponPayment;
			}
			else {
				result = couponPayment = PendingPayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyerFinancing")
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder getUnderlyerFinancing() {
			return underlyerFinancing;
		}
		
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder getOrCreateUnderlyerFinancing() {
			UnderlyerInterestLeg.UnderlyerInterestLegBuilder result;
			if (underlyerFinancing!=null) {
				result = underlyerFinancing;
			}
			else {
				result = underlyerFinancing = UnderlyerInterestLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyerLoanRate")
		public UnderlyerLoanRate.UnderlyerLoanRateBuilder getUnderlyerLoanRate() {
			return underlyerLoanRate;
		}
		
		@Override
		public UnderlyerLoanRate.UnderlyerLoanRateBuilder getOrCreateUnderlyerLoanRate() {
			UnderlyerLoanRate.UnderlyerLoanRateBuilder result;
			if (underlyerLoanRate!=null) {
				result = underlyerLoanRate;
			}
			else {
				result = underlyerLoanRate = UnderlyerLoanRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyerCollateral")
		public Collateral.CollateralBuilder getUnderlyerCollateral() {
			return underlyerCollateral;
		}
		
		@Override
		public Collateral.CollateralBuilder getOrCreateUnderlyerCollateral() {
			Collateral.CollateralBuilder result;
			if (underlyerCollateral!=null) {
				result = underlyerCollateral;
			}
			else {
				result = underlyerCollateral = Collateral.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public BasketConstituent.BasketConstituentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyingAsset")
		public BasketConstituent.BasketConstituentBuilder setUnderlyingAsset(Asset underlyingAsset) {
			this.underlyingAsset = underlyingAsset==null?null:underlyingAsset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("constituentWeight")
		public BasketConstituent.BasketConstituentBuilder setConstituentWeight(ConstituentWeight constituentWeight) {
			this.constituentWeight = constituentWeight==null?null:constituentWeight.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dividendPayout")
		public BasketConstituent.BasketConstituentBuilder setDividendPayout(DividendPayout dividendPayout) {
			this.dividendPayout = dividendPayout==null?null:dividendPayout.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyerPrice")
		public BasketConstituent.BasketConstituentBuilder setUnderlyerPrice(Price underlyerPrice) {
			this.underlyerPrice = underlyerPrice==null?null:underlyerPrice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyerNotional")
		public BasketConstituent.BasketConstituentBuilder setUnderlyerNotional(Money underlyerNotional) {
			this.underlyerNotional = underlyerNotional==null?null:underlyerNotional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyerSpread")
		public BasketConstituent.BasketConstituentBuilder setUnderlyerSpread(SpreadScheduleReference underlyerSpread) {
			this.underlyerSpread = underlyerSpread==null?null:underlyerSpread.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("couponPayment")
		public BasketConstituent.BasketConstituentBuilder setCouponPayment(PendingPayment couponPayment) {
			this.couponPayment = couponPayment==null?null:couponPayment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyerFinancing")
		public BasketConstituent.BasketConstituentBuilder setUnderlyerFinancing(UnderlyerInterestLeg underlyerFinancing) {
			this.underlyerFinancing = underlyerFinancing==null?null:underlyerFinancing.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyerLoanRate")
		public BasketConstituent.BasketConstituentBuilder setUnderlyerLoanRate(UnderlyerLoanRate underlyerLoanRate) {
			this.underlyerLoanRate = underlyerLoanRate==null?null:underlyerLoanRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyerCollateral")
		public BasketConstituent.BasketConstituentBuilder setUnderlyerCollateral(Collateral underlyerCollateral) {
			this.underlyerCollateral = underlyerCollateral==null?null:underlyerCollateral.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public BasketConstituent.BasketConstituentBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public BasketConstituent build() {
			return new BasketConstituent.BasketConstituentImpl(this);
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketConstituent.BasketConstituentBuilder prune() {
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (underlyingAsset!=null && !underlyingAsset.prune().hasData()) underlyingAsset = null;
			if (constituentWeight!=null && !constituentWeight.prune().hasData()) constituentWeight = null;
			if (dividendPayout!=null && !dividendPayout.prune().hasData()) dividendPayout = null;
			if (underlyerPrice!=null && !underlyerPrice.prune().hasData()) underlyerPrice = null;
			if (underlyerNotional!=null && !underlyerNotional.prune().hasData()) underlyerNotional = null;
			if (underlyerSpread!=null && !underlyerSpread.prune().hasData()) underlyerSpread = null;
			if (couponPayment!=null && !couponPayment.prune().hasData()) couponPayment = null;
			if (underlyerFinancing!=null && !underlyerFinancing.prune().hasData()) underlyerFinancing = null;
			if (underlyerLoanRate!=null && !underlyerLoanRate.prune().hasData()) underlyerLoanRate = null;
			if (underlyerCollateral!=null && !underlyerCollateral.prune().hasData()) underlyerCollateral = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getUnderlyingAsset()!=null && getUnderlyingAsset().hasData()) return true;
			if (getConstituentWeight()!=null && getConstituentWeight().hasData()) return true;
			if (getDividendPayout()!=null && getDividendPayout().hasData()) return true;
			if (getUnderlyerPrice()!=null && getUnderlyerPrice().hasData()) return true;
			if (getUnderlyerNotional()!=null && getUnderlyerNotional().hasData()) return true;
			if (getUnderlyerSpread()!=null && getUnderlyerSpread().hasData()) return true;
			if (getCouponPayment()!=null && getCouponPayment().hasData()) return true;
			if (getUnderlyerFinancing()!=null && getUnderlyerFinancing().hasData()) return true;
			if (getUnderlyerLoanRate()!=null && getUnderlyerLoanRate().hasData()) return true;
			if (getUnderlyerCollateral()!=null && getUnderlyerCollateral().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketConstituent.BasketConstituentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasketConstituent.BasketConstituentBuilder o = (BasketConstituent.BasketConstituentBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getUnderlyingAsset(), o.getUnderlyingAsset(), this::setUnderlyingAsset);
			merger.mergeRosetta(getConstituentWeight(), o.getConstituentWeight(), this::setConstituentWeight);
			merger.mergeRosetta(getDividendPayout(), o.getDividendPayout(), this::setDividendPayout);
			merger.mergeRosetta(getUnderlyerPrice(), o.getUnderlyerPrice(), this::setUnderlyerPrice);
			merger.mergeRosetta(getUnderlyerNotional(), o.getUnderlyerNotional(), this::setUnderlyerNotional);
			merger.mergeRosetta(getUnderlyerSpread(), o.getUnderlyerSpread(), this::setUnderlyerSpread);
			merger.mergeRosetta(getCouponPayment(), o.getCouponPayment(), this::setCouponPayment);
			merger.mergeRosetta(getUnderlyerFinancing(), o.getUnderlyerFinancing(), this::setUnderlyerFinancing);
			merger.mergeRosetta(getUnderlyerLoanRate(), o.getUnderlyerLoanRate(), this::setUnderlyerLoanRate);
			merger.mergeRosetta(getUnderlyerCollateral(), o.getUnderlyerCollateral(), this::setUnderlyerCollateral);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketConstituent _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(constituentWeight, _that.getConstituentWeight())) return false;
			if (!Objects.equals(dividendPayout, _that.getDividendPayout())) return false;
			if (!Objects.equals(underlyerPrice, _that.getUnderlyerPrice())) return false;
			if (!Objects.equals(underlyerNotional, _that.getUnderlyerNotional())) return false;
			if (!Objects.equals(underlyerSpread, _that.getUnderlyerSpread())) return false;
			if (!Objects.equals(couponPayment, _that.getCouponPayment())) return false;
			if (!Objects.equals(underlyerFinancing, _that.getUnderlyerFinancing())) return false;
			if (!Objects.equals(underlyerLoanRate, _that.getUnderlyerLoanRate())) return false;
			if (!Objects.equals(underlyerCollateral, _that.getUnderlyerCollateral())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (constituentWeight != null ? constituentWeight.hashCode() : 0);
			_result = 31 * _result + (dividendPayout != null ? dividendPayout.hashCode() : 0);
			_result = 31 * _result + (underlyerPrice != null ? underlyerPrice.hashCode() : 0);
			_result = 31 * _result + (underlyerNotional != null ? underlyerNotional.hashCode() : 0);
			_result = 31 * _result + (underlyerSpread != null ? underlyerSpread.hashCode() : 0);
			_result = 31 * _result + (couponPayment != null ? couponPayment.hashCode() : 0);
			_result = 31 * _result + (underlyerFinancing != null ? underlyerFinancing.hashCode() : 0);
			_result = 31 * _result + (underlyerLoanRate != null ? underlyerLoanRate.hashCode() : 0);
			_result = 31 * _result + (underlyerCollateral != null ? underlyerCollateral.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketConstituentBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"constituentWeight=" + this.constituentWeight + ", " +
				"dividendPayout=" + this.dividendPayout + ", " +
				"underlyerPrice=" + this.underlyerPrice + ", " +
				"underlyerNotional=" + this.underlyerNotional + ", " +
				"underlyerSpread=" + this.underlyerSpread + ", " +
				"couponPayment=" + this.couponPayment + ", " +
				"underlyerFinancing=" + this.underlyerFinancing + ", " +
				"underlyerLoanRate=" + this.underlyerLoanRate + ", " +
				"underlyerCollateral=" + this.underlyerCollateral + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
