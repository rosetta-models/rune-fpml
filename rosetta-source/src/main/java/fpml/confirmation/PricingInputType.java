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
import fpml.confirmation.PricingInputType;
import fpml.confirmation.PricingInputType.PricingInputTypeBuilder;
import fpml.confirmation.PricingInputType.PricingInputTypeBuilderImpl;
import fpml.confirmation.PricingInputType.PricingInputTypeImpl;
import fpml.confirmation.meta.PricingInputTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PricingInputType", builder=PricingInputType.PricingInputTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PricingInputType extends RosettaModelObject {

	PricingInputTypeMeta metaData = new PricingInputTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getPricingInputTypeScheme();

	/*********************** Build Methods  ***********************/
	PricingInputType build();
	
	PricingInputType.PricingInputTypeBuilder toBuilder();
	
	static PricingInputType.PricingInputTypeBuilder builder() {
		return new PricingInputType.PricingInputTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingInputType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PricingInputType> getType() {
		return PricingInputType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("pricingInputTypeScheme"), String.class, getPricingInputTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingInputTypeBuilder extends PricingInputType, RosettaModelObjectBuilder {
		PricingInputType.PricingInputTypeBuilder setValue(String value);
		PricingInputType.PricingInputTypeBuilder setPricingInputTypeScheme(String pricingInputTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("pricingInputTypeScheme"), String.class, getPricingInputTypeScheme(), this);
		}
		

		PricingInputType.PricingInputTypeBuilder prune();
	}

	/*********************** Immutable Implementation of PricingInputType  ***********************/
	class PricingInputTypeImpl implements PricingInputType {
		private final String value;
		private final String pricingInputTypeScheme;
		
		protected PricingInputTypeImpl(PricingInputType.PricingInputTypeBuilder builder) {
			this.value = builder.getValue();
			this.pricingInputTypeScheme = builder.getPricingInputTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("pricingInputTypeScheme")
		public String getPricingInputTypeScheme() {
			return pricingInputTypeScheme;
		}
		
		@Override
		public PricingInputType build() {
			return this;
		}
		
		@Override
		public PricingInputType.PricingInputTypeBuilder toBuilder() {
			PricingInputType.PricingInputTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingInputType.PricingInputTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPricingInputTypeScheme()).ifPresent(builder::setPricingInputTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingInputType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(pricingInputTypeScheme, _that.getPricingInputTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (pricingInputTypeScheme != null ? pricingInputTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingInputType {" +
				"value=" + this.value + ", " +
				"pricingInputTypeScheme=" + this.pricingInputTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingInputType  ***********************/
	class PricingInputTypeBuilderImpl implements PricingInputType.PricingInputTypeBuilder {
	
		protected String value;
		protected String pricingInputTypeScheme;
	
		public PricingInputTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("pricingInputTypeScheme")
		public String getPricingInputTypeScheme() {
			return pricingInputTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public PricingInputType.PricingInputTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("pricingInputTypeScheme")
		public PricingInputType.PricingInputTypeBuilder setPricingInputTypeScheme(String pricingInputTypeScheme) {
			this.pricingInputTypeScheme = pricingInputTypeScheme==null?null:pricingInputTypeScheme;
			return this;
		}
		
		@Override
		public PricingInputType build() {
			return new PricingInputType.PricingInputTypeImpl(this);
		}
		
		@Override
		public PricingInputType.PricingInputTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingInputType.PricingInputTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPricingInputTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingInputType.PricingInputTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingInputType.PricingInputTypeBuilder o = (PricingInputType.PricingInputTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPricingInputTypeScheme(), o.getPricingInputTypeScheme(), this::setPricingInputTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingInputType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(pricingInputTypeScheme, _that.getPricingInputTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (pricingInputTypeScheme != null ? pricingInputTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingInputTypeBuilder {" +
				"value=" + this.value + ", " +
				"pricingInputTypeScheme=" + this.pricingInputTypeScheme +
			'}';
		}
	}
}
