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
import fpml.confirmation.DividendPayoutSequence;
import fpml.confirmation.DividendPayoutSequence.DividendPayoutSequenceBuilder;
import fpml.confirmation.DividendPayoutSequence.DividendPayoutSequenceBuilderImpl;
import fpml.confirmation.DividendPayoutSequence.DividendPayoutSequenceImpl;
import fpml.confirmation.meta.DividendPayoutSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="DividendPayoutSequence", builder=DividendPayoutSequence.DividendPayoutSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface DividendPayoutSequence extends RosettaModelObject {

	DividendPayoutSequenceMeta metaData = new DividendPayoutSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the total actual dividend payout ratio associated with the equity underlyer.
	 */
	BigDecimal getDividendPayoutRatio();
	/**
	 * Specifies the cash actual dividend payout ratio associated with the equity underlyer.
	 */
	BigDecimal getDividendPayoutRatioCash();
	/**
	 * Specifies the non cash actual dividend payout ratio associated with the equity underlyer.
	 */
	BigDecimal getDividendPayoutRatioNonCash();

	/*********************** Build Methods  ***********************/
	DividendPayoutSequence build();
	
	DividendPayoutSequence.DividendPayoutSequenceBuilder toBuilder();
	
	static DividendPayoutSequence.DividendPayoutSequenceBuilder builder() {
		return new DividendPayoutSequence.DividendPayoutSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendPayoutSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DividendPayoutSequence> getType() {
		return DividendPayoutSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dividendPayoutRatio"), BigDecimal.class, getDividendPayoutRatio(), this);
		processor.processBasic(path.newSubPath("dividendPayoutRatioCash"), BigDecimal.class, getDividendPayoutRatioCash(), this);
		processor.processBasic(path.newSubPath("dividendPayoutRatioNonCash"), BigDecimal.class, getDividendPayoutRatioNonCash(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendPayoutSequenceBuilder extends DividendPayoutSequence, RosettaModelObjectBuilder {
		DividendPayoutSequence.DividendPayoutSequenceBuilder setDividendPayoutRatio(BigDecimal dividendPayoutRatio);
		DividendPayoutSequence.DividendPayoutSequenceBuilder setDividendPayoutRatioCash(BigDecimal dividendPayoutRatioCash);
		DividendPayoutSequence.DividendPayoutSequenceBuilder setDividendPayoutRatioNonCash(BigDecimal dividendPayoutRatioNonCash);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("dividendPayoutRatio"), BigDecimal.class, getDividendPayoutRatio(), this);
			processor.processBasic(path.newSubPath("dividendPayoutRatioCash"), BigDecimal.class, getDividendPayoutRatioCash(), this);
			processor.processBasic(path.newSubPath("dividendPayoutRatioNonCash"), BigDecimal.class, getDividendPayoutRatioNonCash(), this);
		}
		

		DividendPayoutSequence.DividendPayoutSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of DividendPayoutSequence  ***********************/
	class DividendPayoutSequenceImpl implements DividendPayoutSequence {
		private final BigDecimal dividendPayoutRatio;
		private final BigDecimal dividendPayoutRatioCash;
		private final BigDecimal dividendPayoutRatioNonCash;
		
		protected DividendPayoutSequenceImpl(DividendPayoutSequence.DividendPayoutSequenceBuilder builder) {
			this.dividendPayoutRatio = builder.getDividendPayoutRatio();
			this.dividendPayoutRatioCash = builder.getDividendPayoutRatioCash();
			this.dividendPayoutRatioNonCash = builder.getDividendPayoutRatioNonCash();
		}
		
		@Override
		@RosettaAttribute("dividendPayoutRatio")
		public BigDecimal getDividendPayoutRatio() {
			return dividendPayoutRatio;
		}
		
		@Override
		@RosettaAttribute("dividendPayoutRatioCash")
		public BigDecimal getDividendPayoutRatioCash() {
			return dividendPayoutRatioCash;
		}
		
		@Override
		@RosettaAttribute("dividendPayoutRatioNonCash")
		public BigDecimal getDividendPayoutRatioNonCash() {
			return dividendPayoutRatioNonCash;
		}
		
		@Override
		public DividendPayoutSequence build() {
			return this;
		}
		
		@Override
		public DividendPayoutSequence.DividendPayoutSequenceBuilder toBuilder() {
			DividendPayoutSequence.DividendPayoutSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendPayoutSequence.DividendPayoutSequenceBuilder builder) {
			ofNullable(getDividendPayoutRatio()).ifPresent(builder::setDividendPayoutRatio);
			ofNullable(getDividendPayoutRatioCash()).ifPresent(builder::setDividendPayoutRatioCash);
			ofNullable(getDividendPayoutRatioNonCash()).ifPresent(builder::setDividendPayoutRatioNonCash);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPayoutSequence _that = getType().cast(o);
		
			if (!Objects.equals(dividendPayoutRatio, _that.getDividendPayoutRatio())) return false;
			if (!Objects.equals(dividendPayoutRatioCash, _that.getDividendPayoutRatioCash())) return false;
			if (!Objects.equals(dividendPayoutRatioNonCash, _that.getDividendPayoutRatioNonCash())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendPayoutRatio != null ? dividendPayoutRatio.hashCode() : 0);
			_result = 31 * _result + (dividendPayoutRatioCash != null ? dividendPayoutRatioCash.hashCode() : 0);
			_result = 31 * _result + (dividendPayoutRatioNonCash != null ? dividendPayoutRatioNonCash.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPayoutSequence {" +
				"dividendPayoutRatio=" + this.dividendPayoutRatio + ", " +
				"dividendPayoutRatioCash=" + this.dividendPayoutRatioCash + ", " +
				"dividendPayoutRatioNonCash=" + this.dividendPayoutRatioNonCash +
			'}';
		}
	}

	/*********************** Builder Implementation of DividendPayoutSequence  ***********************/
	class DividendPayoutSequenceBuilderImpl implements DividendPayoutSequence.DividendPayoutSequenceBuilder {
	
		protected BigDecimal dividendPayoutRatio;
		protected BigDecimal dividendPayoutRatioCash;
		protected BigDecimal dividendPayoutRatioNonCash;
	
		public DividendPayoutSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dividendPayoutRatio")
		public BigDecimal getDividendPayoutRatio() {
			return dividendPayoutRatio;
		}
		
		@Override
		@RosettaAttribute("dividendPayoutRatioCash")
		public BigDecimal getDividendPayoutRatioCash() {
			return dividendPayoutRatioCash;
		}
		
		@Override
		@RosettaAttribute("dividendPayoutRatioNonCash")
		public BigDecimal getDividendPayoutRatioNonCash() {
			return dividendPayoutRatioNonCash;
		}
		
		@Override
		@RosettaAttribute("dividendPayoutRatio")
		public DividendPayoutSequence.DividendPayoutSequenceBuilder setDividendPayoutRatio(BigDecimal dividendPayoutRatio) {
			this.dividendPayoutRatio = dividendPayoutRatio==null?null:dividendPayoutRatio;
			return this;
		}
		@Override
		@RosettaAttribute("dividendPayoutRatioCash")
		public DividendPayoutSequence.DividendPayoutSequenceBuilder setDividendPayoutRatioCash(BigDecimal dividendPayoutRatioCash) {
			this.dividendPayoutRatioCash = dividendPayoutRatioCash==null?null:dividendPayoutRatioCash;
			return this;
		}
		@Override
		@RosettaAttribute("dividendPayoutRatioNonCash")
		public DividendPayoutSequence.DividendPayoutSequenceBuilder setDividendPayoutRatioNonCash(BigDecimal dividendPayoutRatioNonCash) {
			this.dividendPayoutRatioNonCash = dividendPayoutRatioNonCash==null?null:dividendPayoutRatioNonCash;
			return this;
		}
		
		@Override
		public DividendPayoutSequence build() {
			return new DividendPayoutSequence.DividendPayoutSequenceImpl(this);
		}
		
		@Override
		public DividendPayoutSequence.DividendPayoutSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPayoutSequence.DividendPayoutSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDividendPayoutRatio()!=null) return true;
			if (getDividendPayoutRatioCash()!=null) return true;
			if (getDividendPayoutRatioNonCash()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPayoutSequence.DividendPayoutSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendPayoutSequence.DividendPayoutSequenceBuilder o = (DividendPayoutSequence.DividendPayoutSequenceBuilder) other;
			
			
			merger.mergeBasic(getDividendPayoutRatio(), o.getDividendPayoutRatio(), this::setDividendPayoutRatio);
			merger.mergeBasic(getDividendPayoutRatioCash(), o.getDividendPayoutRatioCash(), this::setDividendPayoutRatioCash);
			merger.mergeBasic(getDividendPayoutRatioNonCash(), o.getDividendPayoutRatioNonCash(), this::setDividendPayoutRatioNonCash);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPayoutSequence _that = getType().cast(o);
		
			if (!Objects.equals(dividendPayoutRatio, _that.getDividendPayoutRatio())) return false;
			if (!Objects.equals(dividendPayoutRatioCash, _that.getDividendPayoutRatioCash())) return false;
			if (!Objects.equals(dividendPayoutRatioNonCash, _that.getDividendPayoutRatioNonCash())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendPayoutRatio != null ? dividendPayoutRatio.hashCode() : 0);
			_result = 31 * _result + (dividendPayoutRatioCash != null ? dividendPayoutRatioCash.hashCode() : 0);
			_result = 31 * _result + (dividendPayoutRatioNonCash != null ? dividendPayoutRatioNonCash.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPayoutSequenceBuilder {" +
				"dividendPayoutRatio=" + this.dividendPayoutRatio + ", " +
				"dividendPayoutRatioCash=" + this.dividendPayoutRatioCash + ", " +
				"dividendPayoutRatioNonCash=" + this.dividendPayoutRatioNonCash +
			'}';
		}
	}
}
