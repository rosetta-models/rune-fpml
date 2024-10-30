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
import fpml.confirmation.FxStrikePrice;
import fpml.confirmation.FxStrikePrice.FxStrikePriceBuilder;
import fpml.confirmation.FxStrikePrice.FxStrikePriceBuilderImpl;
import fpml.confirmation.FxStrikePrice.FxStrikePriceImpl;
import fpml.confirmation.StrikeQuoteBasisEnum;
import fpml.confirmation.meta.FxStrikePriceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that describes the rate of exchange at which the option has been struck.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxStrikePrice", builder=FxStrikePrice.FxStrikePriceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxStrikePrice extends RosettaModelObject {

	FxStrikePriceMeta metaData = new FxStrikePriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The rate of exchange between the two currencies of the leg of a deal.
	 */
	BigDecimal getRate();
	/**
	 * The method by which the strike rate is quoted.
	 */
	StrikeQuoteBasisEnum getStrikeQuoteBasis();

	/*********************** Build Methods  ***********************/
	FxStrikePrice build();
	
	FxStrikePrice.FxStrikePriceBuilder toBuilder();
	
	static FxStrikePrice.FxStrikePriceBuilder builder() {
		return new FxStrikePrice.FxStrikePriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxStrikePrice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxStrikePrice> getType() {
		return FxStrikePrice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processor.processBasic(path.newSubPath("strikeQuoteBasis"), StrikeQuoteBasisEnum.class, getStrikeQuoteBasis(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxStrikePriceBuilder extends FxStrikePrice, RosettaModelObjectBuilder {
		FxStrikePrice.FxStrikePriceBuilder setRate(BigDecimal rate);
		FxStrikePrice.FxStrikePriceBuilder setStrikeQuoteBasis(StrikeQuoteBasisEnum strikeQuoteBasis);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processor.processBasic(path.newSubPath("strikeQuoteBasis"), StrikeQuoteBasisEnum.class, getStrikeQuoteBasis(), this);
		}
		

		FxStrikePrice.FxStrikePriceBuilder prune();
	}

	/*********************** Immutable Implementation of FxStrikePrice  ***********************/
	class FxStrikePriceImpl implements FxStrikePrice {
		private final BigDecimal rate;
		private final StrikeQuoteBasisEnum strikeQuoteBasis;
		
		protected FxStrikePriceImpl(FxStrikePrice.FxStrikePriceBuilder builder) {
			this.rate = builder.getRate();
			this.strikeQuoteBasis = builder.getStrikeQuoteBasis();
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("strikeQuoteBasis")
		public StrikeQuoteBasisEnum getStrikeQuoteBasis() {
			return strikeQuoteBasis;
		}
		
		@Override
		public FxStrikePrice build() {
			return this;
		}
		
		@Override
		public FxStrikePrice.FxStrikePriceBuilder toBuilder() {
			FxStrikePrice.FxStrikePriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxStrikePrice.FxStrikePriceBuilder builder) {
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getStrikeQuoteBasis()).ifPresent(builder::setStrikeQuoteBasis);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxStrikePrice _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(strikeQuoteBasis, _that.getStrikeQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (strikeQuoteBasis != null ? strikeQuoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxStrikePrice {" +
				"rate=" + this.rate + ", " +
				"strikeQuoteBasis=" + this.strikeQuoteBasis +
			'}';
		}
	}

	/*********************** Builder Implementation of FxStrikePrice  ***********************/
	class FxStrikePriceBuilderImpl implements FxStrikePrice.FxStrikePriceBuilder {
	
		protected BigDecimal rate;
		protected StrikeQuoteBasisEnum strikeQuoteBasis;
	
		public FxStrikePriceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("strikeQuoteBasis")
		public StrikeQuoteBasisEnum getStrikeQuoteBasis() {
			return strikeQuoteBasis;
		}
		
		@Override
		@RosettaAttribute("rate")
		public FxStrikePrice.FxStrikePriceBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		@Override
		@RosettaAttribute("strikeQuoteBasis")
		public FxStrikePrice.FxStrikePriceBuilder setStrikeQuoteBasis(StrikeQuoteBasisEnum strikeQuoteBasis) {
			this.strikeQuoteBasis = strikeQuoteBasis==null?null:strikeQuoteBasis;
			return this;
		}
		
		@Override
		public FxStrikePrice build() {
			return new FxStrikePrice.FxStrikePriceImpl(this);
		}
		
		@Override
		public FxStrikePrice.FxStrikePriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxStrikePrice.FxStrikePriceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRate()!=null) return true;
			if (getStrikeQuoteBasis()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxStrikePrice.FxStrikePriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxStrikePrice.FxStrikePriceBuilder o = (FxStrikePrice.FxStrikePriceBuilder) other;
			
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			merger.mergeBasic(getStrikeQuoteBasis(), o.getStrikeQuoteBasis(), this::setStrikeQuoteBasis);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxStrikePrice _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(strikeQuoteBasis, _that.getStrikeQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (strikeQuoteBasis != null ? strikeQuoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxStrikePriceBuilder {" +
				"rate=" + this.rate + ", " +
				"strikeQuoteBasis=" + this.strikeQuoteBasis +
			'}';
		}
	}
}
