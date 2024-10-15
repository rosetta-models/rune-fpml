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
import fpml.confirmation.SignatureMethod;
import fpml.confirmation.SignatureMethod.SignatureMethodBuilder;
import fpml.confirmation.SignatureMethod.SignatureMethodBuilderImpl;
import fpml.confirmation.SignatureMethod.SignatureMethodImpl;
import fpml.confirmation.SignatureMethodType;
import fpml.confirmation.SignatureMethodType.SignatureMethodTypeBuilder;
import fpml.confirmation.SignatureMethodType.SignatureMethodTypeBuilderImpl;
import fpml.confirmation.SignatureMethodType.SignatureMethodTypeImpl;
import fpml.confirmation.meta.SignatureMethodMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="SignatureMethod", builder=SignatureMethod.SignatureMethodBuilderImpl.class, version="${project.version}")
public interface SignatureMethod extends SignatureMethodType {

	SignatureMethodMeta metaData = new SignatureMethodMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	SignatureMethod build();
	
	SignatureMethod.SignatureMethodBuilder toBuilder();
	
	static SignatureMethod.SignatureMethodBuilder builder() {
		return new SignatureMethod.SignatureMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignatureMethod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SignatureMethod> getType() {
		return SignatureMethod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("hmacOutputLength"), Integer.class, getHmacOutputLength(), this);
		processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignatureMethodBuilder extends SignatureMethod, SignatureMethodType.SignatureMethodTypeBuilder {
		SignatureMethod.SignatureMethodBuilder setHmacOutputLength(Integer hmacOutputLength);
		SignatureMethod.SignatureMethodBuilder setAlgorithm(String algorithm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("hmacOutputLength"), Integer.class, getHmacOutputLength(), this);
			processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
		}
		

		SignatureMethod.SignatureMethodBuilder prune();
	}

	/*********************** Immutable Implementation of SignatureMethod  ***********************/
	class SignatureMethodImpl extends SignatureMethodType.SignatureMethodTypeImpl implements SignatureMethod {
		
		protected SignatureMethodImpl(SignatureMethod.SignatureMethodBuilder builder) {
			super(builder);
		}
		
		@Override
		public SignatureMethod build() {
			return this;
		}
		
		@Override
		public SignatureMethod.SignatureMethodBuilder toBuilder() {
			SignatureMethod.SignatureMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignatureMethod.SignatureMethodBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignatureMethod {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SignatureMethod  ***********************/
	class SignatureMethodBuilderImpl extends SignatureMethodType.SignatureMethodTypeBuilderImpl  implements SignatureMethod.SignatureMethodBuilder {
	
	
		public SignatureMethodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("hmacOutputLength")
		public SignatureMethod.SignatureMethodBuilder setHmacOutputLength(Integer hmacOutputLength) {
			this.hmacOutputLength = hmacOutputLength==null?null:hmacOutputLength;
			return this;
		}
		@Override
		@RosettaAttribute("algorithm")
		public SignatureMethod.SignatureMethodBuilder setAlgorithm(String algorithm) {
			this.algorithm = algorithm==null?null:algorithm;
			return this;
		}
		
		@Override
		public SignatureMethod build() {
			return new SignatureMethod.SignatureMethodImpl(this);
		}
		
		@Override
		public SignatureMethod.SignatureMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureMethod.SignatureMethodBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureMethod.SignatureMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SignatureMethod.SignatureMethodBuilder o = (SignatureMethod.SignatureMethodBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignatureMethodBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
