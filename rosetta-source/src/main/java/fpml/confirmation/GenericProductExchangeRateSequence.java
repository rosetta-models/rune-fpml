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
import fpml.confirmation.GenericProductExchangeRateSequence;
import fpml.confirmation.GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder;
import fpml.confirmation.GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilderImpl;
import fpml.confirmation.GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceImpl;
import fpml.confirmation.GenericProductExchangeRateSequenceSequence;
import fpml.confirmation.meta.GenericProductExchangeRateSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="GenericProductExchangeRateSequence", builder=GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface GenericProductExchangeRateSequence extends RosettaModelObject {

	GenericProductExchangeRateSequenceMeta metaData = new GenericProductExchangeRateSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An element used for FX forwards and certain types of FX OTC options. For deals consumated in the FX Forwards Market, this represents the current market rate for a particular currency pair. For barrier and digital/binary options, it can be useful to include the spot rate at the time the option was executed to make it easier to know whether the option needs to move &quot;up&quot; or &quot;down&quot; to be triggered.
	 */
	BigDecimal getSpotRate();
	GenericProductExchangeRateSequenceSequence getGenericProductExchangeRateSequenceSequence();

	/*********************** Build Methods  ***********************/
	GenericProductExchangeRateSequence build();
	
	GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder toBuilder();
	
	static GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder builder() {
		return new GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericProductExchangeRateSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GenericProductExchangeRateSequence> getType() {
		return GenericProductExchangeRateSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processRosetta(path.newSubPath("genericProductExchangeRateSequenceSequence"), processor, GenericProductExchangeRateSequenceSequence.class, getGenericProductExchangeRateSequenceSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericProductExchangeRateSequenceBuilder extends GenericProductExchangeRateSequence, RosettaModelObjectBuilder {
		GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder getOrCreateGenericProductExchangeRateSequenceSequence();
		GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder getGenericProductExchangeRateSequenceSequence();
		GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder setSpotRate(BigDecimal spotRate);
		GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder setGenericProductExchangeRateSequenceSequence(GenericProductExchangeRateSequenceSequence genericProductExchangeRateSequenceSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processRosetta(path.newSubPath("genericProductExchangeRateSequenceSequence"), processor, GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder.class, getGenericProductExchangeRateSequenceSequence());
		}
		

		GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of GenericProductExchangeRateSequence  ***********************/
	class GenericProductExchangeRateSequenceImpl implements GenericProductExchangeRateSequence {
		private final BigDecimal spotRate;
		private final GenericProductExchangeRateSequenceSequence genericProductExchangeRateSequenceSequence;
		
		protected GenericProductExchangeRateSequenceImpl(GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder builder) {
			this.spotRate = builder.getSpotRate();
			this.genericProductExchangeRateSequenceSequence = ofNullable(builder.getGenericProductExchangeRateSequenceSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("genericProductExchangeRateSequenceSequence")
		public GenericProductExchangeRateSequenceSequence getGenericProductExchangeRateSequenceSequence() {
			return genericProductExchangeRateSequenceSequence;
		}
		
		@Override
		public GenericProductExchangeRateSequence build() {
			return this;
		}
		
		@Override
		public GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder toBuilder() {
			GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder builder) {
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getGenericProductExchangeRateSequenceSequence()).ifPresent(builder::setGenericProductExchangeRateSequenceSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericProductExchangeRateSequence _that = getType().cast(o);
		
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(genericProductExchangeRateSequenceSequence, _that.getGenericProductExchangeRateSequenceSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (genericProductExchangeRateSequenceSequence != null ? genericProductExchangeRateSequenceSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericProductExchangeRateSequence {" +
				"spotRate=" + this.spotRate + ", " +
				"genericProductExchangeRateSequenceSequence=" + this.genericProductExchangeRateSequenceSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericProductExchangeRateSequence  ***********************/
	class GenericProductExchangeRateSequenceBuilderImpl implements GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder {
	
		protected BigDecimal spotRate;
		protected GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder genericProductExchangeRateSequenceSequence;
	
		public GenericProductExchangeRateSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("genericProductExchangeRateSequenceSequence")
		public GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder getGenericProductExchangeRateSequenceSequence() {
			return genericProductExchangeRateSequenceSequence;
		}
		
		@Override
		public GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder getOrCreateGenericProductExchangeRateSequenceSequence() {
			GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder result;
			if (genericProductExchangeRateSequenceSequence!=null) {
				result = genericProductExchangeRateSequenceSequence;
			}
			else {
				result = genericProductExchangeRateSequenceSequence = GenericProductExchangeRateSequenceSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder setSpotRate(BigDecimal spotRate) {
			this.spotRate = spotRate==null?null:spotRate;
			return this;
		}
		@Override
		@RosettaAttribute("genericProductExchangeRateSequenceSequence")
		public GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder setGenericProductExchangeRateSequenceSequence(GenericProductExchangeRateSequenceSequence genericProductExchangeRateSequenceSequence) {
			this.genericProductExchangeRateSequenceSequence = genericProductExchangeRateSequenceSequence==null?null:genericProductExchangeRateSequenceSequence.toBuilder();
			return this;
		}
		
		@Override
		public GenericProductExchangeRateSequence build() {
			return new GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceImpl(this);
		}
		
		@Override
		public GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder prune() {
			if (genericProductExchangeRateSequenceSequence!=null && !genericProductExchangeRateSequenceSequence.prune().hasData()) genericProductExchangeRateSequenceSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSpotRate()!=null) return true;
			if (getGenericProductExchangeRateSequenceSequence()!=null && getGenericProductExchangeRateSequenceSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder o = (GenericProductExchangeRateSequence.GenericProductExchangeRateSequenceBuilder) other;
			
			merger.mergeRosetta(getGenericProductExchangeRateSequenceSequence(), o.getGenericProductExchangeRateSequenceSequence(), this::setGenericProductExchangeRateSequenceSequence);
			
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericProductExchangeRateSequence _that = getType().cast(o);
		
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(genericProductExchangeRateSequenceSequence, _that.getGenericProductExchangeRateSequenceSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (genericProductExchangeRateSequenceSequence != null ? genericProductExchangeRateSequenceSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericProductExchangeRateSequenceBuilder {" +
				"spotRate=" + this.spotRate + ", " +
				"genericProductExchangeRateSequenceSequence=" + this.genericProductExchangeRateSequenceSequence +
			'}';
		}
	}
}
