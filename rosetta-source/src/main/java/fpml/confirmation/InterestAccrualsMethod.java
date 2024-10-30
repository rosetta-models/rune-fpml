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
import fpml.confirmation.FloatingRateCalculation;
import fpml.confirmation.InterestAccrualsMethod;
import fpml.confirmation.InterestAccrualsMethod.InterestAccrualsMethodBuilder;
import fpml.confirmation.InterestAccrualsMethod.InterestAccrualsMethodBuilderImpl;
import fpml.confirmation.InterestAccrualsMethod.InterestAccrualsMethodImpl;
import fpml.confirmation.meta.InterestAccrualsMethodMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the method for accruing interests on dividends. Can be either a fixed rate reference or a floating rate reference.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="InterestAccrualsMethod", builder=InterestAccrualsMethod.InterestAccrualsMethodBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface InterestAccrualsMethod extends RosettaModelObject {

	InterestAccrualsMethodMeta metaData = new InterestAccrualsMethodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The floating rate calculation definitions
	 */
	FloatingRateCalculation getFloatingRateCalculation();
	/**
	 * The calculation period fixed rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05.
	 */
	BigDecimal getFixedRate();

	/*********************** Build Methods  ***********************/
	InterestAccrualsMethod build();
	
	InterestAccrualsMethod.InterestAccrualsMethodBuilder toBuilder();
	
	static InterestAccrualsMethod.InterestAccrualsMethodBuilder builder() {
		return new InterestAccrualsMethod.InterestAccrualsMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestAccrualsMethod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InterestAccrualsMethod> getType() {
		return InterestAccrualsMethod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.class, getFloatingRateCalculation());
		processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestAccrualsMethodBuilder extends InterestAccrualsMethod, RosettaModelObjectBuilder {
		FloatingRateCalculation.FloatingRateCalculationBuilder getOrCreateFloatingRateCalculation();
		FloatingRateCalculation.FloatingRateCalculationBuilder getFloatingRateCalculation();
		InterestAccrualsMethod.InterestAccrualsMethodBuilder setFloatingRateCalculation(FloatingRateCalculation floatingRateCalculation);
		InterestAccrualsMethod.InterestAccrualsMethodBuilder setFixedRate(BigDecimal fixedRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.FloatingRateCalculationBuilder.class, getFloatingRateCalculation());
			processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
		}
		

		InterestAccrualsMethod.InterestAccrualsMethodBuilder prune();
	}

	/*********************** Immutable Implementation of InterestAccrualsMethod  ***********************/
	class InterestAccrualsMethodImpl implements InterestAccrualsMethod {
		private final FloatingRateCalculation floatingRateCalculation;
		private final BigDecimal fixedRate;
		
		protected InterestAccrualsMethodImpl(InterestAccrualsMethod.InterestAccrualsMethodBuilder builder) {
			this.floatingRateCalculation = ofNullable(builder.getFloatingRateCalculation()).map(f->f.build()).orElse(null);
			this.fixedRate = builder.getFixedRate();
		}
		
		@Override
		@RosettaAttribute("floatingRateCalculation")
		public FloatingRateCalculation getFloatingRateCalculation() {
			return floatingRateCalculation;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		public InterestAccrualsMethod build() {
			return this;
		}
		
		@Override
		public InterestAccrualsMethod.InterestAccrualsMethodBuilder toBuilder() {
			InterestAccrualsMethod.InterestAccrualsMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestAccrualsMethod.InterestAccrualsMethodBuilder builder) {
			ofNullable(getFloatingRateCalculation()).ifPresent(builder::setFloatingRateCalculation);
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestAccrualsMethod _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateCalculation, _that.getFloatingRateCalculation())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateCalculation != null ? floatingRateCalculation.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAccrualsMethod {" +
				"floatingRateCalculation=" + this.floatingRateCalculation + ", " +
				"fixedRate=" + this.fixedRate +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestAccrualsMethod  ***********************/
	class InterestAccrualsMethodBuilderImpl implements InterestAccrualsMethod.InterestAccrualsMethodBuilder {
	
		protected FloatingRateCalculation.FloatingRateCalculationBuilder floatingRateCalculation;
		protected BigDecimal fixedRate;
	
		public InterestAccrualsMethodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("floatingRateCalculation")
		public FloatingRateCalculation.FloatingRateCalculationBuilder getFloatingRateCalculation() {
			return floatingRateCalculation;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder getOrCreateFloatingRateCalculation() {
			FloatingRateCalculation.FloatingRateCalculationBuilder result;
			if (floatingRateCalculation!=null) {
				result = floatingRateCalculation;
			}
			else {
				result = floatingRateCalculation = FloatingRateCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("floatingRateCalculation")
		public InterestAccrualsMethod.InterestAccrualsMethodBuilder setFloatingRateCalculation(FloatingRateCalculation floatingRateCalculation) {
			this.floatingRateCalculation = floatingRateCalculation==null?null:floatingRateCalculation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedRate")
		public InterestAccrualsMethod.InterestAccrualsMethodBuilder setFixedRate(BigDecimal fixedRate) {
			this.fixedRate = fixedRate==null?null:fixedRate;
			return this;
		}
		
		@Override
		public InterestAccrualsMethod build() {
			return new InterestAccrualsMethod.InterestAccrualsMethodImpl(this);
		}
		
		@Override
		public InterestAccrualsMethod.InterestAccrualsMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAccrualsMethod.InterestAccrualsMethodBuilder prune() {
			if (floatingRateCalculation!=null && !floatingRateCalculation.prune().hasData()) floatingRateCalculation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFloatingRateCalculation()!=null && getFloatingRateCalculation().hasData()) return true;
			if (getFixedRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAccrualsMethod.InterestAccrualsMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestAccrualsMethod.InterestAccrualsMethodBuilder o = (InterestAccrualsMethod.InterestAccrualsMethodBuilder) other;
			
			merger.mergeRosetta(getFloatingRateCalculation(), o.getFloatingRateCalculation(), this::setFloatingRateCalculation);
			
			merger.mergeBasic(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestAccrualsMethod _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateCalculation, _that.getFloatingRateCalculation())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateCalculation != null ? floatingRateCalculation.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAccrualsMethodBuilder {" +
				"floatingRateCalculation=" + this.floatingRateCalculation + ", " +
				"fixedRate=" + this.fixedRate +
			'}';
		}
	}
}
