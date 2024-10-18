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
import fpml.confirmation.AdjustableOrAdjustedDate;
import fpml.confirmation.FxCashSettlementSimple;
import fpml.confirmation.FxFixingScheduleSimple;
import fpml.confirmation.FxPerformanceFixedLeg;
import fpml.confirmation.FxPerformanceFloatingLeg;
import fpml.confirmation.FxPerformanceSwap;
import fpml.confirmation.FxPerformanceSwap.FxPerformanceSwapBuilder;
import fpml.confirmation.FxPerformanceSwap.FxPerformanceSwapBuilderImpl;
import fpml.confirmation.FxPerformanceSwap.FxPerformanceSwapImpl;
import fpml.confirmation.FxSpotRateSource;
import fpml.confirmation.FxValuationDateOffset;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Payment;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.meta.FxPerformanceSwapMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Describes an FX volatility and variance swap.
 * @version ${project.version}
 */
@RosettaDataType(value="FxPerformanceSwap", builder=FxPerformanceSwap.FxPerformanceSwapBuilderImpl.class, version="${project.version}")
public interface FxPerformanceSwap extends Product {

	FxPerformanceSwapMeta metaData = new FxPerformanceSwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A Currency Pair with regards to this transaction and the quoting convention.
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 * Vega Notional means the currency and amount specified as such in the related Confirmation.
	 */
	NonNegativeMoney getVegaNotional();
	/**
	 * Notional Amount means, in the case of Transaction Type Variance Swap, the currency and amount specified as such in the related Confirmation or an amount calculated in accordance with the following: Notional Amount = Vega Notional Amount / (0.02 x Fixed FX Rate). This element must be produced in case of Variance Swap transaction.
	 */
	NonNegativeMoney getNotional();
	/**
	 * Fixed FX Rate component describes the Fixed FX Rate and Fixed FX Rate Payer as such in the Confirmation for the Non-Deliverable Swap FX Transaction.
	 */
	FxPerformanceFixedLeg getFixedLeg();
	/**
	 * Floating FX Rate component describes the Floating FX Rate Payer of the rate determined in accordance with the Floating FX Rate Option specified in the Definitions.
	 */
	FxPerformanceFloatingLeg getFloatingLeg();
	/**
	 * Fixing Information source parameters to determine the rate observed for each good business day within the Fixing Schedule.
	 */
	FxSpotRateSource getFixingInformationSource();
	/**
	 * Parametric schedule of rate observation dates.
	 */
	FxFixingScheduleSimple getFixingSchedule();
	/**
	 * Final Observation Date when Settlement Amount and Settlement Amount Payer determination date.
	 */
	Date getValuationDate();
	/**
	 * Valuation date offset relative to the Final Observation Date and can be: [Final Observation Date][The first Business Day following the Final Observation Date].
	 */
	FxValuationDateOffset getValuationDateOffset();
	/**
	 * The date on which the Settlement Amount will be settled.
	 */
	AdjustableOrAdjustedDate getSettlementDate();
	/**
	 * This specifies the numerator of an annualization factor. Frequently this number is equal to the number of rate observations in a year e.g. Daily Observations: 252.
	 */
	BigDecimal getAnnualizationFactor();
	/**
	 * Specifies whether &quot;Mean Adjustment&quot; is applicable or not in the calculation of the Realized Volatility.
	 */
	Boolean getMeanAdjustment();
	/**
	 * Number of Returns is the number of Observation Dates in the Observation Period, excluding the Initial Observation Date (where the Observation Rate on the Initial Observation Date shall equal S0).
	 */
	Integer getNumberOfReturns();
	/**
	 * Additional Payment means, in respect of an FX Transaction, where such fee is required, and a Transaction Fee Payment Date, the amount, if any, that is specified or otherwise determined as provided in the related Confirmation and, subject to any applicable condition precedent, is payable by one party to the other as further specified or otherwise determined as provided in the related Confirmation on the Transaction Fee Payment Date or on each Transaction Fee Payment Date if more than one is specified, for value on such date.
	 */
	List<? extends Payment> getAdditionalPayment();
	/**
	 * Specifies the Settlement currency and fixing details for cash settlement. The FX Volatility and FX Variance Swaps are inherently cash settled, but into the notional currency. The optional cashSettlement block is provided for the case where the Settlement Currency differs from that of the Notional.
	 */
	FxCashSettlementSimple getCashSettlement();

