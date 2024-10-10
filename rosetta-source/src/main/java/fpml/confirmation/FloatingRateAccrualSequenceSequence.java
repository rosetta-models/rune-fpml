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
import fpml.confirmation.FloatingRateAccrualSequenceSequence;
import fpml.confirmation.FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder;
import fpml.confirmation.FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilderImpl;
import fpml.confirmation.FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceImpl;
import fpml.confirmation.meta.FloatingRateAccrualSequenceSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingRateAccrualSequenceSequence", builder=FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilderImpl.class, version="${project.version}")
public interface FloatingRateAccrualSequenceSequence extends RosettaModelObject {

	FloatingRateAccrualSequenceSequenceMeta metaData = new FloatingRateAccrualSequenceSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The penalty spread currently applied to the interest rate period.
	 */
	BigDecimal getPenaltySpread();
	/**
	 * The default spread currently applied to the interest rate period.
	 */
	BigDecimal getDefaultSpread();
	/**
	 * The mandatory cost rate currently applied to the interest rate period.
	 */
	BigDecimal getMandatoryCostRate();
	/**
	 * The actual percentage rate charged to the borrower. (Base Rate + Spread + Default Rate + Penalty Rate + Mandatory Cost Rate) = All In Rate. This rate NEVER includes PIK.
	 */
	BigDecimal getAllInRate();

	/*********************** Build Methods  ***********************/
	FloatingRateAccrualSequenceSequence build();
	
	FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder toBuilder();
	
