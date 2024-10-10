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
import fpml.confirmation.FeeLeg;
import fpml.confirmation.FeeLeg.FeeLegBuilder;
import fpml.confirmation.FeeLeg.FeeLegBuilderImpl;
import fpml.confirmation.FeeLeg.FeeLegImpl;
import fpml.confirmation.FeeLegChoice;
import fpml.confirmation.Leg;
import fpml.confirmation.Leg.LegBuilder;
import fpml.confirmation.Leg.LegBuilderImpl;
import fpml.confirmation.Leg.LegImpl;
import fpml.confirmation.PeriodicPayment;
import fpml.confirmation.QuotationStyleEnum;
import fpml.confirmation.meta.FeeLegMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FeeLeg", builder=FeeLeg.FeeLegBuilderImpl.class, version="${project.version}")
public interface FeeLeg extends Leg {

	FeeLegMeta metaData = new FeeLegMeta();

	/*********************** Getter Methods  ***********************/
	FeeLegChoice getFeeLegChoice();
	/**
	 * Specifies a periodic schedule of fixed amounts that are payable by the buyer to the seller on the fixed rate payer payment dates. The fixed amount to be paid on each payment date can be specified in terms of a known currency amount or as an amount calculated on a formula basis by reference to a per annum fixed rate. The applicable business day convention and business day for adjusting any fixed rate payer payment date if it would otherwise fall on a day that is not a business day are those specified in the dateAdjustments element within the generalTerms component. ISDA 2003 Term:
	 */
	PeriodicPayment getPeriodicPayment();
	/**
	 * An optional element that only has meaning in a credit index trade. This element contains the credit spread (&quot;fair value&quot;) at which the trade was executed. Unlike the fixedRate of an index, the marketFixedRate varies over the life of the index depending on market conditions. The marketFixedRate is the price of the index as quoted by trading desks.
	 */
	BigDecimal getMarketFixedRate();
	/**
	 * Applicable to CDS on MBS to specify whether payment delays are applicable to the fixed Amount. RMBS typically have a payment delay of 5 days between the coupon date of the reference obligation and the payment date of the synthetic swap. CMBS do not, on the other hand, with both payment dates being on the 25th of each month.
	 */
	Boolean getPaymentDelay();
	/**
	 * An optional element that contains the up-front points expressed as a percentage of the notional. An initialPoints value of 5% would be represented as 0.05. The initialPoints element is an alternative to marketFixedRate in quoting the traded level of a trade. When initialPoints is used, the traded level is the sum of fixedRate and initialPoints. The initialPoints is one of the items that are factored into the initialPayment calculation and is payable by the Buyer to the Seller. Note that initialPoints and marketFixedRate may both be present in the same document when both implied values are desired.
	 */
	BigDecimal getInitialPoints();
	/**
	 * An optional element that only has meaning in a credit index trade. This element contains the price at which the trade was executed and is used instead of marketFixedRate on credit trades on certain indicies which are quoted using a price rather than a spread.
	 */
	BigDecimal getMarketPrice();
	/**
	 * The type of quotation that was used between the trading desks. The purpose of this element is to indicate the actual quotation style that was used to quote this trade which may not be apparent when both marketFixedRate and initialPoints are included in the document. When quotationStyle is ‘PointsUpFront’, the initialPoints element should be populated. When quotationStyle is ‘TradedSpread’, the marketFixedRate element should be populated.
	 */
	QuotationStyleEnum getQuotationStyle();

	/*********************** Build Methods  ***********************/
	FeeLeg build();
	
	FeeLeg.FeeLegBuilder toBuilder();
	
