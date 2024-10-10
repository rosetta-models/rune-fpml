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
import fpml.confirmation.VerificationMethod;
import fpml.confirmation.VerificationMethod.VerificationMethodBuilder;
import fpml.confirmation.VerificationMethod.VerificationMethodBuilderImpl;
import fpml.confirmation.VerificationMethod.VerificationMethodImpl;
import fpml.confirmation.meta.VerificationMethodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type used to represent the type of mechanism that can be used to verify a trade.
 * @version ${project.version}
 */
@RosettaDataType(value="VerificationMethod", builder=VerificationMethod.VerificationMethodBuilderImpl.class, version="${project.version}")
public interface VerificationMethod extends RosettaModelObject {

	VerificationMethodMeta metaData = new VerificationMethodMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getVerificationMethodScheme();

	/*********************** Build Methods  ***********************/
	VerificationMethod build();
	
	VerificationMethod.VerificationMethodBuilder toBuilder();
	
	static VerificationMethod.VerificationMethodBuilder builder() {
		return new VerificationMethod.VerificationMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VerificationMethod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VerificationMethod> getType() {
		return VerificationMethod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("verificationMethodScheme"), String.class, getVerificationMethodScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface VerificationMethodBuilder extends VerificationMethod, RosettaModelObjectBuilder {
		VerificationMethod.VerificationMethodBuilder setValue(String value);
		VerificationMethod.VerificationMethodBuilder setVerificationMethodScheme(String verificationMethodScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("verificationMethodScheme"), String.class, getVerificationMethodScheme(), this);
		}
		

		VerificationMethod.VerificationMethodBuilder prune();
	}

	/*********************** Immutable Implementation of VerificationMethod  ***********************/
	class VerificationMethodImpl implements VerificationMethod {
		private final String value;
		private final String verificationMethodScheme;
		
		protected VerificationMethodImpl(VerificationMethod.VerificationMethodBuilder builder) {
			this.value = builder.getValue();
			this.verificationMethodScheme = builder.getVerificationMethodScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("verificationMethodScheme")
		public String getVerificationMethodScheme() {
			return verificationMethodScheme;
		}
		
		@Override
		public VerificationMethod build() {
			return this;
		}
		
		@Override
		public VerificationMethod.VerificationMethodBuilder toBuilder() {
			VerificationMethod.VerificationMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VerificationMethod.VerificationMethodBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getVerificationMethodScheme()).ifPresent(builder::setVerificationMethodScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VerificationMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(verificationMethodScheme, _that.getVerificationMethodScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (verificationMethodScheme != null ? verificationMethodScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VerificationMethod {" +
				"value=" + this.value + ", " +
				"verificationMethodScheme=" + this.verificationMethodScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of VerificationMethod  ***********************/
	class VerificationMethodBuilderImpl implements VerificationMethod.VerificationMethodBuilder {
	
		protected String value;
		protected String verificationMethodScheme;
	
		public VerificationMethodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("verificationMethodScheme")
		public String getVerificationMethodScheme() {
			return verificationMethodScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public VerificationMethod.VerificationMethodBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("verificationMethodScheme")
		public VerificationMethod.VerificationMethodBuilder setVerificationMethodScheme(String verificationMethodScheme) {
			this.verificationMethodScheme = verificationMethodScheme==null?null:verificationMethodScheme;
			return this;
		}
		
		@Override
		public VerificationMethod build() {
			return new VerificationMethod.VerificationMethodImpl(this);
		}
		
		@Override
		public VerificationMethod.VerificationMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VerificationMethod.VerificationMethodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getVerificationMethodScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VerificationMethod.VerificationMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			VerificationMethod.VerificationMethodBuilder o = (VerificationMethod.VerificationMethodBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getVerificationMethodScheme(), o.getVerificationMethodScheme(), this::setVerificationMethodScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VerificationMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(verificationMethodScheme, _that.getVerificationMethodScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (verificationMethodScheme != null ? verificationMethodScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VerificationMethodBuilder {" +
				"value=" + this.value + ", " +
				"verificationMethodScheme=" + this.verificationMethodScheme +
			'}';
		}
	}
}
