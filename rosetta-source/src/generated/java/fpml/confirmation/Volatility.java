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
import fpml.confirmation.CalculationFromObservation;
import fpml.confirmation.CalculationFromObservation.CalculationFromObservationBuilder;
import fpml.confirmation.CalculationFromObservation.CalculationFromObservationBuilderImpl;
import fpml.confirmation.CalculationFromObservation.CalculationFromObservationImpl;
import fpml.confirmation.CalculationFromObservationChoice;
import fpml.confirmation.Volatility;
import fpml.confirmation.Volatility.VolatilityBuilder;
import fpml.confirmation.Volatility.VolatilityBuilderImpl;
import fpml.confirmation.Volatility.VolatilityImpl;
import fpml.confirmation.VolatilityCap;
import fpml.confirmation.meta.VolatilityMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Under 2002 Definitions, When entering into the Transaction, the parties should specify whether, for purposes of determining the initial Share price, they are agreeing to (a) a specific initial price (in which case, the initialLevel element should be populated with the price) or (b) use the price of a Share at the close of the regular trading session on the Trade Date (in which case the closingLevel element should be populated as true) or (c) in the case of a forward starting transaction only, use the Official Settlement Price of the Expiring Contract on the Observation Start Date (in which case expiring Level element should be populated as true). Under 2011 definitions, When entering into the Transaction, the parties should specify whether, for purposes of determining the OPSD Pricing Election, they are agreeing to (a) an agreed price (in which case, the initialLevel element should be populated with the price) or (b) use the Index Close Pricing (Official), (in which case closingLevel element should be populated as true) or (c) use OSP Pricing (in which case the initialLevelSource element should be populated with “OSPPrice”).
 * @version ${project.version}
 */
@RosettaDataType(value="Volatility", builder=Volatility.VolatilityBuilderImpl.class, version="${project.version}")
public interface Volatility extends CalculationFromObservation {

	VolatilityMeta metaData = new VolatilityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Volatility Cap needs to be specified in accordance with the ISDA 2011 Equity Derivatives Definitions.
	 */
	VolatilityCap getVolatilityCap();
	/**
	 * Volatility Strike Price in accordance with the ISDA 2011 Equity Derivatives Definitions.
	 */
	BigDecimal getVolatilityStrikePrice();
	/**
	 * Vega Notional represents the approximate gain/loss at maturity for a 1% difference between RVol(realised vol) and KVol (strike vol). It does not necessarily represent the Vega Risk of the trade. Volatility Amount means the Vega Notional Amount. In accordance with the ISDA 2002 and 2011 Equity Derivatives Definitions.
	 */
	BigDecimal getVegaNotionalAmount();

	/*********************** Build Methods  ***********************/
	Volatility build();
	
	Volatility.VolatilityBuilder toBuilder();
	
