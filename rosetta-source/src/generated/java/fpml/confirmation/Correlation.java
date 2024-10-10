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
import fpml.confirmation.BoundedCorrelation;
import fpml.confirmation.CalculationFromObservation;
import fpml.confirmation.CalculationFromObservation.CalculationFromObservationBuilder;
import fpml.confirmation.CalculationFromObservation.CalculationFromObservationBuilderImpl;
import fpml.confirmation.CalculationFromObservation.CalculationFromObservationImpl;
import fpml.confirmation.CalculationFromObservationChoice;
import fpml.confirmation.Correlation;
import fpml.confirmation.Correlation.CorrelationBuilder;
import fpml.confirmation.Correlation.CorrelationBuilderImpl;
import fpml.confirmation.Correlation.CorrelationImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.CorrelationMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the correlation amount of a correlation swap.
 * @version ${project.version}
 */
@RosettaDataType(value="Correlation", builder=Correlation.CorrelationBuilderImpl.class, version="${project.version}")
public interface Correlation extends CalculationFromObservation {

	CorrelationMeta metaData = new CorrelationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Notional amount, which is a cash multiplier.
	 */
	NonNegativeMoney getNotionalAmount();
	/**
	 * Correlation Strike Price.
	 */
	BigDecimal getCorrelationStrikePrice();
	/**
	 * Bounded Correlation.
	 */
	BoundedCorrelation getBoundedCorrelation();
	/**
	 * Number of data series, normal market practice is that correlation data sets are drawn from geographic market areas, such as America, Europe and Asia Pacific, each of these geographic areas will have its own data series to avoid contagion.
	 */
	Integer getNumberOfDataSeries();

	/*********************** Build Methods  ***********************/
	Correlation build();
	
	Correlation.CorrelationBuilder toBuilder();
	
	static Correlation.CorrelationBuilder builder() {
		return new Correlation.CorrelationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Correlation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Correlation> getType() {
		return Correlation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationFromObservationChoice"), processor, CalculationFromObservationChoice.class, getCalculationFromObservationChoice());
		processor.processBasic(path.newSubPath("closingLevel"), Boolean.class, getClosingLevel(), this);
		processor.processBasic(path.newSubPath("expiringLevel"), Boolean.class, getExpiringLevel(), this);
		processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeMoney.class, getNotionalAmount());
		processor.processBasic(path.newSubPath("correlationStrikePrice"), BigDecimal.class, getCorrelationStrikePrice(), this);
		processRosetta(path.newSubPath("boundedCorrelation"), processor, BoundedCorrelation.class, getBoundedCorrelation());
		processor.processBasic(path.newSubPath("numberOfDataSeries"), Integer.class, getNumberOfDataSeries(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrelationBuilder extends Correlation, CalculationFromObservation.CalculationFromObservationBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotionalAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getNotionalAmount();
		BoundedCorrelation.BoundedCorrelationBuilder getOrCreateBoundedCorrelation();
		BoundedCorrelation.BoundedCorrelationBuilder getBoundedCorrelation();
		Correlation.CorrelationBuilder setCalculationFromObservationChoice(CalculationFromObservationChoice calculationFromObservationChoice);
		Correlation.CorrelationBuilder setClosingLevel(Boolean closingLevel);
		Correlation.CorrelationBuilder setExpiringLevel(Boolean expiringLevel);
		Correlation.CorrelationBuilder setExpectedN(Integer expectedN);
		Correlation.CorrelationBuilder setNotionalAmount(NonNegativeMoney notionalAmount);
		Correlation.CorrelationBuilder setCorrelationStrikePrice(BigDecimal correlationStrikePrice);
		Correlation.CorrelationBuilder setBoundedCorrelation(BoundedCorrelation boundedCorrelation);
		Correlation.CorrelationBuilder setNumberOfDataSeries(Integer numberOfDataSeries);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationFromObservationChoice"), processor, CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder.class, getCalculationFromObservationChoice());
			processor.processBasic(path.newSubPath("closingLevel"), Boolean.class, getClosingLevel(), this);
			processor.processBasic(path.newSubPath("expiringLevel"), Boolean.class, getExpiringLevel(), this);
			processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getNotionalAmount());
			processor.processBasic(path.newSubPath("correlationStrikePrice"), BigDecimal.class, getCorrelationStrikePrice(), this);
			processRosetta(path.newSubPath("boundedCorrelation"), processor, BoundedCorrelation.BoundedCorrelationBuilder.class, getBoundedCorrelation());
			processor.processBasic(path.newSubPath("numberOfDataSeries"), Integer.class, getNumberOfDataSeries(), this);
		}
		

		Correlation.CorrelationBuilder prune();
	}

