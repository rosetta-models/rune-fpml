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
import fpml.confirmation.ConfirmationMethod;
import fpml.confirmation.ConfirmationMethod.ConfirmationMethodBuilder;
import fpml.confirmation.ConfirmationMethod.ConfirmationMethodBuilderImpl;
import fpml.confirmation.ConfirmationMethod.ConfirmationMethodImpl;
import fpml.confirmation.meta.ConfirmationMethodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type used to represent the type of mechanism that can be used to confirm a trade.
 * @version ${project.version}
 */
@RosettaDataType(value="ConfirmationMethod", builder=ConfirmationMethod.ConfirmationMethodBuilderImpl.class, version="${project.version}")
public interface ConfirmationMethod extends RosettaModelObject {

	ConfirmationMethodMeta metaData = new ConfirmationMethodMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getConfirmationMethodScheme();

	/*********************** Build Methods  ***********************/
	ConfirmationMethod build();
	
	ConfirmationMethod.ConfirmationMethodBuilder toBuilder();
	
	static ConfirmationMethod.ConfirmationMethodBuilder builder() {
		return new ConfirmationMethod.ConfirmationMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ConfirmationMethod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ConfirmationMethod> getType() {
		return ConfirmationMethod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("confirmationMethodScheme"), String.class, getConfirmationMethodScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ConfirmationMethodBuilder extends ConfirmationMethod, RosettaModelObjectBuilder {
		ConfirmationMethod.ConfirmationMethodBuilder setValue(String value);
		ConfirmationMethod.ConfirmationMethodBuilder setConfirmationMethodScheme(String confirmationMethodScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("confirmationMethodScheme"), String.class, getConfirmationMethodScheme(), this);
		}
		

		ConfirmationMethod.ConfirmationMethodBuilder prune();
	}

	/*********************** Immutable Implementation of ConfirmationMethod  ***********************/
	class ConfirmationMethodImpl implements ConfirmationMethod {
		private final String value;
		private final String confirmationMethodScheme;
		
		protected ConfirmationMethodImpl(ConfirmationMethod.ConfirmationMethodBuilder builder) {
			this.value = builder.getValue();
			this.confirmationMethodScheme = builder.getConfirmationMethodScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("confirmationMethodScheme")
		public String getConfirmationMethodScheme() {
			return confirmationMethodScheme;
		}
		
		@Override
		public ConfirmationMethod build() {
			return this;
		}
		
		@Override
		public ConfirmationMethod.ConfirmationMethodBuilder toBuilder() {
			ConfirmationMethod.ConfirmationMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConfirmationMethod.ConfirmationMethodBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getConfirmationMethodScheme()).ifPresent(builder::setConfirmationMethodScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConfirmationMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(confirmationMethodScheme, _that.getConfirmationMethodScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (confirmationMethodScheme != null ? confirmationMethodScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConfirmationMethod {" +
				"value=" + this.value + ", " +
				"confirmationMethodScheme=" + this.confirmationMethodScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ConfirmationMethod  ***********************/
	class ConfirmationMethodBuilderImpl implements ConfirmationMethod.ConfirmationMethodBuilder {
	
		protected String value;
		protected String confirmationMethodScheme;
	
		public ConfirmationMethodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("confirmationMethodScheme")
		public String getConfirmationMethodScheme() {
			return confirmationMethodScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ConfirmationMethod.ConfirmationMethodBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("confirmationMethodScheme")
		public ConfirmationMethod.ConfirmationMethodBuilder setConfirmationMethodScheme(String confirmationMethodScheme) {
			this.confirmationMethodScheme = confirmationMethodScheme==null?null:confirmationMethodScheme;
			return this;
		}
		
		@Override
		public ConfirmationMethod build() {
			return new ConfirmationMethod.ConfirmationMethodImpl(this);
		}
		
		@Override
		public ConfirmationMethod.ConfirmationMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConfirmationMethod.ConfirmationMethodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getConfirmationMethodScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConfirmationMethod.ConfirmationMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ConfirmationMethod.ConfirmationMethodBuilder o = (ConfirmationMethod.ConfirmationMethodBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getConfirmationMethodScheme(), o.getConfirmationMethodScheme(), this::setConfirmationMethodScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConfirmationMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(confirmationMethodScheme, _that.getConfirmationMethodScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (confirmationMethodScheme != null ? confirmationMethodScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConfirmationMethodBuilder {" +
				"value=" + this.value + ", " +
				"confirmationMethodScheme=" + this.confirmationMethodScheme +
			'}';
		}
	}
}
