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
import fpml.confirmation.DualCurrencyStrikePrice;
import fpml.confirmation.DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder;
import fpml.confirmation.DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilderImpl;
import fpml.confirmation.DualCurrencyStrikePrice.DualCurrencyStrikePriceImpl;
import fpml.confirmation.DualCurrencyStrikeQuoteBasisEnum;
import fpml.confirmation.meta.DualCurrencyStrikePriceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that describes the rate of exchange at which the embedded option in a Dual Currency Deposit has been struck.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="DualCurrencyStrikePrice", builder=DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface DualCurrencyStrikePrice extends RosettaModelObject {

	DualCurrencyStrikePriceMeta metaData = new DualCurrencyStrikePriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The rate of exchange between the two currencies of the leg of a deal.
	 */
	BigDecimal getRate();
	/**
	 * The method by which the strike rate is quoted, in terms of the deposit (principal) and alternate currencies.
	 */
	DualCurrencyStrikeQuoteBasisEnum getStrikeQuoteBasis();

	/*********************** Build Methods  ***********************/
	DualCurrencyStrikePrice build();
	
	DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder toBuilder();
	
	static DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder builder() {
		return new DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DualCurrencyStrikePrice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DualCurrencyStrikePrice> getType() {
		return DualCurrencyStrikePrice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processor.processBasic(path.newSubPath("strikeQuoteBasis"), DualCurrencyStrikeQuoteBasisEnum.class, getStrikeQuoteBasis(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DualCurrencyStrikePriceBuilder extends DualCurrencyStrikePrice, RosettaModelObjectBuilder {
		DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder setRate(BigDecimal rate);
		DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder setStrikeQuoteBasis(DualCurrencyStrikeQuoteBasisEnum strikeQuoteBasis);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processor.processBasic(path.newSubPath("strikeQuoteBasis"), DualCurrencyStrikeQuoteBasisEnum.class, getStrikeQuoteBasis(), this);
		}
		

		DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder prune();
	}

	/*********************** Immutable Implementation of DualCurrencyStrikePrice  ***********************/
	class DualCurrencyStrikePriceImpl implements DualCurrencyStrikePrice {
		private final BigDecimal rate;
		private final DualCurrencyStrikeQuoteBasisEnum strikeQuoteBasis;
		
		protected DualCurrencyStrikePriceImpl(DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder builder) {
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
		public DualCurrencyStrikeQuoteBasisEnum getStrikeQuoteBasis() {
			return strikeQuoteBasis;
		}
		
		@Override
		public DualCurrencyStrikePrice build() {
			return this;
		}
		
		@Override
		public DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder toBuilder() {
			DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder builder) {
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getStrikeQuoteBasis()).ifPresent(builder::setStrikeQuoteBasis);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DualCurrencyStrikePrice _that = getType().cast(o);
		
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
			return "DualCurrencyStrikePrice {" +
				"rate=" + this.rate + ", " +
				"strikeQuoteBasis=" + this.strikeQuoteBasis +
			'}';
		}
	}

	/*********************** Builder Implementation of DualCurrencyStrikePrice  ***********************/
	class DualCurrencyStrikePriceBuilderImpl implements DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder {
	
		protected BigDecimal rate;
		protected DualCurrencyStrikeQuoteBasisEnum strikeQuoteBasis;
	
		public DualCurrencyStrikePriceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("strikeQuoteBasis")
		public DualCurrencyStrikeQuoteBasisEnum getStrikeQuoteBasis() {
			return strikeQuoteBasis;
		}
		
		@Override
		@RosettaAttribute("rate")
		public DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		@Override
		@RosettaAttribute("strikeQuoteBasis")
		public DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder setStrikeQuoteBasis(DualCurrencyStrikeQuoteBasisEnum strikeQuoteBasis) {
			this.strikeQuoteBasis = strikeQuoteBasis==null?null:strikeQuoteBasis;
			return this;
		}
		
		@Override
		public DualCurrencyStrikePrice build() {
			return new DualCurrencyStrikePrice.DualCurrencyStrikePriceImpl(this);
		}
		
		@Override
		public DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder prune() {
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
		public DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder o = (DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder) other;
			
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			merger.mergeBasic(getStrikeQuoteBasis(), o.getStrikeQuoteBasis(), this::setStrikeQuoteBasis);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DualCurrencyStrikePrice _that = getType().cast(o);
		
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
			return "DualCurrencyStrikePriceBuilder {" +
				"rate=" + this.rate + ", " +
				"strikeQuoteBasis=" + this.strikeQuoteBasis +
			'}';
		}
	}
}