	static Volatility.VolatilityBuilder builder() {
		return new Volatility.VolatilityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Volatility> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Volatility> getType() {
		return Volatility.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationFromObservationChoice"), processor, CalculationFromObservationChoice.class, getCalculationFromObservationChoice());
		processor.processBasic(path.newSubPath("closingLevel"), Boolean.class, getClosingLevel(), this);
		processor.processBasic(path.newSubPath("expiringLevel"), Boolean.class, getExpiringLevel(), this);
		processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
		processRosetta(path.newSubPath("volatilityCap"), processor, VolatilityCap.class, getVolatilityCap());
		processor.processBasic(path.newSubPath("volatilityStrikePrice"), BigDecimal.class, getVolatilityStrikePrice(), this);
		processor.processBasic(path.newSubPath("vegaNotionalAmount"), BigDecimal.class, getVegaNotionalAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface VolatilityBuilder extends Volatility, CalculationFromObservation.CalculationFromObservationBuilder {
		VolatilityCap.VolatilityCapBuilder getOrCreateVolatilityCap();
		VolatilityCap.VolatilityCapBuilder getVolatilityCap();
		Volatility.VolatilityBuilder setCalculationFromObservationChoice(CalculationFromObservationChoice calculationFromObservationChoice);
		Volatility.VolatilityBuilder setClosingLevel(Boolean closingLevel);
		Volatility.VolatilityBuilder setExpiringLevel(Boolean expiringLevel);
		Volatility.VolatilityBuilder setExpectedN(Integer expectedN);
		Volatility.VolatilityBuilder setVolatilityCap(VolatilityCap volatilityCap);
		Volatility.VolatilityBuilder setVolatilityStrikePrice(BigDecimal volatilityStrikePrice);
		Volatility.VolatilityBuilder setVegaNotionalAmount(BigDecimal vegaNotionalAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationFromObservationChoice"), processor, CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder.class, getCalculationFromObservationChoice());
			processor.processBasic(path.newSubPath("closingLevel"), Boolean.class, getClosingLevel(), this);
			processor.processBasic(path.newSubPath("expiringLevel"), Boolean.class, getExpiringLevel(), this);
			processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
			processRosetta(path.newSubPath("volatilityCap"), processor, VolatilityCap.VolatilityCapBuilder.class, getVolatilityCap());
			processor.processBasic(path.newSubPath("volatilityStrikePrice"), BigDecimal.class, getVolatilityStrikePrice(), this);
			processor.processBasic(path.newSubPath("vegaNotionalAmount"), BigDecimal.class, getVegaNotionalAmount(), this);
		}
		

		Volatility.VolatilityBuilder prune();
	}

	/*********************** Immutable Implementation of Volatility  ***********************/
	class VolatilityImpl extends CalculationFromObservation.CalculationFromObservationImpl implements Volatility {
		private final VolatilityCap volatilityCap;
		private final BigDecimal volatilityStrikePrice;
		private final BigDecimal vegaNotionalAmount;
		
		protected VolatilityImpl(Volatility.VolatilityBuilder builder) {
			super(builder);
			this.volatilityCap = ofNullable(builder.getVolatilityCap()).map(f->f.build()).orElse(null);
			this.volatilityStrikePrice = builder.getVolatilityStrikePrice();
			this.vegaNotionalAmount = builder.getVegaNotionalAmount();
		}
		
		@Override
		@RosettaAttribute("volatilityCap")
		public VolatilityCap getVolatilityCap() {
			return volatilityCap;
		}
		
		@Override
		@RosettaAttribute("volatilityStrikePrice")
		public BigDecimal getVolatilityStrikePrice() {
			return volatilityStrikePrice;
		}
		
		@Override
		@RosettaAttribute("vegaNotionalAmount")
		public BigDecimal getVegaNotionalAmount() {
			return vegaNotionalAmount;
		}
		
		@Override
		public Volatility build() {
			return this;
		}
		
		@Override
		public Volatility.VolatilityBuilder toBuilder() {
			Volatility.VolatilityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Volatility.VolatilityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getVolatilityCap()).ifPresent(builder::setVolatilityCap);
			ofNullable(getVolatilityStrikePrice()).ifPresent(builder::setVolatilityStrikePrice);
			ofNullable(getVegaNotionalAmount()).ifPresent(builder::setVegaNotionalAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Volatility _that = getType().cast(o);
		
			if (!Objects.equals(volatilityCap, _that.getVolatilityCap())) return false;
			if (!Objects.equals(volatilityStrikePrice, _that.getVolatilityStrikePrice())) return false;
			if (!Objects.equals(vegaNotionalAmount, _that.getVegaNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (volatilityCap != null ? volatilityCap.hashCode() : 0);
			_result = 31 * _result + (volatilityStrikePrice != null ? volatilityStrikePrice.hashCode() : 0);
			_result = 31 * _result + (vegaNotionalAmount != null ? vegaNotionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Volatility {" +
				"volatilityCap=" + this.volatilityCap + ", " +
				"volatilityStrikePrice=" + this.volatilityStrikePrice + ", " +
				"vegaNotionalAmount=" + this.vegaNotionalAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Volatility  ***********************/
	class VolatilityBuilderImpl extends CalculationFromObservation.CalculationFromObservationBuilderImpl  implements Volatility.VolatilityBuilder {
	
		protected VolatilityCap.VolatilityCapBuilder volatilityCap;
		protected BigDecimal volatilityStrikePrice;
		protected BigDecimal vegaNotionalAmount;
	
		public VolatilityBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("volatilityCap")
		public VolatilityCap.VolatilityCapBuilder getVolatilityCap() {
			return volatilityCap;
		}
		
		@Override
		public VolatilityCap.VolatilityCapBuilder getOrCreateVolatilityCap() {
			VolatilityCap.VolatilityCapBuilder result;
			if (volatilityCap!=null) {
				result = volatilityCap;
			}
			else {
				result = volatilityCap = VolatilityCap.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("volatilityStrikePrice")
		public BigDecimal getVolatilityStrikePrice() {
			return volatilityStrikePrice;
		}
		
		@Override
		@RosettaAttribute("vegaNotionalAmount")
		public BigDecimal getVegaNotionalAmount() {
			return vegaNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("calculationFromObservationChoice")
		public Volatility.VolatilityBuilder setCalculationFromObservationChoice(CalculationFromObservationChoice calculationFromObservationChoice) {
			this.calculationFromObservationChoice = calculationFromObservationChoice==null?null:calculationFromObservationChoice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("closingLevel")
		public Volatility.VolatilityBuilder setClosingLevel(Boolean closingLevel) {
			this.closingLevel = closingLevel==null?null:closingLevel;
			return this;
		}
		@Override
		@RosettaAttribute("expiringLevel")
		public Volatility.VolatilityBuilder setExpiringLevel(Boolean expiringLevel) {
			this.expiringLevel = expiringLevel==null?null:expiringLevel;
			return this;
		}
		@Override
		@RosettaAttribute("expectedN")
		public Volatility.VolatilityBuilder setExpectedN(Integer expectedN) {
			this.expectedN = expectedN==null?null:expectedN;
			return this;
		}
		@Override
		@RosettaAttribute("volatilityCap")
		public Volatility.VolatilityBuilder setVolatilityCap(VolatilityCap volatilityCap) {
			this.volatilityCap = volatilityCap==null?null:volatilityCap.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("volatilityStrikePrice")
		public Volatility.VolatilityBuilder setVolatilityStrikePrice(BigDecimal volatilityStrikePrice) {
			this.volatilityStrikePrice = volatilityStrikePrice==null?null:volatilityStrikePrice;
			return this;
		}
		@Override
		@RosettaAttribute("vegaNotionalAmount")
		public Volatility.VolatilityBuilder setVegaNotionalAmount(BigDecimal vegaNotionalAmount) {
			this.vegaNotionalAmount = vegaNotionalAmount==null?null:vegaNotionalAmount;
			return this;
		}
		
		@Override
		public Volatility build() {
			return new Volatility.VolatilityImpl(this);
		}
		
		@Override
		public Volatility.VolatilityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Volatility.VolatilityBuilder prune() {
			super.prune();
			if (volatilityCap!=null && !volatilityCap.prune().hasData()) volatilityCap = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getVolatilityCap()!=null && getVolatilityCap().hasData()) return true;
			if (getVolatilityStrikePrice()!=null) return true;
			if (getVegaNotionalAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Volatility.VolatilityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Volatility.VolatilityBuilder o = (Volatility.VolatilityBuilder) other;
			
			merger.mergeRosetta(getVolatilityCap(), o.getVolatilityCap(), this::setVolatilityCap);
			
			merger.mergeBasic(getVolatilityStrikePrice(), o.getVolatilityStrikePrice(), this::setVolatilityStrikePrice);
			merger.mergeBasic(getVegaNotionalAmount(), o.getVegaNotionalAmount(), this::setVegaNotionalAmount);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Volatility _that = getType().cast(o);
		
			if (!Objects.equals(volatilityCap, _that.getVolatilityCap())) return false;
			if (!Objects.equals(volatilityStrikePrice, _that.getVolatilityStrikePrice())) return false;
			if (!Objects.equals(vegaNotionalAmount, _that.getVegaNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (volatilityCap != null ? volatilityCap.hashCode() : 0);
			_result = 31 * _result + (volatilityStrikePrice != null ? volatilityStrikePrice.hashCode() : 0);
			_result = 31 * _result + (vegaNotionalAmount != null ? vegaNotionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityBuilder {" +
				"volatilityCap=" + this.volatilityCap + ", " +
				"volatilityStrikePrice=" + this.volatilityStrikePrice + ", " +
				"vegaNotionalAmount=" + this.vegaNotionalAmount +
			'}' + " " + super.toString();
		}
	}
}
