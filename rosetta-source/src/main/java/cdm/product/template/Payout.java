package cdm.product.template;

import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.Cashflow;
import cdm.product.template.AssetPayout;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Payout.PayoutBuilder;
import cdm.product.template.Payout.PayoutBuilderImpl;
import cdm.product.template.Payout.PayoutImpl;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.meta.PayoutMeta;
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
 * Represents the set of future cashflow methodologies in the form of specific payout data type(s) which result from the financial product.  Examples: a trade in a cash asset will use only a settlement payout; for derivatives, two interest rate payouts can be combined to specify an interest rate swap; one interest rate payout can be combined with a credit default payout to specify a credit default swap.
 * @version 6.0.0-dev.76
 */
@RosettaDataType(value="Payout", builder=Payout.PayoutBuilderImpl.class, version="6.0.0-dev.76")
public interface Payout extends RosettaModelObject, GlobalKey {

	PayoutMeta metaData = new PayoutMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * All of the terms necessary to define and calculate a cash flow based on a fixed, a floating or an inflation index rate. The interest rate payout can be applied to interest rate swaps and FRA (which both have two associated interest rate payouts), credit default swaps (to represent the fee leg when subject to periodic payments) and equity swaps (to represent the funding leg).
	 */
	List<? extends InterestRatePayout> getInterestRatePayout();
	/**
	 * The credit default payout, which provides the details necessary for determining when a credit payout will be triggered as well as the parameters for calculating the payout and the settlement terms.
	 */
	CreditDefaultPayout getCreditDefaultPayout();
	/**
	 * The option payout.
	 */
	List<? extends OptionPayout> getOptionPayout();
	/**
	 * Defines the payout for the floating leg of a Commodity Swap.
	 */
	List<? extends CommodityPayout> getCommodityPayout();
	/**
	 * Represents a forward settling payout. The &#39;Underlier&#39; attribute captures the underlying payout, which is settled according to the &#39;SettlementTerms&#39; attribute. Both FX Spot and FX Forward should use this component.
	 */
	List<? extends SettlementPayout> getSettlementPayout();
	/**
	 * Defines a payout in which one or more payouts are defined as a fixed price.
	 */
	List<? extends FixedPricePayout> getFixedPricePayout();
	/**
	 * A cashflow between the parties to the trade. For interest rate and equity products, this corresponds to the FpML additionalPayment element. For credit default swaps, this corresponds to the FpML initialPayment element and the singlePayment element of the fee leg. For option products, it represents the FpML premium element.
	 */
	List<? extends Cashflow> getCashflow();
	/**
	 * The performance payout, which encompasses the equity price returns, dividend returns, volatility return, variance return and correlation provisions.
	 */
	List<? extends PerformancePayout> getPerformancePayout();
	/**
	 * Defines the assets and movements in a security financing transaction.
	 */
	List<? extends AssetPayout> getAssetPayout();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	Payout build();
	
	Payout.PayoutBuilder toBuilder();
	
