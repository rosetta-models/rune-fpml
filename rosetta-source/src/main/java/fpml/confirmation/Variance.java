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
import fpml.confirmation.BoundedVariance;
import fpml.confirmation.CalculationFromObservation;
import fpml.confirmation.CalculationFromObservation.CalculationFromObservationBuilder;
import fpml.confirmation.CalculationFromObservation.CalculationFromObservationBuilderImpl;
import fpml.confirmation.CalculationFromObservation.CalculationFromObservationImpl;
import fpml.confirmation.CalculationFromObservationChoice;
import fpml.confirmation.ExchangeTradedContract;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Variance;
import fpml.confirmation.Variance.VarianceBuilder;
import fpml.confirmation.Variance.VarianceBuilderImpl;
import fpml.confirmation.Variance.VarianceImpl;
import fpml.confirmation.meta.VarianceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the variance amount of a variance swap.
 * @version ${project.version}
 */
@RosettaDataType(value="Variance", builder=Variance.VarianceBuilderImpl.class, version="${project.version}")
public interface Variance extends CalculationFromObservation {

	VarianceMeta metaData = new VarianceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Variance amount, which is a cash multiplier.
	 */
	NonNegativeMoney getVarianceAmount();
	BigDecimal getVolatilityStrikePrice();
	BigDecimal getVarianceStrikePrice();
	/**
	 * If present and true, then variance cap is applicable.
	 */
	Boolean getVarianceCap();
	/**
	 * For use when varianceCap is applicable. Contains the scaling factor of the Variance Cap that can differ on a trade-by-trade basis in the European market. For example, a Variance Cap of 2.5^2 x Variance Strike Price has an unadjustedVarianceCap of 2.5.
	 */
	BigDecimal getUnadjustedVarianceCap();
	/**
	 * Conditions which bound variance. The contract specifies one or more boundary levels. These levels are expressed as prices for confirmation purposes Underlyer price must be equal to or higher than Lower Barrier is known as Up Conditional Swap Underlyer price must be equal to or lower than Upper Barrier is known as Down Conditional Swap Underlyer price must be equal to or higher than Lower Barrier and must be equal to or lower than Upper Barrier is known as Barrier Conditional Swap.
	 */
	BoundedVariance getBoundedVariance();
	/**
	 * Specification of the exchange traded contract nearest.
	 */
	ExchangeTradedContract getExchangeTradedContractNearest();
	/**
	 * Vega Notional represents the approximate gain/loss at maturity for a 1% difference between RVol (realised vol) and KVol (strike vol). It does not necessarily represent the Vega Risk of the trade.
	 */
	BigDecimal getVegaNotionalAmount();

	/*********************** Build Methods  ***********************/
	Variance build();
	
	Variance.VarianceBuilder toBuilder();
	
