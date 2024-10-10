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
import fpml.confirmation.VolatilityCap;
import fpml.confirmation.VolatilityCap.VolatilityCapBuilder;
import fpml.confirmation.VolatilityCap.VolatilityCapBuilderImpl;
import fpml.confirmation.VolatilityCap.VolatilityCapImpl;
import fpml.confirmation.VolatilityCapSequence;
import fpml.confirmation.meta.VolatilityCapMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="VolatilityCap", builder=VolatilityCap.VolatilityCapBuilderImpl.class, version="${project.version}")
public interface VolatilityCap extends RosettaModelObject {

	VolatilityCapMeta metaData = new VolatilityCapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates whether the volatility cap is applicable in accordance with the ISDA 2011 Equity Derivatives Definitions. Setting the element &#39;applicable&#39; to &#39;False&#39; - means No Volatility Cap and no &#39;totalVolatilityCap&#39; or &#39;volatilityCapFactor&#39; should be provided. Setting the element &#39;applicable&#39; to &#39;True&#39; - means Volatility Cap election, then &#39;totalVolatilityCap&#39; or &#39;volatilityCapFactor&#39; should be provided, otherwise it defaults to volatilityCapFactor=2.5.
	 */
	Boolean getApplicable();
	/**
	 * Volatility Cap Amount in accordance with the ISDA 2011 Equity Derivatives Definitions. This means the Volatility Cap Amount election is a number.
	 */
	BigDecimal getTotalVolatilityCap();
	VolatilityCapSequence getVolatilityCapSequence();

	/*********************** Build Methods  ***********************/
	VolatilityCap build();
	
	VolatilityCap.VolatilityCapBuilder toBuilder();
	
