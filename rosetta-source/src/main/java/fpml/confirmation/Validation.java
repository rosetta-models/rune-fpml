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
import fpml.confirmation.Validation;
import fpml.confirmation.Validation.ValidationBuilder;
import fpml.confirmation.Validation.ValidationBuilderImpl;
import fpml.confirmation.Validation.ValidationImpl;
import fpml.confirmation.meta.ValidationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A reference identifying a rule within a validation scheme.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Validation", builder=Validation.ValidationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Validation extends RosettaModelObject {

	ValidationMeta metaData = new ValidationMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getValidationScheme();

	/*********************** Build Methods  ***********************/
	Validation build();
	
	Validation.ValidationBuilder toBuilder();
	
	static Validation.ValidationBuilder builder() {
		return new Validation.ValidationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Validation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Validation> getType() {
		return Validation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("validationScheme"), String.class, getValidationScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValidationBuilder extends Validation, RosettaModelObjectBuilder {
		Validation.ValidationBuilder setValue(String value);
		Validation.ValidationBuilder setValidationScheme(String validationScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("validationScheme"), String.class, getValidationScheme(), this);
		}
		

		Validation.ValidationBuilder prune();
	}

	/*********************** Immutable Implementation of Validation  ***********************/
	class ValidationImpl implements Validation {
		private final String value;
		private final String validationScheme;
		
		protected ValidationImpl(Validation.ValidationBuilder builder) {
			this.value = builder.getValue();
			this.validationScheme = builder.getValidationScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("validationScheme")
		public String getValidationScheme() {
			return validationScheme;
		}
		
		@Override
		public Validation build() {
			return this;
		}
		
		@Override
		public Validation.ValidationBuilder toBuilder() {
			Validation.ValidationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Validation.ValidationBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getValidationScheme()).ifPresent(builder::setValidationScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Validation _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(validationScheme, _that.getValidationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (validationScheme != null ? validationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Validation {" +
				"value=" + this.value + ", " +
				"validationScheme=" + this.validationScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of Validation  ***********************/
	class ValidationBuilderImpl implements Validation.ValidationBuilder {
	
		protected String value;
		protected String validationScheme;
	
		public ValidationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("validationScheme")
		public String getValidationScheme() {
			return validationScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public Validation.ValidationBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("validationScheme")
		public Validation.ValidationBuilder setValidationScheme(String validationScheme) {
			this.validationScheme = validationScheme==null?null:validationScheme;
			return this;
		}
		
		@Override
		public Validation build() {
			return new Validation.ValidationImpl(this);
		}
		
		@Override
		public Validation.ValidationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Validation.ValidationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getValidationScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Validation.ValidationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Validation.ValidationBuilder o = (Validation.ValidationBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getValidationScheme(), o.getValidationScheme(), this::setValidationScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Validation _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(validationScheme, _that.getValidationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (validationScheme != null ? validationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValidationBuilder {" +
				"value=" + this.value + ", " +
				"validationScheme=" + this.validationScheme +
			'}';
		}
	}
}
