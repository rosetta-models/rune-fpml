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
import fpml.confirmation.ExchangeRateSequence;
import fpml.confirmation.ExchangeRateSequence.ExchangeRateSequenceBuilder;
import fpml.confirmation.ExchangeRateSequence.ExchangeRateSequenceBuilderImpl;
import fpml.confirmation.ExchangeRateSequence.ExchangeRateSequenceImpl;
import fpml.confirmation.ExchangeRateSequenceSequence;
import fpml.confirmation.meta.ExchangeRateSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ExchangeRateSequence", builder=ExchangeRateSequence.ExchangeRateSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ExchangeRateSequence extends RosettaModelObject {

	ExchangeRateSequenceMeta metaData = new ExchangeRateSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An element used for FX forwards and certain types of FX OTC options. For deals consumated in the FX Forwards Market, this represents the current market rate for a particular currency pair. For barrier and digital/binary options, it can be useful to include the spot rate at the time the option was executed to make it easier to know whether the option needs to move &quot;up&quot; or &quot;down&quot; to be triggered.
	 */
	BigDecimal getSpotRate();
	ExchangeRateSequenceSequence getExchangeRateSequenceSequence();

	/*********************** Build Methods  ***********************/
	ExchangeRateSequence build();
	
	ExchangeRateSequence.ExchangeRateSequenceBuilder toBuilder();
	
	static ExchangeRateSequence.ExchangeRateSequenceBuilder builder() {
		return new ExchangeRateSequence.ExchangeRateSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeRateSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExchangeRateSequence> getType() {
		return ExchangeRateSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processRosetta(path.newSubPath("exchangeRateSequenceSequence"), processor, ExchangeRateSequenceSequence.class, getExchangeRateSequenceSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExchangeRateSequenceBuilder extends ExchangeRateSequence, RosettaModelObjectBuilder {
		ExchangeRateSequenceSequence.ExchangeRateSequenceSequenceBuilder getOrCreateExchangeRateSequenceSequence();
		ExchangeRateSequenceSequence.ExchangeRateSequenceSequenceBuilder getExchangeRateSequenceSequence();
		ExchangeRateSequence.ExchangeRateSequenceBuilder setSpotRate(BigDecimal spotRate);
		ExchangeRateSequence.ExchangeRateSequenceBuilder setExchangeRateSequenceSequence(ExchangeRateSequenceSequence exchangeRateSequenceSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processRosetta(path.newSubPath("exchangeRateSequenceSequence"), processor, ExchangeRateSequenceSequence.ExchangeRateSequenceSequenceBuilder.class, getExchangeRateSequenceSequence());
		}
		

		ExchangeRateSequence.ExchangeRateSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeRateSequence  ***********************/
	class ExchangeRateSequenceImpl implements ExchangeRateSequence {
		private final BigDecimal spotRate;
		private final ExchangeRateSequenceSequence exchangeRateSequenceSequence;
		
		protected ExchangeRateSequenceImpl(ExchangeRateSequence.ExchangeRateSequenceBuilder builder) {
			this.spotRate = builder.getSpotRate();
			this.exchangeRateSequenceSequence = ofNullable(builder.getExchangeRateSequenceSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("exchangeRateSequenceSequence")
		public ExchangeRateSequenceSequence getExchangeRateSequenceSequence() {
			return exchangeRateSequenceSequence;
		}
		
		@Override
		public ExchangeRateSequence build() {
			return this;
		}
		
		@Override
		public ExchangeRateSequence.ExchangeRateSequenceBuilder toBuilder() {
			ExchangeRateSequence.ExchangeRateSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeRateSequence.ExchangeRateSequenceBuilder builder) {
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getExchangeRateSequenceSequence()).ifPresent(builder::setExchangeRateSequenceSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeRateSequence _that = getType().cast(o);
		
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(exchangeRateSequenceSequence, _that.getExchangeRateSequenceSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (exchangeRateSequenceSequence != null ? exchangeRateSequenceSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeRateSequence {" +
				"spotRate=" + this.spotRate + ", " +
				"exchangeRateSequenceSequence=" + this.exchangeRateSequenceSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of ExchangeRateSequence  ***********************/
	class ExchangeRateSequenceBuilderImpl implements ExchangeRateSequence.ExchangeRateSequenceBuilder {
	
		protected BigDecimal spotRate;
		protected ExchangeRateSequenceSequence.ExchangeRateSequenceSequenceBuilder exchangeRateSequenceSequence;
	
		public ExchangeRateSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("exchangeRateSequenceSequence")
		public ExchangeRateSequenceSequence.ExchangeRateSequenceSequenceBuilder getExchangeRateSequenceSequence() {
			return exchangeRateSequenceSequence;
		}
		
		@Override
		public ExchangeRateSequenceSequence.ExchangeRateSequenceSequenceBuilder getOrCreateExchangeRateSequenceSequence() {
			ExchangeRateSequenceSequence.ExchangeRateSequenceSequenceBuilder result;
			if (exchangeRateSequenceSequence!=null) {
				result = exchangeRateSequenceSequence;
			}
			else {
				result = exchangeRateSequenceSequence = ExchangeRateSequenceSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public ExchangeRateSequence.ExchangeRateSequenceBuilder setSpotRate(BigDecimal spotRate) {
			this.spotRate = spotRate==null?null:spotRate;
			return this;
		}
		@Override
		@RosettaAttribute("exchangeRateSequenceSequence")
		public ExchangeRateSequence.ExchangeRateSequenceBuilder setExchangeRateSequenceSequence(ExchangeRateSequenceSequence exchangeRateSequenceSequence) {
			this.exchangeRateSequenceSequence = exchangeRateSequenceSequence==null?null:exchangeRateSequenceSequence.toBuilder();
			return this;
		}
		
		@Override
		public ExchangeRateSequence build() {
			return new ExchangeRateSequence.ExchangeRateSequenceImpl(this);
		}
		
		@Override
		public ExchangeRateSequence.ExchangeRateSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeRateSequence.ExchangeRateSequenceBuilder prune() {
			if (exchangeRateSequenceSequence!=null && !exchangeRateSequenceSequence.prune().hasData()) exchangeRateSequenceSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSpotRate()!=null) return true;
			if (getExchangeRateSequenceSequence()!=null && getExchangeRateSequenceSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeRateSequence.ExchangeRateSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExchangeRateSequence.ExchangeRateSequenceBuilder o = (ExchangeRateSequence.ExchangeRateSequenceBuilder) other;
			
			merger.mergeRosetta(getExchangeRateSequenceSequence(), o.getExchangeRateSequenceSequence(), this::setExchangeRateSequenceSequence);
			
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeRateSequence _that = getType().cast(o);
		
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(exchangeRateSequenceSequence, _that.getExchangeRateSequenceSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (exchangeRateSequenceSequence != null ? exchangeRateSequenceSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeRateSequenceBuilder {" +
				"spotRate=" + this.spotRate + ", " +
				"exchangeRateSequenceSequence=" + this.exchangeRateSequenceSequence +
			'}';
		}
	}
}
