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
import fpml.confirmation.CompressionType;
import fpml.confirmation.CompressionType.CompressionTypeBuilder;
import fpml.confirmation.CompressionType.CompressionTypeBuilderImpl;
import fpml.confirmation.CompressionType.CompressionTypeImpl;
import fpml.confirmation.meta.CompressionTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that identifies the type of trade amalgamation, for example netting or portfolio compression.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CompressionType", builder=CompressionType.CompressionTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CompressionType extends RosettaModelObject {

	CompressionTypeMeta metaData = new CompressionTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCompressionTypeScheme();

	/*********************** Build Methods  ***********************/
	CompressionType build();
	
	CompressionType.CompressionTypeBuilder toBuilder();
	
	static CompressionType.CompressionTypeBuilder builder() {
		return new CompressionType.CompressionTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CompressionType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CompressionType> getType() {
		return CompressionType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("compressionTypeScheme"), String.class, getCompressionTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CompressionTypeBuilder extends CompressionType, RosettaModelObjectBuilder {
		CompressionType.CompressionTypeBuilder setValue(String value);
		CompressionType.CompressionTypeBuilder setCompressionTypeScheme(String compressionTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("compressionTypeScheme"), String.class, getCompressionTypeScheme(), this);
		}
		

		CompressionType.CompressionTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CompressionType  ***********************/
	class CompressionTypeImpl implements CompressionType {
		private final String value;
		private final String compressionTypeScheme;
		
		protected CompressionTypeImpl(CompressionType.CompressionTypeBuilder builder) {
			this.value = builder.getValue();
			this.compressionTypeScheme = builder.getCompressionTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("compressionTypeScheme")
		public String getCompressionTypeScheme() {
			return compressionTypeScheme;
		}
		
		@Override
		public CompressionType build() {
			return this;
		}
		
		@Override
		public CompressionType.CompressionTypeBuilder toBuilder() {
			CompressionType.CompressionTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CompressionType.CompressionTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCompressionTypeScheme()).ifPresent(builder::setCompressionTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompressionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(compressionTypeScheme, _that.getCompressionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (compressionTypeScheme != null ? compressionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompressionType {" +
				"value=" + this.value + ", " +
				"compressionTypeScheme=" + this.compressionTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CompressionType  ***********************/
	class CompressionTypeBuilderImpl implements CompressionType.CompressionTypeBuilder {
	
		protected String value;
		protected String compressionTypeScheme;
	
		public CompressionTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("compressionTypeScheme")
		public String getCompressionTypeScheme() {
			return compressionTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CompressionType.CompressionTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("compressionTypeScheme")
		public CompressionType.CompressionTypeBuilder setCompressionTypeScheme(String compressionTypeScheme) {
			this.compressionTypeScheme = compressionTypeScheme==null?null:compressionTypeScheme;
			return this;
		}
		
		@Override
		public CompressionType build() {
			return new CompressionType.CompressionTypeImpl(this);
		}
		
		@Override
		public CompressionType.CompressionTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompressionType.CompressionTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCompressionTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompressionType.CompressionTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CompressionType.CompressionTypeBuilder o = (CompressionType.CompressionTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCompressionTypeScheme(), o.getCompressionTypeScheme(), this::setCompressionTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompressionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(compressionTypeScheme, _that.getCompressionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (compressionTypeScheme != null ? compressionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompressionTypeBuilder {" +
				"value=" + this.value + ", " +
				"compressionTypeScheme=" + this.compressionTypeScheme +
			'}';
		}
	}
}
