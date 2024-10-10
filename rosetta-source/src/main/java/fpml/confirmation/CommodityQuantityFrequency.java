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
import fpml.confirmation.CommodityQuantityFrequency;
import fpml.confirmation.CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder;
import fpml.confirmation.CommodityQuantityFrequency.CommodityQuantityFrequencyBuilderImpl;
import fpml.confirmation.CommodityQuantityFrequency.CommodityQuantityFrequencyImpl;
import fpml.confirmation.meta.CommodityQuantityFrequencyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining the frequency at which the Notional Quantity is deemed to apply for purposes of calculating the Total Notional Quantity.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityQuantityFrequency", builder=CommodityQuantityFrequency.CommodityQuantityFrequencyBuilderImpl.class, version="${project.version}")
public interface CommodityQuantityFrequency extends RosettaModelObject {

	CommodityQuantityFrequencyMeta metaData = new CommodityQuantityFrequencyMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getQuantityFrequencyScheme();

	/*********************** Build Methods  ***********************/
	CommodityQuantityFrequency build();
	
	CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder toBuilder();
	
	static CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder builder() {
		return new CommodityQuantityFrequency.CommodityQuantityFrequencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityQuantityFrequency> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityQuantityFrequency> getType() {
		return CommodityQuantityFrequency.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("quantityFrequencyScheme"), String.class, getQuantityFrequencyScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityQuantityFrequencyBuilder extends CommodityQuantityFrequency, RosettaModelObjectBuilder {
		CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder setValue(String value);
		CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder setQuantityFrequencyScheme(String quantityFrequencyScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("quantityFrequencyScheme"), String.class, getQuantityFrequencyScheme(), this);
		}
		

		CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityQuantityFrequency  ***********************/
	class CommodityQuantityFrequencyImpl implements CommodityQuantityFrequency {
		private final String value;
		private final String quantityFrequencyScheme;
		
		protected CommodityQuantityFrequencyImpl(CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder builder) {
			this.value = builder.getValue();
			this.quantityFrequencyScheme = builder.getQuantityFrequencyScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("quantityFrequencyScheme")
		public String getQuantityFrequencyScheme() {
			return quantityFrequencyScheme;
		}
		
		@Override
		public CommodityQuantityFrequency build() {
			return this;
		}
		
		@Override
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder toBuilder() {
			CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getQuantityFrequencyScheme()).ifPresent(builder::setQuantityFrequencyScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityQuantityFrequency _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(quantityFrequencyScheme, _that.getQuantityFrequencyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (quantityFrequencyScheme != null ? quantityFrequencyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityQuantityFrequency {" +
				"value=" + this.value + ", " +
				"quantityFrequencyScheme=" + this.quantityFrequencyScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityQuantityFrequency  ***********************/
	class CommodityQuantityFrequencyBuilderImpl implements CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder {
	
		protected String value;
		protected String quantityFrequencyScheme;
	
		public CommodityQuantityFrequencyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("quantityFrequencyScheme")
		public String getQuantityFrequencyScheme() {
			return quantityFrequencyScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("quantityFrequencyScheme")
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder setQuantityFrequencyScheme(String quantityFrequencyScheme) {
			this.quantityFrequencyScheme = quantityFrequencyScheme==null?null:quantityFrequencyScheme;
			return this;
		}
		
		@Override
		public CommodityQuantityFrequency build() {
			return new CommodityQuantityFrequency.CommodityQuantityFrequencyImpl(this);
		}
		
		@Override
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getQuantityFrequencyScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder o = (CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getQuantityFrequencyScheme(), o.getQuantityFrequencyScheme(), this::setQuantityFrequencyScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityQuantityFrequency _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(quantityFrequencyScheme, _that.getQuantityFrequencyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (quantityFrequencyScheme != null ? quantityFrequencyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityQuantityFrequencyBuilder {" +
				"value=" + this.value + ", " +
				"quantityFrequencyScheme=" + this.quantityFrequencyScheme +
			'}';
		}
	}
}