	/*********************** Immutable Implementation of Correlation  ***********************/
	class CorrelationImpl extends CalculationFromObservation.CalculationFromObservationImpl implements Correlation {
		private final NonNegativeMoney notionalAmount;
		private final BigDecimal correlationStrikePrice;
		private final BoundedCorrelation boundedCorrelation;
		private final Integer numberOfDataSeries;
		
		protected CorrelationImpl(Correlation.CorrelationBuilder builder) {
			super(builder);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.correlationStrikePrice = builder.getCorrelationStrikePrice();
			this.boundedCorrelation = ofNullable(builder.getBoundedCorrelation()).map(f->f.build()).orElse(null);
			this.numberOfDataSeries = builder.getNumberOfDataSeries();
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public NonNegativeMoney getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("correlationStrikePrice")
		public BigDecimal getCorrelationStrikePrice() {
			return correlationStrikePrice;
		}
		
		@Override
		@RosettaAttribute("boundedCorrelation")
		public BoundedCorrelation getBoundedCorrelation() {
			return boundedCorrelation;
		}
		
		@Override
		@RosettaAttribute("numberOfDataSeries")
		public Integer getNumberOfDataSeries() {
			return numberOfDataSeries;
		}
		
		@Override
		public Correlation build() {
			return this;
		}
		
		@Override
		public Correlation.CorrelationBuilder toBuilder() {
			Correlation.CorrelationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Correlation.CorrelationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getCorrelationStrikePrice()).ifPresent(builder::setCorrelationStrikePrice);
			ofNullable(getBoundedCorrelation()).ifPresent(builder::setBoundedCorrelation);
			ofNullable(getNumberOfDataSeries()).ifPresent(builder::setNumberOfDataSeries);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Correlation _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(correlationStrikePrice, _that.getCorrelationStrikePrice())) return false;
			if (!Objects.equals(boundedCorrelation, _that.getBoundedCorrelation())) return false;
			if (!Objects.equals(numberOfDataSeries, _that.getNumberOfDataSeries())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (correlationStrikePrice != null ? correlationStrikePrice.hashCode() : 0);
			_result = 31 * _result + (boundedCorrelation != null ? boundedCorrelation.hashCode() : 0);
			_result = 31 * _result + (numberOfDataSeries != null ? numberOfDataSeries.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Correlation {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"correlationStrikePrice=" + this.correlationStrikePrice + ", " +
				"boundedCorrelation=" + this.boundedCorrelation + ", " +
				"numberOfDataSeries=" + this.numberOfDataSeries +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Correlation  ***********************/
	class CorrelationBuilderImpl extends CalculationFromObservation.CalculationFromObservationBuilderImpl  implements Correlation.CorrelationBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder notionalAmount;
		protected BigDecimal correlationStrikePrice;
		protected BoundedCorrelation.BoundedCorrelationBuilder boundedCorrelation;
		protected Integer numberOfDataSeries;
	
		public CorrelationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotionalAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("correlationStrikePrice")
		public BigDecimal getCorrelationStrikePrice() {
			return correlationStrikePrice;
		}
		
		@Override
		@RosettaAttribute("boundedCorrelation")
		public BoundedCorrelation.BoundedCorrelationBuilder getBoundedCorrelation() {
			return boundedCorrelation;
		}
		
		@Override
		public BoundedCorrelation.BoundedCorrelationBuilder getOrCreateBoundedCorrelation() {
			BoundedCorrelation.BoundedCorrelationBuilder result;
			if (boundedCorrelation!=null) {
				result = boundedCorrelation;
			}
			else {
				result = boundedCorrelation = BoundedCorrelation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("numberOfDataSeries")
		public Integer getNumberOfDataSeries() {
			return numberOfDataSeries;
		}
		
		@Override
		@RosettaAttribute("calculationFromObservationChoice")
		public Correlation.CorrelationBuilder setCalculationFromObservationChoice(CalculationFromObservationChoice calculationFromObservationChoice) {
			this.calculationFromObservationChoice = calculationFromObservationChoice==null?null:calculationFromObservationChoice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("closingLevel")
		public Correlation.CorrelationBuilder setClosingLevel(Boolean closingLevel) {
			this.closingLevel = closingLevel==null?null:closingLevel;
			return this;
		}
		@Override
		@RosettaAttribute("expiringLevel")
		public Correlation.CorrelationBuilder setExpiringLevel(Boolean expiringLevel) {
			this.expiringLevel = expiringLevel==null?null:expiringLevel;
			return this;
		}
		@Override
		@RosettaAttribute("expectedN")
		public Correlation.CorrelationBuilder setExpectedN(Integer expectedN) {
			this.expectedN = expectedN==null?null:expectedN;
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public Correlation.CorrelationBuilder setNotionalAmount(NonNegativeMoney notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationStrikePrice")
		public Correlation.CorrelationBuilder setCorrelationStrikePrice(BigDecimal correlationStrikePrice) {
			this.correlationStrikePrice = correlationStrikePrice==null?null:correlationStrikePrice;
			return this;
		}
		@Override
		@RosettaAttribute("boundedCorrelation")
		public Correlation.CorrelationBuilder setBoundedCorrelation(BoundedCorrelation boundedCorrelation) {
			this.boundedCorrelation = boundedCorrelation==null?null:boundedCorrelation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("numberOfDataSeries")
		public Correlation.CorrelationBuilder setNumberOfDataSeries(Integer numberOfDataSeries) {
			this.numberOfDataSeries = numberOfDataSeries==null?null:numberOfDataSeries;
			return this;
		}
		
		@Override
		public Correlation build() {
			return new Correlation.CorrelationImpl(this);
		}
		
		@Override
		public Correlation.CorrelationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Correlation.CorrelationBuilder prune() {
			super.prune();
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (boundedCorrelation!=null && !boundedCorrelation.prune().hasData()) boundedCorrelation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getCorrelationStrikePrice()!=null) return true;
			if (getBoundedCorrelation()!=null && getBoundedCorrelation().hasData()) return true;
			if (getNumberOfDataSeries()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Correlation.CorrelationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Correlation.CorrelationBuilder o = (Correlation.CorrelationBuilder) other;
			
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getBoundedCorrelation(), o.getBoundedCorrelation(), this::setBoundedCorrelation);
			
			merger.mergeBasic(getCorrelationStrikePrice(), o.getCorrelationStrikePrice(), this::setCorrelationStrikePrice);
			merger.mergeBasic(getNumberOfDataSeries(), o.getNumberOfDataSeries(), this::setNumberOfDataSeries);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Correlation _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(correlationStrikePrice, _that.getCorrelationStrikePrice())) return false;
			if (!Objects.equals(boundedCorrelation, _that.getBoundedCorrelation())) return false;
			if (!Objects.equals(numberOfDataSeries, _that.getNumberOfDataSeries())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (correlationStrikePrice != null ? correlationStrikePrice.hashCode() : 0);
			_result = 31 * _result + (boundedCorrelation != null ? boundedCorrelation.hashCode() : 0);
			_result = 31 * _result + (numberOfDataSeries != null ? numberOfDataSeries.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationBuilder {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"correlationStrikePrice=" + this.correlationStrikePrice + ", " +
				"boundedCorrelation=" + this.boundedCorrelation + ", " +
				"numberOfDataSeries=" + this.numberOfDataSeries +
			'}' + " " + super.toString();
		}
	}
}