	static VolatilityCap.VolatilityCapBuilder builder() {
		return new VolatilityCap.VolatilityCapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VolatilityCap> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VolatilityCap> getType() {
		return VolatilityCap.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
		processor.processBasic(path.newSubPath("totalVolatilityCap"), BigDecimal.class, getTotalVolatilityCap(), this);
		processRosetta(path.newSubPath("volatilityCapSequence"), processor, VolatilityCapSequence.class, getVolatilityCapSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VolatilityCapBuilder extends VolatilityCap, RosettaModelObjectBuilder {
		VolatilityCapSequence.VolatilityCapSequenceBuilder getOrCreateVolatilityCapSequence();
		VolatilityCapSequence.VolatilityCapSequenceBuilder getVolatilityCapSequence();
		VolatilityCap.VolatilityCapBuilder setApplicable(Boolean applicable);
		VolatilityCap.VolatilityCapBuilder setTotalVolatilityCap(BigDecimal totalVolatilityCap);
		VolatilityCap.VolatilityCapBuilder setVolatilityCapSequence(VolatilityCapSequence volatilityCapSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
			processor.processBasic(path.newSubPath("totalVolatilityCap"), BigDecimal.class, getTotalVolatilityCap(), this);
			processRosetta(path.newSubPath("volatilityCapSequence"), processor, VolatilityCapSequence.VolatilityCapSequenceBuilder.class, getVolatilityCapSequence());
		}
		

		VolatilityCap.VolatilityCapBuilder prune();
	}

	/*********************** Immutable Implementation of VolatilityCap  ***********************/
	class VolatilityCapImpl implements VolatilityCap {
		private final Boolean applicable;
		private final BigDecimal totalVolatilityCap;
		private final VolatilityCapSequence volatilityCapSequence;
		
		protected VolatilityCapImpl(VolatilityCap.VolatilityCapBuilder builder) {
			this.applicable = builder.getApplicable();
			this.totalVolatilityCap = builder.getTotalVolatilityCap();
			this.volatilityCapSequence = ofNullable(builder.getVolatilityCapSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("totalVolatilityCap")
		public BigDecimal getTotalVolatilityCap() {
			return totalVolatilityCap;
		}
		
		@Override
		@RosettaAttribute("volatilityCapSequence")
		public VolatilityCapSequence getVolatilityCapSequence() {
			return volatilityCapSequence;
		}
		
		@Override
		public VolatilityCap build() {
			return this;
		}
		
		@Override
		public VolatilityCap.VolatilityCapBuilder toBuilder() {
			VolatilityCap.VolatilityCapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VolatilityCap.VolatilityCapBuilder builder) {
			ofNullable(getApplicable()).ifPresent(builder::setApplicable);
			ofNullable(getTotalVolatilityCap()).ifPresent(builder::setTotalVolatilityCap);
			ofNullable(getVolatilityCapSequence()).ifPresent(builder::setVolatilityCapSequence);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VolatilityCap _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(totalVolatilityCap, _that.getTotalVolatilityCap())) return false;
			if (!Objects.equals(volatilityCapSequence, _that.getVolatilityCapSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (totalVolatilityCap != null ? totalVolatilityCap.hashCode() : 0);
			_result = 31 * _result + (volatilityCapSequence != null ? volatilityCapSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityCap {" +
				"applicable=" + this.applicable + ", " +
				"totalVolatilityCap=" + this.totalVolatilityCap + ", " +
				"volatilityCapSequence=" + this.volatilityCapSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of VolatilityCap  ***********************/
	class VolatilityCapBuilderImpl implements VolatilityCap.VolatilityCapBuilder {
	
		protected Boolean applicable;
		protected BigDecimal totalVolatilityCap;
		protected VolatilityCapSequence.VolatilityCapSequenceBuilder volatilityCapSequence;
	
		public VolatilityCapBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("totalVolatilityCap")
		public BigDecimal getTotalVolatilityCap() {
			return totalVolatilityCap;
		}
		
		@Override
		@RosettaAttribute("volatilityCapSequence")
		public VolatilityCapSequence.VolatilityCapSequenceBuilder getVolatilityCapSequence() {
			return volatilityCapSequence;
		}
		
		@Override
		public VolatilityCapSequence.VolatilityCapSequenceBuilder getOrCreateVolatilityCapSequence() {
			VolatilityCapSequence.VolatilityCapSequenceBuilder result;
			if (volatilityCapSequence!=null) {
				result = volatilityCapSequence;
			}
			else {
				result = volatilityCapSequence = VolatilityCapSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("applicable")
		public VolatilityCap.VolatilityCapBuilder setApplicable(Boolean applicable) {
			this.applicable = applicable==null?null:applicable;
			return this;
		}
		@Override
		@RosettaAttribute("totalVolatilityCap")
		public VolatilityCap.VolatilityCapBuilder setTotalVolatilityCap(BigDecimal totalVolatilityCap) {
			this.totalVolatilityCap = totalVolatilityCap==null?null:totalVolatilityCap;
			return this;
		}
		@Override
		@RosettaAttribute("volatilityCapSequence")
		public VolatilityCap.VolatilityCapBuilder setVolatilityCapSequence(VolatilityCapSequence volatilityCapSequence) {
			this.volatilityCapSequence = volatilityCapSequence==null?null:volatilityCapSequence.toBuilder();
			return this;
		}
		
		@Override
		public VolatilityCap build() {
			return new VolatilityCap.VolatilityCapImpl(this);
		}
		
		@Override
		public VolatilityCap.VolatilityCapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityCap.VolatilityCapBuilder prune() {
			if (volatilityCapSequence!=null && !volatilityCapSequence.prune().hasData()) volatilityCapSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicable()!=null) return true;
			if (getTotalVolatilityCap()!=null) return true;
			if (getVolatilityCapSequence()!=null && getVolatilityCapSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityCap.VolatilityCapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			VolatilityCap.VolatilityCapBuilder o = (VolatilityCap.VolatilityCapBuilder) other;
			
			merger.mergeRosetta(getVolatilityCapSequence(), o.getVolatilityCapSequence(), this::setVolatilityCapSequence);
			
			merger.mergeBasic(getApplicable(), o.getApplicable(), this::setApplicable);
			merger.mergeBasic(getTotalVolatilityCap(), o.getTotalVolatilityCap(), this::setTotalVolatilityCap);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VolatilityCap _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(totalVolatilityCap, _that.getTotalVolatilityCap())) return false;
			if (!Objects.equals(volatilityCapSequence, _that.getVolatilityCapSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (totalVolatilityCap != null ? totalVolatilityCap.hashCode() : 0);
			_result = 31 * _result + (volatilityCapSequence != null ? volatilityCapSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityCapBuilder {" +
				"applicable=" + this.applicable + ", " +
				"totalVolatilityCap=" + this.totalVolatilityCap + ", " +
				"volatilityCapSequence=" + this.volatilityCapSequence +
			'}';
		}
	}
}