	static FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder builder() {
		return new FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateAccrualSequenceSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingRateAccrualSequenceSequence> getType() {
		return FloatingRateAccrualSequenceSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("penaltySpread"), BigDecimal.class, getPenaltySpread(), this);
		processor.processBasic(path.newSubPath("defaultSpread"), BigDecimal.class, getDefaultSpread(), this);
		processor.processBasic(path.newSubPath("mandatoryCostRate"), BigDecimal.class, getMandatoryCostRate(), this);
		processor.processBasic(path.newSubPath("allInRate"), BigDecimal.class, getAllInRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateAccrualSequenceSequenceBuilder extends FloatingRateAccrualSequenceSequence, RosettaModelObjectBuilder {
		FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder setPenaltySpread(BigDecimal penaltySpread);
		FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder setDefaultSpread(BigDecimal defaultSpread);
		FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder setMandatoryCostRate(BigDecimal mandatoryCostRate);
		FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder setAllInRate(BigDecimal allInRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("penaltySpread"), BigDecimal.class, getPenaltySpread(), this);
			processor.processBasic(path.newSubPath("defaultSpread"), BigDecimal.class, getDefaultSpread(), this);
			processor.processBasic(path.newSubPath("mandatoryCostRate"), BigDecimal.class, getMandatoryCostRate(), this);
			processor.processBasic(path.newSubPath("allInRate"), BigDecimal.class, getAllInRate(), this);
		}
		

		FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateAccrualSequenceSequence  ***********************/
	class FloatingRateAccrualSequenceSequenceImpl implements FloatingRateAccrualSequenceSequence {
		private final BigDecimal penaltySpread;
		private final BigDecimal defaultSpread;
		private final BigDecimal mandatoryCostRate;
		private final BigDecimal allInRate;
		
		protected FloatingRateAccrualSequenceSequenceImpl(FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder builder) {
			this.penaltySpread = builder.getPenaltySpread();
			this.defaultSpread = builder.getDefaultSpread();
			this.mandatoryCostRate = builder.getMandatoryCostRate();
			this.allInRate = builder.getAllInRate();
		}
		
		@Override
		@RosettaAttribute("penaltySpread")
		public BigDecimal getPenaltySpread() {
			return penaltySpread;
		}
		
		@Override
		@RosettaAttribute("defaultSpread")
		public BigDecimal getDefaultSpread() {
			return defaultSpread;
		}
		
		@Override
		@RosettaAttribute("mandatoryCostRate")
		public BigDecimal getMandatoryCostRate() {
			return mandatoryCostRate;
		}
		
		@Override
		@RosettaAttribute("allInRate")
		public BigDecimal getAllInRate() {
			return allInRate;
		}
		
		@Override
		public FloatingRateAccrualSequenceSequence build() {
			return this;
		}
		
		@Override
		public FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder toBuilder() {
			FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder builder) {
			ofNullable(getPenaltySpread()).ifPresent(builder::setPenaltySpread);
			ofNullable(getDefaultSpread()).ifPresent(builder::setDefaultSpread);
			ofNullable(getMandatoryCostRate()).ifPresent(builder::setMandatoryCostRate);
			ofNullable(getAllInRate()).ifPresent(builder::setAllInRate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateAccrualSequenceSequence _that = getType().cast(o);
		
			if (!Objects.equals(penaltySpread, _that.getPenaltySpread())) return false;
			if (!Objects.equals(defaultSpread, _that.getDefaultSpread())) return false;
			if (!Objects.equals(mandatoryCostRate, _that.getMandatoryCostRate())) return false;
			if (!Objects.equals(allInRate, _that.getAllInRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (penaltySpread != null ? penaltySpread.hashCode() : 0);
			_result = 31 * _result + (defaultSpread != null ? defaultSpread.hashCode() : 0);
			_result = 31 * _result + (mandatoryCostRate != null ? mandatoryCostRate.hashCode() : 0);
			_result = 31 * _result + (allInRate != null ? allInRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateAccrualSequenceSequence {" +
				"penaltySpread=" + this.penaltySpread + ", " +
				"defaultSpread=" + this.defaultSpread + ", " +
				"mandatoryCostRate=" + this.mandatoryCostRate + ", " +
				"allInRate=" + this.allInRate +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateAccrualSequenceSequence  ***********************/
	class FloatingRateAccrualSequenceSequenceBuilderImpl implements FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder {
	
		protected BigDecimal penaltySpread;
		protected BigDecimal defaultSpread;
		protected BigDecimal mandatoryCostRate;
		protected BigDecimal allInRate;
	
		public FloatingRateAccrualSequenceSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("penaltySpread")
		public BigDecimal getPenaltySpread() {
			return penaltySpread;
		}
		
		@Override
		@RosettaAttribute("defaultSpread")
		public BigDecimal getDefaultSpread() {
			return defaultSpread;
		}
		
		@Override
		@RosettaAttribute("mandatoryCostRate")
		public BigDecimal getMandatoryCostRate() {
			return mandatoryCostRate;
		}
		
		@Override
		@RosettaAttribute("allInRate")
		public BigDecimal getAllInRate() {
			return allInRate;
		}
		
		@Override
		@RosettaAttribute("penaltySpread")
		public FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder setPenaltySpread(BigDecimal penaltySpread) {
			this.penaltySpread = penaltySpread==null?null:penaltySpread;
			return this;
		}
		@Override
		@RosettaAttribute("defaultSpread")
		public FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder setDefaultSpread(BigDecimal defaultSpread) {
			this.defaultSpread = defaultSpread==null?null:defaultSpread;
			return this;
		}
		@Override
		@RosettaAttribute("mandatoryCostRate")
		public FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder setMandatoryCostRate(BigDecimal mandatoryCostRate) {
			this.mandatoryCostRate = mandatoryCostRate==null?null:mandatoryCostRate;
			return this;
		}
		@Override
		@RosettaAttribute("allInRate")
		public FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder setAllInRate(BigDecimal allInRate) {
			this.allInRate = allInRate==null?null:allInRate;
			return this;
		}
		
		@Override
		public FloatingRateAccrualSequenceSequence build() {
			return new FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceImpl(this);
		}
		
		@Override
		public FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPenaltySpread()!=null) return true;
			if (getDefaultSpread()!=null) return true;
			if (getMandatoryCostRate()!=null) return true;
			if (getAllInRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder o = (FloatingRateAccrualSequenceSequence.FloatingRateAccrualSequenceSequenceBuilder) other;
			
			
			merger.mergeBasic(getPenaltySpread(), o.getPenaltySpread(), this::setPenaltySpread);
			merger.mergeBasic(getDefaultSpread(), o.getDefaultSpread(), this::setDefaultSpread);
			merger.mergeBasic(getMandatoryCostRate(), o.getMandatoryCostRate(), this::setMandatoryCostRate);
			merger.mergeBasic(getAllInRate(), o.getAllInRate(), this::setAllInRate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateAccrualSequenceSequence _that = getType().cast(o);
		
			if (!Objects.equals(penaltySpread, _that.getPenaltySpread())) return false;
			if (!Objects.equals(defaultSpread, _that.getDefaultSpread())) return false;
			if (!Objects.equals(mandatoryCostRate, _that.getMandatoryCostRate())) return false;
			if (!Objects.equals(allInRate, _that.getAllInRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (penaltySpread != null ? penaltySpread.hashCode() : 0);
			_result = 31 * _result + (defaultSpread != null ? defaultSpread.hashCode() : 0);
			_result = 31 * _result + (mandatoryCostRate != null ? mandatoryCostRate.hashCode() : 0);
			_result = 31 * _result + (allInRate != null ? allInRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateAccrualSequenceSequenceBuilder {" +
				"penaltySpread=" + this.penaltySpread + ", " +
				"defaultSpread=" + this.defaultSpread + ", " +
				"mandatoryCostRate=" + this.mandatoryCostRate + ", " +
				"allInRate=" + this.allInRate +
			'}';
		}
	}
}
