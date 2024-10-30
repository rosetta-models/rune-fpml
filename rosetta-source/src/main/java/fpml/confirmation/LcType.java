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
import fpml.confirmation.LcType;
import fpml.confirmation.LcType.LcTypeBuilder;
import fpml.confirmation.LcType.LcTypeBuilderImpl;
import fpml.confirmation.LcType.LcTypeImpl;
import fpml.confirmation.meta.LcTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A list of L/C types.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LcType", builder=LcType.LcTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LcType extends RosettaModelObject {

	LcTypeMeta metaData = new LcTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getLcTypeScheme();

	/*********************** Build Methods  ***********************/
	LcType build();
	
	LcType.LcTypeBuilder toBuilder();
	
	static LcType.LcTypeBuilder builder() {
		return new LcType.LcTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LcType> getType() {
		return LcType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("lcTypeScheme"), String.class, getLcTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcTypeBuilder extends LcType, RosettaModelObjectBuilder {
		LcType.LcTypeBuilder setValue(String value);
		LcType.LcTypeBuilder setLcTypeScheme(String lcTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("lcTypeScheme"), String.class, getLcTypeScheme(), this);
		}
		

		LcType.LcTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LcType  ***********************/
	class LcTypeImpl implements LcType {
		private final String value;
		private final String lcTypeScheme;
		
		protected LcTypeImpl(LcType.LcTypeBuilder builder) {
			this.value = builder.getValue();
			this.lcTypeScheme = builder.getLcTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("lcTypeScheme")
		public String getLcTypeScheme() {
			return lcTypeScheme;
		}
		
		@Override
		public LcType build() {
			return this;
		}
		
		@Override
		public LcType.LcTypeBuilder toBuilder() {
			LcType.LcTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcType.LcTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLcTypeScheme()).ifPresent(builder::setLcTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LcType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(lcTypeScheme, _that.getLcTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (lcTypeScheme != null ? lcTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcType {" +
				"value=" + this.value + ", " +
				"lcTypeScheme=" + this.lcTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LcType  ***********************/
	class LcTypeBuilderImpl implements LcType.LcTypeBuilder {
	
		protected String value;
		protected String lcTypeScheme;
	
		public LcTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("lcTypeScheme")
		public String getLcTypeScheme() {
			return lcTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public LcType.LcTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("lcTypeScheme")
		public LcType.LcTypeBuilder setLcTypeScheme(String lcTypeScheme) {
			this.lcTypeScheme = lcTypeScheme==null?null:lcTypeScheme;
			return this;
		}
		
		@Override
		public LcType build() {
			return new LcType.LcTypeImpl(this);
		}
		
		@Override
		public LcType.LcTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcType.LcTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLcTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcType.LcTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LcType.LcTypeBuilder o = (LcType.LcTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLcTypeScheme(), o.getLcTypeScheme(), this::setLcTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LcType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(lcTypeScheme, _that.getLcTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (lcTypeScheme != null ? lcTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcTypeBuilder {" +
				"value=" + this.value + ", " +
				"lcTypeScheme=" + this.lcTypeScheme +
			'}';
		}
	}
}
