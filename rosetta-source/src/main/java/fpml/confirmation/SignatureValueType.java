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
import fpml.confirmation.SignatureValueType;
import fpml.confirmation.SignatureValueType.SignatureValueTypeBuilder;
import fpml.confirmation.SignatureValueType.SignatureValueTypeBuilderImpl;
import fpml.confirmation.SignatureValueType.SignatureValueTypeImpl;
import fpml.confirmation.meta.SignatureValueTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SignatureValueType", builder=SignatureValueType.SignatureValueTypeBuilderImpl.class, version="${project.version}")
public interface SignatureValueType extends RosettaModelObject {

	SignatureValueTypeMeta metaData = new SignatureValueTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getId();

	/*********************** Build Methods  ***********************/
	SignatureValueType build();
	
	SignatureValueType.SignatureValueTypeBuilder toBuilder();
	
	static SignatureValueType.SignatureValueTypeBuilder builder() {
		return new SignatureValueType.SignatureValueTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignatureValueType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SignatureValueType> getType() {
		return SignatureValueType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignatureValueTypeBuilder extends SignatureValueType, RosettaModelObjectBuilder {
		SignatureValueType.SignatureValueTypeBuilder setValue(String value);
		SignatureValueType.SignatureValueTypeBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		SignatureValueType.SignatureValueTypeBuilder prune();
	}

	/*********************** Immutable Implementation of SignatureValueType  ***********************/
	class SignatureValueTypeImpl implements SignatureValueType {
		private final String value;
		private final String id;
		
		protected SignatureValueTypeImpl(SignatureValueType.SignatureValueTypeBuilder builder) {
			this.value = builder.getValue();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public SignatureValueType build() {
			return this;
		}
		
		@Override
		public SignatureValueType.SignatureValueTypeBuilder toBuilder() {
			SignatureValueType.SignatureValueTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignatureValueType.SignatureValueTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignatureValueType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignatureValueType {" +
				"value=" + this.value + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of SignatureValueType  ***********************/
	class SignatureValueTypeBuilderImpl implements SignatureValueType.SignatureValueTypeBuilder {
	
		protected String value;
		protected String id;
	
		public SignatureValueTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("value")
		public SignatureValueType.SignatureValueTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public SignatureValueType.SignatureValueTypeBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public SignatureValueType build() {
			return new SignatureValueType.SignatureValueTypeImpl(this);
		}
		
		@Override
		public SignatureValueType.SignatureValueTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureValueType.SignatureValueTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureValueType.SignatureValueTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SignatureValueType.SignatureValueTypeBuilder o = (SignatureValueType.SignatureValueTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignatureValueType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignatureValueTypeBuilder {" +
				"value=" + this.value + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