	static Variance.VarianceBuilder builder() {
		return new Variance.VarianceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Variance> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Variance> getType() {
		return Variance.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationFromObservationChoice"), processor, CalculationFromObservationChoice.class, getCalculationFromObservationChoice());
		processor.processBasic(path.newSubPath("closingLevel"), Boolean.class, getClosingLevel(), this);
		processor.processBasic(path.newSubPath("expiringLevel"), Boolean.class, getExpiringLevel(), this);
		processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
		processRosetta(path.newSubPath("varianceAmount"), processor, NonNegativeMoney.class, getVarianceAmount());
		processor.processBasic(path.newSubPath("volatilityStrikePrice"), BigDecimal.class, getVolatilityStrikePrice(), this);
		processor.processBasic(path.newSubPath("varianceStrikePrice"), BigDecimal.class, getVarianceStrikePrice(), this);
		processor.processBasic(path.newSubPath("varianceCap"), Boolean.class, getVarianceCap(), this);
		processor.processBasic(path.newSubPath("unadjustedVarianceCap"), BigDecimal.class, getUnadjustedVarianceCap(), this);
		processRosetta(path.newSubPath("boundedVariance"), processor, BoundedVariance.class, getBoundedVariance());
		processRosetta(path.newSubPath("exchangeTradedContractNearest"), processor, ExchangeTradedContract.class, getExchangeTradedContractNearest());
		processor.processBasic(path.newSubPath("vegaNotionalAmount"), BigDecimal.class, getVegaNotionalAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface VarianceBuilder extends Variance, CalculationFromObservation.CalculationFromObservationBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateVarianceAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getVarianceAmount();
		BoundedVariance.BoundedVarianceBuilder getOrCreateBoundedVariance();
		BoundedVariance.BoundedVarianceBuilder getBoundedVariance();
		ExchangeTradedContract.ExchangeTradedContractBuilder getOrCreateExchangeTradedContractNearest();
		ExchangeTradedContract.ExchangeTradedContractBuilder getExchangeTradedContractNearest();
		Variance.VarianceBuilder setCalculationFromObservationChoice(CalculationFromObservationChoice calculationFromObservationChoice);
		Variance.VarianceBuilder setClosingLevel(Boolean closingLevel);
		Variance.VarianceBuilder setExpiringLevel(Boolean expiringLevel);
		Variance.VarianceBuilder setExpectedN(Integer expectedN);
		Variance.VarianceBuilder setVarianceAmount(NonNegativeMoney varianceAmount);
		Variance.VarianceBuilder setVolatilityStrikePrice(BigDecimal volatilityStrikePrice);
		Variance.VarianceBuilder setVarianceStrikePrice(BigDecimal varianceStrikePrice);
		Variance.VarianceBuilder setVarianceCap(Boolean varianceCap);
		Variance.VarianceBuilder setUnadjustedVarianceCap(BigDecimal unadjustedVarianceCap);
		Variance.VarianceBuilder setBoundedVariance(BoundedVariance boundedVariance);
		Variance.VarianceBuilder setExchangeTradedContractNearest(ExchangeTradedContract exchangeTradedContractNearest);
		Variance.VarianceBuilder setVegaNotionalAmount(BigDecimal vegaNotionalAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationFromObservationChoice"), processor, CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder.class, getCalculationFromObservationChoice());
			processor.processBasic(path.newSubPath("closingLevel"), Boolean.class, getClosingLevel(), this);
			processor.processBasic(path.newSubPath("expiringLevel"), Boolean.class, getExpiringLevel(), this);
			processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
			processRosetta(path.newSubPath("varianceAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getVarianceAmount());
			processor.processBasic(path.newSubPath("volatilityStrikePrice"), BigDecimal.class, getVolatilityStrikePrice(), this);
			processor.processBasic(path.newSubPath("varianceStrikePrice"), BigDecimal.class, getVarianceStrikePrice(), this);
			processor.processBasic(path.newSubPath("varianceCap"), Boolean.class, getVarianceCap(), this);
			processor.processBasic(path.newSubPath("unadjustedVarianceCap"), BigDecimal.class, getUnadjustedVarianceCap(), this);
			processRosetta(path.newSubPath("boundedVariance"), processor, BoundedVariance.BoundedVarianceBuilder.class, getBoundedVariance());
			processRosetta(path.newSubPath("exchangeTradedContractNearest"), processor, ExchangeTradedContract.ExchangeTradedContractBuilder.class, getExchangeTradedContractNearest());
			processor.processBasic(path.newSubPath("vegaNotionalAmount"), BigDecimal.class, getVegaNotionalAmount(), this);
		}
		

		Variance.VarianceBuilder prune();
	}

	/*********************** Immutable Implementation of Variance  ***********************/
	class VarianceImpl extends CalculationFromObservation.CalculationFromObservationImpl implements Variance {
		private final NonNegativeMoney varianceAmount;
		private final BigDecimal volatilityStrikePrice;
		private final BigDecimal varianceStrikePrice;
		private final Boolean varianceCap;
		private final BigDecimal unadjustedVarianceCap;
		private final BoundedVariance boundedVariance;
		private final ExchangeTradedContract exchangeTradedContractNearest;
		private final BigDecimal vegaNotionalAmount;
		
		protected VarianceImpl(Variance.VarianceBuilder builder) {
			super(builder);
			this.varianceAmount = ofNullable(builder.getVarianceAmount()).map(f->f.build()).orElse(null);
			this.volatilityStrikePrice = builder.getVolatilityStrikePrice();
			this.varianceStrikePrice = builder.getVarianceStrikePrice();
			this.varianceCap = builder.getVarianceCap();
			this.unadjustedVarianceCap = builder.getUnadjustedVarianceCap();
			this.boundedVariance = ofNullable(builder.getBoundedVariance()).map(f->f.build()).orElse(null);
			this.exchangeTradedContractNearest = ofNullable(builder.getExchangeTradedContractNearest()).map(f->f.build()).orElse(null);
			this.vegaNotionalAmount = builder.getVegaNotionalAmount();
		}
		
		@Override
		@RosettaAttribute("varianceAmount")
		public NonNegativeMoney getVarianceAmount() {
			return varianceAmount;
		}
		
		@Override
		@RosettaAttribute("volatilityStrikePrice")
		public BigDecimal getVolatilityStrikePrice() {
			return volatilityStrikePrice;
		}
		
		@Override
		@RosettaAttribute("varianceStrikePrice")
		public BigDecimal getVarianceStrikePrice() {
			return varianceStrikePrice;
		}
		
		@Override
		@RosettaAttribute("varianceCap")
		public Boolean getVarianceCap() {
			return varianceCap;
		}
		
		@Override
		@RosettaAttribute("unadjustedVarianceCap")
		public BigDecimal getUnadjustedVarianceCap() {
			return unadjustedVarianceCap;
		}
		
		@Override
		@RosettaAttribute("boundedVariance")
		public BoundedVariance getBoundedVariance() {
			return boundedVariance;
		}
		
		@Override
		@RosettaAttribute("exchangeTradedContractNearest")
		public ExchangeTradedContract getExchangeTradedContractNearest() {
			return exchangeTradedContractNearest;
		}
		
		@Override
		@RosettaAttribute("vegaNotionalAmount")
		public BigDecimal getVegaNotionalAmount() {
			return vegaNotionalAmount;
		}
		
		@Override
		public Variance build() {
			return this;
		}
		
		@Override
		public Variance.VarianceBuilder toBuilder() {
			Variance.VarianceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Variance.VarianceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getVarianceAmount()).ifPresent(builder::setVarianceAmount);
			ofNullable(getVolatilityStrikePrice()).ifPresent(builder::setVolatilityStrikePrice);
			ofNullable(getVarianceStrikePrice()).ifPresent(builder::setVarianceStrikePrice);
			ofNullable(getVarianceCap()).ifPresent(builder::setVarianceCap);
			ofNullable(getUnadjustedVarianceCap()).ifPresent(builder::setUnadjustedVarianceCap);
			ofNullable(getBoundedVariance()).ifPresent(builder::setBoundedVariance);
			ofNullable(getExchangeTradedContractNearest()).ifPresent(builder::setExchangeTradedContractNearest);
			ofNullable(getVegaNotionalAmount()).ifPresent(builder::setVegaNotionalAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Variance _that = getType().cast(o);
		
			if (!Objects.equals(varianceAmount, _that.getVarianceAmount())) return false;
			if (!Objects.equals(volatilityStrikePrice, _that.getVolatilityStrikePrice())) return false;
			if (!Objects.equals(varianceStrikePrice, _that.getVarianceStrikePrice())) return false;
			if (!Objects.equals(varianceCap, _that.getVarianceCap())) return false;
			if (!Objects.equals(unadjustedVarianceCap, _that.getUnadjustedVarianceCap())) return false;
			if (!Objects.equals(boundedVariance, _that.getBoundedVariance())) return false;
			if (!Objects.equals(exchangeTradedContractNearest, _that.getExchangeTradedContractNearest())) return false;
			if (!Objects.equals(vegaNotionalAmount, _that.getVegaNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (varianceAmount != null ? varianceAmount.hashCode() : 0);
			_result = 31 * _result + (volatilityStrikePrice != null ? volatilityStrikePrice.hashCode() : 0);
			_result = 31 * _result + (varianceStrikePrice != null ? varianceStrikePrice.hashCode() : 0);
			_result = 31 * _result + (varianceCap != null ? varianceCap.hashCode() : 0);
			_result = 31 * _result + (unadjustedVarianceCap != null ? unadjustedVarianceCap.hashCode() : 0);
			_result = 31 * _result + (boundedVariance != null ? boundedVariance.hashCode() : 0);
			_result = 31 * _result + (exchangeTradedContractNearest != null ? exchangeTradedContractNearest.hashCode() : 0);
			_result = 31 * _result + (vegaNotionalAmount != null ? vegaNotionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Variance {" +
				"varianceAmount=" + this.varianceAmount + ", " +
				"volatilityStrikePrice=" + this.volatilityStrikePrice + ", " +
				"varianceStrikePrice=" + this.varianceStrikePrice + ", " +
				"varianceCap=" + this.varianceCap + ", " +
				"unadjustedVarianceCap=" + this.unadjustedVarianceCap + ", " +
				"boundedVariance=" + this.boundedVariance + ", " +
				"exchangeTradedContractNearest=" + this.exchangeTradedContractNearest + ", " +
				"vegaNotionalAmount=" + this.vegaNotionalAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Variance  ***********************/
	class VarianceBuilderImpl extends CalculationFromObservation.CalculationFromObservationBuilderImpl  implements Variance.VarianceBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder varianceAmount;
		protected BigDecimal volatilityStrikePrice;
		protected BigDecimal varianceStrikePrice;
		protected Boolean varianceCap;
		protected BigDecimal unadjustedVarianceCap;
		protected BoundedVariance.BoundedVarianceBuilder boundedVariance;
		protected ExchangeTradedContract.ExchangeTradedContractBuilder exchangeTradedContractNearest;
		protected BigDecimal vegaNotionalAmount;
	
		public VarianceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("varianceAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getVarianceAmount() {
			return varianceAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateVarianceAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (varianceAmount!=null) {
				result = varianceAmount;
			}
			else {
				result = varianceAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("volatilityStrikePrice")
		public BigDecimal getVolatilityStrikePrice() {
			return volatilityStrikePrice;
		}
		
		@Override
		@RosettaAttribute("varianceStrikePrice")
		public BigDecimal getVarianceStrikePrice() {
			return varianceStrikePrice;
		}
		
		@Override
		@RosettaAttribute("varianceCap")
		public Boolean getVarianceCap() {
			return varianceCap;
		}
		
		@Override
		@RosettaAttribute("unadjustedVarianceCap")
		public BigDecimal getUnadjustedVarianceCap() {
			return unadjustedVarianceCap;
		}
		
		@Override
		@RosettaAttribute("boundedVariance")
		public BoundedVariance.BoundedVarianceBuilder getBoundedVariance() {
			return boundedVariance;
		}
		
		@Override
		public BoundedVariance.BoundedVarianceBuilder getOrCreateBoundedVariance() {
			BoundedVariance.BoundedVarianceBuilder result;
			if (boundedVariance!=null) {
				result = boundedVariance;
			}
			else {
				result = boundedVariance = BoundedVariance.builder();
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
		@RosettaAttribute("vegaNotionalAmount")
		public BigDecimal getVegaNotionalAmount() {
			return vegaNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("calculationFromObservationChoice")
		public Variance.VarianceBuilder setCalculationFromObservationChoice(CalculationFromObservationChoice calculationFromObservationChoice) {
			this.calculationFromObservationChoice = calculationFromObservationChoice==null?null:calculationFromObservationChoice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("closingLevel")
		public Variance.VarianceBuilder setClosingLevel(Boolean closingLevel) {
			this.closingLevel = closingLevel==null?null:closingLevel;
			return this;
		}
		@Override
		@RosettaAttribute("expiringLevel")
		public Variance.VarianceBuilder setExpiringLevel(Boolean expiringLevel) {
			this.expiringLevel = expiringLevel==null?null:expiringLevel;
			return this;
		}
		@Override
		@RosettaAttribute("expectedN")
		public Variance.VarianceBuilder setExpectedN(Integer expectedN) {
			this.expectedN = expectedN==null?null:expectedN;
			return this;
		}
		@Override
		@RosettaAttribute("varianceAmount")
		public Variance.VarianceBuilder setVarianceAmount(NonNegativeMoney varianceAmount) {
			this.varianceAmount = varianceAmount==null?null:varianceAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("volatilityStrikePrice")
		public Variance.VarianceBuilder setVolatilityStrikePrice(BigDecimal volatilityStrikePrice) {
			this.volatilityStrikePrice = volatilityStrikePrice==null?null:volatilityStrikePrice;
			return this;
		}
		@Override
		@RosettaAttribute("varianceStrikePrice")
		public Variance.VarianceBuilder setVarianceStrikePrice(BigDecimal varianceStrikePrice) {
			this.varianceStrikePrice = varianceStrikePrice==null?null:varianceStrikePrice;
			return this;
		}
		@Override
		@RosettaAttribute("varianceCap")
		public Variance.VarianceBuilder setVarianceCap(Boolean varianceCap) {
			this.varianceCap = varianceCap==null?null:varianceCap;
			return this;
		}
		@Override
		@RosettaAttribute("unadjustedVarianceCap")
		public Variance.VarianceBuilder setUnadjustedVarianceCap(BigDecimal unadjustedVarianceCap) {
			this.unadjustedVarianceCap = unadjustedVarianceCap==null?null:unadjustedVarianceCap;
			return this;
		}
		@Override
		@RosettaAttribute("boundedVariance")
		public Variance.VarianceBuilder setBoundedVariance(BoundedVariance boundedVariance) {
			this.boundedVariance = boundedVariance==null?null:boundedVariance.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeTradedContractNearest")
		public Variance.VarianceBuilder setExchangeTradedContractNearest(ExchangeTradedContract exchangeTradedContractNearest) {
			this.exchangeTradedContractNearest = exchangeTradedContractNearest==null?null:exchangeTradedContractNearest.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("vegaNotionalAmount")
		public Variance.VarianceBuilder setVegaNotionalAmount(BigDecimal vegaNotionalAmount) {
			this.vegaNotionalAmount = vegaNotionalAmount==null?null:vegaNotionalAmount;
			return this;
		}
		
		@Override
		public Variance build() {
			return new Variance.VarianceImpl(this);
		}
		
		@Override
		public Variance.VarianceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Variance.VarianceBuilder prune() {
			super.prune();
			if (varianceAmount!=null && !varianceAmount.prune().hasData()) varianceAmount = null;
			if (boundedVariance!=null && !boundedVariance.prune().hasData()) boundedVariance = null;
			if (exchangeTradedContractNearest!=null && !exchangeTradedContractNearest.prune().hasData()) exchangeTradedContractNearest = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getVarianceAmount()!=null && getVarianceAmount().hasData()) return true;
			if (getVolatilityStrikePrice()!=null) return true;
			if (getVarianceStrikePrice()!=null) return true;
			if (getVarianceCap()!=null) return true;
			if (getUnadjustedVarianceCap()!=null) return true;
			if (getBoundedVariance()!=null && getBoundedVariance().hasData()) return true;
			if (getExchangeTradedContractNearest()!=null && getExchangeTradedContractNearest().hasData()) return true;
			if (getVegaNotionalAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Variance.VarianceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Variance.VarianceBuilder o = (Variance.VarianceBuilder) other;
			
			merger.mergeRosetta(getVarianceAmount(), o.getVarianceAmount(), this::setVarianceAmount);
			merger.mergeRosetta(getBoundedVariance(), o.getBoundedVariance(), this::setBoundedVariance);
			merger.mergeRosetta(getExchangeTradedContractNearest(), o.getExchangeTradedContractNearest(), this::setExchangeTradedContractNearest);
			
			merger.mergeBasic(getVolatilityStrikePrice(), o.getVolatilityStrikePrice(), this::setVolatilityStrikePrice);
			merger.mergeBasic(getVarianceStrikePrice(), o.getVarianceStrikePrice(), this::setVarianceStrikePrice);
			merger.mergeBasic(getVarianceCap(), o.getVarianceCap(), this::setVarianceCap);
			merger.mergeBasic(getUnadjustedVarianceCap(), o.getUnadjustedVarianceCap(), this::setUnadjustedVarianceCap);
			merger.mergeBasic(getVegaNotionalAmount(), o.getVegaNotionalAmount(), this::setVegaNotionalAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Variance _that = getType().cast(o);
		
			if (!Objects.equals(varianceAmount, _that.getVarianceAmount())) return false;
			if (!Objects.equals(volatilityStrikePrice, _that.getVolatilityStrikePrice())) return false;
			if (!Objects.equals(varianceStrikePrice, _that.getVarianceStrikePrice())) return false;
			if (!Objects.equals(varianceCap, _that.getVarianceCap())) return false;
			if (!Objects.equals(unadjustedVarianceCap, _that.getUnadjustedVarianceCap())) return false;
			if (!Objects.equals(boundedVariance, _that.getBoundedVariance())) return false;
			if (!Objects.equals(exchangeTradedContractNearest, _that.getExchangeTradedContractNearest())) return false;
			if (!Objects.equals(vegaNotionalAmount, _that.getVegaNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (varianceAmount != null ? varianceAmount.hashCode() : 0);
			_result = 31 * _result + (volatilityStrikePrice != null ? volatilityStrikePrice.hashCode() : 0);
			_result = 31 * _result + (varianceStrikePrice != null ? varianceStrikePrice.hashCode() : 0);
			_result = 31 * _result + (varianceCap != null ? varianceCap.hashCode() : 0);
			_result = 31 * _result + (unadjustedVarianceCap != null ? unadjustedVarianceCap.hashCode() : 0);
			_result = 31 * _result + (boundedVariance != null ? boundedVariance.hashCode() : 0);
			_result = 31 * _result + (exchangeTradedContractNearest != null ? exchangeTradedContractNearest.hashCode() : 0);
			_result = 31 * _result + (vegaNotionalAmount != null ? vegaNotionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceBuilder {" +
				"varianceAmount=" + this.varianceAmount + ", " +
				"volatilityStrikePrice=" + this.volatilityStrikePrice + ", " +
				"varianceStrikePrice=" + this.varianceStrikePrice + ", " +
				"varianceCap=" + this.varianceCap + ", " +
				"unadjustedVarianceCap=" + this.unadjustedVarianceCap + ", " +
				"boundedVariance=" + this.boundedVariance + ", " +
				"exchangeTradedContractNearest=" + this.exchangeTradedContractNearest + ", " +
				"vegaNotionalAmount=" + this.vegaNotionalAmount +
			'}' + " " + super.toString();
		}
	}
}
