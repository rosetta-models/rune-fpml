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
import fpml.confirmation.GenericProductExchangeRateSequenceSequence;
import fpml.confirmation.GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder;
import fpml.confirmation.GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilderImpl;
import fpml.confirmation.GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceImpl;
import fpml.confirmation.meta.GenericProductExchangeRateSequenceSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="GenericProductExchangeRateSequenceSequence", builder=GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilderImpl.class, version="${project.version}")
public interface GenericProductExchangeRateSequenceSequence extends RosettaModelObject {

	GenericProductExchangeRateSequenceSequenceMeta metaData = new GenericProductExchangeRateSequenceSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An optional element used for deals consumated in the FX Forwards market. Forward points represent the interest rate differential between the two currencies traded and are quoted as a preminum or a discount. Forward points are added to, or subtracted from, the spot rate to create the rate of the forward trade.
	 */
	BigDecimal getForwardPoints();
	/**
	 * An optional element that documents the size of point (pip) in which a rate was quoted (or in this case, forwardPoints are calculated). Point (pip) size varies by currency pair: major currencies are all traded in points of 0.0001, with the exception of JPY which has a point size of 0.01.
	 */
	BigDecimal getPointValue();

	/*********************** Build Methods  ***********************/
	GenericProductExchangeRateSequenceSequence build();
	
	GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder toBuilder();
	
	static GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder builder() {
		return new GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericProductExchangeRateSequenceSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GenericProductExchangeRateSequenceSequence> getType() {
		return GenericProductExchangeRateSequenceSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("forwardPoints"), BigDecimal.class, getForwardPoints(), this);
		processor.processBasic(path.newSubPath("pointValue"), BigDecimal.class, getPointValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericProductExchangeRateSequenceSequenceBuilder extends GenericProductExchangeRateSequenceSequence, RosettaModelObjectBuilder {
		GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder setForwardPoints(BigDecimal forwardPoints);
		GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder setPointValue(BigDecimal pointValue);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("forwardPoints"), BigDecimal.class, getForwardPoints(), this);
			processor.processBasic(path.newSubPath("pointValue"), BigDecimal.class, getPointValue(), this);
		}
		

		GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of GenericProductExchangeRateSequenceSequence  ***********************/
	class GenericProductExchangeRateSequenceSequenceImpl implements GenericProductExchangeRateSequenceSequence {
		private final BigDecimal forwardPoints;
		private final BigDecimal pointValue;
		
		protected GenericProductExchangeRateSequenceSequenceImpl(GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder builder) {
			this.forwardPoints = builder.getForwardPoints();
			this.pointValue = builder.getPointValue();
		}
		
		@Override
		@RosettaAttribute("forwardPoints")
		public BigDecimal getForwardPoints() {
			return forwardPoints;
		}
		
		@Override
		@RosettaAttribute("pointValue")
		public BigDecimal getPointValue() {
			return pointValue;
		}
		
		@Override
		public GenericProductExchangeRateSequenceSequence build() {
			return this;
		}
		
		@Override
		public GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder toBuilder() {
			GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder builder) {
			ofNullable(getForwardPoints()).ifPresent(builder::setForwardPoints);
			ofNullable(getPointValue()).ifPresent(builder::setPointValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericProductExchangeRateSequenceSequence _that = getType().cast(o);
		
			if (!Objects.equals(forwardPoints, _that.getForwardPoints())) return false;
			if (!Objects.equals(pointValue, _that.getPointValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (forwardPoints != null ? forwardPoints.hashCode() : 0);
			_result = 31 * _result + (pointValue != null ? pointValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericProductExchangeRateSequenceSequence {" +
				"forwardPoints=" + this.forwardPoints + ", " +
				"pointValue=" + this.pointValue +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericProductExchangeRateSequenceSequence  ***********************/
	class GenericProductExchangeRateSequenceSequenceBuilderImpl implements GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder {
	
		protected BigDecimal forwardPoints;
		protected BigDecimal pointValue;
	
		public GenericProductExchangeRateSequenceSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("forwardPoints")
		public BigDecimal getForwardPoints() {
			return forwardPoints;
		}
		
		@Override
		@RosettaAttribute("pointValue")
		public BigDecimal getPointValue() {
			return pointValue;
		}
		
		@Override
		@RosettaAttribute("forwardPoints")
		public GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder setForwardPoints(BigDecimal forwardPoints) {
			this.forwardPoints = forwardPoints==null?null:forwardPoints;
			return this;
		}
		@Override
		@RosettaAttribute("pointValue")
		public GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder setPointValue(BigDecimal pointValue) {
			this.pointValue = pointValue==null?null:pointValue;
			return this;
		}
		
		@Override
		public GenericProductExchangeRateSequenceSequence build() {
			return new GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceImpl(this);
		}
		
		@Override
		public GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getForwardPoints()!=null) return true;
			if (getPointValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder o = (GenericProductExchangeRateSequenceSequence.GenericProductExchangeRateSequenceSequenceBuilder) other;
			
			
			merger.mergeBasic(getForwardPoints(), o.getForwardPoints(), this::setForwardPoints);
			merger.mergeBasic(getPointValue(), o.getPointValue(), this::setPointValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericProductExchangeRateSequenceSequence _that = getType().cast(o);
		
			if (!Objects.equals(forwardPoints, _that.getForwardPoints())) return false;
			if (!Objects.equals(pointValue, _that.getPointValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (forwardPoints != null ? forwardPoints.hashCode() : 0);
			_result = 31 * _result + (pointValue != null ? pointValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericProductExchangeRateSequenceSequenceBuilder {" +
				"forwardPoints=" + this.forwardPoints + ", " +
				"pointValue=" + this.pointValue +
			'}';
		}
	}
}
