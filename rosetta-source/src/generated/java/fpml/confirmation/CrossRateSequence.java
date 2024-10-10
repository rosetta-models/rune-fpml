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
import fpml.confirmation.CrossRateSequence;
import fpml.confirmation.CrossRateSequence.CrossRateSequenceBuilder;
import fpml.confirmation.CrossRateSequence.CrossRateSequenceBuilderImpl;
import fpml.confirmation.CrossRateSequence.CrossRateSequenceImpl;
import fpml.confirmation.meta.CrossRateSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CrossRateSequence", builder=CrossRateSequence.CrossRateSequenceBuilderImpl.class, version="${project.version}")
public interface CrossRateSequence extends RosettaModelObject {

	CrossRateSequenceMeta metaData = new CrossRateSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An optional element used for FX forwards and certain types of FX OTC options. For deals consumated in the FX Forwards Market, this represents the current market rate for a particular currency pair.
	 */
	BigDecimal getSpotRate();
	/**
	 * An optional element used for deals consumated in the FX Forwards market. Forward points represent the interest rate differential between the two currencies traded and are quoted as a preminum or a discount. Forward points are added to, or subtracted from, the spot rate to create the rate of the forward trade.
	 */
	BigDecimal getForwardPoints();

	/*********************** Build Methods  ***********************/
	CrossRateSequence build();
	
	CrossRateSequence.CrossRateSequenceBuilder toBuilder();
	
	static CrossRateSequence.CrossRateSequenceBuilder builder() {
		return new CrossRateSequence.CrossRateSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CrossRateSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CrossRateSequence> getType() {
		return CrossRateSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processor.processBasic(path.newSubPath("forwardPoints"), BigDecimal.class, getForwardPoints(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CrossRateSequenceBuilder extends CrossRateSequence, RosettaModelObjectBuilder {
		CrossRateSequence.CrossRateSequenceBuilder setSpotRate(BigDecimal spotRate);
		CrossRateSequence.CrossRateSequenceBuilder setForwardPoints(BigDecimal forwardPoints);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processor.processBasic(path.newSubPath("forwardPoints"), BigDecimal.class, getForwardPoints(), this);
		}
		

		CrossRateSequence.CrossRateSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CrossRateSequence  ***********************/
	class CrossRateSequenceImpl implements CrossRateSequence {
		private final BigDecimal spotRate;
		private final BigDecimal forwardPoints;
		
		protected CrossRateSequenceImpl(CrossRateSequence.CrossRateSequenceBuilder builder) {
			this.spotRate = builder.getSpotRate();
			this.forwardPoints = builder.getForwardPoints();
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("forwardPoints")
		public BigDecimal getForwardPoints() {
			return forwardPoints;
		}
		
		@Override
		public CrossRateSequence build() {
			return this;
		}
		
		@Override
		public CrossRateSequence.CrossRateSequenceBuilder toBuilder() {
			CrossRateSequence.CrossRateSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CrossRateSequence.CrossRateSequenceBuilder builder) {
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getForwardPoints()).ifPresent(builder::setForwardPoints);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CrossRateSequence _that = getType().cast(o);
		
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(forwardPoints, _that.getForwardPoints())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (forwardPoints != null ? forwardPoints.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CrossRateSequence {" +
				"spotRate=" + this.spotRate + ", " +
				"forwardPoints=" + this.forwardPoints +
			'}';
		}
	}

	/*********************** Builder Implementation of CrossRateSequence  ***********************/
	class CrossRateSequenceBuilderImpl implements CrossRateSequence.CrossRateSequenceBuilder {
	
		protected BigDecimal spotRate;
		protected BigDecimal forwardPoints;
	
		public CrossRateSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("forwardPoints")
		public BigDecimal getForwardPoints() {
			return forwardPoints;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public CrossRateSequence.CrossRateSequenceBuilder setSpotRate(BigDecimal spotRate) {
			this.spotRate = spotRate==null?null:spotRate;
			return this;
		}
		@Override
		@RosettaAttribute("forwardPoints")
		public CrossRateSequence.CrossRateSequenceBuilder setForwardPoints(BigDecimal forwardPoints) {
			this.forwardPoints = forwardPoints==null?null:forwardPoints;
			return this;
		}
		
		@Override
		public CrossRateSequence build() {
			return new CrossRateSequence.CrossRateSequenceImpl(this);
		}
		
		@Override
		public CrossRateSequence.CrossRateSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CrossRateSequence.CrossRateSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSpotRate()!=null) return true;
			if (getForwardPoints()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CrossRateSequence.CrossRateSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CrossRateSequence.CrossRateSequenceBuilder o = (CrossRateSequence.CrossRateSequenceBuilder) other;
			
			
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			merger.mergeBasic(getForwardPoints(), o.getForwardPoints(), this::setForwardPoints);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CrossRateSequence _that = getType().cast(o);
		
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(forwardPoints, _that.getForwardPoints())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (forwardPoints != null ? forwardPoints.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CrossRateSequenceBuilder {" +
				"spotRate=" + this.spotRate + ", " +
				"forwardPoints=" + this.forwardPoints +
			'}';
		}
	}
}
