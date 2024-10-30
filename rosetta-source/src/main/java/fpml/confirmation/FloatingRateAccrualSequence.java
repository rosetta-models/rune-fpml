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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.FloatingRateAccrualSequence;
import fpml.confirmation.FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder;
import fpml.confirmation.FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilderImpl;
import fpml.confirmation.FloatingRateAccrualSequence.FloatingRateAccrualSequenceImpl;
import fpml.confirmation.FloatingRateAccrualSequenceSequence;
import fpml.confirmation.meta.FloatingRateAccrualSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FloatingRateAccrualSequence", builder=FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FloatingRateAccrualSequence extends RosettaModelObject {

	FloatingRateAccrualSequenceMeta metaData = new FloatingRateAccrualSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which the underlying interest rate is fixed. It is an actual (adjusted) date. Note: This should default to the effective date of the loan contract in the case of a PRIME base rate.
	 */
	Date getRateFixingDate();
	/**
	 * The actual underlying base rate associated with the period, defined as a percentage.
	 */
	BigDecimal getBaseRate();
	FloatingRateAccrualSequenceSequence getFloatingRateAccrualSequenceSequence();

	/*********************** Build Methods  ***********************/
	FloatingRateAccrualSequence build();
	
	FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder toBuilder();
	
	static FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder builder() {
		return new FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateAccrualSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingRateAccrualSequence> getType() {
		return FloatingRateAccrualSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rateFixingDate"), Date.class, getRateFixingDate(), this);
		processor.processBasic(path.newSubPath("baseRate"), BigDecimal.class, getBaseRate(), this);
		processRosetta(path.newSubPath("floatingRateAccrualSequenceSequence"), processor, FloatingRateAccrualSequenceSequence.class, getFloatingRateAccrualSequenceSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateAccrualSequenceBuilder extends FloatingRateAccrualSequence, RosettaModelObjectBuilder {
		FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder getOrCreateFloatingRateAccrualSequenceSequence();
		FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder getFloatingRateAccrualSequenceSequence();
		FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder setRateFixingDate(Date rateFixingDate);
		FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder setBaseRate(BigDecimal baseRate);
		FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder setFloatingRateAccrualSequenceSequence(FloatingRateAccrualSequenceSequence floatingRateAccrualSequenceSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("rateFixingDate"), Date.class, getRateFixingDate(), this);
			processor.processBasic(path.newSubPath("baseRate"), BigDecimal.class, getBaseRate(), this);
			processRosetta(path.newSubPath("floatingRateAccrualSequenceSequence"), processor, FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder.class, getFloatingRateAccrualSequenceSequence());
		}
		

		FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateAccrualSequence  ***********************/
	class FloatingRateAccrualSequenceImpl implements FloatingRateAccrualSequence {
		private final Date rateFixingDate;
		private final BigDecimal baseRate;
		private final FloatingRateAccrualSequenceSequence floatingRateAccrualSequenceSequence;
		
		protected FloatingRateAccrualSequenceImpl(FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder builder) {
			this.rateFixingDate = builder.getRateFixingDate();
			this.baseRate = builder.getBaseRate();
			this.floatingRateAccrualSequenceSequence = ofNullable(builder.getFloatingRateAccrualSequenceSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rateFixingDate")
		public Date getRateFixingDate() {
			return rateFixingDate;
		}
		
		@Override
		@RosettaAttribute("baseRate")
		public BigDecimal getBaseRate() {
			return baseRate;
		}
		
		@Override
		@RosettaAttribute("floatingRateAccrualSequenceSequence")
		public FloatingRateAccrualSequenceSequence getFloatingRateAccrualSequenceSequence() {
			return floatingRateAccrualSequenceSequence;
		}
		
		@Override
		public FloatingRateAccrualSequence build() {
			return this;
		}
		
		@Override
		public FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder toBuilder() {
			FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder builder) {
			ofNullable(getRateFixingDate()).ifPresent(builder::setRateFixingDate);
			ofNullable(getBaseRate()).ifPresent(builder::setBaseRate);
			ofNullable(getFloatingRateAccrualSequenceSequence()).ifPresent(builder::setFloatingRateAccrualSequenceSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateAccrualSequence _that = getType().cast(o);
		
			if (!Objects.equals(rateFixingDate, _that.getRateFixingDate())) return false;
			if (!Objects.equals(baseRate, _that.getBaseRate())) return false;
			if (!Objects.equals(floatingRateAccrualSequenceSequence, _that.getFloatingRateAccrualSequenceSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rateFixingDate != null ? rateFixingDate.hashCode() : 0);
			_result = 31 * _result + (baseRate != null ? baseRate.hashCode() : 0);
			_result = 31 * _result + (floatingRateAccrualSequenceSequence != null ? floatingRateAccrualSequenceSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateAccrualSequence {" +
				"rateFixingDate=" + this.rateFixingDate + ", " +
				"baseRate=" + this.baseRate + ", " +
				"floatingRateAccrualSequenceSequence=" + this.floatingRateAccrualSequenceSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateAccrualSequence  ***********************/
	class FloatingRateAccrualSequenceBuilderImpl implements FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder {
	
		protected Date rateFixingDate;
		protected BigDecimal baseRate;
		protected FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder floatingRateAccrualSequenceSequence;
	
		public FloatingRateAccrualSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rateFixingDate")
		public Date getRateFixingDate() {
			return rateFixingDate;
		}
		
		@Override
		@RosettaAttribute("baseRate")
		public BigDecimal getBaseRate() {
			return baseRate;
		}
		
		@Override
		@RosettaAttribute("floatingRateAccrualSequenceSequence")
		public FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder getFloatingRateAccrualSequenceSequence() {
			return floatingRateAccrualSequenceSequence;
		}
		
		@Override
		public FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder getOrCreateFloatingRateAccrualSequenceSequence() {
			FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder result;
			if (floatingRateAccrualSequenceSequence!=null) {
				result = floatingRateAccrualSequenceSequence;
			}
			else {
				result = floatingRateAccrualSequenceSequence = FloatingRateAccrualSequenceSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rateFixingDate")
		public FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder setRateFixingDate(Date rateFixingDate) {
			this.rateFixingDate = rateFixingDate==null?null:rateFixingDate;
			return this;
		}
		@Override
		@RosettaAttribute("baseRate")
		public FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder setBaseRate(BigDecimal baseRate) {
			this.baseRate = baseRate==null?null:baseRate;
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateAccrualSequenceSequence")
		public FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder setFloatingRateAccrualSequenceSequence(FloatingRateAccrualSequenceSequence floatingRateAccrualSequenceSequence) {
			this.floatingRateAccrualSequenceSequence = floatingRateAccrualSequenceSequence==null?null:floatingRateAccrualSequenceSequence.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateAccrualSequence build() {
			return new FloatingRateAccrualSequence.FloatingRateAccrualSequenceImpl(this);
		}
		
		@Override
		public FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder prune() {
			if (floatingRateAccrualSequenceSequence!=null && !floatingRateAccrualSequenceSequence.prune().hasData()) floatingRateAccrualSequenceSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRateFixingDate()!=null) return true;
			if (getBaseRate()!=null) return true;
			if (getFloatingRateAccrualSequenceSequence()!=null && getFloatingRateAccrualSequenceSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder o = (FloatingRateAccrualSequence.FloatingRateAccrualSequenceBuilder) other;
			
			merger.mergeRosetta(getFloatingRateAccrualSequenceSequence(), o.getFloatingRateAccrualSequenceSequence(), this::setFloatingRateAccrualSequenceSequence);
			
			merger.mergeBasic(getRateFixingDate(), o.getRateFixingDate(), this::setRateFixingDate);
			merger.mergeBasic(getBaseRate(), o.getBaseRate(), this::setBaseRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateAccrualSequence _that = getType().cast(o);
		
			if (!Objects.equals(rateFixingDate, _that.getRateFixingDate())) return false;
			if (!Objects.equals(baseRate, _that.getBaseRate())) return false;
			if (!Objects.equals(floatingRateAccrualSequenceSequence, _that.getFloatingRateAccrualSequenceSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rateFixingDate != null ? rateFixingDate.hashCode() : 0);
			_result = 31 * _result + (baseRate != null ? baseRate.hashCode() : 0);
			_result = 31 * _result + (floatingRateAccrualSequenceSequence != null ? floatingRateAccrualSequenceSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateAccrualSequenceBuilder {" +
				"rateFixingDate=" + this.rateFixingDate + ", " +
				"baseRate=" + this.baseRate + ", " +
				"floatingRateAccrualSequenceSequence=" + this.floatingRateAccrualSequenceSequence +
			'}';
		}
	}
}
