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
import fpml.confirmation.QuantityUnit;
import fpml.confirmation.QuantityUnit.QuantityUnitBuilder;
import fpml.confirmation.QuantityUnit.QuantityUnitBuilderImpl;
import fpml.confirmation.QuantityUnit.QuantityUnitImpl;
import fpml.confirmation.meta.QuantityUnitMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="QuantityUnit", builder=QuantityUnit.QuantityUnitBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface QuantityUnit extends RosettaModelObject {

	QuantityUnitMeta metaData = new QuantityUnitMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getQuantityUnitScheme();

	/*********************** Build Methods  ***********************/
	QuantityUnit build();
	
	QuantityUnit.QuantityUnitBuilder toBuilder();
	
	static QuantityUnit.QuantityUnitBuilder builder() {
		return new QuantityUnit.QuantityUnitBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QuantityUnit> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends QuantityUnit> getType() {
		return QuantityUnit.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("quantityUnitScheme"), String.class, getQuantityUnitScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface QuantityUnitBuilder extends QuantityUnit, RosettaModelObjectBuilder {
		QuantityUnit.QuantityUnitBuilder setValue(String value);
		QuantityUnit.QuantityUnitBuilder setQuantityUnitScheme(String quantityUnitScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("quantityUnitScheme"), String.class, getQuantityUnitScheme(), this);
		}
		

		QuantityUnit.QuantityUnitBuilder prune();
	}

	/*********************** Immutable Implementation of QuantityUnit  ***********************/
	class QuantityUnitImpl implements QuantityUnit {
		private final String value;
		private final String quantityUnitScheme;
		
		protected QuantityUnitImpl(QuantityUnit.QuantityUnitBuilder builder) {
			this.value = builder.getValue();
			this.quantityUnitScheme = builder.getQuantityUnitScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("quantityUnitScheme")
		public String getQuantityUnitScheme() {
			return quantityUnitScheme;
		}
		
		@Override
		public QuantityUnit build() {
			return this;
		}
		
		@Override
		public QuantityUnit.QuantityUnitBuilder toBuilder() {
			QuantityUnit.QuantityUnitBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuantityUnit.QuantityUnitBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getQuantityUnitScheme()).ifPresent(builder::setQuantityUnitScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuantityUnit _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(quantityUnitScheme, _that.getQuantityUnitScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (quantityUnitScheme != null ? quantityUnitScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuantityUnit {" +
				"value=" + this.value + ", " +
				"quantityUnitScheme=" + this.quantityUnitScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of QuantityUnit  ***********************/
	class QuantityUnitBuilderImpl implements QuantityUnit.QuantityUnitBuilder {
	
		protected String value;
		protected String quantityUnitScheme;
	
		public QuantityUnitBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("quantityUnitScheme")
		public String getQuantityUnitScheme() {
			return quantityUnitScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public QuantityUnit.QuantityUnitBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("quantityUnitScheme")
		public QuantityUnit.QuantityUnitBuilder setQuantityUnitScheme(String quantityUnitScheme) {
			this.quantityUnitScheme = quantityUnitScheme==null?null:quantityUnitScheme;
			return this;
		}
		
		@Override
		public QuantityUnit build() {
			return new QuantityUnit.QuantityUnitImpl(this);
		}
		
		@Override
		public QuantityUnit.QuantityUnitBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantityUnit.QuantityUnitBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getQuantityUnitScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantityUnit.QuantityUnitBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QuantityUnit.QuantityUnitBuilder o = (QuantityUnit.QuantityUnitBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getQuantityUnitScheme(), o.getQuantityUnitScheme(), this::setQuantityUnitScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuantityUnit _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(quantityUnitScheme, _that.getQuantityUnitScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (quantityUnitScheme != null ? quantityUnitScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuantityUnitBuilder {" +
				"value=" + this.value + ", " +
				"quantityUnitScheme=" + this.quantityUnitScheme +
			'}';
		}
	}
}