	static Payout.PayoutBuilder builder() {
		return new Payout.PayoutBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Payout> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Payout> getType() {
		return Payout.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("interestRatePayout"), processor, InterestRatePayout.class, getInterestRatePayout());
		processRosetta(path.newSubPath("creditDefaultPayout"), processor, CreditDefaultPayout.class, getCreditDefaultPayout());
		processRosetta(path.newSubPath("optionPayout"), processor, OptionPayout.class, getOptionPayout());
		processRosetta(path.newSubPath("commodityPayout"), processor, CommodityPayout.class, getCommodityPayout());
		processRosetta(path.newSubPath("settlementPayout"), processor, SettlementPayout.class, getSettlementPayout());
		processRosetta(path.newSubPath("fixedPricePayout"), processor, FixedPricePayout.class, getFixedPricePayout());
		processRosetta(path.newSubPath("cashflow"), processor, Cashflow.class, getCashflow());
		processRosetta(path.newSubPath("performancePayout"), processor, PerformancePayout.class, getPerformancePayout());
		processRosetta(path.newSubPath("assetPayout"), processor, AssetPayout.class, getAssetPayout());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PayoutBuilder extends Payout, RosettaModelObjectBuilder {
		InterestRatePayout.InterestRatePayoutBuilder getOrCreateInterestRatePayout(int _index);
		List<? extends InterestRatePayout.InterestRatePayoutBuilder> getInterestRatePayout();
		CreditDefaultPayout.CreditDefaultPayoutBuilder getOrCreateCreditDefaultPayout();
		CreditDefaultPayout.CreditDefaultPayoutBuilder getCreditDefaultPayout();
		OptionPayout.OptionPayoutBuilder getOrCreateOptionPayout(int _index);
		List<? extends OptionPayout.OptionPayoutBuilder> getOptionPayout();
		CommodityPayout.CommodityPayoutBuilder getOrCreateCommodityPayout(int _index);
		List<? extends CommodityPayout.CommodityPayoutBuilder> getCommodityPayout();
		SettlementPayout.SettlementPayoutBuilder getOrCreateSettlementPayout(int _index);
		List<? extends SettlementPayout.SettlementPayoutBuilder> getSettlementPayout();
		FixedPricePayout.FixedPricePayoutBuilder getOrCreateFixedPricePayout(int _index);
		List<? extends FixedPricePayout.FixedPricePayoutBuilder> getFixedPricePayout();
		Cashflow.CashflowBuilder getOrCreateCashflow(int _index);
		List<? extends Cashflow.CashflowBuilder> getCashflow();
		PerformancePayout.PerformancePayoutBuilder getOrCreatePerformancePayout(int _index);
		List<? extends PerformancePayout.PerformancePayoutBuilder> getPerformancePayout();
		AssetPayout.AssetPayoutBuilder getOrCreateAssetPayout(int _index);
		List<? extends AssetPayout.AssetPayoutBuilder> getAssetPayout();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Payout.PayoutBuilder addInterestRatePayout(InterestRatePayout interestRatePayout0);
		Payout.PayoutBuilder addInterestRatePayout(InterestRatePayout interestRatePayout1, int _idx);
		Payout.PayoutBuilder addInterestRatePayout(List<? extends InterestRatePayout> interestRatePayout2);
		Payout.PayoutBuilder setInterestRatePayout(List<? extends InterestRatePayout> interestRatePayout3);
		Payout.PayoutBuilder setCreditDefaultPayout(CreditDefaultPayout creditDefaultPayout);
		Payout.PayoutBuilder addOptionPayout(OptionPayout optionPayout0);
		Payout.PayoutBuilder addOptionPayout(OptionPayout optionPayout1, int _idx);
		Payout.PayoutBuilder addOptionPayout(List<? extends OptionPayout> optionPayout2);
		Payout.PayoutBuilder setOptionPayout(List<? extends OptionPayout> optionPayout3);
		Payout.PayoutBuilder addCommodityPayout(CommodityPayout commodityPayout0);
		Payout.PayoutBuilder addCommodityPayout(CommodityPayout commodityPayout1, int _idx);
		Payout.PayoutBuilder addCommodityPayout(List<? extends CommodityPayout> commodityPayout2);
		Payout.PayoutBuilder setCommodityPayout(List<? extends CommodityPayout> commodityPayout3);
		Payout.PayoutBuilder addSettlementPayout(SettlementPayout settlementPayout0);
		Payout.PayoutBuilder addSettlementPayout(SettlementPayout settlementPayout1, int _idx);
		Payout.PayoutBuilder addSettlementPayout(List<? extends SettlementPayout> settlementPayout2);
		Payout.PayoutBuilder setSettlementPayout(List<? extends SettlementPayout> settlementPayout3);
		Payout.PayoutBuilder addFixedPricePayout(FixedPricePayout fixedPricePayout0);
		Payout.PayoutBuilder addFixedPricePayout(FixedPricePayout fixedPricePayout1, int _idx);
		Payout.PayoutBuilder addFixedPricePayout(List<? extends FixedPricePayout> fixedPricePayout2);
		Payout.PayoutBuilder setFixedPricePayout(List<? extends FixedPricePayout> fixedPricePayout3);
		Payout.PayoutBuilder addCashflow(Cashflow cashflow0);
		Payout.PayoutBuilder addCashflow(Cashflow cashflow1, int _idx);
		Payout.PayoutBuilder addCashflow(List<? extends Cashflow> cashflow2);
		Payout.PayoutBuilder setCashflow(List<? extends Cashflow> cashflow3);
		Payout.PayoutBuilder addPerformancePayout(PerformancePayout performancePayout0);
		Payout.PayoutBuilder addPerformancePayout(PerformancePayout performancePayout1, int _idx);
		Payout.PayoutBuilder addPerformancePayout(List<? extends PerformancePayout> performancePayout2);
		Payout.PayoutBuilder setPerformancePayout(List<? extends PerformancePayout> performancePayout3);
		Payout.PayoutBuilder addAssetPayout(AssetPayout assetPayout0);
		Payout.PayoutBuilder addAssetPayout(AssetPayout assetPayout1, int _idx);
		Payout.PayoutBuilder addAssetPayout(List<? extends AssetPayout> assetPayout2);
		Payout.PayoutBuilder setAssetPayout(List<? extends AssetPayout> assetPayout3);
		Payout.PayoutBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("interestRatePayout"), processor, InterestRatePayout.InterestRatePayoutBuilder.class, getInterestRatePayout());
			processRosetta(path.newSubPath("creditDefaultPayout"), processor, CreditDefaultPayout.CreditDefaultPayoutBuilder.class, getCreditDefaultPayout());
			processRosetta(path.newSubPath("optionPayout"), processor, OptionPayout.OptionPayoutBuilder.class, getOptionPayout());
			processRosetta(path.newSubPath("commodityPayout"), processor, CommodityPayout.CommodityPayoutBuilder.class, getCommodityPayout());
			processRosetta(path.newSubPath("settlementPayout"), processor, SettlementPayout.SettlementPayoutBuilder.class, getSettlementPayout());
			processRosetta(path.newSubPath("fixedPricePayout"), processor, FixedPricePayout.FixedPricePayoutBuilder.class, getFixedPricePayout());
			processRosetta(path.newSubPath("cashflow"), processor, Cashflow.CashflowBuilder.class, getCashflow());
			processRosetta(path.newSubPath("performancePayout"), processor, PerformancePayout.PerformancePayoutBuilder.class, getPerformancePayout());
			processRosetta(path.newSubPath("assetPayout"), processor, AssetPayout.AssetPayoutBuilder.class, getAssetPayout());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		Payout.PayoutBuilder prune();
	}

