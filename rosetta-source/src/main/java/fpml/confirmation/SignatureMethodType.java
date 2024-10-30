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
import fpml.confirmation.SignatureMethodType;
import fpml.confirmation.SignatureMethodType.SignatureMethodTypeBuilder;
import fpml.confirmation.SignatureMethodType.SignatureMethodTypeBuilderImpl;
import fpml.confirmation.SignatureMethodType.SignatureMethodTypeImpl;
import fpml.confirmation.meta.SignatureMethodTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="SignatureMethodType", builder=SignatureMethodType.SignatureMethodTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface SignatureMethodType extends RosettaModelObject {

	SignatureMethodTypeMeta metaData = new SignatureMethodTypeMeta();

	/*********************** Getter Methods  ***********************/
	Integer getHmacOutputLength();
	String getAlgorithm();

	/*********************** Build Methods  ***********************/
	SignatureMethodType build();
	
	SignatureMethodType.SignatureMethodTypeBuilder toBuilder();
	
	static SignatureMethodType.SignatureMethodTypeBuilder builder() {
		return new SignatureMethodType.SignatureMethodTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignatureMethodType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SignatureMethodType> getType() {
		return SignatureMethodType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("hmacOutputLength"), Integer.class, getHmacOutputLength(), this);
		processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignatureMethodTypeBuilder extends SignatureMethodType, RosettaModelObjectBuilder {
		SignatureMethodType.SignatureMethodTypeBuilder setHmacOutputLength(Integer hmacOutputLength);
		SignatureMethodType.SignatureMethodTypeBuilder setAlgorithm(String algorithm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("hmacOutputLength"), Integer.class, getHmacOutputLength(), this);
			processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
		}
		

		SignatureMethodType.SignatureMethodTypeBuilder prune();
	}

	/*********************** Immutable Implementation of SignatureMethodType  ***********************/
	class SignatureMethodTypeImpl implements SignatureMethodType {
		private final Integer hmacOutputLength;
		private final String algorithm;
		
		protected SignatureMethodTypeImpl(SignatureMethodType.SignatureMethodTypeBuilder builder) {
			this.hmacOutputLength = builder.getHmacOutputLength();
			this.algorithm = builder.getAlgorithm();
		}
		
		@Override
		@RosettaAttribute("hmacOutputLength")
		public Integer getHmacOutputLength() {
			return hmacOutputLength;
		}
		
		@Override
		@RosettaAttribute("algorithm")
		public String getAlgorithm() {
			return algorithm;
		}
		
		@Override
		public SignatureMethodType build() {
			return this;
		}
		
		@Override
		public SignatureMethodType.SignatureMethodTypeBuilder toBuilder() {
			SignatureMethodType.SignatureMethodTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignatureMethodType.SignatureMethodTypeBuilder builder) {
			ofNullable(getHmacOutputLength()).ifPresent(builder::setHmacOutputLength);
			ofNullable(getAlgorithm()).ifPresent(builder::setAlgorithm);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignatureMethodType _that = getType().cast(o);
		
			if (!Objects.equals(hmacOutputLength, _that.getHmacOutputLength())) return false;
			if (!Objects.equals(algorithm, _that.getAlgorithm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (hmacOutputLength != null ? hmacOutputLength.hashCode() : 0);
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignatureMethodType {" +
				"hmacOutputLength=" + this.hmacOutputLength + ", " +
				"algorithm=" + this.algorithm +
			'}';
		}
	}

	/*********************** Builder Implementation of SignatureMethodType  ***********************/
	class SignatureMethodTypeBuilderImpl implements SignatureMethodType.SignatureMethodTypeBuilder {
	
		protected Integer hmacOutputLength;
		protected String algorithm;
	
		public SignatureMethodTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("hmacOutputLength")
		public Integer getHmacOutputLength() {
			return hmacOutputLength;
		}
		
		@Override
		@RosettaAttribute("algorithm")
		public String getAlgorithm() {
			return algorithm;
		}
		
		@Override
		@RosettaAttribute("hmacOutputLength")
		public SignatureMethodType.SignatureMethodTypeBuilder setHmacOutputLength(Integer hmacOutputLength) {
			this.hmacOutputLength = hmacOutputLength==null?null:hmacOutputLength;
			return this;
		}
		@Override
		@RosettaAttribute("algorithm")
		public SignatureMethodType.SignatureMethodTypeBuilder setAlgorithm(String algorithm) {
			this.algorithm = algorithm==null?null:algorithm;
			return this;
		}
		
		@Override
		public SignatureMethodType build() {
			return new SignatureMethodType.SignatureMethodTypeImpl(this);
		}
		
		@Override
		public SignatureMethodType.SignatureMethodTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureMethodType.SignatureMethodTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getHmacOutputLength()!=null) return true;
			if (getAlgorithm()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureMethodType.SignatureMethodTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SignatureMethodType.SignatureMethodTypeBuilder o = (SignatureMethodType.SignatureMethodTypeBuilder) other;
			
			
			merger.mergeBasic(getHmacOutputLength(), o.getHmacOutputLength(), this::setHmacOutputLength);
			merger.mergeBasic(getAlgorithm(), o.getAlgorithm(), this::setAlgorithm);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignatureMethodType _that = getType().cast(o);
		
			if (!Objects.equals(hmacOutputLength, _that.getHmacOutputLength())) return false;
			if (!Objects.equals(algorithm, _that.getAlgorithm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (hmacOutputLength != null ? hmacOutputLength.hashCode() : 0);
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignatureMethodTypeBuilder {" +
				"hmacOutputLength=" + this.hmacOutputLength + ", " +
				"algorithm=" + this.algorithm +
			'}';
		}
	}
}