	/*********************** Build Methods  ***********************/
	FxPerformanceSwap build();
	
	FxPerformanceSwap.FxPerformanceSwapBuilder toBuilder();
	
	static FxPerformanceSwap.FxPerformanceSwapBuilder builder() {
		return new FxPerformanceSwap.FxPerformanceSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxPerformanceSwap> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxPerformanceSwap> getType() {
		return FxPerformanceSwap.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("vegaNotional"), processor, NonNegativeMoney.class, getVegaNotional());
		processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.class, getNotional());
		processRosetta(path.newSubPath("fixedLeg"), processor, FxPerformanceFixedLeg.class, getFixedLeg());
		processRosetta(path.newSubPath("floatingLeg"), processor, FxPerformanceFloatingLeg.class, getFloatingLeg());
		processRosetta(path.newSubPath("fixingInformationSource"), processor, FxSpotRateSource.class, getFixingInformationSource());
		processRosetta(path.newSubPath("fixingSchedule"), processor, FxFixingScheduleSimple.class, getFixingSchedule());
		processor.processBasic(path.newSubPath("valuationDate"), Date.class, getValuationDate(), this);
		processRosetta(path.newSubPath("valuationDateOffset"), processor, FxValuationDateOffset.class, getValuationDateOffset());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedDate.class, getSettlementDate());
		processor.processBasic(path.newSubPath("annualizationFactor"), BigDecimal.class, getAnnualizationFactor(), this);
		processor.processBasic(path.newSubPath("meanAdjustment"), Boolean.class, getMeanAdjustment(), this);
		processor.processBasic(path.newSubPath("numberOfReturns"), Integer.class, getNumberOfReturns(), this);
		processRosetta(path.newSubPath("additionalPayment"), processor, Payment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.class, getCashSettlement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxPerformanceSwapBuilder extends FxPerformanceSwap, Product.ProductBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateVegaNotional();
		NonNegativeMoney.NonNegativeMoneyBuilder getVegaNotional();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotional();
		NonNegativeMoney.NonNegativeMoneyBuilder getNotional();
		FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder getOrCreateFixedLeg();
		FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder getFixedLeg();
		FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder getOrCreateFloatingLeg();
		FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder getFloatingLeg();
		FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateFixingInformationSource();
		FxSpotRateSource.FxSpotRateSourceBuilder getFixingInformationSource();
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder getOrCreateFixingSchedule();
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder getFixingSchedule();
		FxValuationDateOffset.FxValuationDateOffsetBuilder getOrCreateValuationDateOffset();
		FxValuationDateOffset.FxValuationDateOffsetBuilder getValuationDateOffset();
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreateSettlementDate();
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getSettlementDate();
		Payment.PaymentBuilder getOrCreateAdditionalPayment(int _index);
		List<? extends Payment.PaymentBuilder> getAdditionalPayment();
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder getOrCreateCashSettlement();
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder getCashSettlement();
		FxPerformanceSwap.FxPerformanceSwapBuilder setProductModel(ProductModel productModel);
		FxPerformanceSwap.FxPerformanceSwapBuilder setId(String id);
		FxPerformanceSwap.FxPerformanceSwapBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxPerformanceSwap.FxPerformanceSwapBuilder setVegaNotional(NonNegativeMoney vegaNotional);
		FxPerformanceSwap.FxPerformanceSwapBuilder setNotional(NonNegativeMoney notional);
		FxPerformanceSwap.FxPerformanceSwapBuilder setFixedLeg(FxPerformanceFixedLeg fixedLeg);
		FxPerformanceSwap.FxPerformanceSwapBuilder setFloatingLeg(FxPerformanceFloatingLeg floatingLeg);
		FxPerformanceSwap.FxPerformanceSwapBuilder setFixingInformationSource(FxSpotRateSource fixingInformationSource);
		FxPerformanceSwap.FxPerformanceSwapBuilder setFixingSchedule(FxFixingScheduleSimple fixingSchedule);
		FxPerformanceSwap.FxPerformanceSwapBuilder setValuationDate(Date valuationDate);
		FxPerformanceSwap.FxPerformanceSwapBuilder setValuationDateOffset(FxValuationDateOffset valuationDateOffset);
		FxPerformanceSwap.FxPerformanceSwapBuilder setSettlementDate(AdjustableOrAdjustedDate settlementDate);
		FxPerformanceSwap.FxPerformanceSwapBuilder setAnnualizationFactor(BigDecimal annualizationFactor);
		FxPerformanceSwap.FxPerformanceSwapBuilder setMeanAdjustment(Boolean meanAdjustment);
		FxPerformanceSwap.FxPerformanceSwapBuilder setNumberOfReturns(Integer numberOfReturns);
		FxPerformanceSwap.FxPerformanceSwapBuilder addAdditionalPayment(Payment additionalPayment0);
		FxPerformanceSwap.FxPerformanceSwapBuilder addAdditionalPayment(Payment additionalPayment1, int _idx);
		FxPerformanceSwap.FxPerformanceSwapBuilder addAdditionalPayment(List<? extends Payment> additionalPayment2);
		FxPerformanceSwap.FxPerformanceSwapBuilder setAdditionalPayment(List<? extends Payment> additionalPayment3);
		FxPerformanceSwap.FxPerformanceSwapBuilder setCashSettlement(FxCashSettlementSimple cashSettlement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("vegaNotional"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getVegaNotional());
			processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getNotional());
			processRosetta(path.newSubPath("fixedLeg"), processor, FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder.class, getFixedLeg());
			processRosetta(path.newSubPath("floatingLeg"), processor, FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder.class, getFloatingLeg());
			processRosetta(path.newSubPath("fixingInformationSource"), processor, FxSpotRateSource.FxSpotRateSourceBuilder.class, getFixingInformationSource());
			processRosetta(path.newSubPath("fixingSchedule"), processor, FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder.class, getFixingSchedule());
			processor.processBasic(path.newSubPath("valuationDate"), Date.class, getValuationDate(), this);
			processRosetta(path.newSubPath("valuationDateOffset"), processor, FxValuationDateOffset.FxValuationDateOffsetBuilder.class, getValuationDateOffset());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder.class, getSettlementDate());
			processor.processBasic(path.newSubPath("annualizationFactor"), BigDecimal.class, getAnnualizationFactor(), this);
			processor.processBasic(path.newSubPath("meanAdjustment"), Boolean.class, getMeanAdjustment(), this);
			processor.processBasic(path.newSubPath("numberOfReturns"), Integer.class, getNumberOfReturns(), this);
			processRosetta(path.newSubPath("additionalPayment"), processor, Payment.PaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.FxCashSettlementSimpleBuilder.class, getCashSettlement());
		}
		

		FxPerformanceSwap.FxPerformanceSwapBuilder prune();
	}

	/*********************** Immutable Implementation of FxPerformanceSwap  ***********************/
	class FxPerformanceSwapImpl extends Product.ProductImpl implements FxPerformanceSwap {
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final NonNegativeMoney vegaNotional;
		private final NonNegativeMoney notional;
		private final FxPerformanceFixedLeg fixedLeg;
		private final FxPerformanceFloatingLeg floatingLeg;
		private final FxSpotRateSource fixingInformationSource;
		private final FxFixingScheduleSimple fixingSchedule;
		private final Date valuationDate;
		private final FxValuationDateOffset valuationDateOffset;
		private final AdjustableOrAdjustedDate settlementDate;
		private final BigDecimal annualizationFactor;
		private final Boolean meanAdjustment;
		private final Integer numberOfReturns;
		private final List<? extends Payment> additionalPayment;
		private final FxCashSettlementSimple cashSettlement;
		
		protected FxPerformanceSwapImpl(FxPerformanceSwap.FxPerformanceSwapBuilder builder) {
			super(builder);
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.vegaNotional = ofNullable(builder.getVegaNotional()).map(f->f.build()).orElse(null);
			this.notional = ofNullable(builder.getNotional()).map(f->f.build()).orElse(null);
			this.fixedLeg = ofNullable(builder.getFixedLeg()).map(f->f.build()).orElse(null);
			this.floatingLeg = ofNullable(builder.getFloatingLeg()).map(f->f.build()).orElse(null);
			this.fixingInformationSource = ofNullable(builder.getFixingInformationSource()).map(f->f.build()).orElse(null);
			this.fixingSchedule = ofNullable(builder.getFixingSchedule()).map(f->f.build()).orElse(null);
			this.valuationDate = builder.getValuationDate();
			this.valuationDateOffset = ofNullable(builder.getValuationDateOffset()).map(f->f.build()).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.annualizationFactor = builder.getAnnualizationFactor();
			this.meanAdjustment = builder.getMeanAdjustment();
			this.numberOfReturns = builder.getNumberOfReturns();
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("vegaNotional")
		public NonNegativeMoney getVegaNotional() {
			return vegaNotional;
		}
		
		@Override
		@RosettaAttribute("notional")
		public NonNegativeMoney getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("fixedLeg")
		public FxPerformanceFixedLeg getFixedLeg() {
			return fixedLeg;
		}
		
		@Override
		@RosettaAttribute("floatingLeg")
		public FxPerformanceFloatingLeg getFloatingLeg() {
			return floatingLeg;
		}
		
		@Override
		@RosettaAttribute("fixingInformationSource")
		public FxSpotRateSource getFixingInformationSource() {
			return fixingInformationSource;
		}
		
		@Override
		@RosettaAttribute("fixingSchedule")
		public FxFixingScheduleSimple getFixingSchedule() {
			return fixingSchedule;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		public Date getValuationDate() {
			return valuationDate;
		}
		
		@Override
		@RosettaAttribute("valuationDateOffset")
		public FxValuationDateOffset getValuationDateOffset() {
			return valuationDateOffset;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public AdjustableOrAdjustedDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("annualizationFactor")
		public BigDecimal getAnnualizationFactor() {
			return annualizationFactor;
		}
		
		@Override
		@RosettaAttribute("meanAdjustment")
		public Boolean getMeanAdjustment() {
			return meanAdjustment;
		}
		
		@Override
		@RosettaAttribute("numberOfReturns")
		public Integer getNumberOfReturns() {
			return numberOfReturns;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public List<? extends Payment> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public FxCashSettlementSimple getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public FxPerformanceSwap build() {
			return this;
		}
		
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder toBuilder() {
			FxPerformanceSwap.FxPerformanceSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxPerformanceSwap.FxPerformanceSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getVegaNotional()).ifPresent(builder::setVegaNotional);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getFixedLeg()).ifPresent(builder::setFixedLeg);
			ofNullable(getFloatingLeg()).ifPresent(builder::setFloatingLeg);
			ofNullable(getFixingInformationSource()).ifPresent(builder::setFixingInformationSource);
			ofNullable(getFixingSchedule()).ifPresent(builder::setFixingSchedule);
			ofNullable(getValuationDate()).ifPresent(builder::setValuationDate);
			ofNullable(getValuationDateOffset()).ifPresent(builder::setValuationDateOffset);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getAnnualizationFactor()).ifPresent(builder::setAnnualizationFactor);
			ofNullable(getMeanAdjustment()).ifPresent(builder::setMeanAdjustment);
			ofNullable(getNumberOfReturns()).ifPresent(builder::setNumberOfReturns);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxPerformanceSwap _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(vegaNotional, _that.getVegaNotional())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(fixedLeg, _that.getFixedLeg())) return false;
			if (!Objects.equals(floatingLeg, _that.getFloatingLeg())) return false;
			if (!Objects.equals(fixingInformationSource, _that.getFixingInformationSource())) return false;
			if (!Objects.equals(fixingSchedule, _that.getFixingSchedule())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(valuationDateOffset, _that.getValuationDateOffset())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(annualizationFactor, _that.getAnnualizationFactor())) return false;
			if (!Objects.equals(meanAdjustment, _that.getMeanAdjustment())) return false;
			if (!Objects.equals(numberOfReturns, _that.getNumberOfReturns())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (vegaNotional != null ? vegaNotional.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (fixedLeg != null ? fixedLeg.hashCode() : 0);
			_result = 31 * _result + (floatingLeg != null ? floatingLeg.hashCode() : 0);
			_result = 31 * _result + (fixingInformationSource != null ? fixingInformationSource.hashCode() : 0);
			_result = 31 * _result + (fixingSchedule != null ? fixingSchedule.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationDateOffset != null ? valuationDateOffset.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (annualizationFactor != null ? annualizationFactor.hashCode() : 0);
			_result = 31 * _result + (meanAdjustment != null ? meanAdjustment.hashCode() : 0);
			_result = 31 * _result + (numberOfReturns != null ? numberOfReturns.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxPerformanceSwap {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"vegaNotional=" + this.vegaNotional + ", " +
				"notional=" + this.notional + ", " +
				"fixedLeg=" + this.fixedLeg + ", " +
				"floatingLeg=" + this.floatingLeg + ", " +
				"fixingInformationSource=" + this.fixingInformationSource + ", " +
				"fixingSchedule=" + this.fixingSchedule + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"valuationDateOffset=" + this.valuationDateOffset + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"annualizationFactor=" + this.annualizationFactor + ", " +
				"meanAdjustment=" + this.meanAdjustment + ", " +
				"numberOfReturns=" + this.numberOfReturns + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"cashSettlement=" + this.cashSettlement +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxPerformanceSwap  ***********************/
	class FxPerformanceSwapBuilderImpl extends Product.ProductBuilderImpl  implements FxPerformanceSwap.FxPerformanceSwapBuilder {
	
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected NonNegativeMoney.NonNegativeMoneyBuilder vegaNotional;
		protected NonNegativeMoney.NonNegativeMoneyBuilder notional;
		protected FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder fixedLeg;
		protected FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder floatingLeg;
		protected FxSpotRateSource.FxSpotRateSourceBuilder fixingInformationSource;
		protected FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder fixingSchedule;
		protected Date valuationDate;
		protected FxValuationDateOffset.FxValuationDateOffsetBuilder valuationDateOffset;
		protected AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder settlementDate;
		protected BigDecimal annualizationFactor;
		protected Boolean meanAdjustment;
		protected Integer numberOfReturns;
		protected List<Payment.PaymentBuilder> additionalPayment = new ArrayList<>();
		protected FxCashSettlementSimple.FxCashSettlementSimpleBuilder cashSettlement;
	
		public FxPerformanceSwapBuilderImpl() {
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
		@RosettaAttribute("vegaNotional")
		public NonNegativeMoney.NonNegativeMoneyBuilder getVegaNotional() {
			return vegaNotional;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateVegaNotional() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (vegaNotional!=null) {
				result = vegaNotional;
			}
			else {
				result = vegaNotional = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notional")
		public NonNegativeMoney.NonNegativeMoneyBuilder getNotional() {
			return notional;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotional() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (notional!=null) {
				result = notional;
			}
			else {
				result = notional = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedLeg")
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder getFixedLeg() {
			return fixedLeg;
		}
		
		@Override
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder getOrCreateFixedLeg() {
			FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder result;
			if (fixedLeg!=null) {
				result = fixedLeg;
			}
			else {
				result = fixedLeg = FxPerformanceFixedLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingLeg")
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder getFloatingLeg() {
			return floatingLeg;
		}
		
		@Override
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder getOrCreateFloatingLeg() {
			FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder result;
			if (floatingLeg!=null) {
				result = floatingLeg;
			}
			else {
				result = floatingLeg = FxPerformanceFloatingLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingInformationSource")
		public FxSpotRateSource.FxSpotRateSourceBuilder getFixingInformationSource() {
			return fixingInformationSource;
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateFixingInformationSource() {
			FxSpotRateSource.FxSpotRateSourceBuilder result;
			if (fixingInformationSource!=null) {
				result = fixingInformationSource;
			}
			else {
				result = fixingInformationSource = FxSpotRateSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingSchedule")
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder getFixingSchedule() {
			return fixingSchedule;
		}
		
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder getOrCreateFixingSchedule() {
			FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder result;
			if (fixingSchedule!=null) {
				result = fixingSchedule;
			}
			else {
				result = fixingSchedule = FxFixingScheduleSimple.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		public Date getValuationDate() {
			return valuationDate;
		}
		
		@Override
		@RosettaAttribute("valuationDateOffset")
		public FxValuationDateOffset.FxValuationDateOffsetBuilder getValuationDateOffset() {
			return valuationDateOffset;
		}
		
		@Override
		public FxValuationDateOffset.FxValuationDateOffsetBuilder getOrCreateValuationDateOffset() {
			FxValuationDateOffset.FxValuationDateOffsetBuilder result;
			if (valuationDateOffset!=null) {
				result = valuationDateOffset;
			}
			else {
				result = valuationDateOffset = FxValuationDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreateSettlementDate() {
			AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = AdjustableOrAdjustedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("annualizationFactor")
		public BigDecimal getAnnualizationFactor() {
			return annualizationFactor;
		}
		
		@Override
		@RosettaAttribute("meanAdjustment")
		public Boolean getMeanAdjustment() {
			return meanAdjustment;
		}
		
		@Override
		@RosettaAttribute("numberOfReturns")
		public Integer getNumberOfReturns() {
			return numberOfReturns;
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
		@RosettaAttribute("cashSettlement")
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder getOrCreateCashSettlement() {
			FxCashSettlementSimple.FxCashSettlementSimpleBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = FxCashSettlementSimple.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public FxPerformanceSwap.FxPerformanceSwapBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxPerformanceSwap.FxPerformanceSwapBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public FxPerformanceSwap.FxPerformanceSwapBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("vegaNotional")
		public FxPerformanceSwap.FxPerformanceSwapBuilder setVegaNotional(NonNegativeMoney vegaNotional) {
			this.vegaNotional = vegaNotional==null?null:vegaNotional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notional")
		public FxPerformanceSwap.FxPerformanceSwapBuilder setNotional(NonNegativeMoney notional) {
			this.notional = notional==null?null:notional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedLeg")
		public FxPerformanceSwap.FxPerformanceSwapBuilder setFixedLeg(FxPerformanceFixedLeg fixedLeg) {
			this.fixedLeg = fixedLeg==null?null:fixedLeg.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingLeg")
		public FxPerformanceSwap.FxPerformanceSwapBuilder setFloatingLeg(FxPerformanceFloatingLeg floatingLeg) {
			this.floatingLeg = floatingLeg==null?null:floatingLeg.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingInformationSource")
		public FxPerformanceSwap.FxPerformanceSwapBuilder setFixingInformationSource(FxSpotRateSource fixingInformationSource) {
			this.fixingInformationSource = fixingInformationSource==null?null:fixingInformationSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingSchedule")
		public FxPerformanceSwap.FxPerformanceSwapBuilder setFixingSchedule(FxFixingScheduleSimple fixingSchedule) {
			this.fixingSchedule = fixingSchedule==null?null:fixingSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationDate")
		public FxPerformanceSwap.FxPerformanceSwapBuilder setValuationDate(Date valuationDate) {
			this.valuationDate = valuationDate==null?null:valuationDate;
			return this;
		}
		@Override
		@RosettaAttribute("valuationDateOffset")
		public FxPerformanceSwap.FxPerformanceSwapBuilder setValuationDateOffset(FxValuationDateOffset valuationDateOffset) {
			this.valuationDateOffset = valuationDateOffset==null?null:valuationDateOffset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementDate")
		public FxPerformanceSwap.FxPerformanceSwapBuilder setSettlementDate(AdjustableOrAdjustedDate settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("annualizationFactor")
		public FxPerformanceSwap.FxPerformanceSwapBuilder setAnnualizationFactor(BigDecimal annualizationFactor) {
			this.annualizationFactor = annualizationFactor==null?null:annualizationFactor;
			return this;
		}
		@Override
		@RosettaAttribute("meanAdjustment")
		public FxPerformanceSwap.FxPerformanceSwapBuilder setMeanAdjustment(Boolean meanAdjustment) {
			this.meanAdjustment = meanAdjustment==null?null:meanAdjustment;
			return this;
		}
		@Override
		@RosettaAttribute("numberOfReturns")
		public FxPerformanceSwap.FxPerformanceSwapBuilder setNumberOfReturns(Integer numberOfReturns) {
			this.numberOfReturns = numberOfReturns==null?null:numberOfReturns;
			return this;
		}
		@Override
		@RosettaAttribute("additionalPayment")
		public FxPerformanceSwap.FxPerformanceSwapBuilder addAdditionalPayment(Payment additionalPayment) {
			if (additionalPayment!=null) this.additionalPayment.add(additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder addAdditionalPayment(Payment additionalPayment, int _idx) {
			getIndex(this.additionalPayment, _idx, () -> additionalPayment.toBuilder());
			return this;
		}
		@Override 
		public FxPerformanceSwap.FxPerformanceSwapBuilder addAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments != null) {
				for (Payment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxPerformanceSwap.FxPerformanceSwapBuilder setAdditionalPayment(List<? extends Payment> additionalPayments) {
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
		@RosettaAttribute("cashSettlement")
		public FxPerformanceSwap.FxPerformanceSwapBuilder setCashSettlement(FxCashSettlementSimple cashSettlement) {
			this.cashSettlement = cashSettlement==null?null:cashSettlement.toBuilder();
			return this;
		}
		
		@Override
		public FxPerformanceSwap build() {
			return new FxPerformanceSwap.FxPerformanceSwapImpl(this);
		}
		
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder prune() {
			super.prune();
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (vegaNotional!=null && !vegaNotional.prune().hasData()) vegaNotional = null;
			if (notional!=null && !notional.prune().hasData()) notional = null;
			if (fixedLeg!=null && !fixedLeg.prune().hasData()) fixedLeg = null;
			if (floatingLeg!=null && !floatingLeg.prune().hasData()) floatingLeg = null;
			if (fixingInformationSource!=null && !fixingInformationSource.prune().hasData()) fixingInformationSource = null;
			if (fixingSchedule!=null && !fixingSchedule.prune().hasData()) fixingSchedule = null;
			if (valuationDateOffset!=null && !valuationDateOffset.prune().hasData()) valuationDateOffset = null;
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getVegaNotional()!=null && getVegaNotional().hasData()) return true;
			if (getNotional()!=null && getNotional().hasData()) return true;
			if (getFixedLeg()!=null && getFixedLeg().hasData()) return true;
			if (getFloatingLeg()!=null && getFloatingLeg().hasData()) return true;
			if (getFixingInformationSource()!=null && getFixingInformationSource().hasData()) return true;
			if (getFixingSchedule()!=null && getFixingSchedule().hasData()) return true;
			if (getValuationDate()!=null) return true;
			if (getValuationDateOffset()!=null && getValuationDateOffset().hasData()) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			if (getAnnualizationFactor()!=null) return true;
			if (getMeanAdjustment()!=null) return true;
			if (getNumberOfReturns()!=null) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxPerformanceSwap.FxPerformanceSwapBuilder o = (FxPerformanceSwap.FxPerformanceSwapBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getVegaNotional(), o.getVegaNotional(), this::setVegaNotional);
			merger.mergeRosetta(getNotional(), o.getNotional(), this::setNotional);
			merger.mergeRosetta(getFixedLeg(), o.getFixedLeg(), this::setFixedLeg);
			merger.mergeRosetta(getFloatingLeg(), o.getFloatingLeg(), this::setFloatingLeg);
			merger.mergeRosetta(getFixingInformationSource(), o.getFixingInformationSource(), this::setFixingInformationSource);
			merger.mergeRosetta(getFixingSchedule(), o.getFixingSchedule(), this::setFixingSchedule);
			merger.mergeRosetta(getValuationDateOffset(), o.getValuationDateOffset(), this::setValuationDateOffset);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			
			merger.mergeBasic(getValuationDate(), o.getValuationDate(), this::setValuationDate);
			merger.mergeBasic(getAnnualizationFactor(), o.getAnnualizationFactor(), this::setAnnualizationFactor);
			merger.mergeBasic(getMeanAdjustment(), o.getMeanAdjustment(), this::setMeanAdjustment);
			merger.mergeBasic(getNumberOfReturns(), o.getNumberOfReturns(), this::setNumberOfReturns);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxPerformanceSwap _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(vegaNotional, _that.getVegaNotional())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(fixedLeg, _that.getFixedLeg())) return false;
			if (!Objects.equals(floatingLeg, _that.getFloatingLeg())) return false;
			if (!Objects.equals(fixingInformationSource, _that.getFixingInformationSource())) return false;
			if (!Objects.equals(fixingSchedule, _that.getFixingSchedule())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(valuationDateOffset, _that.getValuationDateOffset())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(annualizationFactor, _that.getAnnualizationFactor())) return false;
			if (!Objects.equals(meanAdjustment, _that.getMeanAdjustment())) return false;
			if (!Objects.equals(numberOfReturns, _that.getNumberOfReturns())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (vegaNotional != null ? vegaNotional.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (fixedLeg != null ? fixedLeg.hashCode() : 0);
			_result = 31 * _result + (floatingLeg != null ? floatingLeg.hashCode() : 0);
			_result = 31 * _result + (fixingInformationSource != null ? fixingInformationSource.hashCode() : 0);
			_result = 31 * _result + (fixingSchedule != null ? fixingSchedule.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationDateOffset != null ? valuationDateOffset.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (annualizationFactor != null ? annualizationFactor.hashCode() : 0);
			_result = 31 * _result + (meanAdjustment != null ? meanAdjustment.hashCode() : 0);
			_result = 31 * _result + (numberOfReturns != null ? numberOfReturns.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxPerformanceSwapBuilder {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"vegaNotional=" + this.vegaNotional + ", " +
				"notional=" + this.notional + ", " +
				"fixedLeg=" + this.fixedLeg + ", " +
				"floatingLeg=" + this.floatingLeg + ", " +
				"fixingInformationSource=" + this.fixingInformationSource + ", " +
				"fixingSchedule=" + this.fixingSchedule + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"valuationDateOffset=" + this.valuationDateOffset + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"annualizationFactor=" + this.annualizationFactor + ", " +
				"meanAdjustment=" + this.meanAdjustment + ", " +
				"numberOfReturns=" + this.numberOfReturns + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"cashSettlement=" + this.cashSettlement +
			'}' + " " + super.toString();
		}
	}
}