	static FeeLeg.FeeLegBuilder builder() {
		return new FeeLeg.FeeLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FeeLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FeeLeg> getType() {
		return FeeLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("feeLegChoice"), processor, FeeLegChoice.class, getFeeLegChoice());
		processRosetta(path.newSubPath("periodicPayment"), processor, PeriodicPayment.class, getPeriodicPayment());
		processor.processBasic(path.newSubPath("marketFixedRate"), BigDecimal.class, getMarketFixedRate(), this);
		processor.processBasic(path.newSubPath("paymentDelay"), Boolean.class, getPaymentDelay(), this);
		processor.processBasic(path.newSubPath("initialPoints"), BigDecimal.class, getInitialPoints(), this);
		processor.processBasic(path.newSubPath("marketPrice"), BigDecimal.class, getMarketPrice(), this);
		processor.processBasic(path.newSubPath("quotationStyle"), QuotationStyleEnum.class, getQuotationStyle(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FeeLegBuilder extends FeeLeg, Leg.LegBuilder {
		FeeLegChoice.FeeLegChoiceBuilder getOrCreateFeeLegChoice();
		FeeLegChoice.FeeLegChoiceBuilder getFeeLegChoice();
		PeriodicPayment.PeriodicPaymentBuilder getOrCreatePeriodicPayment();
		PeriodicPayment.PeriodicPaymentBuilder getPeriodicPayment();
		FeeLeg.FeeLegBuilder setId(String id);
		FeeLeg.FeeLegBuilder setFeeLegChoice(FeeLegChoice feeLegChoice);
		FeeLeg.FeeLegBuilder setPeriodicPayment(PeriodicPayment periodicPayment);
		FeeLeg.FeeLegBuilder setMarketFixedRate(BigDecimal marketFixedRate);
		FeeLeg.FeeLegBuilder setPaymentDelay(Boolean paymentDelay);
		FeeLeg.FeeLegBuilder setInitialPoints(BigDecimal initialPoints);
		FeeLeg.FeeLegBuilder setMarketPrice(BigDecimal marketPrice);
		FeeLeg.FeeLegBuilder setQuotationStyle(QuotationStyleEnum quotationStyle);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("feeLegChoice"), processor, FeeLegChoice.FeeLegChoiceBuilder.class, getFeeLegChoice());
			processRosetta(path.newSubPath("periodicPayment"), processor, PeriodicPayment.PeriodicPaymentBuilder.class, getPeriodicPayment());
			processor.processBasic(path.newSubPath("marketFixedRate"), BigDecimal.class, getMarketFixedRate(), this);
			processor.processBasic(path.newSubPath("paymentDelay"), Boolean.class, getPaymentDelay(), this);
			processor.processBasic(path.newSubPath("initialPoints"), BigDecimal.class, getInitialPoints(), this);
			processor.processBasic(path.newSubPath("marketPrice"), BigDecimal.class, getMarketPrice(), this);
			processor.processBasic(path.newSubPath("quotationStyle"), QuotationStyleEnum.class, getQuotationStyle(), this);
		}
		

		FeeLeg.FeeLegBuilder prune();
	}

	/*********************** Immutable Implementation of FeeLeg  ***********************/
	class FeeLegImpl extends Leg.LegImpl implements FeeLeg {
		private final FeeLegChoice feeLegChoice;
		private final PeriodicPayment periodicPayment;
		private final BigDecimal marketFixedRate;
		private final Boolean paymentDelay;
		private final BigDecimal initialPoints;
		private final BigDecimal marketPrice;
		private final QuotationStyleEnum quotationStyle;
		
		protected FeeLegImpl(FeeLeg.FeeLegBuilder builder) {
			super(builder);
			this.feeLegChoice = ofNullable(builder.getFeeLegChoice()).map(f->f.build()).orElse(null);
			this.periodicPayment = ofNullable(builder.getPeriodicPayment()).map(f->f.build()).orElse(null);
			this.marketFixedRate = builder.getMarketFixedRate();
			this.paymentDelay = builder.getPaymentDelay();
			this.initialPoints = builder.getInitialPoints();
			this.marketPrice = builder.getMarketPrice();
			this.quotationStyle = builder.getQuotationStyle();
		}
		
		@Override
		@RosettaAttribute("feeLegChoice")
		public FeeLegChoice getFeeLegChoice() {
			return feeLegChoice;
		}
		
		@Override
		@RosettaAttribute("periodicPayment")
		public PeriodicPayment getPeriodicPayment() {
			return periodicPayment;
		}
		
		@Override
		@RosettaAttribute("marketFixedRate")
		public BigDecimal getMarketFixedRate() {
			return marketFixedRate;
		}
		
		@Override
		@RosettaAttribute("paymentDelay")
		public Boolean getPaymentDelay() {
			return paymentDelay;
		}
		
		@Override
		@RosettaAttribute("initialPoints")
		public BigDecimal getInitialPoints() {
			return initialPoints;
		}
		
		@Override
		@RosettaAttribute("marketPrice")
		public BigDecimal getMarketPrice() {
			return marketPrice;
		}
		
		@Override
		@RosettaAttribute("quotationStyle")
		public QuotationStyleEnum getQuotationStyle() {
			return quotationStyle;
		}
		
		@Override
		public FeeLeg build() {
			return this;
		}
		
		@Override
		public FeeLeg.FeeLegBuilder toBuilder() {
			FeeLeg.FeeLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FeeLeg.FeeLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFeeLegChoice()).ifPresent(builder::setFeeLegChoice);
			ofNullable(getPeriodicPayment()).ifPresent(builder::setPeriodicPayment);
			ofNullable(getMarketFixedRate()).ifPresent(builder::setMarketFixedRate);
			ofNullable(getPaymentDelay()).ifPresent(builder::setPaymentDelay);
			ofNullable(getInitialPoints()).ifPresent(builder::setInitialPoints);
			ofNullable(getMarketPrice()).ifPresent(builder::setMarketPrice);
			ofNullable(getQuotationStyle()).ifPresent(builder::setQuotationStyle);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FeeLeg _that = getType().cast(o);
		
			if (!Objects.equals(feeLegChoice, _that.getFeeLegChoice())) return false;
			if (!Objects.equals(periodicPayment, _that.getPeriodicPayment())) return false;
			if (!Objects.equals(marketFixedRate, _that.getMarketFixedRate())) return false;
			if (!Objects.equals(paymentDelay, _that.getPaymentDelay())) return false;
			if (!Objects.equals(initialPoints, _that.getInitialPoints())) return false;
			if (!Objects.equals(marketPrice, _that.getMarketPrice())) return false;
			if (!Objects.equals(quotationStyle, _that.getQuotationStyle())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (feeLegChoice != null ? feeLegChoice.hashCode() : 0);
			_result = 31 * _result + (periodicPayment != null ? periodicPayment.hashCode() : 0);
			_result = 31 * _result + (marketFixedRate != null ? marketFixedRate.hashCode() : 0);
			_result = 31 * _result + (paymentDelay != null ? paymentDelay.hashCode() : 0);
			_result = 31 * _result + (initialPoints != null ? initialPoints.hashCode() : 0);
			_result = 31 * _result + (marketPrice != null ? marketPrice.hashCode() : 0);
			_result = 31 * _result + (quotationStyle != null ? quotationStyle.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeeLeg {" +
				"feeLegChoice=" + this.feeLegChoice + ", " +
				"periodicPayment=" + this.periodicPayment + ", " +
				"marketFixedRate=" + this.marketFixedRate + ", " +
				"paymentDelay=" + this.paymentDelay + ", " +
				"initialPoints=" + this.initialPoints + ", " +
				"marketPrice=" + this.marketPrice + ", " +
				"quotationStyle=" + this.quotationStyle +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FeeLeg  ***********************/
	class FeeLegBuilderImpl extends Leg.LegBuilderImpl  implements FeeLeg.FeeLegBuilder {
	
		protected FeeLegChoice.FeeLegChoiceBuilder feeLegChoice;
		protected PeriodicPayment.PeriodicPaymentBuilder periodicPayment;
		protected BigDecimal marketFixedRate;
		protected Boolean paymentDelay;
		protected BigDecimal initialPoints;
		protected BigDecimal marketPrice;
		protected QuotationStyleEnum quotationStyle;
	
		public FeeLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("feeLegChoice")
		public FeeLegChoice.FeeLegChoiceBuilder getFeeLegChoice() {
			return feeLegChoice;
		}
		
		@Override
		public FeeLegChoice.FeeLegChoiceBuilder getOrCreateFeeLegChoice() {
			FeeLegChoice.FeeLegChoiceBuilder result;
			if (feeLegChoice!=null) {
				result = feeLegChoice;
			}
			else {
				result = feeLegChoice = FeeLegChoice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodicPayment")
		public PeriodicPayment.PeriodicPaymentBuilder getPeriodicPayment() {
			return periodicPayment;
		}
		
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder getOrCreatePeriodicPayment() {
			PeriodicPayment.PeriodicPaymentBuilder result;
			if (periodicPayment!=null) {
				result = periodicPayment;
			}
			else {
				result = periodicPayment = PeriodicPayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("marketFixedRate")
		public BigDecimal getMarketFixedRate() {
			return marketFixedRate;
		}
		
		@Override
		@RosettaAttribute("paymentDelay")
		public Boolean getPaymentDelay() {
			return paymentDelay;
		}
		
		@Override
		@RosettaAttribute("initialPoints")
		public BigDecimal getInitialPoints() {
			return initialPoints;
		}
		
		@Override
		@RosettaAttribute("marketPrice")
		public BigDecimal getMarketPrice() {
			return marketPrice;
		}
		
		@Override
		@RosettaAttribute("quotationStyle")
		public QuotationStyleEnum getQuotationStyle() {
			return quotationStyle;
		}
		
		@Override
		@RosettaAttribute("id")
		public FeeLeg.FeeLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("feeLegChoice")
		public FeeLeg.FeeLegBuilder setFeeLegChoice(FeeLegChoice feeLegChoice) {
			this.feeLegChoice = feeLegChoice==null?null:feeLegChoice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("periodicPayment")
		public FeeLeg.FeeLegBuilder setPeriodicPayment(PeriodicPayment periodicPayment) {
			this.periodicPayment = periodicPayment==null?null:periodicPayment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("marketFixedRate")
		public FeeLeg.FeeLegBuilder setMarketFixedRate(BigDecimal marketFixedRate) {
			this.marketFixedRate = marketFixedRate==null?null:marketFixedRate;
			return this;
		}
		@Override
		@RosettaAttribute("paymentDelay")
		public FeeLeg.FeeLegBuilder setPaymentDelay(Boolean paymentDelay) {
			this.paymentDelay = paymentDelay==null?null:paymentDelay;
			return this;
		}
		@Override
		@RosettaAttribute("initialPoints")
		public FeeLeg.FeeLegBuilder setInitialPoints(BigDecimal initialPoints) {
			this.initialPoints = initialPoints==null?null:initialPoints;
			return this;
		}
		@Override
		@RosettaAttribute("marketPrice")
		public FeeLeg.FeeLegBuilder setMarketPrice(BigDecimal marketPrice) {
			this.marketPrice = marketPrice==null?null:marketPrice;
			return this;
		}
		@Override
		@RosettaAttribute("quotationStyle")
		public FeeLeg.FeeLegBuilder setQuotationStyle(QuotationStyleEnum quotationStyle) {
			this.quotationStyle = quotationStyle==null?null:quotationStyle;
			return this;
		}
		
		@Override
		public FeeLeg build() {
			return new FeeLeg.FeeLegImpl(this);
		}
		
		@Override
		public FeeLeg.FeeLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeeLeg.FeeLegBuilder prune() {
			super.prune();
			if (feeLegChoice!=null && !feeLegChoice.prune().hasData()) feeLegChoice = null;
			if (periodicPayment!=null && !periodicPayment.prune().hasData()) periodicPayment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFeeLegChoice()!=null && getFeeLegChoice().hasData()) return true;
			if (getPeriodicPayment()!=null && getPeriodicPayment().hasData()) return true;
			if (getMarketFixedRate()!=null) return true;
			if (getPaymentDelay()!=null) return true;
			if (getInitialPoints()!=null) return true;
			if (getMarketPrice()!=null) return true;
			if (getQuotationStyle()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeeLeg.FeeLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FeeLeg.FeeLegBuilder o = (FeeLeg.FeeLegBuilder) other;
			
			merger.mergeRosetta(getFeeLegChoice(), o.getFeeLegChoice(), this::setFeeLegChoice);
			merger.mergeRosetta(getPeriodicPayment(), o.getPeriodicPayment(), this::setPeriodicPayment);
			
			merger.mergeBasic(getMarketFixedRate(), o.getMarketFixedRate(), this::setMarketFixedRate);
			merger.mergeBasic(getPaymentDelay(), o.getPaymentDelay(), this::setPaymentDelay);
			merger.mergeBasic(getInitialPoints(), o.getInitialPoints(), this::setInitialPoints);
			merger.mergeBasic(getMarketPrice(), o.getMarketPrice(), this::setMarketPrice);
			merger.mergeBasic(getQuotationStyle(), o.getQuotationStyle(), this::setQuotationStyle);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FeeLeg _that = getType().cast(o);
		
			if (!Objects.equals(feeLegChoice, _that.getFeeLegChoice())) return false;
			if (!Objects.equals(periodicPayment, _that.getPeriodicPayment())) return false;
			if (!Objects.equals(marketFixedRate, _that.getMarketFixedRate())) return false;
			if (!Objects.equals(paymentDelay, _that.getPaymentDelay())) return false;
			if (!Objects.equals(initialPoints, _that.getInitialPoints())) return false;
			if (!Objects.equals(marketPrice, _that.getMarketPrice())) return false;
			if (!Objects.equals(quotationStyle, _that.getQuotationStyle())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (feeLegChoice != null ? feeLegChoice.hashCode() : 0);
			_result = 31 * _result + (periodicPayment != null ? periodicPayment.hashCode() : 0);
			_result = 31 * _result + (marketFixedRate != null ? marketFixedRate.hashCode() : 0);
			_result = 31 * _result + (paymentDelay != null ? paymentDelay.hashCode() : 0);
			_result = 31 * _result + (initialPoints != null ? initialPoints.hashCode() : 0);
			_result = 31 * _result + (marketPrice != null ? marketPrice.hashCode() : 0);
			_result = 31 * _result + (quotationStyle != null ? quotationStyle.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeeLegBuilder {" +
				"feeLegChoice=" + this.feeLegChoice + ", " +
				"periodicPayment=" + this.periodicPayment + ", " +
				"marketFixedRate=" + this.marketFixedRate + ", " +
				"paymentDelay=" + this.paymentDelay + ", " +
				"initialPoints=" + this.initialPoints + ", " +
				"marketPrice=" + this.marketPrice + ", " +
				"quotationStyle=" + this.quotationStyle +
			'}' + " " + super.toString();
		}
	}
}
