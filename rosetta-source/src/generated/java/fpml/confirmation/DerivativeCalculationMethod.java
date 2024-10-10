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
import fpml.confirmation.DerivativeCalculationMethod;
import fpml.confirmation.DerivativeCalculationMethod.DerivativeCalculationMethodBuilder;
import fpml.confirmation.DerivativeCalculationMethod.DerivativeCalculationMethodBuilderImpl;
import fpml.confirmation.DerivativeCalculationMethod.DerivativeCalculationMethodImpl;
import fpml.confirmation.meta.DerivativeCalculationMethodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="DerivativeCalculationMethod", builder=DerivativeCalculationMethod.DerivativeCalculationMethodBuilderImpl.class, version="${project.version}")
public interface DerivativeCalculationMethod extends RosettaModelObject {

	DerivativeCalculationMethodMeta metaData = new DerivativeCalculationMethodMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getDerivativeCalculationMethodScheme();

	/*********************** Build Methods  ***********************/
	DerivativeCalculationMethod build();
	
	DerivativeCalculationMethod.DerivativeCalculationMethodBuilder toBuilder();
	
	static DerivativeCalculationMethod.DerivativeCalculationMethodBuilder builder() {
		return new DerivativeCalculationMethod.DerivativeCalculationMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DerivativeCalculationMethod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DerivativeCalculationMethod> getType() {
		return DerivativeCalculationMethod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("derivativeCalculationMethodScheme"), String.class, getDerivativeCalculationMethodScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DerivativeCalculationMethodBuilder extends DerivativeCalculationMethod, RosettaModelObjectBuilder {
		DerivativeCalculationMethod.DerivativeCalculationMethodBuilder setValue(String value);
		DerivativeCalculationMethod.DerivativeCalculationMethodBuilder setDerivativeCalculationMethodScheme(String derivativeCalculationMethodScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("derivativeCalculationMethodScheme"), String.class, getDerivativeCalculationMethodScheme(), this);
		}
		

		DerivativeCalculationMethod.DerivativeCalculationMethodBuilder prune();
	}

	/*********************** Immutable Implementation of DerivativeCalculationMethod  ***********************/
	class DerivativeCalculationMethodImpl implements DerivativeCalculationMethod {
		private final String value;
		private final String derivativeCalculationMethodScheme;
		
		protected DerivativeCalculationMethodImpl(DerivativeCalculationMethod.DerivativeCalculationMethodBuilder builder) {
			this.value = builder.getValue();
			this.derivativeCalculationMethodScheme = builder.getDerivativeCalculationMethodScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("derivativeCalculationMethodScheme")
		public String getDerivativeCalculationMethodScheme() {
			return derivativeCalculationMethodScheme;
		}
		
		@Override
		public DerivativeCalculationMethod build() {
			return this;
		}
		
		@Override
		public DerivativeCalculationMethod.DerivativeCalculationMethodBuilder toBuilder() {
			DerivativeCalculationMethod.DerivativeCalculationMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DerivativeCalculationMethod.DerivativeCalculationMethodBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getDerivativeCalculationMethodScheme()).ifPresent(builder::setDerivativeCalculationMethodScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeCalculationMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(derivativeCalculationMethodScheme, _that.getDerivativeCalculationMethodScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (derivativeCalculationMethodScheme != null ? derivativeCalculationMethodScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativeCalculationMethod {" +
				"value=" + this.value + ", " +
				"derivativeCalculationMethodScheme=" + this.derivativeCalculationMethodScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of DerivativeCalculationMethod  ***********************/
	class DerivativeCalculationMethodBuilderImpl implements DerivativeCalculationMethod.DerivativeCalculationMethodBuilder {
	
		protected String value;
		protected String derivativeCalculationMethodScheme;
	
		public DerivativeCalculationMethodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("derivativeCalculationMethodScheme")
		public String getDerivativeCalculationMethodScheme() {
			return derivativeCalculationMethodScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public DerivativeCalculationMethod.DerivativeCalculationMethodBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("derivativeCalculationMethodScheme")
		public DerivativeCalculationMethod.DerivativeCalculationMethodBuilder setDerivativeCalculationMethodScheme(String derivativeCalculationMethodScheme) {
			this.derivativeCalculationMethodScheme = derivativeCalculationMethodScheme==null?null:derivativeCalculationMethodScheme;
			return this;
		}
		
		@Override
		public DerivativeCalculationMethod build() {
			return new DerivativeCalculationMethod.DerivativeCalculationMethodImpl(this);
		}
		
		@Override
		public DerivativeCalculationMethod.DerivativeCalculationMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeCalculationMethod.DerivativeCalculationMethodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getDerivativeCalculationMethodScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeCalculationMethod.DerivativeCalculationMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DerivativeCalculationMethod.DerivativeCalculationMethodBuilder o = (DerivativeCalculationMethod.DerivativeCalculationMethodBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getDerivativeCalculationMethodScheme(), o.getDerivativeCalculationMethodScheme(), this::setDerivativeCalculationMethodScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeCalculationMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(derivativeCalculationMethodScheme, _that.getDerivativeCalculationMethodScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (derivativeCalculationMethodScheme != null ? derivativeCalculationMethodScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativeCalculationMethodBuilder {" +
				"value=" + this.value + ", " +
				"derivativeCalculationMethodScheme=" + this.derivativeCalculationMethodScheme +
			'}';
		}
	}
}
