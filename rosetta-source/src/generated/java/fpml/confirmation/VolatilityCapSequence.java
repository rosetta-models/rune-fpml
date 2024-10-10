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
import fpml.confirmation.VolatilityCapSequence;
import fpml.confirmation.VolatilityCapSequence.VolatilityCapSequenceBuilder;
import fpml.confirmation.VolatilityCapSequence.VolatilityCapSequenceBuilderImpl;
import fpml.confirmation.VolatilityCapSequence.VolatilityCapSequenceImpl;
import fpml.confirmation.meta.VolatilityCapSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="VolatilityCapSequence", builder=VolatilityCapSequence.VolatilityCapSequenceBuilderImpl.class, version="${project.version}")
public interface VolatilityCapSequence extends RosettaModelObject {

	VolatilityCapSequenceMeta metaData = new VolatilityCapSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Volatility Cap Factor in accordance with the ISDA 2011 Equity Derivatives Definitions. This means the Volatility Cap Amount election is Calculated VolCapAmt (&#39;volatilityCapFactor&#39; * &#39;volatilityStrikePrice&#39;). By specifying a decimal for &#39;volatilityCapFactor&#39;, means the default value of 2.5 does not apply.
	 */
	BigDecimal getVolatilityCapFactor();
	/**
	 * Volatility Cap Amount in accordance with the ISDA 2011 Equity Derivatives Definitions. The Calculated VolCapAmt can be optionally provided.
	 */
	BigDecimal getTotalVolatilityCap();

	/*********************** Build Methods  ***********************/
	VolatilityCapSequence build();
	
	VolatilityCapSequence.VolatilityCapSequenceBuilder toBuilder();
	
	static VolatilityCapSequence.VolatilityCapSequenceBuilder builder() {
		return new VolatilityCapSequence.VolatilityCapSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VolatilityCapSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VolatilityCapSequence> getType() {
		return VolatilityCapSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("volatilityCapFactor"), BigDecimal.class, getVolatilityCapFactor(), this);
		processor.processBasic(path.newSubPath("totalVolatilityCap"), BigDecimal.class, getTotalVolatilityCap(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface VolatilityCapSequenceBuilder extends VolatilityCapSequence, RosettaModelObjectBuilder {
		VolatilityCapSequence.VolatilityCapSequenceBuilder setVolatilityCapFactor(BigDecimal volatilityCapFactor);
		VolatilityCapSequence.VolatilityCapSequenceBuilder setTotalVolatilityCap(BigDecimal totalVolatilityCap);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("volatilityCapFactor"), BigDecimal.class, getVolatilityCapFactor(), this);
			processor.processBasic(path.newSubPath("totalVolatilityCap"), BigDecimal.class, getTotalVolatilityCap(), this);
		}
		

		VolatilityCapSequence.VolatilityCapSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of VolatilityCapSequence  ***********************/
	class VolatilityCapSequenceImpl implements VolatilityCapSequence {
		private final BigDecimal volatilityCapFactor;
		private final BigDecimal totalVolatilityCap;
		
		protected VolatilityCapSequenceImpl(VolatilityCapSequence.VolatilityCapSequenceBuilder builder) {
			this.volatilityCapFactor = builder.getVolatilityCapFactor();
			this.totalVolatilityCap = builder.getTotalVolatilityCap();
		}
		
		@Override
		@RosettaAttribute("volatilityCapFactor")
		public BigDecimal getVolatilityCapFactor() {
			return volatilityCapFactor;
		}
		
		@Override
		@RosettaAttribute("totalVolatilityCap")
		public BigDecimal getTotalVolatilityCap() {
			return totalVolatilityCap;
		}
		
		@Override
		public VolatilityCapSequence build() {
			return this;
		}
		
		@Override
		public VolatilityCapSequence.VolatilityCapSequenceBuilder toBuilder() {
			VolatilityCapSequence.VolatilityCapSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VolatilityCapSequence.VolatilityCapSequenceBuilder builder) {
			ofNullable(getVolatilityCapFactor()).ifPresent(builder::setVolatilityCapFactor);
			ofNullable(getTotalVolatilityCap()).ifPresent(builder::setTotalVolatilityCap);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VolatilityCapSequence _that = getType().cast(o);
		
			if (!Objects.equals(volatilityCapFactor, _that.getVolatilityCapFactor())) return false;
			if (!Objects.equals(totalVolatilityCap, _that.getTotalVolatilityCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (volatilityCapFactor != null ? volatilityCapFactor.hashCode() : 0);
			_result = 31 * _result + (totalVolatilityCap != null ? totalVolatilityCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityCapSequence {" +
				"volatilityCapFactor=" + this.volatilityCapFactor + ", " +
				"totalVolatilityCap=" + this.totalVolatilityCap +
			'}';
		}
	}

	/*********************** Builder Implementation of VolatilityCapSequence  ***********************/
	class VolatilityCapSequenceBuilderImpl implements VolatilityCapSequence.VolatilityCapSequenceBuilder {
	
		protected BigDecimal volatilityCapFactor;
		protected BigDecimal totalVolatilityCap;
	
		public VolatilityCapSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("volatilityCapFactor")
		public BigDecimal getVolatilityCapFactor() {
			return volatilityCapFactor;
		}
		
		@Override
		@RosettaAttribute("totalVolatilityCap")
		public BigDecimal getTotalVolatilityCap() {
			return totalVolatilityCap;
		}
		
		@Override
		@RosettaAttribute("volatilityCapFactor")
		public VolatilityCapSequence.VolatilityCapSequenceBuilder setVolatilityCapFactor(BigDecimal volatilityCapFactor) {
			this.volatilityCapFactor = volatilityCapFactor==null?null:volatilityCapFactor;
			return this;
		}
		@Override
		@RosettaAttribute("totalVolatilityCap")
		public VolatilityCapSequence.VolatilityCapSequenceBuilder setTotalVolatilityCap(BigDecimal totalVolatilityCap) {
			this.totalVolatilityCap = totalVolatilityCap==null?null:totalVolatilityCap;
			return this;
		}
		
		@Override
		public VolatilityCapSequence build() {
			return new VolatilityCapSequence.VolatilityCapSequenceImpl(this);
		}
		
		@Override
		public VolatilityCapSequence.VolatilityCapSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityCapSequence.VolatilityCapSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getVolatilityCapFactor()!=null) return true;
			if (getTotalVolatilityCap()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityCapSequence.VolatilityCapSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			VolatilityCapSequence.VolatilityCapSequenceBuilder o = (VolatilityCapSequence.VolatilityCapSequenceBuilder) other;
			
			
			merger.mergeBasic(getVolatilityCapFactor(), o.getVolatilityCapFactor(), this::setVolatilityCapFactor);
			merger.mergeBasic(getTotalVolatilityCap(), o.getTotalVolatilityCap(), this::setTotalVolatilityCap);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VolatilityCapSequence _that = getType().cast(o);
		
			if (!Objects.equals(volatilityCapFactor, _that.getVolatilityCapFactor())) return false;
			if (!Objects.equals(totalVolatilityCap, _that.getTotalVolatilityCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (volatilityCapFactor != null ? volatilityCapFactor.hashCode() : 0);
			_result = 31 * _result + (totalVolatilityCap != null ? totalVolatilityCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityCapSequenceBuilder {" +
				"volatilityCapFactor=" + this.volatilityCapFactor + ", " +
				"totalVolatilityCap=" + this.totalVolatilityCap +
			'}';
		}
	}
}
