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
import fpml.confirmation.OptionNumericStrike;
import fpml.confirmation.OptionNumericStrike.OptionNumericStrikeBuilder;
import fpml.confirmation.OptionNumericStrike.OptionNumericStrikeBuilderImpl;
import fpml.confirmation.OptionNumericStrike.OptionNumericStrikeImpl;
import fpml.confirmation.meta.OptionNumericStrikeMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining the strike price for an option as a numeric value without currency.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="OptionNumericStrike", builder=OptionNumericStrike.OptionNumericStrikeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface OptionNumericStrike extends RosettaModelObject {

	OptionNumericStrikeMeta metaData = new OptionNumericStrikeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The price or level at which the option has been struck.
	 */
	BigDecimal getStrikePrice();
	/**
	 * The price or level expressed as a percentage of the forward starting spot price.
	 */
	BigDecimal getStrikePercentage();

	/*********************** Build Methods  ***********************/
	OptionNumericStrike build();
	
	OptionNumericStrike.OptionNumericStrikeBuilder toBuilder();
	
	static OptionNumericStrike.OptionNumericStrikeBuilder builder() {
		return new OptionNumericStrike.OptionNumericStrikeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionNumericStrike> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionNumericStrike> getType() {
		return OptionNumericStrike.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("strikePrice"), BigDecimal.class, getStrikePrice(), this);
		processor.processBasic(path.newSubPath("strikePercentage"), BigDecimal.class, getStrikePercentage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionNumericStrikeBuilder extends OptionNumericStrike, RosettaModelObjectBuilder {
		OptionNumericStrike.OptionNumericStrikeBuilder setStrikePrice(BigDecimal strikePrice);
		OptionNumericStrike.OptionNumericStrikeBuilder setStrikePercentage(BigDecimal strikePercentage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("strikePrice"), BigDecimal.class, getStrikePrice(), this);
			processor.processBasic(path.newSubPath("strikePercentage"), BigDecimal.class, getStrikePercentage(), this);
		}
		

		OptionNumericStrike.OptionNumericStrikeBuilder prune();
	}

	/*********************** Immutable Implementation of OptionNumericStrike  ***********************/
	class OptionNumericStrikeImpl implements OptionNumericStrike {
		private final BigDecimal strikePrice;
		private final BigDecimal strikePercentage;
		
		protected OptionNumericStrikeImpl(OptionNumericStrike.OptionNumericStrikeBuilder builder) {
			this.strikePrice = builder.getStrikePrice();
			this.strikePercentage = builder.getStrikePercentage();
		}
		
		@Override
		@RosettaAttribute("strikePrice")
		public BigDecimal getStrikePrice() {
			return strikePrice;
		}
		
		@Override
		@RosettaAttribute("strikePercentage")
		public BigDecimal getStrikePercentage() {
			return strikePercentage;
		}
		
		@Override
		public OptionNumericStrike build() {
			return this;
		}
		
		@Override
		public OptionNumericStrike.OptionNumericStrikeBuilder toBuilder() {
			OptionNumericStrike.OptionNumericStrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionNumericStrike.OptionNumericStrikeBuilder builder) {
			ofNullable(getStrikePrice()).ifPresent(builder::setStrikePrice);
			ofNullable(getStrikePercentage()).ifPresent(builder::setStrikePercentage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionNumericStrike _that = getType().cast(o);
		
			if (!Objects.equals(strikePrice, _that.getStrikePrice())) return false;
			if (!Objects.equals(strikePercentage, _that.getStrikePercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strikePrice != null ? strikePrice.hashCode() : 0);
			_result = 31 * _result + (strikePercentage != null ? strikePercentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionNumericStrike {" +
				"strikePrice=" + this.strikePrice + ", " +
				"strikePercentage=" + this.strikePercentage +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionNumericStrike  ***********************/
	class OptionNumericStrikeBuilderImpl implements OptionNumericStrike.OptionNumericStrikeBuilder {
	
		protected BigDecimal strikePrice;
		protected BigDecimal strikePercentage;
	
		public OptionNumericStrikeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strikePrice")
		public BigDecimal getStrikePrice() {
			return strikePrice;
		}
		
		@Override
		@RosettaAttribute("strikePercentage")
		public BigDecimal getStrikePercentage() {
			return strikePercentage;
		}
		
		@Override
		@RosettaAttribute("strikePrice")
		public OptionNumericStrike.OptionNumericStrikeBuilder setStrikePrice(BigDecimal strikePrice) {
			this.strikePrice = strikePrice==null?null:strikePrice;
			return this;
		}
		@Override
		@RosettaAttribute("strikePercentage")
		public OptionNumericStrike.OptionNumericStrikeBuilder setStrikePercentage(BigDecimal strikePercentage) {
			this.strikePercentage = strikePercentage==null?null:strikePercentage;
			return this;
		}
		
		@Override
		public OptionNumericStrike build() {
			return new OptionNumericStrike.OptionNumericStrikeImpl(this);
		}
		
		@Override
		public OptionNumericStrike.OptionNumericStrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionNumericStrike.OptionNumericStrikeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStrikePrice()!=null) return true;
			if (getStrikePercentage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionNumericStrike.OptionNumericStrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionNumericStrike.OptionNumericStrikeBuilder o = (OptionNumericStrike.OptionNumericStrikeBuilder) other;
			
			
			merger.mergeBasic(getStrikePrice(), o.getStrikePrice(), this::setStrikePrice);
			merger.mergeBasic(getStrikePercentage(), o.getStrikePercentage(), this::setStrikePercentage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionNumericStrike _that = getType().cast(o);
		
			if (!Objects.equals(strikePrice, _that.getStrikePrice())) return false;
			if (!Objects.equals(strikePercentage, _that.getStrikePercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strikePrice != null ? strikePrice.hashCode() : 0);
			_result = 31 * _result + (strikePercentage != null ? strikePercentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionNumericStrikeBuilder {" +
				"strikePrice=" + this.strikePrice + ", " +
				"strikePercentage=" + this.strikePercentage +
			'}';
		}
	}
}
