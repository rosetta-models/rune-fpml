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
import fpml.confirmation.FixedRateAccrualSequence;
import fpml.confirmation.FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder;
import fpml.confirmation.FixedRateAccrualSequence.FixedRateAccrualSequenceBuilderImpl;
import fpml.confirmation.FixedRateAccrualSequence.FixedRateAccrualSequenceImpl;
import fpml.confirmation.meta.FixedRateAccrualSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FixedRateAccrualSequence", builder=FixedRateAccrualSequence.FixedRateAccrualSequenceBuilderImpl.class, version="${project.version}")
public interface FixedRateAccrualSequence extends RosettaModelObject {

	FixedRateAccrualSequenceMeta metaData = new FixedRateAccrualSequenceMeta();

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
	FixedRateAccrualSequence build();
	
	FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder toBuilder();
	
	static FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder builder() {
		return new FixedRateAccrualSequence.FixedRateAccrualSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedRateAccrualSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FixedRateAccrualSequence> getType() {
		return FixedRateAccrualSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("penaltySpread"), BigDecimal.class, getPenaltySpread(), this);
		processor.processBasic(path.newSubPath("defaultSpread"), BigDecimal.class, getDefaultSpread(), this);
		processor.processBasic(path.newSubPath("mandatoryCostRate"), BigDecimal.class, getMandatoryCostRate(), this);
		processor.processBasic(path.newSubPath("allInRate"), BigDecimal.class, getAllInRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FixedRateAccrualSequenceBuilder extends FixedRateAccrualSequence, RosettaModelObjectBuilder {
		FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder setPenaltySpread(BigDecimal penaltySpread);
		FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder setDefaultSpread(BigDecimal defaultSpread);
		FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder setMandatoryCostRate(BigDecimal mandatoryCostRate);
		FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder setAllInRate(BigDecimal allInRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("penaltySpread"), BigDecimal.class, getPenaltySpread(), this);
			processor.processBasic(path.newSubPath("defaultSpread"), BigDecimal.class, getDefaultSpread(), this);
			processor.processBasic(path.newSubPath("mandatoryCostRate"), BigDecimal.class, getMandatoryCostRate(), this);
			processor.processBasic(path.newSubPath("allInRate"), BigDecimal.class, getAllInRate(), this);
		}
		

		FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FixedRateAccrualSequence  ***********************/
	class FixedRateAccrualSequenceImpl implements FixedRateAccrualSequence {
		private final BigDecimal penaltySpread;
		private final BigDecimal defaultSpread;
		private final BigDecimal mandatoryCostRate;
		private final BigDecimal allInRate;
		
		protected FixedRateAccrualSequenceImpl(FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder builder) {
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
		public FixedRateAccrualSequence build() {
			return this;
		}
		
		@Override
		public FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder toBuilder() {
			FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder builder) {
			ofNullable(getPenaltySpread()).ifPresent(builder::setPenaltySpread);
			ofNullable(getDefaultSpread()).ifPresent(builder::setDefaultSpread);
			ofNullable(getMandatoryCostRate()).ifPresent(builder::setMandatoryCostRate);
			ofNullable(getAllInRate()).ifPresent(builder::setAllInRate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FixedRateAccrualSequence _that = getType().cast(o);
		
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
			return "FixedRateAccrualSequence {" +
				"penaltySpread=" + this.penaltySpread + ", " +
				"defaultSpread=" + this.defaultSpread + ", " +
				"mandatoryCostRate=" + this.mandatoryCostRate + ", " +
				"allInRate=" + this.allInRate +
			'}';
		}
	}

	/*********************** Builder Implementation of FixedRateAccrualSequence  ***********************/
	class FixedRateAccrualSequenceBuilderImpl implements FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder {
	
		protected BigDecimal penaltySpread;
		protected BigDecimal defaultSpread;
		protected BigDecimal mandatoryCostRate;
		protected BigDecimal allInRate;
	
		public FixedRateAccrualSequenceBuilderImpl() {
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
		public FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder setPenaltySpread(BigDecimal penaltySpread) {
			this.penaltySpread = penaltySpread==null?null:penaltySpread;
			return this;
		}
		@Override
		@RosettaAttribute("defaultSpread")
		public FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder setDefaultSpread(BigDecimal defaultSpread) {
			this.defaultSpread = defaultSpread==null?null:defaultSpread;
			return this;
		}
		@Override
		@RosettaAttribute("mandatoryCostRate")
		public FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder setMandatoryCostRate(BigDecimal mandatoryCostRate) {
			this.mandatoryCostRate = mandatoryCostRate==null?null:mandatoryCostRate;
			return this;
		}
		@Override
		@RosettaAttribute("allInRate")
		public FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder setAllInRate(BigDecimal allInRate) {
			this.allInRate = allInRate==null?null:allInRate;
			return this;
		}
		
		@Override
		public FixedRateAccrualSequence build() {
			return new FixedRateAccrualSequence.FixedRateAccrualSequenceImpl(this);
		}
		
		@Override
		public FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder prune() {
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
		public FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder o = (FixedRateAccrualSequence.FixedRateAccrualSequenceBuilder) other;
			
			
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
		
			FixedRateAccrualSequence _that = getType().cast(o);
		
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
			return "FixedRateAccrualSequenceBuilder {" +
				"penaltySpread=" + this.penaltySpread + ", " +
				"defaultSpread=" + this.defaultSpread + ", " +
				"mandatoryCostRate=" + this.mandatoryCostRate + ", " +
				"allInRate=" + this.allInRate +
			'}';
		}
	}
}
