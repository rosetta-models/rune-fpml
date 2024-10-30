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
import fpml.confirmation.ShortSale;
import fpml.confirmation.ShortSale.ShortSaleBuilder;
import fpml.confirmation.ShortSale.ShortSaleBuilderImpl;
import fpml.confirmation.ShortSale.ShortSaleImpl;
import fpml.confirmation.meta.ShortSaleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A short sale concluded by an investment firm on its own behalf or on behalf of a client, as described in Article 11.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ShortSale", builder=ShortSale.ShortSaleBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ShortSale extends RosettaModelObject {

	ShortSaleMeta metaData = new ShortSaleMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getShortSaleScheme();

	/*********************** Build Methods  ***********************/
	ShortSale build();
	
	ShortSale.ShortSaleBuilder toBuilder();
	
	static ShortSale.ShortSaleBuilder builder() {
		return new ShortSale.ShortSaleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ShortSale> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ShortSale> getType() {
		return ShortSale.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("shortSaleScheme"), String.class, getShortSaleScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ShortSaleBuilder extends ShortSale, RosettaModelObjectBuilder {
		ShortSale.ShortSaleBuilder setValue(String value);
		ShortSale.ShortSaleBuilder setShortSaleScheme(String shortSaleScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("shortSaleScheme"), String.class, getShortSaleScheme(), this);
		}
		

		ShortSale.ShortSaleBuilder prune();
	}

	/*********************** Immutable Implementation of ShortSale  ***********************/
	class ShortSaleImpl implements ShortSale {
		private final String value;
		private final String shortSaleScheme;
		
		protected ShortSaleImpl(ShortSale.ShortSaleBuilder builder) {
			this.value = builder.getValue();
			this.shortSaleScheme = builder.getShortSaleScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("shortSaleScheme")
		public String getShortSaleScheme() {
			return shortSaleScheme;
		}
		
		@Override
		public ShortSale build() {
			return this;
		}
		
		@Override
		public ShortSale.ShortSaleBuilder toBuilder() {
			ShortSale.ShortSaleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ShortSale.ShortSaleBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getShortSaleScheme()).ifPresent(builder::setShortSaleScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ShortSale _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(shortSaleScheme, _that.getShortSaleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (shortSaleScheme != null ? shortSaleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ShortSale {" +
				"value=" + this.value + ", " +
				"shortSaleScheme=" + this.shortSaleScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ShortSale  ***********************/
	class ShortSaleBuilderImpl implements ShortSale.ShortSaleBuilder {
	
		protected String value;
		protected String shortSaleScheme;
	
		public ShortSaleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("shortSaleScheme")
		public String getShortSaleScheme() {
			return shortSaleScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ShortSale.ShortSaleBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("shortSaleScheme")
		public ShortSale.ShortSaleBuilder setShortSaleScheme(String shortSaleScheme) {
			this.shortSaleScheme = shortSaleScheme==null?null:shortSaleScheme;
			return this;
		}
		
		@Override
		public ShortSale build() {
			return new ShortSale.ShortSaleImpl(this);
		}
		
		@Override
		public ShortSale.ShortSaleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ShortSale.ShortSaleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getShortSaleScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ShortSale.ShortSaleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ShortSale.ShortSaleBuilder o = (ShortSale.ShortSaleBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getShortSaleScheme(), o.getShortSaleScheme(), this::setShortSaleScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ShortSale _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(shortSaleScheme, _that.getShortSaleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (shortSaleScheme != null ? shortSaleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ShortSaleBuilder {" +
				"value=" + this.value + ", " +
				"shortSaleScheme=" + this.shortSaleScheme +
			'}';
		}
	}
}
