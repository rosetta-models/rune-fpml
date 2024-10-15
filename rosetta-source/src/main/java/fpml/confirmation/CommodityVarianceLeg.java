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
import fpml.confirmation.CommodityCalculationPeriodsModel;
import fpml.confirmation.CommodityNotionalAmount;
import fpml.confirmation.CommodityNotionalAmountReference;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.CommodityPerformanceSwapLeg;
import fpml.confirmation.CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder;
import fpml.confirmation.CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilderImpl;
import fpml.confirmation.CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegImpl;
import fpml.confirmation.CommodityUnderlyerChoiceModel;
import fpml.confirmation.CommodityVarianceCalculation;
import fpml.confirmation.CommodityVarianceLeg;
import fpml.confirmation.CommodityVarianceLeg.CommodityVarianceLegBuilder;
import fpml.confirmation.CommodityVarianceLeg.CommodityVarianceLegBuilderImpl;
import fpml.confirmation.CommodityVarianceLeg.CommodityVarianceLegImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.meta.CommodityVarianceLegMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the variance payments of a commodity variance swap. A type describing the variance leg of a commodity variance swap.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityVarianceLeg", builder=CommodityVarianceLeg.CommodityVarianceLegBuilderImpl.class, version="${project.version}")
public interface CommodityVarianceLeg extends CommodityPerformanceSwapLeg {

	CommodityVarianceLegMeta metaData = new CommodityVarianceLegMeta();

	/*********************** Getter Methods  ***********************/
	CommodityCalculationPeriodsModel getCommodityCalculationPeriodsModel();
	CommodityPaymentDatesModel getCommodityPaymentDatesModel();
	CommodityUnderlyerChoiceModel getCommodityUnderlyerChoiceModel();
	/**
	 * Specifies the notional amount of a commodity performance type swap. It is a currency-denominated value (i.e. price-times-quantity). In confirmations is also referred to as the Notional Quantity (sic, expressed in currency units), Notional Amount, Equity Notional Amount and, in the case of reinvesting swaps, Initial Notional Amount.
	 */
	CommodityNotionalAmount getNotionalAmount();
	/**
	 * A reference to the Return swap notional amount defined in another leg of the return swap.
	 */
	CommodityNotionalAmountReference getNotionalAmountReference();
	/**
	 * Specifies the variance strike price when this strike is expressed in variance units. Payments on the variance leg are equal to the national amount multiplied by the realized variance minus this variance strike price: notional amount * (realized variance - variance strike price).
	 */
	BigDecimal getVarianceStrikePrice();
	/**
	 * Specifies the volatility strike price when this strike is expressed in standard deviation units. Payments on the variance leg are equal to the national amount multiplied by the realized volatility squared minus the volatility strike price squared. Notional amount * (realized volatility^2 - volatility strike^2). Squaring the volatility strike price converts the volatility strike price into a variance strike price. Squaring the realized volatility converts realized volatility to realized variance.
	 */
	BigDecimal getVolatilityStrikePrice();
	/**
	 * Specifies, in relation to each Payment Date, the variance percentage which, when multiplied times the notional amount is the amount to which the Payment Date relates. For purposes of this representation the realized variance is: (annualizationFactor / N) * signma from i = 1 to N (ln (S sub (i+1)) / (S sub i)), where: ln is the natural logarithm, N is the number of pricing dates, S sub i is the relevant price on the observation date i. If nAdjustment is &#39;true&#39; then the denominator of the annualization factor is (N - 1) rather than N. If realized volatility is the performance metric in a variance swap rather than realized variance then the square root of the formula above will appear in the confirmation.
	 */
	CommodityVarianceCalculation getVarianceCalculation();

	/*********************** Build Methods  ***********************/
	CommodityVarianceLeg build();
	
	CommodityVarianceLeg.CommodityVarianceLegBuilder toBuilder();
	
