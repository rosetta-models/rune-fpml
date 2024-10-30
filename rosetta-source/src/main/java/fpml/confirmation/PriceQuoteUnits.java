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
import fpml.confirmation.PriceQuoteUnits;
import fpml.confirmation.PriceQuoteUnits.PriceQuoteUnitsBuilder;
import fpml.confirmation.PriceQuoteUnits.PriceQuoteUnitsBuilderImpl;
import fpml.confirmation.PriceQuoteUnits.PriceQuoteUnitsImpl;
import fpml.confirmation.meta.PriceQuoteUnitsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PriceQuoteUnits", builder=PriceQuoteUnits.PriceQuoteUnitsBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PriceQuoteUnits extends RosettaModelObject {

	PriceQuoteUnitsMeta metaData = new PriceQuoteUnitsMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getPriceQuoteUnitsScheme();

	/*********************** Build Methods  ***********************/
	PriceQuoteUnits build();
	
	PriceQuoteUnits.PriceQuoteUnitsBuilder toBuilder();
	
	static PriceQuoteUnits.PriceQuoteUnitsBuilder builder() {
		return new PriceQuoteUnits.PriceQuoteUnitsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PriceQuoteUnits> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PriceQuoteUnits> getType() {
		return PriceQuoteUnits.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("priceQuoteUnitsScheme"), String.class, getPriceQuoteUnitsScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PriceQuoteUnitsBuilder extends PriceQuoteUnits, RosettaModelObjectBuilder {
		PriceQuoteUnits.PriceQuoteUnitsBuilder setValue(String value);
		PriceQuoteUnits.PriceQuoteUnitsBuilder setPriceQuoteUnitsScheme(String priceQuoteUnitsScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("priceQuoteUnitsScheme"), String.class, getPriceQuoteUnitsScheme(), this);
		}
		

		PriceQuoteUnits.PriceQuoteUnitsBuilder prune();
	}

	/*********************** Immutable Implementation of PriceQuoteUnits  ***********************/
	class PriceQuoteUnitsImpl implements PriceQuoteUnits {
		private final String value;
		private final String priceQuoteUnitsScheme;
		
		protected PriceQuoteUnitsImpl(PriceQuoteUnits.PriceQuoteUnitsBuilder builder) {
			this.value = builder.getValue();
			this.priceQuoteUnitsScheme = builder.getPriceQuoteUnitsScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("priceQuoteUnitsScheme")
		public String getPriceQuoteUnitsScheme() {
			return priceQuoteUnitsScheme;
		}
		
		@Override
		public PriceQuoteUnits build() {
			return this;
		}
		
		@Override
		public PriceQuoteUnits.PriceQuoteUnitsBuilder toBuilder() {
			PriceQuoteUnits.PriceQuoteUnitsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PriceQuoteUnits.PriceQuoteUnitsBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPriceQuoteUnitsScheme()).ifPresent(builder::setPriceQuoteUnitsScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceQuoteUnits _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(priceQuoteUnitsScheme, _that.getPriceQuoteUnitsScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (priceQuoteUnitsScheme != null ? priceQuoteUnitsScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceQuoteUnits {" +
				"value=" + this.value + ", " +
				"priceQuoteUnitsScheme=" + this.priceQuoteUnitsScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PriceQuoteUnits  ***********************/
	class PriceQuoteUnitsBuilderImpl implements PriceQuoteUnits.PriceQuoteUnitsBuilder {
	
		protected String value;
		protected String priceQuoteUnitsScheme;
	
		public PriceQuoteUnitsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("priceQuoteUnitsScheme")
		public String getPriceQuoteUnitsScheme() {
			return priceQuoteUnitsScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public PriceQuoteUnits.PriceQuoteUnitsBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("priceQuoteUnitsScheme")
		public PriceQuoteUnits.PriceQuoteUnitsBuilder setPriceQuoteUnitsScheme(String priceQuoteUnitsScheme) {
			this.priceQuoteUnitsScheme = priceQuoteUnitsScheme==null?null:priceQuoteUnitsScheme;
			return this;
		}
		
		@Override
		public PriceQuoteUnits build() {
			return new PriceQuoteUnits.PriceQuoteUnitsImpl(this);
		}
		
		@Override
		public PriceQuoteUnits.PriceQuoteUnitsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceQuoteUnits.PriceQuoteUnitsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPriceQuoteUnitsScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceQuoteUnits.PriceQuoteUnitsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PriceQuoteUnits.PriceQuoteUnitsBuilder o = (PriceQuoteUnits.PriceQuoteUnitsBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPriceQuoteUnitsScheme(), o.getPriceQuoteUnitsScheme(), this::setPriceQuoteUnitsScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceQuoteUnits _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(priceQuoteUnitsScheme, _that.getPriceQuoteUnitsScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (priceQuoteUnitsScheme != null ? priceQuoteUnitsScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceQuoteUnitsBuilder {" +
				"value=" + this.value + ", " +
				"priceQuoteUnitsScheme=" + this.priceQuoteUnitsScheme +
			'}';
		}
	}
}