	/*********************** Immutable Implementation of Payout  ***********************/
	class PayoutImpl implements Payout {
		private final List<? extends InterestRatePayout> interestRatePayout;
		private final CreditDefaultPayout creditDefaultPayout;
		private final List<? extends OptionPayout> optionPayout;
		private final List<? extends CommodityPayout> commodityPayout;
		private final List<? extends SettlementPayout> settlementPayout;
		private final List<? extends FixedPricePayout> fixedPricePayout;
		private final List<? extends Cashflow> cashflow;
		private final List<? extends PerformancePayout> performancePayout;
		private final List<? extends AssetPayout> assetPayout;
		private final MetaFields meta;
		
		protected PayoutImpl(Payout.PayoutBuilder builder) {
			this.interestRatePayout = ofNullable(builder.getInterestRatePayout()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditDefaultPayout = ofNullable(builder.getCreditDefaultPayout()).map(f->f.build()).orElse(null);
			this.optionPayout = ofNullable(builder.getOptionPayout()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commodityPayout = ofNullable(builder.getCommodityPayout()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementPayout = ofNullable(builder.getSettlementPayout()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fixedPricePayout = ofNullable(builder.getFixedPricePayout()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.cashflow = ofNullable(builder.getCashflow()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.performancePayout = ofNullable(builder.getPerformancePayout()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.assetPayout = ofNullable(builder.getAssetPayout()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("interestRatePayout")
		public List<? extends InterestRatePayout> getInterestRatePayout() {
			return interestRatePayout;
		}
		
		@Override
		@RosettaAttribute("creditDefaultPayout")
		public CreditDefaultPayout getCreditDefaultPayout() {
			return creditDefaultPayout;
		}
		
		@Override
		@RosettaAttribute("optionPayout")
		public List<? extends OptionPayout> getOptionPayout() {
			return optionPayout;
		}
		
		@Override
		@RosettaAttribute("commodityPayout")
		public List<? extends CommodityPayout> getCommodityPayout() {
			return commodityPayout;
		}
		
		@Override
		@RosettaAttribute("settlementPayout")
		public List<? extends SettlementPayout> getSettlementPayout() {
			return settlementPayout;
		}
		
		@Override
		@RosettaAttribute("fixedPricePayout")
		public List<? extends FixedPricePayout> getFixedPricePayout() {
			return fixedPricePayout;
		}
		
		@Override
		@RosettaAttribute("cashflow")
		public List<? extends Cashflow> getCashflow() {
			return cashflow;
		}
		
		@Override
		@RosettaAttribute("performancePayout")
		public List<? extends PerformancePayout> getPerformancePayout() {
			return performancePayout;
		}
		
		@Override
		@RosettaAttribute("assetPayout")
		public List<? extends AssetPayout> getAssetPayout() {
			return assetPayout;
		}
		
		@Override
		@RosettaAttribute("meta")
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Payout build() {
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder toBuilder() {
			Payout.PayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Payout.PayoutBuilder builder) {
			ofNullable(getInterestRatePayout()).ifPresent(builder::setInterestRatePayout);
			ofNullable(getCreditDefaultPayout()).ifPresent(builder::setCreditDefaultPayout);
			ofNullable(getOptionPayout()).ifPresent(builder::setOptionPayout);
			ofNullable(getCommodityPayout()).ifPresent(builder::setCommodityPayout);
			ofNullable(getSettlementPayout()).ifPresent(builder::setSettlementPayout);
			ofNullable(getFixedPricePayout()).ifPresent(builder::setFixedPricePayout);
			ofNullable(getCashflow()).ifPresent(builder::setCashflow);
			ofNullable(getPerformancePayout()).ifPresent(builder::setPerformancePayout);
			ofNullable(getAssetPayout()).ifPresent(builder::setAssetPayout);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Payout _that = getType().cast(o);
		
			if (!ListEquals.listEquals(interestRatePayout, _that.getInterestRatePayout())) return false;
			if (!Objects.equals(creditDefaultPayout, _that.getCreditDefaultPayout())) return false;
			if (!ListEquals.listEquals(optionPayout, _that.getOptionPayout())) return false;
			if (!ListEquals.listEquals(commodityPayout, _that.getCommodityPayout())) return false;
			if (!ListEquals.listEquals(settlementPayout, _that.getSettlementPayout())) return false;
			if (!ListEquals.listEquals(fixedPricePayout, _that.getFixedPricePayout())) return false;
			if (!ListEquals.listEquals(cashflow, _that.getCashflow())) return false;
			if (!ListEquals.listEquals(performancePayout, _that.getPerformancePayout())) return false;
			if (!ListEquals.listEquals(assetPayout, _that.getAssetPayout())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (interestRatePayout != null ? interestRatePayout.hashCode() : 0);
			_result = 31 * _result + (creditDefaultPayout != null ? creditDefaultPayout.hashCode() : 0);
			_result = 31 * _result + (optionPayout != null ? optionPayout.hashCode() : 0);
			_result = 31 * _result + (commodityPayout != null ? commodityPayout.hashCode() : 0);
			_result = 31 * _result + (settlementPayout != null ? settlementPayout.hashCode() : 0);
			_result = 31 * _result + (fixedPricePayout != null ? fixedPricePayout.hashCode() : 0);
			_result = 31 * _result + (cashflow != null ? cashflow.hashCode() : 0);
			_result = 31 * _result + (performancePayout != null ? performancePayout.hashCode() : 0);
			_result = 31 * _result + (assetPayout != null ? assetPayout.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Payout {" +
				"interestRatePayout=" + this.interestRatePayout + ", " +
				"creditDefaultPayout=" + this.creditDefaultPayout + ", " +
				"optionPayout=" + this.optionPayout + ", " +
				"commodityPayout=" + this.commodityPayout + ", " +
				"settlementPayout=" + this.settlementPayout + ", " +
				"fixedPricePayout=" + this.fixedPricePayout + ", " +
				"cashflow=" + this.cashflow + ", " +
				"performancePayout=" + this.performancePayout + ", " +
				"assetPayout=" + this.assetPayout + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of Payout  ***********************/
	class PayoutBuilderImpl implements Payout.PayoutBuilder, GlobalKeyBuilder {
	
		protected List<InterestRatePayout.InterestRatePayoutBuilder> interestRatePayout = new ArrayList<>();
		protected CreditDefaultPayout.CreditDefaultPayoutBuilder creditDefaultPayout;
		protected List<OptionPayout.OptionPayoutBuilder> optionPayout = new ArrayList<>();
		protected List<CommodityPayout.CommodityPayoutBuilder> commodityPayout = new ArrayList<>();
		protected List<SettlementPayout.SettlementPayoutBuilder> settlementPayout = new ArrayList<>();
		protected List<FixedPricePayout.FixedPricePayoutBuilder> fixedPricePayout = new ArrayList<>();
		protected List<Cashflow.CashflowBuilder> cashflow = new ArrayList<>();
		protected List<PerformancePayout.PerformancePayoutBuilder> performancePayout = new ArrayList<>();
		protected List<AssetPayout.AssetPayoutBuilder> assetPayout = new ArrayList<>();
		protected MetaFields.MetaFieldsBuilder meta;
	
		public PayoutBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("interestRatePayout")
		public List<? extends InterestRatePayout.InterestRatePayoutBuilder> getInterestRatePayout() {
			return interestRatePayout;
		}
		
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder getOrCreateInterestRatePayout(int _index) {
		
			if (interestRatePayout==null) {
				this.interestRatePayout = new ArrayList<>();
			}
			InterestRatePayout.InterestRatePayoutBuilder result;
			return getIndex(interestRatePayout, _index, () -> {
						InterestRatePayout.InterestRatePayoutBuilder newInterestRatePayout = InterestRatePayout.builder();
						return newInterestRatePayout;
					});
		}
		
		@Override
		@RosettaAttribute("creditDefaultPayout")
		public CreditDefaultPayout.CreditDefaultPayoutBuilder getCreditDefaultPayout() {
			return creditDefaultPayout;
		}
		
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder getOrCreateCreditDefaultPayout() {
			CreditDefaultPayout.CreditDefaultPayoutBuilder result;
			if (creditDefaultPayout!=null) {
				result = creditDefaultPayout;
			}
			else {
				result = creditDefaultPayout = CreditDefaultPayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionPayout")
		public List<? extends OptionPayout.OptionPayoutBuilder> getOptionPayout() {
			return optionPayout;
		}
		
		@Override
		public OptionPayout.OptionPayoutBuilder getOrCreateOptionPayout(int _index) {
		
			if (optionPayout==null) {
				this.optionPayout = new ArrayList<>();
			}
			OptionPayout.OptionPayoutBuilder result;
			return getIndex(optionPayout, _index, () -> {
						OptionPayout.OptionPayoutBuilder newOptionPayout = OptionPayout.builder();
						return newOptionPayout;
					});
		}
		
		@Override
		@RosettaAttribute("commodityPayout")
		public List<? extends CommodityPayout.CommodityPayoutBuilder> getCommodityPayout() {
			return commodityPayout;
		}
		
		@Override
		public CommodityPayout.CommodityPayoutBuilder getOrCreateCommodityPayout(int _index) {
		
			if (commodityPayout==null) {
				this.commodityPayout = new ArrayList<>();
			}
			CommodityPayout.CommodityPayoutBuilder result;
			return getIndex(commodityPayout, _index, () -> {
						CommodityPayout.CommodityPayoutBuilder newCommodityPayout = CommodityPayout.builder();
						return newCommodityPayout;
					});
		}
		
		@Override
		@RosettaAttribute("settlementPayout")
		public List<? extends SettlementPayout.SettlementPayoutBuilder> getSettlementPayout() {
			return settlementPayout;
		}
		
		@Override
		public SettlementPayout.SettlementPayoutBuilder getOrCreateSettlementPayout(int _index) {
		
			if (settlementPayout==null) {
				this.settlementPayout = new ArrayList<>();
			}
			SettlementPayout.SettlementPayoutBuilder result;
			return getIndex(settlementPayout, _index, () -> {
						SettlementPayout.SettlementPayoutBuilder newSettlementPayout = SettlementPayout.builder();
						return newSettlementPayout;
					});
		}
		
		@Override
		@RosettaAttribute("fixedPricePayout")
		public List<? extends FixedPricePayout.FixedPricePayoutBuilder> getFixedPricePayout() {
			return fixedPricePayout;
		}
		
		@Override
		public FixedPricePayout.FixedPricePayoutBuilder getOrCreateFixedPricePayout(int _index) {
		
			if (fixedPricePayout==null) {
				this.fixedPricePayout = new ArrayList<>();
			}
			FixedPricePayout.FixedPricePayoutBuilder result;
			return getIndex(fixedPricePayout, _index, () -> {
						FixedPricePayout.FixedPricePayoutBuilder newFixedPricePayout = FixedPricePayout.builder();
						return newFixedPricePayout;
					});
		}
		
		@Override
		@RosettaAttribute("cashflow")
		public List<? extends Cashflow.CashflowBuilder> getCashflow() {
			return cashflow;
		}
		
		@Override
		public Cashflow.CashflowBuilder getOrCreateCashflow(int _index) {
		
			if (cashflow==null) {
				this.cashflow = new ArrayList<>();
			}
			Cashflow.CashflowBuilder result;
			return getIndex(cashflow, _index, () -> {
						Cashflow.CashflowBuilder newCashflow = Cashflow.builder();
						return newCashflow;
					});
		}
		
		@Override
		@RosettaAttribute("performancePayout")
		public List<? extends PerformancePayout.PerformancePayoutBuilder> getPerformancePayout() {
			return performancePayout;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder getOrCreatePerformancePayout(int _index) {
		
			if (performancePayout==null) {
				this.performancePayout = new ArrayList<>();
			}
			PerformancePayout.PerformancePayoutBuilder result;
			return getIndex(performancePayout, _index, () -> {
						PerformancePayout.PerformancePayoutBuilder newPerformancePayout = PerformancePayout.builder();
						return newPerformancePayout;
					});
		}
		
		@Override
		@RosettaAttribute("assetPayout")
		public List<? extends AssetPayout.AssetPayoutBuilder> getAssetPayout() {
			return assetPayout;
		}
		
		@Override
		public AssetPayout.AssetPayoutBuilder getOrCreateAssetPayout(int _index) {
		
			if (assetPayout==null) {
				this.assetPayout = new ArrayList<>();
			}
			AssetPayout.AssetPayoutBuilder result;
			return getIndex(assetPayout, _index, () -> {
						AssetPayout.AssetPayoutBuilder newAssetPayout = AssetPayout.builder();
						return newAssetPayout;
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
		@RosettaAttribute("interestRatePayout")
		public Payout.PayoutBuilder addInterestRatePayout(InterestRatePayout interestRatePayout) {
			if (interestRatePayout!=null) this.interestRatePayout.add(interestRatePayout.toBuilder());
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addInterestRatePayout(InterestRatePayout interestRatePayout, int _idx) {
			getIndex(this.interestRatePayout, _idx, () -> interestRatePayout.toBuilder());
			return this;
		}
		@Override 
		public Payout.PayoutBuilder addInterestRatePayout(List<? extends InterestRatePayout> interestRatePayouts) {
			if (interestRatePayouts != null) {
				for (InterestRatePayout toAdd : interestRatePayouts) {
					this.interestRatePayout.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Payout.PayoutBuilder setInterestRatePayout(List<? extends InterestRatePayout> interestRatePayouts) {
			if (interestRatePayouts == null)  {
				this.interestRatePayout = new ArrayList<>();
			}
			else {
				this.interestRatePayout = interestRatePayouts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("creditDefaultPayout")
		public Payout.PayoutBuilder setCreditDefaultPayout(CreditDefaultPayout creditDefaultPayout) {
			this.creditDefaultPayout = creditDefaultPayout==null?null:creditDefaultPayout.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionPayout")
		public Payout.PayoutBuilder addOptionPayout(OptionPayout optionPayout) {
			if (optionPayout!=null) this.optionPayout.add(optionPayout.toBuilder());
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addOptionPayout(OptionPayout optionPayout, int _idx) {
			getIndex(this.optionPayout, _idx, () -> optionPayout.toBuilder());
			return this;
		}
		@Override 
		public Payout.PayoutBuilder addOptionPayout(List<? extends OptionPayout> optionPayouts) {
			if (optionPayouts != null) {
				for (OptionPayout toAdd : optionPayouts) {
					this.optionPayout.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Payout.PayoutBuilder setOptionPayout(List<? extends OptionPayout> optionPayouts) {
			if (optionPayouts == null)  {
				this.optionPayout = new ArrayList<>();
			}
			else {
				this.optionPayout = optionPayouts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("commodityPayout")
		public Payout.PayoutBuilder addCommodityPayout(CommodityPayout commodityPayout) {
			if (commodityPayout!=null) this.commodityPayout.add(commodityPayout.toBuilder());
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addCommodityPayout(CommodityPayout commodityPayout, int _idx) {
			getIndex(this.commodityPayout, _idx, () -> commodityPayout.toBuilder());
			return this;
		}
		@Override 
		public Payout.PayoutBuilder addCommodityPayout(List<? extends CommodityPayout> commodityPayouts) {
			if (commodityPayouts != null) {
				for (CommodityPayout toAdd : commodityPayouts) {
					this.commodityPayout.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Payout.PayoutBuilder setCommodityPayout(List<? extends CommodityPayout> commodityPayouts) {
			if (commodityPayouts == null)  {
				this.commodityPayout = new ArrayList<>();
			}
			else {
				this.commodityPayout = commodityPayouts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementPayout")
		public Payout.PayoutBuilder addSettlementPayout(SettlementPayout settlementPayout) {
			if (settlementPayout!=null) this.settlementPayout.add(settlementPayout.toBuilder());
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addSettlementPayout(SettlementPayout settlementPayout, int _idx) {
			getIndex(this.settlementPayout, _idx, () -> settlementPayout.toBuilder());
			return this;
		}
		@Override 
		public Payout.PayoutBuilder addSettlementPayout(List<? extends SettlementPayout> settlementPayouts) {
			if (settlementPayouts != null) {
				for (SettlementPayout toAdd : settlementPayouts) {
					this.settlementPayout.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Payout.PayoutBuilder setSettlementPayout(List<? extends SettlementPayout> settlementPayouts) {
			if (settlementPayouts == null)  {
				this.settlementPayout = new ArrayList<>();
			}
			else {
				this.settlementPayout = settlementPayouts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("fixedPricePayout")
		public Payout.PayoutBuilder addFixedPricePayout(FixedPricePayout fixedPricePayout) {
			if (fixedPricePayout!=null) this.fixedPricePayout.add(fixedPricePayout.toBuilder());
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addFixedPricePayout(FixedPricePayout fixedPricePayout, int _idx) {
			getIndex(this.fixedPricePayout, _idx, () -> fixedPricePayout.toBuilder());
			return this;
		}
		@Override 
		public Payout.PayoutBuilder addFixedPricePayout(List<? extends FixedPricePayout> fixedPricePayouts) {
			if (fixedPricePayouts != null) {
				for (FixedPricePayout toAdd : fixedPricePayouts) {
					this.fixedPricePayout.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Payout.PayoutBuilder setFixedPricePayout(List<? extends FixedPricePayout> fixedPricePayouts) {
			if (fixedPricePayouts == null)  {
				this.fixedPricePayout = new ArrayList<>();
			}
			else {
				this.fixedPricePayout = fixedPricePayouts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("cashflow")
		public Payout.PayoutBuilder addCashflow(Cashflow cashflow) {
			if (cashflow!=null) this.cashflow.add(cashflow.toBuilder());
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addCashflow(Cashflow cashflow, int _idx) {
			getIndex(this.cashflow, _idx, () -> cashflow.toBuilder());
			return this;
		}
		@Override 
		public Payout.PayoutBuilder addCashflow(List<? extends Cashflow> cashflows) {
			if (cashflows != null) {
				for (Cashflow toAdd : cashflows) {
					this.cashflow.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Payout.PayoutBuilder setCashflow(List<? extends Cashflow> cashflows) {
			if (cashflows == null)  {
				this.cashflow = new ArrayList<>();
			}
			else {
				this.cashflow = cashflows.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("performancePayout")
		public Payout.PayoutBuilder addPerformancePayout(PerformancePayout performancePayout) {
			if (performancePayout!=null) this.performancePayout.add(performancePayout.toBuilder());
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addPerformancePayout(PerformancePayout performancePayout, int _idx) {
			getIndex(this.performancePayout, _idx, () -> performancePayout.toBuilder());
			return this;
		}
		@Override 
		public Payout.PayoutBuilder addPerformancePayout(List<? extends PerformancePayout> performancePayouts) {
			if (performancePayouts != null) {
				for (PerformancePayout toAdd : performancePayouts) {
					this.performancePayout.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Payout.PayoutBuilder setPerformancePayout(List<? extends PerformancePayout> performancePayouts) {
			if (performancePayouts == null)  {
				this.performancePayout = new ArrayList<>();
			}
			else {
				this.performancePayout = performancePayouts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("assetPayout")
		public Payout.PayoutBuilder addAssetPayout(AssetPayout assetPayout) {
			if (assetPayout!=null) this.assetPayout.add(assetPayout.toBuilder());
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder addAssetPayout(AssetPayout assetPayout, int _idx) {
			getIndex(this.assetPayout, _idx, () -> assetPayout.toBuilder());
			return this;
		}
		@Override 
		public Payout.PayoutBuilder addAssetPayout(List<? extends AssetPayout> assetPayouts) {
			if (assetPayouts != null) {
				for (AssetPayout toAdd : assetPayouts) {
					this.assetPayout.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Payout.PayoutBuilder setAssetPayout(List<? extends AssetPayout> assetPayouts) {
			if (assetPayouts == null)  {
				this.assetPayout = new ArrayList<>();
			}
			else {
				this.assetPayout = assetPayouts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		public Payout.PayoutBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		
		@Override
		public Payout build() {
			return new Payout.PayoutImpl(this);
		}
		
		@Override
		public Payout.PayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Payout.PayoutBuilder prune() {
			interestRatePayout = interestRatePayout.stream().filter(b->b!=null).<InterestRatePayout.InterestRatePayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (creditDefaultPayout!=null && !creditDefaultPayout.prune().hasData()) creditDefaultPayout = null;
			optionPayout = optionPayout.stream().filter(b->b!=null).<OptionPayout.OptionPayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			commodityPayout = commodityPayout.stream().filter(b->b!=null).<CommodityPayout.CommodityPayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			settlementPayout = settlementPayout.stream().filter(b->b!=null).<SettlementPayout.SettlementPayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			fixedPricePayout = fixedPricePayout.stream().filter(b->b!=null).<FixedPricePayout.FixedPricePayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			cashflow = cashflow.stream().filter(b->b!=null).<Cashflow.CashflowBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			performancePayout = performancePayout.stream().filter(b->b!=null).<PerformancePayout.PerformancePayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			assetPayout = assetPayout.stream().filter(b->b!=null).<AssetPayout.AssetPayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInterestRatePayout()!=null && getInterestRatePayout().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditDefaultPayout()!=null && getCreditDefaultPayout().hasData()) return true;
			if (getOptionPayout()!=null && getOptionPayout().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommodityPayout()!=null && getCommodityPayout().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementPayout()!=null && getSettlementPayout().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFixedPricePayout()!=null && getFixedPricePayout().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCashflow()!=null && getCashflow().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPerformancePayout()!=null && getPerformancePayout().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAssetPayout()!=null && getAssetPayout().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Payout.PayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Payout.PayoutBuilder o = (Payout.PayoutBuilder) other;
			
			merger.mergeRosetta(getInterestRatePayout(), o.getInterestRatePayout(), this::getOrCreateInterestRatePayout);
			merger.mergeRosetta(getCreditDefaultPayout(), o.getCreditDefaultPayout(), this::setCreditDefaultPayout);
			merger.mergeRosetta(getOptionPayout(), o.getOptionPayout(), this::getOrCreateOptionPayout);
			merger.mergeRosetta(getCommodityPayout(), o.getCommodityPayout(), this::getOrCreateCommodityPayout);
			merger.mergeRosetta(getSettlementPayout(), o.getSettlementPayout(), this::getOrCreateSettlementPayout);
			merger.mergeRosetta(getFixedPricePayout(), o.getFixedPricePayout(), this::getOrCreateFixedPricePayout);
			merger.mergeRosetta(getCashflow(), o.getCashflow(), this::getOrCreateCashflow);
			merger.mergeRosetta(getPerformancePayout(), o.getPerformancePayout(), this::getOrCreatePerformancePayout);
			merger.mergeRosetta(getAssetPayout(), o.getAssetPayout(), this::getOrCreateAssetPayout);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Payout _that = getType().cast(o);
		
			if (!ListEquals.listEquals(interestRatePayout, _that.getInterestRatePayout())) return false;
			if (!Objects.equals(creditDefaultPayout, _that.getCreditDefaultPayout())) return false;
			if (!ListEquals.listEquals(optionPayout, _that.getOptionPayout())) return false;
			if (!ListEquals.listEquals(commodityPayout, _that.getCommodityPayout())) return false;
			if (!ListEquals.listEquals(settlementPayout, _that.getSettlementPayout())) return false;
			if (!ListEquals.listEquals(fixedPricePayout, _that.getFixedPricePayout())) return false;
			if (!ListEquals.listEquals(cashflow, _that.getCashflow())) return false;
			if (!ListEquals.listEquals(performancePayout, _that.getPerformancePayout())) return false;
			if (!ListEquals.listEquals(assetPayout, _that.getAssetPayout())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (interestRatePayout != null ? interestRatePayout.hashCode() : 0);
			_result = 31 * _result + (creditDefaultPayout != null ? creditDefaultPayout.hashCode() : 0);
			_result = 31 * _result + (optionPayout != null ? optionPayout.hashCode() : 0);
			_result = 31 * _result + (commodityPayout != null ? commodityPayout.hashCode() : 0);
			_result = 31 * _result + (settlementPayout != null ? settlementPayout.hashCode() : 0);
			_result = 31 * _result + (fixedPricePayout != null ? fixedPricePayout.hashCode() : 0);
			_result = 31 * _result + (cashflow != null ? cashflow.hashCode() : 0);
			_result = 31 * _result + (performancePayout != null ? performancePayout.hashCode() : 0);
			_result = 31 * _result + (assetPayout != null ? assetPayout.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PayoutBuilder {" +
				"interestRatePayout=" + this.interestRatePayout + ", " +
				"creditDefaultPayout=" + this.creditDefaultPayout + ", " +
				"optionPayout=" + this.optionPayout + ", " +
				"commodityPayout=" + this.commodityPayout + ", " +
				"settlementPayout=" + this.settlementPayout + ", " +
				"fixedPricePayout=" + this.fixedPricePayout + ", " +
				"cashflow=" + this.cashflow + ", " +
				"performancePayout=" + this.performancePayout + ", " +
				"assetPayout=" + this.assetPayout + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