	static CommodityVarianceLeg.CommodityVarianceLegBuilder builder() {
		return new CommodityVarianceLeg.CommodityVarianceLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityVarianceLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityVarianceLeg> getType() {
		return CommodityVarianceLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("commodityCalculationPeriodsModel"), processor, CommodityCalculationPeriodsModel.class, getCommodityCalculationPeriodsModel());
		processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.class, getCommodityPaymentDatesModel());
		processRosetta(path.newSubPath("commodityUnderlyerChoiceModel"), processor, CommodityUnderlyerChoiceModel.class, getCommodityUnderlyerChoiceModel());
		processRosetta(path.newSubPath("notionalAmount"), processor, CommodityNotionalAmount.class, getNotionalAmount());
		processRosetta(path.newSubPath("notionalAmountReference"), processor, CommodityNotionalAmountReference.class, getNotionalAmountReference());
		processor.processBasic(path.newSubPath("varianceStrikePrice"), BigDecimal.class, getVarianceStrikePrice(), this);
		processor.processBasic(path.newSubPath("volatilityStrikePrice"), BigDecimal.class, getVolatilityStrikePrice(), this);
		processRosetta(path.newSubPath("varianceCalculation"), processor, CommodityVarianceCalculation.class, getVarianceCalculation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityVarianceLegBuilder extends CommodityVarianceLeg, CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder {
		CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder getOrCreateCommodityCalculationPeriodsModel();
		CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder getCommodityCalculationPeriodsModel();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getOrCreateCommodityPaymentDatesModel();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getCommodityPaymentDatesModel();
		CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder getOrCreateCommodityUnderlyerChoiceModel();
		CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder getCommodityUnderlyerChoiceModel();
		CommodityNotionalAmount.CommodityNotionalAmountBuilder getOrCreateNotionalAmount();
		CommodityNotionalAmount.CommodityNotionalAmountBuilder getNotionalAmount();
		CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder getOrCreateNotionalAmountReference();
		CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder getNotionalAmountReference();
		CommodityVarianceCalculation.CommodityVarianceCalculationBuilder getOrCreateVarianceCalculation();
		CommodityVarianceCalculation.CommodityVarianceCalculationBuilder getVarianceCalculation();
		CommodityVarianceLeg.CommodityVarianceLegBuilder setId(String id);
		CommodityVarianceLeg.CommodityVarianceLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		CommodityVarianceLeg.CommodityVarianceLegBuilder setCommodityCalculationPeriodsModel(CommodityCalculationPeriodsModel commodityCalculationPeriodsModel);
		CommodityVarianceLeg.CommodityVarianceLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel);
		CommodityVarianceLeg.CommodityVarianceLegBuilder setCommodityUnderlyerChoiceModel(CommodityUnderlyerChoiceModel commodityUnderlyerChoiceModel);
		CommodityVarianceLeg.CommodityVarianceLegBuilder setNotionalAmount(CommodityNotionalAmount notionalAmount);
		CommodityVarianceLeg.CommodityVarianceLegBuilder setNotionalAmountReference(CommodityNotionalAmountReference notionalAmountReference);
		CommodityVarianceLeg.CommodityVarianceLegBuilder setVarianceStrikePrice(BigDecimal varianceStrikePrice);
		CommodityVarianceLeg.CommodityVarianceLegBuilder setVolatilityStrikePrice(BigDecimal volatilityStrikePrice);
		CommodityVarianceLeg.CommodityVarianceLegBuilder setVarianceCalculation(CommodityVarianceCalculation varianceCalculation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("commodityCalculationPeriodsModel"), processor, CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder.class, getCommodityCalculationPeriodsModel());
			processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder.class, getCommodityPaymentDatesModel());
			processRosetta(path.newSubPath("commodityUnderlyerChoiceModel"), processor, CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder.class, getCommodityUnderlyerChoiceModel());
			processRosetta(path.newSubPath("notionalAmount"), processor, CommodityNotionalAmount.CommodityNotionalAmountBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("notionalAmountReference"), processor, CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder.class, getNotionalAmountReference());
			processor.processBasic(path.newSubPath("varianceStrikePrice"), BigDecimal.class, getVarianceStrikePrice(), this);
			processor.processBasic(path.newSubPath("volatilityStrikePrice"), BigDecimal.class, getVolatilityStrikePrice(), this);
			processRosetta(path.newSubPath("varianceCalculation"), processor, CommodityVarianceCalculation.CommodityVarianceCalculationBuilder.class, getVarianceCalculation());
		}
		

		CommodityVarianceLeg.CommodityVarianceLegBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityVarianceLeg  ***********************/
	class CommodityVarianceLegImpl extends CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegImpl implements CommodityVarianceLeg {
		private final CommodityCalculationPeriodsModel commodityCalculationPeriodsModel;
		private final CommodityPaymentDatesModel commodityPaymentDatesModel;
		private final CommodityUnderlyerChoiceModel commodityUnderlyerChoiceModel;
		private final CommodityNotionalAmount notionalAmount;
		private final CommodityNotionalAmountReference notionalAmountReference;
		private final BigDecimal varianceStrikePrice;
		private final BigDecimal volatilityStrikePrice;
		private final CommodityVarianceCalculation varianceCalculation;
		
		protected CommodityVarianceLegImpl(CommodityVarianceLeg.CommodityVarianceLegBuilder builder) {
			super(builder);
			this.commodityCalculationPeriodsModel = ofNullable(builder.getCommodityCalculationPeriodsModel()).map(f->f.build()).orElse(null);
			this.commodityPaymentDatesModel = ofNullable(builder.getCommodityPaymentDatesModel()).map(f->f.build()).orElse(null);
			this.commodityUnderlyerChoiceModel = ofNullable(builder.getCommodityUnderlyerChoiceModel()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.notionalAmountReference = ofNullable(builder.getNotionalAmountReference()).map(f->f.build()).orElse(null);
			this.varianceStrikePrice = builder.getVarianceStrikePrice();
			this.volatilityStrikePrice = builder.getVolatilityStrikePrice();
			this.varianceCalculation = ofNullable(builder.getVarianceCalculation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsModel")
		public CommodityCalculationPeriodsModel getCommodityCalculationPeriodsModel() {
			return commodityCalculationPeriodsModel;
		}
		
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public CommodityPaymentDatesModel getCommodityPaymentDatesModel() {
			return commodityPaymentDatesModel;
		}
		
		@Override
		@RosettaAttribute("commodityUnderlyerChoiceModel")
		public CommodityUnderlyerChoiceModel getCommodityUnderlyerChoiceModel() {
			return commodityUnderlyerChoiceModel;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public CommodityNotionalAmount getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("notionalAmountReference")
		public CommodityNotionalAmountReference getNotionalAmountReference() {
			return notionalAmountReference;
		}
		
		@Override
		@RosettaAttribute("varianceStrikePrice")
		public BigDecimal getVarianceStrikePrice() {
			return varianceStrikePrice;
		}
		
		@Override
		@RosettaAttribute("volatilityStrikePrice")
		public BigDecimal getVolatilityStrikePrice() {
			return volatilityStrikePrice;
		}
		
		@Override
		@RosettaAttribute("varianceCalculation")
		public CommodityVarianceCalculation getVarianceCalculation() {
			return varianceCalculation;
		}
		
		@Override
		public CommodityVarianceLeg build() {
			return this;
		}
		
		@Override
		public CommodityVarianceLeg.CommodityVarianceLegBuilder toBuilder() {
			CommodityVarianceLeg.CommodityVarianceLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityVarianceLeg.CommodityVarianceLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommodityCalculationPeriodsModel()).ifPresent(builder::setCommodityCalculationPeriodsModel);
			ofNullable(getCommodityPaymentDatesModel()).ifPresent(builder::setCommodityPaymentDatesModel);
			ofNullable(getCommodityUnderlyerChoiceModel()).ifPresent(builder::setCommodityUnderlyerChoiceModel);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getNotionalAmountReference()).ifPresent(builder::setNotionalAmountReference);
			ofNullable(getVarianceStrikePrice()).ifPresent(builder::setVarianceStrikePrice);
			ofNullable(getVolatilityStrikePrice()).ifPresent(builder::setVolatilityStrikePrice);
			ofNullable(getVarianceCalculation()).ifPresent(builder::setVarianceCalculation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityVarianceLeg _that = getType().cast(o);
		
			if (!Objects.equals(commodityCalculationPeriodsModel, _that.getCommodityCalculationPeriodsModel())) return false;
			if (!Objects.equals(commodityPaymentDatesModel, _that.getCommodityPaymentDatesModel())) return false;
			if (!Objects.equals(commodityUnderlyerChoiceModel, _that.getCommodityUnderlyerChoiceModel())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(notionalAmountReference, _that.getNotionalAmountReference())) return false;
			if (!Objects.equals(varianceStrikePrice, _that.getVarianceStrikePrice())) return false;
			if (!Objects.equals(volatilityStrikePrice, _that.getVolatilityStrikePrice())) return false;
			if (!Objects.equals(varianceCalculation, _that.getVarianceCalculation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityCalculationPeriodsModel != null ? commodityCalculationPeriodsModel.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			_result = 31 * _result + (commodityUnderlyerChoiceModel != null ? commodityUnderlyerChoiceModel.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (notionalAmountReference != null ? notionalAmountReference.hashCode() : 0);
			_result = 31 * _result + (varianceStrikePrice != null ? varianceStrikePrice.hashCode() : 0);
			_result = 31 * _result + (volatilityStrikePrice != null ? volatilityStrikePrice.hashCode() : 0);
			_result = 31 * _result + (varianceCalculation != null ? varianceCalculation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityVarianceLeg {" +
				"commodityCalculationPeriodsModel=" + this.commodityCalculationPeriodsModel + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel + ", " +
				"commodityUnderlyerChoiceModel=" + this.commodityUnderlyerChoiceModel + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"notionalAmountReference=" + this.notionalAmountReference + ", " +
				"varianceStrikePrice=" + this.varianceStrikePrice + ", " +
				"volatilityStrikePrice=" + this.volatilityStrikePrice + ", " +
				"varianceCalculation=" + this.varianceCalculation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityVarianceLeg  ***********************/
	class CommodityVarianceLegBuilderImpl extends CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilderImpl  implements CommodityVarianceLeg.CommodityVarianceLegBuilder {
	
		protected CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder commodityCalculationPeriodsModel;
		protected CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder commodityPaymentDatesModel;
		protected CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder commodityUnderlyerChoiceModel;
		protected CommodityNotionalAmount.CommodityNotionalAmountBuilder notionalAmount;
		protected CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder notionalAmountReference;
		protected BigDecimal varianceStrikePrice;
		protected BigDecimal volatilityStrikePrice;
		protected CommodityVarianceCalculation.CommodityVarianceCalculationBuilder varianceCalculation;
	
		public CommodityVarianceLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodityCalculationPeriodsModel")
		public CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder getCommodityCalculationPeriodsModel() {
			return commodityCalculationPeriodsModel;
		}
		
		@Override
		public CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder getOrCreateCommodityCalculationPeriodsModel() {
			CommodityCalculationPeriodsModel.CommodityCalculationPeriodsModelBuilder result;
			if (commodityCalculationPeriodsModel!=null) {
				result = commodityCalculationPeriodsModel;
			}
			else {
				result = commodityCalculationPeriodsModel = CommodityCalculationPeriodsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getCommodityPaymentDatesModel() {
			return commodityPaymentDatesModel;
		}
		
		@Override
		public CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getOrCreateCommodityPaymentDatesModel() {
			CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder result;
			if (commodityPaymentDatesModel!=null) {
				result = commodityPaymentDatesModel;
			}
			else {
				result = commodityPaymentDatesModel = CommodityPaymentDatesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityUnderlyerChoiceModel")
		public CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder getCommodityUnderlyerChoiceModel() {
			return commodityUnderlyerChoiceModel;
		}
		
		@Override
		public CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder getOrCreateCommodityUnderlyerChoiceModel() {
			CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder result;
			if (commodityUnderlyerChoiceModel!=null) {
				result = commodityUnderlyerChoiceModel;
			}
			else {
				result = commodityUnderlyerChoiceModel = CommodityUnderlyerChoiceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder getOrCreateNotionalAmount() {
			CommodityNotionalAmount.CommodityNotionalAmountBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = CommodityNotionalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmountReference")
		public CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder getNotionalAmountReference() {
			return notionalAmountReference;
		}
		
		@Override
		public CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder getOrCreateNotionalAmountReference() {
			CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder result;
			if (notionalAmountReference!=null) {
				result = notionalAmountReference;
			}
			else {
				result = notionalAmountReference = CommodityNotionalAmountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("varianceStrikePrice")
		public BigDecimal getVarianceStrikePrice() {
			return varianceStrikePrice;
		}
		
		@Override
		@RosettaAttribute("volatilityStrikePrice")
		public BigDecimal getVolatilityStrikePrice() {
			return volatilityStrikePrice;
		}
		
		@Override
		@RosettaAttribute("varianceCalculation")
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder getVarianceCalculation() {
			return varianceCalculation;
		}
		
		@Override
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder getOrCreateVarianceCalculation() {
			CommodityVarianceCalculation.CommodityVarianceCalculationBuilder result;
			if (varianceCalculation!=null) {
				result = varianceCalculation;
			}
			else {
				result = varianceCalculation = CommodityVarianceCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public CommodityVarianceLeg.CommodityVarianceLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public CommodityVarianceLeg.CommodityVarianceLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityCalculationPeriodsModel")
		public CommodityVarianceLeg.CommodityVarianceLegBuilder setCommodityCalculationPeriodsModel(CommodityCalculationPeriodsModel commodityCalculationPeriodsModel) {
			this.commodityCalculationPeriodsModel = commodityCalculationPeriodsModel==null?null:commodityCalculationPeriodsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public CommodityVarianceLeg.CommodityVarianceLegBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel) {
			this.commodityPaymentDatesModel = commodityPaymentDatesModel==null?null:commodityPaymentDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityUnderlyerChoiceModel")
		public CommodityVarianceLeg.CommodityVarianceLegBuilder setCommodityUnderlyerChoiceModel(CommodityUnderlyerChoiceModel commodityUnderlyerChoiceModel) {
			this.commodityUnderlyerChoiceModel = commodityUnderlyerChoiceModel==null?null:commodityUnderlyerChoiceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public CommodityVarianceLeg.CommodityVarianceLegBuilder setNotionalAmount(CommodityNotionalAmount notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmountReference")
		public CommodityVarianceLeg.CommodityVarianceLegBuilder setNotionalAmountReference(CommodityNotionalAmountReference notionalAmountReference) {
			this.notionalAmountReference = notionalAmountReference==null?null:notionalAmountReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("varianceStrikePrice")
		public CommodityVarianceLeg.CommodityVarianceLegBuilder setVarianceStrikePrice(BigDecimal varianceStrikePrice) {
			this.varianceStrikePrice = varianceStrikePrice==null?null:varianceStrikePrice;
			return this;
		}
		@Override
		@RosettaAttribute("volatilityStrikePrice")
		public CommodityVarianceLeg.CommodityVarianceLegBuilder setVolatilityStrikePrice(BigDecimal volatilityStrikePrice) {
			this.volatilityStrikePrice = volatilityStrikePrice==null?null:volatilityStrikePrice;
			return this;
		}
		@Override
		@RosettaAttribute("varianceCalculation")
		public CommodityVarianceLeg.CommodityVarianceLegBuilder setVarianceCalculation(CommodityVarianceCalculation varianceCalculation) {
			this.varianceCalculation = varianceCalculation==null?null:varianceCalculation.toBuilder();
			return this;
		}
		
		@Override
		public CommodityVarianceLeg build() {
			return new CommodityVarianceLeg.CommodityVarianceLegImpl(this);
		}
		
		@Override
		public CommodityVarianceLeg.CommodityVarianceLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityVarianceLeg.CommodityVarianceLegBuilder prune() {
			super.prune();
			if (commodityCalculationPeriodsModel!=null && !commodityCalculationPeriodsModel.prune().hasData()) commodityCalculationPeriodsModel = null;
			if (commodityPaymentDatesModel!=null && !commodityPaymentDatesModel.prune().hasData()) commodityPaymentDatesModel = null;
			if (commodityUnderlyerChoiceModel!=null && !commodityUnderlyerChoiceModel.prune().hasData()) commodityUnderlyerChoiceModel = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (notionalAmountReference!=null && !notionalAmountReference.prune().hasData()) notionalAmountReference = null;
			if (varianceCalculation!=null && !varianceCalculation.prune().hasData()) varianceCalculation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommodityCalculationPeriodsModel()!=null && getCommodityCalculationPeriodsModel().hasData()) return true;
			if (getCommodityPaymentDatesModel()!=null && getCommodityPaymentDatesModel().hasData()) return true;
			if (getCommodityUnderlyerChoiceModel()!=null && getCommodityUnderlyerChoiceModel().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getNotionalAmountReference()!=null && getNotionalAmountReference().hasData()) return true;
			if (getVarianceStrikePrice()!=null) return true;
			if (getVolatilityStrikePrice()!=null) return true;
			if (getVarianceCalculation()!=null && getVarianceCalculation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityVarianceLeg.CommodityVarianceLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityVarianceLeg.CommodityVarianceLegBuilder o = (CommodityVarianceLeg.CommodityVarianceLegBuilder) other;
			
			merger.mergeRosetta(getCommodityCalculationPeriodsModel(), o.getCommodityCalculationPeriodsModel(), this::setCommodityCalculationPeriodsModel);
			merger.mergeRosetta(getCommodityPaymentDatesModel(), o.getCommodityPaymentDatesModel(), this::setCommodityPaymentDatesModel);
			merger.mergeRosetta(getCommodityUnderlyerChoiceModel(), o.getCommodityUnderlyerChoiceModel(), this::setCommodityUnderlyerChoiceModel);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getNotionalAmountReference(), o.getNotionalAmountReference(), this::setNotionalAmountReference);
			merger.mergeRosetta(getVarianceCalculation(), o.getVarianceCalculation(), this::setVarianceCalculation);
			
			merger.mergeBasic(getVarianceStrikePrice(), o.getVarianceStrikePrice(), this::setVarianceStrikePrice);
			merger.mergeBasic(getVolatilityStrikePrice(), o.getVolatilityStrikePrice(), this::setVolatilityStrikePrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityVarianceLeg _that = getType().cast(o);
		
			if (!Objects.equals(commodityCalculationPeriodsModel, _that.getCommodityCalculationPeriodsModel())) return false;
			if (!Objects.equals(commodityPaymentDatesModel, _that.getCommodityPaymentDatesModel())) return false;
			if (!Objects.equals(commodityUnderlyerChoiceModel, _that.getCommodityUnderlyerChoiceModel())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(notionalAmountReference, _that.getNotionalAmountReference())) return false;
			if (!Objects.equals(varianceStrikePrice, _that.getVarianceStrikePrice())) return false;
			if (!Objects.equals(volatilityStrikePrice, _that.getVolatilityStrikePrice())) return false;
			if (!Objects.equals(varianceCalculation, _that.getVarianceCalculation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityCalculationPeriodsModel != null ? commodityCalculationPeriodsModel.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			_result = 31 * _result + (commodityUnderlyerChoiceModel != null ? commodityUnderlyerChoiceModel.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (notionalAmountReference != null ? notionalAmountReference.hashCode() : 0);
			_result = 31 * _result + (varianceStrikePrice != null ? varianceStrikePrice.hashCode() : 0);
			_result = 31 * _result + (volatilityStrikePrice != null ? volatilityStrikePrice.hashCode() : 0);
			_result = 31 * _result + (varianceCalculation != null ? varianceCalculation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityVarianceLegBuilder {" +
				"commodityCalculationPeriodsModel=" + this.commodityCalculationPeriodsModel + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel + ", " +
				"commodityUnderlyerChoiceModel=" + this.commodityUnderlyerChoiceModel + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"notionalAmountReference=" + this.notionalAmountReference + ", " +
				"varianceStrikePrice=" + this.varianceStrikePrice + ", " +
				"volatilityStrikePrice=" + this.volatilityStrikePrice + ", " +
				"varianceCalculation=" + this.varianceCalculation +
			'}' + " " + super.toString();
		}
	}
}
