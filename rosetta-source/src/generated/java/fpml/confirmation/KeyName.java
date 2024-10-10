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
import fpml.confirmation.KeyName;
import fpml.confirmation.KeyName.KeyNameBuilder;
import fpml.confirmation.KeyName.KeyNameBuilderImpl;
import fpml.confirmation.KeyName.KeyNameImpl;
import fpml.confirmation.meta.KeyNameMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="KeyName", builder=KeyName.KeyNameBuilderImpl.class, version="${project.version}")
public interface KeyName extends RosettaModelObject {

	KeyNameMeta metaData = new KeyNameMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();

	/*********************** Build Methods  ***********************/
	KeyName build();
	
	KeyName.KeyNameBuilder toBuilder();
	
	static KeyName.KeyNameBuilder builder() {
		return new KeyName.KeyNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends KeyName> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends KeyName> getType() {
		return KeyName.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface KeyNameBuilder extends KeyName, RosettaModelObjectBuilder {
		KeyName.KeyNameBuilder setValue(String value);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		}
		

		KeyName.KeyNameBuilder prune();
	}

	/*********************** Immutable Implementation of KeyName  ***********************/
	class KeyNameImpl implements KeyName {
		private final String value;
		
		protected KeyNameImpl(KeyName.KeyNameBuilder builder) {
			this.value = builder.getValue();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		public KeyName build() {
			return this;
		}
		
		@Override
		public KeyName.KeyNameBuilder toBuilder() {
			KeyName.KeyNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(KeyName.KeyNameBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			KeyName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "KeyName {" +
				"value=" + this.value +
			'}';
		}
	}

	/*********************** Builder Implementation of KeyName  ***********************/
	class KeyNameBuilderImpl implements KeyName.KeyNameBuilder {
	
		protected String value;
	
		public KeyNameBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("value")
		public KeyName.KeyNameBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public KeyName build() {
			return new KeyName.KeyNameImpl(this);
		}
		
		@Override
		public KeyName.KeyNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KeyName.KeyNameBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KeyName.KeyNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			KeyName.KeyNameBuilder o = (KeyName.KeyNameBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			KeyName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "KeyNameBuilder {" +
				"value=" + this.value +
			'}';
		}
	}
}
